/* class GUIExample
 * 
 * 
 * Implements a java.swing program to display a window with
 * search fields and a results text box.
 * 
 * The main() method will create and display the window.
 * 
 */

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

import java.awt.*;
import java.awt.event.*;

public class GUIExample extends JPanel implements ActionListener {

    // Control items
    private String[] distances = {"5 miles", "10 miles", "20 miles", "50 miles"};
    private String[] categories = {"All", "Restaurants", "Cafes"};
    
    private JLabel l_lat = new JLabel("Latitude");
    private JTextField lat = new JTextField(0);
    private JLabel l_lon = new JLabel("Longitude");
    private JTextField lon = new JTextField(0);
    
    private JLabel l_dist = new JLabel("Within");
    private JComboBox<String> dist = new JComboBox<String>(distances);
    private JLabel l_cat = new JLabel("Category");
    private JComboBox<String> cat = new JComboBox<String>(categories);
    
    private JButton search = new JButton("Search");
    private JButton clear = new JButton("Reset");

    // Text area to display result string
    private JTextArea results = new JTextArea();

    // Constructor;  creates window elements
    public GUIExample() {
        setLayout(new BorderLayout());
        
        // Control panel, which includes the fields for the search and the search button itself
        JPanel control = new JPanel();
        control.setLayout(new BoxLayout(control, BoxLayout.PAGE_AXIS));   // top-down layout
        
        // Search fields -- nice layout where labels and data fields are aligned vertically & horizontally
        JPanel fields = new JPanel();
        GroupLayout layout = new GroupLayout(fields);
        fields.setLayout(layout);
        
        // Turn on automatically adding gaps between components
        layout.setAutoCreateGaps(true);

        // Turn on automatically creating gaps between components that touch
        // the edge of the container and the container.
        layout.setAutoCreateContainerGaps(true);
        
        // Create a sequential group for the horizontal axis.
        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        // The sequential group in turn contains two parallel groups.
        // One parallel group contains the labels, the other the text fields.
        // Putting the labels in a parallel group along the horizontal axis
        // positions them at the same x location.
        //
        hGroup.addGroup(layout.createParallelGroup().addComponent(l_lat).addComponent(l_lon).addComponent(l_dist).addComponent(l_cat));
        hGroup.addGroup(layout.createParallelGroup().addComponent(lat).addComponent(lon).addComponent(dist).addComponent(cat));
        layout.setHorizontalGroup(hGroup);

        // Create a sequential group for the vertical axis.
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        // The sequential group contains two parallel groups that align
        // the contents along the baseline.
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(l_lat).addComponent(lat));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(l_lon).addComponent(lon));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(l_dist).addComponent(dist));
        vGroup.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(l_cat).addComponent(cat));
        layout.setVerticalGroup(vGroup);
        
        // Buttons
        JPanel buttons = new JPanel();//new FlowLayout());   // simple: layout buttons one after the other in the button section
        buttons.add(search);
        buttons.add(clear);
        
        // Now, add the search fields, and below that, the search button
        control.add(fields);
        control.add(buttons);
        
        // Add the controls to the top part of the window
        add(control, BorderLayout.NORTH);
        
        // Results box -- add that to the central/main part of the window, and make it wrap and scroll
        results.setLineWrap(true);
        results.setWrapStyleWord(true);
        results.setEditable(false);
        
        JScrollPane sp = new JScrollPane(results, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setPreferredSize(new Dimension(300, 150));
        sp.setMinimumSize(new Dimension(150, 100));
        add(sp);
        
        // add a callback for the search and reset buttons, so that when pressed, the actionPerformed method gets called
        search.setActionCommand("search");  // identifier for the button
        search.addActionListener(this);     // this class has the actionPerformed method
        
        clear.setActionCommand("clear");
        clear.addActionListener(this);
    }

    // event handler
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("search")) {
            double latitude, longitude;
            
            try {
                latitude = Double.parseDouble(lat.getText());
                longitude = Double.parseDouble(lon.getText());
            } catch (NumberFormatException ne) {
                JOptionPane.showMessageDialog(this, "Latitude and longitude must be numeric values", "Error", JOptionPane.ERROR_MESSAGE);
                results.setText("Error: invalid search criteria.");
                return;
            }
            
            String message = "You asked me to find results\n in the \"" + cat.getSelectedItem().toString()
                            + "\" category within " + dist.getSelectedItem().toString()
                            + " of the location (" + latitude + ", " + longitude + ").";
                            
            results.setText(message);
            
        
        } else if (e.getActionCommand().equals("clear")) {
            lat.setText("");
            lon.setText("");
            dist.setSelectedIndex(0);
            cat.setSelectedIndex(0);
            results.setText("Search fields reset.");
        }
    }
    
    
    /* main()
     * 
     * Starts the program.
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                JFrame frame = new JFrame("GUI Example");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
                frame.add(new GUIExample());
                
                frame.pack();
                frame.setVisible(true);
                frame.toFront();
            }
        });
    }
}

import java.util.ArrayList;


public class AllHours {
	
	
	
	//use of java.date  and simpleDateFormat...?
	
	ArrayList<ArrayList<Hours>> storeHours = new ArrayList<ArrayList<Hours>>(); //time Strings for each day of the week 
	
	
		
		
	
	
	//the restaurant hours has to store open hours for each day... 7 days a week...
	public AllHours(String[] data) {
		//take in the list of times of sunday to saturday.. 
		for (String s: data) { // for each line
			ArrayList<Hours> dayHours= new ArrayList<Hours>();
			if (s==null) {
				storeHours.add(dayHours);
			}
			else {
			String[] times = s.split("\\s+"); //split it on space
			//ArrayList<Hours> dayHours= new ArrayList<Hours>();
			for (String t: times) {  // "11:00-12:00"-> Hours  
				Hours r = new Hours(t);
				dayHours.add(r);
			}
			
			storeHours.add(dayHours);
			
			}
		
	}
	}
	
	/*public String getSundayHours(){
		return storeHours.get(0);
	}
	
	public String getMondayHours() {
		return storeHours.get(1);
	}
	
	public String getTuesdayHours() {
		return storeHours.get(2);
	}*/
}
	
	//more get methods for each day 
	
	


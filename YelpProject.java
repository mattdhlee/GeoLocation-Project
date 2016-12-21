/// main function 

//import java.io.InputStream;
//import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.DataInputStream;
import java.io.File;
import java.util.Arrays;

//import AllHours.Hours;

public class YelpProject {
	
	
	
	private static int n = 18; //number of lines in one restaurant data.

	
	public static void main(String[] args) {
		YelpProject test= new YelpProject();
		test.run(); // run -> reads the file and prepares all the 
		}
	
	
		public YelpProject() { //constructor doesnt really HAVE to do anything 
			
		}
	
		public String[] splitData(String data) {// takes one restaurant data and splits by line accordingly
			String[] splitString = new String[n];
			splitString = data.split("\\n");  
			if (splitString.length != (n-1)) {
				
			}
			return splitString; 
		}
		
		public Location splitToLoc(String line0) { //returns Location by splitting then parsing the first line of the restaurant data.
			String[] loc = line0.split(" ");
			//Double[] location = new Double[2];
			Location location = new Location(Double.parseDouble(loc[0]),Double.parseDouble(loc[1]));
			return location;
		}
		
		public Address fullAddress(String[] s) {//index 2-5 
			Address address = new Address(s[2],s[3],s[4],s[5]);
			return address;
		}
		//look into join method 
		public String toPhoneNumber(String s) {   //splits the phone number string with multiple delimiters 0< returns one string of all numbers concatenated w/out spaces etx. 
			String[] temp = s.split("\\s+|\\(|\\)|\\-");
			String phoneNumber= "";
			for(String a: temp) {
				phoneNumber+= a;
			}
			return phoneNumber;
		}
		
		public ArrayList<String> getTypes(String s) {
			String[] temp = s.split(" ");
			ArrayList<String> f = new ArrayList<String>();
			for (String e: temp) {
				f.add(e);
			}
			return f;
		}
			
		
	//	public String typeToStringCode(String restuarantType) {
		//	
			
	//	}
		
		public ArrayList<Establishment> locationFilter(ArrayList<Establishment> allRestaurants, Location userLoc, int userBoundary) {//takes in all restaurant data, full zip data, and the user zip input to filter outofbounds restaurants
			
			ArrayList<Establishment> locFiltered;
			//get the location coordinates of the user 
			//System.out.println(allRestaurants.get(2).mName);
					
			//calculate the userLocation 
			int first = 0;
			int last = allRestaurants.size()-1;
			int middle = (allRestaurants.size())/2;
			//System.out.println(middle);
			
			//System.out.println("LOL");
			//calculate the distance from userLoc with restaurantLoc
			//!(userLoc.equals(allRestaurants.get(middle).mLocation))
			while (!(userLoc.equals(allRestaurants.get(middle).mLocation))) { //gets the middle location from restaurants
				Location resLoc = allRestaurants.get(middle).mLocation; 
				//System.out.println(resLoc.mLat);
				Double d = distanceCalculate(resLoc, userLoc);  //the distance between one restaurant and user
				//System.out.println(d);
				//System.out.println(d);
				if (d > userBoundary) { // if the distance out of the userBoundary...
					System.out.println("entered1");
					first = middle+1;
					middle = (last+first)/2; 
					System.out.println(middle);
					
				}
				else if(d < userBoundary) {// if the distance is within the userBoundary 
					System.out.println("entered2");
					//System.out.println("d");
					last = middle-1;
					//middle = middle/2;
					middle = (first+middle)/2;
				}
				else{
					System.out.println("same");
				}
			//middle to user should equal the user boundary 
			
			
				
			}
			locFiltered= new ArrayList<Establishment>(allRestaurants.subList(first,middle+1));
			
			//compare the two points and add if it is within the distance distance input 
			return locFiltered;
		}
		
		
		public Location zipToLoc(String zip, ArrayList<ZipCode> zipCodes) {
			Location userLoc;
			int userZip = Integer.parseInt(zip); 
			int middle = zipCodes.size()/2;
			int first = 0;
			int last= zipCodes.size()-1;
			//System.out.print(zipCodes.get(middle).zip);
			while(userZip != zipCodes.get(middle).zip) { //binary search while the zip does not equal userZip
				if (userZip > zipCodes.get(middle).zip) { //if userZip is bigger than middle zip, search secondhalf 
					first = middle+1;
					middle = (first+last)/2;
				}
				else if(userZip < zipCodes.get(middle).zip) {
					last = middle - 1;
					middle = (first+last)/2;
				}
				else{
					return null;
				}
			}
			userLoc = new Location(zipCodes.get(middle).mLat,zipCodes.get(middle).mLong);
			return userLoc;	
		}
				
		
		
		
		
		public boolean openAt(int time, Hours resHours){
			// returns true if the restaurant is open at the given time.
			// determined through a series of logical checks using 24-hour time
			int open = resHours.getOpenTime();
			int close = resHours.getCloseTime();
			if (time >= open){
				if (time <= close){
					return true;
				}
				if (close < 1200){
					if (time <= close + 2400){
						return true;
					}
				}
			}
			if (time <= close){
				if (open > close){
					return true;
				}
			}
			return false;
		}
		
		public boolean typeFilter(ArrayList<String> userTypes, ArrayList<String> resTypes) { //takes in arraylist of types (user) and one restaurant type data
			for(int i=0; i<userTypes.size();i++) {
				String userT = userTypes.get(i);
				for (int j=0; j<resTypes.size();j++) {
					if (userT.equals(resTypes.get(j))) {
						return true;
					}	
				}
			}
			return false;
		}
		
		
		//public boolean nameFilter(String userName, String 
		
		
		public double deg2rad(double deg) {
			return (deg * Math.PI / 180.0);
		}
		public double rad2deg(double rad) {
			return (rad * 180 / Math.PI);
		}
		
		
		
		public double distanceCalculate(Location resLocation, Location userLocation){ // returns the distance from user loc to restuarant loc 
			///double t = resLocation.getLat() - userLocation.getLat();
			double t = resLocation.getLong() - userLocation.getLong();
			double lat1 = resLocation.mLat;
			double lat2 = userLocation.mLat;
			double d = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(t));
			//double a = Math.pow(Math.sin(x/2), 2) + Math.cos(userLocation.getLat()) * Math.cos(resLocation.getLat()) * Math.pow(Math.sin(y/2), 2);
			//double b = 2 * Math.asin(Math.min(1, Math.sqrt(a)));
			d = Math.acos(d); // 3959 correlates to the radius of the Earth (miles)
			d= rad2deg(d);
			d = d * 60 * 1.1515;
			return d;
			
		}
		
		
		
		
		
		
		
		
		
		
		public ArrayList<ZipCode> readZipCodeFile() { //makes list of ALL zipcode info
			// Again borrowed heavily from run() in YelpProject.java
			ArrayList<ZipCode> allZipData = new ArrayList<ZipCode>();
			BufferedReader theZipFile;
			int p = 4; //used to split read and store every four lines
			try {
				theZipFile = new BufferedReader(new FileReader(new File ("src/data_set/zip_data/zip_all.txt")));
				
				while (theZipFile.readLine() != null) {
					//System.out.println(allData.readLine());
					//System.out.println("why");
					String[] oneZip = new String[p];
					for (int i=0; i<p; i++) {
						//System.out.print("it enter");
						oneZip[i] = theZipFile.readLine();
						//System.out.println(oneZip[i]);
					}
					//System.out.println("oksooo");
					ZipCode temp = new ZipCode(oneZip[0], splitToLoc(oneZip[1]), oneZip[2], oneZip[3]);
					//System.out.println(temp.);
					allZipData.add(temp);	
					//allData.readLine();
				}
				//System.out.println(allZipData.get(0).zip);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return allZipData;
		}
		
		
		
		
		
		
		public void run() {
			//ArrayList<String> allRestaurants = new ArrayList<String>();
			//boolean x = 
			
			ArrayList<Establishment> allEstablishments = new ArrayList<Establishment>();
			
			BufferedReader allData;
			try {
				allData = new BufferedReader(new FileReader(new File ("src/data_set/food_data/food_NY.txt")));
				
				//allEstablishments = new ArrayList<Establishment>();
				while (allData.readLine() != null) {
					//allData.readLine();
					String[] oneData = new String[n-1];
					for (int i=0;i<n-1;i++) {
						oneData[i] = allData.readLine();
					}
					//System.out.println(oneData[6]);
					Establishment temp= new Establishment(splitToLoc(oneData[0]),oneData[1],fullAddress(oneData),toPhoneNumber(oneData[6]),oneData[7],getTypes(oneData[8]), new AllHours(Arrays.copyOfRange(oneData, 10, 17)));
					allEstablishments.add(temp);
					allData.readLine(); //eating up the empty line... 
					
				}
				//System.out.print(allRestaurants.size());	
			}
			catch(IOException e) {
				e.printStackTrace(); /// what does this do ASK 
				
			}
			
			
			
	
			
	 	
			//System.out.println(allEstablishments.get(3).mPhone);
			System.out.println("DONE");
			ArrayList<ZipCode> z = readZipCodeFile();
			//System.out.println(z.get(2).zip);
			Location colgateLoc = zipToLoc("10001",z);
			
			int userBoundary = 20;
			//System.out.println(colgateLoc.mLong);
			ArrayList<Establishment> locFil = locationFilter(allEstablishments, colgateLoc, userBoundary); 
			System.out.println("DONE AGAIN");
			System.out.print(locFil.get(0).mPhone);
			
		}
	
}

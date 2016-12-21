
import java.io.*;
import java.util.ArrayList;

public class ZipCode {
	double mLat;
	double mLong;
	int zip;
	String mTown;
	String mState;

	private static int n = 4; // number of lines in one location (ie zip, coordinates, town, state)

	
	
	public ZipCode(String zipCode, Location coordinates, String town, String state){
		zip = Integer.parseInt(zipCode);
		mLat = (coordinates.getLat());
		mLong = (coordinates.getLong());
		mTown = town; 
		mState = state;
	}

	public String[] splitData(String data) {
		// takes one location data and splits by line accordingly (borrowed from YelpProject.java)
		String[] splitString = new String[n];
		splitString = data.split("\\n"); 
		return splitString; 
	}
	
	/// Below: four methods for returning any given portion of the location data in a zip_XX.txt file using splitData()

	public String getZip(String[] data){
		return data[0];
	}
	
	public String getCoordinates(String[] data){
		return data[1];
	}
	
	public String getTown(String[] data){
		return data[2];
	}
	
	public String getState(String[] data){
		return data[3];
	}

	// The run() function compiles all the info from a given zip_XX.txt file (zip_all.txt, here) into a single ArrayList
	
	
	
	//public String zipCodeSearch(String zipCode){
		//int zip = Integer.parseInt(zipCode);
		
		//return null;
	//}

}


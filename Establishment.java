import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Establishment {
	
	Location mLocation;
	String mName;
	AllHours mHours; 
	Address mAddress;
	String mPhone;
	String mWebsite;
	ArrayList<String> mRestaurantTypes = new ArrayList<String>();
	
	
	
	// 
	
	
	public Establishment(Location location, String name, Address address, String phone, 
			String website, ArrayList<String> restaurantType,AllHours hours) {
		//(loc, name, add, phone, website, type, hours)
		mLocation = location; 
		mName = name;
		mHours = hours;
		mAddress = address;
		mPhone = phone;
		mWebsite = website;
		mRestaurantTypes = restaurantType;
		
	}
	
	
	
	
	//public Location locCalculate(String oneData) {
		//
	//}
	public Location getLocation() {
		return mLocation;
	}
	
	public String getName() {
		return mName;
	}
	
	public AllHours getHours() {
		return mHours;
	}
	
	public Address getAddress() {
		return mAddress;
	}
}

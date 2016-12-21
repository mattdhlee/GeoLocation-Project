
public class Address {
	
	
	private String[] mAddress = new String[4];  //a list of address info [streetadd, city, state, zip]
	
	public Address(String street, String city, String state, String zip) {
		mAddress[0] = street;
		mAddress[1] = city;
		mAddress[2] = state;
		mAddress[3] = zip;
	}
	
	//public String[] getAddress() {
		//return mAddress;
	//}
	
	public String getStreet() {
		return mAddress[0];
	}
	
	public String getCity() {
		return mAddress[1];
	}
	
	public String getState() {
		return mAddress[2];
	}
	
	public String getZip(){
		return mAddress[3];
	}
	
	
}

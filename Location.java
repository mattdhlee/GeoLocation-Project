
public class Location {
	Double mLat;
	Double mLong;
	
	public Location(Double latitude, Double longitude) {
		mLat = latitude;
		mLong = longitude;
	}
	
	public Double getLat() {
		return mLat;
	}
	
	public Double getLong() {
		return mLong;
	}
	
	public boolean equals(Location other) {
		if (mLat+0.1 > other.mLat && mLat-0.1< other.mLat) {
			if (mLong+0.1 > other.mLong && mLong-0.1< other.mLong){
				return true;
			}
		}
		return false;
	}
	
}

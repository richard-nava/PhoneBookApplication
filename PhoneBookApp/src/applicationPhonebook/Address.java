package applicationPhonebook;


public class Address extends Person {
	
	
	
	public Address( String street, String city, String state, String zip) {
		
		
		this.street = streetFormatSave(street);
		this.city = cityFormatSave(city);
		this.state = stateFormatSave(state);
		this.zip = zipFormatSave(zip);
	}
	
	public Address(){}

	private String street, city, state;
	private String zip;
	
	public String zipFormatSave(String zip) {
		String newZip = zip;
		
		if(zip.charAt(0) == ' ') {
			
			newZip = zip.substring(1, zip.length());
		}
		
		
		return newZip;
	}
	
	public static String stateFormatSave(String state) {
	
		String newState = state;
		
		if(state.charAt(0) == ' ') {
			
			newState = state.substring(1, state.length());
		}
		
		return newState;
		
	}
	
	public static String streetFormatSave(String street){
		
		String newStreet = street;
		
		if(street.charAt(0) == ' ') {
			
			newStreet = street.substring(1, street.length());
		}
		
		
		
		return newStreet;
	}
	
	
	public static String cityFormatSave(String city) {
		String newCity = city;
		
		if(city.charAt(0) == ' ') {
			
			newCity = city.substring(1, city.length());
		}
		
		return newCity;
	}
	
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@Override
	public String toString() {
		return street + "\n" + city + ", " + state + "\n" + zip;
	}

}

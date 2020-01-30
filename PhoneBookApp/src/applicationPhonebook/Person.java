package applicationPhonebook;

import java.util.Scanner;
import java.util.Comparator;

public class Person implements Comparable<Person>{
	
	private String firstName;
	private String lastName;
	private String middleName;
	private String wholeName;
	private String phoneNumber;
	private Address address;
	public Person() {}
	public Person(String wholeName, Address address, String phoneNumber) {
		super();
		//this.firstName = nameBreakUp(wholeName)[0];
		//this.lastName = nameBreakUp(wholeName)[nameBreakUp(wholeName).length - 1];
		this.phoneNumber = phoneSaveFormat(phoneNumber);
		this.address = address;
		//this.middleName = nameBreakUp(wholeName)[1];
		this.wholeName = wholeName;
		nameBreakUp(wholeName);
	}	
	public String getWholeName() {
		return wholeName;
	}
	public void setWholeName(String wholeName) {
		this.wholeName = wholeName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		
		
		 String[] newWhole = wholeName.split(" "); newWhole[0] = firstName;
		 wholeName ="";
		 for(int i = 0; i<newWhole.length; i++) {
		  
			 wholeName += newWhole[i];
		  
			 	if(i != newWhole.length-1) {
		 
			 	wholeName += " "; 
			 	}
		 
		 }
			
		
		
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
		
		String[] newWhole = wholeName.split(" ");
		newWhole[newWhole.length -1] = lastName;
		
		wholeName ="";
		
		for(int i = 0; i<newWhole.length; i++) {
			
			wholeName += newWhole[i];
			
			if(i != newWhole.length-1) {
				
				wholeName += " ";
			}
		}
			
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber= phoneNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		String displayString ="";
		
		/*
		 * if(wholeName.length() == 2) { displayString = "Name: " + firstName + " " +
		 * lastName + "\nPhone Number: " + phoneFormat(phoneNumber) + "\nAddress: " +
		 * address + "\n";
		 * 
		 * } else if(wholeName.length() > 2) { displayString = "Name: " + firstName +
		 * " " + middleName + " " + lastName + "\nPhone Number: " +
		 * phoneFormat(phoneNumber) + "\nAddress: " + address + "\n";
		 * 
		 * }
		 */
		
		
		return "Name: " + wholeName
				+ "\nPhone Number: " + phoneFormat(phoneNumber)
				+ "\nAddress: " + address + "\n";
		
	}
	public static Person[] addPerson(Person[] source, Person add) {
		
		//initialize the new array
		// new array in the original array + 1 more spot
		Person[] temp = new Person[source.length +1];
		
		//loop through OG array
		for(int i=0;i<source.length;i++) {
			
			/*the new arrays index element is the same as the old
			ones*/
			
			temp[i]=source[i];
		}
		
		temp[source.length] = add; 
		
		//System.out.println("Inside method addPerson: " + temp.toString() +"\n");
		
		return temp;
	
	}
	public static Comparator<Person> PersonNameComparator 
						= new Comparator<Person>() {

					@Override
					public int compare(Person o1, Person o2) {
						
						String firstName1 = o1.getFirstName().toUpperCase();
						String firstName2 = o2.getFirstName().toUpperCase();
						
						return firstName1.compareTo(firstName2);
					}
		
				
	};
	public void nameBreakUp(String wholeName){
		
		String[] userWhole = wholeName.split(" ");
		//String firstName, lastName; 
		//String middleName="";
		
		if(userWhole.length == 2) {
			firstName = userWhole[0];
			lastName = userWhole[userWhole.length - 1];
		}
		else if(userWhole.length > 2) {
			firstName = userWhole[0];
			lastName = userWhole[userWhole.length-1];
			
			for(int i =1; i<userWhole.length-2; i++) {
				
				middleName += userWhole[i].toString();
			}
			
		}
		firstName = userWhole[0];
		lastName = userWhole[userWhole.length - 1];
		//middleName = userWhole[1];
		//return userWhole;	
	}	
	
	
	public static String phoneFormat(String phoneNumber) {
		
		String newNum = phoneNumber;
		
		if(phoneNumber.charAt(0) == ' ') {
			
			phoneNumber = phoneNumber.substring(1,11);	
			
		}

		String[] fullNum = new String[10];
		fullNum[0] = phoneNumber.substring(0, 3);
		fullNum[1] = phoneNumber.substring(3, 6);
		fullNum[2] = phoneNumber.substring(6,10);
		newNum = fullNum[0] + "-" + fullNum[1] + "-" + fullNum[2];	
		
		return newNum;
			
	}
	
	public static String phoneSaveFormat(String phoneNumber) {
		
		String newNum = phoneNumber;
		
		if(phoneNumber.charAt(0) == ' ') {
			
			phoneNumber = phoneNumber.substring(1,11);	
			
		}
		

		String[] fullNum = new String[10];
		fullNum[0] = phoneNumber.substring(0, 3);
		fullNum[1] = phoneNumber.substring(3, 6);
		fullNum[2] = phoneNumber.substring(6,10);
		newNum = fullNum[0] + fullNum[1] + fullNum[2];	
		
		return newNum;
	}
		
	
	public static Person[] updatedAddEntry(Person[] source){
		
		Scanner in = new Scanner(System.in);
		
		String firstName ="", lastName="", wholeName, city, state, phone, street, zip;
		String middleName = "";
		System.out.println("Enter New Entry Information \n"
				+ "(Format: Full Name, "
				+ " Street Address, City, State, Zip Code, Phone Number): ");
		
		String information = in.nextLine();
		
		String[] userInfo = information.split(",");
		wholeName = userInfo[0];
		phone = userInfo[5];
		street = userInfo[1];
		city = userInfo[2];
		state = userInfo[3];
		zip = userInfo[4];
		
		String[] userWhole = wholeName.split(" ");
		
		if(userWhole.length == 2) {
		firstName = userWhole[0];
		lastName = userWhole[userWhole.length -1];
		}
		else if(userWhole.length > 2) {
		firstName = userWhole[0];
		lastName = userWhole[userWhole.length-1];
			
			for(int i =0; i<=userWhole.length-2; i++) {
				
				middleName += userWhole[i];
			
				if(i != wholeName.length() - 2) {
					middleName += " ";	
				}
				//System.out.println(middleName);
			}
			//System.out.println(middleName);
		}
		
		/*
		 * firstName = userWhole[0]; lastName = userWhole[userWhole.length -1];
		 * middleName = userWhole[1];
		 */
		
		
		Address newAddress = new Address(street, city, state, zip);
		Person newGuy = new Person(wholeName, newAddress, phone);
		
		source = Person.addPerson(source,newGuy);			

		System.out.println(firstName + " " + lastName + " has been added to "
				+ "the Phonebook! \n");

		
		return source;
	}
	
	
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}
	
	
	
	


package applicationPhonebook;

import java.util.Arrays;
import java.util.Scanner;

public class MainConsole {

	public static void main(String[] args) {

		
		 //String temp = "7733016222";  System.out.println(newNum);
		 

		Scanner in = new Scanner(System.in);
		Person[] entries = new Person[0];
		boolean again = true;

		while (again) {
			// begin program
			System.out.println("Welcome to the main menu of Richard's Phonebook! \n" + "\n" + "Main Menu: \n"
					+ "1. Search Entries \n" + "2. Add New Entry \n" + "3. Delete an Entry \n"
					+ "4. View All Entries \n" + "5. Update Entry \n" + "6. Exit Phonebook \n");

			System.out.print("Enter number selection: ");
			int select = in.nextInt();

			switch (select) {
			case 1:
				searchEntries(entries);
				break;
			case 2:
				try {
				entries = Person.updatedAddEntry(entries);
				}
				catch(Exception e) {
					System.out.println("\n Not a valid entry! \n "
							+ "You didn't follow the format!");
				}
				break;
			case 3:
				entries = deleteEntry(entries);
				break;
			case 4:
				//System.out.println(entries[0].getMiddleName());
				ascendingOrder(entries);
				break;
			case 5:
				updateEntry(entries);
				break;
			case 6:
				System.out.println("Goodbye!");
				again = false;
				break;
			default:
				System.out.println("Not a valid entry.");
				break;
			}
		}
	}

	private static void updateEntry(Person[] entries) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the phone number of the person you would like to update: ");
		String phoneNum = in.next();

		for (int i = 0; i < entries.length; i++) {

			if (entries[i].getPhoneNumber().equals(phoneNum)){

				System.out.println("What would you like to update? \n" + "1. First Name \n" + "2. Last Name \n"
						+ "3. Address \n" + "4. Phone Number");
				int updateSelect = in.nextInt();

				switch (updateSelect) {
				case 1:
					System.out.println("Enter new First Name: ");
					String newFirst = in.next();
					entries[i].setFirstName(newFirst);
					System.out.println(entries[i].getFirstName() + " " 
								+ entries[i].getLastName() + " has been updated!");
					break;
				case 2:
					System.out.println("Enter new Last Name: ");
					String newLast = in.next();
					entries[i].setLastName(newLast);
					System.out.println(entries[i].getFirstName() + " " 
							+ entries[i].getLastName() + " has been updated!");
					break;
				case 3:
					System.out.println("Enter new Street Address: ");
					String newStreet = in.nextLine();
					newStreet = in.nextLine();
					System.out.println("Enter new City: ");
					String newCity = in.next();
					System.out.println("Enter new State: ");
					String newState = in.next();
					System.out.println("Enter new Zip");
					String newZip = in.next();
					Address newAddress = new Address(newStreet, newCity, newState, newZip);
					entries[i].setAddress(newAddress);
					System.out.println(entries[i].getFirstName() + " " 
							+ entries[i].getLastName() + " has been updated!");
					break;
				case 4:
					System.out.println("Enter new Phone Number: ");
					String newPhone = in.next();
					entries[i].setPhoneNumber(newPhone);
					System.out
							.println(entries[i].getFirstName() + " " + entries[i].getLastName() + " has been updated!");
					break;

				default:
					System.out.println("Not a valid entry.");
				}
				
				break;
			}
			
		}
	}

	// if user chooses to search entries
	public static void searchEntries(Person[] entries) {

		Scanner in = new Scanner(System.in);

		System.out.println("How would you like to search? \n" + "\n" + "1. First Name \n" + "2. Last Name \n"
				+ "3. City \n" + "4. State \n" + "5. Zip Code \n"
				+ "6. Phone Number \n" + "Enter selection number: ");

		int search = in.nextInt();

		switch (search) {
		case 1:
			System.out.println("Enter first name: ");
			String fname = in.next();
			searchFirst(fname, entries);
			break;
		case 2:
			System.out.println("Enter last name: ");
			String lname = in.next();
			searchLast(lname, entries);
			break;
		case 3:
			System.out.println("Enter city: ");
			String citySearch = in.next();
			searchCity(citySearch, entries);
			break;
		case 4:
			System.out.println("Enter State: ");
			String searchState = in.next();
			searchState(searchState, entries);
			break;
		case 5:
			System.out.println("Enter Zip: ");
			String searchZip = in.next();
			searchZip(searchZip, entries);
			break;
		case 6:
			System.out.println("Enter Phone number: ");
			String num = in.nextLine();
			num = in.nextLine();
			searchNum(num, entries);
			break;
		default:
			System.out.println("Not a valid entry.");

		}

	}

	// if user chooses to delete an entry
	public static Person[] deleteEntry(Person[] entries) {
		
		Scanner in = new Scanner(System.in);

		Person[] tempNow = new Person[0];

		System.out.println("WARNING: You can only delete an entry " + "using a telephone number. \n"
				+ "Enter the person's telephone number to delete their entry: ");

		String deleteParam = in.next();

		for (int i = 0; i < entries.length; i++) {

			if (!entries[i].getPhoneNumber().equals(deleteParam)) {

				tempNow = Person.addPerson(tempNow, entries[i]);
				
			}
			
		}
		if(tempNow.length < entries.length) {
			System.out.println("Person successfully deleted!");
		}
		else {
			System.out.println("No such person in directory");
		}

		return tempNow;
	}

	
	// search by first name
	public static void searchFirst(String fname, Person[] entries) {

		for (int i = 0; i < entries.length; i++) {

			if (entries[i].getFirstName().equals(fname)) {

				System.out.println(entries[i] + "\n");

			} else {
				System.out.println("No entries match your query!");
			}

		}
	}

	// search by last name
	public static void searchLast(String lname, Person[] entries) {

		for (int i = 0; i < entries.length; i++) {

			if (entries[i].getLastName().equals(lname)) {

				System.out.println(" ");
				System.out.print(entries[i]);
			}
				
		}

	}

	// search by phone number
	public static void searchNum(String num, Person[] entries) {

		for (int i = 0; i < entries.length; i++) {

			if (entries[i].getPhoneNumber().equals(num)) {

				System.out.print(entries[i]);
			}
		}

	}

	// search by city
	private static void searchCity(String citySearch, Person[] entries) {

		for (int i = 0; i < entries.length; i++) {

			if (entries[i].getAddress().getCity().equals(citySearch)) {

				System.out.print(entries[i] + "\n");

			}

		}
	}

	// search by zip
	private static void searchZip(String zipSearch, Person[] entries) {
		
		for (int i = 0; i < entries.length; i++) {

			if (entries[i].getAddress().getZip().equals(zipSearch)) {

				System.out.print(entries[i]);

			}

		}
		
	}
	
	// search by state
	private static void searchState(String searchState, Person[] entries) {
		// TODO Auto-generated method stub

		for (int i = 0; i < entries.length; i++) {

			if (entries[i].getAddress().getState().equals(searchState)) {

				System.out.print(entries[i]);

			}

		}
	}

	public static void ascendingOrder(Person[] entries) {

		Person[] newEntries = entries;

		for (int i = 0; i < newEntries.length; i++) {
			Arrays.sort(newEntries, Person.PersonNameComparator);
			System.out.println(newEntries[i] + "\n");
		}

	}


}

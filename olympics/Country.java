package olympics;

import java.util.ArrayList;

public class Country {

	private static ArrayList<Country> allCountries;
	private String name;
	private int numOfMedals;
	
	public Country(String name) {
		allCountries = new ArrayList<Country>();
		this.name = name;
		numOfMedals = 0;
	}
	
	public void addCountry(Country country) {
		allCountries.add(country);
	}
	
	public void addMedals(int numOfMedals) {
		this.numOfMedals += numOfMedals;
	}
	//getters
	
	public ArrayList<Country> getAllCountries() {
		return allCountries;
	}

	public String getName() {
		return name;
	}

	public int getNumOfMedals() {
		return numOfMedals;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
	
	
}

package olympics;

public class SportMan {
	public enum SportType {running, jumping, runningAndJumping};

	private String name;
	private Country country;
	private int numOfMedals;
	private SportType sportType;
	
	public SportMan(String name, Country country, int numOfMedals, SportType sportType) {
		this.name = name;
		this.country = country;
		this.numOfMedals = numOfMedals;
		this.sportType = sportType;
	}
	
	public void addMedalsToSportMan(int numOfMedals) {
		this.numOfMedals += numOfMedals;
		country.addMedals(numOfMedals);
	}
	//getters

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}

	public int getNumOfMedals() {
		return numOfMedals;
	}

	public SportType getSportType() {
		return sportType;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name: " + name + ", from " + country + ", his sport type is: " + sportType + ", he has: " + numOfMedals + " medals ");
		return sb.toString();
	}

	

}

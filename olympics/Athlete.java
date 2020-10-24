package olympics;

public class Athlete extends SportsMan {

	private int numOfMedals;
	
	public Athlete(String name, Country country, int numOfMedals, SportType sportType) {
		super(name , country ,sportType);
		this.numOfMedals = numOfMedals;
	}
	
	public void addMedalsToSportMan(int numOfMedals) {
		this.numOfMedals += numOfMedals;
		getCountry().addMedals(numOfMedals);
	}

	public int getNumOfMedals() {
		return numOfMedals;
	}

	@Override
	public String toString() {
		return super.toString() + "He has: " + numOfMedals;
	}

	

	

}

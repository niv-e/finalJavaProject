package olympics;

public class athlete extends SportsMan {


	private int numOfMedals;
	
	public athlete(String name, Country country, int numOfMedals, SportType sportType) {
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
		StringBuilder sb = new StringBuilder();
		sb.append("name: " + getName() + ", from " + getCountry() + ", his sport type is: " + sportType + ", he has: " +/* + numOfMedals +*/ " medals ");
		return sb.toString();
	}

	

}

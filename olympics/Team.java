package olympics;

import java.util.Vector;

public class Team {

	private Vector<Athlete> allSportsManOfTeam;
	private Country country;
	private int numOfMedals;
	
	public Team(Country country, Vector<Athlete> alls) {
		allSportsManOfTeam = new Vector<Athlete>();
		this.country = country;
		numOfMedals = 0;
	}
	
	public void addSportManToTeam(Athlete sportman) {
		allSportsManOfTeam.add(sportman);
	}
	
	public void addMedals(int numOfMedals) {
		this.numOfMedals += numOfMedals;
		country.addMedals(numOfMedals);
	}
	//getters

	public Vector<Athlete> allSportsManOfTeam() {
		return allSportsManOfTeam;
	}

	public Country getCountry() {
		return country;
	}

	public int getNumOfMedals() {
		return numOfMedals;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < allSportsManOfTeam.size(); i++) {
			sb.append("Team " + (i+1) + "--> ");
			sb.append("from: " + country + " has: " + numOfMedals);
			sb.append(allSportsManOfTeam.get(i).toString());
		}
		return sb.toString();
	}
	
	
	
}

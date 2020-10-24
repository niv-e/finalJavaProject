package olympics;

public class Competition {
	
	//public enum CompetitionSportTypes {running, jumping};

	//protected String refereeName;
	//protected Country refereeCountry;
	protected Referee referee;
	protected Stadium stadium;
	//protected String stadiumName;
	//protected String stadiumLocation;
	protected SportType cmpType;
	personalOrTeamComp typeCompetition;
	//protected final int NUM_OF_SEATS = 1000;
	protected static int counter = 1;
	protected int competitionNumber;
	
	//public Competition(String refereeName, Country refereeCountry, String stadiumName, String stadiumLocation,
		//	TypesOfCompetition typeCompetition) {
		//this.refereeName = refereeName;
		//this.refereeCountry = refereeCountry;
		//this.stadiumName = stadiumName;
		//this.stadiumLocation = stadiumLocation;
	public Competition(Referee referee, Stadium stadium, SportType compType, personalOrTeamComp sportType) {
		this.referee = referee;
		this.stadium = stadium;
		this.cmpType = compType;
		this.typeCompetition = sportType;
		competitionNumber = ++counter;
	}
	//getters
	
	public Referee getReferee() {
		return referee;
	}

	public Stadium getStadium() {
		return stadium;
	}

	public int getCompetitionNumber() {
		return competitionNumber;
	}
	
	public personalOrTeamComp getTypeCompetition() {
		return typeCompetition;
	}

	public CompetitionSportTypes getCmpType() {
		return cmpType;
	}

	@Override
	public String toString() {
		return "Competition [referee=" + referee + ", stadium=" + stadium + ", cmpType=" + cmpType
				+ ", typeCompetition=" + typeCompetition + ", competitionNumber=" + competitionNumber + "]";
	}

//	public String getRefereeName() {
//		return refereeName;
//	}
//
//	public Country getRefereeCountry() {
//		return refereeCountry;
//	}
//
//	public String getStadiumName() {
//		return stadiumName;
//	}
//
//	public String getStadiumLocation() {
//		return stadiumLocation;
//	}
//
//	public int getNUM_OF_SEATS() {
//		return NUM_OF_SEATS;
//	}

//	@Override
//	public String toString() {
//		StringBuilder sb = new StringBuilder();
//		sb.append("details competition are --> \n" );
//		sb.append("refereeName: " + refereeName + ", from " + refereeCountry + ", the stadiumName: "
//				+ stadiumName + ", in Location: " + stadiumLocation + ", competition type is: " + cmpType + " \n");
//		return sb.toString();	
//	}
	
	
}

	
	
	
	
	


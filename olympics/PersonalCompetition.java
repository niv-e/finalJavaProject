package olympics;

import java.util.ArrayList;
import java.util.Collections;

import olympics.Competition.CompetitionSportTypes;

public class PersonalCompetition extends Competition {

	private ArrayList<Athlete> allSportMan;
	//private SportType refereeSportType;
	
	
	public PersonalCompetition(Referee referee, Stadium stadium, personalOrTeamComp compType, SportType sportType) {
		super(referee, stadium, sportType, compType);
		allSportMan = new ArrayList<Athlete>();
		//this.refereeSportType = refereeSportType;	
	}
	
	public void addSportMan(Athlete sportMan) {
		allSportMan.add(sportMan);
	}
	
	public void compete() {
		Collections.shuffle(allSportMan);
		allSportMan.get(0).addMedalsToSportMan(3);//first rank
		allSportMan.get(1).addMedalsToSportMan(2);//second rank
		allSportMan.get(2).addMedalsToSportMan(1);//third rank
	}
	//getters

	public ArrayList<Athlete> getAllSportMan() {
		return allSportMan;
	}

//public SportType getRefereeSportType() {
	//	return refereeSportType;
	//}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < allSportMan.size(); i++) {
			sb.append("SportMan " + (i+1) + " --> \n" );
			  sb.append(allSportMan.get(i).toString() + "\n");
		}
		return super.toString() + sb.toString();
	}
	
	
	
	
	
}

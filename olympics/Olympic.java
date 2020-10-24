package olympics;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Olympic {
	
	private String name;
	private String startDate;
	private String endDate;
	private ArrayList<PersonalCompetition> allPersonalsCompetition;
	private ArrayList<TeamCompetition> allTeamsCompetition;
	
	public Olympic(String name, String startDate, String endDate) {
		allPersonalsCompetition = new ArrayList<PersonalCompetition>();
		allTeamsCompetition = new ArrayList<TeamCompetition>();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public void runOlympic() {
		for(PersonalCompetition p : allPersonalsCompetition) {
			p.compete();
			p.toString();
		}
		for(TeamCompetition p : allTeamsCompetition) {
			p.teamCompete();
			p.toString();
		}
	}
	//getters

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public ArrayList<PersonalCompetition> getAllPersonalsCompetition() {
		return allPersonalsCompetition;
	}

	public ArrayList<TeamCompetition> getAllTeamsCompetition() {
		return allTeamsCompetition;
	}

	@Override
	public String toString() {
		return "olympic [startDate=" + startDate + ", endDate=" + endDate + ", allPersonalsCompetition="
				+ allPersonalsCompetition + ", allTeamsCompetition=" + allTeamsCompetition + "]";
	}
	
	
	
	
}

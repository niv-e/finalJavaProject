package view;

import Controller.OlympicController;
import olympics.Country;
import olympics.Referee;
import olympics.SportType;
import olympics.Stadium;
import olympics.personalOrTeamComp;
import olympics.Athlete;
import olympics.Competition;

public interface OlympicViewable {

	void registerListener(OlympicController oc);
	void setNewOlympicIsCreated();
	void setNewPersonalCompetition(Competition pc);
	void setNewTeamCompetition(Competition tc);
	void setNewCountry(Country countryName);
	void setNewStadium(Stadium stadium);
	void setNewReferee(Referee referee);
	void setNewAthlet(Athlete athlet);
	
	
}

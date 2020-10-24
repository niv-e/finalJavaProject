package Listener;

import olympics.Country;
import olympics.Referee;
import olympics.Stadium;
import olympics.Athlete;
import olympics.Competition;

public interface OlympicModelEventListener {

	void fireNewCountryWasAdd(Country country);
	void fireNewStadiumWasCreate(Stadium stadium);
	void fireNewRefereeWasCreate(Referee referee);
	void fireNewAthletWasCreate(Athlete athlet);
	void fireNewPersonalCompWasCreate(Competition pc);
	void fireNewTeamCompWasCreate(Competition tc);
	

}

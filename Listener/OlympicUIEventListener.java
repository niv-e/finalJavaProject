package Listener;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import olympics.Competition.CompetitionSportTypes;
import olympics.Country;
import olympics.Referee;
import olympics.SportType;
import olympics.Stadium;
import olympics.personalOrTeamComp;

public interface OlympicUIEventListener {

	void viewFireOlympicAdded(String name, String startDate, String endDate);
	void viewFireNewPersonalCompetitonWasAdd(SportType sportType, personalOrTeamComp typesOfCompetition, Referee referee, Stadium stadium);
	void viewFireNewTeamCompetitonWasAdd(SportType sportType, personalOrTeamComp typesOfCompetition, Referee referee, Stadium stadium);
	void viewFireNewCountryWasAdd(String countryName);
	void viewFireNewStadiumWasAdd(String name, String location, int numOfSeat);
	void viewFireNewRefereeWasCreate(String name, Country country, SportType sportType);
	void viewFireNewAthletWasCreate(String name, Country country, int numOfMedals, SportType selectedItem);
	
	
}

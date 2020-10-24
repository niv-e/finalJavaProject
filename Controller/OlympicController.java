package Controller;

import Listener.OlympicModelEventListener;
import Listener.OlympicUIEventListener;
import javafx.scene.control.TextField;
import olympics.Country;
import olympics.OlympicManager;
import olympics.Referee;
import olympics.SportType;
import olympics.Stadium;
import olympics.personalOrTeamComp;
import olympics.Athlete;
import olympics.Competition;
import view.OlympicViewable;

public class OlympicController implements OlympicModelEventListener, OlympicUIEventListener{

	private OlympicManager theModel;
	private OlympicViewable theView;
	
	public OlympicController(OlympicManager m, OlympicViewable v) {
		theModel = m;
		theView = v;
		
		theModel.registerListener(this);
		theView.registerListener(this);
	}

	@Override
	public void viewFireOlympicAdded(String name, String startDate, String endDate) {
		theModel.createNewOlympic(name, startDate, endDate);
		theView.setNewOlympicIsCreated();
	}

	@Override
	public void viewFireNewPersonalCompetitonWasAdd(SportType sportType, personalOrTeamComp compType, Referee referee, Stadium stadium) {
		theModel.addNewPersonalCompetition(sportType, compType, referee, stadium);
	}
	
	@Override
	public void fireNewPersonalCompWasCreate(Competition pc) {
		System.out.println("controller line 43");
		theView.setNewPersonalCompetition(pc);
	}
	
	@Override
	public void viewFireNewTeamCompetitonWasAdd(SportType sportType, personalOrTeamComp compType, Referee referee, Stadium stadium) {
		theModel.addNewTeamCompetition(sportType, compType, referee, stadium);
	}
	
	@Override
		public void fireNewTeamCompWasCreate(Competition tc) {
			theView.setNewTeamCompetition(tc);
		}

	@Override
	public void viewFireNewCountryWasAdd(String countryName) {
		theModel.addNewCountry(countryName);
	}

	@Override
	public void fireNewCountryWasAdd(Country country) {
		theView.setNewCountry(country);	
	}

	@Override
	public void viewFireNewStadiumWasAdd(String name, String location, int numOfSeat) {
		theModel.createNewStadium(name , location , numOfSeat);
	}

	@Override
	public void fireNewStadiumWasCreate(Stadium stadium) {
		theView.setNewStadium(stadium);	
	}

	@Override
	public void viewFireNewRefereeWasCreate(String name, Country country, SportType sportType) {
		theModel.createNewReferee(name , country , sportType);
	}

	@Override
	public void fireNewRefereeWasCreate(Referee referee) {
		theView.setNewReferee( referee);
	}
	
	@Override
	public void viewFireNewAthletWasCreate(String name, Country country, int numOfMedals, SportType sportType) {
		theModel.createNewAthlet(name, country, numOfMedals, sportType);
	}
	
	@Override
	public void fireNewAthletWasCreate(Athlete athlet) {
		theView.setNewAthlet(athlet);
	}


}

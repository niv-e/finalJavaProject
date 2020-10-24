package olympics;

import java.util.ArrayList;
import java.util.Vector;

import olympics.Competition.CompetitionType;
import olympics.SportMan.SportType;

public class Program {

	public static void main(String[] args) {
		
		Vector<SportMan> allSportManFromCountry1 = new Vector<SportMan>();
		Vector<SportMan> allSportManFromCountry2 = new Vector<SportMan>();
		Vector<SportMan> allSportManFromCountry3 = new Vector<SportMan>();
		
		//OlympicManager o = new OlympicManager("Rio", "2020", "2021");
		
		SportMan shay = new SportMan("shay", new Country("Israel"), 5, SportType.running);
		SportMan daniel = new SportMan("daniel", new Country("USA"), 4, SportType.jumping);
		SportMan niv = new SportMan("niv", new Country("Israel"), 3, SportType.runningAndJumping);
		SportMan idan = new SportMan("idan", new Country("France"), 7, SportType.running);
		SportMan aviel = new SportMan("aviel", new Country("USA"), 1, SportType.jumping);
		SportMan ariel = new SportMan("ariel", new Country("USA"), 3, SportType.runningAndJumping);
		SportMan nissim = new SportMan("nissim", new Country("France"), 2, SportType.runningAndJumping);

		
		Team t1 = new Team(new Country("Israel"), allSportManFromCountry1);
		Team t2 = new Team(new Country("USA"), allSportManFromCountry2);
		Team t3 = new Team(new Country("France"), allSportManFromCountry3);
		
		
		PersonalCompetition pc1 = new PersonalCompetition("moshe", new Country("Germany"), "Sami-Ofer", "Haifa", "Running", CompetitionType.running);
		PersonalCompetition pc2 = new PersonalCompetition("david", new Country("Italy"), "Blumfild", "TLV", "Jumping", CompetitionType.jumping);
		PersonalCompetition pc3 = new PersonalCompetition("tal", new Country("Poland"), "Terner", "Beer-Sheva", "Running&Jumping", CompetitionType.running);
		
		pc1.addSportMan(shay);
		pc1.addSportMan(daniel);
		pc1.addSportMan(idan);
		pc1.addSportMan(ariel);
		
		pc2.addSportMan(nissim);
		pc2.addSportMan(aviel);
		pc2.addSportMan(niv);
		pc2.addSportMan(shay);
		pc2.addSportMan(ariel);

		pc3.addSportMan(daniel);
		pc3.addSportMan(idan);
		pc3.addSportMan(ariel);
		pc3.addSportMan(aviel);
		
		//o.getAllPersonalsCompetition().add(pc1);
	//	o.getAllPersonalsCompetition().add(pc2);
	//	o.getAllPersonalsCompetition().add(pc3);
		
		t1.addSportManToTeam(shay);
		t1.addSportManToTeam(niv);
		
		t2.addSportManToTeam(daniel);
		t2.addSportManToTeam(aviel);
		t2.addSportManToTeam(ariel);
		
		t3.addSportManToTeam(idan);
		t3.addSportManToTeam(nissim);
		
	//	TeamCompetition tp1 = new TeamCompetition("avi", new Country("Iran"), "Natanya", "Natanya", "Jumping", CompetitionType.runningAndJumping);
	//	TeamCompetition tp2 = new TeamCompetition("ben", new Country("USA"), "Tedi", "Jerusalem", "Running&Jumping", CompetitionType.runningAndJumping);
		
	//	tp1.addTeam(t1);
	//	tp1.addTeam(t2);
	//	tp1.addTeam(t3);
		
	//	tp2.addTeam(t3);
	//	tp2.addTeam(t2);
	//	tp2.addTeam(t1);
		System.out.println(pc1.toString());
		//o.getAllTeamsCompetition().add(tp1);
		//o.getAllTeamsCompetition().add(tp2);
		
	//	System.out.println(o.getAllTeamsCompetition().toString());
	//	System.out.println(tp2.toString());
		
		//o.runOlympic();
		
		
		
	}

	
}

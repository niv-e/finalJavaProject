package view;
//view --> controller (fire)
//controller --> model (get)
//model --> controller (from model)
//controller --> view (set)

import java.util.Vector;
import javax.swing.JOptionPane;
import Controller.OlympicController;
import Listener.OlympicModelEventListener;
import Listener.OlympicUIEventListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import olympics.Competition;
import olympics.personalOrTeamComp;
import olympics.Country;
import olympics.OlympicManager;
import olympics.PersonalCompetition;
import olympics.Referee;
import olympics.SportType;
import olympics.Stadium;
import olympics.TeamCompetition;
import olympics.Athlete;

public class View implements OlympicViewable {

	private Vector<OlympicUIEventListener> allListeners = new Vector<OlympicUIEventListener>();
	private Vector<Competition> allCompetitions = new Vector<Competition>();
	ComboBox<Country> cmbCountries;
	ComboBox<Stadium> cmbStadiums;
	ComboBox<SportType> cmbSportTypes;
	ComboBox<Referee> cmbReferees;
	ComboBox<Athlete> cmbAthlets;
	ComboBox<personalOrTeamComp> cmbCompetitionType;
	ComboBox<String> cmbAllPersonalComp;
	ComboBox<String> cmbAllTeamComp;

	Button btnMenuCreateOlympic;
	Button btnMenuCompetitionType;
	Button btnMenuCountryList;
	Button btnMenuStadiumList;
	Button btnMenuRefereeList;
	Button btnMenuAthletesList;
	Button btnMenuStartOlympic;
	Button btnAddComp;
	Button btnAddCountry;
	Button btnSetStadium;
	Button btnAddReferee;
	Button btnAddAthlet;
	Button btnSetOlympic;
	Button btnShowWinners;
	Button setOlimpic;
	
	Label lblOlympicName;
	Label lblStartOlympic;
	Label lblEndOlympic;
	Label lblAddCompetition;
	Label lblAddCompType;
	Label lblRefereeForCompetiton;
	Label lblStadiumForCompetiton;
	Label lblAddCountry;
	Label lblStadiumName;
	Label lblStadiumLocation;
	Label lblNumOfSeats;
	Label lblRefereeName;
	Label lblRefereeCountry;
	Label lblRefereeList;
	Label lblAthletName;
	Label lblAthletCountry;
	Label lblAthletesList;
	Label lblNumOfAthletMedals;
	Label lblShowPersonalCompDetails;
	Label lblShowTeamCompDetails;
	
	TextField tfOlympicName;
	TextField tfStartOlympic;
	TextField tfEndOlympic;
	TextField tfAddCountry;
	TextField tfStadiumName;
	TextField tfStadiumLocation;
	TextField tfStadiumNumOfSeats;
	TextField tfRefereeName;
	TextField tfAthletName;
	TextField tfNumOfAthletMedals;
	
	
	public View(Stage theStage) {
		theStage.setTitle("Welcome to olympics! ");
		GridPane gpRoot = new GridPane();
		gpRoot.setBackground(new Background(new BackgroundFill(Color.GREENYELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
		gpRoot.setPrefHeight(200);
		gpRoot.setPrefWidth(200);
		gpRoot.setPadding(new Insets(10));
		gpRoot.setAlignment(Pos.TOP_LEFT);
		gpRoot.setHgap(10);
		gpRoot.setVgap(10);
		
		cmbSportTypes = new ComboBox<SportType>();
		cmbSportTypes.getItems().addAll(SportType.running, SportType.jumping , SportType.runningAndJumping);
		cmbReferees = new ComboBox<Referee>() ;
		cmbAthlets = new ComboBox<Athlete>();
		cmbCountries = new ComboBox<Country>();
		cmbCompetitionType = new ComboBox<personalOrTeamComp>();
		cmbCompetitionType.getItems().addAll(personalOrTeamComp.PersonalCompetition, personalOrTeamComp.TeamCompetition);
		cmbAllPersonalComp = new ComboBox<String>();
		cmbAllTeamComp = new ComboBox<String>();
		
		btnMenuCreateOlympic = new Button("Create new olympic"); 
		GridPane.setRowIndex(btnMenuCreateOlympic, 0);
		GridPane.getColumnIndex(btnMenuCreateOlympic);
		
		btnSetOlympic = new Button("Set data");

		btnMenuCreateOlympic.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {	
				setMenu(gpRoot);
				lblOlympicName = new Label("Olympic name:");
				GridPane.setConstraints(lblOlympicName, 5, 1);
				//
				tfOlympicName = new TextField();
				GridPane.setConstraints(tfOlympicName, 6, 1);
				//
				lblStartOlympic = new Label("Start at:");
				GridPane.setConstraints(lblStartOlympic, 5, 2);
				//
				tfStartOlympic = new TextField();
				GridPane.setConstraints(tfStartOlympic, 6, 2);
				//
				lblEndOlympic = new Label("End at:");
				GridPane.setConstraints(lblEndOlympic, 5, 3);
				//
				tfEndOlympic = new TextField();
				GridPane.setConstraints(tfEndOlympic, 6, 3);
				//
				GridPane.setConstraints(btnSetOlympic, 9, 2);
				//
				gpRoot.getChildren().addAll(lblOlympicName, tfOlympicName, lblStartOlympic, tfStartOlympic, lblEndOlympic
						,tfEndOlympic, btnSetOlympic);
			}
		});
		
		btnSetOlympic.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent ex) {	
				String name = tfOlympicName.getText();
				String startDate = tfStartOlympic.getText();
				String endDate = tfEndOlympic.getText(); 
				for(OlympicUIEventListener l : allListeners) {
					l.viewFireOlympicAdded(name, startDate, endDate);	
				}
			}
		});
		
		btnAddComp = new Button("Add Competition");
		btnMenuCompetitionType = new Button("Competitions");
		GridPane.setRowIndex(btnMenuCompetitionType, 1);
		GridPane.getColumnIndex(btnMenuCompetitionType);
		
		btnMenuCompetitionType.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setMenu(gpRoot);
				lblAddCompetition = new Label("Add competition:");
				GridPane.setConstraints(lblAddCompetition, 5, 2);
				//
				GridPane.setConstraints(btnAddComp, 7, 2);
				//
				cmbSportTypes.setPromptText("sport types");
				GridPane.setConstraints(cmbSportTypes, 6, 2);
				//
				lblAddCompType = new Label("type:");
				GridPane.setConstraints(lblAddCompType, 5, 3);
				//
				cmbCompetitionType.setPromptText("types");
				GridPane.setConstraints(cmbCompetitionType, 6, 3);
				//
				lblRefereeForCompetiton = new Label("Choose referee:");
				GridPane.setConstraints(lblRefereeForCompetiton, 5, 4);
				//
				GridPane.setConstraints(cmbReferees, 6, 4);
				//
				lblStadiumForCompetiton = new Label("Choose stadium:");
				GridPane.setConstraints(lblStadiumForCompetiton, 5, 5);
				//
				GridPane.setConstraints(cmbStadiums, 6, 5);
				//
				gpRoot.getChildren().addAll(lblAddCompetition, btnAddComp, cmbSportTypes, lblAddCompType, cmbCompetitionType,
						lblRefereeForCompetiton, cmbReferees, lblStadiumForCompetiton, cmbStadiums);			
			}
		});
		
		btnAddComp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.out.println("btnAddComp setOnAction");
				if(cmbCompetitionType.getSelectionModel().getSelectedItem() == personalOrTeamComp.PersonalCompetition) {
					for(OlympicUIEventListener l : allListeners) {
					l.viewFireNewPersonalCompetitonWasAdd(cmbSportTypes.getValue(), cmbCompetitionType.getValue(),
							cmbReferees.getValue(), cmbStadiums.getValue());	
					}
				}
				else {
					for(OlympicUIEventListener l : allListeners) {
						l.viewFireNewTeamCompetitonWasAdd(cmbSportTypes.getValue(), cmbCompetitionType.getValue(),
								cmbReferees.getValue(), cmbStadiums.getValue());	
						}
				}		
			}
		});
		
		btnMenuCountryList = new Button("Country"); 
		btnAddCountry = new Button("Add Country");

		GridPane.setRowIndex(btnMenuCountryList, 2);
		GridPane.getColumnIndex(btnMenuCountryList);
		
		btnMenuCountryList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setMenu(gpRoot);
				lblAddCountry = new Label("Add country:");
				GridPane.setConstraints(lblAddCountry, 5, 2);
				//
				tfAddCountry = new TextField();
				GridPane.setConstraints(tfAddCountry, 6, 2);
				//
				GridPane.setConstraints(btnAddCountry, 7, 2);
				//
				GridPane.setConstraints(cmbCountries, 6, 3);
				//
				cmbCountries.setPromptText("Countries");
				gpRoot.getChildren().addAll(lblAddCountry, tfAddCountry, btnAddCountry, cmbCountries);	
			}
		});
		
		btnAddCountry.setOnAction(new EventHandler <ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for(OlympicUIEventListener l : allListeners) {
					l.viewFireNewCountryWasAdd(tfAddCountry.getText());
				}
			}	
		});
		
		btnMenuStadiumList = new Button("Stadium");
		btnSetStadium = new Button("Add Stadium");
		GridPane.setRowIndex(btnMenuStadiumList, 3);
		GridPane.getColumnIndex(btnMenuStadiumList);
		
		tfStadiumName = new TextField();
		tfStadiumLocation = new TextField();
		tfStadiumNumOfSeats = new TextField();

		cmbStadiums = new ComboBox<Stadium>();

		btnMenuStadiumList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setMenu(gpRoot);
				lblStadiumName = new Label("Stadium name:");
				GridPane.setConstraints(lblStadiumName, 5, 1);
				//
				GridPane.setConstraints(tfStadiumName, 6, 1);
				//
				lblStadiumLocation = new Label("Stadium location:");
				GridPane.setConstraints(lblStadiumLocation, 5, 2);
				//
				GridPane.setConstraints(tfStadiumLocation, 6, 2);
				//
				lblNumOfSeats = new Label("Number of seats:");
				GridPane.setConstraints(lblNumOfSeats, 5, 3);
				//
				GridPane.setConstraints(tfStadiumNumOfSeats, 6, 3);
				//
				GridPane.setConstraints(btnSetStadium, 9, 2);
				//
				cmbStadiums.setPromptText("Stadiums");
				GridPane.setConstraints(cmbStadiums, 6, 4);
				
				gpRoot.getChildren().addAll(lblStadiumName, tfStadiumName, lblStadiumLocation, tfStadiumLocation, 
						lblNumOfSeats,tfStadiumNumOfSeats, btnSetStadium, cmbStadiums);
			}
		});
		
		btnSetStadium.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for(OlympicUIEventListener l : allListeners) {
					l.viewFireNewStadiumWasAdd(tfStadiumName.getText() ,tfStadiumLocation.getText(),
						 Integer.parseInt(tfStadiumNumOfSeats.getText()));
				}
			}
		});

		
		btnMenuRefereeList = new Button("Referee"); 
		GridPane.setRowIndex(btnMenuRefereeList, 4);
		GridPane.getColumnIndex(btnMenuRefereeList);
		
		btnMenuRefereeList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setMenu(gpRoot);
				lblRefereeName = new Label("Referee name:");
				GridPane.setConstraints(lblRefereeName, 5, 1);
				//
				GridPane.setConstraints(tfRefereeName, 6, 1);
				//
				lblRefereeCountry = new Label("Referee country:");
				GridPane.setConstraints(lblRefereeCountry, 5, 2);
				//
				GridPane.setConstraints(cmbCountries, 6, 2);
				//
				lblRefereeList = new Label("referees type:");
				GridPane.setConstraints(lblRefereeList, 5, 3);
				//
				GridPane.setConstraints(btnAddReferee, 9, 2);
				//
				cmbSportTypes.setPromptText("Types");
				GridPane.setConstraints(cmbSportTypes, 6, 3);
	
				gpRoot.getChildren().addAll(lblRefereeName, tfRefereeName, lblRefereeCountry, lblRefereeList, cmbCountries,
						cmbSportTypes, btnAddReferee); 
			}
		});
		
		tfRefereeName = new TextField();
		btnAddReferee = new Button("Add referee");
		
		btnAddReferee.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for(OlympicUIEventListener l : allListeners) {	
					l.viewFireNewRefereeWasCreate(tfRefereeName.getText() , cmbCountries.getValue(), 
							cmbSportTypes.getSelectionModel().getSelectedItem());
				}
			}
		});
		
		
		btnMenuAthletesList = new Button("Athletes");
		btnAddAthlet = new Button("Add Athlet");
		GridPane.setRowIndex(btnMenuAthletesList, 5);
		GridPane.getColumnIndex(btnMenuAthletesList);
		
		btnMenuAthletesList.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setMenu(gpRoot);
				lblAthletName = new Label("Athlet name:");
				GridPane.setConstraints(lblAthletName, 5, 1);
				//
				tfAthletName = new TextField();
				GridPane.setConstraints(tfAthletName, 7, 1);
				//
				lblAthletCountry = new Label("Athlet country:");
				GridPane.setConstraints(lblAthletCountry, 5, 2);
				//
				GridPane.setConstraints(cmbCountries, 7, 2);
				//
				lblAthletesList = new Label("Athlete type:");
				GridPane.setConstraints(lblAthletesList, 5, 3);
				//
				cmbSportTypes.setPromptText("Types");
				GridPane.setConstraints(cmbSportTypes, 7, 3);
				//
				lblNumOfAthletMedals = new Label("num of medals:");
				GridPane.setConstraints(lblNumOfAthletMedals, 5, 4);
				//
				tfNumOfAthletMedals = new TextField();
				GridPane.setConstraints(tfNumOfAthletMedals, 7, 4);
				//
				GridPane.setConstraints(btnAddAthlet, 8, 2);
		
				gpRoot.getChildren().addAll(lblAthletName, tfAthletName, lblAthletCountry, cmbCountries, lblNumOfAthletMedals,
						tfNumOfAthletMedals, lblAthletesList, cmbSportTypes, btnAddAthlet); 
			}
		});
		
		tfAthletName = new TextField();
		tfNumOfAthletMedals = new TextField();
		
		btnAddAthlet.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				for(OlympicUIEventListener l : allListeners) {	
					l.viewFireNewAthletWasCreate(tfAthletName.getText(), cmbCountries.getValue(),  
							Integer.parseInt(tfNumOfAthletMedals.getText()), cmbSportTypes.getSelectionModel().getSelectedItem());
				}
			}
		});
		
		btnMenuStartOlympic = new Button("Start Olympic games!"); 
		GridPane.setRowIndex(btnMenuStartOlympic, 6);
		GridPane.getColumnIndex(btnMenuStartOlympic);
		
		btnMenuStartOlympic.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setMenu(gpRoot);
				lblShowPersonalCompDetails = new Label("All Personal Competitions:");
				GridPane.setConstraints(lblShowPersonalCompDetails, 6, 0);
				//
				cmbAllPersonalComp.setPromptText("Personal competition -->");
				GridPane.setConstraints(cmbAllPersonalComp, 6, 1);
				//
				lblShowTeamCompDetails = new Label("All Team Competitions:");
				GridPane.setConstraints(lblShowTeamCompDetails, 6, 7);
				//
				cmbAllTeamComp.setPromptText("Team competition -->");
				GridPane.setConstraints(cmbAllTeamComp, 6, 8);
				//
				GridPane.setConstraints(btnShowWinners, 8, 1);
				//
				gpRoot.getChildren().addAll(lblShowPersonalCompDetails, cmbAllPersonalComp, lblShowTeamCompDetails, 
						cmbAllTeamComp, btnShowWinners);
			}
		});
		
		setOlimpic = new Button("set olimpic");
		GridPane.setRowIndex(setOlimpic, 7);
		GridPane.getColumnIndex(setOlimpic);
		
//		setOlimpic.setOnAction(new EventHandler<ActionEvent>() {
//			public void handle(ActionEvent e) {
//				for(OlympicUIEventListener l : allListeners) {	
//					l.viewFireOlympicAdded("Roi", "2020", "2021");
//					//l.viewFireNewStadiumWasAdd("tedi","Jerusaleam", 45000);
//					//l.viewFireNewRefereeWasCreate("Daniel", new Country("Israel"), SportType.jumping);
//					l.viewFireNewAthletWasCreate("Avi", new Country("Poland"), 12, SportType.jumping);
//					l.viewFireNewPersonalCompetitonWasAdd(SportType.jumping, TypesOfCompetition.PersonalCompetition,
//							new Referee("Daniel", new Country("Israel"), SportType.jumping), new Stadium("tedi","Jerusaleam", 45000));
//							
//				}
//
//			}
//		});
//		
		
		//need to fix and complete the event
		btnShowWinners = new Button("Show winners:");
		btnShowWinners.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				
			}
		});
		
		setMenu(gpRoot);
		theStage.setScene(new Scene(gpRoot, 650, 600));
		theStage.show();	
	}
	
	private void setMenu(GridPane gpRoot) {
		gpRoot.getChildren().clear();
		gpRoot.getChildren().addAll(btnMenuCreateOlympic, btnMenuCompetitionType, btnMenuCountryList, btnMenuStadiumList,
				btnMenuRefereeList, btnMenuAthletesList, btnMenuStartOlympic, setOlimpic);
	}
	
	@Override
	public void registerListener(OlympicController oc) {
		Boolean res = allListeners.add(oc);	
	}
	
	@Override
	public void setNewOlympicIsCreated() {
		JOptionPane.showMessageDialog(null, "Olympic " + tfOlympicName.getText() + " was create! ");
	}
	
	@Override
	public void setNewPersonalCompetition(Competition pc) {
		allCompetitions.add(pc);
		String tempComp = pc.getCompetitionNumber() + pc.getCmpType().name();
		System.out.println(tempComp);
		cmbAllPersonalComp.getItems().add(tempComp);
		cmbAllPersonalComp.getSelectionModel().clearSelection();
		JOptionPane.showMessageDialog(null, "New competition " + pc + " was create! ");
	}
	
	@Override
	public void setNewTeamCompetition(Competition tc) {
		allCompetitions.add(tc);
		cmbAllTeamComp.getItems().add(tc.getCompetitionNumber() + tc.getCmpType().toString());
		cmbAllTeamComp.getSelectionModel().clearSelection();
		JOptionPane.showMessageDialog(null, "New competition " + tc + " was create! ");
	}
	
	@Override
	public void setNewCountry(Country countryName) {
		cmbCountries.getItems().add(countryName);
		tfAddCountry.clear();
		cmbCountries.getSelectionModel().clearSelection();
		JOptionPane.showMessageDialog(null, "New country " + countryName + " was create! ");	
	}
	
	@Override
	public void setNewStadium(Stadium stadium) {
		cmbStadiums.getItems().add(stadium);
		tfStadiumName.clear();
		tfStadiumLocation.clear();
		tfStadiumNumOfSeats.clear();
		cmbStadiums.getSelectionModel().clearSelection();
		JOptionPane.showMessageDialog(null, "New stadium " + stadium + " was create! ");	
	}
	
	@Override
	public void setNewReferee(Referee referee) {
		cmbReferees.getItems().add(referee);
		tfRefereeName.clear();
		cmbSportTypes.getSelectionModel().clearSelection();
		cmbCountries.getSelectionModel().clearSelection();
		JOptionPane.showMessageDialog(null, "New Referee " + referee + " was create! ");
	}
	
	@Override
	public void setNewAthlet(Athlete athlet) {
		System.out.println(athlet.toString());
		cmbAthlets.getItems().add(athlet);
		tfAthletName.clear();
		tfNumOfAthletMedals.clear();
		cmbSportTypes.getSelectionModel().clearSelection();
		cmbCountries.getSelectionModel().clearSelection();
		JOptionPane.showMessageDialog(null, "New Athlet " + athlet + " was create! ");
	}

}

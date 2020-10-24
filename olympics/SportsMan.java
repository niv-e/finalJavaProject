package olympics;

public class SportsMan {
	
	SportType sportType; //custom enum
	
	protected String name;
	protected Country country;
	
	public SportsMan(String name , Country country , SportType sportType) {
		this.name = name;
		this.country  = country;
		this.sportType = sportType;
	}

	public SportType getSportType() {
		return sportType;
	}

	public String getName() {
		return name;
	}

	public Country getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "name " + name + " sportType " + sportType +  " from " + country;
	}
	
	
	

}

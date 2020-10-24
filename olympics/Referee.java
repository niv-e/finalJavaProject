package olympics;

public class Referee extends SportsMan {
	
	SportType Jurisdiction;
	
	public Referee (String name , Country country , SportType Jurisdiction) {
		super(name , country , Jurisdiction);
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
	

}

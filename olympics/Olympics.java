package olympics;

public class Olympics {

	private String name;
	private String startDate;
	private String endDate;
	
	public Olympics(String name, String startDate, String endDate) {
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	//getters

	public String getName() {
		return name;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	@Override
	public String toString() {
		return "Olympics [name=" + name + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}
	
	
}

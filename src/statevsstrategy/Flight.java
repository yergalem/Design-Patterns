package statevsstrategy;

public class Flight {
	
	String flightID;
	String flightStatus;
	String flightType;
	int numberOfPassangers;

	public Flight(int passangersSize,String flightID, String flightStatus, String flightType) {
		this.numberOfPassangers = passangersSize;
		this.flightID = flightID;
		this.flightStatus = flightStatus;
		this.flightType = flightType;
	}

	public String getFlightID() {
		return flightID;
	}

	public void setFlightID(String flightID) {
		this.flightID = flightID;
	}

	public String getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(String flightStatus) {
		this.flightStatus = flightStatus;
	}

	public String getFlightType() {
		return flightType;
	}

	public void setFlightType(String flightType) {
		this.flightType = flightType;
	}

	public String toString() {
		return flightID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flightID == null) ? 0 : flightID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (flightID == null) {
			if (other.flightID != null)
				return false;
		} else if (!flightID.equals(other.flightID))
			return false;
		return true;
	}
	

}

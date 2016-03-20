package WorkApplication;

import java.util.ArrayList;
import java.util.List;

public class City {
	private boolean isFestive;
	private int distance;
	private int cityNumber;
	private List<City> neighbours;
	
	public City(int cityNumber) {
		if (cityNumber == 1) {
			setFestive(true);
		} else {
			setFestive(false);
		}
		setDistance(0);
		neighbours = new ArrayList<City>();
		this.cityNumber = cityNumber;
	}

	public boolean isFestive() {
		return isFestive;
	}

	public void setFestive(boolean isFestive) {
		this.isFestive = isFestive;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getCityNumber() {
		return cityNumber;
	}

	public void setCityNumber(int cityNumber) {
		this.cityNumber = cityNumber;
	}

	public List<City> getNeighbours() {
		return neighbours;
	}

	public void addNeighbour(City neighbour) {
		this.neighbours.add(neighbour);
	}
	
	
}

package WorkApplication;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int numberOfCities;
	static int numberOfQueries;
	static City[] island = null;
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		numberOfCities = s.nextInt();
		numberOfQueries = s.nextInt();
		island = new City[numberOfCities+1];
		
		for (int i=1; i<numberOfCities; i++) {
			int firstCity = s.nextInt();
			int secondCity = s.nextInt();
			connectCity(firstCity, secondCity);
		}
		
		for (int i=1; i<=numberOfQueries;i++) {
			int firstParam = s.nextInt();
			int secondParam = s.nextInt();
			
			if (firstParam == 1) {
				island[secondParam].setFestive(true);
			} else if(firstParam == 2) {
				System.out.println(findClosestFestiveCity(secondParam));
			}
		}
		s.close();
	}

	private static int findClosestFestiveCity(int startCity) {
		if (island[startCity].isFestive()){
			return 0;
		}
		Queue<City> toProcess = new LinkedList<>();
		toProcess.add(island[startCity]);
		boolean visited[] = new boolean[numberOfCities+1];
		visited[startCity] = true;
		island[startCity].setDistance(0);
		while(!toProcess.isEmpty()) {
			City city = toProcess.remove();
			for (City neighbour:city.getNeighbours()) {
				if (!visited[neighbour.getCityNumber()]) {
					visited[neighbour.getCityNumber()] = true;
					toProcess.add(neighbour);
					neighbour.setDistance(city.getDistance()+1);
				}
				if (neighbour.isFestive()) {
					return neighbour.getDistance();
				}
			}
		}
		return -1;
	}

	private static void connectCity(int firstCity, int secondCity) {
		if (island[firstCity] == null) {
			island[firstCity] = new City(firstCity);
		}
		if (island[secondCity] == null) {
			island[secondCity] = new City(secondCity);
		}
		island[firstCity].addNeighbour(island[secondCity]);
		island[secondCity].addNeighbour(island[firstCity]);
		
	}
}

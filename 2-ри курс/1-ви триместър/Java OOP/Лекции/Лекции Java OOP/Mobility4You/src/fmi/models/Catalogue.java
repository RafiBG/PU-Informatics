package fmi.models;

import java.util.ArrayList;
import java.util.Comparator;

import fmi.util.DBOperations;
import fmi.util.Parser;

public class Catalogue {
	
	private ArrayList<AbstractCar> list = new ArrayList<>();
	
	public void sortByBrand() {
		Comparator<AbstractCar> byBrand = (AbstractCar car1, AbstractCar car2)
				-> car1.getBrand().compareTo(car2.getBrand());
		list.sort(byBrand);
	}
	
	public void sortByType() {
		
		Comparator<AbstractCar> byType = (AbstractCar car1, AbstractCar car2)
				-> car1.getClass().getName().compareTo(car2.getClass().getName());
		list.sort(byType);
		
	}
	
	public void printCatalogue() {
		for(AbstractCar car : list) {
			System.out.println(car);
		}
	}
	
	public ArrayList<AbstractCar> getCarsFromCatalogue(){
		return list;
	}
	
	public void loadFromFile(String path) {
		
		ArrayList<String> rows = DBOperations.readRowsFromFile(path);
		
		for(String row : rows) {
			addCar(Parser.parseRow(row));
		}
		
	}
	
	public void writeCatalogueToFile(String path) {
		DBOperations.writeCarsToFile(path, list);
	}
	
	public void addCar(AbstractCar car) {
		list.add(car);
	}

}

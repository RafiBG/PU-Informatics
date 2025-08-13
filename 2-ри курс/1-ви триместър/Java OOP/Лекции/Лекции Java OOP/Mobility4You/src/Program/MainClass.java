package Program;

import fmi.models.Catalogue;
import fmi.models.ElCar;

public class MainClass {

	public static void main(String[] args) {
		
		Catalogue myCatalogue = new Catalogue();
		myCatalogue.loadFromFile("C:/Users/FMI/Desktop/input.txt");
		myCatalogue.sortByType();
		myCatalogue.printCatalogue();
		myCatalogue.addCar(new ElCar("Nqma", "Karuca", 1, 0, 1400));
		myCatalogue.writeCatalogueToFile("C:/Users/FMI/Desktop/output.txt");
		
		
	}

}

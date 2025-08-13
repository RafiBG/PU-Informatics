package fmi.util;

import fmi.models.AbstractCar;
import fmi.models.ElCar;
import fmi.models.GasCar;
import fmi.models.HybCar;

public class Parser {
	
	static String brand, model, type;
	static int powEng, price, capacity;
	static float engDis;
	
	public static AbstractCar parseRow(String row) {
		
		String[] attributes = row.split(", ");
		type = attributes[0].split(" ")[0];
		brand = attributes[0].split(" ")[1];
		model = attributes[1];
		price = Integer.parseInt(attributes[attributes.length-1].split(" ")[0]);
		
		switch (type) {
		case "ELECTRIC_CAR": return createElCar(attributes);
		case "GAS_CAR" : return createGasCar(attributes);
		case "HYBRID_CAR" : return createHybCar(attributes);

		default:
			return null;
		}
	}// end parseRow()
	
	public static ElCar createElCar(String[] attributes) {
		
		powEng = Integer.parseInt(attributes[2].replace("KW", ""));
		capacity = Integer.parseInt(attributes[3].replace("Ah", ""));
		
		return new ElCar(brand, model, powEng, capacity, price);
	}
	
	public static GasCar createGasCar(String[] attributes) {
		
		powEng = Integer.parseInt(attributes[3].replace("KW", ""));
		engDis = Float.parseFloat(attributes[2].replace("L", ""));
		
		return new GasCar(brand, model, engDis, powEng, price);
	}
	
	public static HybCar createHybCar(String[] attributes) {
		
		powEng = Integer.parseInt(attributes[3].replace("KW", ""));
		engDis = Float.parseFloat(attributes[2].replace("L", ""));
		capacity = Integer.parseInt(attributes[4].replace("Ah", ""));
		
		return new HybCar(brand, model, engDis, powEng, capacity, price);
	}

}

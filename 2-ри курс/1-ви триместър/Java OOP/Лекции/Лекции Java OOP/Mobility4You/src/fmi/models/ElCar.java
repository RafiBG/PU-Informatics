package fmi.models;

public class ElCar extends AbstractCar {
	
	private int capacity;

	public ElCar(String brand, String model, int powEng, int capacity, int price) {
		super(brand, model, powEng, price);
		this.capacity = capacity;
	}
	
	
	@Override
	public String toString() {
		
		String middle = this.getPowEng() + "KW, " + this.getCapacity() + "Ah";
		
		return "ELECTRIC_CAR " + super.printInfo(middle);
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	

}

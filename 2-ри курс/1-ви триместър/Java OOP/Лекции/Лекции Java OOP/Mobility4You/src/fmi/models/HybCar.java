package fmi.models;

public class HybCar extends AbstractCar{
	
	private float engDis;
	private int capacity;

	public HybCar(String brand, String model, float engDis, int powEng, int capacity, int price) {
		super(brand, model, powEng, price);
		this.engDis = engDis;
		this.capacity = capacity;
	}
	

	@Override
	public String toString() {

		String middle = this.getEngDis() + "L, " + this.getPowEng() + "KW, " 
				+ this.getCapacity() + "Ah";
		
		return "HYBRID_CAR " + super.printInfo(middle);
	}


	public float getEngDis() {
		return engDis;
	}

	public void setEngDis(float engDis) {
		this.engDis = engDis;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	

}

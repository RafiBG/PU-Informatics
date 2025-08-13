package fmi.models;

public class GasCar extends AbstractCar{
	
	private float engDis;

	public GasCar(String brand, String model, float engDis, int powEng, int price) {
		super(brand, model, powEng, price);
		this.engDis = engDis;
	}
	
	@Override
	public String toString() {

		String middle = this.getEngDis() + "L, " + this.getPowEng() + "KW";
		
		return "GAS_CAR " + super.printInfo(middle);
	}



	public float getEngDis() {
		return engDis;
	}

	public void setEngDis(float engDis) {
		this.engDis = engDis;
	}
	
	

}

package fmi.models;

public abstract class AbstractCar {

	private String model;
	private String brand;
	private int powEng;
	private int price;

	public AbstractCar(String brand, String model, int powEng, int price) {
		super();
		this.model = model;
		this.brand = brand;
		this.powEng = powEng;
		this.price = price;
	}
	
	public String printInfo(String middle) {
		
		return this.brand + ", " + this.model + ", " + middle + ", " + this.price + " euro";
		
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPowEng() {
		return powEng;
	}

	public void setPowEng(int powEng) {
		this.powEng = powEng;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}

import java.util.Random;

public class Motorcycle extends Vehicle {
	private Random rand = new Random();
	
	private String helmetType;

	public Motorcycle(String vehicleType, String manufacturer, String vehicleName, String vehicleColor,
			Integer fuelCapacity, String helmetType) {
		super(vehicleType, manufacturer, vehicleName, vehicleColor, fuelCapacity);
		this.helmetType = helmetType;
	}

	public String getHelmetType() {
		return helmetType;
	}

	public void setHelmetType(String helmetType) {
		this.helmetType = helmetType;
	}

	@Override
	public Integer sellPrice() {
		int result;
		result = 12000000 + (95000 * this.getFuelCapacity());
		return result;
	}

	@Override
    public void print() {
        System.out.printf("%-12s | %-12s | %-15s | %-5d |\n", this.getVehicleName(), this.getManufacturer(), this.getVehicleID(), sellPrice());
    }

	@Override
    public String generateID() {
        return String.format("MOTO-%03d-%s", rand.nextInt(1000), helmetType.toUpperCase().substring(0, 3));
    }
	
	

	

}

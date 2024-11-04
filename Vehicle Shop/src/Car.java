import java.util.Random;

public class Car extends Vehicle {
	
	private Random rand = new Random();
	
	private Integer numberOfSeats;

	public Car(String vehicleType, String manufacturer, String vehicleName, String vehicleColor, Integer fuelCapacity, Integer numberOfSeats) {
		super(vehicleType, manufacturer, vehicleName, vehicleColor, fuelCapacity);
		this.numberOfSeats = numberOfSeats;
		// TODO Auto-generated constructor stub
	}

	public Integer getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(Integer numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}
	
	@Override
	public void print() {
		for(int i = 0; i < 80; i++) {
			// TODO Auto-generated method stub
			System.out.printf("%-5d | %-12s | %-12s | %-15s | %-5d |\n", i+1, this.getVehicleName(), this.getManufacturer(), this.getVehicleID(), sellPrice());
		}
		
	}

	@Override
	public Integer sellPrice() {
		int result;
		result = 210500000 + (100000 * this.getFuelCapacity());
		return result;
	}

	@Override
	public String generateID() {
        return String.format("CA-%03d-%d", rand.nextInt(1000), this.getNumberOfSeats());
    }
	
	

}


public abstract class Vehicle {
	private String vehicleType;
	private String manufacturer;
	private String vehicleName;
	private String vehicleColor;
	private Integer fuelCapacity;
	private String vehicleID;

	public Vehicle(String vehicleType, String manufacturer, String vehicleName, String vehicleColor, Integer fuelCapacity) {
        this.vehicleType = vehicleType;
        this.manufacturer = manufacturer;
        this.vehicleName = vehicleName;
        this.vehicleColor = vehicleColor;
        this.fuelCapacity = fuelCapacity;
        this.vehicleID = generateID(); // Initialize vehicle ID
    }

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

	public String getVehicleColor() {
		return vehicleColor;
	}

	public void setVehicleColor(String vehicleColor) {
		this.vehicleColor = vehicleColor;
	}

	public Integer getFuelCapacity() {
		return fuelCapacity;
	}

	public void setFuelCapacity(Integer fuelCapacity) {
		this.fuelCapacity = fuelCapacity;
	}

	public String getVehicleID() {
        return vehicleID;
    }
	
	public abstract void print();
	
	public abstract Integer sellPrice();
	
	public abstract String generateID();
	
	
	
	
	
	
	
	

}

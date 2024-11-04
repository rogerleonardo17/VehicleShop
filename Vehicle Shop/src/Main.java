import java.util.Scanner;
import java.util.Vector;

public class Main {
    private Scanner scan = new Scanner(System.in);
    private Vector<Vehicle> listVehicle = new Vector<>();

    private void menu() {
        int option = -1;

        do {
            System.out.println("Vehicle Shop");
            System.out.println("=============");
            System.out.println("1. Add New Vehicle");
            System.out.println("2. View Vehicle List");
            System.out.println("3. Remove Vehicle");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            option = scan.nextInt();
            scan.nextLine();

            switch (option) {
                case 1:
                    addNewVehicle();
                    break;
                case 2:
                    viewVehicleList();
                    break;
                case 3:
                    removeVehicle();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option < 1 || option > 4);
    }

    private void removeVehicle() {
        if (listVehicle.isEmpty()) {
            System.out.println("No vehicle added to the list yet.");
            return;
        } else {
            viewVehicleList(); // Display the list before removal
        }

        Integer vehicleInput;
        do {
            System.out.print("Select vehicle [1 - " + listVehicle.size() + "]: ");
            vehicleInput = scan.nextInt();
        } while (vehicleInput < 1 || vehicleInput > listVehicle.size());

        listVehicle.remove(vehicleInput - 1); // Correct the index for removal
        System.out.println("Vehicle successfully removed!");

        System.out.println("Press enter to continue");
        scan.nextLine();
    }

    private void viewVehicleList() {
        if (listVehicle.isEmpty()) {
            System.out.println("No vehicle added to the list yet.");
            return;
        } else {
            System.out.println("Vehicle List");
            System.out.println("============");
            System.out.printf("%-5s | %-12s | %-12s | %-15s | %-5s |\n", "No.", "Vehicle Name", "Manufacturer", "Vehicle ID", "Sell Price");
            for (int i = 0; i < listVehicle.size(); i++) {
                System.out.printf("%-5d | ", (i + 1));
                listVehicle.get(i).print();
            }
        }
        System.out.println("Press enter to continue...");
        scan.nextLine();
    }

    private void addNewVehicle() {
        String vehicleType;
        String manufacturer;
        String vehicleName;
        String vehicleColor;
        Integer fuelCapacity;

        do {
            System.out.print("Input Vehicle Type [Car | Motorcycle]: ");
            vehicleType = scan.nextLine();
        } while (!vehicleType.equals("Car") && !vehicleType.equals("Motorcycle"));

        do {
            System.out.print("Input Manufacturer [Honda | Suzuki | Yamaha]: ");
            manufacturer = scan.nextLine();
        } while (!manufacturer.equals("Honda") && !manufacturer.equals("Suzuki") && !manufacturer.equals("Yamaha"));

        do {
            System.out.print("Input Vehicle Name [6..20]: ");
            vehicleName = scan.nextLine();
        } while (vehicleName.length() < 6 || vehicleName.length() > 20);

        do {
            System.out.print("Input Vehicle Color: ");
            vehicleColor = scan.nextLine();
        } while (vehicleColor.length() < 1);

        do {
            System.out.print("Input Fuel Capacity [min. 1 lt]: ");
            fuelCapacity = scan.nextInt();
        } while (fuelCapacity < 1);

        if (vehicleType.equals("Car")) {
            Integer numberOfSeats;
            do {
                System.out.print("Input Number of Seats [1-8]: ");
                numberOfSeats = scan.nextInt();
            } while (numberOfSeats < 1 || numberOfSeats > 8);
            listVehicle.add(new Car(vehicleType, manufacturer, vehicleName, vehicleColor, fuelCapacity, numberOfSeats));
        } else if (vehicleType.equals("Motorcycle")) {
            scan.nextLine(); // Consume newline
            String helmetType;
            do {
                System.out.print("Input Helmet Type [Full face | Modular | Off-road]: ");
                helmetType = scan.nextLine();
            } while (!helmetType.equalsIgnoreCase("Full face") && !helmetType.equalsIgnoreCase("Modular") && !helmetType.equalsIgnoreCase("Off-road"));
            listVehicle.add(new Motorcycle(vehicleType, manufacturer, vehicleName, vehicleColor, fuelCapacity, helmetType));
        }

        System.out.println("Success! Added new vehicle.");
        System.out.println("Press enter to continue...");
        scan.nextLine();
    }

    public Main() {
        menu();
    }

    public static void main(String[] args) {
        new Main();
    }
}

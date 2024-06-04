import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLot parkingLot = null;

        while (true) {
            System.out.println("1. create_parking_lot [parkingId] [numOfFloor] [numOfSlotPerFloor]");
            System.out.println("2. park_vehicle [vehicleType] [regNum] [color]");
            System.out.println("3. unpark_vehicle [parkingTicketNum]");
            System.out.println("4. display free_count [vehicleType]");
            System.out.println("5. exit");
            System.out.print("command: ");
            String cmd = sc.nextLine();
            if (cmd.equals("exit")) {
                break;
            }
            String[] cmds = cmd.split(" ");
            String command = cmds[0];
            try {
                switch (command) {
                    case "create_parking_lot":
                        parkingLot = new ParkingLot(Integer.parseInt(cmds[2]), Integer.parseInt(cmds[3]), cmds[1]);
                        break;
                    case "park_vehicle": {
                        VehicleType vehicleType = VehicleType.valueOf(cmds[1]);
                        String regNo = cmds[2];
                        Color color = Color.valueOf(cmds[3]);
                        String ticketNumber = parkingLot.parkVehicle(new Vehicle(vehicleType, regNo, color));
                        if (ticketNumber.equals("PARKING LOT FULL")) {
                            System.out.println("PARKING LOT FULL");
                        } else {
                            System.out.println("Parked. TicketNumber: " + ticketNumber);
                        }
                        break;
                    }
                    case "unpark_vehicle":
                        parkingLot.unParkVehicle(cmds[1]);
                        break;
                    case "display":
                        if (cmds[1].equals("free_count")) {
                            parkingLot.displayFreeCount(VehicleType.valueOf(cmds[2]));
                        }
                        break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Not enough parameter");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        sc.close();
    }
}
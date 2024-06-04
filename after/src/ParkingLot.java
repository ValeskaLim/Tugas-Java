import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private String parkingLotId;
    private List<Floor> floors;

    public ParkingLot(int floorsCount, int slotsPerFloor, String parkingLotId){
        floors = new ArrayList<>(floorsCount);
        for(int i = 0; i < floorsCount; i++){
            Floor floor = new Floor(slotsPerFloor);
            floors.add(floor);
        }

        this.parkingLotId = "PR1234";
        System.out.println("Created parkingLot with "+ floorsCount +" floors and "+ slotsPerFloor +" slots per floor");
    }

    public String parkVehicle(Vehicle vehicle){
        String ticketNumber = parkingLotId+"_"+getTicket(vehicle);
        if(ticketNumber.equals(parkingLotId+"_"+"NA"))
            return "PARKING LOT FULL";
        return ticketNumber;
    }

    public String getTicket(Vehicle vehicle){
        int floorId = 1;
        for(Floor floor : floors){
            List<Slot> slots = floor.getUnmodifiableSlots();

            // implement getter for vehicle type from vehicle
            if(vehicle.getVehicleType().equals(VehicleType.TRUCK)){
                if(!slots.get(0).getOccupied()){
                    slots.get(0).setOccupied(true);
                    slots.get(0).setVehicle(vehicle);
                    return floorId+"_1";
                }
            } else if(vehicle.getVehicleType().equals(VehicleType.BIKE)){
                if(!slots.get(1).getOccupied()){
                    slots.get(1).setOccupied(true);
                    slots.get(1).setVehicle(vehicle);
                    return floorId+"_2";
                }
                if(!slots.get(2).getOccupied()){
                    slots.get(2).setOccupied(true);
                    slots.get(2).setVehicle(vehicle);
                    return floorId+"_3";
                }
            }
            for(int i = 3; i< slots.size(); i++){
                if(!slots.get(i).getOccupied()) {
                    if (vehicle.getVehicleType().equals(VehicleType.CAR)) {
                        slots.get(i).setOccupied(true);
                        slots.get(i).setVehicle(vehicle);
                        return floorId + "_" + (i + 1);
                    }
                }
            }
            floorId++;
        }
        return "NA";
    }

    public void unParkVehicle(String ticketId){
        String[] ticket = ticketId.split("_");
        try {
            int floorNum = Integer.parseInt(ticket[1]);
            int slotNum = Integer.parseInt(ticket[2]);
            System.out.println("floor "+floorNum + " slotNum "+slotNum);
            Slot slot = floors.get(floorNum-1).getUnmodifiableSlots().get(slotNum-1);
            if(!slot.getOccupied()){
                System.out.println("Invalid Ticket");
            } else{
                System.out.println("Unparked Vehicle with Registration Number: "+ slot.getVehicle().getRegistrationNumber() +" Color: "+slot.getVehicle().getColor());
                slot.setOccupied(false);
                slot.setVehicle(null);
            }
        }catch (Exception e){
            System.out.println("Invalid Ticket");
        }
    }

    public void displayFreeCount(VehicleType vehicleType){
        int floorId = 1;
        for(Floor floor: floors){
            int freeSlots = 0;
            List<Slot> slots = floor.getUnmodifiableSlots();

            if(vehicleType.equals(VehicleType.TRUCK)){
                if(!slots.get(0).getOccupied()){
                    freeSlots++;
                }
            } else if(vehicleType.equals(VehicleType.BIKE)){
                if(!slots.get(1).getOccupied()){
                    freeSlots++;
                }
                if(!slots.get(2).getOccupied()){
                    freeSlots++;
                }
            }
            for(int i = 3; i< slots.size(); i++){
                if(!slots.get(i).getOccupied()) {
                    if (vehicleType.equals(VehicleType.CAR)) {
                        freeSlots++;
                    }
                }
            }

            System.out.println("Number of free slots for "+ vehicleType + " on floor "+floorId + ": "+freeSlots);
            floorId++;
        }
    }

}

public class Vehicle {
    private VehicleType vehicleType;
    private String registrationNumber;
    private Color color;

    public Vehicle(VehicleType vehicleType, String registrationNumber, Color color) {
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
        this.color = color;
    }
    
// getter setter vehicle type
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
    
// getter setter registration number
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
    
// getter setter vehicle color
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Floor {
    private List<Slot> slots = new ArrayList<>();

    public Floor(int n){
        for(int i = 0;i < n;i++){
            Slot slot = new Slot();
            this.slots.add(slot);
        }
    }

    public List<Slot> getUnmodifiableSlots() {
        return Collections.unmodifiableList(slots);
    }
    
    public void addSlot(Slot slot) {
    	slots.add(slot);
    }

    public void removeSlot(Slot slot) {
    	slots.remove(slot);
    }
}

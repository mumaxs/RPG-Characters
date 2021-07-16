package items;

/**
 * Abstract class Item that holds shared attributes.
 */
public abstract class Item {
    private Slot slot;
    private int reqLevel;
    private String name;

    public Item(Slot slot, int reqLevel, String name){
        this.slot = slot;
        this.reqLevel = reqLevel;
        this.name = name;
    }
    public Slot getSlot(){
        return this.slot;
    }
    public int getReqLevel(){
        return this.reqLevel;
    }
}

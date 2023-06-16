package shop;

public class Item {
    private int itemId;
    private String itemName;
    private int quantity;
    private int pricePerUnit;

    public Item(int itemId, String itemName, int quantity, int pricePerUnit) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return  "itemId=" + itemId +
                ",\t itemName='" + itemName + '\'' +
                ",\t quantity=" + quantity +
                ",\t pricePerUnit=" + pricePerUnit
                ;
    }
}

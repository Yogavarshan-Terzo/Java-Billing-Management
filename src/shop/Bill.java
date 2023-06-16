package shop;

import java.util.ArrayList;
import java.util.List;

public class Bill {
    private int billId;
    private String customerName;
    private double billAmount = 0.0;
    List<Item> itemList = new ArrayList<>();

    public Bill(int billId, String customerName) {
        this.billId = billId;
        this.customerName = customerName;
    }

    public Bill(int billId) {
        this.billId = billId;
        this.customerName = "anonymous";
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    public void addItem(Item item, int purchaseQuantity){
        item.setQuantity(purchaseQuantity);
        itemList.add(item);
        billAmount += (item.getPricePerUnit()*purchaseQuantity);
    }

    @Override
    public String toString() {
        return  "Bill Receipt\n" +
                "billId=" + billId +
                "\t customerName='" + customerName + '\'' +
                "\t Total Amount=" + billAmount +
                "\n Items :" + itemList.toString()
                ;
    }
}

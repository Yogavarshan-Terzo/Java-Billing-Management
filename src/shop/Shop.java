package shop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Shop {
    List<Bill> bills = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public void showMenu(){
        System.out.println("Options");
        System.out.println("1.New Bill");
        System.out.println("2.Check Bill");
        System.out.println("3.Remove Bill");
        System.out.println("4.Exit");
    }

    public void showItems(List<Item> itemList){
        for(var item : itemList){
            System.out.println(item.toString());
        }
    }


    public void run(){
        List<Item> itemsAvailable = new ArrayList<>();
        Collections.addAll(itemsAvailable,new Item(1,"Apple",10,50),
                                          new Item(2,"Mango",15, 20),
                                          new Item(3,"Orange",10,50),
                                          new Item(4,"Banana",50,10)
                          );
        System.out.println("Welcome,Have a nice day");
        showMenu();
        int option = 1;
        System.out.println("Enter Any Option :");
        try {
            option = scanner.nextInt();
            if (option < 1 || option > 4) {
                throw new IllegalArgumentException("Enter Valid Option!!!");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            run();
        }
        switch (option){
            case 1:
                System.out.println("Enter Customer Name :");
                String customerName = scanner.next();
                Bill bill = new Bill(bills.size()+1,customerName);
                showItems(itemsAvailable);
                int temp = 0;
                do {
                    System.out.println("Enter Item id to add or 0 to Generate Bill");
                    temp = scanner.nextInt();
                    if(temp == 0)break;
                    Item item = itemsAvailable.get(temp - 1);
                    System.out.println( "Enter Quantity"+"(Available Quantity :"+item.getQuantity() +") :");
                    int quantity = scanner.nextInt();
                    bill.addItem(item,quantity);
                    System.out.println("Item added successfully");
                }while(temp != 0);
                bills.add(bill);
                System.out.println(bill.toString());
                run();
                break;
            case 2:
                    try{
                            System.out.println("Enter Bill id to Fetch :");
                            int billId = scanner.nextInt();
                            if (billId < 1 || billId > bills.size()) {
                                throw new IllegalArgumentException("Invalid Bill Id!!!");
                            }
                            System.out.println(bills.get(billId-1).toString());
                            run();
                            break;
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                        run();
                    }
            case 3:
                try{
                    System.out.println("Enter billId to Remove");
                    int billId = scanner.nextInt();
                    if(billId < 0 || billId > bills.size()){
                        throw new IllegalArgumentException("Enter Valid Bill Id");
                    }
                    bills.remove(billId-1);
                    System.out.println("Bill details removed successfully");
                    run();
                    break;
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                    run();
                }
            case 4:
                System.out.println("Happy Shopping, Come Again");
                break;
            default:
                System.out.println("Invalid Option");
                run();
                break;
        }

    }
}

package com.pluralsight;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;


public class Inventory {
    public static HashMap<String, Product> inventory = new HashMap<String, Product>() ;
    public static void main(String[] args) {


        loadInventory();

        Scanner scanner = new Scanner(System.in);

        System.out.print("What item are you interested in? ");
        int id = scanner.nextInt();
        Product matchedProduct = inventory.get(id);
        if (matchedProduct == null){
            System.out.println("We don't carry that product");
            return;
        }
        System.out.printf("We carry %s and the price is $%.2f",
                matchedProduct.getName(), matchedProduct.getPrice());





    } private static void loadInventory(){
        FileReader file = null;
        try {
            file = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufferedReader = new BufferedReader(file);
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                System.out.println(input);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}



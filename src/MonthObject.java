import com.sun.org.apache.xml.internal.security.algorithms.implementations.SignatureDSA;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import  java.io.File;
import java.util.HashMap;


public class MonthObject {
    String name;
    String is_expense;
    Double quantity;
    Double priceOne;
    Double finalPrice;
    MonthObject(String name, String expense,Double quantity, Double priceOne) {
        this.name = name;
        this.is_expense = expense;
        this.quantity = quantity;
        this.priceOne = priceOne;
    }
       MonthObject(String nameItem, double finalPrice, String expense){
            this.name = nameItem;
            this.is_expense = expense;
            this.finalPrice = finalPrice;

      }
     public String getName(){
        return name;
     }
     public  Double getQuantity(){
        return  quantity;
     }
     public String getExpense(){
        return is_expense;
     }
     public Double getPriceOne(){
        return priceOne;
     }
     public Double getFinalPrice(){
        return finalPrice;
     }

}

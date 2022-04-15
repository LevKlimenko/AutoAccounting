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


public class MonthReport {
    String name;
    String is_expense;
    Double quantity;
    Double price;
    HashMap<Integer, ArrayList> month;
    MonthObject monthItem;


    MonthReport(String nameItem, String isExpense, Double quantityItem, Double priceItem) {
        month = new HashMap<>();
        this.name = nameItem;
        this.is_expense = isExpense;
        this.quantity = quantityItem;
        this.price = priceItem;

    }



    public void readFileContentsOrNull() {

        for (int i = 1; i <= 3; i++) {
            String path = "./resources/m.20210" + i + ".csv";
            String line = " ";
            String cvsSplitBy = ",";
            ArrayList<MonthObject> itemName = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] reportMonth = line.split(cvsSplitBy);
                    name = reportMonth[0];
                    is_expense = reportMonth[1];
                    quantity = Double.parseDouble(reportMonth[2]);
                    price = Double.parseDouble(reportMonth[3]);
                    itemName.add(new MonthObject(reportMonth[0], reportMonth[1],  Double.parseDouble(reportMonth[2]), Double.parseDouble(reportMonth[3])));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            month.put(i, itemName);


        }
        //System.out.println(month.get(monthItem.name));
                monthItem.getName();

    }



  /*  void printAll() {
        for (A print : month.entrySet()) {
            ArrayList value = monthItem.();
            for (Object name : value) {
                 System.out.println(month);
            }
            System.out.println(month);
        }



    } */
}

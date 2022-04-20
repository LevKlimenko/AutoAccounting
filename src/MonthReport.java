import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;


public class MonthReport {
    private String name;
    private String isExpense;
    private Double quantity;
    private Double price;
    private HashMap<Integer, ArrayList<MonthObject>> month = new HashMap<>();
    public ArrayList<Double> sumIncome;
    public ArrayList<Double> sumExpense;


    MonthReport(String nameItem, String isExpense, Double quantityItem, Double priceItem) {
        this.name = nameItem;
        this.isExpense = isExpense;
        this.quantity = quantityItem;
        this.price = priceItem;
    }
    MonthReport(){
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
                    itemName.add(new MonthObject(reportMonth[0], reportMonth[1], reportMonth[2], reportMonth[3]));
                }
            } catch (IOException e) {
                System.out.println("Ошибка чтения данных");
                //e.printStackTrace();
            }
            month.put(i, itemName);
        }
        System.out.println("Чтение данных: выполнено");
    }

     private void getMaxExpenseFalse(int i){
        double maxExpenseFalse = 0;
        String itemNameFalse = " ";
        for (MonthObject item : month.get(i)){
            double monthItemSum = item.getQuantity() * item.getPriceOne();
            if (item.getExpense().equals("FALSE")) {
                if ((monthItemSum) > maxExpenseFalse){
                    maxExpenseFalse = monthItemSum;
                    itemNameFalse = item.getName();
                }
            }
        }
        System.out.println("Самый прибыльный товар месяца: " + itemNameFalse + "\nСтоимость: " + maxExpenseFalse);
    }

    private void getMaxExpenseTrue(int i){
        double maxExpenseTrue = 0;
        String itemNameTrue = " ";
        for (MonthObject item : month.get(i)) {
            double monthItemSum = item.getQuantity() * item.getPriceOne();
            if (item.getExpense().equals("TRUE")) {
                if ((monthItemSum) > maxExpenseTrue) {
                    maxExpenseTrue = monthItemSum;
                    itemNameTrue = item.getName();
                }
            }
        }
            System.out.println("Самая большая трата месяца: "+itemNameTrue+"\nСтоимость: "+maxExpenseTrue+"\n") ;
    }

    public void getMaxFalseTrue(){
        if (month.isEmpty()){
            System.out.println("Сначала произведите чтение данных из пункта меню <1>");
        }
        else {
            for (int i = 1; i <= month.size(); i++) {
                System.out.println("Данные за " + MonthID.monthID[i-1]);
                getMaxExpenseFalse(i);
                getMaxExpenseTrue(i);
            }
        }
    }

    public ArrayList<Double> getSumIncome() {
        sumIncome = new ArrayList<>();
        for (int i = 1; i <= month.size(); i++) {

            double sumFalseMonth = 0;
            for (MonthObject item : month.get(i)) {
                double monthItemSum = item.getQuantity() * item.getPriceOne();
                if (item.getExpense().equals("FALSE")) {
                    sumFalseMonth = sumFalseMonth + monthItemSum;
                }
               }
            sumIncome.add(sumFalseMonth);
        }return sumIncome;
    }


    public ArrayList<Double> getSumExpense() {
        sumExpense = new ArrayList<>();
        for (int i = 1; i <= month.size(); i++) {
            double sumTrueMonth = 0;
            for (MonthObject item : month.get(i)) {
                double monthItemSum = item.getQuantity() * item.getPriceOne();
                if (item.getExpense().equals("TRUE")) {
                    sumTrueMonth = sumTrueMonth + monthItemSum;
                   }
             }
            sumExpense.add(sumTrueMonth);
        }return sumExpense;
    }


}

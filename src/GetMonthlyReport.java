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


public class GetMonthlyReport {
    int month;
    String item;
    boolean is_expense;
    int fullPrice;

    //HashMap<String, ArrayList<Integer>> monthReport(i);

    GetMonthlyReport(int monthNumber,String item_name, boolean is_expenseReport, int fullPriceReport) {
        //monthReport = new HashMap<>();
    this.month = monthNumber;
    item=item_name;
    is_expense= is_expenseReport;
    fullPrice=fullPriceReport;

    }


    public void readFileContentsOrNull() {

        for (int i = 1; i <= 3; i++) {
            HashMap<String, ArrayList<Integer>> monthReport = new HashMap<>();
            String path = "./resources/m.20210" + i + ".csv";
            String line = " ";
            String cvsSplitBy = ",";
            System.out.println("Месяц - " + i);
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] reportMonth = line.split(cvsSplitBy);

                    int value = Integer.parseInt(reportMonth[2]);
                    int price = Integer.parseInt(reportMonth[3]);
                   // is_expense = reportMonth[1];
                    int finalPrice = value * price;
                    if (reportMonth[1].equals("TRUE")) {
                        reportMonth[1] = "| Куплено |";
                        if (monthReport.containsKey("Расход")) {
                            ArrayList<Integer> monthRashod = monthReport.get("Расход");
                            monthRashod.add(finalPrice);
                        } else {
                            ArrayList<Integer> monthRashod = new ArrayList<>();
                            monthRashod.add(finalPrice);
                            monthReport.put("Расход", monthRashod);
                        }
                    } else if (reportMonth[1].equals("FALSE")) {
                        reportMonth[1] = "| Продано |";
                        if (monthReport.containsKey("Доход")) {
                            ArrayList<Integer> monthRashod = monthReport.get("Доход");
                            monthRashod.add(finalPrice);
                        } else {
                            ArrayList<Integer> monthRashod = new ArrayList<>();
                            monthRashod.add(finalPrice);
                            monthReport.put("Доход", monthRashod);
                        }
                    }
                    System.out.println("Позиция | " + reportMonth[0] + reportMonth[1] + " количество " + reportMonth[2] + " | по цене " + reportMonth[3]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(monthReport + "\n");
        }


    }

}



/*    public static double getSum(int i) {

        double sum = 0;
        for (
                ArrayList<Integer> monthRashodAll = monthReport.get("Расход")) {
            for (double rashod : monthRashodAll) {
                sum += rashod;
            }

        }
        return sum;
    }

 String getMaxOrderCustomerName() {
        double maxOrder = 0;
        String customerName = "";

        for (String customer : customersOrders.keySet()) {
            for (Double order : customersOrders.get(customer)) {// Допишите логику работы метода
                if (order > maxOrder) {
                    maxOrder = order;
                    customerName = customer;
                }

            }
        }
        return customerName;
    }       //Этот кусок кода для нахождения максимального значения и кому принадлежит



    public void printMonthReport(int number){
        if (!monthReport.isEmpty() ()){
            System.out.println("Доход по месяцам:");
            System.out.println(hashMapYearReportDohod);
            System.out.println("\nРасход по месяцам:");
            System.out.println(hashMapYearReportRashod);
        }
        else {
            System.out.println("Сначала выполните считывание доходов/расходов за год.\n");
        }

    }

 */

//}
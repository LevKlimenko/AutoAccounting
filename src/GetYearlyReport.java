import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class GetYearlyReport {

    HashMap<Integer, ArrayList<Double>> yearIncome = new HashMap<>();
    HashMap<Integer, ArrayList<Double>> yearExpense = new HashMap<>();
    ArrayList<Double> yearReportIncome;
    ArrayList<Double> yearReportExpense;
    MonthID monthID = new MonthID();
    Scanner scanner = new Scanner(System.in);
    MonthReport monthReport = new MonthReport();

    public void readFileContentsOrNull() {
        System.out.println("Введите год:");
        int year=scanner.nextInt();
          String path = "./resources/y." + year + ".csv";
            //BufferedReader br = null;
            String line = " ";
            String cvsSplitBy = ",";
            yearReportExpense = new ArrayList<>();
            yearReportIncome = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] reportYear = line.split(cvsSplitBy);
                     double value = Double.parseDouble(reportYear[1]);
                     if (reportYear[2].equals("true")) {
                       yearReportExpense.add(value);
                         yearExpense.put(year, yearReportExpense);

                    } else if (reportYear[2].equals("false")) {
                       yearReportIncome.add(value);
                         yearIncome.put(year, yearReportIncome);
                    }
                 }

                System.out.println("Чтение данных за " + year+ " год: выполнено\n");
                } catch (IOException e) {
                System.out.println("Ошибка чтения файла. Возможно отсутствует файл "+ path);
               // e.printStackTrace();
            }

    }


    private double getAverageExpenseYear(int year){
            int sum=0;
            for (Double rashod : yearExpense.get(year)){
                sum += rashod;
                }
            int averageExpense = sum/ yearExpense.get(year).size();
            return averageExpense;
            }

      private double getAverageIncomeYear(int year){
        int sum=0;
        for (Double rashod : yearIncome.get(year)){
            sum += rashod;
        }
        int averageIncome = sum/ yearIncome.get(year).size();
        return averageIncome;
    }

      private void getProfit(int year) {
        double profitInMonth = 0;
        for (int i = 0; i< yearExpense.get(year).size(); i++){
            profitInMonth = yearIncome.get(year).get(i) - yearExpense.get(year).get(i);
            System.out.println("Прибыль в  месяце " + monthID.monthID[i] + ": " + profitInMonth);
        }
      }

        public void printYearReport(){
            System.out.println("За какой год вывести отчет?");
            int year = scanner.nextInt();
            if (yearIncome.containsKey(year) && yearExpense.containsKey(year)) {
                System.out.println("Отчет за "+ year + " год:");
                getProfit(year);
                System.out.println("Средний расход за все месяцы в году : "+ getAverageExpenseYear(year));
                System.out.println("Средний доход за все месяцы в году : "+ getAverageIncomeYear(year));
                System.out.println("Доход по месяцам:");
                System.out.println(yearIncome.get(year));
                System.out.println("Расход по месяцам:");
                System.out.println(yearExpense.get(year));
                } else {
                System.out.println("Сначала выполните считывание доходов/расходов за " + year+ " год");
            }
            System.out.println();

        }

       public HashMap<Integer, ArrayList<Double>> getYearIncome(){
        return yearIncome;
    }

    public HashMap<Integer, ArrayList<Double>> getYearExpense(){
        return yearExpense;
    }

}


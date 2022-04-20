import java.util.ArrayList;
import java.util.Scanner;

public class CheckReport {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    GetYearlyReport yearlyReport;
    MonthReport monthReport;
    Scanner scanner;



    public CheckReport(GetYearlyReport yearlyReport, MonthReport monthReport,Scanner scanner) {
        this.yearlyReport = yearlyReport;
        this.monthReport = monthReport;
        this.scanner = scanner;
    }


       public void checkRep() {
        System.out.println("Введите год отчета:");
        int year = scanner.nextInt();
        ArrayList<Double> monthIncome = monthReport.getSumIncome();
        ArrayList<Double> monthExpense = monthReport.getSumExpense();
        ArrayList<Double> yearExpense = yearlyReport.getYearExpense().get(year);
        ArrayList<Double> yearIncome = yearlyReport.getYearIncome().get(year);

        if  (monthIncome.isEmpty() || monthExpense.isEmpty() ||
            !(yearlyReport.getYearIncome().containsKey(year) &&
              yearlyReport.getYearExpense().containsKey(year))) {
            System.out.println("Сначала выполните чтение данных");
        }
        else {

            for (int i = 0; i < monthIncome.size(); i++) {
                if (!monthIncome.get(i).equals(yearIncome.get(i))) {
                    System.out.println(ANSI_RED +"Несоответствие суммы доходов за " + MonthID.monthID[i] +
                                       "\nЗначение в отчете за месяц: <" + monthIncome.get(i) +
                                       ">. Значение в отчете за год: <" + yearIncome.get(i)+ ">" + ANSI_RESET) ;
                }
                else{
                    System.out.println("Доходы за " + MonthID.monthID[i] + " совпадают с годовым отчетом");
                }
            }
            for (int i = 0; i < monthExpense.size(); i++) {
                if (!monthExpense.get(i).equals(yearExpense.get(i))) {
                    System.out.println(ANSI_RED +"Несоответствие суммы расходов за " + MonthID.monthID[i] +
                                       "\nЗначение в отчете за месяц: <" + monthExpense.get(i) +
                                       ">. Значение в отчете за год: <" + yearExpense.get(i)+">"+ ANSI_RESET);
                }
                else{
                    System.out.println("Расходы за " + MonthID.monthID[i] + " совпадают с годовым отчетом");
                }
            }
            System.out.println("Отчеты успешно проверены");
        }

    }
}

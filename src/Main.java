import java.util.*;

public class Main {
    public static void main(String[] args) {

        String name = "";
        String isExpense = "TRUE";
        double quantity = 0;
        double price = 0;
        Scanner scanner = new Scanner(System.in);
        printMenu();
        MonthReport monthReport = new MonthReport(name,isExpense,quantity,price);
        GetYearlyReport yearlyReport = new GetYearlyReport(scanner);//здесь загружаем новый конструктор из метода
        CheckReport checkReport = new CheckReport(yearlyReport,monthReport,scanner);

        while(true) {
            switch (scanner.nextInt()) {
                case 1://выбор 1 Считать все месячные отчеты
                    monthReport.readFileContentsOrNull();
                    printMenu();
                    break;
                case 2://выбор 2 Считать годовой отчет
                    yearlyReport.readFileContentsOrNull();
                    printMenu();
                    break;
                case 3://выбор 3 Сверить отчеты
                    checkReport.checkRep();
                    printMenu();
                    break;
                case 4://выбор 4 Вывести информацию о всех месячных отчетах
                    monthReport.getMaxFalseTrue();
                    printMenu();
                    break;
                case 5://выбор 5 Вывести информацию о годовом отчете
                    yearlyReport.printYearReport();
                    printMenu();
                    break;
                case 1551://закрытие программы
                    System.out.println("Программа завершена");
                    scanner.close();
                    return;
                default:
                    System.out.println("Нет такого пункта меню.");
                    printMenu();
            }
        }
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчеты");
        System.out.println("2 - Считать годовой отчет");
        System.out.println("3 - Сверить отчеты");
        System.out.println("4 - Вывести информацию о всех месячных отчетах");
        System.out.println("5 - Вывести информацию о годовом отчете");
        System.out.println("Для выхода введите <1551> и нажмите Enter");
    }
}

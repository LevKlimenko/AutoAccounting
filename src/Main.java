import java.util.*;

public class Main {
    public static void main(String[] args) {

        String name = "";
        String isexpense = "TRUE";
        double quantity = 0;
        double price = 0;
        Scanner scanner = new Scanner(System.in);
        printMenu();
        MonthReport monthReport = new MonthReport(name,isexpense,quantity,price);
        GetYearlyReport yearlyReport = new GetYearlyReport();//здесь загружаем новый конструктор из метода
        while(true) {
            switch (scanner.nextInt()) {
                case 1:
                   // System.out.println("Введите месяц для отчета: ");
                   // int month = scanner.nextInt();
                    //MonthObject object = new MonthObject(name,isexpense,quantity,price);
                        monthReport.readFileContentsOrNull();
                       // monthReport.printAll();
                  //выбор 1 Считать все месячные отчеты
                    printMenu();
                    break;
                case 2:
                    yearlyReport.readFileContentsOrNull();//выбор 2 Считать годовой отчет
                    printMenu();
                    break;
                case 3:
                    //выбор 3 Сверить отчеты
                    printMenu();
                    break;
                case 4:
                    //выбор 4 Вывести информацию о всех месячных отчетах
                    printMenu();
                    break;
                case 5:
                    yearlyReport.printYearReport();
                    System.out.println();//выбор 5 Вывести информацию о годовом отчете
                    printMenu();
                    break;
                case 1551:
                    //закрытие программы
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

public class CheckReport {
    GetYearlyReport yearlyReport = new GetYearlyReport();
    //MonthReport monthReport;

    public void checkMonthYear(){
       //System.out.println("Расход по месяцам:" + monthReport.sumTrue);
        System.out.println("Доход по году: " + yearlyReport.getYearIncomeCheck());
        //System.out.println((monthReport.sumTrue).equals(yearlyReport.yearReportRashod));
    }


}

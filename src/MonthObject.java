
public class MonthObject {
    private String name;
    private String expense;
    private Double quantity;
    private Double priceOne;

    MonthObject(String name, String expense,String quantity, String priceOne) {
        this.name = name;
        this.expense = expense;
        this.quantity = Double.parseDouble(quantity);
        this.priceOne = Double.parseDouble(priceOne);
    }


     public String getName(){return name;}
     public  Double getQuantity(){
        return  quantity;
     }
     public String getExpense(){
        return expense;
     }
     public Double getPriceOne(){
        return priceOne;
     }

}

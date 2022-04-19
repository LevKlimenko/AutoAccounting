import java.util.ArrayList;
import java.util.HashMap;

public class Praktikum {
    public static void main(String[] args) {
        HashMap<String, ArrayList<Double>> menu = new HashMap<>(); //создаём хеш-таблицу
        ArrayList<Double> mohitoPrice = new ArrayList<>(); //создаём список с ценами для коктейля
        mohitoPrice.add(350.0);  //добавляем в список цену в рублях
        mohitoPrice.add(15.50);  //добавляем в список цену в долларах
        mohitoPrice.add(13.20);  //добавляем в список цену в евро
        menu.put("Коктейль Mojito", mohitoPrice); //добавляем коктейль и список ценами в хеш-таблицу

        ArrayList<Double> tiramisuPrice = new ArrayList<>();  //создаём список с ценами для тирамису
        tiramisuPrice.add(120.0);
        tiramisuPrice.add(4.00);
        tiramisuPrice.add(3.20);
        menu.put("Тирамису", tiramisuPrice); //добавляем тирамису и список с ценами в хеш-таблицу

        ArrayList<Double> ramenPrice = new ArrayList<>(); //создаём список с ценами для рамена
        ramenPrice.add(230.0);
        ramenPrice.add(8.50);
        ramenPrice.add(7.00);
        menu.put("Рамен", ramenPrice); //добавляем рамен и список с ценами в хеш-таблицу
        System.out.println(menu);
    }
} 
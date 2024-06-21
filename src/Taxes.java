import java.util.*;
import java.lang.*;

public class Taxes {

    public static double[] taxesCount (double[] prices) {
        double[] taxes = new double[prices.length];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] <= 100) {taxes[i] = prices[i] * 0.1;}
            else if (prices[i] <= 1000) {taxes[i] = (prices[i] - 100) * 0.2 + 10;}
            else if (prices[i] <= 10000) {taxes[i] = (prices[i] - 1000) * 0.3 + 190;}
            else if (prices[i] > 10000) {taxes[i] = 2890;}
        }
        return taxes;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String yesOrNo;
        int i = 0;
        ArrayList<Double> listOfPrices = new ArrayList<>();

        do {
            while (true) {
                System.out.print("Введите цену для ценника " + (i + 1) + ": ");
                try {
                    Double price = Double.parseDouble(sc.nextLine().trim().replaceAll("\\s", "").replaceAll("^\\+", "").replaceAll(",", "."));
                    if (price <= 0) {
                        System.out.println("Ошибка: число должно быть больше 0. Повторите ввод.");
                        continue;
                    }
                    listOfPrices.add(price);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: неверный ввод числа!");
                }
            }
            do {
                System.out.print("Повторить? (y/n)");
                yesOrNo = sc.nextLine();
            }
            while ((!yesOrNo.equals("y")) && (!yesOrNo.equals("n")));

            i++;

        } while (yesOrNo.equals("y"));

        double[] prices = new double[listOfPrices.size()];
        for (i = 0; i < listOfPrices.size(); i++) {
            prices[i] = listOfPrices.get(i);
        }
        ;
        System.out.println("Цены:");
        for (i = 0; i < prices.length; i++) {
            System.out.println(prices[i]);
        }
        System.out.println("Нологе:");
        double[] taxes = taxesCount(prices);
        for (i = 0; i < taxes.length; i++) {System.out.println(taxes[i]);}
        sc.close();
    }
}


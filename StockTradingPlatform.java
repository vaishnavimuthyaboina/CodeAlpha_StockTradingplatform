import java.util.*;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Portfolio {
    double balance = 10000;
    Map<String, Integer> holdings = new HashMap<>();

    void buyStock(Stock stock, int qty) {
        double cost = stock.price * qty;

        if (cost <= balance) {
            balance -= cost;
            holdings.put(stock.name, holdings.getOrDefault(stock.name, 0) + qty);
            System.out.println("Bought " + qty + " " + stock.name);
        } else {
            System.out.println("Not enough balance!");
        }
    }

    void sellStock(Stock stock, int qty) {
        if (holdings.getOrDefault(stock.name, 0) >= qty) {
            holdings.put(stock.name, holdings.get(stock.name) - qty);
            balance += stock.price * qty;
            System.out.println("Sold " + qty + " " + stock.name);
        } else {
            System.out.println("Not enough stocks!");
        }
    }

    void showPortfolio() {
        System.out.println("\n=== PORTFOLIO ===");
        System.out.println("Balance: " + balance);
        System.out.println("Holdings: " + holdings);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock apple = new Stock("Apple", 150);
        Stock google = new Stock("Google", 280);
        Stock tesla = new Stock("Tesla", 200);

        Portfolio user = new Portfolio();

        while (true) {
            System.out.println("\n=== STOCK MENU ===");
            System.out.println("1. View Stocks");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Apple: " + apple.price);
                    System.out.println("Google: " + google.price);
                    System.out.println("Tesla: " + tesla.price);
                    break;

                case 2:
                    System.out.print("Choose stock (1 Apple, 2 Google, 3 Tesla): ");
                    int b = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int q1 = sc.nextInt();

                    if (b == 1) user.buyStock(apple, q1);
                    else if (b == 2) user.buyStock(google, q1);
                    else if (b == 3) user.buyStock(tesla, q1);
                    break;

                case 3:
                    System.out.print("Choose stock (1 Apple, 2 Google, 3 Tesla): ");
                    int s = sc.nextInt();
                    System.out.print("Enter quantity: ");
                    int q2 = sc.nextInt();

                    if (s == 1) user.sellStock(apple, q2);
                    else if (s == 2) user.sellStock(google, q2);
                    else if (s == 3) user.sellStock(tesla, q2);
                    break;

                case 4:
                    user.showPortfolio();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
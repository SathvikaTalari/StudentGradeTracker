class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Portfolio {
    String name = "";
    int quantity = 0;
    double balance;

    Portfolio(double balance) {
        this.balance = balance;
    }

    void buy(Stock stock, int qty) {
        if (stock.price * qty <= balance) {
            name = stock.name;
            quantity += qty;
            balance -= stock.price * qty;
            System.out.println("Bought " + qty + " of " + stock.name);
        } else {
            System.out.println("Not enough money");
        }
    }

    void sell(Stock stock, int qty) {
        if (name.equals(stock.name) && quantity >= qty) {
            quantity -= qty;
            balance += stock.price * qty;
            System.out.println("Sold " + qty + " of " + stock.name);
        } else {
            System.out.println("Not enough stock");
        }
    }

    void show() {
        System.out.println("Portfolio:");
        if (!name.isEmpty()) {
            System.out.println(name + " : " + quantity);
        }
        System.out.println("Balance: " + balance);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Stock techCorp = new Stock("TechCorp", 150);
        Stock innovateInc = new Stock("InnovateInc", 2800);

        Portfolio portfolio = new Portfolio(10000);
        portfolio.buy(techCorp, 10);
        portfolio.buy(innovateInc, 1);
        portfolio.sell(techCorp, 5);
        portfolio.show();
    }
}

package com.bridgelabz;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Stock {
    private String name;
    private int numShare;
    private double sharePrice;



    public Stock(String name, int numShare, double sharePrice) {
        this.name = name;
        this.numShare = numShare;
        this.sharePrice = sharePrice;

    }

    public String getName() {
        return name;
    }



    public int getNumberOfShare() {
        return numShare;
    }


    public double getSharePrice() {
        return sharePrice;
    }



    public double getValue() {
        return numShare * sharePrice;
    }




}

class StockPortfolio {
    private List<Stock> stocks;

    public StockPortfolio() {
        stocks = new ArrayList<>();
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public double getTotalValue() {
        double totalValue = 0;
        for(Stock stock : stocks){
            totalValue += stock.getValue();
        }
        return totalValue;
    }
    public void printStockReport(){
        System.out.println("Stock Report :");
        for (Stock stock : stocks){
            System.out.println(stock.getName() + " - " + stock.getNumberOfShare() + "shares : "+ stock.getSharePrice() + "per share - Value" + stock.getValue() );
        }
        System.out.println("Total Stock Value : $" + getTotalValue());
    }
}
public class StockAccountManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of stocks :");
        int numberOfStocks = sc.nextInt();

        StockPortfolio portfolio = new StockPortfolio();

        for(int i=0; i<= numberOfStocks; i++){
            System.out.println("Enter details of stock :" + i + ":");
            System.out.println("Name :");
            String name = sc.next();
            System.out.println("Number of Shares: ");
            int numShare = sc.nextInt();
            System.out.println("Share price:");
            double sharePrice = sc.nextDouble();
            Stock stock = new Stock(name, numShare, sharePrice);
            portfolio.addStock(stock);

        }
        portfolio.printStockReport();
    }
}

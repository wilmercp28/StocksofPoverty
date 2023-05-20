/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stocksofpoverty;

import java.util.Random;


public class Stocks {
    Random random = new Random();
    String stockName;
    double stockPrice;
    double deviation;
    double trend;
    double percentageChange;
    int stockShares = 0;

    
    
    
    public Stocks(String name, double minPrice, double maxPrice, double standarDeviation, double stockTrend, double stockPercentageChange, int shares){
    stockName = name;
    stockPrice = minPrice + (maxPrice - minPrice) * random.nextDouble();
    deviation = standarDeviation;
    trend = stockTrend;
    percentageChange = stockPercentageChange;
    shares = stockShares;
  
 
    
    
    
    }
    
}

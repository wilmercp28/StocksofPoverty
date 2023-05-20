/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stocksofpoverty;


public class BankAccount {
    String playerName;
    double balance;
    int load;
    int interests;
    
    
    public BankAccount(String name){
    playerName = name;
    balance = 5000;
    load = 5000;
    interests = 5;
    
    
    }
    
    public double buySell(Stocks stock, boolean isBuying){
        if(isBuying){
          if (stock.stockPrice < balance){
            balance = balance - stock.stockPrice;
            stock.stockShares++;
          }   
        } else if (!isBuying){
            if(stock.stockShares > 0){
            balance = stock.stockPrice + balance;
            stock.stockShares--;
            
           }
          } 
        return balance;
    }
}
    
    
    


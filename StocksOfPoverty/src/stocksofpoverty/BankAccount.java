/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stocksofpoverty;

import java.text.DecimalFormat;
import javax.swing.JTextField;


public class BankAccount {
    String playerName;
    double balance;
    double loan;
    int interests;
    double creditLimit;
    boolean x10;
    
    
    public BankAccount(String name){
    playerName = name;
    balance = 5000;
    loan = 100;
    interests = 5;
    creditLimit = 100000;
    
    
    }
    public double takePayLoan(double balance, boolean isTaking,double amount,JTextField textField){
    if(isTaking){
    if(amount >= creditLimit - loan){
    textField.setText("Over Credit Limit");
    return balance;
    } else {
    loan += amount;
    return balance + amount;
    }    
    }else{
    if(balance < amount){
    return balance;
    } else {
    loan =- amount;
    return balance - amount;
    
    }
    
    
    }
    }
    
    public double buySell(Stocks stock, boolean isBuying, boolean x10){
    int stocksToTrade = x10 ? 10 : 1;

    if (isBuying) {
        if (stock.stockPrice * stocksToTrade <= balance) {
            balance = balance - (stock.stockPrice * stocksToTrade);
            stock.stockShares += stocksToTrade;
        }
    } else {
        if (stock.stockShares >= stocksToTrade) {
            balance = balance + (stock.stockPrice * stocksToTrade);
            stock.stockShares -= stocksToTrade;
        }
    }

    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    String formattedBalance = decimalFormat.format(balance);
    double roundedBalance = Double.parseDouble(formattedBalance);
    return roundedBalance;
    }
    
    public double monthlyInteres(double playerBalance, double playerInterestRate){
    // Convert the interest rate to a decimal
    double monthlyInterestRate = playerInterestRate / 100.0;

    // Calculate the interest amount
    double interestAmount = playerBalance * monthlyInterestRate;

    // Calculate the new player balance
    double newPlayerBalance = playerBalance - interestAmount;

    return newPlayerBalance;
    }
}
    
    
    


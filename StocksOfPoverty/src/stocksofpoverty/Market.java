/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package stocksofpoverty;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import static java.lang.Double.parseDouble;
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.Timer;


public final class Market extends javax.swing.JFrame {
    Random random = new Random();
    int day = 1;
    int month = 1;
    boolean gameIsPause = true;
   
    int daysAfterBreakingNews = 0;
    double breakingNewsTrend;
    boolean devMode = true;
    Stocks breakingNewsStock;
  
    
    
  
  
    
    
   
    

Color defaultColor = new Color(184,207,229);
BankAccount player = new BankAccount("Wilmer");


Stocks aple = new Stocks("Aple", 100, 150, 0.5, 0,0,0,false,0);
Stocks gogle = new Stocks("Gogle", 500, 800, 1,0,0,0,false,0);
Stocks fakebook = new Stocks("FakeBook", 500, 800, 1,0,0,0,false,0);
Stocks amazonia = new Stocks("amazonia", 500, 800, 1,0,0,0,false,0);
Stocks anz = new Stocks("ANZ", 50, 80, 1.2,0,0,0,false,0);
Stocks pns = new Stocks("P&S", 100, 400, 0.2,0,0,0,false,0);
Stocks donalsj = new Stocks("DonalsJ", 100, 400, 0.1,0,0,0,false,0);
Stocks nassp = new Stocks("NassP", 500, 800, 0.3,0,0,0,false,0);
Stocks[] stocks = {aple, gogle, fakebook, amazonia, anz, donalsj,nassp,pns};


  
    public Market() {
        initComponents();
        
        newsUpdate(stocks);
        updateTextFields();
        

       
     
       
    }
    ActionListener gameTicks = new ActionListener(){    
           @Override
           public void actionPerformed(ActionEvent evt){
           priceUpdate(stocks);
           dayMonthChanger();
           newsCounter();
           updateTextFields(); // Update the text fields in the GUI
           if(day == 1){
           player.balance = player.monthlyInteres(player.loan, player.interests);
           }
           }
           };
           Timer timer = new Timer(StocksOfPoverty.gameSpeed, gameTicks);

       
      
    
       
    public void setTimerDelay(int delay) {
        timer.setDelay(delay);
        StocksOfPoverty.gameSpeed = delay;
    }
       
    
    
    public void updateTextFields() {
    updateTextField(stock1,price1, aple,sharesOwn1);
    updateTextField(stock2,price2, gogle,sharesOwn2);
    updateTextField(stock3,price3, fakebook,sharesOwn3);
    updateTextField(stock4,price4, amazonia,sharesOwn4);
    updateTextField(stock5,price5, anz,sharesOwn5);
    updateTextField(stock6,price6, donalsj,sharesOwn6);
    updateTextField(stock7,price7, nassp,sharesOwn7);
    updateTextField(stock8,price8, pns,sharesOwn8);
    unRealizedBlanceText.setText("UnrealizedGains " +String.valueOf(unRealizedGains()));
    
    
    loan.setText("Loan: "+player.loan+"   ("+player.creditLimit+")");
    monthlyInterestRate.setText("Monthly interest rate: " +player.interests + "%");
    String formattedPlayerBalance = String.format("%5.2f", player.balance);
    playerBalance.setText("Balance "+String.valueOf(formattedPlayerBalance));
    accountBalance.setText("Account Balance " + player.balance);
   
    
    
    
    }
    
    
    
    private double unRealizedGains(){
    double unRealizedBalance = 0;
    for(Stocks stocks : stocks){
    unRealizedBalance += stocks.stockPrice * stocks.stockShares;
    
    }
    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
    String formattedBalance = decimalFormat.format(unRealizedBalance);
    double roundedBalance = Double.parseDouble(formattedBalance);
    return roundedBalance;
    }
    
    
   

private void updateTextField(javax.swing.JTextField stockName, javax.swing.JTextField stockPrice, Stocks stock, javax.swing.JLabel stockShares) {
    String formattedPrice = String.format("%5.2f", stock.stockPrice); // Using a width of 10 for the price
    double absoluteChange = Math.abs(stock.percentageChange);
    String formattedChange = String.format("%3.1f", absoluteChange); // Using a width of 6 for the percentage change
    stockName.setText(stock.stockName);
    stockShares.setText(String.valueOf(stock.stockShares));

    if (stock.percentageChange < 0) {
        stockPrice.setForeground(new Color(150, 0, 0)); // Dark red
    } else {
        stockPrice.setForeground(new Color(0, 150, 0)); // Dark green
    }
    
    // Use 'stock.stockPrice' as the new price and 'mean' (original stock price) as the base number
    stockPrice.setText(formattedPrice + "  % " + formattedChange);
}
    
    public void dayMonthChanger(){
      if (day < 30) {
        day++;
    } else {
        day = 1;

        if (month < 12) {
            month++;
        } else {
            month = 1;
        }
    
      }
      
      if(devMode){
       stock1.setToolTipText(stocks[0].stockName+"Trend: " + String.valueOf(stocks[0].trend)+"Is Breaking News: "+stocks[0].isBreakingNews);
       stock2.setToolTipText(stocks[1].stockName+"Trend: " + String.valueOf(stocks[1].trend)+"Is Breaking News: "+stocks[1].isBreakingNews);
       stock3.setToolTipText(stocks[2].stockName+"Trend: " + String.valueOf(stocks[2].trend)+"Is Breaking News: "+stocks[2].isBreakingNews);
       stock4.setToolTipText(stocks[3].stockName+"Trend: " + String.valueOf(stocks[3].trend)+"Is Breaking News: "+stocks[3].isBreakingNews);
       stock5.setToolTipText(stocks[4].stockName+"Trend: " + String.valueOf(stocks[4].trend)+"Is Breaking News: "+stocks[4].isBreakingNews);
       stock6.setToolTipText(stocks[5].stockName+"Trend: " + String.valueOf(stocks[5].trend)+"Is Breaking News: "+stocks[5].isBreakingNews);
       stock7.setToolTipText(stocks[6].stockName+"Trend: " + String.valueOf(stocks[6].trend)+"Is Breaking News: "+stocks[6].isBreakingNews);
       stock8.setToolTipText(stocks[7].stockName+"Trend: " + String.valueOf(stocks[7].trend)+"Is Breaking News: "+stocks[7].isBreakingNews);
      }
      
      
    
    }
    
    public double percentageChanger(double baseNumber, double newNumber){
    double difference = newNumber - baseNumber;
    double percentage = (difference / Math.abs(baseNumber)) * 100;
    return percentage;
    }
    
    private boolean shouldRollForTrendChange() {
        return day == 30;
}
    
    private void newsCounter(){
        int randomNumber = random.nextInt(101) + 100;
        if(daysAfterBreakingNews < randomNumber){
        daysAfterBreakingNews++;
        System.out.println(daysAfterBreakingNews);
          } else if(daysAfterBreakingNews > randomNumber) {
        pauseGame();
        breakingNewsStock.isBreakingNews = false;
        breakingNewsStock.trend = 0;
        newsUpdate(stocks);
        breakingNewsStock.isBreakingNews = true;
        daysAfterBreakingNews = 0;
        }
    
    
    }
    
    public void newsUpdate(Stocks[] stocks){
         int randomIndex = random.nextInt(stocks.length);
    Stocks randomStock = stocks[randomIndex];
    NewsFeed news = new NewsFeed(randomStock.stockName, "", randomStock.isBreakingNews, randomStock.trend);
    newsFeed.setText(news.newsText);
    randomStock.trend = news.stockTrend;
    randomStock.isBreakingNews = news.breakingNews;
    breakingNewsStock = randomStock;
    System.out.println(breakingNewsStock.isBreakingNews);
    System.out.println(breakingNewsStock.trend);
    System.out.println(randomStock.trend);
    
    tabsChangeColors();
    }
 

public void priceUpdate(Stocks[] stocks) {
    for (Stocks stock : stocks) {
        double mean = stock.stockPrice; // Use the current stock price as the mean
        double standardDeviation = stock.deviation;
        if(day == 1 && month ==1){
        stock.baseNumber = mean;
        }
        // Generate a random price using the normal distribution
        double randomPrice = generateRandomPrice(mean, standardDeviation);

        // Add a trend component to the stock price
       double trend = stock.trend;
       if(!stock.isBreakingNews){
        trend = shouldRollForTrendChange() ? getRandomTrend() : stock.trend;
        } else if(stock.isBreakingNews){
        trend = breakingNewsStock.trend;
        }
        
        double newPrice = randomPrice + trend;
        
        // Update the stock price
        if (newPrice < 0.1) {
            stock.stockPrice = 0.1;
        } else {
            stock.stockPrice = newPrice;
        }

        stock.trend = trend; // Update the trend for the stock
        
        stock.percentageChange = percentageChanger(stock.baseNumber, newPrice);
        
        
    }

    
}


private double generateRandomPrice(double mean, double standardDeviation) {
    Random random = new Random();
    double randomValue = random.nextGaussian();

    // Scale the random number by the standard deviation and add the mean
    double randomPrice = randomValue * standardDeviation + mean;

    return randomPrice;
}

private double getRandomTrend() {
    Random random = new Random();
    int randomValue = random.nextInt(5); // Generates a random value between 0 and 4

    
    double trend;
    trend = switch (randomValue) {
        // 20% down trend
           case 0 -> -0.3;
               // 60% no trend
           case 1, 2, 3 -> 0;
               // 20% up trend
           default -> 0.3;
        };

    return trend;

}
    
    public void timerRestart(){
    timer.restart();
    pauseButtom.setText("Pause");
    gameIsPause = false;
    }
    
    public void timerStop(){
    timer.stop();
    pauseButtom.setText("Resume");
    gameIsPause = true;
    
    }
    public void reduceSpeed(){
    switch (StocksOfPoverty.gameSpeed) {
            case 500:
                setTimerDelay(1000);
                gameSpeedLabel.setText("X 3");
                break;
            case 1000:
                setTimerDelay(1500);
                gameSpeedLabel.setText("X 2");
                break;
            case 1500:
                setTimerDelay(3000);
                gameSpeedLabel.setText("X 1");
                break;
            default:
                break;
        }
    }
    public void increaseSpeed(){
    switch (StocksOfPoverty.gameSpeed) {
            case 3000:
                setTimerDelay(1500);
                gameSpeedLabel.setText("X 2");
                break;
            case 1500:
                setTimerDelay(1000);
                gameSpeedLabel.setText("X 3");
                break;
            case 1000:
                setTimerDelay(200);
                gameSpeedLabel.setText("X 4");
                break;
            default:
                break;
        }
    }
    public void pauseGame(){
      if (!gameIsPause){
        timerStop();
      } else if (gameIsPause) {
        timer.setInitialDelay(0);
        timerRestart();
        }
    }
    private void tabsChangeColors(){
    int tabIndexNews = 2;
    Color newColor = Color.YELLOW; 

    int selectedIndex = stocksTab.getSelectedIndex();
    if (selectedIndex != tabIndexNews ) {
        stocksTab.setBackgroundAt(tabIndexNews, newColor);
    } 
        
    }
    
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        stocksTab = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        stock1 = new javax.swing.JTextField();
        sell1 = new javax.swing.JButton();
        buy1 = new javax.swing.JButton();
        stock2 = new javax.swing.JTextField();
        stock3 = new javax.swing.JTextField();
        stock4 = new javax.swing.JTextField();
        stock5 = new javax.swing.JTextField();
        stock6 = new javax.swing.JTextField();
        stock7 = new javax.swing.JTextField();
        stock8 = new javax.swing.JTextField();
        price1 = new javax.swing.JTextField();
        price2 = new javax.swing.JTextField();
        price3 = new javax.swing.JTextField();
        price4 = new javax.swing.JTextField();
        price5 = new javax.swing.JTextField();
        price6 = new javax.swing.JTextField();
        price7 = new javax.swing.JTextField();
        price8 = new javax.swing.JTextField();
        buy2 = new javax.swing.JButton();
        sell2 = new javax.swing.JButton();
        buy3 = new javax.swing.JButton();
        sell3 = new javax.swing.JButton();
        sell4 = new javax.swing.JButton();
        buy4 = new javax.swing.JButton();
        buy5 = new javax.swing.JButton();
        sell5 = new javax.swing.JButton();
        buy6 = new javax.swing.JButton();
        sell6 = new javax.swing.JButton();
        buy7 = new javax.swing.JButton();
        sell7 = new javax.swing.JButton();
        sell8 = new javax.swing.JButton();
        buy8 = new javax.swing.JButton();
        sharesOwn1 = new javax.swing.JLabel();
        sharesOwn2 = new javax.swing.JLabel();
        sharesOwn3 = new javax.swing.JLabel();
        sharesOwn4 = new javax.swing.JLabel();
        sharesOwn5 = new javax.swing.JLabel();
        sharesOwn6 = new javax.swing.JLabel();
        sharesOwn7 = new javax.swing.JLabel();
        sharesOwn8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        accountBalance = new javax.swing.JLabel();
        loan = new javax.swing.JLabel();
        monthlyInterestRate = new javax.swing.JLabel();
        spectedYearTax = new javax.swing.JLabel();
        loanTextField = new javax.swing.JFormattedTextField();
        takeLoan = new javax.swing.JButton();
        repayLoan = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        newsFeed = new javax.swing.JTextArea();
        gameSpeedPlus = new javax.swing.JButton();
        gameSpeedMinus = new javax.swing.JButton();
        gameSpeedLabel = new javax.swing.JLabel();
        pauseButtom = new javax.swing.JButton();
        playerBalance = new javax.swing.JLabel();
        unRealizedBlanceText = new javax.swing.JLabel();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        stocksTab.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stocksTabMouseClicked(evt);
            }
        });

        stock1.setEditable(false);
        stock1.setText("jTextField1");

        sell1.setText("Sell 1 Share");
        sell1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sell1MouseClicked(evt);
            }
        });

        buy1.setText("Buy 1 Share");
        buy1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy1MouseClicked(evt);
            }
        });

        stock2.setEditable(false);
        stock2.setText("jTextField1");

        stock3.setEditable(false);
        stock3.setText("jTextField1");

        stock4.setEditable(false);
        stock4.setText("jTextField1");

        stock5.setEditable(false);
        stock5.setText("jTextField1");
        stock5.setToolTipText("");

        stock6.setEditable(false);
        stock6.setText("jTextField1");

        stock7.setEditable(false);
        stock7.setText("jTextField1");

        stock8.setEditable(false);
        stock8.setText("jTextField1");

        price1.setEditable(false);
        price1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price1.setText("jTextField1");
        price1.setMinimumSize(new java.awt.Dimension(90, 22));

        price2.setEditable(false);
        price2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price2.setText("jTextField2");
        price2.setMinimumSize(new java.awt.Dimension(90, 22));

        price3.setEditable(false);
        price3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price3.setText("jTextField3");
        price3.setMinimumSize(new java.awt.Dimension(90, 22));

        price4.setEditable(false);
        price4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price4.setText("jTextField4");
        price4.setMinimumSize(new java.awt.Dimension(90, 22));

        price5.setEditable(false);
        price5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price5.setText("jTextField5");
        price5.setMinimumSize(new java.awt.Dimension(90, 22));

        price6.setEditable(false);
        price6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price6.setText("jTextField6");
        price6.setMinimumSize(new java.awt.Dimension(90, 22));

        price7.setEditable(false);
        price7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price7.setText("jTextField7");
        price7.setMinimumSize(new java.awt.Dimension(90, 22));

        price8.setEditable(false);
        price8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        price8.setText("jTextField8");
        price8.setMinimumSize(new java.awt.Dimension(90, 22));

        buy2.setText("Buy 1 Share");
        buy2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy2MouseClicked(evt);
            }
        });

        sell2.setText("Sell 1 Share");
        sell2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sell2MouseClicked(evt);
            }
        });

        buy3.setText("Buy 1 Share");
        buy3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy3MouseClicked(evt);
            }
        });

        sell3.setText("Sell 1 Share");
        sell3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sell3MouseClicked(evt);
            }
        });

        sell4.setText("Sell 1 Share");
        sell4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sell4MouseClicked(evt);
            }
        });

        buy4.setText("Buy 1 Share");
        buy4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy4MouseClicked(evt);
            }
        });

        buy5.setText("Buy 1 Share");
        buy5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy5MouseClicked(evt);
            }
        });

        sell5.setText("Sell 1 Share");
        sell5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sell5MouseClicked(evt);
            }
        });

        buy6.setText("Buy 1 Share");
        buy6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy6MouseClicked(evt);
            }
        });

        sell6.setText("Sell 1 Share");
        sell6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sell6MouseClicked(evt);
            }
        });

        buy7.setText("Buy 1 Share");
        buy7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy7MouseClicked(evt);
            }
        });

        sell7.setText("Sell 1 Share");
        sell7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sell7MouseClicked(evt);
            }
        });

        sell8.setText("Sell 1 Share");
        sell8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sell8MouseClicked(evt);
            }
        });

        buy8.setText("Buy 1 Share");
        buy8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buy8MouseClicked(evt);
            }
        });

        sharesOwn1.setText("jLabel2");

        sharesOwn2.setText("jLabel3");

        sharesOwn3.setText("jLabel4");

        sharesOwn4.setText("jLabel5");

        sharesOwn5.setText("jLabel6");

        sharesOwn6.setText("jLabel7");

        sharesOwn7.setText("jLabel8");

        sharesOwn8.setText("jLabel9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(stock7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(stock6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stock5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stock1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stock4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stock2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stock3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stock8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(price2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(price3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(price4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(price5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(price6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(price7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(price8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(price1, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sharesOwn1)
                    .addComponent(sharesOwn2)
                    .addComponent(sharesOwn3)
                    .addComponent(sharesOwn4)
                    .addComponent(sharesOwn5)
                    .addComponent(sharesOwn6)
                    .addComponent(sharesOwn7)
                    .addComponent(sharesOwn8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buy1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buy2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buy3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buy4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buy5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buy6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buy7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buy8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sell1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sell2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sell3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sell4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sell5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sell6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sell7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sell8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {buy1, buy2, buy3, buy4, buy5, buy6, buy7, buy8, price1, price2, price3, price4, price5, price6, price7, price8, sell1, sell2, sell3, sell4, sell5, sell6, sell7, sell8, stock1, stock2, stock3, stock4, stock5, stock6, stock7, stock8});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sell1)
                            .addComponent(buy1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buy2)
                            .addComponent(sell2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sell3)
                            .addComponent(buy3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buy4)
                            .addComponent(sell4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sell5)
                            .addComponent(buy5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buy6)
                            .addComponent(sell6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sell7)
                            .addComponent(buy7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buy8)
                            .addComponent(sell8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stock1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sharesOwn1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stock2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sharesOwn2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stock3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sharesOwn3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stock4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sharesOwn4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stock5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sharesOwn5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stock6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sharesOwn6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stock7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sharesOwn7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(stock8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(price8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sharesOwn8))))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buy1, buy2, buy3, buy4, buy5, buy6, buy7, buy8, price1, price2, price3, price4, price5, price6, price7, price8, sell1, sell2, sell3, sell4, sell5, sell6, sell7, sell8, stock1, stock2, stock3, stock4, stock5, stock6, stock7, stock8});

        stocksTab.addTab("Stocks", jPanel1);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Poverty Bank");

        accountBalance.setText("Account Balance");

        loan.setText("Loan");

        monthlyInterestRate.setText("Monthly interest rate");

        spectedYearTax.setText("Spected yearly tax Payment");

        loanTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                loanTextFieldFocusGained(evt);
            }
        });
        loanTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                loanTextFieldKeyTyped(evt);
            }
        });

        takeLoan.setText("Take Loan");
        takeLoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                takeLoanMouseClicked(evt);
            }
        });

        repayLoan.setText("Repay Loan");
        repayLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repayLoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(accountBalance, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addComponent(loan, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addComponent(monthlyInterestRate, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addComponent(spectedYearTax, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(loanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(takeLoan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(repayLoan)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(accountBalance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(loan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(monthlyInterestRate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spectedYearTax)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loanTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(takeLoan)
                    .addComponent(repayLoan))
                .addContainerGap())
        );

        stocksTab.addTab("Bank", jPanel3);

        newsFeed.setEditable(false);
        newsFeed.setColumns(20);
        newsFeed.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        newsFeed.setRows(5);
        newsFeed.setText("Hello\n");
        newsFeed.setAutoscrolls(false);
        jScrollPane1.setViewportView(newsFeed);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        stocksTab.addTab("News", jPanel4);

        gameSpeedPlus.setText("+");
        gameSpeedPlus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gameSpeedPlusMouseClicked(evt);
            }
        });

        gameSpeedMinus.setText("-");
        gameSpeedMinus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gameSpeedMinusMouseClicked(evt);
            }
        });

        gameSpeedLabel.setText("X 1");

        pauseButtom.setText("Start Game");
        pauseButtom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pauseButtomMouseClicked(evt);
            }
        });

        playerBalance.setText("jLabel1");

        unRealizedBlanceText.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(stocksTab)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(playerBalance, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unRealizedBlanceText, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(pauseButtom)
                        .addGap(18, 18, 18)
                        .addComponent(gameSpeedLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gameSpeedMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gameSpeedPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(stocksTab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gameSpeedPlus)
                    .addComponent(gameSpeedMinus)
                    .addComponent(gameSpeedLabel)
                    .addComponent(pauseButtom)
                    .addComponent(playerBalance)
                    .addComponent(unRealizedBlanceText))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void gameSpeedPlusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameSpeedPlusMouseClicked
      increaseSpeed();
    }//GEN-LAST:event_gameSpeedPlusMouseClicked

    private void gameSpeedMinusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gameSpeedMinusMouseClicked
      reduceSpeed();
    }//GEN-LAST:event_gameSpeedMinusMouseClicked

    private void pauseButtomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseButtomMouseClicked
    pauseGame();
    }//GEN-LAST:event_pauseButtomMouseClicked

    private void stocksTabMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stocksTabMouseClicked
        // TODO add your handling code here:
        stocksTab.setBackgroundAt(2, defaultColor);
    }//GEN-LAST:event_stocksTabMouseClicked

    private void buy8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy8MouseClicked
        if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(pns, true,true);
        } else {
        player.balance = player.buySell(pns, true,false);
        }
        System.out.println(pns.stockShares);
        updateTextFields();
    }//GEN-LAST:event_buy8MouseClicked

    private void sell8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell8MouseClicked
         if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(pns, false,true);
        } else {
        player.balance = player.buySell(pns, false,false);
         }
        System.out.println(pns.stockShares);
        updateTextFields();
    }//GEN-LAST:event_sell8MouseClicked

    private void sell7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell7MouseClicked
         if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(nassp, false,true);
        } else {
        player.balance = player.buySell(nassp, false,false);
         }
        System.out.println(nassp.stockShares);
        updateTextFields();
    }//GEN-LAST:event_sell7MouseClicked

    private void buy7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy7MouseClicked
         if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(nassp, true,true);
        } else {
        player.balance = player.buySell(nassp, true,false);
         }
        System.out.println(nassp.stockShares);
        updateTextFields();
    }//GEN-LAST:event_buy7MouseClicked

    private void sell6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell6MouseClicked
         if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(donalsj, false,true);
        } else {
        player.balance = player.buySell(donalsj, false,false);
         }
        System.out.println(donalsj.stockShares);
        updateTextFields();
    }//GEN-LAST:event_sell6MouseClicked

    private void buy6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy6MouseClicked
        if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(donalsj, true,true);
        } else {
        player.balance = player.buySell(donalsj, true,false);
        }
        System.out.println(donalsj.stockShares);
        updateTextFields();
    }//GEN-LAST:event_buy6MouseClicked

    private void sell5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell5MouseClicked
        if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(anz, false,true);
        } else {
        player.balance = player.buySell(anz, false,false);
        }
        System.out.println(anz.stockShares);
        updateTextFields();
    }//GEN-LAST:event_sell5MouseClicked

    private void buy5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy5MouseClicked
        if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(anz, true,true);
        } else {
        player.balance = player.buySell(anz, true,false);
        }
        System.out.println(anz.stockShares);
        updateTextFields();
    }//GEN-LAST:event_buy5MouseClicked

    private void buy4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy4MouseClicked
        if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(amazonia, true,true);
        } else {
        player.balance = player.buySell(amazonia, true,false);
        }
        System.out.println(amazonia.stockShares);
        updateTextFields();
    }//GEN-LAST:event_buy4MouseClicked

    private void sell4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell4MouseClicked
        if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(amazonia, false,true);
        } else {
        player.balance = player.buySell(amazonia, false,false);
        }
        System.out.println(amazonia.stockShares);
        updateTextFields();
    }//GEN-LAST:event_sell4MouseClicked

    private void sell3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell3MouseClicked
        if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(fakebook, false,true);
        } else {
        player.balance = player.buySell(fakebook, false,false);
        }
        System.out.println(fakebook.stockShares);
        updateTextFields();
    }//GEN-LAST:event_sell3MouseClicked

    private void buy3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy3MouseClicked
        if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(fakebook, true,true);
        } else {
        player.balance = player.buySell(fakebook, true,false);
        }
        System.out.println(fakebook.stockShares);
        updateTextFields();
    }//GEN-LAST:event_buy3MouseClicked

    private void sell2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell2MouseClicked
        if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(gogle, false,true);
        } else {
        player.balance = player.buySell(gogle, false,false);
        }
        System.out.println(gogle.stockShares);
        updateTextFields();
    }//GEN-LAST:event_sell2MouseClicked

    private void buy2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy2MouseClicked
        if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(gogle, true,true);
        } else {
        player.balance = player.buySell(gogle, true,false);
        }
        System.out.println(gogle.stockShares);
        updateTextFields();
    }//GEN-LAST:event_buy2MouseClicked

    private void buy1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buy1MouseClicked
        if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(aple, true,true);
        } else {
        player.balance = player.buySell(aple, true,false);
        }
        System.out.println(aple.stockShares);
        updateTextFields();
    }//GEN-LAST:event_buy1MouseClicked

    private void sell1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sell1MouseClicked
        if ((evt.getModifiersEx() & KeyEvent.SHIFT_DOWN_MASK) != 0){
        player.balance = player.buySell(aple, false,true);
        } else {
        player.balance = player.buySell(aple, false,false);
        }
        System.out.println(aple.stockShares);
        updateTextFields();
    }//GEN-LAST:event_sell1MouseClicked

    private void repayLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repayLoanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_repayLoanActionPerformed

    private void takeLoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_takeLoanMouseClicked
     player.balance = player.takePayLoan(player.balance, true, parseDouble(loanTextField.getText()),loanTextField);   // TODO add your handling code here:
     updateTextFields();
     
    }//GEN-LAST:event_takeLoanMouseClicked

    private void loanTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_loanTextFieldFocusGained
    loanTextField.setText("");
        // TODO add your handling code here:
    }//GEN-LAST:event_loanTextFieldFocusGained

    private void loanTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_loanTextFieldKeyTyped
    char keyChar = evt.getKeyChar();

    // Allow digits and dots (decimal point)
    if (!Character.isDigit(keyChar) && keyChar != '.') {
        evt.consume();
    }
    }//GEN-LAST:event_loanTextFieldKeyTyped
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Market.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Market.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Market.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Market.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Market().setVisible(true);
            }
        });
        
       
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accountBalance;
    private javax.swing.JButton buy1;
    private javax.swing.JButton buy2;
    private javax.swing.JButton buy3;
    private javax.swing.JButton buy4;
    private javax.swing.JButton buy5;
    private javax.swing.JButton buy6;
    private javax.swing.JButton buy7;
    private javax.swing.JButton buy8;
    private javax.swing.JLabel gameSpeedLabel;
    private javax.swing.JButton gameSpeedMinus;
    private javax.swing.JButton gameSpeedPlus;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel loan;
    private javax.swing.JFormattedTextField loanTextField;
    private javax.swing.JLabel monthlyInterestRate;
    private javax.swing.JTextArea newsFeed;
    private javax.swing.JButton pauseButtom;
    private javax.swing.JLabel playerBalance;
    private javax.swing.JTextField price1;
    private javax.swing.JTextField price2;
    private javax.swing.JTextField price3;
    private javax.swing.JTextField price4;
    private javax.swing.JTextField price5;
    private javax.swing.JTextField price6;
    private javax.swing.JTextField price7;
    private javax.swing.JTextField price8;
    private javax.swing.JButton repayLoan;
    private javax.swing.JButton sell1;
    private javax.swing.JButton sell2;
    private javax.swing.JButton sell3;
    private javax.swing.JButton sell4;
    private javax.swing.JButton sell5;
    private javax.swing.JButton sell6;
    private javax.swing.JButton sell7;
    private javax.swing.JButton sell8;
    private javax.swing.JLabel sharesOwn1;
    private javax.swing.JLabel sharesOwn2;
    private javax.swing.JLabel sharesOwn3;
    private javax.swing.JLabel sharesOwn4;
    private javax.swing.JLabel sharesOwn5;
    private javax.swing.JLabel sharesOwn6;
    private javax.swing.JLabel sharesOwn7;
    private javax.swing.JLabel sharesOwn8;
    private javax.swing.JLabel spectedYearTax;
    private javax.swing.JTextField stock1;
    private javax.swing.JTextField stock2;
    private javax.swing.JTextField stock3;
    private javax.swing.JTextField stock4;
    private javax.swing.JTextField stock5;
    private javax.swing.JTextField stock6;
    private javax.swing.JTextField stock7;
    private javax.swing.JTextField stock8;
    private javax.swing.JTabbedPane stocksTab;
    private javax.swing.JButton takeLoan;
    private javax.swing.JLabel unRealizedBlanceText;
    // End of variables declaration//GEN-END:variables


}

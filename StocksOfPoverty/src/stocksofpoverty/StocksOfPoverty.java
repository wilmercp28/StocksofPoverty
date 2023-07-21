
package stocksofpoverty;


public class StocksOfPoverty {
    static int gameSpeed = 3000;
   
    public static void main(String[] args) {
        
        Market market = new Market();
        market.timer.setRepeats(true);
        market.timer.setDelay(gameSpeed);  
      
        market.setVisible(true);
    
            
    }
    
}

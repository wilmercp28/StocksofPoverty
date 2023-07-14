
package stocksofpoverty;

import java.util.Random;


public class NewsFeed {
    boolean breakingNews;
    Random random = new Random();
    String stockName;
    boolean isBadNews;
    double stockTrend;

    String newsText;
    
   
    
    public NewsFeed(String name, String newsArticle, boolean isBreakingNews, double trend) {
        isBreakingNews = breakingNews;
        newsText = newsArticle;
        stockName = name;
        breakingNews = false;
        trend = stockTrend;
        if (!breakingNews) {
            String newsFeed = newsFeed(stockName);
            newsText = newsFeed;
            
        }
    }
    
    private String newsFeed(String name) {
            int randomNumber = random.nextInt(10);
            
            switch (randomNumber) {
                case 1 -> {
                    isBadNews = true;
                    breakingNews = true;
                   stockTrend = stockTrend - 1;
                    return "News: " + name + " is found guilty of tax evasion. The IRS is working to impose the necessary fines on the company.";
                }
                case 2 -> {
                    isBadNews = true;
                    breakingNews = true;
                    stockTrend = stockTrend - 1;
                    return "News: " + name + " reports a major product recall due to safety concerns. Customers are advised to return the affected items.";
                }
                case 3 -> {
                    isBadNews = true;
                    breakingNews = true;
                    stockTrend = stockTrend - 1;
                    return "News: " + name + " faces a lawsuit from shareholders over alleged financial misconduct. The case will be heard in court next month.";
                }
                case 4 -> {
                    isBadNews = true;
                    breakingNews = true;
                    stockTrend = stockTrend - 1;
                    return "News: " + name + " experiences a significant drop in quarterly earnings. Analysts express concerns about the company's financial performance.";
                }
                case 5 -> {
                    isBadNews = false;
                    breakingNews = true;
                    stockTrend = stockTrend + 1;
                    return "News: " + name + " secures a major contract with a prominent client, boosting investor confidence in the company's prospects.";
                }
                case 6 -> {
                    isBadNews = false;
                    breakingNews = true;
                    stockTrend = stockTrend + 1;
                    return "News: " + name + " unveils an innovative product that is expected to revolutionize the industry. Experts predict strong market demand.";
                }
                case 7 -> {
                    isBadNews = false;
                    breakingNews = true;
                    stockTrend = stockTrend + 1;
                    return "News: " + name + " receives a positive rating upgrade from a leading credit agency. The company's creditworthiness is now considered strong.";
                }
                case 8 -> {
                    isBadNews = false;
                    breakingNews = true;
                    stockTrend = stockTrend + 1;
                    return "News: " + name + " announces plans for expansion into new international markets, aiming to tap into emerging opportunities.";
                }
                case 9 -> {
                    isBadNews = false;
                    breakingNews = true;
                    stockTrend = stockTrend + 1;
                    return "News: " + name + " forms a strategic partnership with a global industry leader. The collaboration is expected to drive growth and innovation.";
                }
                default -> {
                    breakingNews = false;
                    stockTrend = stockTrend;
                    return "No breaking news available at the moment.";
                }
            }
        }
    }


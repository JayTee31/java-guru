package chapter9;

public class Solution92 {
    public static void main(String[] args) {
        Stock stock = new Stock("Oracle", "ORCL");
        stock.setPreviousClosingPrice(34.5);
        stock.setCurrentPrice(34.35);
        System.out.println(stock.getChangePercent());

    }

    public static class Stock {
        private final String name;
        private final String symbol;
        private double previousClosingPrice;
        private double currentPrice;

        Stock(final String name, final String symbol) {
            this.name = name;
            this.symbol = symbol;
        }

        public void setPreviousClosingPrice(double previousClosingPrice) {
            this.previousClosingPrice = previousClosingPrice;
        }

        public void setCurrentPrice(double currentPrice) {
            this.currentPrice = currentPrice;
        }

        public double getChangePercent() {
            if (previousClosingPrice <= 0) {
                throw new IllegalArgumentException();
            }

            return Math.abs(previousClosingPrice - currentPrice) / previousClosingPrice * 100;
        }
    }
}

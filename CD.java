public abstract class CD {
    private int CDNo;
    private String title;
    private double cost;
    private String genre;
    private int stockLevel;

    public CD(int CDNo, String title, double cost, String genre, int stockLevel) {
        this.CDNo = CDNo;
        this.title = title;
        this.cost = cost;
        this.genre = genre;
        this.stockLevel = stockLevel;
    }

    public int getCDNo() {
        return CDNo;
    }

    public void setCDNo(int CDNo) {
        this.CDNo = CDNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }

    public String borrow(String title, int stockLevel) {
        if (stockLevel > 2) {
            return "Can borrow CD: " + title;
        }
        return "Cannot borrow CD: " + title;
    }

    public void returnCD(String title, int stockLevel) {
        this.stockLevel++;
        System.out.println("Returned CD: " + title);
    }

    public abstract void buy(Customer cust);
}

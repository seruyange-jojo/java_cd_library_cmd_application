public class MovieCD extends CD {
    private String duration;
    private String movieType;

    public MovieCD(int CDNo, String title, double cost, String genre, int stockLevel, String duration, String movieType) {
        super(CDNo, title, cost, genre, stockLevel);
        this.duration = duration;
        this.movieType = movieType;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMovieType() {
        return movieType;
    }

    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    @Override
    public String toString() {
        return "MovieCD [duration=" + duration + ", movieType=" + movieType +
               ", " + super.toString() + "]";
    }

    @Override
    public void buy(Customer cust) {
        System.out.println("MovieCD order");
        System.out.println(cust.getName() + " [" + getTitle() + "] " + getCost() +
                           " " + cust.getTelephone());
    }
}

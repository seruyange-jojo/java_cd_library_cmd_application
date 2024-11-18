import java.util.Arrays;

public class MusicCD extends CD {
    private String[] songs;

    public MusicCD(int CDNo, String title, double cost, String genre, int stockLevel, String[] songs) {
        super(CDNo, title, cost, genre, stockLevel);
        this.songs = songs;
    }

    public String[] getSongs() {
        return songs;
    }

    public void setSongs(String[] songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "MusicCD [songs=" + Arrays.toString(songs) + ", " + super.toString() + "]";
    }

    @Override
    public void buy(Customer cust) {
        System.out.println("Music CD order");
        System.out.println(cust.getName() + " [" + getTitle() + "] " + getCost() +
                           " " + cust.getTelephone());
    }
}

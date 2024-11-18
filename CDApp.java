import java.util.*;

public class CDApp {
    public static void main(String[] args) {

        MusicCD music1 = new MusicCD(101, "Wizkid", 50000, "Afrobeats", 6,
                new String[] { "Essence", "Blessed", "No Stress" });
        MusicCD music2 = new MusicCD(102, "Chameleone Collection", 35000, "Reggae", 5,
                new String[] { "Mama Mia", "Kipepeo", "Shida Za Dunia" });

        MovieCD movie1 = new MovieCD(301, "The Shawshank Redemption", 35000, "Drama", 10,
                "2hrs", "Drama");
        MovieCD movie2 = new MovieCD(302, "Crazy Wedding", 40000, "Romantic Comedy", 4,
                "2.5hrs", "Romantic Comedy");
        MovieCD movie3 = new MovieCD(303, "Spider-Man: No Way Home", 45000, "Action", 4,
                "2.5hrs", "Action");

        List<CD> cdLibrary = new ArrayList<>();
        cdLibrary.add(music1);
        cdLibrary.add(music2);
        cdLibrary.add(movie1);
        cdLibrary.add(movie2);
        cdLibrary.add(movie3);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nCD Library Application Menu");
            System.out.println("======================================");
            System.out.println("1. Borrow a CD");
            System.out.println("2. Return a CD");
            System.out.println("3. Buy a Music CD");
            System.out.println("4. Buy a Movie CD");
            System.out.println("5. Exit");
            System.out.print("Enter Menu Option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:

                    displayAvailableCDs(cdLibrary);
                    System.out.print("Enter CD title to borrow: ");
                    scanner.nextLine();
                    String borrowTitle = scanner.nextLine();
                    borrowCD(cdLibrary, borrowTitle);
                    break;

                case 2:

                    displayAllCDs(cdLibrary);
                    System.out.print("Enter CD title to return: ");
                    scanner.nextLine();
                    String returnTitle = scanner.nextLine();
                    returnCD(cdLibrary, returnTitle);
                    break;

                case 3:

                    displaySpecificCDs(cdLibrary, MusicCD.class);
                    buyCD(cdLibrary, scanner, "Music");
                    break;

                case 4:

                    displaySpecificCDs(cdLibrary, MovieCD.class);
                    buyCD(cdLibrary, scanner, "Movie");
                    break;

                case 5:

                    System.out.println("Exiting CD Library Application.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void displayAvailableCDs(List<CD> cdLibrary) {
        System.out.println("\nAvailable CDs for Borrowing:");
        System.out.println("=============================");
        for (CD cd : cdLibrary) {
            if (cd.getStockLevel() > 0) {
                System.out.println(cd.getTitle() + " (" + cd.getStockLevel() + " left)");
            }
        }
    }

    private static void displayAllCDs(List<CD> cdLibrary) {
        System.out.println("\nAll CDs in Library:");
        System.out.println("====================");
        for (CD cd : cdLibrary) {
            System.out.println(cd.getTitle() + " (" + cd.getStockLevel() + " left)");
        }
    }

    private static void displaySpecificCDs(List<CD> cdLibrary, Class<?> cdType) {
        System.out.println("\nAvailable " + cdType.getSimpleName() + "s for Purchase:");
        System.out.println("=================================================");
        for (CD cd : cdLibrary) {
            if (cdType.isInstance(cd)) {
                System.out.println(cd.getCDNo() + ". " + cd.getTitle() + " - " +
                        cd.getCost() + " (" + cd.getStockLevel() + " left)");
            }
        }
    }

    private static void borrowCD(List<CD> cdLibrary, String title) {
        for (CD cd : cdLibrary) {
            if (cd.getTitle().equalsIgnoreCase(title)) {
                System.out.println(cd.borrow(cd.getTitle(), cd.getStockLevel()));
                if (cd.getStockLevel() > 2) {
                    cd.setStockLevel(cd.getStockLevel() - 1);
                }
                return;
            }
        }
        System.out.println("CD not found.");
    }

    private static void returnCD(List<CD> cdLibrary, String title) {
        for (CD cd : cdLibrary) {
            if (cd.getTitle().equalsIgnoreCase(title)) {
                cd.returnCD(cd.getTitle(), cd.getStockLevel());
                return;
            }
        }
        System.out.println("CD not found.");
    }

    private static void buyCD(List<CD> cdLibrary, Scanner scanner, String type) {
        System.out.print("Your Name: ");
        scanner.nextLine();
        String name = scanner.nextLine();

        System.out.print("Your Telephone: ");
        String telephone = scanner.nextLine();

        System.out.print("How many CDs: ");
        int numCDs = scanner.nextInt();

        String[] orders = new String[numCDs];
        double totalCost = 0;

        for (int i = 0; i < numCDs; i++) {
            System.out.print("Enter CDNo: ");
            int cdNo = scanner.nextInt();

            for (CD cd : cdLibrary) {
                if (cd.getCDNo() == cdNo && ((type.equals("Music") && cd instanceof MusicCD) ||
                        (type.equals("Movie") && cd instanceof MovieCD))) {
                    orders[i] = cd.getTitle();
                    totalCost += cd.getCost();
                    cd.setStockLevel(cd.getStockLevel() - 1);
                    break;
                }
            }
        }

        Customer customer = new Customer(name, orders, totalCost, telephone);
        System.out.println("\n" + type + " CD Order:");
        System.out.println(customer.toString());
    }
}

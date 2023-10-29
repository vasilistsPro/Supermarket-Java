import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SupermarketPlay {

    private static Scanner in = new Scanner(System.in);
    private static Supermarket primary = new Supermarket();

    public static void main(String args[]) {
        boolean exit = false;
        int option = 0;
        menu();

        do {
            try {
                option = in.nextInt();
            } catch (InputMismatchException e) {
                in.nextLine();
                option = -1;
            }
            if (option == 0) {
                exit = true;
            }

            switch (option) {
                case 1:
                    insertProduct();
                    break;
                case 2:
                    modifyProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    findProduct();
                    break;
                case 5:
                    String[] copieSup = copySup();
                    if (Arrays.equals(copieSup, primary.getProducts()))
                        System.out.println("Η αντιγραφή έγινε με επιτυχία");
                    break;
                case 6:
                    primary.showProducts();
                    System.out.println("Παρακαλώ επιλέξτε έναν αριθμό μεταξύ του 1 και του 8.");
                    break;
                case 7:
                    menu(); // Added to show the menu again
                    break;
            }
        } while (!exit);

        System.out.println("Τέλος του προγράμματος.");
    }

    private static void insertProduct() {
        System.out.println("Παρακαλώ γράψτε το όνομα του προϊόντος.");
        String newProduct = in.next();
        if (primary.insert(newProduct)) System.out.println("Η προσθήκη του προϊόντος έγινε με επιτυχία.");
    }

    private static void modifyProduct() {
        System.out.println("Παρακαλώ γράψτε το προϊόν που επιθυμείτε να τροποποιήσετε.");
        String oldProduct = in.next();
        System.out.println("Παρακαλώ γράψτε το νέο προϊόν.");
        String newProduct = in.next();
        if (primary.update(oldProduct, newProduct))
            System.out.println("Η ενημέρωση του προϊόντος έγινε με επιτυχία.");
        else
            System.out.println("Δεν βρέθηκε το προϊόν.");
    }

    private static void deleteProduct() {
        System.out.println("Παρακαλώ γράψτε το προϊόν που επιθυμείτε να διαγράψετε.");
        if (primary.delete(in.next())) System.out.println("Η διαγραφή του προϊόντοε έγινε με επιτυχία.");
    }

    private static void findProduct() {
        System.out.println("Παρακαλώ δώστε το προϊόν που επιθυμείτε να αναζητήσετε.");
        if (primary.isOnFile(in.next())) System.out.println("Το προϊόν υπάρχει ήδη.");
        else System.out.println("Το προϊόν δεν υπάρχει.");
    }

    private static String[] copySup() {
        return primary.copySupermarket();
    }

    private static void menu() {
        System.out.println("Παρακαλώ επιλέξτε έναν αριθμό από τους παρακάτω:");
        System.out.println("1. Για εισαγωγή προϊόντος.");
        System.out.println("2. Για ενημέρωση προϊόντος.");
        System.out.println("3. Για διαγραφή προϊόντος.");
        System.out.println("4. Για αναζήτηση προϊόντος.");
        System.out.println("5. Για αντιγραφή του πίνακα.");
        System.out.println("6. Για εμφάνιση του πίνακα.");
        System.out.println("7. Για εμφάνιση του μενού.");
        System.out.println("8. Για έξοδο.");
    }
}

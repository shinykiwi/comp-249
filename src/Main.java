import java.util.Objects;
import java.util.Scanner;  // Import the Scanner class

public class Main {

    final static String password = "249";

    public static void main(String[] args) {

        /**
         * Part II
         * @author Kira Fountain, 40192824
         */

        // Displaying a welcome message to user
        System.out.println("Welcome user!");

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the maximum number of books that your bookstore can contain.");

        int maxBooks = input.nextInt();

        Book inventory[];

        System.out.println("What do you want to do?\n" +
                "1. Enter new books (password required)\n" +
                "2. Change information of a book\n" +
                "3. Display all books by a specific author\n" +
                "4. Display all books under a certain price.\n" +
                "5. Quit.\n" +
                "Please enter your choice.");

        int choice = 0;

        while (choice != 5) {

            choice = input.nextInt();

            switch (choice){
                case 1:
                    int attempts = 3;

                    while(attempts != 0){

                        System.out.println("Please enter your password:");

                        String inputPass = input.next();

                        attempts--;

                        // If the input does not match the password
                        if (Objects.equals(inputPass, password)){
                            attempts = 0;
                            System.out.println("Success!");
                        }
                        else {



                        }





                    }





            }
        }






    }
}


import java.util.Objects;
import java.util.Scanner;  // Import the Scanner class

public class Main {

    final static String password = "249";
    static int passwordCounter = 4;


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

        Book inventory[] = new Book[maxBooks];

        int choice = 0;

        while (choice != 5) {
            System.out.println("""

                    What do you want to do?
                    1. Enter new books (password required)
                    2. Change information of a book
                    3. Display all books by a specific author
                    4. Display all books under a certain price.
                    5. Quit.
                    Please enter your choice:""");

            choice = input.nextInt();

            switch (choice){
                case 1:
                    int attempts = 3;

                    if (passwordCounter == 0){
                        System.out.println("Program detected suspicious activities and will terminate immediately!");
                        System.exit(0);
                    }
                    else{

                        attempts = getAttempts(input, attempts);

                        // If there are no more attempts available
                        if (attempts == 0){
                            choice = 0; // resetting the choice
                            passwordCounter--;
                            break; // break out of the switch statement, bringing back to menu
                        }

                        // Any other outcome, aka what happens when the user enters password correctly
                        else{
                            System.out.println("How many books do you want to enter?");
                            int booksToEnter = input.nextInt();
                            int entryPoint = 0;
                            int currentBooksAmt = 0;

                            // Looping through the current inventory list
                            for(int i = 0; i< inventory.length; i++){
                                // If the element is filled, increase the current number of books
                                if (inventory[i] != null){
                                    currentBooksAmt++;
                                }

                                // Otherwise, remember the entry point for later
                                else{
                                    entryPoint = i;
                                    break;
                                }
                            }

                            // If there's enough room to add more books then begin add process
                            if ((inventory.length - currentBooksAmt) >= booksToEnter){

                                // Adding books
                                for (int i = 0; i < booksToEnter; i++){

                                    inventory[entryPoint] = new Book();

                                    System.out.println("Please enter the following information about the book.\n" +
                                            "Title:");
                                    inventory[entryPoint].setTitle(input.nextLine());
                                    inventory[entryPoint].setTitle(input.nextLine());

                                    System.out.println("Author:");
                                    inventory[entryPoint].setAuthor(input.nextLine());

                                    System.out.println("Price:");
                                    inventory[entryPoint].setPrice(input.nextDouble());

                                    System.out.println("ISBN:");
                                    inventory[entryPoint].setISBN(input.nextLong());

                                    System.out.println("\""+inventory[entryPoint].title + "\" added successfully.");
                                    entryPoint++;
                                }


                            }
                            // If there's not enough room for the entered amount of books
                            else{
                                System.out.println("There's not enough inventory space to hold " + booksToEnter + " more books!");
                                break;
                            }
                        }
                    }

                    break;


                case 2:

                    attempts = 3;

                    attempts = getAttempts(input, attempts);

                    // If there are no more attempts available
                    if (attempts == 0){
                        choice = 0; // resetting the choice
                        break; // break out of the switch statement, bringing back to menu
                    }
                    else{

                        int miniMenuChoice = 0;
                        while(miniMenuChoice!= 2){
                            System.out.println("Which book number would you like to update?");
                            int bookIndex = input.nextInt();

                            if(inventory[bookIndex] == null){
                                System.out.println("There's no book associated with that number. Would you like to enter another book number or return to menu?");
                                System.out.println("1. Re-enter\n" +
                                        "2. Return to menu");
                                 miniMenuChoice = input.nextInt();

                            }
                            else{
                                int infoChangeChoice = 0;
                                while(infoChangeChoice != 5){
                                    // Displaying current book info
                                    System.out.println("Book #"+ bookIndex + inventory[bookIndex]);

                                    // Forcing the user to enter a number between 1 and 5
                                    while(infoChangeChoice < 1 || infoChangeChoice > 5){
                                        System.out.println("What information would you like to change?");
                                        System.out.println(
                                                """
                                                        1. author
                                                        2. title
                                                        3. ISBN
                                                        4. price
                                                        5. Quit""");

                                        infoChangeChoice = input.nextInt();
                                    }

                                    // Handling the choice
                                    switch (infoChangeChoice){
                                        // Change author
                                        case 1:
                                            System.out.println("Please enter a new author:");
                                            inventory[bookIndex].setAuthor(input.nextLine());
                                            inventory[bookIndex].setAuthor(input.nextLine());
                                            infoChangeChoice = 0;
                                            break;

                                        // Change title
                                        case 2:
                                            System.out.println("Please enter a new title:");
                                            inventory[bookIndex].setTitle(input.nextLine());
                                            inventory[bookIndex].setTitle(input.nextLine());
                                            infoChangeChoice = 0;
                                            break;

                                        // Change ISBN
                                        case 3:
                                            System.out.println("Please enter a new ISBN number:");
                                            inventory[bookIndex].setISBN(input.nextLong());
                                            infoChangeChoice = 0;
                                            break;

                                        // Change price
                                        case 4:
                                            System.out.println("Please enter a new price:");
                                            inventory[bookIndex].setPrice(input.nextInt());
                                            infoChangeChoice = 0;
                                            break;

                                        // Quit the menu
                                        case 5:
                                            break;

                                    }


                                }





                                break;
                            }
                        }
                        break;

                    }

                case 3:

                    System.out.println("Please enter an author name:");
                    String authorName = input.nextLine();
                    authorName = input.nextLine();
                    findBooksByAuthor(authorName, inventory);
                    break;


                case 4:
                    System.out.println("Please enter a price:");
                    double inputPrice = input.nextDouble();
                    findBooksCheaperThan(inputPrice, inventory);
                    break;


            }



        }

        System.out.println("Goodbye!");
    }

    private static int getAttempts(Scanner input, int attempts) {
        while(attempts != 0){


            System.out.println("Please enter your password:");

            String inputPass = input.next();

            attempts--;

            // If the input matches the password
            if (Objects.equals(inputPass, password)){
                attempts += 1;
                System.out.println("Success!");
                break;
            }
        }
        return attempts;
    }

    private static void findBooksByAuthor(String author, Book[] books){

        for (Book b: books
             ) {
            if (b != null){
                if (Objects.equals(b.author, author)){
                    System.out.println(b);
                }
            }


        }
    }

    private static void findBooksCheaperThan(double price, Book[] books){

        for(Book b: books
        ){
            if(b != null){
                if (b.price < price){
                    System.out.println(b);
                }
            }

        }
    }
}




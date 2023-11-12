package a2;
import a2.Exceptions.*;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        //do_part1();

        //do_part2();

        do_part3();
    }

    // validating syntax partition book records based on genre
    public static void do_part1() {
        int numberOfFiles;
        File[] tempFiles;

        try {
            Scanner scanner = new Scanner(new FileInputStream("src/a2/files/part1_input_file_names.txt"));

            PrintWriter pw = new PrintWriter(new FileOutputStream("src/a2/files/syntax_error_file.txt"));

            PrintWriter ccb = new PrintWriter(new FileOutputStream("src/a2/files/genres/Cartoons_Comics.csv.txt"));  // 0
            PrintWriter hcb = new PrintWriter(new FileOutputStream("src/a2/files/genres/Hobbies_Collectibles.csv.txt")); // 1
            PrintWriter mtv = new PrintWriter(new FileOutputStream("src/a2/files/genres/Movies_TV_Books.csv.txt")); // 2
            PrintWriter mrb = new PrintWriter(new FileOutputStream("src/a2/files/genres/Music_Radio_Books.csv.txt")); // 3
            PrintWriter neb = new PrintWriter(new FileOutputStream("src/a2/files/genres/Nostalgia_Eclectic_Books.csv.txt")); // 4
            PrintWriter otr = new PrintWriter(new FileOutputStream("src/a2/files/genres/Old_Time_Radio_Books.csv.txt")); // 5
            PrintWriter ssm = new PrintWriter(new FileOutputStream("src/a2/files/genres/Sports_Sports_Memorabilia.csv.txt")); // 6
            PrintWriter tpa = new PrintWriter(new FileOutputStream("src/a2/files/genres/Trains_Planes_Automobiles.csv.txt")); // 7

            numberOfFiles = scanner.nextInt();
            tempFiles = new File[numberOfFiles];
            System.out.println("Reading files...\n");
            int i = 0;
            scanner.nextLine();

            while (scanner.hasNextLine()) {

                File file = new File("src/a2/files/" + scanner.nextLine());

                if (file.exists()) {
                    if (file.length() < 1) {
                        System.out.println("\"" + file.getName() + "\" has no contents.");
                    } else {
                        System.out.println("\"" + file.getName() + "\" loaded successfully.");
                        tempFiles[i] = file;
                        i++;

                    }
                } else {
                    System.out.println("\"" + file.getName() + "\" could not be found.");
                }
            }

            scanner.close();

            File[] validFiles = new File[i + 1];
            // for each valid file
            for (int j = 0; j < validFiles.length; j++) {

                validFiles[j] = tempFiles[j];
            }

            // for each valid file
            for (File file : validFiles) {
                String fileErrors = "";
                try {
                    System.out.println("Reading file: " + file.getName() + "\n----------------------------");
                    Scanner reader = new Scanner(file);

                    String title;
                    String otherFields;
                    fileErrors = "";

                    while (reader.hasNext()) {
//                        System.out.println("top");
                        reader.useDelimiter(" ");
                        title = reader.next();
//                        System.out.println("reader.next is " + title);
                        String extra = null;

                        // Getting the title
                        if (title.charAt(0) == '"') {
                            reader.useDelimiter("\"");
                            title += reader.next();
                            title = title.substring(1);

                            otherFields = reader.nextLine().substring(2);

                        } else {
//                            System.out.println("got here");
                            //if there's a comma somewhere in there

                            String s;

                            if (title.indexOf(',') != -1){
                                extra = title.split(",")[1];
                                title = title.split(",")[0];

                            }else{
                                reader.useDelimiter(",");
                                s = reader.next();
                                title += s;
                            }
                            System.out.println(title);

                            otherFields = reader.nextLine().substring(1);
                            //System.out.println("Other fields" + otherFields);
                        }

                        String[] fields = otherFields.split(",");

                        String genre = fields[3];

                        if (extra != null){
                            fields[0] = extra + " " +fields[0];
                        }
                        String author = fields[0];
                        short year = 0;
                        long isbn = 0;
                        double price = 0;

                        //System.out.println(Arrays.toString(fields));

                        try {
                            try {
                                // If there's too many fields
                                if (fields.length > 5) {
                                    throw new TooManyFieldsException(fields);
                                } else if (fields.length < 5) {
//                                    System.out.println("too few fields");
                                    throw new TooFewFieldsException(fields);
                                }

                                // Unknown genre exception
                                if (!(genre.equals("CCB") || genre.equals("HCB") || genre.equals("MTV") || genre.equals("MRB") || genre.equals("NEB") || genre.equals("OTR") || genre.equals("SSM") || genre.equals("TPA"))) {
                                    throw new UnknownGenreException(fields);
                                }

                                // Missing field exceptions
                                try {
                                    price = Double.parseDouble(fields[1]);

                                    try {
                                        isbn = Long.parseLong(fields[2]);

                                        try {
                                            year = Short.parseShort(fields[4]);
                                        } catch (NumberFormatException e) {
                                            throw new MissingFieldException("year", fields);
                                        }


                                    } catch (NumberFormatException e) {
                                        throw new MissingFieldException("isbn", fields);
                                    }
                                } catch (NumberFormatException e) {
                                    throw new MissingFieldException("price", fields);
                                }

                            } catch (TooManyFieldsException e) {
                                fileErrors += e.msg + "\n";
                                System.out.println(ANSI_RED + e.msg + ANSI_RESET);
                            } catch (TooFewFieldsException e) {
                                fileErrors += e.msg + "\n";
                                System.out.println(ANSI_RED + e.msg + ANSI_RESET);
                            }

                        } catch (MissingFieldException e) {
                            fileErrors += e.msg + "\n";

                        } catch (UnknownGenreException e) {
                            fileErrors += e.msg + "\n";

                        } finally {
//                            System.out.println("bottom");
                            reader.useDelimiter(" ");
                        }

                        short[] genreCount = new short[8];

                        String output = "\""+title + "\"," + author  + "," + price + "," + isbn + "," + genre + "," + year;

                        switch (genre){
                            case "CCB":
                                genreCount[0]++;
                                ccb.println(output);
                                ccb.flush();
                                break;
                            case "HCB":
                                genreCount[1]++;
                                hcb.println(output);
                                hcb.flush();
                                break;
                            case "MTV":
                                genreCount[2]++;
                                mtv.println(output);
                                mtv.flush();
                                break;
                            case "MRB":
                                genreCount[3]++;
                                mrb.println(output);
                                mrb.flush();
                                break;
                            case "NEB":
                                genreCount[4]++;
                                neb.println(output);
                                neb.flush();
                                break;
                            case "OTR":
                                genreCount[5]++;
                                otr.println(output);
                                otr.flush();
                                break;
                            case "SSM":
                                genreCount[6]++;
                                ssm.println(output);
                                ssm.flush();
                                break;
                            case "TPA":
                                genreCount[7]++;
                                tpa.println(output);
                                tpa.flush();
                                break;
                            default:
                                System.out.println(ANSI_RED + genre + ANSI_RESET);
                        }

                    }

                    if (!fileErrors.equals("")) {
                        pw.println("syntax error in file" + file.getName() + "\n===========================\n" + fileErrors);
                    }

                    fileErrors = "\n";
                    pw.flush();

                } catch (FileNotFoundException e) {
                    System.out.println("Could not find file.");
                    System.exit(-1);
                } catch (NullPointerException e) {
                    System.exit(0);
                }

            }
            pw.close();
            scanner.close();
            ccb.close();
            hcb.close();
            mtv.close();
            mrb.close();
            neb.close();
            otr.close();
            ssm.close();
            tpa.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Could not find file.");
            System.exit(-1);
        }

    }
    public static void do_part2(){

        Book[] validBooks;


        String[] fileNames = {"Cartoons_Comics", "Hobbies_Collectibles", "Movies_TV_Books",
        "Music_Radio_Books", "Nostalgia_Eclectic_Books", "Old_Time_Radio_Books",
        "Sports_Sports_Memorabilia", "Trains_Planes_Automobiles"};


        for (String path : fileNames){

            int counter = 0;

            try{
                Scanner reader = new Scanner(new FileInputStream("src/a2/files/genres/" + path + ".csv.txt"));
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/a2/files/binaries/" + path + ".csv.ser"));

                while (reader.hasNextLine()){
                    reader.nextLine();
                    counter++;
                }

                reader.close();

                validBooks = new Book[counter];

                reader = new Scanner(new FileInputStream("src/a2/files/genres/" + path + ".csv.txt"));


                for(int j = 0; j < validBooks.length; j++){
                    String s = reader.nextLine();
                    String[] fields = s.split(",");

                    Book book = new Book();

                    book.setGenre(fields[fields.length -2]);


                    double price = Double.parseDouble(fields[fields.length - 4]);
                    int year = Integer.parseInt(fields[fields.length-1]);
                    String isbn = fields[fields.length - 3];

                    try{
                        if (price < 0.0){
                            throw new BadPriceException("Price cannot be lower than $0!");
                        }

                        // made to this line means its good price
                        book.setPrice(price);

                        try{
                            if (!(year >= 1995 && year <= 2010)){
                                throw new BadYearException("Year does not fall within the accepted range/");
                            }

                            // by now both price and year are good
                            book.setYear(year);

                            // validating ISBN


                            char[] chars = new char[isbn.length()];
                            int sum = 0;

                            // ISBN 10
                            if (chars.length == 10){

                                for (int i = 0; i < chars.length; i++){
                                    sum += (int) chars[i] * 10-i;
                                }

                                try{
                                    if (sum % 11 != 0){
                                        throw new BadIsbn10Exception("Invalid isbn 10");
                                    }
                                    else{
                                        book.setIsbn(isbn);
                                    }

                                }
                                catch (BadIsbn10Exception e){
                                    System.out.println(e.msg);
                                }


                                // ISBN 13
                            }
                            else if (chars.length == 13) {

                                for (int i = 0; i < chars.length; i++){
                                    if (i % 2 == 0){
                                        sum += (int) chars[i] * 3;
                                    }
                                    else{
                                        sum += (int) chars[i];
                                    }

                                }

                                try{
                                    if(sum % 13 != 0){
                                        throw new BadIsbn13Exception("Invalid isbn 13");
                                    }
                                    else{
                                        book.setIsbn(isbn);
                                    }
                                }
                                catch(BadIsbn13Exception e){
                                    System.out.println(e.msg);
                                }


                            }

                        }
                        catch (BadYearException e){
                            System.out.println(e.msg);

                        }

                    }
                    catch(BadPriceException e){
                        System.out.println(e.msg);
                    }


                    book.setAuthor(fields[fields.length - 5]);


                    String stringBuilder = "";
                    for(int i = 0; i < fields.length - 5; i++){
                        stringBuilder += fields[i];
                    }

                    //System.out.println(stringBuilder);

                    book.setTitle(stringBuilder);

                    System.out.println(book);

                    validBooks[j] = book;

                    oos.writeObject(book);

                }

                oos.close();
                reader.close();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void do_part3(){

        String[] fileNames = {"Cartoons_Comics", "Hobbies_Collectibles", "Movies_TV_Books",
                "Music_Radio_Books", "Nostalgia_Eclectic_Books", "Old_Time_Radio_Books",
                "Sports_Sports_Memorabilia", "Trains_Planes_Automobiles"};



        Book[] books = new Book[256];
        int bookCounter = 0;

        for (String path: fileNames){
            try{
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/a2/files/binaries/" + path + ".csv.ser"));

                while(true){
                    try{
                        books[bookCounter] = (Book) ois.readObject();
                        bookCounter++;
                    }
                    catch (ClassNotFoundException e){
                        System.out.println(ANSI_RED + "Class not found!" + ANSI_RESET);
                        break;
                    }
                    catch (EOFException e){
                        break;
                    }
                }

            }
            catch(IOException e){
                e.printStackTrace();


            }
        }





    }
}
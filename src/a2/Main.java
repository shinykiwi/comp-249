package a2;
import a2.Exceptions.MissingFieldException;
import a2.Exceptions.TooFewFieldsException;
import a2.Exceptions.TooManyFieldsException;
import a2.Exceptions.UnknownGenreException;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        do_part1();


    }

    // validating syntax partition book records based on genre
    public static void do_part1() {
        int numberOfFiles;
        File[] tempFiles;

        try {
            Scanner scanner = new Scanner(new FileInputStream("src/a2/files/part1_input_file_names.txt"));

            PrintWriter pw = new PrintWriter(new FileOutputStream("src/a2/files/syntax_error_file.txt"));

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
                                    double price = Double.parseDouble(fields[1]);

                                    try {
                                        long isbn = Long.parseLong(fields[2]);

                                        try {
                                            short year = Short.parseShort(fields[4]);
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

                    }

                    if (!fileErrors.equals("")) {
                        System.out.println("GOT HERE");
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
        }
        catch (FileNotFoundException e){
            System.out.println("Could not find file.");
            System.exit(-1);
        }
    }
}
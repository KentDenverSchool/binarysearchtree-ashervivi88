/***
 * Authors: Ashley
 * Date: 12/2/19
 * Purpose: Test BinarySearchTree using tests from text file
 */

import java.io.*;
import java.util.Scanner;
public class BinarySearchTreeDriver {

    public static void main(String[] args) {
        File file = new File("test.txt");
        String results = "_______ BinarySearchTree Tests________" +
                "\nTests in format expected: actual: passed: true/false\n\n";
        try {
            //Tests method based on text file equations
            Scanner sc = new Scanner(file);
            BinarySearchTree m = new BinarySearchTree();

            boolean hasSeen999 = false;

            while (sc.hasNextLine() && sc.nextInt()!=-999) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                int size = sc.nextInt();
                int min = sc.nextInt();
                int max = sc.nextInt();
                m.put(key, value);
                results+= "\n"
                        + " Answer should be: " + value + ", Actual: " + m.get(key)
                        + "\n"
                        + " Answer should be: " + size + ", Actual: " + m.size()
                        + "\n"
                        + " Answer should be: " + min + ", Actual: " + m.min()
                        + "\n"
                        + " Answer should be: " + max + ", Actual: " + m.max()
                        + "\n";
                }
            while (sc.hasNextLine()) {
                int key = sc.nextInt();
                int value = sc.nextInt();
                int size = sc.nextInt();
                int min = sc.nextInt();
                int max = sc.nextInt();
                m.remove(key);
                results+= "\n"
                        + " Answer should be: " + value + ", Actual: " + m.remove(key)
                        + "\n"
                        + " Answer should be: " + size + ", Actual: " + m.size()
                        + "\n"
                        + " Answer should be: " + min + ", Actual: " + m.min()
                        + "\n"
                        + " Answer should be: " + max + ", Actual: " + m.max()
                        + "\n";
            }



        }  catch(Exception e){
            results += "ERROR: " + e + "\n\n"; //Returns the type of error
        }
        //Makes logfile
        Scanner s = new Scanner(System.in);
        System.out.println("Enter in name for logfile: ");
        String filename = s.nextLine() + ".txt";

        //write results to new file log.txt (need to delete before re-running test)
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "utf-8"))) {
            writer.write(results);

        } catch (IOException e) {
            System.out.println("Issues writing to log file");

        }
    }
}

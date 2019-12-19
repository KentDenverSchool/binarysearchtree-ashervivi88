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
            BinarySearchTree<Integer, Integer> m = new BinarySearchTree();

            //-999 is the signal that shows where to switch from putting to removing
            boolean hasSeen999 = false;
            int key = 0;

            //adds when 999 key has not been seen
            while (sc.hasNextLine()&& key!= -999){
                key = sc.nextInt();
                if(key != -999){
                int value = sc.nextInt();
                int size = sc.nextInt();
                int min = sc.nextInt();
                int max = sc.nextInt();
                m.put(key, value);
                    System.out.println(m);
                results+= "\n"
                        + " Get should return: " + value + ", Actual: " + m.get(key)
                        + "\n"
                        + " Size should return: " + size + ", Actual: " + m.size()
                        + "\n"
                        + " Min should be: " + min + ", Actual: " + m.min()
                        + "\n"
                        + " Max should be: " + max + ", Actual: " + m.max()
                        + "\n";
                }}

            //the remove method is only triggered when -999 has been seen
            while (sc.hasNextLine()) {
                key = sc.nextInt();
                int value = sc.nextInt();
                int size = sc.nextInt();
                results+= "\n"
                        + " Removed value should be: " + value + ", Actual: " + m.remove(key)
                        + "\n"
                        + " Size should be: " + size + ", Actual: " + m.size();

                //when size is zero, min and max output null, which is not an  integer, so results don't use a
                //logfile max or min
                if(size == 0){
                    results+= "\n"
                        + " Min should be: " + null + ", Actual: " + m.min()
                        + "\n"
                        + " Max should be: " + null + ", Actual: " + m.max()
                        + "\n";}

                else{
                int max = sc.nextInt();
                int min = sc.nextInt();
                results+= "\n"
                        + " Min should be: " + min + ", Actual: " + m.min()
                        + "\n"
                        + " Max should be: " + max + ", Actual: " + m.max()
                        + "\n";
                    System.out.println(m);
                }}



        }  catch(Exception e){
            results += "ERROR: " + e + "\n\n"; //Returns the type of error
        }
        //Makes logfile
        Scanner s = new Scanner(System.in);
        System.out.println("Enter in name for logfile: ");
        String filename = s.nextLine() + ".txt";

        //write results to new file log.txt (need to delete before re-running test.txt)
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(filename), "utf-8"))) {
            writer.write(results);

        } catch (IOException e) {
            System.out.println("Issues writing to log file");

        }
    }
}

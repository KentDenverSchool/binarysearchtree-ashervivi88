/***
 * Authors: Ashley
 * Date: 12/2/19
 * Purpose: Test BinarySearchTree using tests from text file
 */

import java.io.*;
import java.util.Scanner;
public class MinStackDriver {

    public static void main(String[] args) {
        File file = new File("test.txt");
        String results = "_______ MinStack Tests________" +
                "\nTests in format expected: actual: passed: true/false\n\n";
        try {
            //Tests method based on text file equations
            Scanner sc = new Scanner(file);
            MinStack m = new MinStack();

            while (sc.hasNextLine()) {
                String command = sc.nextLine();

                if(command.equals("pushItem")){
                    Comparable toPush = sc.nextInt();
                    results += command + ": " + toPush + "\n";
                    m.push(toPush);
                    Comparable correctNum = sc.nextInt();
                    Comparable output = m.min();
                    results+= "\n"
                            + " Answer should be: " + correctNum + ", Actual: " + output
                            + ", Passed: " + (correctNum == output)
                            + "\n";
                    sc.nextLine();
                }

                if(command.equals("popExpectedValue")){
                    Comparable popped = m.peek();
                    m.pop();
                    Comparable correctPop = sc.nextInt();
                    results+= "\n"
                            + " Answer should be: " + correctPop + ", Actual: " + popped
                            + ", Passed: " + (correctPop == popped)
                            + "\n";
                    Comparable predictedMin = sc.nextInt();
                    results+= "\n"
                            + " Answer should be: " + predictedMin + ", Actual: " + m.min()
                            + ", Passed: " + (predictedMin == m.min())
                            + "\n";
                    sc.nextLine();
                }
            }
            sc.close();

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

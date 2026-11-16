/*
 * Class: CMSC203 CRN 21305
 * Instructor: Professor Grigoriy Grinberg
 * Description: SalesAppDriver is the console driver. It asks for the input and
 *   output file names, shows the results and writes the summary file.
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse IDE, Java 21
 * I pledge that I have completed the programming assignment
 *   independently. I have not copied the code from a student or
 *   any source. I have not given my code to any student.
 * Print your Name here: Samik Gurung
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Console program that processes a sales data file.
 *
 * @author Samik Gurung
 */
public class SalesAppDriver
{
    /**
     * Reads the data, prints the results and writes the summary file.
     *
     * @param args not used
     */
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter the input file name: ");
        String inFile = keyboard.nextLine().trim();

        System.out.print("Enter the output file name: ");
        String outFile = keyboard.nextLine().trim();

        try
        {
            double[][] data = SalesFileIO.readSalesData(inFile);
            System.out.println("Data loaded from " + inFile);
            System.out.println();

            System.out.printf("Total sales: %.2f%n", SalesDataUtility.getTotal(data));
            System.out.printf("Average sale: %.2f%n", SalesDataUtility.getAverage(data));
            System.out.printf("Highest sale: %.2f%n", SalesDataUtility.getHighestInArray(data));
            System.out.printf("Lowest sale: %.2f%n", SalesDataUtility.getLowestInArray(data));
            System.out.println();

            for (int row = 0; row < data.length; row++)
            {
                System.out.printf("Row %d total: %.2f (highest %.2f, lowest %.2f)%n", row,
                        SalesDataUtility.getRowTotal(data, row),
                        SalesDataUtility.getHighestInRow(data, row),
                        SalesDataUtility.getLowestInRow(data, row));
            }

            for (int col = 0; col < SalesDataUtility.getMaxColumns(data); col++)
            {
                System.out.printf("Column %d total: %.2f%n", col, SalesDataUtility.getColumnTotal(data, col));
            }

            SalesFileIO.writeSummary(outFile, data);
            System.out.println();
            System.out.println("Summary written to " + outFile);
        }
        catch (FileNotFoundException e)
        {
            System.out.println("ERROR: Input file not found.");
        }
        catch (NumberFormatException e)
        {
            System.out.println("ERROR: Invalid number in data file.");
        }
        catch (IOException e)
        {
            System.out.println("ERROR writing summary: " + e.getMessage());
        }

        System.out.println("Programmed by: Samik Gurung");
        keyboard.close();
    }
}

/*
 * Class: CMSC203 CRN 21305
 * Instructor: Professor Grigoriy Grinberg
 * Description: SalesFileIO reads sales data from a text file into a ragged
 *   2D array and writes a summary of the data to an output file.
* Due: 11/16/2026
 * Platform/compiler: Eclipse IDE, Java 21
 * I pledge that I have completed the programming assignment
 *   independently. I have not copied the code from a student or
 *   any source. I have not given my code to any student.
 * Print your Name here: Samik Gurung
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Reads and writes sales data files.
 *
 * @author Samik Gurung
 */
public class SalesFileIO
{
    /**
     * Reads a file where each line holds one department's sales,
     * separated by spaces. Blank lines are skipped.
     *
     * @param filename the name of the input file
     * @return a ragged 2D array with one row per line
     * @throws FileNotFoundException if the file does not exist
     */
    public static double[][] readSalesData(String filename) throws FileNotFoundException
    {
        // First pass: count the lines that have data
        Scanner inputFile = new Scanner(new File(filename));
        int rows = 0;

        while (inputFile.hasNextLine())
        {
            if (!inputFile.nextLine().trim().isEmpty())
            {
                rows++;
            }
        }
        inputFile.close();

        // Second pass: fill each row
        double[][] data = new double[rows][];
        inputFile = new Scanner(new File(filename));
        int row = 0;

        while (inputFile.hasNextLine())
        {
            String line = inputFile.nextLine().trim();

            if (!line.isEmpty())
            {
                String[] tokens = line.split("\\s+");
                data[row] = new double[tokens.length];

                for (int col = 0; col < tokens.length; col++)
                {
                    data[row][col] = Double.parseDouble(tokens[col]);
                }

                row++;
            }
        }
        inputFile.close();

        return data;
    }

    /**
     * Writes the total, average, highest, lowest, row totals and
     * column totals to an output file.
     *
     * @param filename the name of the output file
     * @param data the sales data
     * @throws IOException if the file cannot be written
     */
    public static void writeSummary(String filename, double[][] data) throws IOException
    {
        PrintWriter outputFile = new PrintWriter(filename);

        outputFile.printf("Total sales: %.2f%n", SalesDataUtility.getTotal(data));
        outputFile.printf("Average sale: %.2f%n", SalesDataUtility.getAverage(data));
        outputFile.printf("Highest sale: %.2f%n", SalesDataUtility.getHighestInArray(data));
        outputFile.printf("Lowest sale: %.2f%n", SalesDataUtility.getLowestInArray(data));

        for (int row = 0; row < data.length; row++)
        {
            outputFile.printf("Row %d total: %.2f%n", row, SalesDataUtility.getRowTotal(data, row));
        }

        for (int col = 0; col < SalesDataUtility.getMaxColumns(data); col++)
        {
            outputFile.printf("Column %d total: %.2f%n", col, SalesDataUtility.getColumnTotal(data, col));
        }

        outputFile.close();
    }
}

/*
 * Class: CMSC203 CRN 21305
 * Instructor: Professor Grigoriy Grinberg
 * Description: SalesDataUtility has static methods that find totals, averages,
 *   and highest/lowest values in a ragged 2D array of sales.
 * Due: 11/16/2026
 * Platform/compiler: Eclipse IDE, Java 21
 * I pledge that I have completed the programming assignment
 *   independently. I have not copied the code from a student or
 *   any source. I have not given my code to any student.
 * Print your Name here: Samik Gurung
 */

/**
 * Static methods for working with a ragged 2D array of sales.
 * Each row is a department and each column is a day.
 *
 * @author Samik Gurung
 */
public class SalesDataUtility
{
    /**
     * Adds up every value in the array.
     *
     * @param data the sales data
     * @return the total of all values
     */
    public static double getTotal(double[][] data)
    {
        double total = 0;

        for (int row = 0; row < data.length; row++)
        {
            for (int col = 0; col < data[row].length; col++)
            {
                total = total + data[row][col];
            }
        }

        return total;
    }

    /**
     * Finds the average of every value in the array.
     *
     * @param data the sales data
     * @return the average, or 0 if there are no values
     */
    public static double getAverage(double[][] data)
    {
        int count = 0;

        for (int row = 0; row < data.length; row++)
        {
            count = count + data[row].length;
        }

        if (count == 0)
        {
            return 0;
        }

        return getTotal(data) / count;
    }

    /**
     * Adds up the values in one row.
     *
     * @param data the sales data
     * @param row the row index
     * @return the total of that row
     */
    public static double getRowTotal(double[][] data, int row)
    {
        double total = 0;

        for (int col = 0; col < data[row].length; col++)
        {
            total = total + data[row][col];
        }

        return total;
    }

    /**
     * Adds up the values in one column. Rows that are too short
     * to have this column are skipped.
     *
     * @param data the sales data
     * @param col the column index
     * @return the total of that column
     */
    public static double getColumnTotal(double[][] data, int col)
    {
        double total = 0;

        for (int row = 0; row < data.length; row++)
        {
            if (col < data[row].length)
            {
                total = total + data[row][col];
            }
        }

        return total;
    }

    /**
     * Finds the highest value in one row.
     *
     * @param data the sales data
     * @param row the row index
     * @return the highest value in that row
     */
    public static double getHighestInRow(double[][] data, int row)
    {
        double highest = data[row][0];

        for (int col = 1; col < data[row].length; col++)
        {
            if (data[row][col] > highest)
            {
                highest = data[row][col];
            }
        }

        return highest;
    }

    /**
     * Finds the lowest value in one row.
     *
     * @param data the sales data
     * @param row the row index
     * @return the lowest value in that row
     */
    public static double getLowestInRow(double[][] data, int row)
    {
        double lowest = data[row][0];

        for (int col = 1; col < data[row].length; col++)
        {
            if (data[row][col] < lowest)
            {
                lowest = data[row][col];
            }
        }

        return lowest;
    }

    /**
     * Finds the highest value in the whole array.
     *
     * @param data the sales data
     * @return the highest value
     */
    public static double getHighestInArray(double[][] data)
    {
        double highest = data[0][0];

        for (int row = 0; row < data.length; row++)
        {
            for (int col = 0; col < data[row].length; col++)
            {
                if (data[row][col] > highest)
                {
                    highest = data[row][col];
                }
            }
        }

        return highest;
    }

    /**
     * Finds the lowest value in the whole array.
     *
     * @param data the sales data
     * @return the lowest value
     */
    public static double getLowestInArray(double[][] data)
    {
        double lowest = data[0][0];

        for (int row = 0; row < data.length; row++)
        {
            for (int col = 0; col < data[row].length; col++)
            {
                if (data[row][col] < lowest)
                {
                    lowest = data[row][col];
                }
            }
        }

        return lowest;
    }

    /**
     * Finds the length of the longest row, which is the number of columns.
     *
     * @param data the sales data
     * @return the length of the longest row
     */
    public static int getMaxColumns(double[][] data)
    {
        int max = 0;

        for (int row = 0; row < data.length; row++)
        {
            if (data[row].length > max)
            {
                max = data[row].length;
            }
        }

        return max;
    }
}

/*
 * Class: CMSC203 CRN 21305
 * Instructor: Professor Grigoriy Grinberg
 * Description: JUnit tests for the SalesDataUtility methods.
* Due: 11/16/2026
 * Platform/compiler: Eclipse IDE, Java 21
 * I pledge that I have completed the programming assignment
 *   independently. I have not copied the code from a student or
 *   any source. I have not given my code to any student.
 * Print your Name here: Samik Gurung
 */

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit 4 tests for SalesDataUtility using a ragged array.
 *
 * @author Samik Gurung
 */
public class SalesDataUtilityJUnitStudentTest
{
    private double[][] data = {
        {10.0, 20.0, 30.0, 40.0},
        {5.0},
        {15.0, 25.0}
    };

    /** Tests getTotal. */
    @Test
    public void testGetTotal()
    {
        assertEquals(145.0, SalesDataUtility.getTotal(data), 0.001);
    }

    /** Tests getAverage: 145 / 7 values. */
    @Test
    public void testGetAverage()
    {
        assertEquals(145.0 / 7, SalesDataUtility.getAverage(data), 0.001);
    }

    /** Tests getRowTotal for each row. */
    @Test
    public void testGetRowTotal()
    {
        assertEquals(100.0, SalesDataUtility.getRowTotal(data, 0), 0.001);
        assertEquals(5.0, SalesDataUtility.getRowTotal(data, 1), 0.001);
        assertEquals(40.0, SalesDataUtility.getRowTotal(data, 2), 0.001);
    }

    /** Tests getColumnTotal, including columns only some rows have. */
    @Test
    public void testGetColumnTotal()
    {
        assertEquals(30.0, SalesDataUtility.getColumnTotal(data, 0), 0.001);
        assertEquals(45.0, SalesDataUtility.getColumnTotal(data, 1), 0.001);
        assertEquals(30.0, SalesDataUtility.getColumnTotal(data, 2), 0.001);
        assertEquals(40.0, SalesDataUtility.getColumnTotal(data, 3), 0.001);
    }

    /** Tests getHighestInRow and getLowestInRow. */
    @Test
    public void testHighestLowestInRow()
    {
        assertEquals(40.0, SalesDataUtility.getHighestInRow(data, 0), 0.001);
        assertEquals(10.0, SalesDataUtility.getLowestInRow(data, 0), 0.001);
        assertEquals(5.0, SalesDataUtility.getHighestInRow(data, 1), 0.001);
        assertEquals(5.0, SalesDataUtility.getLowestInRow(data, 1), 0.001);
    }

    /** Tests getHighestInArray and getLowestInArray. */
    @Test
    public void testHighestLowestInArray()
    {
        assertEquals(40.0, SalesDataUtility.getHighestInArray(data), 0.001);
        assertEquals(5.0, SalesDataUtility.getLowestInArray(data), 0.001);
    }
}

package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BigIntegerStructuralTest {

    // GCD Method Tests - Structural Testing (Task 2)
    @Test
    public void testGcd_xIsZero() {
        // Covers: Line 3 (true), Line 4 (true), Line 5
        // Branch: Line 3 true, Line 4 true
        // Condition: xval == 0 (true)
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("42");
        assertEquals(new BigInteger("42"), x.gcd(y));
    }

    @Test
    public void testGcd_yIsZero() {
        // Covers: Line 3 (true), Line 4 (false), Line 6 (false), Line 12, Line 13 (true), Line 14 (true), Line 15
        // Branch: Line 3 true, Line 4 false, Line 6 false, Line 13 true, Line 14 true
        // Condition: xval == 0 (false), yval == Integer.MIN_VALUE (true), yval == 0 (true)
        BigInteger x = new BigInteger("50");
        BigInteger y = new BigInteger("0");
        assertEquals(new BigInteger("50"), x.gcd(y));
    }

    @Test
    public void testGcd_xNegative_yPositive() {
        // Covers: Line 3 (true), Line 4 (false), Line 6 (true), Line 7 (true), Line 8, Line 9 (false), Line 11
        // Branch: Line 3 true, Line 4 false, Line 6 true, Line 7 true, Line 9 false
        // Condition: xval < 0 (true), yval < 0 (false)
        BigInteger x = new BigInteger("-25");
        BigInteger y = new BigInteger("15");
        assertEquals(new BigInteger("5"), x.gcd(y));
    }

    @Test
    public void testGcd_LargeNumbers() {
        // Covers: Line 3 (false), Line 13 (false), Line 17-26
        // Branch: Line 3 false, Line 13 false
        // Condition: words == null (false), y.words == null (false)
        BigInteger x = new BigInteger("1267650600228229401496703205376"); // 2^100
        BigInteger y = new BigInteger("1125899906842624"); // 2^50
        assertEquals(new BigInteger("1125899906842624"), x.gcd(y)); // GCD is 2^50
    }

    @Test
    public void testGcd_SmallIntegers() {
        // Covers: Line 3 (true), Line 4 (false), Line 6 (true), Line 7 (false), Line 9 (false), Line 11
        // Branch: Line 3 true, Line 4 false, Line 6 true, Line 7 false, Line 9 false
        // Condition: xval < 0 (false), yval < 0 (false)
        BigInteger x = new BigInteger("20");
        BigInteger y = new BigInteger("12");
        assertEquals(new BigInteger("4"), x.gcd(y));
    }

    @Test
    public void testGcd_xAtMinValue() {
        // Covers: Line 3 (true), Line 4 (false), Line 6 (false), Line 12, Line 13 (true), Line 14 (false), Line 16
        // Branch: Line 3 true, Line 4 false, Line 6 false, Line 13 true, Line 14 false
        // Condition: xval != Integer.MIN_VALUE (false)
        BigInteger x = new BigInteger(String.valueOf(Integer.MIN_VALUE));
        BigInteger y = new BigInteger("10");
        assertEquals(new BigInteger("2"), x.gcd(y));
    }

    // compareTo Method Tests - Structural Testing (Task 2)
    @Test
    public void testCompare_SmallIntegers_Smaller() {
        // Covers: Line 1 (true), Line 2
        // Branch: Line 1 true
        // Condition: x.words == null (true), y.words == null (true)
        BigInteger x = new BigInteger("5");
        BigInteger y = new BigInteger("10");
        assertEquals(-1, x.compareTo(y));
    }

    @Test
    public void testCompare_SmallIntegers_Equal() {
        // Covers: Line 1 (true), Line 2
        // Branch: Line 1 true
        // Condition: x.words == null (true), y.words == null (true)
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("0");
        assertEquals(0, x.compareTo(y));
    }

    @Test
    public void testCompare_SmallIntegers_Larger() {
        // Covers: Line 1 (true), Line 2
        // Branch: Line 1 true
        // Condition: x.words == null (true), y.words == null (true)
        BigInteger x = new BigInteger("10");
        BigInteger y = new BigInteger("5");
        assertEquals(1, x.compareTo(y));
    }

    @Test
    public void testCompare_NegativeVsPositive() {
        // Covers: Line 1 (true), Line 3-6
        // Branch: Line 1 true, Line 5 true
        // Condition: x_negative != y_negative (true)
        BigInteger x = new BigInteger("-5");
        BigInteger y = new BigInteger("5");
        assertEquals(-1, x.compareTo(y));
    }

    @Test
    public void testCompare_LargeNumbers_DifferentLengths() {
        // Covers: Line 1 (false), Line 3-5, Line 7-10
        // Branch: Line 1 false, Line 5 false, Line 9 true
        // Condition: x.words == null (false), y.words == null (false), x_negative != y_negative (false), x_len != y_len (true)
        BigInteger x = new BigInteger("1234567890");
        BigInteger y = new BigInteger("12345678901234567890");
        assertEquals(-1, x.compareTo(y));
    }

    @Test
    public void testCompare_LargeNumbers_SameLength() {
        // Covers: Line 1 (false), Line 3-5, Line 7-9, Line 11
        // Branch: Line 1 false, Line 5 false, Line 9 false
        // Condition: x.words == null (false), y.words == null (false), x_len != y_len (false)
        BigInteger x = new BigInteger("1267650600228229401496703205376"); // 2^100
        BigInteger y = new BigInteger("1125899906842624"); // 2^50
        assertEquals(1, x.compareTo(y));
    }
}
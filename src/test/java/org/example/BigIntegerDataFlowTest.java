package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BigIntegerDataFlowTest {

    @Test
    public void testGcd_xIsZero() {
        // Test Case 1: Input (this = 0, y = 5)
        // Covers: xval (Line 1 → Line 4) [All-Uses], xval (Line 1), yval (Line 2) [All-Defs]
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("5");
        assertEquals(new BigInteger("5"), x.gcd(y));
    }

    @Test
    public void testGcd_xPositive_yNegative() {
        // Test Case 2: Input (this = 12, y = -18)
        // Covers: xval (Line 1 → Line 6), xval (Line 1 → Line 7), yval (Line 2 → Line 6),
        // yval (Line 2 → Line 9), yval (Line 10 → Line 11) [All-Uses]
        BigInteger x = new BigInteger("12");
        BigInteger y = new BigInteger("-18");
        assertEquals(new BigInteger("6"), x.gcd(y));
    }

    @Test
    public void testGcd_xNegative_yPositive() {
        // Test Case 3: Input (this = -12, y = 18)
        // Covers: xval (Line 8 → Line 11) [All-Uses], xval (Line 8) [All-Defs]
        BigInteger x = new BigInteger("-12");
        BigInteger y = new BigInteger("18");
        assertEquals(new BigInteger("6"), x.gcd(y));
    }

    @Test
    public void testGcd_yIsZero() {
        // Test Case 4: Input (this = 7, y = 0)
        // Covers: xval (Line 12 → Line 17), yval (Line 2 → Line 14) [All-Uses], xval (Line 12) [All-Defs]
        BigInteger x = new BigInteger("7");
        BigInteger y = new BigInteger("0");
        assertEquals(new BigInteger("7"), x.gcd(y));
    }

    @Test
    public void testGcd_BothPositive() {
        // Test Case 5: Input (this = 7, y = 13)
        // Covers: yval (Line 16 → Line 17), len (Line 17 → Line 18), len (Line 17 → Line 19),
        // len (Line 17 → Line 22), len (Line 22 → Line 24), xwords (Line 18 → Line 20),
        // xwords (Line 18 → Line 22), xwords (Line 18 → Line 25), ywords (Line 19 → Line 21),
        // ywords (Line 19 → Line 22), result (Line 23 → Line 24), result (Line 23 → Line 25),
        // result (Line 23 → Line 26) [All-Uses], len (Line 17, Line 22), xwords (Line 18),
        // ywords (Line 19), result (Line 23) [All-Defs]
        BigInteger x = new BigInteger("7");
        BigInteger y = new BigInteger("13");
        assertEquals(new BigInteger("1"), x.gcd(y));
    }

    // compareTo Method Tests for Task 3d - Covers All-Defs (Task 3b) and All-Uses (Task 3c)
    @Test
    public void testCompare_Smaller() {
        // Test Case 1: Input (this = 5, val = 10)
        // Covers: None (early return) [All-Defs, All-Uses]
        BigInteger x = new BigInteger("5");
        BigInteger y = new BigInteger("10");
        assertEquals(-1, x.compareTo(y));
    }

    @Test
    public void testCompare_NegativeVsPositive() {
        // Test Case 2: Input (this = -5, val = 10)
        // Covers: x_negative (Line 3 → Line 5), x_negative (Line 3 → Line 6),
        // y_negative (Line 4 → Line 5) [All-Uses], x_negative (Line 3), y_negative (Line 4) [All-Defs]
        BigInteger x = new BigInteger("-5");
        BigInteger y = new BigInteger("10");
        assertEquals(-1, x.compareTo(y));
    }

    @Test
    public void testCompare_LargePositiveVsLargeNegative() {
        // Test Case 3: Input (this = 2^100, val = -2^50)
        // Covers: None (redundant for All-Uses) [All-Uses]
        BigInteger x = new BigInteger("1267650600228229401496703205376"); // 2^100
        BigInteger y = new BigInteger("-1125899906842624"); // -2^50
        assertEquals(1, x.compareTo(y));
    }

    @Test
    public void testCompare_LargeSmallerVsLargeLarger() {
        // Test Case 4: Input (this = 2^100, val = 2^200)
        // Covers: x_negative (Line 3 → Line 10), x_len (Line 7 → Line 9), x_len (Line 7 → Line 10),
        // y_len (Line 8 → Line 9), y_len (Line 8 → Line 10) [All-Uses]
        BigInteger x = new BigInteger("1267650600228229401496703205376"); // 2^100
        BigInteger y = new BigInteger("1606938044258990275541962092341162602522202993782792835301376"); // 2^200
        assertEquals(-1, x.compareTo(y));
    }

    @Test
    public void testCompare_LargeLargerVsLargeSmaller() {
        // Test Case 5: Input (this = 2^100, val = 2^50)
        // Covers: x_len (Line 7 → Line 11) [All-Uses], x_len (Line 7), y_len (Line 8) [All-Defs]
        BigInteger x = new BigInteger("1267650600228229401496703205376"); // 2^100
        BigInteger y = new BigInteger("1125899906842624"); // 2^50
        assertEquals(1, x.compareTo(y));
    }
}
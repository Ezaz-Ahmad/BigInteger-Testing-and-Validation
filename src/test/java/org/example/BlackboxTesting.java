package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BlackboxTesting {

    // Tests for BigInteger(int signum, byte[] magnitude)
    @Test
    public void ConstructorSignumMagnitude_ZeroLengthMagnitude() {
        BigInteger bi = new BigInteger(1, new byte[]{});
        assertEquals("0", bi.toString());
    }

    @Test
    public void ConstructorSignumMagnitude_NonZeroMagnitudePositive() {
        BigInteger bi = new BigInteger(1, new byte[]{1, 2});
        assertEquals("258", bi.toString());
    }

    @Test
    public void ConstructorSignumMagnitude_NonZeroMagnitudeNegative() {
        BigInteger bi = new BigInteger(-1, new byte[]{1, 2});
        assertEquals("-258", bi.toString());
    }

    @Test
    public void ConstructorSignumMagnitude_SignumZeroAllZeroMagnitude() {
        BigInteger bi = new BigInteger(0, new byte[]{0, 0});
        assertEquals("0", bi.toString());
    }

    @Test
    public void ConstructorSignumMagnitude_InvalidSignum() {
        assertThrows(NumberFormatException.class, () -> new BigInteger(2, new byte[]{1, 2}));
    }

    @Test
    public void ConstructorSignumMagnitude_SignumZeroNonZeroMagnitude() {
        assertThrows(NumberFormatException.class, () -> new BigInteger(0, new byte[]{1, 2}));
    }
    // Tests for BigInteger(String val, int radix)
    @Test
    public void ConstructorStringRadix_ValidPositiveRadix10() {
        BigInteger bi = new BigInteger("123", 10);
        assertEquals("123", bi.toString());
    }

    @Test
    public void ConstructorStringRadix_ValidNegativeRadix10() {
        BigInteger bi = new BigInteger("-123", 10);
        assertEquals("-123", bi.toString());
    }

    @Test
    public void ConstructorStringRadix_ValidRadix16() {
        BigInteger bi = new BigInteger("FF", 16);
        assertEquals("255", bi.toString());
    }

    @Test
    public void ConstructorStringRadix_InvalidRadix() {
        assertThrows(NumberFormatException.class, () -> new BigInteger("123", 1));
    }

    @Test
    public void ConstructorStringRadix_InvalidStringForRadix() {
        assertThrows(NumberFormatException.class, () -> new BigInteger("12G", 10));
    }

    @Test
    public void ConstructorStringRadix_InvalidStringFormat() {
        assertThrows(NumberFormatException.class, () -> new BigInteger("12 3", 10));
    }

    // Tests for compareTo(BigInteger val)
    @Test
    public void CompareTo_LessThanBothPositive() {
        BigInteger x = new BigInteger("5");
        BigInteger y = new BigInteger("10");
        assertEquals(-1, x.compareTo(y));
    }

    @Test
    public void CompareTo_EqualBothZero() {
        BigInteger x = new BigInteger("0");
        BigInteger y = new BigInteger("0");
        assertEquals(0, x.compareTo(y));
    }

    @Test
    public void CompareTo_GreaterThanDifferentSigns() {
        BigInteger x = new BigInteger("5");
        BigInteger y = new BigInteger("-5");
        assertEquals(1, x.compareTo(y));
    }

    @Test
    public void CompareTo_LessThanLargeNumbers() {
        BigInteger x = new BigInteger("1234567890");
        BigInteger y = new BigInteger("12345678901234567890");
        assertEquals(-1, x.compareTo(y));
    }

    @Test
    public void CompareTo_GreaterThanBothNegative() {
        BigInteger x = new BigInteger("-5");
        BigInteger y = new BigInteger("-10");
        assertEquals(1, x.compareTo(y));
    }
}
package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tests {

    @Test(expected = NumberFormatException.class)
    public void testZeroLengthString() {
        Integer.decode("");
    }

    @Test(expected = NumberFormatException.class)
    public void testInputString() {
        Integer.decode("quatre-vingt-dix-neuf");
    }

    @Test(expected = NumberFormatException.class)
    public void testArithmeticOperation() {
        Integer.decode("1-5");
    }

    @Test(expected = NumberFormatException.class)
    public void testWithDot() {
        Integer.decode("19.89");
    }


    @Test(expected = NumberFormatException.class)
    public void testWithSpaces() {
        Integer.decode("36 15");
    }

    @Test
    public void testWithBounds() {
        assertEquals(Integer.MIN_VALUE, Integer.decode(String.valueOf(Integer.MIN_VALUE)));
        assertEquals(Integer.MAX_VALUE, Integer.decode(String.valueOf(Integer.MAX_VALUE)));
    }

    @Test
    public void testWithPositiveDecimalNumbers() {
        assertEquals(0, Integer.decode("0"));
        assertEquals(0, Integer.decode("+0"));
        assertEquals(1, Integer.decode("1"));
        assertEquals(1, Integer.decode("+1"));
        assertEquals(10, Integer.decode("10"));
        assertEquals(10, Integer.decode("+10"));
        assertEquals(512, Integer.decode("512"));
        assertEquals(512, Integer.decode("+512"));
    }

    @Test
    public void testWithNegativeDecimalNumbers() {
        assertEquals(0, Integer.decode("-0"));
        assertEquals(-1, Integer.decode("-1"));
        assertEquals(-10, Integer.decode("-10"));
        assertEquals(-512, Integer.decode("-512"));
    }

    @Test
    public void testWithOctalRadix() {
        assertEquals(0, Integer.decode("-00"));
        assertEquals(0, Integer.decode("00"));
        assertEquals(-1, Integer.decode("-01"));
        assertEquals(1, Integer.decode("01"));
        assertEquals(-8, Integer.decode("-010"));
        assertEquals(8, Integer.decode("010"));
        assertEquals(-64, Integer.decode("-0100"));
        assertEquals(64, Integer.decode("0100"));
    }

    @Test
    public void testWithHexRadix() {
        assertEquals(0, Integer.decode("0x0"));
        assertEquals(0, Integer.decode("#0"));
        assertEquals(1, Integer.decode("0x1"));
        assertEquals(1, Integer.decode("#1"));
        assertEquals(16, Integer.decode("0x10"));
        assertEquals(16, Integer.decode("#10"));
        assertEquals(1000, Integer.decode("0x3E8"));
        assertEquals(1000, Integer.decode("#3E8"));
        assertEquals(0, Integer.decode("-0x0"));
        assertEquals(0, Integer.decode("-#0"));
        assertEquals(-1, Integer.decode("-0x1"));
        assertEquals(-1, Integer.decode("-#1"));
        assertEquals(-16, Integer.decode("-0x10"));
        assertEquals(-16, Integer.decode("-#10"));
        assertEquals(-1000, Integer.decode("-0x3E8"));
        assertEquals(-1000, Integer.decode("-#3E8"));
    }
}
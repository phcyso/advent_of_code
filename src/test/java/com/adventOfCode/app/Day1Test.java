package com.adventOfCode.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adventOfCode.app.day1.Day1;

public class Day1Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testRunWithSampleInput() {
        String[] lines = {
                "3   4",
                "4   3",
                "2   5",
                "1   3",
                "3   9",
                "3   3",
        };

        Day1.RunLines(lines);

        String expectedOutput = "Total distance is 11\nSimilarity is 31\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void testRunWithEmptyInput() {
        String[] lines = {};
        Day1.RunLines(lines);

        String expectedOutput = "Total distance is 0\nSimilarity is 0\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
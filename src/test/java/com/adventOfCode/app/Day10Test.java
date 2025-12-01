package com.adventOfCode.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.adventOfCode.app.day10.Day10;

public class Day10Test {

  @Test
  public void testRunLinesWithSampleInputPart1() {
    String[] lines = {
        "...",
        "..."
    };

    Result result = Day10.RunLines(lines);

    assertEquals(-1, result.part1);
  }

  @Test
  public void testRunLinesWithSampleInputPart2() {
    String[] lines = {
        "...",
        "..."
    };

    Result result = Day10.RunLines(lines);

    assertEquals(-1, result.part2);
  }

  @Test
  public void fullTest() {
    Result result = Day10.Run();

    assertEquals(-1, result.part1);
    assertEquals(-1, result.part2);
  }

}

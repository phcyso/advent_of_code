package com.adventOfCode.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.adventOfCode.app.day6.Day6;

public class Day6Test {

  @Test
  public void testRunLinesWithSampleInputPart1() {
    String[] lines = {
        "....#.....",
        ".........#",
        "..........",
        "..#.......",
        ".......#..",
        "..........",
        ".#..^.....",
        "........#.",
        "#.........",
        "......#...",
    };

    Result result = Day6.RunLines(lines);

    assertEquals(41, result.part1);
  }

  @Test
  public void testRunLinesWithSampleInputPart2() {
    String[] lines = {
        "...",
        "..."
    };

    Result result = Day6.RunLines(lines);

    assertEquals(-1, result.part2);
  }

  @Test
  public void fullTest() {
    Result result = Day6.Run();

    assertEquals(4722, result.part1);
    // assertEquals(-1, result.part2);
  }

}

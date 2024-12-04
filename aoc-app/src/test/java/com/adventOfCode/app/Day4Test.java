package com.adventOfCode.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.adventOfCode.app.day4.Day4;

public class Day4Test {

  @Test
  public void testRunLinesWithSampleInputPart1() {
    String[] lines = {
        "MMMSXXMASM",
        "MSAMXMSMSA",
        "AMXSXMAAMM",
        "MSAMASMSMX",
        "XMASAMXAMM",
        "XXAMMXXAMA",
        "SMSMSASXSS",
        "SAXAMASAAA",
        "MAMMMXMMMM",
        "MXMXAXMASX",
    };

    Result result = Day4.RunLines(lines);

    assertEquals(18, result.part1);
  }

  @Test
  public void testRunLinesWithSampleInputPart2() {
    String[] lines = {
        ".M.S......",
        "..A..MSMS.",
        ".M.S.MAA..",
        "..A.ASMSM.",
        ".M.S.M....",
        "..........",
        "S.S.S.S.S.",
        ".A.A.A.A..",
        "M.M.M.M.M.",
        "..........",
    };

    Result result = Day4.RunLines(lines);

    assertEquals(9, result.part2);
  }

  @Test
  public void fullTest() {
    Result result = Day4.Run();

    assertEquals(2517, result.part1);
    assertEquals(1960, result.part2);
  }

}

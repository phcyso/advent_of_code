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
    // assertEquals(161, result.part2);
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

    // assertEquals(0, result.part1);
    assertEquals(9, result.part2);
  }

  // @Test
  // public void testRunLinesWithSampleInputLong() {
  // String[] lines = {
  // "xmul(2,4)xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))",
  // };

  // Result result = Day3.RunLines(lines);

  // assertEquals(483, result.part1);
  // // assertEquals(0, result.part2);
  // }

  // @Test
  // public void testRunLinesWithKnownGoodInput() {
  // String[] lines = {
  // "mul(2,4)",
  // };

  // Result result = Day3.RunLines(lines);

  // assertEquals(8, result.part1);
  // // assertEquals(1, result.part2);
  // }

  // @Test
  // public void testRunLinesWithKnownGoodInputTwice() {
  // String[] lines = {
  // "mul(2,4)mul(2,4)",
  // };

  // Result result = Day3.RunLines(lines);

  // assertEquals(16, result.part1);
  // // assertEquals(1, result.part2);
  // }

  // @Test
  // public void testRunLinesWithBadSpaces() {
  // String[] lines = {
  // "mul ( 2 , 4 )",
  // };

  // Result result = Day3.RunLines(lines);

  // assertEquals(0, result.part1);
  // // assertEquals(1, result.part2);
  // }

  // @Test
  // public void testRunLinesWithBadAndGoodSpaces() {
  // String[] lines = {
  // "mul ( 2 , 4 )mul(2,1)",
  // };

  // Result result = Day3.RunLines(lines);

  // assertEquals(2, result.part1);
  // // assertEquals(1, result.part2);
  // }
}

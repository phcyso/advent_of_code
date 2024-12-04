package com.adventOfCode.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.adventOfCode.app.day3.Day3;

public class Day3Test {

  @Test
  public void testRunLinesWithSampleInputPart1() {
    String[] lines = {
        "xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))",
    };

    Result result = Day3.RunLines(lines);

    assertEquals(161, result.part1);
    assertEquals(161, result.part2);
  }

  @Test
  public void testRunLinesWithSampleInputPart2() {
    String[] lines = {
        "xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))",
    };

    Result result = Day3.RunLines(lines);

    assertEquals(161, result.part1);
    assertEquals(48, result.part2);
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

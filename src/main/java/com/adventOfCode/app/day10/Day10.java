package com.adventOfCode.app.day10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adventOfCode.app.InputReader;
import com.adventOfCode.app.Result;

public class Day10 {
  public static final String DayNumber = "10";

  public static Result Run() {
    System.out.println("Day " + DayNumber);
    String[] lines = InputReader.readlines("inputs/day" + DayNumber + ".txt");
    Result result = RunLines(lines);
    result.print();
    return result;
  }

  public static Result RunLines(String[] inputLines) {

    int part1Result = 0;
    int part2Result = 0;

    return new Result(part1Result, part2Result);
  }

}

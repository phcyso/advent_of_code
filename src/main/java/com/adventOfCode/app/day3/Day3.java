package com.adventOfCode.app.day3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adventOfCode.app.Result;

public class Day3 {
  public static void Run() {
    System.out.println("Day 3");
    String[] lines = readlines("inputs/day3.txt");
    Result result = RunLines(lines);
    result.print();
  }

  public static Result RunLines(String[] inputLines) {
    // part 1

    String line = inputLines[0];

    int part1Result = 0;
    int part2Result = 0;

    Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)");
    // run regex to find all the mul() calls
    Matcher match = pattern.matcher(line);
    boolean runMatch = true;
    while (match.find()) {
      String mult = match.group();
      if (mult.equals("do()")) {
        runMatch = true;
        continue;
      } else if (mult.equals("don't()")) {
        runMatch = false;
        continue;
      }

      String[] clean = mult.replaceAll("[mul\\(\\)]", "").split(",");
      int a = Integer.parseInt(clean[0]);
      int b = Integer.parseInt(clean[1]);
      int result = (a * b);
      part1Result += result;
      if (runMatch) {
        part2Result += result;
      }
    }

    return new Result(part1Result, part2Result);
  }

  private static String[] readlines(String filename) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      List<String> lines = new ArrayList<String>();
      String line = reader.readLine();
      while (line != null) {
        lines.add(line);
        line = reader.readLine();
      }
      reader.close();
      return lines.toArray(new String[0]);
    } catch (IOException e) {
      e.printStackTrace();
      return new String[0];
    }
  }
}

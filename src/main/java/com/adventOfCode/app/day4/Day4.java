package com.adventOfCode.app.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adventOfCode.app.Result;

/**
 * Helper class to store the pattern and offset for a word search direction
 */
class WordSearchPattern {
  String pattern;
  int offset;

  public WordSearchPattern(String pattern, int offset) {
    this.pattern = pattern;
    this.offset = offset;
  }

  public String format(int lineLength) {
    return String.format(pattern, (lineLength + offset));
  }
}

public class Day4 {
  public static Result Run() {
    System.out.println("Day 4");
    String[] lines = readlines("inputs/day4.txt");
    Result result = RunLines(lines);
    result.print();
    return result;
  }

  public static Result RunLines(String[] inputLines) {
    // put all lines into one string and grab the length of the first line
    int lineLength = inputLines[0].length();
    String bigLine = String.join(" ", inputLines);

    // Part 1
    WordSearchPattern[] part1Patterns = {
        p("X.{%1$d}M.{%1$d}A.{%1$d}S", 0),
        p("S.{%1$d}A.{%1$d}M.{%1$d}X", 0),
        p("X.{%1$d}M.{%1$d}A.{%1$d}S", 1),
        p("S.{%1$d}A.{%1$d}M.{%1$d}X", 1),
        p("X.{%1$d}M.{%1$d}A.{%1$d}S", -1),
        p("S.{%1$d}A.{%1$d}M.{%1$d}X", -1),
        p("XMAS", 0),
        p("SAMX", 0),
    };

    int part1Result = 0;
    for (WordSearchPattern pattern : part1Patterns) {
      part1Result += countMatches(bigLine, pattern, lineLength);
    }

    // Part 2
    WordSearchPattern[] part2Patterns = {
        p("M.S.{%1$d}A.{%1$d}M.S", -1),
        p("S.M.{%1$d}A.{%1$d}S.M", -1),
        p("S.S.{%1$d}A.{%1$d}M.M", -1),
        p("M.M.{%1$d}A.{%1$d}S.S", -1),
    };

    int part2Result = 0;
    for (WordSearchPattern pattern : part2Patterns) {
      part2Result += countMatches(bigLine, pattern, lineLength);
    }

    return new Result(part1Result, part2Result);
  }

  /**
   * Count the number of matches in a line
   * Takes a line and a pattern and returns the number of matches
   * It expects the pattern to have at least one %1$d in it to be replaced with
   * the length of the line and whatever offset the pattern has
   * 
   * @param line
   * @param rawPattern
   * @param lineLength
   * @return
   */
  private static int countMatches(String line, WordSearchPattern rawPattern, int lineLength) {

    String formattedRegex = rawPattern.format(lineLength);

    Pattern pattern = Pattern.compile(formattedRegex);
    Matcher m = pattern.matcher(line);
    int searchFrom = 0;
    int count = 0;
    while (m.find(searchFrom)) {
      searchFrom = m.start() + 1;
      count++;
    }
    return count;
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

  private static WordSearchPattern p(String pattern, int offset) {
    return new WordSearchPattern(pattern, offset);
  }
}

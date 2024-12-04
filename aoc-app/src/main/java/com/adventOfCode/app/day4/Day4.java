package com.adventOfCode.app.day4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adventOfCode.app.Result;

/*
 * X.{140}M.{140}A.{140}S
S.{140}A.{140}M.{140}X

X.{141}M.{141}A.{141}S
S.{141}A.{141}M.{141}X

XMAS|SAMX
 */

public class Day4 {
  public static void Run() {
    System.out.println("Day 4");
    String[] lines = readlines("inputs/day4.txt");
    Result result = RunLines(lines);
    result.print();
  }

  public static Result RunLines(String[] inputLines) {
    // part 1
    // put all lines into one string
    int lengthOfLine = inputLines[0].length();

    String bigLine = String.join(" ", inputLines);
    // create a regex pattern to match the words
    Pattern vert1 = Pattern.compile("X.{" + lengthOfLine + "}M.{" + lengthOfLine + "}A.{" + lengthOfLine + "}S");
    Pattern vert2 = Pattern.compile("S.{" + lengthOfLine + "}A.{" + lengthOfLine + "}M.{" + lengthOfLine + "}X");
    Pattern diag1 = Pattern
        .compile("X.{" + (lengthOfLine + 1) + "}M.{" + (lengthOfLine + 1) + "}A.{" + (lengthOfLine + 1) + "}S");
    Pattern diag2 = Pattern
        .compile("S.{" + (lengthOfLine + 1) + "}A.{" + (lengthOfLine + 1) + "}M.{" + (lengthOfLine + 1) + "}X");
    Pattern diag3 = Pattern
        .compile("X.{" + (lengthOfLine - 1) + "}M.{" + (lengthOfLine - 1) + "}A.{" + (lengthOfLine - 1) + "}S");
    Pattern diag4 = Pattern
        .compile("S.{" + (lengthOfLine - 1) + "}A.{" + (lengthOfLine - 1) + "}M.{" + (lengthOfLine - 1) + "}X");
    Pattern horz1 = Pattern.compile("XMAS");
    Pattern horz2 = Pattern.compile("SAMX");

    // run the regex patterns
    int vert1Count = countMatches(bigLine, vert1);
    int vert2Count = countMatches(bigLine, vert2);
    int diag1Count = countMatches(bigLine, diag1);
    int diag2Count = countMatches(bigLine, diag2);
    int diag3Count = countMatches(bigLine, diag3);
    int diag4Count = countMatches(bigLine, diag4);
    int horz1Count = (int) horz1.matcher(bigLine).results().count();
    int horz2Count = (int) horz2.matcher(bigLine).results().count();

    int part1Result = vert1Count + vert2Count + diag1Count + diag2Count + diag3Count + diag4Count + horz1Count
        + horz2Count;

    // PArt 2

    /*
     * M.S.{9}A.{9}M.S
     * S.M.{9}A.{9}S.M
     * S.S.{9}A.{9}M.M
     * M.M.{9}A.{9}S.S
     */

    Pattern p2v1 = Pattern.compile("M.S.{" + (lengthOfLine - 1) + "}A.{" + (lengthOfLine - 1) + "}M.S");
    Pattern p2v2 = Pattern.compile("S.M.{" + (lengthOfLine - 1) + "}A.{" + (lengthOfLine - 1) + "}S.M");
    Pattern p2v3 = Pattern.compile("S.S.{" + (lengthOfLine - 1) + "}A.{" + (lengthOfLine - 1) + "}M.M");
    Pattern p2v4 = Pattern.compile("M.M.{" + (lengthOfLine - 1) + "}A.{" + (lengthOfLine - 1) + "}S.S");

    int p2v1Count = countMatches(bigLine, p2v1);
    int p2v2Count = countMatches(bigLine, p2v2);
    int p2v3Count = countMatches(bigLine, p2v3);
    int p2v4Count = countMatches(bigLine, p2v4);

    int part2Result = p2v1Count + p2v2Count + p2v3Count + p2v4Count;

    return new Result(part1Result, part2Result);
  }

  private static int countMatches(String line, Pattern pattern) {
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
}

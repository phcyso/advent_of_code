package com.adventOfCode.app.day2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.adventOfCode.app.Result;

public class Day2 {
  public static void Run() {
    System.out.println("Day 2");
    String[] lines = readlines("inputs/day2.txt");
    Result result = RunLines(lines);
    result.print();
  }

  public static Result RunLines(String[] inputLines) {

    int safeReports = 0;
    int safeReportsPart2 = 0;
    for (String line : inputLines) {

      Report report = new Report(line);

      if (report.reportIsSafePart1()) {
        safeReports++;
      } else {
        if (report.reportIsSafePart2()) {
          safeReportsPart2++;
        }
        ;
      }
    }

    return new Result(safeReports, safeReports + safeReportsPart2);
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

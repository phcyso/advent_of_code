package com.adventOfCode.app.day6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.adventOfCode.app.InputReader;
import com.adventOfCode.app.Result;

class GuardMap {
  HashMap<Integer, List<Integer>> columnObsticles = new HashMap<Integer, List<Integer>>();
  HashMap<Integer, List<Integer>> rowObsticles = new HashMap<Integer, List<Integer>>();

  private int guardStartingX;
  private int guardStartingY;

  private int mapSize;

  public GuardMap(int size) {
    this.mapSize = size;
  }

  public void readMap(String[] lines) {
    for (int i = 0; i < lines.length; i++) {
      String line = lines[i];
      for (int j = 0; j < line.length(); j++) {
        if (line.charAt(j) == '^') {
          guardStartingX = j;
          guardStartingY = i;
        } else if (line.charAt(j) == '#') {
          if (!columnObsticles.containsKey(j)) {
            columnObsticles.put(j, new ArrayList<Integer>());
          }
          columnObsticles.get(j).add(i);
          if (!rowObsticles.containsKey(i)) {
            rowObsticles.put(i, new ArrayList<Integer>());
          }
          rowObsticles.get(i).add(j);
        }
      }
    }
  }

  /**
   * Lab guards in 1518 follow a very strict patrol protocol which involves
   * repeatedly following these steps:
   * 
   * If there is something directly in front of you, turn right 90 degrees.
   * Otherwise, take a step forward.
   * 
   * @return
   */
  public int preditGuardPath() {
    ArrayList<String> visitedPoints = new ArrayList<String>();
    visitedPoints.add("(" + guardStartingX + ", " + guardStartingY + ")");

    int guardX = guardStartingX;
    int guardY = guardStartingY;

    int direction = 0; // 0 = up, 1 = right, 2 = down, 3 = left

    while (true) {
      if (direction == 0) {
        if (rowObsticles.containsKey(guardY - 1) && rowObsticles.get(guardY - 1).contains(guardX)) {
          direction = 1;
          continue;
        } else {
          guardY--;
        }
      } else if (direction == 1) {
        if (columnObsticles.containsKey(guardX + 1) && columnObsticles.get(guardX + 1).contains(guardY)) {
          direction = 2;
          continue;
        } else {
          guardX++;
        }
      } else if (direction == 2) {
        if (rowObsticles.containsKey(guardY + 1) && rowObsticles.get(guardY + 1).contains(guardX)) {
          direction = 3;
          continue;
        } else {
          guardY++;
        }
      } else if (direction == 3) {
        if (columnObsticles.containsKey(guardX - 1) && columnObsticles.get(guardX - 1).contains(guardY)) {
          direction = 0;
          continue;
        } else {
          guardX--;
        }
      }
      // if outside the map break
      if (guardX < 0 || guardX >= mapSize || guardY < 0 || guardY >= mapSize) {
        break;
      }

      String point = "(" + guardX + ", " + guardY + ")";
      if (!visitedPoints.contains(point)) {
        visitedPoints.add(point);
      }
    }

    return visitedPoints.size();
  }

  public void printObsticles() {
    System.out.println("Column obsticles:");
    for (int key : columnObsticles.keySet()) {
      System.out.println(key + ": " + columnObsticles.get(key));
    }
    System.out.println("Row obsticles:");
    for (int key : rowObsticles.keySet()) {
      System.out.println(key + ": " + rowObsticles.get(key));
    }
  }

  public void printGuardPosition() {
    System.out.println("Guard starting position: (" + guardStartingX + ", " + guardStartingY + ")");
  }
}

public class Day6 {
  public static final String DayNumber = "6";

  public static Result Run() {
    System.out.println("Day " + DayNumber);
    String[] lines = InputReader.readlines("inputs/day" + DayNumber + ".txt");
    Result result = RunLines(lines);

    result.print();
    return result;
  }

  public static Result RunLines(String[] inputLines) {

    GuardMap guardMap = new GuardMap(inputLines[0].length());
    guardMap.readMap(inputLines);
    guardMap.printObsticles();
    guardMap.printGuardPosition();

    // Part 1

    int part1Result = guardMap.preditGuardPath();
    int part2Result = 0;

    return new Result(part1Result, part2Result);
  }

}

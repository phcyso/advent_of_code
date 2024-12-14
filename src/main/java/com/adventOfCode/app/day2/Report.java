package com.adventOfCode.app.day2;

import java.util.ArrayList;
import java.util.Scanner;

public class Report {
  public ArrayList<Integer> levels = new ArrayList<Integer>();

  public Report(String line) {
    Scanner in = new Scanner(line);
    try {
      while (in.hasNextInt()) {
        int number = in.nextInt();
        levels.add(number);
      }
    } finally {
      in.close();
    }
  }

  public Report(ArrayList<Integer> list) {
    levels = list;
  }

  public boolean reportIsSafePart1() {

    String direction = "";

    for (int i = 1; i < levels.size(); i++) {
      int previous = levels.get(i - 1);
      int current = levels.get(i);

      if (Math.abs(current - previous) > 3 || current == previous) {
        return false;
      }

      if (previous < current) {
        if (direction.equals("decreasing")) {
          return false;
        }
        direction = "increasing";
      } else if (previous > current) {
        if (direction.equals("increasing")) {
          return false;
        }
        direction = "decreasing";
      } else {
        return false;
      }
    }

    return true;
  }

  public boolean reportIsSafePart2() {
    int removedSafeCount = 0;

    for (int i = 0; i < levels.size(); i++) {

      ArrayList<Integer> clonedList = new ArrayList<Integer>();
      clonedList = (ArrayList<Integer>) levels.clone();

      clonedList.remove(i);
      Report r = new Report(clonedList);

      if (r.reportIsSafePart1()) {
        removedSafeCount++;
      }
    }

    return removedSafeCount > 0;
  }

}

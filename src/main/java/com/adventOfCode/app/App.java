package com.adventOfCode.app;

import com.adventOfCode.app.day1.Day1;
import com.adventOfCode.app.day10.Day10;
import com.adventOfCode.app.day11.Day11;
import com.adventOfCode.app.day12.Day12;
import com.adventOfCode.app.day13.Day13;
import com.adventOfCode.app.day2.Day2;
import com.adventOfCode.app.day3.Day3;
import com.adventOfCode.app.day4.Day4;
import com.adventOfCode.app.day6.Day6;
import com.adventOfCode.app.day7.Day7;
import com.adventOfCode.app.day8.Day8;
import com.adventOfCode.app.day9.Day9;

public class App {
    public static void main(String[] args) {

        // first real command line argument is the day number
        if (args.length == 0) {
            throw new IllegalArgumentException("Please provide a day number as the first argument, e.g. 1");
        }
        String day = args[0];

        switch (day) {
            case "1":
                Day1.Run();
                break;
            case "2":
                Day2.Run();
                break;
            case "3":
                Day3.Run();
                break;
            case "4":
                Day4.Run();
                break;
            // case "5":
            // Day5.Run();
            // break;
            case "6":
                Day6.Run();
                break;
            case "7":
                Day7.Run();
                break;
            case "8":
                Day8.Run();
                break;
            case "9":
                Day9.Run();
                break;
            case "10":
                Day10.Run();
                break;
            case "11":
                Day11.Run();
                break;
            case "12":
                Day12.Run();
                break;
            case "13":
                Day13.Run();
                break;
            // case "14":
            // Day14.Run();
            // break;

            default:
                throw new IllegalArgumentException("Invalid day number: " + day);
        }
    }
}

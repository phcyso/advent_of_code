package com.adventOfCode.app;

import com.adventOfCode.app.day1.Day1;
import com.adventOfCode.app.day2.Day2;
import com.adventOfCode.app.day3.Day3;
import com.adventOfCode.app.day4.Day4;

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
            default:
                throw new IllegalArgumentException("Invalid day number: " + day);
        }
    }
}

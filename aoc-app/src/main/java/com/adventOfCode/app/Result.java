package com.adventOfCode.app;

public class Result {
    public int part1;
    public int part2;

    public Result(int part1, int part2) {
        this.part1 = part1;
        this.part2 = part2;
    }

    public void setPart1(int part1) {
        this.part1 = part1;
    }

    public void setPart2(int part2) {
        this.part2 = part2;
    }

    public void print() {
        System.out.println("Part 1: " + part1);
        System.out.println("Part 2: " + part2);
    }
}
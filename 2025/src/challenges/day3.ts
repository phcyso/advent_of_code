import { loadInputLineArray } from "../helpers";

const DAY = 3;
const DAY_LABEL = DAY.toString().padStart(2, "0");

type DayInput = string[];

export function parseInput(): DayInput {
  return loadInputLineArray(DAY);
}

export function part1(): string {
  const input = parseInput();
  void input;
  return `Day ${DAY_LABEL} - Part 1 not implemented`;
}

export function part2(): string {
  const input = parseInput();
  void input;
  return `Day ${DAY_LABEL} - Part 2 not implemented`;
}

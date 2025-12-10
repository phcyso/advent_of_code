import { loadInputLineArray } from "../helpers";

const DAY = 5;
const DAY_LABEL = DAY.toString().padStart(2, "0");

type DayInput = string[];

export function parseInput(): DayInput {
  return loadInputLineArray(DAY);
}

class Pantry {
  freshRanges: Array<[number, number]> = [];
  availableIngredients: number[] = [];

  constructor(input: DayInput) {
    let i = 0;
    while (input[i] !== "") {
      const [start, end] = input[i].split("-").map(Number);
      this.freshRanges.push([start, end]);
      i++;
    }
    i++; // skip blank line
    while (i < input.length) {
      this.availableIngredients.push(Number(input[i]));
      i++;
    }
    this.freshRanges.sort((a, b) => a[0] - b[0]);
  }

  mergeRanges() {
    const merged: Array<[number, number]> = [];
    for (const [start, end] of this.freshRanges) {
      if (merged.length === 0) {
        merged.push([start, end]);
      } else {
        const last = merged[merged.length - 1];
        if (start <= last[1] + 1) {
          last[1] = Math.max(last[1], end);
        } else {
          merged.push([start, end]);
        }
      }
    }
    this.freshRanges = merged;
  }
  isFresh(ingredientId: number): boolean {
    for (const [start, end] of this.freshRanges) {
      if (ingredientId >= start && ingredientId <= end) {
        return true;
      }
    }
    return false;
  }

  countFreshIngredients(): number {
    let freshCount = 0;
    for (const id of this.availableIngredients) {
      if (this.isFresh(id)) {
        freshCount++;
      }
    }
    return freshCount;
  }


}

export function part1(): string {
  const input = parseInput();

  let pantry = new Pantry(input);
  let freshIngredients = pantry.countFreshIngredients();
  return `freshIngredients: ${freshIngredients}`;
}

export function part2(): string {
  const input = parseInput();
  let pantry = new Pantry(input);
  pantry.mergeRanges();
  // for each range, count the number of ids
  let totalFreshIds = 0;
  for (const [start, end] of pantry.freshRanges) {
    totalFreshIds += end - start + 1;
  }
  return `freshIngredientIds: ${totalFreshIds}`;
}

/**
 * --- Day 5: Cafeteria ---

As the forklifts break through the wall, the Elves are delighted to discover that there was a cafeteria on the other side after all.

You can hear a commotion coming from the kitchen. "At this rate, we won't have any time left to put the wreaths up in the dining hall!" Resolute in your quest, you investigate.

"If only we hadn't switched to the new inventory management system right before Christmas!" another Elf exclaims. You ask what's going on.

The Elves in the kitchen explain the situation: because of their complicated new inventory management system, they can't figure out which of their ingredients are fresh and which are spoiled. When you ask how it works, they give you a copy of their database (your puzzle input).

The database operates on ingredient IDs. It consists of a list of fresh ingredient ID ranges, a blank line, and a list of available ingredient IDs. For example:

3-5
10-14
16-20
12-18

1
5
8
11
17
32

The fresh ID ranges are inclusive: the range 3-5 means that ingredient IDs 3, 4, and 5 are all fresh. The ranges can also overlap; an ingredient ID is fresh if it is in any range.

The Elves are trying to determine which of the available ingredient IDs are fresh. In this example, this is done as follows:

    Ingredient ID 1 is spoiled because it does not fall into any range.
    Ingredient ID 5 is fresh because it falls into range 3-5.
    Ingredient ID 8 is spoiled.
    Ingredient ID 11 is fresh because it falls into range 10-14.
    Ingredient ID 17 is fresh because it falls into range 16-20 as well as range 12-18.
    Ingredient ID 32 is spoiled.

So, in this example, 3 of the available ingredient IDs are fresh.

Process the database file from the new inventory management system. How many of the available ingredient IDs are fresh?

Your puzzle answer was 782.

The first half of this puzzle is complete! It provides one gold star: *
--- Part Two ---

The Elves start bringing their spoiled inventory to the trash chute at the back of the kitchen.

So that they can stop bugging you when they get new inventory, the Elves would like to know all of the IDs that the fresh ingredient ID ranges consider to be fresh. An ingredient ID is still considered fresh if it is in any range.

Now, the second section of the database (the available ingredient IDs) is irrelevant. Here are the fresh ingredient ID ranges from the above example:

3-5
10-14
16-20
12-18

The ingredient IDs that these ranges consider to be fresh are 3, 4, 5, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, and 20. So, in this example, the fresh ingredient ID ranges consider a total of 14 ingredient IDs to be fresh.

Process the database file again. How many ingredient IDs are considered to be fresh according to the fresh ingredient ID ranges?

Your puzzle answer was 353863745078671.

Both parts of this puzzle are complete! They provide two gold stars: **
 */
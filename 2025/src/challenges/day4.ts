import { loadInputLineArray } from "../helpers";

const DAY = 4;
const DAY_LABEL = DAY.toString().padStart(2, "0");

type DayInput = string[];

class WherehouseGrid {

  private warehouseGrid: string[][];

  private gridWidth: number;

  private gridHeight: number;

  constructor(input: DayInput) {
    this.warehouseGrid = input.map(line => line.split(''));
    this.gridHeight = this.warehouseGrid.length;
    this.gridWidth = this.warehouseGrid[0].length;
  }
  getGridPosition(x: number, y: number): string | null {
    if (x < 0 || x >= this.gridWidth || y < 0 || y >= this.gridHeight) {
      return null;
    }
    return this.warehouseGrid[y][x];
  }
  isAccessible(x: number, y: number): boolean {
    if (this.getGridPosition(x, y) !== '@') {
      return false;
    }
    let adjacentRolls = 0;
    // check each of the 8 adjacent positions
    adjacentRolls += this.getGridPosition(x - 1, y - 1) === '@' ? 1 : 0; // top-left
    adjacentRolls += this.getGridPosition(x, y - 1) === '@' ? 1 : 0;   // top
    adjacentRolls += this.getGridPosition(x + 1, y - 1) === '@' ? 1 : 0; // top-right
    adjacentRolls += this.getGridPosition(x - 1, y) === '@' ? 1 : 0;   // left
    adjacentRolls += this.getGridPosition(x + 1, y) === '@' ? 1 : 0;   // right
    adjacentRolls += this.getGridPosition(x - 1, y + 1) === '@' ? 1 : 0; // bottom-left
    adjacentRolls += this.getGridPosition(x, y + 1) === '@' ? 1 : 0;   // bottom
    adjacentRolls += this.getGridPosition(x + 1, y + 1) === '@' ? 1 : 0; // bottom-right
    return adjacentRolls < 4;
  }

  countAccessableRolls(): number {
    let accessibleCount = 0;
    for (let y = 0; y < this.gridHeight; y++) {
      for (let x = 0; x < this.gridWidth; x++) {
        if (this.isAccessible(x, y)) {
          accessibleCount++;
        }
      }
    }
    return accessibleCount;
  }

  reduceAccessibleRolls(): number {
    // while there are accessible rolls, remove them
    let totalRemoved = 0;
    let removedThisRound = 0;
    do {
      removedThisRound = 0;
      for (let y = 0; y < this.gridHeight; y++) {
        for (let x = 0; x < this.gridWidth; x++) {
          if (this.isAccessible(x, y)) {
            removedThisRound++;
            this.warehouseGrid[y][x] = '.';
          }
        }
      }
      totalRemoved += removedThisRound;
    } while (removedThisRound > 0);
    return totalRemoved;
  }
}

export function parseInput(): DayInput {
  return loadInputLineArray(DAY);
}

export function part1(): string {
  const input = parseInput();
  const warehouse = new WherehouseGrid(input);
  let accessibleCount = warehouse.countAccessableRolls();
  return `accessibleRolls: ${accessibleCount}`;
}

export function part2(): string {
  const input = parseInput();

  const warehouse = new WherehouseGrid(input);

  const removedRolls = warehouse.reduceAccessibleRolls();

  return `removedRolls: ${removedRolls}`;
}

/** 
 * --- Day 4: Printing Department ---

You ride the escalator down to the printing department. They're clearly getting ready for Christmas; they have lots of large rolls of paper everywhere, and there's even a massive printer in the corner (to handle the really big print jobs).

Decorating here will be easy: they can make their own decorations. What you really need is a way to get further into the North Pole base while the elevators are offline.

"Actually, maybe we can help with that," one of the Elves replies when you ask for help. "We're pretty sure there's a cafeteria on the other side of the back wall. If we could break through the wall, you'd be able to keep moving. It's too bad all of our forklifts are so busy moving those big rolls of paper around."

If you can optimize the work the forklifts are doing, maybe they would have time to spare to break through the wall.

The rolls of paper (@) are arranged on a large grid; the Elves even have a helpful diagram (your puzzle input) indicating where everything is located.

For example:

..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@.

The forklifts can only access a roll of paper if there are fewer than four rolls of paper in the eight adjacent positions. If you can figure out which rolls of paper the forklifts can access, they'll spend less time looking and more time breaking down the wall to the cafeteria.

In this example, there are 13 rolls of paper that can be accessed by a forklift (marked with x):

..xx.xx@x.
x@@.@.@.@@
@@@@@.x.@@
@.@@@@..@.
x@.@@@@.@x
.@@@@@@@.@
.@.@.@.@@@
x.@@@.@@@@
.@@@@@@@@.
x.x.@@@.x.

Consider your complete diagram of the paper roll locations. How many rolls of paper can be accessed by a forklift?
Your puzzle answer was 1474.

The first half of this puzzle is complete! It provides one gold star: *
--- Part Two ---

Now, the Elves just need help accessing as much of the paper as they can.

Once a roll of paper can be accessed by a forklift, it can be removed. Once a roll of paper is removed, the forklifts might be able to access more rolls of paper, which they might also be able to remove. How many total rolls of paper could the Elves remove if they keep repeating this process?

Starting with the same example as above, here is one way you could remove as many rolls of paper as possible, using highlighted @ to indicate that a roll of paper is about to be removed, and using x to indicate that a roll of paper was just removed:

Initial state:
..@@.@@@@.
@@@.@.@.@@
@@@@@.@.@@
@.@@@@..@.
@@.@@@@.@@
.@@@@@@@.@
.@.@.@.@@@
@.@@@.@@@@
.@@@@@@@@.
@.@.@@@.@.

Remove 13 rolls of paper:
..xx.xx@x.
x@@.@.@.@@
@@@@@.x.@@
@.@@@@..@.
x@.@@@@.@x
.@@@@@@@.@
.@.@.@.@@@
x.@@@.@@@@
.@@@@@@@@.
x.x.@@@.x.

Remove 12 rolls of paper:
.......x..
.@@.x.x.@x
x@@@@...@@
x.@@@@..x.
.@.@@@@.x.
.x@@@@@@.x
.x.@.@.@@@
..@@@.@@@@
.x@@@@@@@.
....@@@...

Remove 7 rolls of paper:
..........
.x@.....x.
.@@@@...xx
..@@@@....
.x.@@@@...
..@@@@@@..
...@.@.@@x
..@@@.@@@@
..x@@@@@@.
....@@@...

Remove 5 rolls of paper:
..........
..x.......
.x@@@.....
..@@@@....
...@@@@...
..x@@@@@..
...@.@.@@.
..x@@.@@@x
...@@@@@@.
....@@@...

Remove 2 rolls of paper:
..........
..........
..x@@.....
..@@@@....
...@@@@...
...@@@@@..
...@.@.@@.
...@@.@@@.
...@@@@@x.
....@@@...

Remove 1 roll of paper:
..........
..........
...@@.....
..x@@@....
...@@@@...
...@@@@@..
...@.@.@@.
...@@.@@@.
...@@@@@..
....@@@...

Remove 1 roll of paper:
..........
..........
...x@.....
...@@@....
...@@@@...
...@@@@@..
...@.@.@@.
...@@.@@@.
...@@@@@..
....@@@...

Remove 1 roll of paper:
..........
..........
....x.....
...@@@....
...@@@@...
...@@@@@..
...@.@.@@.
...@@.@@@.
...@@@@@..
....@@@...

Remove 1 roll of paper:
..........
..........
..........
...x@@....
...@@@@...
...@@@@@..
...@.@.@@.
...@@.@@@.
...@@@@@..
....@@@...

Stop once no more rolls of paper are accessible by a forklift. In this example, a total of 43 rolls of paper can be removed.

Start with your original diagram. How many rolls of paper in total can be removed by the Elves and their forklifts?
Your puzzle answer was 8910.

Both parts of this puzzle are complete! They provide two gold stars: **
*/
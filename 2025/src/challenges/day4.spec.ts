import { afterEach, beforeEach, describe, expect, it, vi } from "vitest";

const sampleInput = [
  "..@@.@@@@.",
  "@@@.@.@.@@",
  "@@@@@.@.@@",
  "@.@@@@..@.",
  "@@.@@@@.@@",
  ".@@@@@@@.@",
  ".@.@.@.@@@",
  "@.@@@.@@@@",
  ".@@@@@@@@.",
  "@.@.@@@.@.",
];

describe("day4", () => {
  describe("part1 sample", () => {
    let loadInputLineArrayMock: ReturnType<typeof vi.fn>;
    let parseInput: typeof import("./day4").parseInput;
    let part1: typeof import("./day4").part1;

    beforeEach(async () => {
      vi.resetModules();
      loadInputLineArrayMock = vi.fn().mockReturnValue([...sampleInput]);
      vi.doMock("../helpers", () => ({
        loadInputLineArray: loadInputLineArrayMock,
      }));

      const day4 = await import("./day4");
      parseInput = day4.parseInput;
      part1 = day4.part1;
    });

    afterEach(() => {
      vi.doUnmock("../helpers");
    });

    it("parses the sample input", () => {
      const parsed = parseInput();
      expect(parsed).toEqual(sampleInput);
      expect(loadInputLineArrayMock).toHaveBeenCalledWith(4);
    });

    it("solves the provided example for part1", () => {
      const result = part1();
      expect(result).toBe("accessibleRolls: 13");
    });
  });

  describe("part1 full input", () => {
    let part1: typeof import("./day4").part1;

    beforeEach(async () => {
      vi.resetModules();
      vi.doUnmock("../helpers");
      const day4 = await import("./day4");
      part1 = day4.part1;
    });

    it("returns the documented full-input result", () => {
      const result = part1();
      expect(result).toBe("accessibleRolls: 1474");
    });
  });

  describe("part2 sample", () => {
    let loadInputLineArrayMock: ReturnType<typeof vi.fn>;
    let part2: typeof import("./day4").part2;

    beforeEach(async () => {
      vi.resetModules();
      loadInputLineArrayMock = vi.fn().mockReturnValue([...sampleInput]);
      vi.doMock("../helpers", () => ({
        loadInputLineArray: loadInputLineArrayMock,
      }));

      const day4 = await import("./day4");
      part2 = day4.part2;
    });

    afterEach(() => {
      vi.doUnmock("../helpers");
    });

    it("matches the 43-roll removal example", () => {
      const result = part2();
      expect(result).toBe("removedRolls: 43");
      expect(loadInputLineArrayMock).toHaveBeenCalledWith(4);
    });
  });

  describe("part2 full input", () => {
    it.todo("returns the documented full-input result");
  });
});

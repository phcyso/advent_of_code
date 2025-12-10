import { afterEach, beforeEach, describe, expect, it, vi } from "vitest";

const sampleInput = [
  ".......S.......",
  "...............",
  ".......^.......",
  "...............",
  "......^.^......",
  "...............",
  ".....^.^.^.....",
  "...............",
  "....^.^...^....",
  "...............",
  "...^.^...^.^...",
  "...............",
  "..^...^.....^..",
  "...............",
  ".^.^.^.^.^...^.",
  "...............",
];

describe("day7", () => {
  describe("part1 sample", () => {
    let loadInputLineArrayMock: ReturnType<typeof vi.fn>;
    let parseInput: typeof import("./day7").parseInput;
    let part1: typeof import("./day7").part1;

    beforeEach(async () => {
      vi.resetModules();
      loadInputLineArrayMock = vi.fn().mockReturnValue([...sampleInput]);
      vi.doMock("../helpers", () => ({
        loadInputLineArray: loadInputLineArrayMock,
      }));

      const day7 = await import("./day7");
      parseInput = day7.parseInput;
      part1 = day7.part1;
    });

    afterEach(() => {
      vi.doUnmock("../helpers");
    });

    it("parses the tachyon manifold sample", () => {
      const parsed = parseInput();
      expect(parsed).toEqual(sampleInput);
      expect(loadInputLineArrayMock).toHaveBeenCalledWith(7);
    });

    it("counts the documented number of beam splits", () => {
      const result = part1();
      expect(result).toBe("splitCount: 21");
    });
  });

  describe("part2", () => {
    it.todo("adds sample coverage later");
    it.todo("solves the full input");
  });
});

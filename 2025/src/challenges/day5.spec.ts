import { afterEach, beforeEach, describe, expect, it, vi } from "vitest";

const sampleInput = [
  "3-5",
  "10-14",
  "16-20",
  "12-18",
  "",
  "1",
  "5",
  "8",
  "11",
  "17",
  "32",
];

describe("day5", () => {
  describe("part1 sample", () => {
    let loadInputLineArrayMock: ReturnType<typeof vi.fn>;
    let parseInput: typeof import("./day5").parseInput;
    let part1: typeof import("./day5").part1;

    beforeEach(async () => {
      vi.resetModules();
      loadInputLineArrayMock = vi.fn().mockReturnValue([...sampleInput]);
      vi.doMock("../helpers", () => ({
        loadInputLineArray: loadInputLineArrayMock,
      }));

      const day5 = await import("./day5");
      parseInput = day5.parseInput;
      part1 = day5.part1;
    });

    afterEach(() => {
      vi.doUnmock("../helpers");
    });

    it("parses the sample input", () => {
      const parsed = parseInput();
      expect(parsed).toEqual(sampleInput);
      expect(loadInputLineArrayMock).toHaveBeenCalledWith(5);
    });

    it("solves the provided example for part1", () => {
      const result = part1();
      expect(result).toBe("freshIngredients: 3");
    });
  });

  describe("part2 sample", () => {
    let loadInputLineArrayMock: ReturnType<typeof vi.fn>;
    let part2: typeof import("./day5").part2;

    beforeEach(async () => {
      vi.resetModules();
      loadInputLineArrayMock = vi.fn().mockReturnValue([...sampleInput]);
      vi.doMock("../helpers", () => ({
        loadInputLineArray: loadInputLineArrayMock,
      }));

      const day5 = await import("./day5");
      part2 = day5.part2;
    });

    afterEach(() => {
      vi.doUnmock("../helpers");
    });

    it("counts the unique fresh ingredient IDs", () => {
      const result = part2();
      expect(result).toBe("freshIngredientIds: 14");
      expect(loadInputLineArrayMock).toHaveBeenCalledWith(5);
    });
  });

  describe("part2", () => {
    it.todo("solves the full input");
  });
});

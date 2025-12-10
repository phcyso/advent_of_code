import { afterEach, beforeEach, describe, expect, it, vi } from "vitest";

const sampleInput = [
  "123 328  51 64",
  "45 64  387 23",
  "6 98  215 314",
  "*   +   *   +",
];

describe("day6", () => {
  describe("part1 sample", () => {
    let loadInputLineArrayMock: ReturnType<typeof vi.fn>;
    let parseInput: typeof import("./day6").parseInput;
    let part1: typeof import("./day6").part1;

    beforeEach(async () => {
      vi.resetModules();
      loadInputLineArrayMock = vi.fn().mockReturnValue([...sampleInput]);
      vi.doMock("../helpers", () => ({
        loadInputLineArray: loadInputLineArrayMock,
      }));

      const day6 = await import("./day6");
      parseInput = day6.parseInput;
      part1 = day6.part1;
    });

    afterEach(() => {
      vi.doUnmock("../helpers");
    });

    it("parses the worksheet sample", () => {
      const parsed = parseInput();
      expect(parsed).toEqual(sampleInput);
      expect(loadInputLineArrayMock).toHaveBeenCalledWith(6);
    });

    it("solves the provided worksheet for part1", () => {
      const result = part1();
      expect(result).toBe("grandTotal: 4277556");
    });
  });

  describe("part2", () => {
    it.todo("adds sample coverage later");
    it.todo("solves the full input");
  });
});

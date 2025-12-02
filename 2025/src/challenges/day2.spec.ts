import { afterEach, beforeEach, describe, expect, it, vi } from "vitest";

const exampleInput = [
  "11-22",
  "95-115",
  "998-1012",
  "1188511880-1188511890",
  "222220-222224",
  "1698522-1698528",
  "446443-446449",
  "38593856-38593862",
  "565653-565659",
  "824824821-824824827",
  "2121212118-2121212124",
];

let part1: typeof import("./day2").part1;
let part2: typeof import("./day2").part2;
let loadInputCommaSeperatedMock: ReturnType<typeof vi.fn>;

describe("day2 samples", () => {
  beforeEach(async () => {
    vi.resetModules();
    loadInputCommaSeperatedMock = vi.fn();
    vi.doMock("../helpers", () => ({
      loadInputCommaSeperated: loadInputCommaSeperatedMock,
    }));
    const day2 = await import("./day2");
    part1 = day2.part1;
    part2 = day2.part2;
  });

  afterEach(() => {
    vi.doUnmock("../helpers");
  });

  it("computes the provided example sum for part1", () => {
    loadInputCommaSeperatedMock.mockReturnValueOnce([...exampleInput]);

    const result = part1();

    expect(result).toBe("invalidIdsSum : 1227775554");
    expect(loadInputCommaSeperatedMock).toHaveBeenCalledWith(2);
  });

  it("computes the provided example sum for part2", () => {
    loadInputCommaSeperatedMock.mockReturnValueOnce([...exampleInput]);

    const result = part2();

    expect(result).toBe("invalidIdsSum : 4174379265");
    expect(loadInputCommaSeperatedMock).toHaveBeenCalledWith(2);
  });
});


describe("day2 full results", () => {
  beforeEach(async () => {
    vi.resetModules();
    vi.doUnmock("../helpers");
    const day2 = await import("./day2");
    part1 = day2.part1;
    part2 = day2.part2;
  });

  it("computes the sum for part1", () => {
    const result = part1();
    expect(result).toBe("invalidIdsSum : 55916882972");
  });

  it("computes the sum for part2", () => {

    const result = part2();

    expect(result).toBe("invalidIdsSum : 76169125915");
  });
});

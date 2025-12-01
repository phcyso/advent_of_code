import { beforeEach, describe, expect, it } from "vitest";
import { Dial, part1 } from "./day1";

describe("Click Left", () => {
  let dial: Dial;

  beforeEach(() => {
    dial = new Dial();
  });

  it("clickLeft simple ", () => {
    dial.clickLeft(5);
    expect(dial.pos()).toBe(45);
  });

  it("clickLeft moves wraps", () => {
    dial.clickLeft(68);
    expect(dial.pos()).toBe(82);
  });

  it("clickLeft moves wraps more then once", () => {
    dial.clickLeft(401);
    expect(dial.pos()).toBe(49);
  });

});

describe("Click Right", () => {
  let dial: Dial;

  beforeEach(() => {
    dial = new Dial();
  });

  it("clickRight simple ", () => {
    dial.clickRight(5);
    expect(dial.pos()).toBe(55);
  });

});


describe("Click Right", () => {
  let dial: Dial;

  beforeEach(() => {
    dial = new Dial();
  });

  it("full simple test ", () => {
    dial.clickLeft(68);
    dial.clickLeft(30);
    dial.clickRight(48);
    dial.clickLeft(5);
    dial.clickRight(60);
    dial.clickLeft(55);
    dial.clickLeft(1);
    dial.clickLeft(99);
    dial.clickRight(14);
    dial.clickLeft(82);
    expect(dial.pos()).toBe(32);
  });
});



describe("run Part 1run", () => {
  let dial: Dial;

  beforeEach(() => {
    dial = new Dial();
  });

  it("full part1 test ", () => {
    const result = part1();
    expect(result).toBe("zeroCount: 1021")
  });

});



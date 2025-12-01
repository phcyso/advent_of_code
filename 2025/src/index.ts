#!/usr/bin/env node

import fs from "node:fs";
import path from "node:path";
import { cli } from "argus-ts";

type PartRunner = () => unknown | Promise<unknown>;

cli({ name: "aoc-2025" })
  .argument("<day>", "Day number to run")
  .option("--part <part>", "Run only the specified part (1 or 2)")
  .action((args, options) => runDay(args.day, options.part))
  .parse();

async function runDay(dayRaw: string, partRaw?: unknown): Promise<void> {
  const dayNumber = Number.parseInt(dayRaw.trim(), 10);
  if (!Number.isInteger(dayNumber)) {
    console.log(`Invalid day: ${dayRaw}`);
    return;
  }

  const challenge = loadChallenge(dayNumber);
  if (!challenge) {
    console.log(`Day ${formatDay(dayNumber)} not implemented.`);
    return;
  }

  const part = normalisePart(partRaw);
  if (part === "invalid") {
    console.log(`Invalid part: ${String(partRaw)}`);
    return;
  }

  if (part) {
    await runPart(dayNumber, part, part === "1" ? challenge.part1 : challenge.part2);
    return;
  }

  await runPart(dayNumber, "1", challenge.part1);
  await runPart(dayNumber, "2", challenge.part2);
}

function loadChallenge(dayNumber: number): { part1?: PartRunner; part2?: PartRunner } | undefined {
  const modulePath = path.resolve(__dirname, "challenges", `day${dayNumber}.js`);
  if (!fs.existsSync(modulePath)) {
    return undefined;
  }

  // eslint-disable-next-line @typescript-eslint/no-var-requires
  const loaded = require(modulePath) as {
    part1?: PartRunner;
    part2?: PartRunner;
    default?: { part1?: PartRunner; part2?: PartRunner };
  };
  return loaded.default ?? loaded;
}

function normalisePart(input: unknown): "1" | "2" | "invalid" | undefined {
  if (typeof input !== "string") {
    return undefined;
  }
  const trimmed = input.trim();
  if (trimmed === "1") {
    return "1";
  }
  if (trimmed === "2") {
    return "2";
  }
  return "invalid";
}

async function runPart(dayNumber: number, part: "1" | "2", runner?: PartRunner): Promise<void> {
  const label = `Day ${formatDay(dayNumber)} - Part ${part}`;
  if (!runner) {
    console.log(`${label} missing.`);
    return;
  }

  const result = await runner();
  console.log(result === undefined ? `${label}: done` : `${label}: ${result}`);
}

function formatDay(dayNumber: number): string {
  return dayNumber.toString().padStart(2, "0");
}

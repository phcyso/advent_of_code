import path from "path";
import fs from "fs";

export function loadInputLineArray(day: number): string[] {
  const inputPath = path.resolve(__dirname, "..", "inputs", `day${day}.txt`);
  const fileContents = fs.readFileSync(inputPath, "utf-8");
  return fileContents.split("\n").map((line) => line.trim());
}
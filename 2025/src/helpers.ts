import path from "path";
import fs from "fs";

export function loadInputLineArray(day: number): string[] {
  const inputPath = path.resolve(__dirname, "..", "inputs", `day${day}.txt`);
  const fileContents = fs.readFileSync(inputPath, "utf-8");
  return fileContents.split("\n").map((line) => line.trim());
}

/* reads a file like:  11-22,95-115,998-1012, amd returns an array of strings for each seperation */
export function loadInputCommaSeperated(day: number): string[] {
  const inputPath = path.resolve(__dirname, "..", "inputs", `day${day}.txt`);
  const fileContents = fs.readFileSync(inputPath, "utf-8");
  return fileContents.split(",").map((line) => line.trim());
}
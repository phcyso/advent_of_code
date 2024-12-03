import java.io.BufferedReader;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Day1 {
  public static void main(String[] args) {
    // Read the input file
    String[] lines = readlines("input.txt");
    // String[] lines = readlines("input_test.txt");

    // loop through the lines
    ArrayList<Integer> left = new ArrayList<Integer>();
    ArrayList<Integer> right = new ArrayList<Integer>();

    for (String line : lines) {
      // split the lines into two numbers and fill the left and right arrays
      String[] parts = line.split("\\s+");
      // System.out.println(parts[0] + " " + parts[1]);
      left.add(Integer.parseInt(parts[0]));
      right.add(Integer.parseInt(parts[1]));
    }
    // sort the arrays
    left.sort(null);
    right.sort(null);

    // Handle part 1
    int totalDistance = 0;
    int similarity = 0;
    // loop over the left array
    for (int i = 0; i < left.size(); i++) {
      int l1 = left.get(i);
      int r1 = right.get(i);
      // calculate the distance between the two points
      int dist = distance(left.get(i), right.get(i));
      totalDistance += dist;
      // print the distance
      // System.out.println("Distance between " + left.get(i) + " and " + right.get(i)
      // + " is " + dist);
      similarity += (l1 * Collections.frequency(right, l1));
    }

    // print the total distance
    System.out.println("Total distance is " + totalDistance);

    // print the similarity
    System.out.println("Similarity is " + similarity);

    // Handle part 2
  }

  static int distance(int x, int y) {
    return Math.abs(y - x);
  }

  private static String[] readlines(String filename) {
    try {
      BufferedReader reader = new BufferedReader(new FileReader(filename));
      List<String> lines = new ArrayList<String>();
      String line = reader.readLine();
      while (line != null) {
        lines.add(line);
        line = reader.readLine();
      }
      reader.close();
      return lines.toArray(new String[0]);
    } catch (IOException e) {
      e.printStackTrace();
      return new String[0];
    }
  }

}

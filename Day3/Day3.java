package javatest.Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.geometry.Point2D;

public class Day3 {
    private static String[][] grid = new String[16000][16000];
    private static int indexRow = grid.length / 2;
    private static int indexColumn = grid.length / 2;
    private static int originalRow = grid.length / 2;
    private static int originalColumn = grid.length / 2;
    private static ArrayList<Integer> indexRowWithX = new ArrayList();
    private static ArrayList<Integer> indexColumnWithX = new ArrayList();
    private static ArrayList<Integer> stepsByWire = new ArrayList();
    private static int steps = 0;

    public static void main(String[] args) {
        String path = "C:/Users/Ivete/Documents/Code/javatest/Day3/puzzle3.txt";
        try {
            List<String> list = Files.readAllLines(Paths.get(path));

            String[] wire1 = list.get(0).split(",");
            String[] wire2 = list.get(1).split(",");

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    grid[i][j] = ".";
                }
            }

            // Starting point
            grid[originalRow][originalColumn] = "o";

            // showGrid();

            move(wire1, 0);

            // showGrid();

            indexColumn = originalColumn;
            indexRow = originalRow;
            steps = 0;

            move(wire2, 1);

            // showGrid();

            // part 1 solution :
            System.out.println("Solution part 1 = " + calculateManhattanDistance());

            // part 2 solution :
            System.out.println("Solution part 2 = " + calculateFewerSteps());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showGrid() throws IOException {

        String pathTest = "C:/Users/Ivete/Documents/Code/javatest/Day3/test.txt";

        String output = "";

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                output += grid[i][j] + " ";
            }
            output += "\n";
        }

        Files.write(Paths.get(pathTest), output.getBytes(), StandardOpenOption.APPEND);
    }

    public static void move(String[] wire, int wireNumber) {
        for (int i = 0; i < wire.length; i++) {
            if (wire[i].contains("U")) {
                for (int j = 0; j < Integer.parseInt(wire[i].split("U")[1]); j++) {
                    steps++;
                    indexRow -= 1;
                    if (grid[indexRow][indexColumn].split(";")[0].equals("-")) {
                        if (grid[indexRow][indexColumn].split(";")[1].equals("0")) {
                            if (wireNumber == 1) {
                                stepsByWire.add(steps + Integer.parseInt(grid[indexRow][indexColumn].split(";")[2]));
                                grid[indexRow][indexColumn] = "X";
                                indexRowWithX.add(Math.abs(indexRow - originalRow));
                                indexColumnWithX.add(Math.abs(indexColumn - originalColumn));
                            }
                        }
                    } else {
                        if (wireNumber == 1) {
                            grid[indexRow][indexColumn] = "|;1;" + steps;
                        }
                        if (wireNumber == 0) {
                            grid[indexRow][indexColumn] = "|;0;" + steps;
                        }
                    }
                    if (j == Integer.parseInt(wire[i].split("U")[1]) - 1) {
                        grid[indexRow][indexColumn] = "+";
                    }

                }
            }
            if (wire[i].contains("L")) {
                for (int j = 0; j < Integer.parseInt(wire[i].split("L")[1]); j++) {
                    steps++;
                    indexColumn -= 1;
                    if (grid[indexRow][indexColumn].split(";")[0].equals("|")) {
                        if (grid[indexRow][indexColumn].split(";")[1].equals("0")) {
                            if (wireNumber == 1) {
                                stepsByWire.add(steps + Integer.parseInt(grid[indexRow][indexColumn].split(";")[2]));
                                grid[indexRow][indexColumn] = "X";
                                indexRowWithX.add(Math.abs(indexRow - originalRow));
                                indexColumnWithX.add(Math.abs(indexColumn - originalColumn));
                            }
                        }
                    } else {
                        if (wireNumber == 1) {
                            grid[indexRow][indexColumn] = "-;1;" + steps;
                        }
                        if (wireNumber == 0) {
                            grid[indexRow][indexColumn] = "-;0;" + steps;
                        }
                    }
                    if (j == Integer.parseInt(wire[i].split("L")[1]) - 1) {
                        grid[indexRow][indexColumn] = "+";
                    }

                }
            }
            if (wire[i].contains("R")) {
                for (int j = 0; j < Integer.parseInt(wire[i].split("R")[1]); j++) {
                    steps++;
                    indexColumn += 1;
                    if (grid[indexRow][indexColumn].split(";")[0].equals("|")) {
                        if (grid[indexRow][indexColumn].split(";")[1].equals("0")) {
                            if (wireNumber == 1) {
                                stepsByWire.add(steps + Integer.parseInt(grid[indexRow][indexColumn].split(";")[2]));
                                grid[indexRow][indexColumn] = "X";
                                indexRowWithX.add(Math.abs(indexRow - originalRow));
                                indexColumnWithX.add(Math.abs(indexColumn - originalColumn));

                            }
                        }

                    } else {
                        if (wireNumber == 1) {
                            grid[indexRow][indexColumn] = "-;1;" + steps;
                        }
                        if (wireNumber == 0) {
                            grid[indexRow][indexColumn] = "-;0;" + steps;
                        }
                    }
                    if (j == Integer.parseInt(wire[i].split("R")[1]) - 1) {
                        grid[indexRow][indexColumn] = "+";
                    }

                }
            }
            if (wire[i].contains("D")) {
                for (int j = 0; j < Integer.parseInt(wire[i].split("D")[1]); j++) {
                    steps++;
                    indexRow += 1;
                    if (grid[indexRow][indexColumn].split(";")[0].equals("-")) {
                        if (grid[indexRow][indexColumn].split(";")[1].equals("0")) {
                            if (wireNumber == 1) {
                                stepsByWire.add(steps + Integer.parseInt(grid[indexRow][indexColumn].split(";")[2]));
                                grid[indexRow][indexColumn] = "X";
                                indexRowWithX.add(Math.abs(indexRow - originalRow));
                                indexColumnWithX.add(Math.abs(indexColumn - originalColumn));
                            }
                        }
                    } else {
                        if (wireNumber == 1) {
                            grid[indexRow][indexColumn] = "|;1;" + steps;
                        }
                        if (wireNumber == 0) {
                            grid[indexRow][indexColumn] = "|;0;" + steps;
                        }
                    }
                    if (j == Integer.parseInt(wire[i].split("D")[1]) - 1) {
                        grid[indexRow][indexColumn] = "+";
                    }

                }
            }
        }
    }

    public static int calculateManhattanDistance() {
        ArrayList<Integer> listOfSums = new ArrayList();

        for (int i = 0; i < indexRowWithX.size(); i++) {
            listOfSums.add(indexRowWithX.get(i) + indexColumnWithX.get(i));
        }

        Collections.sort(listOfSums);

        return listOfSums.get(0);
    }

    public static int calculateFewerSteps() {
        Collections.sort(stepsByWire);

        return stepsByWire.get(0);
    }
}

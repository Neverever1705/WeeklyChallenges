package dev.ldo.own_stuff.newsletter_exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExitTheMaze {
    private List<int[]> maze;
    private boolean hasSolution;
    private final int[] startPosition = new int[]{0, 0};
    private final int[] exit;
    private boolean[][] visited;



    public ExitTheMaze(int[][] maze) {
        this.maze = Arrays.asList(maze);
        this.exit = getLastElement();
    }

    private int[] getLastElement() {
        int lastRowNumber = maze.size() - 1;
        int[] lastRow = maze.get(lastRowNumber);
        int lastColumnNumber = lastRow.length - 1;

        return new int[]{lastRowNumber, lastColumnNumber};
    }

    public boolean canExit() {
        int row = 0;
        int column = 0;
        if (getValueFromField(startPosition) == 1 || getValueFromField(exit) == 1)
            return false;
        for (int[] values : maze) {

            for (int number : values) {
                if (isVisited(row, column)) {
                    continue;
                } else {
                    setVisited(row, column, true);
                }
                if (!getValueFromField(getNeighbors(new int[]{row, column})).contains(0)) {
                    hasSolution = false;
                    continue;
                }
                column++;
            }
            row++;
        }
        return hasSolution;
    }

    private int getValueFromField(int[] position) {
        int rowIndex = position[0];
        int columnIndex = position[1];
        int[] row = maze.get(rowIndex);
        return row[columnIndex];
    }

    private List<Integer> getValueFromField(List<int[]> positions) {
        List<Integer> values = new ArrayList<>();
        for (int[] pos : positions) {
            int rowIndex = pos[0];
            int columnIndex = pos[1];
            int[] row = maze.get(rowIndex);
            values.add(row[columnIndex]);

        }
        return values;
    }

    private List<int[]> getNeighbors(int[] position) {
        List<int[]> neighbors = new ArrayList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // top, bottom, left, right
        int gridSize = maze.size();
        int row = position[0];
        int col = position[1];
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < gridSize && newCol >= 0 && newCol < maze.get(0).length) {
                neighbors.add(new int[]{newRow, newCol});
            }
        }

        return neighbors;
    }

    private boolean isVisited(int row, int col) {
        if (visited == null)
            visited = new boolean[maze.size()][maze.get(0).length];
        return visited[row][col];
    }

    private void setVisited(int row, int col, boolean value) {
        if (visited == null)
            visited = new boolean[maze.size()][maze.get(0).length];
        visited[row][col] = value;
    }


}

package Service.Impl;

import Helper.Node;
import Helper.SharedObject;
import Service.BombSweeper;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BombSweeperImpl implements BombSweeper {

    int xCoordinates = 0, yCoordinates = 0;
    int rows;
    int cols;
    SharedObject sharedObject = new SharedObject();
    
    /*
     * For direction, they are represented like the WASD conventions
     * W: UP
     * S: Down
     * Q: Left
     * D: Right
     * */

    /*               y
     *                |
     *                |
     *                |
     *              2 |
     *              1 |
     * --------------------------------- x
     *      -3 -2 -1  |  1  2
     *             -2 |
     *             -3 |
     *                |
     *                |
     *
     * */

                    // Right, Left, UP, Down
    char[] directions = {'D', 'Q', 'W', 'S'};
    int[] dimensionX =  { 0,   0,  -1,   1};
    int[] dimensionY =  { 1,  -1,   0,   0};
    @Override
    public void findStartPointCoordinates(char[][] map , char startPoint) {
        rows = map.length;
        cols = map[0].length;
        for (int rowIndex = 0; rowIndex < rows; rowIndex++) {
            for (int colIndex = 0; colIndex < cols; colIndex++) {
                if (map[rowIndex][colIndex] == startPoint) {
                    xCoordinates = rowIndex;
                    yCoordinates = colIndex;
                    break;
                }
            }
            if (map[xCoordinates][yCoordinates] == startPoint) {
                break;
            }
        }
    }
    @Override
    public String BFS(char[][] map ,char startPoint, char safePoint, char blockPoint, char endPoint) {
//        get location starting point
        this.findStartPointCoordinates(map, startPoint);
        int newDimensionX;
        int newDimensionY;
        List<Node> nodes = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        nodes.add(new Node(xCoordinates, yCoordinates ,""));

        while (!nodes.isEmpty() && map[xCoordinates][yCoordinates] == startPoint) {
            Node currentNode = nodes.remove(0);

            if (map[currentNode.getX()][currentNode.getY()] == endPoint) {
                return currentNode.getPath();
            }
            for (int i = 0; i < 4; i++) {
                newDimensionX = currentNode.getX() + dimensionX[i];
                newDimensionY = currentNode.getY() + dimensionY[i];

                if (newDimensionX >= 0 && newDimensionX < rows && newDimensionY >= 0 && newDimensionY < cols &&
                        map[newDimensionX][newDimensionY] != blockPoint && !visited[newDimensionX][newDimensionY]) {
                    nodes.add(new Node(newDimensionX, newDimensionY, currentNode.getPath() + directions[i]));
                    visited[newDimensionX][newDimensionY] = true;
                }}}
        return "RTB";
    }
}

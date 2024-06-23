package Service;

public interface BombSweeper {

    void findStartPointCoordinates(char[][] map , char startPoint);

    String BFS(char[][] map ,char startPoint, char safePoint, char blockPoint, char endPoint);
}

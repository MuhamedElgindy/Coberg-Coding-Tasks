import Service.BombSweeper;
import Service.Impl.BombSweeperImpl;
public class Main {
    public static void main(String[] args) {
        char[][] field1 = {
                {'*', 'B', 'S', 'B'},
                {'S', 'B', 'B', 'B'},
                {'S', 'S', 'S', '$'}
        };
        char[][] field2 = {
                {'*', 'B', 'S', 'B'},
                {'S', 'B', 'B', 'B'},
                {'S', 'S', 'B', 'B'},
                {'B', 'S', 'B', '$'}
        };
        char[][] field3 = {
                {'B', 'B', 'S', 'B'},
                {'S', 'B', '*', 'B'},
                {'S', 'S', 'S', 'B'},
                {'S', 'S', 'S', '$'}
        };
        BombSweeper bombSweeper = new BombSweeperImpl();
        String s1 = bombSweeper.BFS(field1, '*', 'S', 'B', '$');
        System.out.println("Path Maze 1 -> "+s1);

        String s2 = bombSweeper.BFS(field2, '*', 'S', 'B', '$');
        System.out.println("Path Maze 2 -> "+s2);

        String s3 = bombSweeper.BFS(field3, '*', 'S', 'B', '$');
        System.out.println("Path Maze 3 -> "+s3);
    }
}
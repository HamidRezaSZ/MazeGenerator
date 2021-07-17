package Controller;

import java.util.*;

public class Controller {
    private static Controller controller;

    public static Controller getInstance() {
        if (controller == null)
            controller = new Controller();
        return controller;
    }

    public char[][] generateMaze(int height, int width) {
        char[][] maze = new char[height][width];
        for (int i = 0; i < height; i++) Arrays.fill(maze[i], '1');
        maze[1][0] = 's';
        maze[height - 2][width - 1] = 'e';
        Random rand = new Random();
        int randomNumber1 = rand.nextInt(height);
        while (randomNumber1 % 2 == 0) randomNumber1 = rand.nextInt(height);
        int randomNumber2 = rand.nextInt(width);
        while (randomNumber2 % 2 == 0) randomNumber2 = rand.nextInt(width);
        maze[randomNumber1][randomNumber2] = '0';
        road(maze, randomNumber1, randomNumber2, width, height);
        return maze;
    }

    public void road(char[][] maze, int randomNumber1, int randomNumber2, int width, int height) {
        Integer[] randDirections = randomNumber();
        for (Integer randDirection : randDirections) {

            switch (randDirection) {
                case 1: // Up
                    if (randomNumber1 - 2 <= 0) continue;
                    if (maze[randomNumber1 - 2][randomNumber2] != '0') {
                        maze[randomNumber1 - 2][randomNumber2] = '0';
                        maze[randomNumber1 - 1][randomNumber2] = '0';
                        road(maze, randomNumber1 - 2, randomNumber2, width, height);
                    }
                    break;
                case 2: // Right
                    if (randomNumber2 + 2 >= width - 1) continue;
                    if (maze[randomNumber1][randomNumber2 + 2] != '0') {
                        maze[randomNumber1][randomNumber2 + 2] = '0';
                        maze[randomNumber1][randomNumber2 + 1] = '0';
                        road(maze, randomNumber1, randomNumber2 + 2, width, height);
                    }
                    break;
                case 3: // Down
                    if (randomNumber1 + 2 >= height - 1) continue;
                    if (maze[randomNumber1 + 2][randomNumber2] != '0') {
                        maze[randomNumber1 + 2][randomNumber2] = '0';
                        maze[randomNumber1 + 1][randomNumber2] = '0';
                        road(maze, randomNumber1 + 2, randomNumber2, width, height);
                    }
                    break;
                case 4: // Left
                    if (randomNumber2 - 2 <= 0) continue;
                    if (maze[randomNumber1][randomNumber2 - 2] != '0') {
                        maze[randomNumber1][randomNumber2 - 2] = '0';
                        maze[randomNumber1][randomNumber2 - 1] = '0';
                        road(maze, randomNumber1, randomNumber2 - 2, width, height);
                    }
                    break;
            }
        }

    }

    public Integer[] randomNumber() {
        ArrayList<Integer> randoms = new ArrayList<>();
        for (int i = 0; i < 4; i++) randoms.add(i + 1);
        Collections.shuffle(randoms);

        return randoms.toArray(new Integer[4]);
    }
}

import java.util.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter width, height and number:");
        Scanner inputNumber = new Scanner(System.in);
        int width = inputNumber.nextInt();
        int height = inputNumber.nextInt();
        int number = inputNumber.nextInt();
        for (int z = 0; z < number; ++z) {
            char[][] maze = generateMaze(2 * width + 1, 2 * height + 1);
            maze[0][1] = 'e';
            maze[2 * width][2 * height - 1] = 'e';
            for (char[] x : maze) {
                System.out.println(x);
            }
            System.out.println();
        }

    }

    public static char[][] generateMaze(int height, int width) {
        char[][] maze = new char[height][width];
        for (int i = 0; i < height; i++) Arrays.fill(maze[i], '1');
        Random rand = new Random();
        int randomNumber1 = rand.nextInt(height);
        while (randomNumber1 % 2 == 0) randomNumber1 = rand.nextInt(height);
        int randomNumber2 = rand.nextInt(width);
        while (randomNumber2 % 2 == 0) randomNumber2 = rand.nextInt(width);
        maze[randomNumber1][randomNumber2] = '0';
        recursion(maze, randomNumber1, randomNumber2, width, height);
        return maze;
    }

    public static void recursion(char[][] maze, int randomNumber1, int randomNumber2, int width, int height) {
        Integer[] randDirections = generateRandomDirections();
        for (Integer randDirection : randDirections) {

            switch (randDirection) {
                case 1: // Up
                    if (randomNumber1 - 2 <= 0) continue;
                    if (maze[randomNumber1 - 2][randomNumber2] != '0') {
                        maze[randomNumber1 - 2][randomNumber2] = '0';
                        maze[randomNumber1 - 1][randomNumber2] = '0';
                        recursion(maze, randomNumber1 - 2, randomNumber2, width, height);
                    }
                    break;
                case 2: // Right
                    if (randomNumber2 + 2 >= width - 1) continue;
                    if (maze[randomNumber1][randomNumber2 + 2] != '0') {
                        maze[randomNumber1][randomNumber2 + 2] = '0';
                        maze[randomNumber1][randomNumber2 + 1] = '0';
                        recursion(maze, randomNumber1, randomNumber2 + 2, width, height);
                    }
                    break;
                case 3: // Down
                    if (randomNumber1 + 2 >= height - 1) continue;
                    if (maze[randomNumber1 + 2][randomNumber2] != '0') {
                        maze[randomNumber1 + 2][randomNumber2] = '0';
                        maze[randomNumber1 + 1][randomNumber2] = '0';
                        recursion(maze, randomNumber1 + 2, randomNumber2, width, height);
                    }
                    break;
                case 4: // Left
                    if (randomNumber2 - 2 <= 0) continue;
                    if (maze[randomNumber1][randomNumber2 - 2] != '0') {
                        maze[randomNumber1][randomNumber2 - 2] = '0';
                        maze[randomNumber1][randomNumber2 - 1] = '0';
                        recursion(maze, randomNumber1, randomNumber2 - 2, width, height);
                    }
                    break;
            }
        }

    }

    public static Integer[] generateRandomDirections() {
        ArrayList<Integer> randoms = new ArrayList<Integer>();
        for (int i = 0; i < 4; i++) randoms.add(i + 1);
        Collections.shuffle(randoms);

        return randoms.toArray(new Integer[4]);
    }
}
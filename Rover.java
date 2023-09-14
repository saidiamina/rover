import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Rover {
    private int x;
    private int y;
    private char direction;

    public Rover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void move(char instruction) {
        if (instruction == 'L') {
            turnLeft();
        } else if (instruction == 'R') {
            turnRight();
        } else if (instruction == 'M') {
            moveForward();
        }
    }

    private void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }

    private void moveForward() {
        switch (direction) {
            case 'N':
                y++;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                y--;
                break;
            case 'W':
                x--;
                break;
        }
    }

    public String getPosition() {
        return x + " " + y + " " + direction;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(args[0]));

        String[] plateau = br.readLine().split(" ");
        int maxX = Integer.parseInt(plateau[0]);
        int maxY = Integer.parseInt(plateau[1]);

        String line;
        while ((line = br.readLine()) != null) {
            String[] roverPosition = line.split(" ");
            int x = Integer.parseInt(roverPosition[0]);
            int y = Integer.parseInt(roverPosition[1]);
            char direction = roverPosition[2].charAt(0);

            Rover rover = new Rover(x, y, direction);

            String instructions = br.readLine();
            for (char instruction : instructions.toCharArray()) {
                rover.move(instruction);
            }

            System.out.println(rover.getPosition());
        }

        br.close();
    }
}

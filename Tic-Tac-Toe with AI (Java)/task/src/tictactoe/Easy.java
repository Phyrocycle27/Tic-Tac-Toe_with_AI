package tictactoe;

import java.util.Random;

public class Easy implements Player{
    private Random random = new Random();
    private char cell;

    public Easy (char cell) {
        this.cell = cell;
    }

    @Override
    public void move(char[][] cells) {
        System.out.println("Making move level \"easy\"");

        while (true) {
            int x = random.nextInt(3);
            int y = random.nextInt(3);

            if (cells[2 - y][x] == ' ') {
                cells[2 - y][x] = cell;
                break;
            }
        }

    }
}

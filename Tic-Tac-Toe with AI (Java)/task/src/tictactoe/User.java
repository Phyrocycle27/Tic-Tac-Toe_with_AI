package tictactoe;

import java.util.Scanner;

public class User implements Player{
    private char cell;

    public User (char cell) {
        this.cell = cell;
    }
    @Override
    public void move(char[][] cells) {
        while (true) {
            Scanner corScanner = new Scanner(System.in);

            System.out.print("Enter the coordinates: ");

            Integer x = corScanner.hasNextInt() ? corScanner.nextInt() : null;
            Integer y = corScanner.hasNextInt() ? corScanner.nextInt() : null;

            if (x == null || y == null) {
                System.out.println("You should enter numbers!");
            } else if ((x > Main.getLength() || x < 1) || (y > Main.getLength() || y < 1)) {
                System.out.println("Coordinates should be from 1 to " + Main.getLength() + "!");
            } else if (cells[Main.getLength() - y][x - 1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
            } else {
                cells[Main.getLength() - y][x - 1] = cell;
                break;
            }
        }
    }
}
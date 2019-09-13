package tictactoe;

import java.util.Scanner;

public class Main {
    private static char[][] cells;
    private static final int length = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player playerOne;
        Player playerTwo;

        while (true) {
            System.out.print("Input command: ");
            String[] parameters = scanner.nextLine().split("[ ]");

            switch (parameters[0]) {
                case "start":
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Bad parameters!");
                    continue;
            }
            if (parameters.length == 3) {
                switch (parameters[1]) {
                    case "user":
                        playerOne = new User('X');
                        break;
                    case "easy":
                        playerOne = new Easy('X');
                        break;
                    case "medium":
                        playerOne = new Medium('X');
                        break;
                    default:
                        System.out.println("Bad parameters!");
                        continue;
                }

                switch (parameters[2]) {
                    case "user":
                        playerTwo = new User('O');
                        break;
                    case "easy":
                        playerTwo = new Easy('O');
                        break;
                    case "medium":
                        playerTwo = new Medium('O');
                        break;
                    default:
                        System.out.println("Bad parameters!");
                        continue;
                }
                break;
            } else {
                System.out.println("Bad parameters!");
            }
        }

        cells = new char[length][length];
        for (int i = 0; i < length * length; i++) {
            cells[i / length][i % length] = ' ';
        }

        printGameField();
        String gameState;

        while (true) {
            playerOne.move(cells);
            printGameField();

            gameState = checkGameState();
            if (!gameState.equals("")) {
                System.out.println(gameState);
                break;
            }

            playerTwo.move(cells);
            printGameField();

            gameState = checkGameState();
            if (!gameState.equals("")) {
                System.out.println(gameState);
                break;
            }
        }
    }

    private static String checkGameState() {
        String state = "";
        int xCnt = 0;
        int oCnt = 0;
        boolean xWins = false;
        boolean oWins = false;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (cells[i][j] == 'X') {
                    xCnt++;
                } else if (cells[i][j] == 'O') {
                    oCnt++;
                }
                if (j >= 2 && i + 2 < length) {
                    if (cells[i][j] == cells[i + 1][j - 1] && cells[i][j] == cells[i + 2][j - 2]) {
                        if (cells[i][j] == 'X') {
                            xWins = true;
                        } else if (cells[i][j] == 'O') {
                            oWins = true;
                        }
                    }
                }
                if (i + 2 < length && j + 2 < length) {
                    if (cells[i][j] == cells[i + 1][j + 1] && cells[i][j] == cells[i + 2][j + 2]) {
                        if (cells[i][j] == 'X') {
                            xWins = true;
                        } else if (cells[i][j] == 'O') {
                            oWins = true;
                        }
                    }
                }
                if (j + 2 < length) {
                    if (cells[i][j] == cells[i][j + 1] && cells[i][j + 1] == cells[i][j + 2]) {
                        if (cells[i][j] == 'X') {
                            xWins = true;
                        } else if (cells[i][j] == 'O') {
                            oWins = true;
                        }
                    }
                    if (cells[j][i] == cells[j + 1][i] && cells[j][i] == cells[j + 2][i]) {
                        if (cells[j][i] == 'X') {
                            xWins = true;
                        } else if (cells[j][i] == 'O') {
                            oWins = true;
                        }
                    }
                }
            }
        }

        if ((Math.abs(xCnt - oCnt) > 1) || (oWins && xWins)) {
            state = "Impossible";
        } else if (xWins) {
            state = "X wins";
        } else if (oWins) {
            state = "O wins";
        } else if (xCnt + oCnt == length * length) {
            state = "Draw";
        }
        return state;
    }

    private static void printGameField() {
        System.out.println("---------");
        for (char[] line : cells) {
            System.out.print("| ");
            for (char cell : line) {
                System.out.print(cell + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    static int getLength() {
        return length;
    }
}
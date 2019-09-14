package tictactoe;

public class Medium implements Player {
    private char cell;
    private Easy easy;

    public Medium(char cell) {
        easy = new Easy(cell);
        this.cell = cell;
    }

    @Override
    public void move(char[][] cells) {
        int length = Main.getLength();

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                // PASS ↙
                if (j >= 1 && i + 1 < length) {
                    if (cells[i][j] == cells[i + 1][j - 1]) {
                        if (i > 0 && j + 1 < length && cells[i - 1][j + 1] == ' ') {
                            cells[i - 1][j + 1] = cell;
                            return;
                        } else if (i + 2 < length && j > 1 && cells[i + 2][j - 2] == ' ') {
                            cells[i + 2][j - 2] = cell;
                            return;
                        }
                    }
                }

                // PASS ↘
                if (i + 1 < length && j + 1 < length) {
                    if (cells[i][j] == cells[i + 1][j + 1]) {
                        if (i + 2 < length && j + 2 < length && cells[i + 2][j + 2] == ' ') {
                            cells[i + 2][j + 2] = cell;
                            return;
                        } else if (i >= 1 && j >= 1 && cells[i - 1][j - 1] == ' ') {
                            cells[i - 1][j - 1] = cell;
                            return;
                        }
                    }
                }

                if (j + 1 < length) {
                    // PASS →
                    if (cells[i][j] == cells[i][j + 1]) {
                        if (j + 2 < length && cells[i][j + 2] == ' ') {
                            cells[i][j + 2] = cell;
                            return;
                        } else if (j > 0 && cells[i][j - 1] == ' ') {
                            cells[i][j - 1] = cell;
                            return;
                        }
                    }

                    // PASS ↓
                    if (cells[j][i] == cells[j + 1][i]) {
                        if (j + 2 < length && cells[j + 2][i] == ' ') {
                            cells[j + 2][i] = cell;
                            return;
                        } else if (j > 0 && cells[j - 1][i] == ' ') {
                            cells[j - 1][i] = cell;
                            return;
                        }
                    }
                }
            }
        }

        easy.move(cells);
    }
}

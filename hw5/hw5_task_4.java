// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.

package hw5;

public class hw5_task_4 {

    public static void main(String[] args) {
        int[][] field = new int[8][8];
        queen(1, field, 5, 6);

    }

    private static void queen(int num, int[][] field, int x, int y) {
        if (x < 0 || y < 0 || x >= field[0].length || y >= field.length)
            return;
        if (field[y][x] != 0 || field[y][x] == -1)
            return;

        for (int i = 0; i < field[x].length; i++) {
            field[i][x] = -1;
        }
        for (int i = 0; i < field[y].length; i++) {
            field[y][i] = -1;
        }
        // if (y>x) {
        // for (int i = 0; i < field[x].length; i++) {
        // for (int j = 0; j < field[y].length-(y-x); j++) {
        // field[y-x+j][j] = -1;
        // }
        // }
        // }
        // else {
        // for (int i = 0; i < field[x].length; i++) {
        // for (int j = 0; j < field[y].length-(x-y); j++) {
        // field[j][x-y+j] = -1;
        // }
        // }
        // }
        if (y < x) {
            for (int i = 0; i < field[x].length; i++) {
                for (int j = 0; j < field[y].length - 1; j++) {
                    field[field[y].length / 2 + y - j][j + 1] = -1;
                }
            }
        }
        else {
            for (int i = 0; i < field[x].length; i++) {
                for (int j = 0; j < field[y].length - 1; j++) {
                    field[field[y].length / 2 + x - j][j + 1] = -1;
                }
            }
        }

        field[y][x] = num;
        if (num > 0) {
            print(field);
            System.exit(0);
        }
        queen(num + 1, field, x + 2, y - 1);
        queen(num + 1, field, x - 2, y - 1);
        queen(num + 1, field, x + 2, y + 1);
        queen(num + 1, field, x - 2, y + 1);
        queen(num + 1, field, x + 1, y + 2);
        queen(num + 1, field, x - 1, y + 2);
        queen(num + 1, field, x + 1, y - 2);
        queen(num + 1, field, x - 1, y - 2);
        field[y][x] = 0;
    }

    private static void print(int[][] field) {
        for (int[] row : field) {
            for (int cell : row) {
                System.out.printf("%2d ", cell);
            }
            System.out.println();
        }
    }
}

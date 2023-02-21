import java.util.ArrayDeque;
import java.util.Queue;

public class Task1 {
    public static void main(String[] args) {
        int[][] map = getMap();
        map = start(map, 7, 4);
        pprint(map);
        finish(map, 1, 1);
        finish(map, 2, 2);
    }

    static int[][] getMap() {
        return new int[][] {
                { 00, 00, 00, 00, 00, 00, 00, 00 },
                { 00, 00, -1, 00, 00, 00, 00, 00 },
                { 00, 00, -1, 00, -1, 00, -1, 00 },
                { 00, 00, -1, 00, 00, 00, -1, 00 },
                { 00, 00, -1, 00, 00, 00, -1, 00 },
                { 00, -1, -1, -1, -1, -1, -1, 00 },
                { 00, 00, -1, 00, 00, 00, -1, 00 },
                { 00, 00, -1, 00, 00, 00, -1, 00 },
                { 00, 00, 00, 00, 00, 00, -1, 00 },
                { 00, 00, 00, 00, 00, 00, -1, 00 },
                { 00, 00, 00, 00, 00, 00, 00, 00 }
        };
    }

    static void pprint(int[][] m) {
        int rows = m.length;
        int colums = m[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (m[i][j] < 0) {
                    // System.out.printf(" %d ", m[i][j]);
                    System.out.printf("▓▓▓▓", m[i][j]);
                } else if (m[i][j] == 1) {
                    System.out.printf(" ═╬═");
                } else if (m[i][j] < 10) {
                    System.out.printf("  %d ", m[i][j]);
                } else {
                    System.out.printf(" %d ", m[i][j]);
                }

                /*
                 * if (m[i][j] == -1)
                 * System.out.printf("%s", " -1 ");
                 * else if (m[i][j] == -2)
                 * System.out.printf("%s", " -2 ");
                 * else
                 * System.out.printf("%s", "  0 ");
                 */
                // System.out.printf("%4d", m[i][j]);
            }
            System.out.println();
        }
    }

    static int[][] start(int[][] map, int x, int y) {
        map[x][y] = 1;
        Queue<int[]> arr = new ArrayDeque<int[]>();
        arr.add(new int[] { x, y });

        int h = map[0].length;
        int w = map.length;

        while (true) {
            if (arr.isEmpty()) {
                break;
            }

            // x - num[0]
            // y - num[1]

            int[] num = arr.poll();
            x = num[0];
            y = num[1];

            int count = map[x][y];

            if ((y - 1) >= 0 && (y - 1) < h && map[x][y - 1] == 0) {
                map[x][y - 1] = count + 1;
                arr.add(new int[] { x, y - 1 });
            }

            if ((y + 1) >= 0 && (y + 1) < h && map[x][y + 1] == 0) {
                map[x][y + 1] = count + 1;
                arr.add(new int[] { x, y + 1 });
            }

            if ((x - 1) >= 0 && (x - 1) < w && map[x - 1][y] == 0) {
                map[x - 1][y] = count + 1;
                arr.add(new int[] { x - 1, y });
            }

            if ((x + 1) >= 0 && (x + 1) < w && map[x + 1][y] == 0) {
                map[x + 1][y] = count + 1;
                arr.add(new int[] { x + 1, y });
            }

        }

        return map;
    }

    static void finish(int[][] map, int x, int y) {
        int count = map[x][y];
        System.out.printf("\nФиниш в точке x=%d y=%d\n", x, y);
        if (count > 0) {
            System.out.printf("До финиша можно дойти за %d шагов\n", count);
        } else {
            System.out.printf("Не удалось добратся до финиша\n");
        }
    }

}

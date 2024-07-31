package org.example;
import java.util.Scanner;

public class HuaWeiTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int blackCount = 0;
        int whiteCount = 0;
        int[][] visited = new int[19][19];
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
                int a = in.nextInt();
                int b = in.nextInt();
                // System.out.println(a + b);
                visited[a][b] = 1;

                if (inArea(a - 1, b, visited)) {
                    blackCount++;
                }

                if (inArea(a + 1, b, visited)) {
                    blackCount++;
                }

                if (inArea(a, b - 1, visited)) {
                    blackCount++;
                }

                if (inArea(a, b + 1, visited)) {
                    blackCount++;
                }
        }

        while (in.hasNext()) {
            int a = in.nextInt();
            int b = in.nextInt();
            // System.out.println(a + b);
            visited[a][b] = 1;

            if (inArea(a - 1, b, visited)) {
                whiteCount++;
            }

            if (inArea(a + 1, b, visited)) {
                whiteCount++;
            }

            if (inArea(a, b - 1, visited)) {
                whiteCount++;
            }

            if (inArea(a, b + 1, visited)) {
                whiteCount++;
            }
        }

        System.out.println(blackCount + " " + whiteCount);
    }

    public static boolean inArea(int a, int b, int[][] visited) {
        if ((a > 0 && a < 19) && (b > 0 && b < 19) && visited[a][b] == 0) {
            return true;
        }
        return false;
    }
}

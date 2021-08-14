/**
 * 稀疏数组
 */

package day02;

public class ArrayDemo2 {

    public static void main(String[] args) {

        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;
        System.out.println("完整数组如下：");
        for (int[] arr : array) {
            for (int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        System.out.println("==========================");

        // 开始生成稀疏数组。首先你得知道稀疏数组共有多少个有效数字，其次原始数组的行列数。
        int rows = array.length;
        // 不考虑边界场景的条件下，只是为了了解稀疏数组是什么
        int cols = array[0].length;
        // 用来记录有多少个有效数字
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] != 0) {
                    count++;
                }
            }
        }
        // 稀疏数组的行数 = 原始有效数字 + 1；列数 = 3
        int[][] array2 = new int[count + 1][3];
        int index = 0;
        array2[index][0] = rows;
        array2[index][1] = cols;
        array2[index][2] = count;
        ++index;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j] != 0) {
                    array2[index][0] = i;
                    array2[index][1] = j;
                    array2[index][2] = array[i][j];
                    ++index;
                }
            }

        }
        // 打印稀疏数组
        System.out.println("稀疏数组如下：");
        for (int i = 0; i <= count; i++) {
            System.out.println(array2[i][0] + " " + array2[i][1] + " "+ array2[i][2]);
        }

        System.out.println("==========================");
        // 如何还原一个稀疏数组，同样不考虑边界条件
        int[][] array3 = new int[array2[0][0]][array2[0][1]];
        for (int i = 1; i < array2.length; i++) {
            array3[array2[i][0]][array2[i][1]] = array2[i][2];
        }
        System.out.println("还原稀疏数组如下：");
        for (int[] arr : array3) {
            for (int value : arr) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }


}

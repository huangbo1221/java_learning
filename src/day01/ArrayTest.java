package day01;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        int[] a = {1, 5, 4, 900,65};

        // 对数组进行升序排序功能
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }

}

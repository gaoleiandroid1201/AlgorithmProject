package com.gaolei.java_lib.array_tow_num_sum;

import java.util.Arrays;

public class ArrayTwoNumSum {
    public static void main(String[] args) {

        int array[] = {3, 0,6, 1, 8, 2};
        System.out.println("排序前：" + Arrays.toString(array));
        quick(array);
        System.out.println("排序后：" + Arrays.toString(array));
        boolean isExit = getSumNum(array, 1);
        System.out.println("isExit：" + isExit);
    }

    //时间复杂度o(n)
    public static boolean getSumNum(int[] arr, int Sum)   //arr为数组，Sum为和
    {
        int i, j;
        int n = arr.length;
        for (i = 0, j = n - 1; i < j; ) {
            if (arr[i] + arr[j] == Sum) {
                System.out.println("arr[i]：" + arr[i]);
                System.out.println("arr[j]：" + arr[j]);
                return true;
            } else if (arr[i] + arr[j] < Sum)
                i++;
            else
                j--;
        }
        return false;
    }

    //快速排序
    public static int getMiddle(int[] array, int low, int high) {
        int tmp = array[low];    //数组的第一个作为中轴
        while (low < high) {
            while (low < high && array[high] >= tmp) {

                high--;
            }
            array[low] = array[high];   //比中轴小的记录移到低端
            while (low < high && array[low] <= tmp) {
                low++;
            }
            array[high] = array[low];   //比中轴大的记录移到高端
        }
        array[low] = tmp;              //中轴记录到尾

        return low;                   //返回中轴的位置
    }

    public static void _quickSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = getMiddle(array, low, high);  //将list数组进行一分为二
            System.out.println(Arrays.toString(array));
            System.out.println("middle：" + middle);
            _quickSort(array, low, middle - 1);        //对低字表进行递归排序
            _quickSort(array, middle + 1, high);       //对高字表进行递归排序
        }
    }

    public static void quick(int[] a2) {
        if (a2.length > 0) {    //查看数组是否为空
            _quickSort(a2, 0, a2.length - 1);
        }
    }

}

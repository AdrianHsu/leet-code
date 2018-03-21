import java.util.*;

public class BubbleSort {
    public static void main(String args[]) {
        
        int [] arr = new int []{ 10, 2, 3, 4, 1, 19, 1, 8};
        for(int i = 0 ; i < arr.length; i ++) {
            for(int j = 0; j < arr.length - i - 1; j ++) {
                if( arr[j + 1] < arr[j] ) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }

        for(int i = 0; i < arr.length; i ++)
            System.out.println(arr[i]);
    }
}
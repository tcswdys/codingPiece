/**
 *
 */
package play;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ydu
 *
 */
public class combinationPrintHourMin {

    static Set<Integer> hour;
    static Set<Integer> min;

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        System.out.println(Policy.valueOf("aaa"));


//        System.out.println(Math.abs((long) Integer.MIN_VALUE));
//        System.out.println((long)Integer.MIN_VALUE / -1);
//        System.out.println((long)Integer.MIN_VALUE % -1);


        int arr[] = {0, 1, 2, 3};
        int arr2[] = {0, 1, 2, 3, 4, 5};

        hour = new HashSet<>();
        min = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            int[] result = new int[4];
            int[] result2 = new int[6];
            com(arr, 4, i, 0, 0, result, true);
            com(arr2, 6, 3 - i, 0, 0, result2, false);
            for (Integer n : hour) {
                for (Integer m : min) {
                    System.out.println(n + ":" + m);
                }
            }
            hour.clear();
            min.clear();
        }

    }


    static void com(int[] position, int len, int targetLen, int index, int i, int[] result, boolean hOrm) {
        if (index == targetLen) {
            int num = 0;
            for (int j = 0; j < targetLen; j++) {
                num |= (1 << result[j]);
            }
            if (hOrm) {
                if (num < 13) {
                    hour.add(num);
                }
            } else {
                if (num < 60) {
                    min.add(num);
                }
            }
            return;
        }

        if (i >= len) {
            return;
        }

        result[index] = position[i];

        com(position, len, targetLen, index + 1, i + 1, result, hOrm);
        com(position, len, targetLen, index, i + 1, result, hOrm);
    }

}

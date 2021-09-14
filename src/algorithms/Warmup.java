package algorithms;

import java.util.ArrayList;
import java.util.List;

class Warmup {

    static int simpleArraySum(List<Integer> arr) {
        int sum = 0;
        for (Integer val : arr) {
            sum += val;
        }
        return sum;
    }

    public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int len = a.size();
        int[] res = new int[2];
        for (int i = 0; i < len; i++) {
            if (a.get(i) > b.get(i)) {
                ++res[0];
            } else if (a.get(i) < b.get(i)) {
                ++res[1];
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int score : res) {
            ans.add(score);
        }
        return ans;
    }

    public static long aVeryBigSum(List<Long> arr) {
        long sum = 0;
        for (Long val : arr) {
            sum += val;
        }
        return sum;
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        int left2right = 0, right2left = 0;
        int cols = arr.get(0).size();
        int leftCol = 0, rightCol = cols - 1;
        for (List<Integer> row : arr) {
            if (leftCol < cols) {
                left2right += row.get(leftCol++);
            }
            if (rightCol >= 0) {
                right2left += row.get(rightCol--);
            }
        }
        return Math.abs(left2right - right2left);
    }

    public static void plusMinus(List<Integer> arr) {
        float total = arr.size();
        int positive = 0, negative = 0, zero = 0;
        for (Integer val : arr) {
            if (val == 0) {
                ++zero;
            } else if (val > 0) {
                ++positive;
            } else {
                ++negative;
            }
        }
        System.out.printf("%.6f\n", positive / total);
        System.out.printf("%.6f\n", negative / total);
        System.out.printf("%.6f\n", zero / total);
    }

    public static void staircase(int n) {
        int j;
        for (int i = 0; i < n; i++) {
            for (j = 0; j < n - 1 - i; j++) {
                System.out.print(" ");
            }
            for (; j < n; ++j) {
                System.out.print("#");
            }
            System.out.println();
        }
    }

    public static void miniMaxSum(List<Integer> arr) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        long sum = 0;
        for (Integer val : arr) {
            sum += val;
            max = Math.max(max, val);
            min = Math.min(min, val);
        }
        System.out.println((sum - max) + " " + (sum - min));
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        int tallest = 0;
        int max = -1;
        for (Integer candle : candles) {
            if (max < candle) {
                max = candle;
                tallest = 1;
            } else if (max == candle) {
                ++tallest;
            }
        }
        return tallest;
    }

    public static String timeConversion(String s) {
        String pm = "PM", am = "AM";
        char[] str = s.substring(0, s.length() - 2).toCharArray();
        if (s.endsWith(pm) && !s.startsWith("12")) {
            ++str[0];
            if (str[1] - '0' < 8) {
                str[1] += 2;
            } else {
                int diff = str[1] - '0';
                str[1] = (char) ('0' + (diff + 2) % 10);
                ++str[0];
            }
        } else if (s.endsWith(am) && s.startsWith("12")) {
            --str[0];
            str[1] -= 2;
        }
        return String.valueOf(str);
    }
}
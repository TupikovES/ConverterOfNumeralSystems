package com.samgtu.cons.util;

/**
 * Created by x3mib_000 on 30.10.2015.
 */
public class ConvertMethod {
    public static Integer toDec(Integer num, int ns) {
        String s = num.toString();
        int r = s.length();

        int sum = 0;

        for (int i = 0; i < r; i++) {
            sum += Math.pow(ns, i) * (num % 10);
            num /= 10;
        }

        return sum;
    }

    public static long fromDec(int num, int ns) {
        long s = 0;
        long mn = 1;
        while(true){
            int ret = num % ns;
            num /= ns;
            s += ret * mn;
            mn *= 10;
            if(num < ns) {
                s += num * mn;
                break;
            }
        }

        return s;
    }

}

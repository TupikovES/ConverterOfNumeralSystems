package com.samgtu.cons.util;

import java.math.BigInteger;

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

    public static String toDecNew(String s, int ns) {
        int[] num = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            int buf = (int)s.charAt(i);
            if (buf < 58)
                num[i] = buf - 48;
            else
                num[i] = buf - 55;
        }

        //BigInteger sum = new BigInteger("0");
        long sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += Math.pow(ns, i) * num[s.length() - i - 1];
            //sum.add(BigInteger.valueOf((long)Math.pow(ns, i)).multiply(BigInteger.valueOf(num[s.length() - i - 1])));
        }
        return String.valueOf(sum);
    }

    public static String fromDecNew(String s, int ns) {
        BigInteger
                b = new BigInteger(s),
                nsBig = BigInteger.valueOf(ns);

        BigInteger[] bigArr;
        String value = "";
        char val;
        while (true) {
            bigArr = b.divideAndRemainder(nsBig);
            if(bigArr[1].compareTo(BigInteger.valueOf(10)) < 0) {
                val = (char)(Integer.parseInt(bigArr[1].toString()) + 48);
            }
            else {
                val = (char)(Integer.parseInt(bigArr[1].toString()) + 55);
            }
            value = val + value;
            System.out.println(val);
            if ((bigArr[0].compareTo(nsBig)) < 0) {
                if(bigArr[0].compareTo(BigInteger.valueOf(10)) < 0) {
                    val = (char)(Integer.parseInt(bigArr[0].toString()) + 48);
                }
                else {
                    val = (char)(Integer.parseInt(bigArr[0].toString()) + 55);
                }
                if (val != '0')
                    value = val + value;
                break;
            }
            b = bigArr[0];
        }

        return value;
    }
}

package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        long q = System.nanoTime();
        factors( 791943245);
        long d = System.nanoTime();
        //factors_how_it_was_supposed(791943245);
        long h = System.nanoTime();
        System.out.println((d-q)/10000);
        System.out.println((h - d)/10000 );
    }
    // !!!
    // мой метод работает быстрее всех, которые я проверял, причем намного у большинства
    // только один был быстрее с Map, но там очень большое решение
    public static String factors(int n)
    {
        int check_num = 1;
        int prime = 2;
        int times = 0;
        boolean is_prime = false;

        StringBuilder result = new StringBuilder();
        while(n != 1)
        {
            if (n%prime == 0)
            {
                n /= prime;
                times++;
                if(n == 1)
                {
                    if (times > 1) result.append("(").append(prime).append("**").append(times).append(")");
                    else if (times == 1) result.append("(").append(prime).append(")");
                }
            }
            else
            {
                if (times > 1) result.append("(").append(prime).append("**").append(times).append(")");
                else if (times == 1) result.append("(").append(prime).append(")");

                while (!is_prime)
                {
                    //System.out.println(prime);

                    if (prime == 2) prime++;
                    else prime+=2;

                    // по т.Ферма -> https://habr.com/ru/company/otus/blog/486116/
                    if (Math.pow(check_num, prime-1)%prime == 1.0f) is_prime = true;
                }
                times = 0;
                is_prime = false;
            }
        }

        return result.toString();
    }
}

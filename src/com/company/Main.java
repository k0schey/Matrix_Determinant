package com.company;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;

public class Main
{
    public static void main(String[] args)
    {
        int[][] n ={ {1, -3, -4, 8, -6, 7, 10, 6},
                {-3, -3, 5, 5, 7, -4, -5, 5},
                {5, 1, 8, -8, -4, -3, 2, -1},
                {-6, 7, -2, 8, 9, 9, 0, -9},
                {8, 9, 7, -2, -5, 7, -9, -1},
                {-2, -8, -5, 4, 6, 7, 2, 1},
                {9, 10, 5, -5, 7, -9, 6, -1},
                {7, 9, 7, 9, 6, 2, 4, 9}};
        long a = System.currentTimeMillis();
        determinant(n);
        long b = System.currentTimeMillis();
        determinant_how_it_was_supposed(n);
        long c = System.currentTimeMillis();
        System.out.println(b-a);
        System.out.println(c-b);
    }

    public static int determinant_how_it_was_supposed(int[][] m) {
        int d = 0, size = m.length;
        if (size == 1) return m[0][0];

        for (int n = 0 ; n < size ; n++) {
            int[][] newM = new int[size-1][size-1];
            for (int x = 1 ; x < size ; x++) for (int y = 0 ; y < size ; y++) {
                if (y == n) continue;
                newM[x-1][y + (y>n ? -1 : 0)] = m[x][y];
            }
            d += (n%2!=0 ? -1 : 1) * m[0][n] * determinant(newM);
        }
        return d;
    }

    // надо было привести к int ответ в конце
    public static long determinant(int[][] n)
    {

        if (n.length == 1) return n[0][0];
        else if (n.length == 2) return (((long) n[0][0] *n[1][1]- (long) n[0][1] *n[1][0]));
        else
        {
            long result = 0;
            int[][] a = new int[n.length-1][n[0].length-1];

            // создаем уменьшанный массив
            for (int i = 0; i < n[0].length; i++)
            {
                // добавляем все элементы до столба исключения слева
                // маркер по  горизонтали исходного массива
                for(int d = 0; d < i; d++)
                {
                    // маркер по  вертикали исходдного массива
                    for(int x = 1; x < n.length; x++)
                    {
                        a[x-1][d] = n[x][d];
                    }
                }

                // добавляем все элементы до столба исключения справа
                for(int d = i+1; d < n[0].length; d++)
                {
                    for(int x = 1; x < n.length; x++)
                    {
                        a[x-1][d-1] = n[x][d];
                    }
                }

                if (a.length > 2) result += Math.pow(-1, i)*n[0][i]*determinant(a);
                else if (a.length == 2) result += (int)Math.pow(-1, i)*n[0][i]*((long) a[0][0] *a[1][1]- (long) a[0][1] *a[1][0]);
            }
        return (int)result;
        }
    }
}




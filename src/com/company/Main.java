package com.company;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        s = encode(s);
        System.out.println(s);
    }

    static String encode(String word)
    {
        char[] w = word.toLowerCase(Locale.ROOT).toCharArray();
        Obj[] s = new Obj[w.length];
        for (int i = 0; i < s.length; i++)
        {
            s[i] = new Obj(w[i], false);
        }

        for(int i = 0; i < s.length-1; i++)
        {
            boolean d = false;
            for(int j = i+1; j < s.length; j++)
            {
                if ((s[i].i == s[j].i) && !(s[j]).i_was_changed && !(s[i]).i_was_changed)
                {
                    d = true;
                    s[j].i = ')';

                    s[j].i_was_changed = true;
                }
            }
            if (d)
            {
                System.out.println(i);
                s[i].i = ')';
                s[i].i_was_changed = true;
            }
        }

        String a = "";

        for(int i = 0; i < s.length; i++)
        {
            if (!s[i].i_was_changed)
            {
                System.out.println(i);
                s[i].i = '(';
            }
            a += s[i].i;
        }
        return a;
    }

    // from best solution on codewars
    static String encode2(String word)
    {
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i)
        {
            char c = word.charAt(i);
            result += word.lastIndexOf(c) == word.indexOf(c) ? "(" : ")";
        }
        return result;
    }
}

class Obj
{
    char i;
    boolean i_was_changed;
    Obj(char d, boolean b)
    {
        i = d;
        i_was_changed = b;
    }
}

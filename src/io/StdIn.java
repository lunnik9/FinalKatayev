package io;

import java.util.Scanner;


public class StdIn implements Input {

    @Override
    public IO In() {
        Scanner sc = new Scanner(System.in);
        IO res = new IO();
        String input;
            input = sc.next();


        res.setInput(input);
        return res;
    }
}

package io;

import java.util.Scanner;


public class StdIn implements Input {
    private String in;

    @Override
    public String getIn() {
        return in;
    }

    public void setIn(String in) {
        this.in = in;
    }

    @Override
    public IO In() {
        Scanner sc = new Scanner(System.in);
        IO res = new IO();
        String input;
        input = sc.next();
        in = input;
        res.setInput(input);

        return res;
    }
}

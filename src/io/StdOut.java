package io;

public class StdOut implements Output {
    @Override
    public void Out(IO process) {
        System.out.println(process.getOutput());
    }
}

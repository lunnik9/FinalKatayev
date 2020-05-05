package io;

public class StdOut implements Output {
    private String out;

    @Override
    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    @Override
    public void Out(IO process) {
        System.out.println(process.getOutput().split("#")[1]);
    }
}

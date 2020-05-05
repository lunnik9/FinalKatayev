package process;

import io.Input;
import io.Output;

import java.util.UUID;

public class Proc {
    private String pid;
    private Input input;
    private Output otuput;


    public void setInput(Input input) {
        this.input = input;
    }

    public void setOtuput(Output otuput) {
        this.otuput = otuput;
    }

    public String getPid() {
        return pid;
    }

    public Input getInput() {
        return input;
    }

    public Output getOtuput() {
        return otuput;
    }

    public void init(){
        pid= UUID.randomUUID().toString();
    }
}

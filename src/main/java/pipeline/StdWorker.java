package pipeline;

import io.StdOut;
import process.Proc;
import process.ProcessMap;

public class StdWorker implements Worker {

    @Override
    public Proc process(Proc process, Proc prev, ProcessMap map) {

        process.setOtuput(new StdOut());
        StdOut nextOut = new StdOut();
        Proc out =new Proc();

        if (prev == null) {
            nextOut.setOut(process.getInput().getIn());
            process.setOtuput(nextOut);
            return process;
        }
        if (process.getInput().getIn().split("#")[0].equals("add")) {
            nextOut.setOut(process.getInput().getIn().split("#")[0] +"#"+
                    (Integer.parseInt(prev.getOtuput().getOut().split("#")[1]) +
                            Integer.parseInt(process.getInput().getIn().split("#")[1])
                    )
            );

        } else if (process.getInput().getIn().split("#")[0].equals("substract")) {
            nextOut.setOut(process.getInput().getIn().split("#")[0] +"#"+
                    (Integer.parseInt(prev.getOtuput().getOut().split("#")[1]) -
                            Integer.parseInt(process.getInput().getIn().split("#")[1])
                    )
            );
        }
        out.setOtuput(nextOut);

        return out;
    }
}

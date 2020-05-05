import exceptions.InvalidInput;
import io.IO;
import io.Output;
import io.StdIn;
import io.StdOut;
import pipeline.Pipeline;
import pipeline.StdWorker;
import pipeline.WorkerPool;
import process.StdProcessMap;

public class Main {
    public static void main(String[] args)  {
        StdIn in= new StdIn();
        StdOut out=new StdOut();
        in.In();

        StdProcessMap map=new StdProcessMap();
        try{
            map.init(in);

        }catch (InvalidInput invalidInput) {
            invalidInput.printStackTrace();
        }

        WorkerPool wp=new WorkerPool();
        wp.init(new StdWorker(),3);
        
        Pipeline pipeline =new Pipeline(map,wp);
        IO io = null;
        try {
            io=pipeline.run(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        out.Out(io);
    }
}

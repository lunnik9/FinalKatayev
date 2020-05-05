package pipeline;

import io.IO;
import io.Output;
import process.Proc;
import process.ProcessMap;

public class Pipeline {
    private ProcessMap map;
    private WorkerPool wp;

    public Pipeline(ProcessMap map, WorkerPool wp) {
        this.map = map;
        this.wp = wp;
    }

    public IO run(int sleepTime) throws InterruptedException {
        String pid = "1";
        Output output = null;
        Proc prev = null;
        for (Proc process = map.getByPid(pid); process != null; process = map.getByPid(pid)) {
            while (wp.isEmpty()) {
                Thread.sleep(sleepTime);
            }

            Worker w = wp.getWorker();
            prev = w.process(process, prev, map);
            pid = process.getPid();
            output = prev.getOtuput();
            wp.putWorker(w);

            System.out.print("\u001B[31m###\u001B[0m");
            Thread.sleep(1000);
        }
        System.out.println();
        IO res = new IO();
        res.setOutput(output.getOut());
        return res;
    }
}

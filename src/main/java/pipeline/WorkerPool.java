package pipeline;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class WorkerPool {
    private ImmutableList<Worker> pool;
    private AtomicInteger len;

    public boolean isEmpty() {
        return len.equals(new AtomicInteger(0));
    }

    public Worker getWorker() {
        Worker tmp = pool.get(pool.size() - 1);
        len.decrementAndGet();
        return tmp;
    }

    public void putWorker(Worker w) {
        len.incrementAndGet();
    }


    public void init(Worker worker, int len) {
        ArrayList<Worker> temp = new ArrayList<Worker>();

        for (int i = 0; i < len; i++) {
            temp.add(worker);
        }
        this.len = new AtomicInteger();
        this.len.set(len);
        pool = ImmutableList.copyOf(temp);
    }
}

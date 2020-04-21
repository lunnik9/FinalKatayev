package pipeline;

public class WorkerMap {
    private WorkerMap map;

    public void init() {
        if (map == null) {
            map = new WorkerMap();
        }
    }
}

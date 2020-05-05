package pipeline;

import process.Proc;
import process.ProcessMap;

public interface Worker {
    Proc process(Proc process,Proc prev, ProcessMap map);
}

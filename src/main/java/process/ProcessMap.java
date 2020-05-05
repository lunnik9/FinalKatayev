package process;

import exceptions.InvalidInput;
import io.Input;

public interface ProcessMap {
    void init(Input input) throws InvalidInput;
    Proc getByPid(String pid);

}

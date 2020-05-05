package process;

import com.google.common.collect.ImmutableMap;
import exceptions.InvalidInput;
import io.Input;
import io.StdIn;

import java.util.HashMap;

public class StdProcessMap implements ProcessMap {
    ImmutableMap<String, Proc> iMap;

    public void init(Input input) throws InvalidInput {
        HashMap<String, Proc> map = new HashMap<String, Proc>();

        String operation = input.getIn().split("#")[0];
        if (!operation.equals("add") && !operation.equals("substract")) {
            throw new InvalidInput("unsupported operation type: " + input.getIn().split("#")[0]);
        }

        int number = Integer.parseInt(input.getIn().split("#")[1]);

        String tmp = null;

        for (int i = 0; i < number; i++) {
            Proc process = new Proc();
            process.init();
            StdIn procIn = new StdIn();
            procIn.setIn(input.getIn().split("#")[0] + "#" + input.getIn().split("#")[i + 2]);
            process.setInput(procIn);
            if (i == 0) {
                StdIn firstIn = new StdIn();
                firstIn.setIn(input.getIn().split("#")[0] + "#0");
                map.put("1", process);
                tmp = process.getPid();
            } else {
                map.put(tmp, process);
                tmp = process.getPid();
            }
        }

        iMap = ImmutableMap.copyOf(map);
    }

    @Override
    public Proc getByPid(String pid) {
        return iMap.get(pid);
    }
}

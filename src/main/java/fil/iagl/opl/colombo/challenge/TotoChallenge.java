package fil.iagl.opl.colombo.challenge;

import java.util.Arrays;
import java.util.List;

public class TotoChallenge implements Challenge<Integer> {

    @Override
    public Class<Integer> getInputFormat() {
        return Integer.class;
    }

    @Override
    public List<Integer> getInputs() {
        return Arrays.asList(1, 2);
    }

    @Override
    public Object doIt(Integer input) {
        return null;
    }

    @Override
    public void challenge(Integer input) {
        int a = 3;
        a = a + input;
        assert a != 5;
    }
}

package fil.iagl.opl.colombo.challenge;

import java.util.List;

public interface Challenge<I> {

    Class<? extends I> getInputFormat();

    List<I> getInputs();

    Object doIt(I input);

    void challenge(I input);

}

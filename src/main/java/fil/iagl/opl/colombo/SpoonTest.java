package fil.iagl.opl.colombo;

import fil.iagl.opl.colombo.challenge.Challenge;
import fil.iagl.opl.colombo.challenge.RacistChallenge;

public class SpoonTest {

    public static void main(String[] args) {
        new DDebuggerImpl().debug((Challenge) new RacistChallenge());
    }

}

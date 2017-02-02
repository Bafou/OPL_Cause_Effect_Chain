package fil.iagl.opl.colombo;

import fil.iagl.opl.colombo.challenge.CauseEffectChain;
import fil.iagl.opl.colombo.challenge.Challenge;
import fil.iagl.opl.colombo.challenge.ChallengeProcessor;
import spoon.Launcher;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class DDebuggerImpl implements DDebugger<Object> {

    @Override
    public CauseEffectChain debug(Challenge<Object> c) {
        final Launcher launcher = new Launcher();
        // TODO change this (get the absolute path of a Java class)
        launcher.addInputResource("/Users/salla/workspace/colombo/src/main/java/fil/iagl/opl/colombo/challenge/TotoChallenge.java");
        final List<Object> inputs = Arrays.asList(Color.WHITE, Color.BLACK, Color.BLUE);
        launcher.addProcessor(new ChallengeProcessor(inputs));
        launcher.run();
        return null;
    }

}

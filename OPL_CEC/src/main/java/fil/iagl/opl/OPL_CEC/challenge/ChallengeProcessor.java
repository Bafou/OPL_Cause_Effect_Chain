package fil.iagl.opl.colombo.challenge;

import bsh.EvalError;
import fil.iagl.opl.colombo.BshEvaluator;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.declaration.CtClass;

import java.util.List;

public class ChallengeProcessor extends AbstractProcessor<CtClass<Challenge<?>>> {

    private List<Object> inputs;

    public ChallengeProcessor(List<Object> inputs) {
        this.inputs = inputs;
    }

    @Override
    public boolean isToBeProcessed(CtClass<Challenge<?>> candidate) {
        return candidate.getSuperInterfaces().stream().anyMatch(ctTypeReference -> ctTypeReference.getActualClass().equals(Challenge.class));
    }

    @Override
    public void process(CtClass<Challenge<?>> challengeCtClass) {
        final CtBlock<?> challengeMethodBody = challengeCtClass.getMethodsByName("challenge").get(0).getBody();
        final BshEvaluator bshEvaluator;
        try {
            bshEvaluator = new BshEvaluator();
            bshEvaluator.evaluateBlockWithAllInputs(inputs, challengeMethodBody);
        } catch (EvalError evalError) {
            evalError.printStackTrace();
        }
    }


}

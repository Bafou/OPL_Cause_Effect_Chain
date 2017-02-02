package fil.iagl.opl.colombo.challenge;

import bsh.EvalError;
import fil.iagl.opl.colombo.BshEvaluator;
import fil.iagl.opl.colombo.handler.BlockHandler2;
import spoon.processing.AbstractProcessor;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtStatement;
import spoon.reflect.declaration.CtClass;

import java.util.LinkedList;
import java.util.List;

public class ChallengeProcessor extends AbstractProcessor<CtClass<Challenge<?>>> {

    private List<Object> inputs;
    private Class<?> inputFormat;

    public ChallengeProcessor(List<Object> inputs, Class<?> inputFormat) {
        this.inputs = inputs;
        this.inputFormat = inputFormat;
    }

    @Override
    public boolean isToBeProcessed(CtClass<Challenge<?>> candidate) {
        return candidate.getSuperInterfaces().stream().anyMatch(ctTypeReference -> ctTypeReference.getActualClass().equals(Challenge.class));
    }

    @Override
    public void process(CtClass<Challenge<?>> challengeCtClass) {
        final CtBlock<?> challengeMethodBody = challengeCtClass.getMethodsByName("challenge").get(0).getBody();
        try {
            final BshEvaluator bshEvaluator = new BshEvaluator();
            final BlockHandler2 blockHandler = new BlockHandler2();
            final List<CtStatement> newStatements = new LinkedList<CtStatement>();

            final List<String> traces = new LinkedList<String>();

            for (Object input : inputs) {
                try {
                    bshEvaluator.setInput(input);
                    // TODO can be better with polymorphism and chain of responsibility pattern, but life...
                    for (final CtStatement statement : challengeMethodBody.getStatements()) {
                        newStatements.addAll(blockHandler.handleStatement(statement, getFactory(), bshEvaluator.getTraceName()));
                    }
                    bshEvaluator.evaluateStatements(newStatements);
                } catch (EvalError evalError) {
                    evalError.printStackTrace();
                }
            }


        } catch (EvalError e) {

        }
    }

}

package fil.iagl.opl.colombo;

import bsh.EvalError;
import bsh.Interpreter;
import spoon.reflect.code.CtBlock;

import java.util.List;

public class BshEvaluator {

    private Interpreter interpreter;

    public BshEvaluator() throws EvalError {
        interpreter = new Interpreter();

        interpreter.eval("import java.lang.*;");
        interpreter.eval("import java.util.*;");
        interpreter.eval("import java.awt.*;");
        interpreter.eval("import java.beans.*;");
        interpreter.eval("import java.io.*;");
        interpreter.eval("import java.net.*;");
        interpreter.eval("import java.rmi.*;");
        interpreter.eval("import java.security.*;");
        interpreter.eval("import java.text.*;");

        interpreter.eval("import fil.iagl.opl.colombo.challenge;");

        interpreter.eval("assert(boolean condition) { " + "if (!condition) " + "throw new Exception();" + "}");
    }

    public void evaluateBlockWithAllInputs(List<Object> inputs, CtBlock<?> block) {
        inputs.forEach(input -> {
            try {
                evaluateBlockWithOneInput(input, block);
            } catch (EvalError evalError) {
                evalError.printStackTrace();
            }
        });
    }

    private void evaluateBlockWithOneInput(Object input, CtBlock<?> block) throws EvalError {
        interpreter.set("input", input);
        block.getStatements().forEach(ctStatement -> {
            try {
                interpreter.eval(ctStatement.toString());
            } catch (EvalError evalError) {
                evalError.printStackTrace();
            }
        });
    }

}

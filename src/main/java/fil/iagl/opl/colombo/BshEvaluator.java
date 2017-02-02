package fil.iagl.opl.colombo;

import bsh.EvalError;
import bsh.Interpreter;
import fil.iagl.opl.colombo.challenge.ChainElement;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtStatement;

import java.util.LinkedList;
import java.util.List;

public class BshEvaluator {

    private Interpreter interpreter;
    private String traceName;

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

        interpreter.eval("import *;");

        interpreter.eval("assert(boolean condition) { " + "if (!condition) " + "throw new Exception();" + "}");

        traceName = "AAAAAAAAAAAA";
        interpreter.set(traceName, new LinkedList<ChainElement>());
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

    public void evaluateStatements(List<CtStatement> statements) {
        statements.forEach(statement -> {
            try {
                interpreter.eval(statement.toString());
            } catch (EvalError evalError) {
                evalError.printStackTrace();
            }
        });
    }

    public void setInput(Object input) throws EvalError {
        interpreter.set("input", input);
    }

    private void evaluateBlockWithOneInput(Object input, CtBlock<?> block) throws EvalError {
        block.getStatements().forEach(ctStatement -> {
            try {
                interpreter.eval(ctStatement.toString());
            } catch (EvalError evalError) {
                evalError.printStackTrace();
            }
        });
    }

    public String getTraceName() {
        return traceName;
    }

    public List<ChainElement> getTraceValue() throws EvalError {
        return (List<ChainElement>) interpreter.get(traceName);
    }
}

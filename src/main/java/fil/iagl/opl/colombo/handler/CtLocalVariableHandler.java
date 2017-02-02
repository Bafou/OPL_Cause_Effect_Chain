package fil.iagl.opl.colombo.handler;

import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;

public class CtLocalVariableHandler implements StatementHandler {

    @Override
    public boolean accept(CtStatement statement) {
        return statement instanceof CtLocalVariable;
    }

    @Override
    public String execute(CtStatement statement, String traceVariableName) {
    	final CtLocalVariable ctLocalVariable = (CtLocalVariable) statement;
        final String variableName = ctLocalVariable.getSimpleName();
    	final Object variableValue = ctLocalVariable.getAssignment().toString();
    	final int variableLine = ctLocalVariable.getPosition().getLine();
    	return traceVariableName + ".add(new ChainElement(" + variableLine + ", " + variableName + ", " + variableValue + "));";
    }
}

package fil.iagl.opl.colombo.handler;

import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;

public class CtAssignmentHandler implements StatementHandler {

	@Override
	public boolean accept(CtStatement statement) {
		return statement instanceof CtAssignment;
	}

	@Override
	public String execute(CtStatement statement, String traceVariableName) {
		CtAssignment ctLocalVariable = (CtAssignment) statement;
    	String variableValue = ctLocalVariable.getAssignment().toString();
    	int variableLine = ctLocalVariable.getPosition().getLine();
    	return traceVariableName + ".add(new ChainElement(" + variableLine + ", " + variableValue + ", " + "\"\"" + "));";
	}
	
}

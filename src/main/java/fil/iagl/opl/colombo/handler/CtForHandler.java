package fil.iagl.opl.colombo.handler;

import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;

public class CtForHandler implements StatementHandler{

	@Override
	public boolean accept(CtStatement statement) {
		return statement instanceof CtFor;
	}

	@Override
	public String execute(CtStatement statement, String traceVariableName) {
    	final CtFor ctLocalVariable = (CtFor) statement;
    	final CtStatement ctStatement = ctLocalVariable.getBody();
		return null;
	}

}

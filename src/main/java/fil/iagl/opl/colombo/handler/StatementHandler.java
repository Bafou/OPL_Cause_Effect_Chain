package fil.iagl.opl.colombo.handler;

import spoon.reflect.code.CtStatement;

public interface StatementHandler {

    boolean accept(CtStatement statement);

    String execute(CtStatement statement, String traceVariableName);

}

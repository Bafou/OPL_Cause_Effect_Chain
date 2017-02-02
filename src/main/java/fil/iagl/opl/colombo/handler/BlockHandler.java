package fil.iagl.opl.colombo.handler;

import spoon.reflect.code.CtBlock;

import java.util.LinkedList;
import java.util.List;

public class BlockHandler {

    private List<StatementHandler> statementHandlers;

    public BlockHandler() {
        statementHandlers = new LinkedList<StatementHandler>();
    }

    public void addStatementHandler(StatementHandler statementHandler) {
        statementHandlers.add(statementHandler);
    }

    public List<String> handle(CtBlock<?> block, String traceVariableName) {
        final List<String> codeLinesToAdd = new LinkedList<String>();
        block.getStatements().forEach(statement -> {
            for (StatementHandler statementHandler: statementHandlers) {
                if (statementHandler.accept(statement))
                    codeLinesToAdd.add(statementHandler.execute(statement, traceVariableName));
            }
        });
        return codeLinesToAdd;
    }

}

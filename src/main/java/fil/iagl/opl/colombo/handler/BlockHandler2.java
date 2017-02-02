package fil.iagl.opl.colombo.handler;

import spoon.reflect.code.CtAssert;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtStatement;
import spoon.reflect.factory.Factory;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BlockHandler2 {

    public List<CtStatement> handleStatement(CtStatement statement, Factory factory, String traceVariableName) {
        final List<CtStatement> statementsToAdd = new LinkedList<CtStatement>();
        final CtStatement clone = statement.clone();
        clone.setParent(statement.getParent().clone());
        if (clone instanceof CtLocalVariable) {
            statementsToAdd.addAll(localVariableHandler((CtLocalVariable) clone, factory, traceVariableName));
        } else if (clone instanceof CtAssignment){
            statementsToAdd.addAll(assignmentHandler((CtAssignment) clone, factory, traceVariableName));
        } else if (clone instanceof CtAssert) {
            statementsToAdd.addAll(assertHandler((CtAssert) clone, factory));
        }
        return statementsToAdd;
    }

    private List<CtStatement> localVariableHandler(CtLocalVariable statement, Factory factory, String traceVariableName) {
        final String variableName = statement.getSimpleName();
        final Object variableValue = statement.getAssignment().toString();
        final int variableLine = statement.getPosition().getLine();
        final String newStatementValue = traceVariableName + ".add(new ChainElement(" + variableLine + ", \"" + variableName + "\", " + variableValue + "));";
        final CtStatement newStatement = factory.Core().createCodeSnippetStatement().setValue(newStatementValue);
        return Arrays.asList(statement, newStatement);
    }

    private List<CtStatement> assignmentHandler(CtAssignment statement, Factory factory, String traceVariableName) {
        final CtAssignment assignment = (CtAssignment) statement;
        final int variableLine = assignment.getPosition().getLine();
        final String variableName = assignment.getAssigned().toString();
        final Object variableValue = assignment.getAssignment().toString();
        final String newStatementValue = traceVariableName + ".add(new ChainElement(" + variableLine + ", \"" + variableName + "\", " + variableValue + "));";
        final CtStatement newStatement = factory.Core().createCodeSnippetStatement().setValue(newStatementValue);
        return Arrays.asList(statement, newStatement);
    }

    private List<CtStatement> assertHandler(CtAssert statement, Factory factory) {
        final CtStatement assertStatement = factory.Core().createCodeSnippetStatement().setValue("assert(" + statement.getAssertExpression().toString() + ");");
        return Collections.singletonList(assertStatement);
    }

}

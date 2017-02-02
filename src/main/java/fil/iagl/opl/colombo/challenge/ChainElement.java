package fil.iagl.opl.colombo.challenge;

public class ChainElement {

    private int line;
    private String variableName;
    private Object variableValue;

    public ChainElement(int line, String variableName, Object variableValue) {
        this.line = line;
        this.variableName = variableName;
        this.variableValue = variableValue;
    }

    public int getLine() {
        return line;
    }

    public Object getVariableValue() {
        return variableValue;
    }

    public String getVariableName() {
        return variableName;
    }

}

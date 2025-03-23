package org.lld.prep.design_patterns.command_pattern;

public class TextAddCommand implements Command{
    StringBuilder str;
    String temp;

    public TextAddCommand(StringBuilder str, String temp) {
        this.str = str;
        this.temp = temp;
    }

    @Override
    public void execute() {
        str.append(temp);
    }

    @Override
    public void undo() {
        str.delete(str.length()-temp.length(), str.length());
    }

    @Override
    public void getText() {
        System.out.println("Current String: "+str);
    }
}

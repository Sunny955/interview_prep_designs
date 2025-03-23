package org.lld.prep.design_patterns.command_pattern;

public class TextDeleteCommand implements Command{
    StringBuilder str;
    String temp;
    int len;
    int startIndx;

    public TextDeleteCommand(StringBuilder str, int startIndx, int len) {
        this.str = str;
        this.startIndx = startIndx;
        this.len = len;
        temp = str.substring(startIndx, startIndx + len);
    }

    @Override
    public void execute() {
        str.delete(startIndx, startIndx + len);
    }

    @Override
    public void undo() {
        str.insert(startIndx, temp);
    }

    @Override
    public void getText() {
        System.out.println("Current String: "+str);
    }
}

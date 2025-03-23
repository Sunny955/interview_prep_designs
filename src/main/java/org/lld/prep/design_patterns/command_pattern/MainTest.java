package org.lld.prep.design_patterns.command_pattern;

public class MainTest {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("....");
        Command textAdd = new TextAddCommand(str, "Dalli");
        Command textAdd1 = new TextAddCommand(str, " Gym Jaun");
        Command textRemove = new TextDeleteCommand(str,0, 2);

        Remote r = new Remote();

        r.executeCommand(textAdd);
        r.executeCommand(textAdd1);
        r.undo();
        r.redo();

        r.executeCommand(textRemove);
        r.undo();
        r.redo();
    }
}

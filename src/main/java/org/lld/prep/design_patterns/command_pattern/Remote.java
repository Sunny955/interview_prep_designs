package org.lld.prep.design_patterns.command_pattern;

import java.util.Stack;

public class Remote {
    private Command cmd;
    private Stack<Command> undo = new Stack<>();
    private Stack<Command> redo = new Stack<>();

    public void executeCommand(Command cmd) {
        cmd.execute();
        undo.push(cmd);
        redo.clear();
        cmd.getText();
    }

    public void undo() {
        if(!undo.isEmpty()) {
            Command top = undo.pop();
            top.undo();
            top.getText();
            redo.push(top);
        }
    }

    public void redo() {
        if(!redo.isEmpty()) {
            Command top = redo.pop();
            top.execute();
            top.getText();
            undo.push(top);
        }
    }
}

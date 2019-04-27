package com.logdyn.ui;

import com.logdyn.CommandDelegator;
import com.logdyn.UndoableExecutor;
import com.logdyn.core.command.NewFileCommand;
import org.springframework.stereotype.Component;

@Component
public class EditorDockController {
    public EditorDockController(CommandDelegator commandDelegator) {
        commandDelegator.subscribe(new NewFileExecutor(), NewFileCommand.class);
    }
}

class NewFileExecutor implements UndoableExecutor<NewFileCommand> {

    @Override
    public void unexecute(final NewFileCommand command) throws Exception {
        System.out.println("Undo New File");
    }

    @Override
    public void execute(final NewFileCommand command) throws Exception {
        System.out.println("Do New File");
    }
}

package com.logdyn.core.command;

import com.logdyn.UndoableCommand;
import org.springframework.stereotype.Service;

@Service
public class NewFileCommand implements UndoableCommand {
    @Override
    public String getName() {
        return "New File";
    }
}

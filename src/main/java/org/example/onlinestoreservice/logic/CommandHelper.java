package org.example.onlinestoreservice.logic;

import org.example.onlinestoreservice.logic.impl.AdminLoggingCommand;
import org.example.onlinestoreservice.logic.impl.LoggingCommand;
import org.example.onlinestoreservice.logic.impl.NoSuchCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandHelper {
    private static final CommandHelper instance = new CommandHelper();
    private Map<CommandName, ICommand> commands = new HashMap<>();
    public CommandHelper() {
        commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
        commands.put(CommandName.LOGGING_COMMAND, new LoggingCommand());
        commands.put(CommandName.ADMIN_LOGGING_COMMAND, new AdminLoggingCommand());
    }
    public static CommandHelper getInstance() {
        return instance;
    }
    public ICommand getCommand(String commandName){
        CommandName name = CommandName.valueOf(commandName.toUpperCase());
        ICommand command;
        if (null != name){
            command = commands.get(name);
        } else{
            command = commands.get(CommandName.NO_SUCH_COMMAND);
        }
        return command;
    }
}

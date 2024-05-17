package com.pattern;

import com.command.ConfigCommand;
import com.command.GeneratorCommand;
import com.command.ListCommand;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.util.concurrent.Callable;

@Command(name = "si", mixinStandardHelpOptions = true, version = "generator 1.0",
        description = "XXX.")
public class CommandExecutor implements Runnable {
    CommandLine commandLine;
    {
        commandLine = new CommandLine(this)
                .addSubcommand(new ConfigCommand())
                .addSubcommand(new GeneratorCommand())
                .addSubcommand(new ListCommand());
    }

    public int doExecute(String[] args){
        return commandLine.execute(args);
    }

    @Override
    public void run() {
        System.out.println("请输入具体子命令，或者输入 --help 查看命令提示信息");
    }
}

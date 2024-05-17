package com.command;

import picocli.CommandLine.Command;

import java.lang.reflect.Field;
import java.util.concurrent.Callable;

@Command(name = "config",mixinStandardHelpOptions = true,description = "打印配置参数信息")
public class ConfigCommand implements Runnable {

    @Override
    public void run() {
        Field[] fields = GeneratorCommand.class.getDeclaredFields();
        for (Field field:fields) {
            System.out.println("类型："+field.getType()+"\t名称："+field.getName());
        }
    }
}

package com.command;

import com.generator.MainGenerator;
import com.model.MainTemplateConfig;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(name = "generator",mixinStandardHelpOptions=true,description = "generate template files")
public class GeneratorCommand implements Callable {
    /**
     * 作者（填充值）
     */
    @Option(names = {"-a","--author"},arity = "0..1",interactive = true,echo = true,defaultValue = "请输入作者",description = "代码作者")
    private String author;
    /**
     * 输出信息
     */
    @Option(names = {"-o","--outputText"},arity = "0..1",interactive = true,echo = true,defaultValue = "请输入输出内容",description = "输出描述内容")
    private String outputText;
    /**
     * 是否循环（开关值）
     */
    @Option(names = {"-l","--loop"},arity = "0..1",interactive = true,echo = true,defaultValue = "true",description = "是否开启循环")
    private boolean loop;
    @Override
    public Object call() throws Exception {
        MainTemplateConfig mainTemplateConfig = new MainTemplateConfig(author,outputText,loop);
        MainGenerator.doGenerator(mainTemplateConfig);
        return 0;
    }
}

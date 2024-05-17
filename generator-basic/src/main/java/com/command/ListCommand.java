package com.command;

import cn.hutool.core.io.FileUtil;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;

@Command(name = "list",mixinStandardHelpOptions = true)
public class ListCommand implements Callable {
    @Override
    public Object call() throws Exception {
        String projectPath = System.getProperty("user.dir");
        File root = new File(projectPath).getParentFile();
        String templateDir = root.getPath()+File.separator+"acm-template";
        List<File> files = FileUtil.loopFiles(templateDir);
        for (File file:files) {
            System.out.println(file);
        }
        return 0;
    }
}

package com.generator;

import com.model.MainTemplateConfig;

import java.io.File;

public class MainGenerator {
    public static void doGenerator(Object dataConfig)throws Exception{
        String projectPath = System.getProperty("user.dir");
        File root = new File(projectPath).getParentFile();
        String inputPath = root.getPath() + File.separator + "demo-project" + File.separator + "acm-template";
        String outputPath = root.getPath();
        StaticGenerator.copyFiles(new File(inputPath),new File(outputPath));

        String DyanmicInputPath = projectPath + "/src/main/resources/templates";
        String DyanmicOutputPath = outputPath + File.separator + "acm-template/src/com/acm/MainTemplate.java";

        DynamicGenerator.doGenerator(DyanmicInputPath,DyanmicOutputPath,dataConfig);
    }
}

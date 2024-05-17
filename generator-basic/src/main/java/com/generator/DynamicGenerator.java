package com.generator;

import com.model.MainTemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class DynamicGenerator {
    public static void doGenerator(String inputPath,String outputPath,Object dateModel) throws Exception {
        /* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        // 设置模版加载目录
        cfg.setDirectoryForTemplateLoading(new File(inputPath));
        // 设置编码模式
        cfg.setDefaultEncoding("UTF-8");

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("MainTemplate.java.ftl");

        /* Merge data-model with template */
        // 输出到系统打印
        Writer out = new FileWriter(new File(outputPath));
        temp.process(dateModel, out);
    }
}

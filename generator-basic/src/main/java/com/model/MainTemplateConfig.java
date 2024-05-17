package com.model;

import lombok.Data;

/**
 * 动态模版配置
 */
@Data
public class MainTemplateConfig {
    /**
     * 作者（填充值）
     */
    private String author;
    /**
     * 输出信息
     */
    private String outputText;
    /**
     * 是否循环（开关值）
     */
    private boolean loop;

    public MainTemplateConfig(){
        // 默认值
        author = "请输入作者";
        outputText = "请输入输出内容";
        loop = true;
    }

    public MainTemplateConfig(String author, String outputText, boolean loop) {
        this.author = author;
        this.outputText = outputText;
        this.loop = loop;
    }
}

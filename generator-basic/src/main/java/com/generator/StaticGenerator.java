package com.generator;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IORuntimeException;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ArrayUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;

/**
 * 静态文件生成器
 */
public class StaticGenerator {

    /**
     * 复制文件（Hutool实现,不覆盖目标路径文件）
     * @param inputPath 输入路径
     * @param outputPath 输出路径
     */
    static public void copyFilesByHutool(String inputPath,String outputPath){
        FileUtil.copy(inputPath,outputPath,false);
    }

    /**
     * 递归拷贝文件
     * @param src 源文件
     * @param dest 目标文件
     * @throws IORuntimeException
     * @throws IOException
     */
    static public void copyFiles(File src,File dest) throws IORuntimeException, IOException {
        // check
        Assert.notNull(src, "Source File is null !");
        if (!src.exists()) {
            throw new IORuntimeException("File not exist: " + src);
        }
        Assert.notNull(dest, "Destination File or directiory is null !");
        if (FileUtil.equals(src, dest)) {
            throw new IORuntimeException("Files '{}' and '{}' are equal", src, dest);
        }

        if (src.isDirectory()) {// 复制目录
            if(dest.exists() && !dest.isDirectory()) {
                //源为目录，目标为文件，抛出IO异常
                throw new IORuntimeException("Src is a directory but dest is a file!");
            }
            if(FileUtil.isSub(src, dest)) {
                throw new IORuntimeException("Dest is a sub directory of src !");
            }
            File[] files = src.listFiles();

            if(ArrayUtil.isEmpty(files)){
                return;
            }
            File destOutputFile = new File(dest,src.getName());
            if(!destOutputFile.exists()){
                destOutputFile.mkdirs();
            }
            for(File file : files){
                copyFiles(file,destOutputFile);
            }
        } else {// 复制文件
            Path destPath = dest.toPath().resolve(src.getName());
            Files.copy(src.toPath(),destPath,StandardCopyOption.REPLACE_EXISTING);
        }
    }
}

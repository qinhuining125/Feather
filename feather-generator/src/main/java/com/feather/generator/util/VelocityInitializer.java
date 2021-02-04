package com.feather.generator.util;

import java.util.Properties;

import org.apache.velocity.app.Velocity;

import com.feather.common.constant.FeatherConstants;

/**
 * VelocityEngine工厂
 * 
 * @author Feather
 */
public class VelocityInitializer {
    /**
     * 初始化vm方法
     */
    public static void initVelocity() {
        Properties p = new Properties();
        try {
            // 加载classpath目录下的vm文件
            p.setProperty("file.resource.loader.class",
                    "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
            // 定义字符集
            p.setProperty(Velocity.ENCODING_DEFAULT, FeatherConstants.UTF8);
            p.setProperty(Velocity.OUTPUT_ENCODING, FeatherConstants.UTF8);
            // 初始化Velocity引擎，指定配置Properties
            Velocity.init(p);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

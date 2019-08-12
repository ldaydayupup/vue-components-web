package com.news.utill;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * ���������ļ�
 * @author yin
 *
 */
public class ConfigManager {
    private static Properties props = null;

    static {
        InputStream is = null;
        is = ConfigManager.class.getClassLoader().getResourceAsStream(
                "database.properties");
        if (is == null)
            throw new RuntimeException("�Ҳ������ݿ���������ļ���");
        props = new Properties();
        try {
            props.load(is);
        } catch (IOException e) {
            throw new RuntimeException("���ݿ����ò������ش���", e);
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}

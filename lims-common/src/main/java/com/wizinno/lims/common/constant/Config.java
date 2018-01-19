package com.wizinno.lims.common.constant;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author LiuMei
 */
public class Config {

    protected static final Log logger = LogFactory.getLog(Config.class);
    protected static final Properties P = new Properties();

    private Config(){

    }

    /**
     * 静态读入属性文件到Properties p变量中
     */
    protected static void init(String propertyFileName) {
        InputStream in = null;
        try {
            in = Config.class.getClassLoader().getResourceAsStream(propertyFileName);
            if (in != null) {
                P.load(in);
            }
        } catch (IOException e) {
            logger.error("load " + propertyFileName + " into Constants error!");
        }
        finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error("close " + propertyFileName + " error!");
                }
            }
        }
    }

    /**
     * 封装了Properties类的getProperty函数,使p变量对子类透明.
     *
     * @param key          property key.
     * @param defaultValue 当使用property key在properties中取不到值时的默认值.
     */
    protected static String getProperty(String key, String defaultValue) {
        return P.getProperty(key, defaultValue);
    }

    static {
        init("config.properties");
    }

    public final static String AFFIX_PATH = getProperty("affix.path", "/sampleLot/");

}

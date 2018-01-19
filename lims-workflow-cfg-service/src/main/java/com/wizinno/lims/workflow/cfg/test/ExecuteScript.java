package com.wizinno.lims.workflow.cfg.test;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;

/**
 * @author LiuMei on 2017-08-16.
 */
public class ExecuteScript {


    public static void main(String[] args) throws NoSuchMethodException, ScriptException, IOException {
        javascript();
        javascriptBind();
    }

    public static void javascript() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");
        try {
            engine.eval("var a=3; var b=4;print (a+b);");
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public static void javascriptBind() {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        engine.put("a", 4);
        engine.put("b", 3);
        try {
            // 只能为Double，使用Float和Integer会抛出异常
            Double result = (Double) engine.eval("a+b");
            System.out.println("result = " + result);
            engine.eval("c=a+b");
            Double c = (Double) engine.get("c");
            System.out.println("c = " + c);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }
}

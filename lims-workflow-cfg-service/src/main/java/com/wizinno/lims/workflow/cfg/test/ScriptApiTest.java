package com.wizinno.lims.workflow.cfg.test;

import com.google.gson.Gson;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.File;

/**
 * @author LiuMei on 2017-08-18.
 */
public class ScriptApiTest {

    private static Gson gson = new Gson();

    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        //演示如何暴露Java对象为脚本语言的全局变量
        testScriptVariables(engine);
        //演示如何在Java中调用脚本语言的方法
        testInvokeScriptMethod(engine);
        //演示脚本语言如何实现Java的接口
        testScriptInterface(engine);
        //演示脚本语言如何使用JDK平台下的类
        testUsingJDKClasses(engine);
    }

    public static void testScriptVariables(ScriptEngine engine) throws ScriptException {
        File file = new File("test.txt");
        engine.put("f", file);
        engine.eval("print('Total Space:'+f.getTotalSpace())");
    }

    public static void testInvokeScriptMethod(ScriptEngine engine) throws Exception{
        String script = "function hello(item) { \n" +
                "if(item.id == 1){\n" +
                "item.id =2;\n" +
                "}\n" +
                "return item;\n" +
                "}";
        engine.eval(script);
        Invocable inv = (Invocable) engine;
//        SchemeQubit schemeQubit = new SchemeQubit();
//        schemeQubit.setId(1L);
//        schemeQubit.setKit("测试");
//        SchemeQubit res = (SchemeQubit) inv.invokeFunction("hello", schemeQubit );
//        System.out.print("res:"+ gson.toJson(res));
    }

    public static void testScriptInterface(ScriptEngine engine) throws ScriptException{
        String script = "var obj = new Object(); obj.run = function() { print('run method called'); }";
        engine.eval(script);
        Object obj = engine.get("obj");
        Invocable inv = (Invocable) engine;
        Runnable r = inv.getInterface(obj,Runnable.class);
        Thread th = new Thread(r);
        th.start();
    }

    public static void testUsingJDKClasses(ScriptEngine engine) throws Exception{
        //Packages是脚本语言里的一个全局变量,专用于访问JDK的package
        String js = "function doSwing(t){var f=new Packages.javax.swing.JFrame(t);f.setSize(400,300);f.setVisible(true);}";
        engine.eval(js);
        Invocable inv = (Invocable) engine;
        inv.invokeFunction("doSwing", "Scripting Swing" );
    }
}

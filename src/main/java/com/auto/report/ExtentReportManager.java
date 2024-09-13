package com.auto.report;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentReportManager {


    public static ExtentTest test;
    private static Map<String, ExtentReports> reportMap = new HashMap<>();

    private ExtentReportManager(){}



    public synchronized static final ExtentReports initReporter(String name, String env, String app, String browser){
        String key = String.format("%s_%s_%s_%s",name, env, app, browser);

        ExtentReports er = reportMap.get(key);
        if(er == null){
            er = new ExtentReports(System.getProperty("user.dir") + "/test-output/"+key+".html", true);
            er.addSystemInfo("Host Name", "ElementalSelenium")
                    .addSystemInfo("Environment", env)
//                    .addSystemInfo("Test", testType)
                    .addSystemInfo("Application", app)
                    .addSystemInfo("Browser", browser);
            reportMap.put(key,er);
        }

        return er;
    }
}

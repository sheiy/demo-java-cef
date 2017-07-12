package com.comup.demo.cef;/*
 * 文 件 名 : com.comup.demo.cef.Main
 * 版    权 : CZYSOFT TECHNOLOGY CO.,LTD.Copyright 2017-2030.All rights reserved
 * 描    述 : <描述>
 * 修 改 人 : <工号>xu.yang22@zte.com.cn
 * 修改时间 : 2017-07-12 17:29
 * 需求单号 : <需求Redmine单号>
 * 变更单号 : <变更Redmine单号>
 * 修改内容 : <修改内容>
 * Version : V1.0
 */

import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.CefSettings;
import org.cef.OS;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefBrowserFactory;
import org.cef.browser.CefRequestContext;
import org.cef.callback.CefCommandLine;
import org.cef.handler.CefAppHandlerAdapter;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.URL;

/**
 * <一句话功能简介><br>
 *
 * @author [004293]004293@ch.com
 * @version [版本号, 2017-07-12]
 * @Description: //TODO <功能详细描述>
 * @ClassName:Main
 * @see [相关类/方法]
 * @since [产品/模块]
 */
public class Main {
    public static void main(String[] args) {
        final Frame frame = new Frame();
        frame.setSize(800, 600);
        CefSettings settings = new CefSettings();
        settings.windowless_rendering_enabled= OS.isLinux();
        settings.background_color = settings.new ColorType(100, 255, 242, 211);
        settings.locale = "zh-CN";
        CefApp cefApp = CefApp.getInstance(args, settings);
        CefApp.addAppHandler(new CefAppHandlerAdapter(args) {
            @Override
            public void onBeforeCommandLineProcessing(String process_type, CefCommandLine command_line) {
                super.onBeforeCommandLineProcessing(process_type, command_line);
                //启动flash支持需要系统安装flash
                command_line.appendSwitch("--enable-system-flash");
            }
        });
        CefClient cefClient = cefApp.createClient();
        CefBrowser browser = cefClient.createBrowser("http://www.baidu.com/", OS.isLinux(), false);
        Component uiComponent = browser.getUIComponent();
        frame.add(uiComponent);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                CefApp.getInstance().dispose();
                frame.dispose();
            }
        });
        frame.setVisible(true);
    }
}

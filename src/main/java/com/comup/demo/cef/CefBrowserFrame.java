package com.comup.demo.cef;

import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.CefSettings;
import org.cef.browser.CefBrowser;
import org.cef.callback.CefCommandLine;
import org.cef.callback.CefContextMenuParams;
import org.cef.callback.CefMenuModel;
import org.cef.handler.CefAppHandlerAdapter;
import org.cef.handler.CefContextMenuHandlerAdapter;
import org.cef.handler.CefLifeSpanHandlerAdapter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Comup on 2017/7/12.
 * Cef浏览器Frame
 */
public class CefBrowserFrame extends JFrame {
    private final JTextField address;
    private final CefApp cefApp;
    private final CefClient cefClient;
    private final CefBrowser browser;
    private final Component browerUI;

    public CefBrowserFrame(String[] args, String initString, boolean useOsr, boolean isTransparent) throws HeadlessException {
        CefSettings settings = new CefSettings();
        settings.windowless_rendering_enabled = useOsr;
        settings.background_color = settings.new ColorType(100, 255, 242, 211);
        settings.locale = "zh-CN";

        cefApp = CefApp.getInstance(args, settings);
        CefApp.addAppHandler(new CefAppHandlerAdapter(args) {
            @Override
            public void stateHasChanged(CefApp.CefAppState state) {
                if (state == CefApp.CefAppState.TERMINATED) {
                    System.exit(0);
                }
            }

            @Override
            public void onBeforeCommandLineProcessing(String process_type, CefCommandLine command_line) {
                super.onBeforeCommandLineProcessing(process_type, command_line);
                //启动flash支持需要系统安装flash
                command_line.appendSwitch("--enable-system-flash");
            }
        });

        cefClient = cefApp.createClient();
        cefClient.addContextMenuHandler(new CefContextMenuHandlerAdapter() {
            //清理右键菜单
            @Override
            public void onBeforeContextMenu(CefBrowser browser, CefContextMenuParams params, CefMenuModel model) {
                model.clear();
                //model.addItem(1, "开发者选项");
            }

            @Override
            public boolean onContextMenuCommand(CefBrowser browser, CefContextMenuParams params, int commandId, int eventFlags) {
//                switch (commandId) {
//                    case 1:
//                        Component debuggerComponent = browser.getDevTools().getUIComponent();
//                        Frame debuggerFrame = new Frame();
//                        debuggerFrame.add(debuggerComponent);
//                        debuggerFrame.setSize(800, 600);
//                        debuggerFrame.setVisible(true);
//                        return true;
//                    default:
//                        return false;
//                }
                return false;
            }
        });

        cefClient.addLifeSpanHandler(new CefLifeSpanHandlerAdapter() {
            @Override
            public boolean onBeforePopup(CefBrowser browser, String target_url, String target_frame_name) {
                //控制windows.open行为 true不打开新窗口，false会在新窗口打开
                if (target_url != null && (!"".equals(target_url))) {
                    browser.loadURL(target_url);
                }
                return true;
            }
        });

        browser = cefClient.createBrowser(initString, useOsr, isTransparent);
        address = new JTextField(initString, 100);
        address.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                browser.loadURL(address.getText());
            }
        });
        browerUI = browser.getUIComponent();

        add(address, BorderLayout.NORTH);
        add(browerUI, BorderLayout.CENTER);
        pack();
        setSize(800, 600);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                CefApp.getInstance().dispose();
            }
        });
        setLocationRelativeTo(null);
    }
}

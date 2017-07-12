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

import org.cef.OS;

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
        String startURL = "http://www.baidu.com/";
        new CefBrowserFrame(args, startURL, OS.isLinux(), false).setVisible(true);
    }
}

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

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.request.UploadFileRequest;
import com.qcloud.cos.sign.Credentials;
import org.cef.OS;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


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

    private static int APP_ID = 1253953328;
    private static String SECRET_ID = "AKIDoW4QcbT0PcecUBeSAg083pOkurtmIhaI";
    private static String SECRET_KEY = "jGbkhJp8JI4e4ISgvhDkIjy1vd8QXR4l";
    private static String BUCKET_NAME = "test";

    public static void main(String[] args) throws IOException {
//        ClientConfig clientConfig = new ClientConfig();
//        clientConfig.setRegion("cq");
//        Credentials cred = new Credentials(APP_ID, SECRET_ID, SECRET_KEY);
//        COSClient cosClient = new COSClient(clientConfig, cred);
//        File file = new File("f:\\1.xml");
//        FileInputStream fileInputStream = new FileInputStream(file);
//        byte[] bytes = new byte[fileInputStream.available()];
//        fileInputStream.read(bytes,0,fileInputStream.available());
//
//        UploadFileRequest uploadFileRequest = new UploadFileRequest(BUCKET_NAME, "/test.jpg", bytes );
//        uploadFileRequest.setEnableShaDigest(false);
//        String uploadFileRet = cosClient.uploadFile(uploadFileRequest);
//        System.out.println("upload file ret:" + uploadFileRet);
        try{
            String startURL = "http://www.baidu.com/";
            new CefBrowserFrame(args, startURL, OS.isLinux(), false).setVisible(true);
        }catch (Throwable e){
            e.printStackTrace();
        }
    }
}

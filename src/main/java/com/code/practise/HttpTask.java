package com.code.practise;

import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 发送http相关请求
 *
 * @author Summer 2020/10/21 10:39
 */
public class HttpTask implements Runnable{


   public String post(){

       String url = "http://172.29.1.61:8080/oauth/oauth/token?grant_type=password&username=111@wolwo.com&password=qqqqq&scope=all";

       try {
           CloseableHttpClient client = null;
           CloseableHttpResponse response = null;
           try {
               // 创建一个提交数据的容器
               List<BasicNameValuePair> parames = new ArrayList<>();

               parames.add(new BasicNameValuePair("client_id", "user-client"));
               parames.add(new BasicNameValuePair("client_secret", "user-secret-8888"));

               HttpPost httpPost = new HttpPost(url);
               httpPost.setEntity(new UrlEncodedFormEntity(parames, "UTF-8"));


               client = HttpClients.createDefault();
               response = client.execute(httpPost);
               HttpEntity entity = response.getEntity();
               String result = EntityUtils.toString(entity);
               System.out.println(result);
           } finally {
               if (response != null) {
                   response.close();
               }
               if (client != null) {
                   client.close();
               }
           }
       } catch (Exception e) {
           e.printStackTrace();
       }

       return "";
   }

    @Override
    public void run() {
        post();
    }
}

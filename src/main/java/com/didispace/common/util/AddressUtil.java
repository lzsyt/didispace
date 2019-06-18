package com.didispace.common.util;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

import java.io.IOException;

public class AddressUtil {

    /**
     *
     *
     * String str = "{\"age\":\"24\",\"name\":\"cool_summer_moon\"}";
     * JSONObject jsonObject = JSONObject.parseObject(str);
     * System.out.println("json对象是：" + jsonObject);
     * Object object = jsonObject.get("name");
     * System.out.println("name值是："+object)
     *
     *
     *
     */


    public static String getAdress(String ip) {
        if (ip != null && !StringUtils.isEmpty(ip)) {
            if (ip.equals("127.0.0.1")) {
                return "本地";
            } else {
                String url = "http://ip.taobao.com/service/getIpInfo.php";

                String rs = null;

                while (true){
                    try {
                        rs = HttpUtils.sendPost(url, "ip=" + ip);
                        if (!StringUtils.isEmpty(rs)){
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


                JSONObject jsonObject = JSONObject.parseObject(rs);
                JSONObject dataObject = JSONObject.parseObject(String.valueOf(jsonObject.get("data")));;
                if (dataObject!=null){
                    if (dataObject.get("region")==null){
                        return String.valueOf(dataObject.get("country"));

                    }else {
                        return String.valueOf(dataObject.get("region"))+ String.valueOf(dataObject.get("city"));
                    }
                }else{
                    return "";
                }
            }
        }
        return "";

    }
}
package com.didispace.common.util;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressUtil2 {

    private final static Logger logger = LoggerFactory.getLogger(AddressUtil2.class);


    public final static String getAdressByIp(String ip) {
        if (ip != null && !StringUtils.isEmpty(ip)) {
            if (ip.equals("127.0.0.1")) {
                return "本地";
            } else {
                String url = "http://ip.taobao.com/service/getIpInfo.php";
                String rs = null;
                try {
                    rs = HttpUtils.sendPost(url, "ip=" + ip);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!StringUtils.isEmpty(rs)) {
                    JSONObject jsonObject = JSONObject.parseObject(rs);
                    JSONObject dataObject = JSONObject.parseObject(String.valueOf(jsonObject.get("data")));
                    if (dataObject.get("region") == null) {
                        return String.valueOf(dataObject.get("country"));

                    } else {
                        return String.valueOf(dataObject.get("region")) + String.valueOf(dataObject.get("city"));
                    }
                } else {
                    return "";
                }
            }
        }
        return "";
    }
}

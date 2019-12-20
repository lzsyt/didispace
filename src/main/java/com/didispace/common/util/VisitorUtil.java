package com.didispace.common.util;

import com.didispace.domain.Visitor;
import com.didispace.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Component
public class VisitorUtil {

    @Autowired
    private VisitorService visitorService;

    @Async
    public void insertVisitor(HttpServletRequest request, String uri) throws IOException {
        Visitor visitor=new Visitor();
        //访问页面的名称
        visitor.setVisitorPagename(judgePage(uri));
        //访问的url
        visitor.setVisitorPage(uri);
        //访问时间
        visitor.setVisitorTime(new Date());
        //访问的类型
        visitor.setVisitorType(1);
        //访问ip地址
        visitor.setIp(NetworkUtil.getIpAddress(request));
        //访问的真实地址
        visitor.setVisitorAddr(AddressUtil2.getAdressByIp(visitor.getIp()));
        //插入数据库
        visitorService.addVisitor(visitor);
    }

    private String judgePage(String uri) {
        if (uri.contains("windenergy/aboutus")) {
            return "风机手机版本:企业文化";
        } else if (uri.contains("windenergy/contact")) {
            return "风机手机版本:联系我们";
        } else if (uri.contains("windenergy/products")) {
            return "风机手机版本:产品列表";
        } else if (uri.contains("windenergy/technology")) {
            return "风机手机版本:技术支持";
        } else if (uri.contains("windenergy/classicCase")) {
            return "风机手机版本:经典案例";
        } else if (uri.contains("windenergy/map")) {
            return "风机手机版本:地图";
        }else if (uri.contains("windenergy")) {
            return "风机手机版本:主页";
        }else if (uri.contains("/aboutus")) {// 下面是光合硅能
            return "光合硅能手机版本:企业文化";
        } else if (uri.contains("/contact")) {
            return "光合硅能手机版本:联系我们";
        } else if (uri.contains("/products")) {
            return "光合硅能手机版本:产品列表";
        } else if (uri.contains("/technology")) {
            return "光合硅能手机版本:技术支持";
        } else if (uri.contains("/classicCase")) {
            return "光合硅能手机版本:经典案例";
        } else if (uri.contains("map")) {
            return "光合硅能手机版本:地图";
        }else if (uri.contains("/")) {
            return "光合硅能手机版本:主页";
        }else {
            return "";
        }
    }
}

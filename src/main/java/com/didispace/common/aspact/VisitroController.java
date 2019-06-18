package com.didispace.common.aspact;

import com.didispace.common.util.AddressUtil;
import com.didispace.common.util.NetworkUtil;
import com.didispace.domain.Visitor;
import com.didispace.service.VisitorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Aspect
@Component
public class VisitroController {


    @Autowired
    private VisitorService visitorService;



    protected Logger logger = LogManager.getLogger(getClass());

    @Pointcut("execution(* com.didispace.web.Controller.*(..))")
    public void poincut(){}

    @Before("poincut()")
    public void addVisitor() throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String uri=request.getRequestURI();
        String regex = "/static/*";
        if (!uri.matches(regex)) {
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
            visitor.setVisitorAddr(AddressUtil.getAdress(visitor.getIp()));
            //插入数据库
            visitorService.addVisitor(visitor);
        }


    }

    private String judgePage(String uri) {
        if (uri.contains("/aboutus")) {
            return "手机项目(battery.150ah.com)企业文化";
        } else if (uri.contains("/contact")) {
            return "手机项目(battery.150ah.com)联系我们";
        } else if (uri.contains("/products")) {
            return "手机项目(battery.150ah.com)产品列表";
        } else if (uri.contains("/technology")) {
            return "手机项目(battery.150ah.com)技术支持";
        } else if (uri.contains("/classicCase")) {
            return "手机项目(battery.150ah.com)经典案例";
        } else if (uri.contains("map")) {
            return "手机项目(battery.150ah.com)地图";
        }else if (uri.contains("/")) {
            return "手机项目(battery.150ah.com)主页";
        }else {
            return "";
        }
    }

}

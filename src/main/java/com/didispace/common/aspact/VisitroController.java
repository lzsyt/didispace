package com.didispace.common.aspact;

import com.didispace.domain.Visitor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

public class VisitroController {



    protected Logger logger = LogManager.getLogger(getClass());

    @Pointcut("execution(* com.didispace.web.Controller.*(..))")
    public void poincut(){}

    @Before("poincut()")
    public void addVisitor(ProceedingJoinPoint point) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        String uri=request.getRequestURI();
        String regex = "/static/*";
        if (!uri.matches(regex)) {
            Visitor visitor=new Visitor();

            //访问页面的名称
            if (uri.contains("/customer/main")){
                visitor.setVisitorPageName("主页");
            }
            else if (uri.contains("/customer/productDetail")){
                visitor.setVisitorPageName("产品详情页");
                try {
                    String [] arr=uri.split("/customer/productDetail/");
                    String productId=arr[1];
                    visitor.setVisitorProductId(Integer.parseInt(productId));
                }catch (Exception e){
                    e.printStackTrace();

                }
            }
            else if (uri.contains("/customer/aboutUs")){
                visitor.setVisitorPageName("企业文化");

            }
            else if (uri.contains("/customer/search")){
                visitor.setVisitorPageName("搜索");

            }
            else if (uri.contains("/customer/productsCenter")){
                visitor.setVisitorPageName("产品中心");

            }
            else if (uri.contains("/customer/case")){
                visitor.setVisitorPageName("经典案例");

            }
            else if (uri.contains("/customer/solarmain")){
                visitor.setVisitorPageName("太阳能主页");

            }else {
                return ;
            }
            visitor.setVisitorTime(new Date());
            visitor.setVisitorPage(uri);
            HttpSession session= request.getSession();
            if (session.getAttribute("ip")==null||session.getAttribute("address")==null){
                Map<String,String> map=IpAdrressUtil.findRealAddress(request);

                visitor.setIp(map.get("ip"));
                visitor.setVisitorAddr(map.get("address"));
                session.setAttribute("ip",map.get("ip"));
                session.setAttribute("address",map.get("address"));
            }else {
                String ip=String.valueOf(session.getAttribute("ip"));
                String address=String.valueOf(session.getAttribute("address"));
                visitor.setIp(ip);
                visitor.setVisitorAddr(address);
            }
            String requestHeader = request.getHeader("user-agent");
            if(isMobileDevice(requestHeader)){
                //手机
                visitor.setVisitorType(1);
            }else{
                //电脑
                visitor.setVisitorType(2);
            }

            visitorService.insert(visitor);
        }


    }

}

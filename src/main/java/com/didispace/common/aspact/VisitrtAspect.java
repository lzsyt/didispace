package com.didispace.common.aspact;

import com.didispace.common.util.AddressUtil;
import com.didispace.common.util.AddressUtil2;
import com.didispace.common.util.NetworkUtil;
import com.didispace.common.util.VisitorUtil;
import com.didispace.domain.Visitor;
import com.didispace.service.VisitorService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Aspect
@Component
public class VisitrtAspect {


    @Autowired
    private VisitorUtil visitorUtil;



    protected Logger logger = LogManager.getLogger(getClass());

    @Pointcut("execution(* com.didispace.web.*.*(..))")
    public void poincut(){}

    @Before("poincut()")
    public void addVisitor() throws IOException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String uri=request.getRequestURI();
        String regex = "/static/*";
        if (!uri.matches(regex)) {
            visitorUtil.insertVisitor(request, uri);
        }


    }



}

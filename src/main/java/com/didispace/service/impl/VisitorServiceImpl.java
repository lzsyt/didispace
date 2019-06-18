package com.didispace.service.impl;

import com.didispace.domain.Visitor;
import com.didispace.mapper.VisitorMapper;
import com.didispace.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService {

    @Autowired
    private VisitorMapper visitorMapper;

    @Override
    public int addVisitor(Visitor visitor) {
        return visitorMapper.insertUseGeneratedKeys(visitor);
    }

}

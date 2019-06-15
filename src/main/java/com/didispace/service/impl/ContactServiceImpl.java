package com.didispace.service.impl;

import com.didispace.domain.Contact;
import com.didispace.mapper.ContactMapper;
import com.didispace.service.ContactService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServiceImpl implements ContactService {
    @Autowired
    private ContactMapper contactMapper;

    @Override
    public Contact find() {
        Contact contact = contactMapper.selectAll().get(0);
        return contact;
    }
}

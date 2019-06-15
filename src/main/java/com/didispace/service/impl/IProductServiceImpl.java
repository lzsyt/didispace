package com.didispace.service.impl;

import com.didispace.domain.Product;
import com.didispace.mapper.ProductMapper;
import com.didispace.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IProductServiceImpl implements IProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product selectById(Integer productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

}

package com.didispace.service;

import com.didispace.domain.Product;

public interface IProductService {
    Product selectById(Integer productId);
}

package com.didispace.service.impl;

import com.didispace.domain.Image;
import com.didispace.mapper.ImageMapper;
import com.didispace.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class IImageServiceImpl implements IImageService {
    @Autowired
    private ImageMapper imageMapper;

    @Override
    /**
     *根据图片类型和产品id查
     * @param image
     * @return List
     */
    public List<Image> selectListByCondition(Image image) {
        return imageMapper.selectByCondition(image);
    }

    @Override
    /**
     * 根据名字查
     * @param name
     * @return List
     */
    public List<Image> findByName(String name) {
        return imageMapper.findByName(name);
    }


    @Override
    /**
     * 通过product_type,imageType查询
     * @param  image
     * @return List
     */
    public List<Image> selectByTypeId(Image image) {
        return imageMapper.selectByTypeId(image);
    }

    @Override
    public List<Image> findImg(HashMap<String, String> map) {
        return imageMapper.findImg(map);
    }

}

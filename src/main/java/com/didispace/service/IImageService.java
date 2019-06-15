package com.didispace.service;

import com.didispace.domain.Image;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IImageService {
    List<Image> selectListByCondition(Image image);

    List<Image> findByName(String name);

    List<Image> selectByTypeId(Image image);

    List<Image> findImg(HashMap<String, String> map);
}

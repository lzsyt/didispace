package com.didispace.mapper;

import com.didispace.common.mapper.MyMapper;
import com.didispace.domain.Image;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ImageMapper extends MyMapper<Image> {

    List<Image> selectByCondition(Image image);

    List<Image> findByName(String name);

    List<Image> selectByTypeId(Image image);

    List<Image> findImg(HashMap<String, String> map);
}
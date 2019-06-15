package com.didispace.mapper;

import com.didispace.common.mapper.MyMapper;
import com.didispace.domain.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionMapper extends MyMapper<Question> {

    List<Question> findFile();

    List<Question> findIntroduce();
}
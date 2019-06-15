package com.didispace.service.impl;

import com.didispace.domain.Question;
import com.didispace.mapper.QuestionMapper;
import com.didispace.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IQuestionServiceImpl implements IQuestionService {

    @Autowired
    private QuestionMapper questionMapper;

    @Override
    public List<Question> findIntroduce() {
        return questionMapper.findIntroduce();
    }
    @Override
    public List<Question> selectList() {
        return questionMapper.selectAll();
    }

    @Override
    public List<Question> findFile() {
        return questionMapper.findFile();
    }


}

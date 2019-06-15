package com.didispace.service;

import com.didispace.domain.Question;

import java.util.List;

public interface IQuestionService {


    List<Question> findIntroduce();

    List<Question> findFile();

    List<Question> selectList();
}

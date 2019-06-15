package com.didispace.domain;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "question")
public class Question {
    @Id
    private Integer id;

    private String question;

    private String answer;

    private String filePath;

    private Date createTime;

    private Integer creater;

//    private Integer productType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreater() {
        return creater;
    }

    public void setCreater(Integer creater) {
        this.creater = creater;
    }

//    public Integer getProductType() {
//        return productType;
//    }
//
//    public void setProductType(Integer productType) {
//        this.productType = productType;
//    }
}
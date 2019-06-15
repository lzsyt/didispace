package com.didispace.domain;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "file_download")
public class FileDownload {
    @Id
    private Integer id;

    private String filePath;

    private String fileTitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle == null ? null : fileTitle.trim();
    }
}
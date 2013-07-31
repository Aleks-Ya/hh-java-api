package ru.yaal.project.hhapi.loader.cache;

import java.util.Date;

public class CacheData {
    private String content;
    private long creationDate;

    public CacheData(String content) {
        this.content = content;
        this.creationDate = new Date().getTime();
    }

    public String getContent() {
        return content;
    }

    public long getCreationDate() {
        return creationDate;
    }


}

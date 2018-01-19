package com.wizinno.lims.project.service.dto.job.content;

/**
 * @author LiuMei on 2017-06-15.
 */
public class LibraryBuildDto {

    /**
     * 测序平台
     */
    private Integer seqPlatform;

    /**
     * 文库类型
     */
    private Integer libraryType;

    public Integer getSeqPlatform() {
        return seqPlatform;
    }

    public void setSeqPlatform(Integer seqPlatform) {
        this.seqPlatform = seqPlatform;
    }

    public Integer getLibraryType() {
        return libraryType;
    }

    public void setLibraryType(Integer libraryType) {
        this.libraryType = libraryType;
    }
}

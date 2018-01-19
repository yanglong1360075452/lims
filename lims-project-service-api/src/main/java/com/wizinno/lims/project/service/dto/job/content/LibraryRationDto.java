package com.wizinno.lims.project.service.dto.job.content;

/**
 * @author LiuMei on 2017-06-15.
 */
public class LibraryRationDto {

    /**
     * 测序平台
     */
    private Integer seqPlatform;

    /**
     * 试剂盒
     */
    private Integer kit;

    public Integer getSeqPlatform() {
        return seqPlatform;
    }

    public void setSeqPlatform(Integer seqPlatform) {
        this.seqPlatform = seqPlatform;
    }

    public Integer getKit() {
        return kit;
    }

    public void setKit(Integer kit) {
        this.kit = kit;
    }
}

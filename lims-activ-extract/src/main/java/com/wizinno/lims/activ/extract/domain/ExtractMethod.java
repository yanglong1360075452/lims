package com.wizinno.lims.activ.extract.domain;

import javax.persistence.*;

/**
 * @author LiuMei
 * @date 2017-12-08.
 */
@Entity
@Table(name = "extract_method")
public class ExtractMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    /**
     * 提取方法名称
     */
    @Column(nullable = false)
    private String name;

    /**
     * 备注
     */
    private String note;

    /**
     * 提取方法对应SOP
     */
    private String sop;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSop() {
        return sop;
    }

    public void setSop(String sop) {
        this.sop = sop;
    }
}

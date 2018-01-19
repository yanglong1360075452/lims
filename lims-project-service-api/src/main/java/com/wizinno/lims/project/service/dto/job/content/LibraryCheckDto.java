package com.wizinno.lims.project.service.dto.job.content;

import java.util.Set;

/**
 * @author LiuMei on 2017-06-15.
 */
public class LibraryCheckDto {

    private Set<Integer> checkMethods;

    public Set<Integer> getCheckMethods() {
        return checkMethods;
    }

    public void setCheckMethods(Set<Integer> checkMethods) {
        this.checkMethods = checkMethods;
    }
}

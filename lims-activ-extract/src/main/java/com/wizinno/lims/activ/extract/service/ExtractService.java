package com.wizinno.lims.activ.extract.service;

import com.wizinno.lims.activ.extract.domain.ExtractMethod;
import com.wizinno.lims.activ.service.ActivService;

import java.util.List;

/**
 * @author LiuMei
 * @date 2017-11-09.
 */
public interface ExtractService<T> extends ActivService<T> {

    /**
     * 根据物种/样本类型查询提取方法
     * @param species
     * @param extractType
     * @return
     */
    List<ExtractMethod> getExtractMethod(long species, long extractType);

    /**
     * 根据提取方法查询sop
     * @param method
     * @return
     */
    String getSopByMethod(long method);
}

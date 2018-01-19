package com.wizinno.lims.log.service;

import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.log.service.condition.LogCondition;
import com.wizinno.lims.log.service.dto.LogDto;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * @author LiuMei on 2017-06-14.
 */
public interface LogService {

    /**
     * 记录日志
     * @param logDto
     */
    void addLog(LogDto logDto);

    /**
     * 按条件查询
     * @param condition
     * @return
     */
    List<LogDto> getLogByCondition(LogCondition condition);

    /**
     * 分页查询
     * @param condition 查询条件
     * @param request 分页信息
     * @return
     */
    PageData<LogDto> findAll(LogCondition condition, PageRequest request);
}

package com.wizinno.lims.log.service.impl;

import com.wizinno.lims.common.data.LogOperateEnum;
import com.wizinno.lims.common.data.LogOperateTypeEnum;
import com.wizinno.lims.common.data.PageData;
import com.wizinno.lims.common.query.Criteria;
import com.wizinno.lims.common.query.Restrictions;
import com.wizinno.lims.log.domain.Log;
import com.wizinno.lims.log.repository.LogRepository;
import com.wizinno.lims.log.service.LogService;
import com.wizinno.lims.log.service.condition.LogCondition;
import com.wizinno.lims.log.service.dto.LogDto;
import com.wizinno.lims.user.service.UserService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @author LiuMei on 2017-06-14.
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private UserService userService;

    /**
     * 记录日志
     * @param logDto
     */
    @Override
    public void addLog(LogDto logDto) {
        Log log = new Log();
        BeanUtils.copyProperties(logDto,log);
        logRepository.save(log);
    }

    @Override
    public List<LogDto> getLogByCondition(LogCondition condition) {

        String description = condition.getDescription();
        Integer operate = condition.getOperate();
        Integer operateType = condition.getOperateType();
        Long operator = condition.getOperator();
        Date startTime = condition.getOperateStartTime();
        Date endTime = condition.getOperateEndTime();

        Criteria c = new Criteria();

        if (StringUtils.isNotBlank(description)) {
            c.add(Restrictions.like("description", description, true));
        }

        if (operate != null ) {
            c.add(Restrictions.eq("operate", operate, true));
        }

        if (operateType != null ) {
            c.add(Restrictions.eq("operateType", operateType, true));
        }

        if (operator != null ) {
            c.add(Restrictions.eq("operator", operator, true));
        }

        if (startTime != null) {
            c.add(Restrictions.gte("operateTime", startTime, true));
        }
        if (endTime != null) {
            c.add(Restrictions.gte("operateTime", endTime, true));
        }

        List<Log> logs = logRepository.findAll(c,new Sort(Direction.DESC,"operateTime"));
        List<LogDto> logDTOs = null;
        if(CollectionUtils.isNotEmpty(logs)){
            logDTOs =  new ArrayList<>();
            LogDto logDto;
            for(Log log : logs){
                logDto = new LogDto();
                BeanUtils.copyProperties(log,logDto);
                logDTOs.add(logDto);
            }
        }
        return logDTOs;
    }

    @Override
    public PageData<LogDto> findAll(LogCondition condition, PageRequest request) {
        Date operateStartTime = condition.getOperateStartTime();
        Date operateEndTime = condition.getOperateEndTime();
        Integer operateType = condition.getOperateType();
        Long operator = condition.getOperator();
        Criteria c = new Criteria();
        if (operateStartTime != null) {
            c.add(Restrictions.gte("operateTime", operateStartTime, true));
        }
        if (operateEndTime != null) {
            c.add(Restrictions.lte("operateTime", operateEndTime, true));
        }
        if(operateType != null){
            c.add(Restrictions.eq("operateType",operateType, true));
        }
        if(operator != null){
            c.add(Restrictions.eq("operator",operator, true));
        }
        Page page = logRepository.findAll(c, request);
        long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();
        List<Log> content = page.getContent();

        List<LogDto> logDTOs = null;
        if (CollectionUtils.isNotEmpty(content)) {
            logDTOs = new ArrayList<>();
            LogDto logDto;
            for (Log log : content) {
                logDto = new LogDto();
                BeanUtils.copyProperties(log, logDto);
                logDto.setOperateDesc(LogOperateEnum.getNameByCode(logDto.getOperate()));
                logDto.setOperateTypeDesc(LogOperateTypeEnum.getNameByCode(logDto.getOperateType()));
                logDto.setOperatorUser(userService.findSimpleById(logDto.getOperator()));
                logDTOs.add(logDto);
            }
        }
        return new PageData(request.getPageNumber(), request.getPageSize(), logDTOs, totalPages, totalElements);
    }

}

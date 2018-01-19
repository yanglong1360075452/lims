package com.wizinno.lims.log.api;

import com.wizinno.lims.common.controller.BaseController;
import com.wizinno.lims.common.data.LogOperateTypeEnum;
import com.wizinno.lims.common.data.ResponseVO;
import com.wizinno.lims.log.service.LogService;
import com.wizinno.lims.log.service.condition.LogCondition;
import com.wizinno.lims.log.service.dto.EnumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author LiuMei on 2017-06-14.
 *
 * 日志控制类
 */
@RestController
@RequestMapping("/api/log")
public class LogController extends BaseController {

    @Autowired
    private LogService logService;

    /**
     * 根据条件获取日志列表
     * @param page
     * @param length
     * @param operateType
     * @param operator
     * @param operateTimeStart
     * @param operateTimeEnd
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public ResponseVO getLogs(@RequestParam(value = "page", defaultValue = "1") int page,
                               @RequestParam(value = "length", defaultValue = "10") int length,
                               @RequestParam(value = "operateType", required = false) Integer operateType,
                               @RequestParam(value = "operator", required = false) Long operator,
                               @RequestParam(value = "operateTimeStart", required = false) Long operateTimeStart,
                               @RequestParam(value = "operateTimeEnd", required = false) Long operateTimeEnd) {
        Order order = new Order(Direction.DESC, "id");
        PageRequest pageRequest = new PageRequest(page - 1, length, new Sort(order));
        LogCondition condition = new LogCondition();
        if (operateTimeEnd != null) {
            condition.setOperateEndTime(new Date(operateTimeEnd));
        }
        if (operateTimeStart != null) {
            condition.setOperateStartTime(new Date(operateTimeStart));
        }
        if(operateType != null){
            condition.setOperateType(operateType);
        }
        if(operator != null){
            condition.setOperator(operator);
        }
        return new ResponseVO(logService.findAll(condition, pageRequest));
    }

    /**
     * 获取日志类型列表
     * @return
     */
    @RequestMapping(value = "/type",method = RequestMethod.GET)
    public ResponseVO getLogType() {
        List<EnumDto> enumDTOs = new ArrayList<>();
        EnumDto enumDto;
        for (LogOperateTypeEnum e : LogOperateTypeEnum.values()) {
           enumDto = new EnumDto();
           enumDto.setCode(e.toCode());
           enumDto.setName(e.toString());
            enumDTOs.add(enumDto);
        }
        return new ResponseVO(enumDTOs);
    }

}

package com.wizinno.lims.workflow.cfg.repository;

import com.wizinno.lims.workflow.cfg.domain.CfgWfTrans;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author LiuMei
 * @date 2017-10-25.
 */
public interface CfgWfTransRepository extends JpaRepository<CfgWfTrans,Long> {

    /**
     * 根据工作流ID查询走向列表
     * @param wfId
     * @return
     */
    List<CfgWfTrans> findByCfgWfId(long wfId);

    /**
     * 根据workflowId和fromActivId查询trans记录
     * @param workflowId
     * @param fromActivId
     * @return
     */
    CfgWfTrans findByCfgWfIdAndFromActivId(long workflowId, Long fromActivId);
}

package com.wizinno.lims.task.repository;

import com.wizinno.lims.task.domain.TaskStep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author LiuMei on 2017-07-18.
 */
public interface TaskStepRepository extends JpaRepository<TaskStep,Long>,JpaSpecificationExecutor<TaskStep> {

}

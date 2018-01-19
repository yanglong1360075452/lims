package com.wizinno.lims.workflow.cfg.service.data;

/**
 * 工作流应用分类枚举
 *
 * @author LiuMei
 * @date 2017-10-26.
 */
public enum WorkflowApplicationEnum {

    /**
     * NGS
     */
    NGS(1, "NGS"),
    /**
     * PCR
     */
    PCR(2, "PCR"),
    ;
    private Integer code;

    private String name;


    WorkflowApplicationEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer toCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public static WorkflowApplicationEnum valueOf(Integer code) {
        for (WorkflowApplicationEnum workflowApplicationEnum : WorkflowApplicationEnum.values()) {
            if (workflowApplicationEnum.toCode().equals(code)) {
                return workflowApplicationEnum;
            }
        }
        return null;
    }

    public static String getNameByCode(Integer code) {
        for (WorkflowApplicationEnum workflowApplicationEnum : WorkflowApplicationEnum.values()) {
            if (workflowApplicationEnum.toCode().equals(code)) {
                return workflowApplicationEnum.toString();
            }
        }
        return null;
    }
    
}

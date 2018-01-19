package com.wizinno.lims.project.api.vo;

import java.util.List;

/**
 * @author LiuMei on 2017-06-30.
 */
public class SampleLotBarListVO {

    private SampleLotBarVO originalSampleLot;

    private List<SampleLotBarVO> workSampleLots;

    public SampleLotBarVO getOriginalSampleLot() {
        return originalSampleLot;
    }

    public void setOriginalSampleLot(SampleLotBarVO originalSampleLot) {
        this.originalSampleLot = originalSampleLot;
    }

    public List<SampleLotBarVO> getWorkSampleLots() {
        return workSampleLots;
    }

    public void setWorkSampleLots(List<SampleLotBarVO> workSampleLots) {
        this.workSampleLots = workSampleLots;
    }

}

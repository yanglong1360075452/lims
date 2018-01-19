<template>
    <el-form ref="form" label-position="right" :rules="rules" :model="form" label-width="100px" id="projectTab">
        <el-row :gutter="10">
            <el-col :span="8">
                <el-form-item label="项目编号">
                    <el-input name="projectNo" v-model="form.no" :readonly="true"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="16" style="display: flex;">
                <el-form-item label="项目名称" prop="name" style="flex-grow: 1">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>

                <div class="btn-group">
                    <el-button v-if="form.id == null">
                        <icon-svg icon-class="lead"/>
                        导入合同
                    </el-button>
                    <el-button v-if="form.id != null && !edit">
                        <icon-svg icon-class="lead"/>
                        导出
                    </el-button>
                    <el-button v-if="form.id != null && !edit">
                        <icon-svg icon-class="lead"/>
                        打印
                    </el-button>
                    <div v-if="form.id != null && !edit && form.projectStatus<this.GLOBAL.ProjectStatusEnum.DELIVERED" class="editWrapper">
                        <el-button class="edit" icon="edit" @click="editForm()">编辑</el-button>
                    </div>
                    <div class="buttonWrapper">
                        <el-button class="confirm" icon="check" @click="submitForm()" v-if="edit">保存</el-button>
                        <el-button class="cancel" icon="close" @click="cancel()" v-if="edit">取消</el-button>
                    </div>
                </div>
            </el-col>
        </el-row>
        <hr/>
        <div class="form-group-title">合同摘要</div>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-form-item label="合同编号" prop="contractNo">
                    <el-input v-model="form.contractNo"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="16">
                <el-form-item label="合同名称" prop="contractName">
                    <el-input v-model="form.contractName"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-form-item label="子合同编号">
                    <el-input v-model="form.subContractNo"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="16">
                <el-form-item label="子合同名称">
                    <el-input v-model="form.subContractName"></el-input>
                </el-form-item>
            </el-col>
        </el-row>

        <el-row :gutter="20">
            <el-col :span="8">
                <el-form-item label="商机编号" prop="businessNo">
                    <el-input v-model="form.businessNo"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="16">
                <el-form-item label="临时合同">
                    <el-input v-model="form.tempContract"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-form-item label="客户代表" prop="customerRepresentative">
                    <el-input v-model="form.customerRepresentative"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="16">
                <el-form-item label="合同备注">
                    <el-input v-model="form.contractNote"></el-input>
                </el-form-item>
            </el-col>
        </el-row>

        <hr/>
        <div class="form-group-title">项目摘要</div>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-form-item label="客户编号" prop="customerNo">
                    <el-input v-model="form.customerNo"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="16">
                <el-form-item label="客户单位" prop="customerUnit">
                    <el-input v-model="form.customerUnit"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-form-item label="客户姓名" prop="customerName">
                    <el-input v-model="form.customerName"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="客户电话" prop="customerPhone">
                    <el-input v-model="form.customerPhone"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="Email" prop="customerEmail">
                    <el-input v-model="form.customerEmail"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-form-item label="项目类型">
                    <el-radio-group v-model="form.projectType">
                        <el-radio v-for="item in projectTypeList" :label="item.id" :key="item.id">
                            {{item.description}}
                        </el-radio>
                    </el-radio-group>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="优先级别" prop="priority">
                    <el-select v-model="form.priority" placeholder="请选择">
                        <el-option v-for="item in priorityList" :key="item.id" :label="item.description"
                                   :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>

            </el-col>
            <el-col :span="8">
                <el-form-item label="计划完成时间">
                    <el-date-picker
                            v-model="form.planCompleteTime"
                            align="right"
                            type="date"
                            placeholder="选择日期"
                            :picker-options="pickerOptions0"
                            style="width: 100%;"
                    >
                    </el-date-picker>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="24">
                <el-form-item label="概要备注">
                    <el-input v-model="form.summaryNote"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="24">
                <el-form-item label="特殊要求">
                    <el-input
                            type="textarea"
                            :rows="2"
                            placeholder="请输入内容"
                            v-model="form.specialRequire"
                    >
                    </el-input>
                </el-form-item>
            </el-col>
        </el-row>

        <el-row :gutter="20">
            <el-col :span="8">
                <el-form-item label="样本类别" prop="sampleCategory">
                    <el-select v-model="form.sampleCategory" placeholder="请选择" @change="changeSampleCategory">
                        <el-option v-for="item in sampleCategoryList" :key="item.id" :label="item.description"
                                   :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
            </el-col>

            <el-col :span="8">
                <el-form-item label="样本类型" prop="sampleType">
                    <el-select v-model="form.sampleType" placeholder="请选择">
                        <el-option v-for="item in sampleTypeList" :key="item.id" :label="item.description"
                                   :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>
            </el-col>

            <el-col :span="8">
                <el-form-item label="物种分类" prop="species">
                    <el-select v-model="form.species" placeholder="请选择">
                        <el-option v-for="item in speciesList" :key="item.id" :label="item.description"
                                   :value="item.id">
                        </el-option>
                    </el-select>
                </el-form-item>

            </el-col>
        </el-row>

        <hr/>

        <div class="form-group-title">工作任务</div>
        <el-row :gutter="20">
            <div class="task-line-wrapper">
                <div class="task-line"></div>
            </div>

            <el-row class="task-item-wrapper" :class="{disable:!taskEnableList[0]}" :gutter="20" v-if="taskShowList[0]">
                <el-col @click.native="changeTaskStatus(0)" class="task-icon-wrapper" :span="4">
                    <img class="task-icon" v-show="taskEnableList[0] || jobs[0].selected"
                         src="~assets/image/task/icon_ybtq_sel@2x.png"/>
                    <img class="task-icon" v-show="!taskEnableList[0] && !jobs[0].selected"
                         src="~assets/image/task/icon_ybtq_nor@2x.png"/>
                    <div class="task-text">样本提取</div>
                </el-col>

                <el-col class="task-item-content" :span="20">

                    <el-col :span="10">
                        <el-form-item label="样本类别">
                            <el-select :disabled="!taskEnableList[0] && !jobs[0].selected"
                                       v-model="jobs[0].params.sampleCategory" placeholder="请选择"
                                       @change="extractChangeSampleCategory()">
                                <el-option v-for="item in extractSampleCategoryList" :key="item.id"
                                           :label="item.description"
                                           :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>

                    <el-col :span="10">
                        <el-form-item label="样本类型">
                            <el-select :disabled="!taskEnableList[0] && !jobs[0].selected"
                                       v-model="jobs[0].params.sampleType" placeholder="请选择">
                                <el-option v-for="item in extractSampleTypeList" :key="item.id"
                                           :label="item.description"
                                           :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-col>

            </el-row>

            <el-row class="task-item-wrapper" :class="{disable:!taskEnableList[1]}" :gutter="20" v-if="taskShowList[1]">
                <el-col @click.native="changeTaskStatus(1)" class="task-icon-wrapper" :span="4">
                    <!--图标-->
                    <img class="task-icon" v-show="taskEnableList[1] || jobs[1].selected"
                         src="~assets/image/task/icon_ybjc_sel@2x.png"/>
                    <img class="task-icon" v-show="!taskEnableList[1] && !jobs[1].selected"
                         src="~assets/image/task/icon_ybjc_nor@2x.png"/>
                    <div class="task-text">样本检测</div>
                </el-col>

                <el-col class="task-item-content" :span="20">
                    <el-form-item label="检测方法" prop="sampleCheckMethod">
                        <el-checkbox-group v-model="jobs[1].params.checkMethods">
                            <el-checkbox v-for="item in checkMethodsList" :label="item.id" :key="item.id"
                                         :disabled="!taskEnableList[1] && !jobs[1].selected">
                                {{item.description}}
                            </el-checkbox>
                        </el-checkbox-group>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row class="task-item-wrapper" :class="{disable:!taskEnableList[2]}" :gutter="20" v-if="taskShowList[2]">
                <el-col @click.native="changeTaskStatus(2)" class="task-icon-wrapper" :span="4">
                    <!--图标-->
                    <img class="task-icon" v-show="taskEnableList[2] || jobs[2].selected"
                         src="~assets/image/task/icon_wkgj_sel@2x.png"/>
                    <img class="task-icon" v-show="!taskEnableList[2] && !jobs[2].selected"
                         src="~assets/image/task/icon_wkgj_nor@2x.png"/>
                    <div class="task-text">文库构建</div>
                </el-col>

                <el-col class="task-item-content" :span="20">
                    <el-col :span="10">
                        <el-form-item label="测序平台" prop="buildSeqPlatform">
                            <el-select :disabled="!taskEnableList[2] && !jobs[2].selected"
                                       v-model="jobs[2].params.seqPlatform"
                                       placeholder="请选择">
                                <el-option v-for="item in seqPlatformList" :key="item.id" :label="item.description"
                                           :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="文库类型" prop="libraryType">
                            <el-select :disabled="!taskEnableList[2] && !jobs[2].selected"
                                       v-model="jobs[2].params.libraryType"
                                       placeholder="请选择">
                                <el-option v-for="item in libraryTypeList" :key="item.id" :label="item.description"
                                           :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                </el-col>

            </el-row>

            <el-row class="task-item-wrapper" :class="{disable:!taskEnableList[3]}" :gutter="20" v-if="taskShowList[3]">
                <el-col @click.native="changeTaskStatus(3)" class="task-icon-wrapper" :span="4">
                    <img class="task-icon" v-show="taskEnableList[3] || jobs[3].selected"
                         src="~assets/image/task/icon_wkjc_sel@2x.png"/>
                    <img class="task-icon" v-show="!taskEnableList[3] && !jobs[3].selected"
                         src="~assets/image/task/icon_wkjc_nor@2x.png"/>
                    <div class="task-text">文库检测</div>
                </el-col>
                <el-col class="task-item-content" :span="20">
                    <el-form-item label="检测方法" prop="libraryCheckMethod">
                        <el-checkbox-group v-model="jobs[3].params.checkMethods">
                            <el-checkbox v-for="wk in libraryCheckMethodList" :label="wk.id" :key="wk.id"
                                         :disabled="!taskEnableList[3] && !jobs[3].selected">
                                {{wk.description}}
                            </el-checkbox>
                        </el-checkbox-group>
                    </el-form-item>
                </el-col>

            </el-row>

            <el-row class="task-item-wrapper" :class="{disable:!taskEnableList[4]}" :gutter="20" v-if="taskShowList[4]">
                <el-col @click.native="changeTaskStatus(4)" class="task-icon-wrapper" :span="4">
                    <img class="task-icon" v-show="taskEnableList[4] || jobs[4].selected"
                         src="~assets/image/task/icon_wkdl_sel@2x.png"/>
                    <img class="task-icon" v-show="!taskEnableList[4] && !jobs[4].selected"
                         src="~assets/image/task/icon_wkdl_nor@2x.png"/>
                    <div class="task-text">文库定量</div>
                </el-col>

                <el-col class="task-item-content" :span="20">
                    <el-col :span="10">
                        <el-form-item label="测序平台" prop="rationSeqPlatform">
                            <el-select :disabled="!taskEnableList[4] && !jobs[4].selected"
                                       v-model="jobs[4].params.seqPlatform"
                                       placeholder="请选择">
                                <el-option v-for="item in seqPlatformList" :key="item.id" :label="item.description"
                                           :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="试剂盒" prop="kit">
                            <el-select :disabled="!taskEnableList[4] && !jobs[4].selected" v-model="jobs[4].params.kit"
                                       placeholder="请选择">
                                <el-option v-for="item in kitList" :key="item.id" :label="item.description"
                                           :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-col>

            </el-row>


            <el-row class="task-item-wrapper" :class="{disable:!taskEnableList[5]}" :gutter="20" v-if="taskShowList[5]">
                <el-col @click.native="changeTaskStatus(5)" class="task-icon-wrapper" :span="4">
                    <!--图标-->
                    <img class="task-icon" v-show="taskEnableList[5] || jobs[5].selected"
                         src="~assets/image/task/icon_sjcx_sel@2x.png"/>
                    <img class="task-icon" v-show="!taskEnableList[5] && !jobs[5].selected"
                         src="~assets/image/task/icon_sjcx_nor@2x.png"/>
                    <div class="task-text">上机测序</div>
                </el-col>

                <el-col class="task-item-content" :span="20">
                    <el-col :span="10">
                        <el-form-item label="测序平台" prop="seqSeqPlatform">
                            <el-select :disabled="!taskEnableList[5] && !jobs[5].selected"
                                       v-model="jobs[5].params.seqPlatform"
                                       placeholder="请选择" @change="seqSeqPlatformChange">
                                <el-option v-for="item in seqPlatformList" :key="item.id" :label="item.description"
                                           :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="测序策略" prop="seqStrategy">
                            <el-select :disabled="!taskEnableList[5] && !jobs[5].selected"
                                       v-model="jobs[5].params.seqStrategy"
                                       placeholder="请选择">
                                <el-option v-for="item in seqStrategyList" :key="item.id" :label="item.description"
                                           :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="数据量" prop="dataAmount">
                            <el-input :disabled="!taskEnableList[5] && !jobs[5].selected"
                                      v-model="jobs[5].params.dataAmount"></el-input>
                        </el-form-item>

                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="单位" prop="dataAmountUnit">
                            <el-select :disabled="!taskEnableList[5] && !jobs[5].selected"
                                       v-model="jobs[5].params.dataAmountUnit"
                                       placeholder="请选择">
                                <el-option v-for="item in dataAmountUnitList" :key="item.id" :label="item.description"
                                           :value="item.id">
                                </el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-col>
            </el-row>
            <el-row class="task-item-wrapper" :class="{disable:!taskEnableList[6]}" :gutter="20" v-if="taskShowList[6]">
                <el-col @click.native="changeTaskStatus(6)" class="task-icon-wrapper" :span="4">
                    <img class="task-icon" v-show="taskEnableList[6] || jobs[6].selected"
                         src="~assets/image/task/icon_cxjg_sel@2x.png"/>
                    <img class="task-icon" v-show="!taskEnableList[6] && !jobs[6].selected"
                         src="~assets/image/task/icon_cxjg_nor@2x.png"/>
                    <div class="task-text">测序结果QC</div>
                </el-col>
                <el-col class="task-item-content" :span="20">
                    <el-col :span="10">
                        <el-form-item label="待定内容">
                            <el-select :disabled="!taskEnableList[6] && !jobs[6].selected" placeholder="请选择"
                                       v-model="form.test">
                                <el-option :value="3"></el-option>
                                <el-option :value="2"></el-option>
                                <el-option :value="1"></el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="待定内容">
                            <el-select :disabled="!taskEnableList[6] && !jobs[6].selected" v-model="form.test"
                                       placeholder="请选择">
                                <el-option :value="3"></el-option>
                                <el-option :value="2"></el-option>
                                <el-option :value="1"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-col>

            </el-row>

            <el-row class="task-item-wrapper" :class="{disable:!taskEnableList[7]}" :gutter="20" v-if="taskShowList[7]">
                <el-col @click.native="changeTaskStatus(7)" class="task-icon-wrapper" :span="4">
                    <!--图标-->
                    <img class="task-icon" v-show="taskEnableList[7] || jobs[7].selected"
                         src="~assets/image/task/icon_sxfx_sel@2x.png"/>
                    <img class="task-icon" v-show="!taskEnableList[7] && !jobs[7].selected"
                         src="~assets/image/task/icon_sxfx_nor@2x.png"/>
                    <div class="task-text">生信分析</div>
                </el-col>

                <el-col class="task-item-content" :span="20">
                    <el-col :span="10">
                        <el-form-item label="待定内容">
                            <el-select :disabled="!taskEnableList[7] && !jobs[7].selected" v-model="form.test"
                                       placeholder="请选择">
                                <el-option :value="3"></el-option>
                                <el-option :value="2"></el-option>
                                <el-option :value="1"></el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                    <el-col :span="10">
                        <el-form-item label="待定内容">
                            <el-select :disabled="!taskEnableList[7] && !jobs[7].selected" v-model="form.test"
                                       placeholder="请选择">
                                <el-option :value="3"></el-option>
                                <el-option :value="2"></el-option>
                                <el-option :value="1"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                </el-col>
            </el-row>
            <el-row class="task-item-wrapper" :class="{disable:!taskEnableList[8]}" :gutter="20" v-if="taskShowList[8]">
                <el-col @click.native="changeTaskStatus(8)" class="task-icon-wrapper" :span="4">
                    <img class="task-icon" v-show="taskEnableList[8] || jobs[8].selected"
                         src="~assets/image/task/icon_other_sel@2x.png"/>
                    <img class="task-icon" v-show="!taskEnableList[8] && !jobs[8].selected"
                         src="~assets/image/task/icon_other_nor@2x.png"/>
                    <div class="task-text">其他</div>
                </el-col>
                <el-col class="task-item-content" :span="20">
                    <el-col :span="20">
                        <el-form-item label="其他">
                            <el-input :disabled="!taskEnableList[8] && !jobs[8].selected"
                                      v-model="jobs[8].params.description"
                                      placeholder="请输入内容"></el-input>
                        </el-form-item>
                    </el-col>
                </el-col>
            </el-row>
        </el-row>
        <hr/>
        <el-row>
            <div class="buttonWrapper">
                <el-button class="confirm" icon="check" @click="submitForm()" v-if="edit || form.id == null">保存
                </el-button>
                <el-button class="cancel" icon="close" @click="cancel()" v-if="edit">取消</el-button>
            </div>
        </el-row>
        <el-dialog
                title="提示"
                :visible.sync="dialogVisible"
                size="tiny">
            <span>项目创建完毕，是否添加样本</span>
            <span slot="footer" class="dialog-footer">
                  <el-button @click="$router.push({name:'projectDetail',query:{title:'sample',projectId:form.id},
                    params:{projectNo:form.no,id: form.id,sampleCategory:form.sampleCategory,species:form.species,sampleType:form.sampleType}})"
                             type="primary">
                     添加样本
                  </el-button>
                <router-link :to="{path:'/project/list/1'}">
                  <el-button type="primary">返回项目列表</el-button>
                </router-link>
                  <el-button type="primary" @click="stay">留在详情页</el-button>
              </span>
        </el-dialog>
    </el-form>
</template>

<script>
    import IconSvg from "components/Icon-svg/index";
    import DataDict from '@/api/dataDict';
    import Project from '@/api/project';
    import Util from '@/utils/util';
    import {setTabDisabled} from '@/utils/projectTabUtil';
    import {validateMobilePhone, validateTelephone} from '@/utils/validate'

    export default {
        components: {
            IconSvg,
        },
        data() {
            let checkPhone = (rule, value, callback) => {
                if (!validateMobilePhone(value) && !validateTelephone(value)) {
                    callback(new Error());
                } else {
                    callback();
                }
            };
            return {
                jobsDisabled: false,
                edit: false,
                dialogVisible: false,
                id: null,
                taskEnableList: [false, false, false, false, false, false, false, false, false],
                taskShowList: [true, true, true, true, true, true, true, true, true],
                typeList: "1,2,3,4,7,9,10,13,15",
                form: {
                    id: null,
                    no: null,
                    name: null,
                    contractNo: null,
                    contractName: null,
                    subContractNo: null,
                    subContractName: null,
                    businessNo: null,
                    tempContract: null,
                    customerRepresentative: null,
                    contractNote: null,
                    customerNo: null,
                    customerUnit: null,
                    customerName: null,
                    customerPhone: null,
                    customerEmail: null,
                    projectType: 1,
                    priority: null,
                    planCompleteTime: null,
                    specialRequire: null,
                    summaryNote: null,
                    sampleCategory: null,
                    sampleType: null,
                    species: null,
                    jobs: [],
                    projectStatus: null
                },
                jobTypes: [1, 2, 3, 4, 5, 6, 7, 8, 9],//工作任务类型列表
                jobs: [
                    {
                        type: 1,
                        params: {
                            sampleCategory: null,
                            sampleType: null
                        }
                    },
                    {
                        type: 2,
                        params: {
                            checkMethods: []
                        }
                    },
                    {
                        type: 3,
                        params: {
                            seqPlatform: null,
                            libraryType: null
                        }
                    },
                    {
                        type: 4,
                        params: {
                            checkMethods: []
                        }
                    },
                    {
                        type: 5,
                        params: {
                            seqPlatform: null,
                            kit: null
                        }
                    },
                    {
                        type: 6,
                        params: {
                            seqPlatform: null,
                            seqStrategy: null,
                            dataAmount: null,
                            dataAmountUnit: null
                        }
                    },
                    {
                        type: 7,
                        params: {}
                    },
                    {
                        type: 8,
                        params: {}
                    },
                    {
                        type: 9,
                        params: {
                            description: null
                        }
                    }
                ],
                //下拉框数据存放集合
                projectTypeList: [],
                priorityList: [],
                sampleCategoryList: [],
                extractSampleCategoryList: [],
                sampleTypeList: [],
                extractSampleTypeList: [],
                speciesList: [],
                extractContentList: [],
                checkMethodsList: [],
                libraryTypeList: [],
                libraryCheckMethodList: [],
                seqPlatformList: [],
                seqStrategyList: [],
                dataAmountUnitList: [],
                kitList: [],
                pickerOptions0: {
                    disabledDate(time) {
                        return time.getTime() < Date.now() - 8.64e7;
                    }
                },
                time: '',
                rules: {
                    name: [{required: true, message: '请输入项目名称', trigger: 'blur'}],
                    contractNo: [{required: true, message: '请输入合同编号', trigger: 'blur'}],
                    contractName: [{required: true, message: '请输入合同名称', trigger: 'blur'}],
                    businessNo: [{required: true, message: '请输入商机编号', trigger: 'blur'}],
                    customerRepresentative: [{required: true, message: '请输入客户代表', trigger: 'blur'}],
                    customerNo: [{required: true, message: '请输入客户编号', trigger: 'blur'}],
                    customerUnit: [{required: true, message: '请输入客户单位', trigger: 'blur'}],
                    customerName: [{required: true, message: '请输入客户姓名', trigger: 'blur'}],
                    customerEmail: [{type: 'email', required: true, message: '请输入正确的邮箱地址', trigger: 'blur'}],
                    customerPhone: [
                        {required: true, message: '请输入电话号码', trigger: 'blur'},
                        {validator: checkPhone, message: '请输入正确电话号码', trigger: 'blur'},
                    ],
                    priority: [{type: 'number', required: true, message: '请选择优先级', trigger: 'change'}],
                    sampleCategory: [{type: 'number', required: true, message: '请选择样本类别', trigger: 'change'}],
                    sampleType: [{type: 'number', required: true, message: '请选择样本类型', trigger: 'change'}],
                    species: [{type: 'number', required: true, message: '请选择物种', trigger: 'change'}],
                    sampleExtractContent: [{index: 0, required: false, message: '请选择提取内容', trigger: 'change'}],
                    sampleCheckMethod: [{index: 1, required: false, message: '请选择检测方法', trigger: 'change'}],
                    buildSeqPlatform: [{index: 2, required: false, message: '请选择测序平台', trigger: 'change'}],
                    libraryType: [{index: 2, required: false, message: '请选择文库类型', trigger: 'blur'}],
                    libraryCheckMethod: [{index: 3, required: false, message: '请选择检测方法', trigger: 'blur'}],
                    rationSeqPlatform: [{index: 4, required: false, message: '请选择测序平台', trigger: 'blur'}],
//                    kit: [{index: 4, required: false, message: '请选择试剂盒', trigger: 'blur'}],
                    seqSeqPlatform: [{index: 5, required: false, message: '请选择测序平台', trigger: 'blur'}],
                    seqStrategy: [{index: 5, required: false, message: '请选择测序策略', trigger: 'blur'}],
                    dataAmount: [{index: 5, required: false, message: '请选择数据量', trigger: 'blur'}],
                    dataAmountUnit: [{index: 5, required: false, message: '请选择数据量单位', trigger: 'blur'}]
                },
            };
        },

        mounted () {
            this.getDictList(this.typeList);
            this.form.id = this.$route.query.projectId;
            if (this.form.id != null) {
                this.getProject();
            } else {
                this.$store.commit("setProjectNo", null);
                this.$store.commit("setProjectStatus", null);
            }
        },
        methods: {
            stay(){
                this.dialogVisible = false;
                this.edit = false;
                this.readOnly();
            },
            readOnly(){//整个页面只读状态
                let tags = document.querySelectorAll("#projectTab .el-form-item");
                for (let i = 0; i < tags.length; i++) {
                    tags[i].setAttribute("readonly", "");
                }
                this.jobsDisabled = true;
                let jobs = this.form.jobs;
                for (let i = 0; i < jobs.length; i++) {
                    this.$set(this.taskEnableList, i, false);
                }
            },
            cancel(){
                this.edit = false;
                this.readOnly();
                setTabDisabled(false);
            },
            editForm(){
                setTabDisabled(true);
                let tags = document.querySelectorAll("#projectTab .el-form-item");
                for (let i = 0; i < tags.length; i++) {
                    tags[i].removeAttribute("readonly");
                }
                document.getElementsByName("projectNo")[0].readOnly = true;
                this.edit = true;
                this.jobsDisabled = false;
                let jobs = this.form.jobs;
                for (let i = 0; i < jobs.length; i++) {
                    this.$set(this.taskEnableList, jobs[i].type - 1, !this.taskEnableList[jobs[i].type - 1]);
                }
            },
            submitForm() {
                setTabDisabled(false);
                this.$refs.form.validate((valid) => {
                    if (valid) {
                        if (this.form.jobs == null || this.form.jobs.length <= 0) {
                            this.$message({type: 'info', message: '请选择工作任务'});
                        } else {
                            let that = this;
                            let flag = false;
                            this.form.jobs.forEach(function (job) {
                                for (let prop in job.params) {
                                    if (job.params[prop] == null || job.params[prop] == '') {
                                        that.$message({type: 'info', message: '请完善工作任务'});
                                        flag = true;
                                    }
                                }
                            });
                            if (flag) {
                                return;
                            }
                            if (this.form.planCompleteTime != null) {
                                this.form.planCompleteTime = Util.dateUtil.dateFormatNewDate(this.form.planCompleteTime);
                            }
                            if (this.form.id == null) {
                                Project.create(this.form).then((response) => {
                                    if (response.code == 0) {
                                        this.$store.commit("setProjectNo", response.data.no);
                                        this.$store.commit("setProjectId", response.data.id);
                                        this.$store.commit("setProjectStatus", response.data.projectStatus);
                                        this.$message({type: 'success', message: '创建项目成功'});
                                        this.form.id = response.data.id;
                                        this.form.no = response.data.no;
                                        this.dialogVisible = true;
                                    } else {
                                        this.$message({type: 'error', message: '创建项目失败'});
                                    }
                                });
                            } else {
                                Project.update(this.form).then((response) => {
                                    if (response.code == 0) {
                                        this.$store.commit("setProjectNo", this.form.no);
                                        this.$store.commit("setProjectId", this.form.id);
                                        this.$store.commit("setProjectStatus", this.form.projectStatus);
                                        this.$message({type: 'success', message: '更新项目成功'});
                                        this.getProject();
                                        this.edit = false;
                                    } else {
                                        this.$message({type: 'error', message: '更新项目失败'});
                                    }
                                });
                            }
                        }
                    } else {
                        this.$message({type: 'info', message: '请完善项目信息'});
                        return false;
                    }
                });
            },
            changeTaskStatus(index){
                this.jobs[index].selected = !this.jobs[index].selected;
                if (!this.jobsDisabled) {
                    this.$set(this.taskEnableList, index, !this.taskEnableList[index]);
                    if (this.taskEnableList[index]) {
                        this.form.jobs.push(this.jobs[index]);
                        this.setJobContentRequired(index, true);
                    } else {
                        for (let i = 0; i < this.form.jobs.length; i++) {
                            if (this.form.jobs[i].type == this.jobs[index].type) {
                                this.form.jobs.splice(i, 1);
                                this.setJobContentRequired(index, false);
                            }
                        }
                    }
                }
                if (this.form.id == null) {
                    Object.assign(this.$data.jobs, this.$options.data());//初始化jobs
                }
            },
            setJobContentRequired(index, required){
                for (let prop in this.rules) {
                    if (this.rules[prop][0].index == index) {
//                        this.rules[prop][0].required = required;
                    }
                }
            },
            getProject(){
                if (this.form.id != null) {
                    Project.getById(this.form.id).then((response) => {
                        if (response.code == 0) {
                            this.readOnly();
                            this.form = response.data;
                            this.$store.commit("setProjectNo", this.form.no);
                            this.$store.commit("setProjectId", this.form.id);
                            this.$store.commit("setProjectStatus", this.form.projectStatus);
                            let jobs = this.form.jobs;
                            for (let i = 0; i < jobs.length; i++) {
                                let job = jobs[i];
                                let type = job.type;
                                this.jobs[type - 1].params = job.params;
                                this.jobs[type - 1].selected = true;
                            }
                            this.changeSampleCategory();
                        } else {
                            this.$message({type: 'error', message: response.reason});
                        }
                    });
                }
            },
            getDictList(type){
                DataDict.getList({
                    type: type
                }).then(response => {
                    if (response.code == 0) {
                        this.projectTypeList = response.data[1];
                        this.priorityList = response.data[2];
                        this.speciesList = response.data[3];
                        this.sampleCategoryList = response.data[4];
                        let that = this;
                        this.sampleCategoryList.forEach(function (val) {
                            if (val.description === "DNA" || val.description === "RNA") {
                                that.extractSampleCategoryList.push(val);
                            }
                        });
                        this.extractContentList = response.data[7];
                        this.checkMethodsList = response.data[9];
                        this.libraryCheckMethodList = response.data[10];
                        this.seqPlatformList = response.data[13];
                        this.dataAmountUnitList = response.data[15];
                    }
                });
            },
            changeSampleCategory(){
                let id = this.form.sampleCategory;
                if (this.edit) {
                    this.$set(this.form, "sampleType", null);
                }
                if (id == 12 || id == 14) { //DNA/RNA
                    let that = this;
                    this.taskShowList.forEach(function (val, index) {
                        that.$set(that.taskShowList, index, true);
                    });
                    that.$set(that.taskShowList, 0, false); //样本提取不显示

                    if (that.jobs[0].selected) {
                        that.changeTaskStatus(0);
                    }
                } else if (id == 13 || id == 15) { //DNA文库/RNA文库
                    let that = this;
                    this.taskShowList.forEach(function (val, index) {
                        that.$set(that.taskShowList, index, true);
                    });
                    //样本提取/样本检测/文库构建不显示
                    for (let i = 0; i < 3; i++) {
                        that.$set(that.taskShowList, i, false);
                        if (that.jobs[i].selected) {
                            that.changeTaskStatus(i);
                        }
                    }
                } else if (id == 16) { //组织样本
                    let that = this;
                    this.taskShowList.forEach(function (val, index) {
                        that.$set(that.taskShowList, index, true);
                    });
                } else {
                    //核酸序列
                    let that = this;
                    this.taskShowList.forEach(function (val, index) {
                        that.$set(that.taskShowList, index, true);
                    });
                }
                /**
                 * 查询文库类型
                 */
                DataDict.get({
                    parentId: id,
                    type: 16
                }).then(response => {
                    if (response.code == 0) {
                        this.libraryTypeList = response.data;
                    }
                });

                DataDict.get({
                    parentId: id,
                    type: 5
                }).then(response => {
                    if (response.code == 0) {
                        this.sampleTypeList = response.data;
                    }
                });
            },
            /**
             * 样本提取-修改样本类别
             */
            extractChangeSampleCategory(){
                DataDict.get({
                    parentId: this.jobs[0].params.sampleCategory,
                    type: 5
                }).then(response => {
                    if (response.code == 0) {
                        this.extractSampleTypeList = response.data;
                    }
                });
                //查询文库类型
                DataDict.get({
                    parentId: this.jobs[0].params.sampleCategory,
                    type: 16
                }).then(response => {
                    if (response.code == 0) {
                        this.$set(this.jobs[2].params, "libraryType", null);
                        this.libraryTypeList = response.data;
                    }
                });
            },
            /**
             * 根据上机测序-测序平台查询测序策略
             */
            seqSeqPlatformChange(){
                let parentId = this.jobs[5].params.seqPlatform;
                let type = 14;
                DataDict.get({
                    parentId: parentId,
                    type: type
                }).then(response => {
                    if (response.code == 0) {
                        this.seqStrategyList = response.data;
                    }
                });
            }
        }
    };

</script>

<style lang="scss" scoped>
    @import "~styles/variable";

    .btn-group {
        padding-left: 10px;
        display: flex;
        align-items: center;
        margin-bottom: 22px;
    }

    .task-line-wrapper {
        position: absolute;
        left: 0;
        top: 30px;
        bottom: 50px;
        margin-left: -10px;
        box-sizing: border-box;
        width: 16.66%;
        text-align: center;

        .task-line {
            display: inline-block;
            width: 2px;
            height: 100%;
            background-color: $color-text-ll;
        }
    }

    .task-item-wrapper {
        margin: 15px 10px 15px -10px !important;
        &.disable {
            input, select {
                pointer-events: none;
            }
            .task-icon {
                fill: $color-theme-l !important;
            }
            .task-text {
                color: $color-theme-l !important;
            }
        }

        .task-icon-wrapper {
            text-align: center;
            position: relative;
            z-index: 10;
            background-color: #fff;
            padding: 10px;
            .task-icon {
                height: 60px;
                fill: $color-theme;
            }

            .task-text {
                color: $color-theme;
                font-size: 14px;
            }
        }

        .task-item-content {
            background-color: $color-text-lll;
            border-radius: 10px;
            padding-top: 22px;
            position: relative;
            &:after {
                color: white;
                content: '';
                position: absolute;
                width: 0;
                height: 0;
                border: 8px solid;
                border-right-color: $color-text-lll;
                top: 30px;
                left: -15px;
                z-index: 100;
            }
        }
    }

    .buttonWrapper {
        font-size: 12px;
        /**div居中*/
        display: -webkit-flex;
        -webkit-justify-content: center;
        -webkit-align-items: center;
        .confirm,
        .cancel {
            height: 36px;
            width: 76px;
            padding: 7px 15px;
            color: $color-red;
            border: 1px solid $color-red;
        }
        .confirm {
            height: 36px;
            color: $color-theme;
            border: 1px solid $color-theme;
        }
    }

    .editWrapper {
        float: right;
        margin-left: 10px;
        .edit {
            height: 36px;
            width: 76px;
            padding: 7px 15px;
            color: $color-theme;
            border: 1px solid $color-theme;
        }
    }
</style>
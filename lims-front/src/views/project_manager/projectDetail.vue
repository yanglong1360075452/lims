<template>
  <div class="container-wrap" style="height:100%;margin-top:7%">
    <div class="container-box">
      <div class="container-content">
        <el-row>
          <el-col :span="12" style="width:100%">
            <div style="margin: 20px;"></div>
            <div class="grid-content">
              <div style="margin-top:5%">
                <el-form :model="project" :inline="true" class="demo-form-inline" label-width="100px" :rules="projectRules" ref="project">
                  <el-form-item label="项目编号" prop="no">
                    <el-input placeholder="项目编号" v-model="project.no" style="width: 200px" :readonly="true"></el-input>
                  </el-form-item>
                  <el-form-item label="项目名称" prop="name">
                    <el-input placeholder="项目名称" v-model="project.name" style="width: 400px"></el-input>
                  </el-form-item>
                </el-form>
                <!--<el-button type="primary" v-show="updateShow">导入</el-button>-->
                <el-button type="primary" v-show="updateCancelShow" @click="cancel">取消</el-button>
                <el-button type="primary" v-show="saveShow" @click="save()">保存</el-button>
                <el-button type="primary" v-show="updateShow" @click="update()">编辑</el-button>
              </div>
              <br/>
              <h1>合同摘要：</h1>
              <div class="bac">
                <el-form :model="project" :inline="true" class="demo-form-inline" label-width="100px" :rules="contractRules" ref="contract">
                  <el-form-item label="合同编号" prop="contractNo">
                    <el-input placeholder="合同编号" v-model="project.contractNo" style="width: 200px"></el-input>
                  </el-form-item>
                  <el-form-item label="合同名称" prop="contractName">
                    <el-input placeholder="合同名称" v-model="project.contractName" style="width: 620px"></el-input>
                  </el-form-item>
                  <br/>
                  <el-form-item label="子合同编号">
                    <el-input placeholder="子合同编号" v-model="project.subContractNo" style="width: 200px"></el-input>
                  </el-form-item>
                  <el-form-item label="子合同名称">
                    <el-input placeholder="子合同名称" v-model="project.subContractName" style="width: 620px"></el-input>
                  </el-form-item>
                  <br/>
                  <el-form-item label="商机编号" prop="businessNo">
                    <el-input placeholder="商机编号" v-model="project.businessNo" style="width: 200px"></el-input>
                  </el-form-item>
                  <el-form-item label="临时合同">
                    <el-input placeholder="临时合同" v-model="project.tempContract" style="width: 620px"></el-input>
                  </el-form-item>
                  <br/>
                  <el-form-item label="客户代表" prop="customerRepresentative">
                    <el-input placeholder="客户代表" v-model="project.customerRepresentative" style="width: 200px"></el-input>
                  </el-form-item>
                  <el-form-item label="合同备注">
                    <el-input placeholder="合同备注" v-model="project.contractNote" style="width: 620px"></el-input>
                  </el-form-item>
                </el-form>
              </div>
              <br/>
              <h1>项目概要</h1>
              <div class="bac">
                <el-form :model="project" :inline="true" class="demo-form-inline" label-width="100px" :rules="summaryRules" ref="summary">
                  <el-form-item label="客户编号" prop="customerNo">
                    <el-input placeholder="客户编号" v-model="project.customerNo" style="width: 200px"></el-input>
                  </el-form-item>
                  <el-form-item label="客户单位" prop="customerUnit">
                    <el-input placeholder="客户单位" v-model="project.customerUnit" style="width: 620px"></el-input>
                  </el-form-item>
                  <br/>
                  <el-form-item label="客户姓名" prop="customerName">
                    <el-input placeholder="客户姓名" v-model="project.customerName" style="width: 200px"></el-input>
                  </el-form-item>
                  <el-form-item label="电话" prop="customerPhone">
                    <el-input placeholder="电话" v-model="project.customerPhone" style="width: 200px"></el-input>
                  </el-form-item>
                  <el-form-item label="Email" prop="customerEmail">
                    <el-input placeholder="Email" v-model="project.customerEmail" style="width: 307px"></el-input>
                  </el-form-item>
                  <br/>
                  <el-form-item label="项目类型" prop="projectType">
                    <el-select v-model="project.projectType" placeholder="请选择" :disabled="projectTypeDisabled">
                      <el-option v-for="item in projectTypeList" :key="item.id" :label="item.description" :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item label="优先级" prop="priority">
                    <el-select v-model="project.priority" placeholder="请选择" :disabled="priorityDisabled">
                      <el-option v-for="item in priorityList" :key="item.id" :label="item.description" :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item label="计划完成时间" style="margin-left: 40px;">
                    <el-date-picker
                      v-model="project.planCompleteTime"
                      type="date"
                      placeholder="选择日期"
                      :picker-options="pickerOptions0"
                      :readonly="planCompleteTimeDisabled"
                    >
                    </el-date-picker>
                  </el-form-item>
                  <br/>
                  <el-form-item label="特殊要求">
                    <el-input placeholder="特殊要求" v-model="project.specialRequire" style="width: 935px"></el-input>
                  </el-form-item>
                  <br/>
                  <el-form-item label="概要备注">
                    <el-input placeholder="概要备注" v-model="project.summaryNote" style="width: 935px"></el-input>
                  </el-form-item>
                </el-form>
              </div>
              <div class="bac1">
                <el-form :model="project" :rules="categoryRules" ref="category">
                  <el-form-item label="样本类别" prop="sampleCategory">
                    <el-select v-model="project.sampleCategory" placeholder="请选择" :disabled="sampleCategoryDisabled">
                      <el-option v-for="item in sampleCategoryList" :key="item.id" :label="item.description" :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item label="物种分类" prop="species">
                    <el-select v-model="project.species" placeholder="请选择" :disabled="speciesDisabled">
                      <el-option v-for="item in speciesList" :key="item.id" :label="item.description" :value="item.id">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-form>
              </div>
              <br/>
              <h1>工作内容</h1>
              <el-form :inline="true" :model="project" class="demo-form-inline" label-width="100px" ref="job">
                <el-form-item>
                  <div class="bac2">
                    <el-checkbox label="样本提取" @change="sampleExtractPitch" :disabled="sampleExtractDisabled" v-model="sampleExtractChecked">
                    </el-checkbox>
                    <el-form-item label="提取内容">
                      <el-select v-model="sampleExtract.params.extractContent" @change="extractContentChange" placeholder="请选择"
                                 :disabled="sampleExtractDisabled || !sampleExtractChecked">
                        <el-option v-for="item in extractContentList" :key="item.id" :label="item.description" :value="item.id">
                        </el-option>
                      </el-select>
                    </el-form-item>
                    <el-form-item label="提取方法">
                      <el-select v-model="sampleExtract.params.extractMethod" placeholder="请选择" :disabled="sampleExtractDisabled || !sampleExtractChecked">
                        <el-option v-for="item in extractMethodList" :key="item.id" :label="item.description" :value="item.id">
                        </el-option>
                      </el-select>
                    </el-form-item>
                  </div>
                  <br/>
                  <div class="bac3">
                    <el-checkbox label="样本检测" @change="sampleCheckPitch" :disabled="sampleCheckDisabled" v-model="sampleCheckChecked">
                    </el-checkbox>
                    <el-form-item label="检测方法:">
                      <el-checkbox-group v-model="sampleCheck.params.checkMethods">
                        <el-checkbox v-for="item in checkMethodsList" :label="item.id" :key="item.id" :disabled="sampleCheckDisabled || !sampleCheckChecked">
                          {{item.description}}
                        </el-checkbox>
                      </el-checkbox-group>
                    </el-form-item>
                  </div>
                  <br/>
                  <div class="bac3">
                    <el-checkbox label="文库构建" @change="libraryBuildPitch" :disabled="libraryBuildDisabled" v-model="libraryBuildChecked">
                    </el-checkbox>
                    <el-form-item label="测序平台:">
                      <el-select v-model="libraryBuild.params.seqPlatform" placeholder="请选择" :disabled="libraryBuildDisabled || !libraryBuildChecked">
                        <el-option v-for="item in seqPlatformList" :key="item.id" :label="item.description" :value="item.id">
                        </el-option>
                      </el-select>
                    </el-form-item>
                    <el-form-item label="文库类型:">
                      <el-select v-model="libraryBuild.params.libraryType" placeholder="请选择" :disabled="libraryBuildDisabled || !libraryBuildChecked">
                        <el-option v-for="item in libraryTypeList" :key="item.id" :label="item.description" :value="item.id">
                        </el-option>
                      </el-select>
                    </el-form-item>
                  </div>
                  <br/>
                  <div class="bac3">
                    <el-checkbox label="文库检测" @change="libraryCheckPitch" :disabled="libraryCheckDisabled" v-model="libraryCheckChecked">
                    </el-checkbox>
                    <el-form-item label="检测方法:">
                      <el-checkbox-group v-model="libraryCheck.params.checkMethods">
                        <el-checkbox v-for="wk in libraryCheckMethodList" :label="wk.id" :key="wk.id" :disabled="libraryCheckDisabled || !libraryCheckChecked">
                          {{wk.description}}
                        </el-checkbox>
                      </el-checkbox-group>
                    </el-form-item>
                  </div>

                  <br/>
                  <div class="bac3">
                    <el-checkbox label="文库定量" @change="libraryRationPitch" :disabled="libraryRationDisabled" v-model="libraryRationChecked">
                    </el-checkbox>
                    <el-form-item label="测序平台:">
                      <el-select v-model="libraryRation.params.seqPlatform" placeholder="请选择" :disabled="libraryRationDisabled || !libraryRationChecked">
                        <el-option v-for="item in seqPlatformList" :key="item.id" :label="item.description" :value="item.id">
                        </el-option>
                      </el-select>

                      <el-form-item label="试剂盒">
                        <el-select v-model="libraryRation.params.kit" placeholder="请选择" :disabled="libraryRationDisabled || !libraryRationChecked">
                          <el-option v-for="item in kitList" :key="item.id" :label="item.description" :value="item.id">
                          </el-option>
                        </el-select>
                      </el-form-item>
                    </el-form-item>
                  </div>
                  <br/>
                  <div class="bac3">
                    <el-checkbox label="上机测序" @change="sequencingPitch" :disabled="sequencingDisabled" v-model="sequencingChecked">
                    </el-checkbox>
                    <el-form-item label="测序平台:">
                      <el-select v-model="sequencing.params.seqPlatform" placeholder="请选择" :disabled="sequencingDisabled || !sequencingChecked">
                        <el-option v-for="item in seqPlatformList" :key="item.id" :label="item.description" :value="item.id">
                        </el-option>
                      </el-select>
                    </el-form-item>
                    <el-form-item label="测序策略:">
                      <el-select v-model="sequencing.params.seqStrategy" placeholder="请选择" :disabled="sequencingDisabled || !sequencingChecked">
                        <el-option v-for="item in seqPlatformList" :key="item.id" :label="item.description" :value="item.id">
                        </el-option>
                      </el-select>
                    </el-form-item>
                    <el-form-item label="数据量">
                      <el-input v-model="sequencing.params.dataAmount" placeholder="数据量" :disabled="sequencingDisabled || !sequencingChecked"></el-input>
                    </el-form-item>
                    <el-form-item label="数据量单位">
                      <el-select v-model="sequencing.params.dataAmountUnit" placeholder="请选择" :disabled="sequencingDisabled || !sequencingChecked">
                        <el-option v-for="item in dataAmountUnitList" :key="item.id" :label="item.description" :value="item.id">
                        </el-option>
                      </el-select>
                    </el-form-item>
                  </div>

                  <br/>
                  <div class="bac3">
                    <el-checkbox label="测序结果QC" @change="sequencingQCPitch" :disabled="sequencingQCDisabled" v-model="sequencingQCChecked"></el-checkbox>
                    <br/>
                  </div>
                  <div class="b4">
                    <el-checkbox label="生信分析" @change="letterAnalysisPitch" :disabled="letterAnalysisDisabled" v-model="letterAnalysisChecked">
                    </el-checkbox>
                    <br/>
                  </div>
                  <div class="b4">
                    <el-checkbox label="其它" @change="otherPitch" :disabled="otherDisabled" v-model="otherChecked"></el-checkbox>
                    <el-form-item label="说明">
                      <el-input v-model="other.params.description" placeholder="说明" style="width: 620px" :disabled="otherDisabled || !otherChecked"></el-input>
                    </el-form-item>
                  </div>

                  <br/>
                  <el-button type="primary" style="margin-left: 910px;" @click="cancel">取消</el-button>
                  <el-button type="primary" @click="save">保存</el-button>
                  <el-dialog
                    title="提示"
                    :visible.sync="dialogVisible"
                    size="tiny">
                    <span>{{edit == false?'项目创建完毕，是否添加样本？':'项目编辑完毕，是否编辑样本'}}</span>
                    <span slot="footer" class="dialog-footer">
                <router-link
                  :to="{ name: 'sample',params:  {id: project.id,sampleCategory:project.sampleCategory,species:project.species}}">
                  <el-button type="primary">{{edit == false ? '添加样本' : '编辑样本'}}</el-button>
                </router-link>
                <router-link :to="{name:'projects'}">
                  <el-button type="primary">返回项目列表</el-button>
                </router-link>
                  <el-button type="primary" @click="dialogVisible = false">留在详情页</el-button>
              </span>
                  </el-dialog>
                </el-form-item>
              </el-form>
            </div>
          </el-col>
        </el-row>
      </div>
    </div>
  </div>
</template>
<script>
  import Util from '../../assets/lib/util';
  import store from '../../store/index'
  import ProjectService from '../../service/project';
  import DataDictService from '../../service/dataDict';
  import ElCheckboxGroup from "../../../node_modules/element-ui/packages/checkbox/src/checkbox-group";
  export default {
    components: {ElCheckboxGroup},
    data() {
      return {
        edit : false,
        dialogVisible: false,//弹框
        typeArray: [{type: 1}, {type: 2}, {type: 3}, {type: 4}, {type: 7}, {type: 9}, {type: 10}, {type: 13}, {type: 15}],
        project: { //项目信息model
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
          projectType: null,
          priority: null,
          name: null,
          planCompleteTime: null,
          specialRequire: null,
          summaryNote: null,
          sampleCategory: null,
          species: null,
          jobs: []
        },
        sampleExtract: {
          type: 1,
          params: {
            extractContent: null,
            extractMethod: null
          }
        },
        sampleCheck: {
          type: 2,
          params: {
            checkMethods: []
          }
        },
        libraryBuild: {
          type: 3,
          params: {
            seqPlatform: null,
            libraryType: null
          }
        },
        libraryCheck: {
          type: 4,
          params: {
            checkMethods: []
          }
        },
        libraryRation: {
          type: 5,
          params: {
            seqPlatform: null,
            kit: null
          }
        },
        sequencing: {
          type: 6,
          params: {
            seqPlatform: null,
            seqStrategy: null,
            dataAmount: null,
            dataAmountUnit: null
          }
        },
        sequencingQC: {
          type: 7,
          params: {}
        },
        letterAnalysis: {
          type: 8,
          params: {}
        },
        other: {
          type: 9,
          params: {
            description: null
          }
        },
        //下拉框数据存放集合
        projectTypeList: [],
        priorityList: [],
        sampleCategoryList: [],
        speciesList: [],
        extractContentList: [],
        extractMethodList: [],
        checkMethodsList: [],
        libraryTypeList: [],
        libraryCheckMethodList: [],
        seqPlatformList: [],
        dataAmountUnitList: [],
        kitList: [],
        id: null,
        updateShow: false,
        saveShow: true,
        updateCancelShow: false,
        sampleExtractChecked: false,
        sampleCheckChecked: false,
        libraryBuildChecked: false,
        libraryCheckChecked: false,
        libraryRationChecked: false,
        sequencingChecked: false,
        sequencingQCChecked: false,
        letterAnalysisChecked: false,
        otherChecked: false,
        sampleExtractDisabled: false,
        sampleCheckDisabled: false,
        libraryBuildDisabled: false,
        libraryCheckDisabled: false,
        libraryRationDisabled: false,
        sequencingDisabled: false,
        sequencingQCDisabled: false,
        letterAnalysisDisabled: false,
        otherDisabled: false,
        projectTypeDisabled: false,
        priorityDisabled: false,
        sampleCategoryDisabled: false,
        speciesDisabled: false,
        planCompleteTimeDisabled: false,
        pickerOptions0: {
          disabledDate(time) {
            return time.getTime() < Date.now() - 8.64e7;
          }
        },
        time: '',
        projectRules: {
          name: [
            {required: true, message: '请输入项目名称', trigger: 'blur'}
          ]
        },
        contractRules: {
          contractNo: [
            {required: true, message: '请输入合同编号', trigger: 'blur'}
          ],
          contractName: [
            {required: true, message: '请输入合同名称', trigger: 'blur'}
          ],
          businessNo: [
            {required: true, message: '请输入商机编号', trigger: 'blur'}
          ],
          customerRepresentative: [
            {required: true, message: '请输入客户代表', trigger: 'blur'}
          ],
        },
        summaryRules: {
          customerNo: [
            {required: true, message: '请输入客户编号', trigger: 'blur'}
          ],
          customerUnit: [
            {required: true, message: '请输入客户单位', trigger: 'blur'}
          ],
          customerName: [
            {required: true, message: '请输入客户姓名', trigger: 'blur'}
          ],
          customerEmail: [
            {required: true, message: '请输入Email', trigger: 'blur'}
          ],
          customerPhone: [
            {required: true, message: '请输入电话', trigger: 'blur'}
          ],
          projectType: [
            {type: 'number', required: true, message: '请选择项目类型', trigger: 'change'}
          ],
          priority: [
            {type: 'number', required: true, message: '请选择优先级', trigger: 'change'}
          ]
        },
        categoryRules: {
          sampleCategory: [
            {type: 'number', required: true, message: '请选择样本类别', trigger: 'change'}
          ],
          species: [
            {type: 'number', required: true, message: '请选择物种', trigger: 'change'}
          ]
        }
      }
    },
    mounted () {
      var id = null;
      var secondParentId = null;
      for (let i = 0; i < this.typeArray.length; i++) {
        this.getDict(id, secondParentId, this.typeArray[i].type);
      }
      this.project.id = this.$route.params.id;
      if (this.project.id != null) {
        this.getProject();
        var input = document.getElementsByTagName("input");
        for (var i = 0; i < input.length; i++) {
          input[i].readOnly = true;
        }
        this.updateShow = true;
        this.saveShow = false;
        this.edit = true;
      } else {
        this.updateShow = false;
        this.saveShow = true;
      }
    },
    methods: {
      cancel(){
        if (this.project.id != null) {
          this.getProject();
          var input = document.getElementsByTagName("input");
          for (var i = 0; i < input.length; i++) {
            input[i].readOnly = true;
          }
          this.updateShow = true;
          this.saveShow = false;
          this.sampleExtractDisabled = true;
          this.sampleCheckDisabled = true;
          this.libraryBuildDisabled = true;
          this.libraryCheckDisabled = true;
          this.libraryRationDisabled = true;
          this.sequencingDisabled = true;
          this.otherDisabled = true;
          this.letterAnalysisDisabled = true;
          this.sequencingQCDisabled = true;
          this.projectTypeDisabled = true,
          this.priorityDisabled = true,
          this.sampleCategoryDisabled = true,
          this.speciesDisabled = true,
          this.planCompleteTimeDisabled = true
        }
      },
      update(){
        var input = document.getElementsByTagName("input");
        for (var i = 0; i < input.length; i++) {
          if (input[i].placeholder != "项目编号") {
            input[i].readOnly = false;
          }
        }
        this.updateShow = false;
        this.updateCancelShow = true;
        this.saveShow = true;
        this.sampleExtractDisabled = false;
        this.sampleCheckDisabled = false;
        this.libraryBuildDisabled = false;
        this.libraryCheckDisabled = false;
        this.libraryRationDisabled = false;
        this.sequencingDisabled = false;
        this.sequencingQCDisabled = false;
        this.letterAnalysisDisabled = false;
        this.otherDisabled = false;
        this.projectTypeDisabled = false,
        this.priorityDisabled = false,
        this.sampleCategoryDisabled = false,
        this.speciesDisabled = false,
        this.planCompleteTimeDisabled = false
      },
      getProject(){
        let that = this;
        if (that.project.id != null) {
          ProjectService.get(that.project.id).then(function (response) {
            if (response.code == 0) {
              that.project = response.data;
              that.$store.commit("setProjectNo",that.project.no);
              var jobs = that.project.jobs;
              that.sampleExtractDisabled = true;
              that.sampleCheckDisabled = true;
              that.libraryBuildDisabled = true;
              that.libraryCheckDisabled = true;
              that.libraryRationDisabled = true;
              that.sequencingDisabled = true;
              that.sequencingQCDisabled = true;
              that.letterAnalysisDisabled = true;
              that.otherDisabled = true;
              that.projectTypeDisabled = true;
              that.priorityDisabled = true;
              that.sampleCategoryDisabled = true;
              that.speciesDisabled = true;
              that.planCompleteTimeDisabled = true;
              for (var i = 0; i < jobs.length; i++) {
                var job = jobs[i];
                var type = job.type;
                if (type == that.sampleExtract.type) {
                  that.sampleExtractChecked = true;
                  that.sampleExtract.params.extractMethod = job.params.extractMethod;
                  that.sampleExtract.params.extractContent = job.params.extractContent;
                } else if (type == that.sampleCheck.type) {
                  that.sampleCheckChecked = true;
                  that.sampleCheck.params.checkMethods = job.params.checkMethods;
                } else if (type == that.libraryBuild.type) {
                  that.libraryBuildChecked = true;
                  that.libraryBuild.params.seqPlatform = job.params.seqPlatform;
                  that.libraryBuild.params.libraryType = job.params.libraryType;
                } else if (type == that.libraryCheck.type) {
                  that.libraryCheckChecked = true;
                  that.libraryCheck.params.checkMethods = job.params.checkMethods;
                } else if (type == that.libraryRation.type) {
                  that.libraryRationChecked = true;
                  that.libraryRation.params.seqPlatform = job.params.seqPlatform;
                  that.libraryRation.params.kit = job.params.kit;
                } else if (type == that.sequencing.type) {
                  that.sequencingChecked = true;
                  that.sequencing.params.seqPlatform = job.params.seqPlatform;
                  that.sequencing.params.seqStrategy = job.params.seqStrategy;
                  that.sequencing.params.dataAmount = job.params.dataAmount;
                  that.sequencing.params.dataAmountUnit = job.params.dataAmountUnit;
                } else if (type == that.sequencingQC.type) {
                  that.sequencingQCChecked = true;
                } else if (type == that.letterAnalysis.type) {
                  that.letterAnalysisChecked = true;
                } else if (type == that.other.type) {
                  that.otherChecked = true;
                  that.other.params.description = job.params.description;
                }
              }
            }
          });
        }
      },
      getDict(id, secondParentId, type){
        let that = this;
        DataDictService.get({
          parentId: id,
          secondParentId: secondParentId,
          type: type
        }).then(function (response) {
          if (response.code == 0) {
            if (type == "4") {
              that.sampleCategoryList = response.data;
            } else if (type == "3") {
              that.speciesList = response.data;
            } else if (type == "1") {
              that.projectTypeList = response.data;
            } else if (type == "2") {
              that.priorityList = response.data;
            } else if (type == "7") {
              that.extractContentList = response.data;
            } else if (type == "9") {
              that.checkMethodsList = response.data;
            } else if (type == "10") {
              that.libraryCheckMethodList = response.data;
            } else if (type == "13") {
              that.seqPlatformList = response.data;
            } else if (type == "15") {
              that.dataAmountUnitList = response.data;
            } else if (id != null && secondParentId != null) {
              that.extractMethodList = response.data;
            } else if (type == "8") {
              that.extractMethodList = response.data;
            }
          }
        });
      },
      extractContentChange(){
        //联动查询数据
        let secondParentId = this.project.species;
        let id = this.sampleExtract.params.extractContent;
        let type = "8";
        this.getDict(id, secondParentId, type);
      },
      save(){
        var verify = true;
        if (this.$refs["project"] != undefined) {
          this.$refs["project"].validate((valid) => {
            if (valid) {
              this.$refs["contract"].validate((valid) => {
                if (valid) {
                  this.$refs["summary"].validate((valid) => {
                    if (valid) {
                      this.$refs["category"].validate((valid) => {
                        if (valid) {
                          verify = true;
                        } else {
                          verify = false;
                          return;
                        }
                      });
                    } else {
                      verify = false;
                      return;
                    }
                  });
                } else {
                  verify = false;
                  return;
                }
              });
            } else {
              verify = false;
            }
          });
          if (verify) {
            if (this.project.jobs == null || this.project.jobs.length <= 0) {
              this.$message({type: 'info', message: '请选择工作内容'});
            } else {
              if (this.project.planCompleteTime != null) {
                this.project.planCompleteTime = Util.dateUtil.dateFormatNewDate(this.project.planCompleteTime);
              }
              let that = this;
              if (that.project.id == null) {
                ProjectService.create(that.project).then(function (response) {
                  if (response.code == 0) {
                    that.$message({type: 'success', message: '创建项目成功'});
                    that.project.id = response.data;
                    that.dialogVisible = true;
                  } else {
                    that.$message({type: 'success', message: '创建项目失败'});
                  }
                });
              } else {
                ProjectService.update(that.project).then(function (response) {
                  if (response.code == 0) {
                    that.$message({type: 'success', message: '更新项目成功'});
                    that.dialogVisible = true;
                  } else {
                    that.$message({type: 'success', message: '更新项目失败'});
                  }
                });
              }
            }
          } else {
            this.$message({type: 'info', message: '请完善项目信息'});
          }
        }
      },
      sampleExtractPitch(){
        if (this.sampleExtractChecked) {
          this.project.jobs.push(this.sampleExtract);
        } else {
          for (var i = 0; i < this.project.jobs.length; i++) {
            if (this.project.jobs[i].type = this.sampleExtract.type) {
              this.project.jobs.splice(this.project.jobs[i]);
              if (this.project.id == null) {
                this.sampleExtract.params.extractContent = null;
                this.sampleExtract.params.extractMethod = null;
              }
            }
          }
        }
      },
      sampleCheckPitch(){
        if (this.sampleCheckChecked) {
          this.project.jobs.push(this.sampleCheck);
        } else {
          for (var i = 0; i < this.project.jobs.length; i++) {
            if (this.project.jobs[i].type = this.sampleCheck.type) {
              this.project.jobs.splice(this.project.jobs[i]);
            }
          }
        }
      },
      libraryBuildPitch(){
        if (this.libraryBuildChecked) {
          this.project.jobs.push(this.libraryBuild);
        } else {
          for (var i = 0; i < this.project.jobs.length; i++) {
            if (this.project.jobs[i].type = this.libraryBuild.type) {
              this.project.jobs.splice(this.project.jobs[i]);
            }
          }
        }
      },
      libraryCheckPitch(){
        if (this.libraryCheckChecked) {
          this.project.jobs.push(this.libraryCheck);
        } else {
          for (var i = 0; i < this.project.jobs.length; i++) {
            if (this.project.jobs[i].type = this.libraryCheck.type) {
              this.project.jobs.splice(this.project.jobs[i]);
            }
          }
        }
      },
      libraryRationPitch(){
        if (this.libraryRationChecked) {
          this.project.jobs.push(this.libraryRation);
        } else {
          for (var i = 0; i < this.project.jobs.length; i++) {
            if (this.project.jobs[i].type = this.libraryRation.type) {
              this.project.jobs.splice(this.project.jobs[i]);
            }
          }
        }
      },
      sequencingPitch(){
        if (this.sequencingChecked) {
          this.project.jobs.push(this.sequencing);
        } else {
          for (var i = 0; i < this.project.jobs.length; i++) {
            if (this.project.jobs[i].type = this.sequencing.type) {
              this.project.jobs.splice(this.project.jobs[i]);
            }
          }
        }
      },
      sequencingQCPitch(){
        if (this.sequencingQCChecked) {
          this.project.jobs.push(this.sequencingQC);
        } else {
          for (var i = 0; i < this.project.jobs.length; i++) {
            if (this.project.jobs[i].type = this.sequencingQC.type) {
              this.project.jobs.splice(this.project.jobs[i]);
            }
          }
        }
      },
      letterAnalysisPitch(){
        if (this.letterAnalysisChecked) {
          this.project.jobs.push(this.letterAnalysis);
        } else {
          for (var i = 0; i < this.project.jobs.length; i++) {
            if (this.project.jobs[i].type = this.letterAnalysis.type) {
              this.project.jobs.splice(this.project.jobs[i]);
            }
          }
        }
      },
      otherPitch(){
        if (this.otherChecked) {
          this.project.jobs.push(this.other);
        } else {
          for (var i = 0; i < this.project.jobs.length; i++) {
            if (this.project.jobs[i].type = this.other.type) {
              this.project.jobs.splice(this.project.jobs[i]);
            }
          }
        }
      }
    }

  }
</script>

<style>
  .bac {
    background: #F2F2F2;
    width: 63%;
  }

  .bac1 {
    background: #F2F2F2;
    width: 63%;
    margin-top: 10px
  }

  .bac2 {
    background: #F2F2F2;
    width: 100%
  }

  .bac3 {
    background: #F2F2F2;
    margin-top: -10px;
  }

  .bac4 {
    background: #F2F2F2;
    margin-top: 20px;
  }
</style>

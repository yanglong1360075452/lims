<template>
    <div>
        <page-label title="检测执行" sub-title="RNA样本检测" icon="detection"></page-label>
        <div class="group">
            <el-row type="flex" justify="space-between">
                <el-col>
                    <span class="taskList">任务单名称：</span><span class="taskContent">{{taskData.name}}</span>
                </el-col>
                <el-col>
                    <span class="taskList">任务单编号：</span><span class="taskContent">{{taskData.number}}</span>
                </el-col>
                <el-col>
                    <span class="taskList">任务单类型：</span><span class="taskContent">{{taskData.type}}</span>
                </el-col>
                <el-col>
                    <span class="taskList">任务单开始时间：</span><span class="taskContent">{{taskData.startTime}}</span>
                </el-col>
                <el-col>
                    <span class="taskList">预计束时间：</span><span class="taskContent">{{taskData.name}}</span>
                </el-col>
            </el-row>
            <p class="hr"></p>
            <el-steps :active="active" finish-status="success">
                <el-step title="开始"></el-step>
                <el-step title="出库"></el-step>
                <el-step title="步骤 3"></el-step>
                <el-step title="步骤 4"></el-step>
                <el-step title="步骤 5"></el-step>
                <el-step title="步骤 6"></el-step>
                <el-step title="步骤 7"></el-step>
                <el-step title="步骤 8"></el-step>
                <el-step title="步骤 9"></el-step>
                <el-step title="步骤 10"></el-step>
                <el-step title="步骤 11"></el-step>
                <el-step title="Anglient"></el-step>
                <el-step title="样品质量"></el-step>
            </el-steps>
        </div>
        <div>
            <el-row :gutter="20">
                <el-col :span="16">
                    <el-tabs v-model="activeName1" type="card">
                        <el-tab-pane label="实验操作" name="first">
                            <div class="form-group-title">步骤一</div>
                            <el-form ref="stepOne" :model="stepOne" label-position="right" label-width="120px">
                                <el-row>
                                    <el-col>
                                        <el-form-item label="试剂盒">
                                            <el-select placeholder="请选择" v-model="stepOne.kit" class="selectWidth">
                                                <el-option label="试剂盒" value="1"></el-option>
                                            </el-select>
                                        </el-form-item>
                                    </el-col>
                                </el-row>
                                <el-row :gutter="20">
                                    <el-col :span="22">
                                        <el-form-item label="运行程序模板">
                                            <el-select placeholder="请选择" v-model="stepOne.produceTempl" class="selectWidth offSel">
                                                <el-option label="运行程序模板" value="1"></el-option>
                                            </el-select>
                                        </el-form-item>
                                    </el-col>
                                    <el-col :span="2">
                                        <el-button type="primary"class="submitSoft">提交到2100软件</el-button>
                                    </el-col>
                                </el-row>
                            </el-form>
                            <p class="hr"></p>
                            <el-row type="flex" align="middle">
                                <el-col :span="4">
                                    <div class="form-group-title">步骤二</div>
                                </el-col>
                                <el-col :span="20">
                                    <el-button type="primary" v-show="!stepSecond.isSelect" @click.native="selectChips()">选择芯片孔位</el-button>
                                    <div class="chipsButtonWrap" v-show="stepSecond.isSelect">
                                        <el-button @click="deleteChips()" class="deleteChips">删除芯片</el-button>
                                        <el-button @click="addChips()" class="addChips">添加芯片</el-button>
                                    </div>
                                </el-col>
                            </el-row>
                            <el-dialog title="芯片型号" :visible.sync="stepSecond.dialogTableVisible" :before-close="handleClose">
                                 <!-- <div class="form-group-title dialogTitle">芯片型号<span>RNA12342</span></div> -->
                                <el-table :data="stepSecond.gridData" @selection-change="handleSelectionChange" border height="440">
                                    <el-table-column type="selection" width="55"></el-table-column>
                                    <el-table-column property="queueNumber" label="芯片序列号" width="150"></el-table-column>
                                    <el-table-column property="use" label="已使用孔位数" width="200"></el-table-column>
                                    <el-table-column property="unuse" label="未使用孔位数"></el-table-column>
                                    <el-table-column property="projectId" label="项目ID"></el-table-column>
                                </el-table>
                                <div slot="footer" class="dialog-footer">
                                    <span class="selectText">已选中<span>{{stepSecond.multipleSelection.length}}</span>个芯片共有<span>{{stepSecond.totalHoles}}</span>个孔位</span>
                                    <el-button type="primary" @click.native="dialogConfirm()">确 定</el-button>
                                </div>
                            </el-dialog>
                            <el-row :gutter="20" v-show="stepSecond.isSelect" class="haveSelectTable">
                                <el-col :span="10">
                                    <holes-picture :data="stepSecond.chipTrData"></holes-picture>
                                    <!-- <div class="img-wrap">
                                        <div class="circle-wrap">
                                        <div v-for="hole in stepSecond.chipTrData.holeList" class="circle" :class="{'unuse':hole.state === 1,'use':hole.state === 2,'forbidden':hole.state === 3,'add':hole.state === 4}"></div>
                                        </div>
                                    </div> -->
                                    <p class="image-title">芯片序列号: {{stepSecond.chipPicCon}}示意图</p>
                                </el-col>
                                <el-col :span="14">
                                    <el-table :data="stepSecond.multipleSelection" :row-class-name="tableRowClassName" @selection-change="chipSelectionChange" @row-click="chipsChange" border height="260">
                                        <el-table-column type="selection"></el-table-column>
                                        <el-table-column property="queueNumber" label="芯片序列号"></el-table-column>
                                        <el-table-column property="use" label="已使用孔位数"></el-table-column>
                                        <el-table-column property="unuse" label="未使用孔位数"></el-table-column>
                                    </el-table>
                                    <p class="remain">剩余<span>{{stepSecond.tableCheckHoles}}</span>芯片空位</p>
                                </el-col>
                            </el-row>
                            <p class="hr"></p>
                            <el-row type="flex" align="middle" justify="space-around" class="stepThree">
                                <el-col :span="18">
                                    <div class="form-group-title">步骤三</div>
                                </el-col>
                                <el-col :span="6">
                                    <el-button type="primary" icon="document" class="printList">打印上样清单</el-button>
                                </el-col>
                            </el-row>
                            <el-table :data="stepThird.tableDataList" @selection-change="chipSelectionChange" border>
                                <el-table-column property="id" label="样本ID"></el-table-column>
                                <el-table-column property="name" label="样本名称"></el-table-column>
                                <el-table-column property="diluentVolumn" label="稀释液体积(计算)"></el-table-column>
                                <el-table-column property="originalVolumn" label="原液体积(计算)"></el-table-column>
                                <el-table-column property="member" label="样品负责"></el-table-column>
                                <el-table-column property="holeId" label="孔位"></el-table-column>
                                <el-table-column property="queueNumber" label="芯片序列号"></el-table-column>
                            </el-table>
                            <el-row type="fix" align="middle" style="margin-top: 20px">
                                <el-col :span="8">
                                    <el-button @click="chipsSort()">芯片排位</el-button>
                                    <el-button @click="clearSort()">清除排位</el-button>
                                </el-col>
                                <el-col :span="16">
                                    <el-pagination
                                        @size-change="handleSizeChange"
                                        @current-change="handleCurrentChange"
                                        :current-page.sync="stepThird.currentPage"
                                        :page-size="100"
                                        layout="prev, pager, next, jumper"
                                        :total="1000">
                                    </el-pagination>
                                </el-col>
                            </el-row>
                        </el-tab-pane>
                        <el-tab-pane label="RNA样品检测报告" name="second">
                            RNA样品检测报告
                        </el-tab-pane>
                    </el-tabs>
                    <div class="footer">
                        <p class="next">下一步</p>
                        <p class="back">上一步</p>
                    </div>
                </el-col>
                <el-col :span="8">
                    <el-tabs v-model="activeName2" type="card">
                        <el-tab-pane label="RNA样品检测SOP" name="first">
                            <div class="rightTitle">二、样品检测</div>
                            <p class="content warn">注：1. 为避免操作过程中外源RNA酶会使样品降解，请在样品检测前佩戴好一次性口罩及手套，避免直接用手接触枪头，EP管等实验耗材，请检查实验台面及相应的实验用具是否干净，避免样品外来污染或样品之间的交叉污染！</p>
                            <p class="content">2. RNA样品检测应全程使用DEPC水及无核酸酶枪头。</p>
                            <p class="content">1.样品的Qubit定量</p>
                            <p class="content">1)将RNA样品取出后于室温融化，当样品融化后轻弹EP管，使管内的样品混合均匀，在4℃离心机瞬离后立即将样品转移到冰上，避免样品长时间室温放置；</p>
                            <p class="content">注：样品混匀后一定要及时瞬离，使样品落回管底瞬离转速小于5000rpm。</p>
                            <p class="content">2)     样品信息确认无误后，取出与样品数量相当的新的1.5mL EP管，做好按照样品编号做好标记；</p>

                            <p class="content">3)     根据样品信息单上的样品浓度，在新的1.5mL离心管中对样品进行稀释（DEPC H2O），终浓度100ng/μL左右，稀释后的体积大于5μL，若样品信息单未标明样品浓度，则对样品统一进行10倍稀释，将样品稀释液振荡混匀，瞬时离心10s后置于冰上备用；</p>
                            <p class="content">4)     使用Qubit® RNA Assay Kit对样品稀释液进行浓度测定，具体实验步骤如下：</p>
                            <p class="content">注：1. Qubit® RNA Assay Kit试剂存放于4℃，使用前应提前取出平衡至室温，Qubit® RNA HS Reagent应完全融解；</p>
                            <p class="content">2.     Qubit® RNA HS Reagent在整个检测过程中应注意避光保存；</p>
                            <p class="content">3.     新包装的0.5mL离心管在使用前，应用Qubit® RNA Assay Kit中的标准液恔准，并在离心管包装外注明“已标定”。</p>
                            <p class="content">a)     取出新的0.5mL离心管，按照样品名称做好标记；</p>
                            <p class="content">b)     工作液的配制（终体积200μL）：依次在离心管中加入198μL已平衡至室温的Qubit® RNA HS Buffer ，1μL Qubit® RNA HS Reagent（200倍稀释），避光放置于EP管架上；</p>
                        </el-tab-pane>
                    </el-tabs>
                </el-col>
            </el-row>
        </div>

    </div>
</template>

<script>
    import PageLabel from 'components/pageLabel'
    import ElCol from "element-ui/packages/col/src/col";
    import HolesPicture from "./modal/holes";

    export default {
        name: 'index',
        components: {
            ElCol,
            PageLabel,
            HolesPicture
        },
        beforeCreate() {
            this.temp = [];
            this.stepThirdTemp = []; 
        },
        mounted(){
            this.handleData(this.stepSecond.gridData);  //弹框数据处理
        },
        data() {
            return {
                temp:[],
                activeName1: "first",
                activeName2: "first",
                taskData: {
                    name: "07-mc-35-md",
                    number: "BN-16-OD-78",
                    type: "RNA样本检测",
                    startTime: "2016-11-13",
                    startTime: "2016-11-14"
                },
                active: 6,
                stepOne: {
                    kit: '',
                    produceTempl: ''
                },
                stepSecond: {
                    isSelect: false,
                    dialogTableVisible: false,
                    gridData: [{
                      queueNumber: '20170731',
                      projectId: '111111',
                      holeList:[{
                        id: 1,
                        state: 1,       //1:未使用;2:已使用;3:禁用;4:新插入
                        sample: {}
                      },{
                        id: 2,
                        state: 2,
                        sample: {}
                      },{
                        id: 3,
                        state: 2,
                        sample: {}
                      },{
                        id: 4,
                        state: 3,
                        sample: {}
                      },{
                        id: 5,
                        state: 1,
                        sample: {}
                      },{
                        id: 6,
                        state: 3,
                        sample: {}
                      },{
                        id: 7,
                        state: 3,
                        sample: {}
                      },{
                        id: 8,
                        state: 1,
                        sample: {}
                      },{
                        id: 9,
                        state: 1,
                        sample: {}
                      },{
                        id: 10,
                        state: 1,
                        sample: {}
                      },{
                        id: 11,
                        state: 2,
                        sample: {}
                      },{
                        id: 12,
                        state: 2,
                        sample: {}
                      },{
                        id: 13,
                        state: 2,
                        sample: {}
                      },{
                        id: 14,
                        state: 2,
                        sample: {}
                      },{
                        id: 15,
                        state: 2,
                        sample: {}
                      },{
                        id: 16,
                        state: 3,
                        sample: {}
                      }]
                    },{
                      queueNumber: '20170801',
                      projectId: '222222',
                      holeList:[{
                        id: 1,
                        state: 1,       //1:未使用;2:已使用;3:禁用;4:新插入
                        sample: {}
                      },{
                        id: 2,
                        state: 2,
                        sample: {}
                      },{
                        id: 3,
                        state: 2,
                        sample: {}
                      },{
                        id: 4,
                        state: 1,
                        sample: {}
                      },{
                        id: 5,
                        state: 3,
                        sample: {}
                      },{
                        id: 6,
                        state: 2,
                        sample: {}
                      },{
                        id: 7,
                        state: 3,
                        sample: {}
                      },{
                        id: 8,
                        state: 1,
                        sample: {}
                      },{
                        id: 9,
                        state: 1,
                        sample: {}
                      },{
                        id: 10,
                        state: 1,
                        sample: {}
                      },{
                        id: 11,
                        state: 3,
                        sample: {}
                      },{
                        id: 12,
                        state: 2,
                        sample: {}
                      },{
                        id: 13,
                        state: 2,
                        sample: {}
                      },{
                        id: 14,
                        state: 2,
                        sample: {}
                      },{
                        id: 15,
                        state: 3,
                        sample: {}
                      },{
                        id: 16,
                        state: 2,
                        sample: {}
                      }]
                    },{
                      queueNumber: '20170802',
                      projectId: '333333',
                      holeList:[{
                        id: 1,
                        state: 1,       //1:未使用;2:已使用;3:禁用;4:新插入
                        sample: {}
                      },{
                        id: 2,
                        state: 2,
                        sample: {}
                      },{
                        id: 3,
                        state: 2,
                        sample: {}
                      },{
                        id: 4,
                        state: 3,
                        sample: {}
                      },{
                        id: 5,
                        state: 3,
                        sample: {}
                      },{
                        id: 6,
                        state: 3,
                        sample: {}
                      },{
                        id: 7,
                        state: 3,
                        sample: {}
                      },{
                        id: 8,
                        state: 1,
                        sample: {}
                      },{
                        id: 9,
                        state: 1,
                        sample: {}
                      },{
                        id: 10,
                        state: 1,
                        sample: {}
                      },{
                        id: 11,
                        state: 2,
                        sample: {}
                      },{
                        id: 12,
                        state: 2,
                        sample: {}
                      },{
                        id: 13,
                        state: 1,
                        sample: {}
                      },{
                        id: 14,
                        state: 2,
                        sample: {}
                      },{
                        id: 15,
                        state: 1,
                        sample: {}
                      },{
                        id: 16,
                        state: 1,
                        sample: {}
                      }]
                    }],
                    multipleSelection: [],    //弹框表格选中值
                    totalHoles: 0,            //已选中芯片未使用孔位总数
                    tableCheckedVal: [],       //表格选中值
                    tableCheckHoles: 0,
                    chipPicCon: '',      //选中芯片序列号
                    chipTrData: {}
                     
                },
                stepThird: {
                    tableDataList: [{
                        id: '111',
                        name: '甲状腺组织',
                        diluentVolumn: '1.38',
                        originalVolumn: '1.38',
                        member: '张静',
                        hole: '',
                        queueNumber: ''
                    },{
                        id: '112',
                        name: '甲状腺组织',
                        diluentVolumn: '1.38',
                        originalVolumn: '1.38',
                        member: '张静',
                        hole: '',
                        queueNumber: ''
                    },{
                        id: '113',
                        name: '甲状腺组织',
                        diluentVolumn: '1.38',
                        originalVolumn: '1.38',
                        member: '张静',
                        hole: '',
                        queueNumber: ''
                    }],
                    resetUnuse: [],
                    currentPage: 1
                }
            }
        },
        methods: {
            // 弹框数据处理
            handleData(list){
                // 数据插入属性
                for (var i = 0; i < list.length; i++) {
                    list[i].unuse = list[i].holeList.filter(item => {return item.state == 1}).length;
                    list[i].use = list[i].holeList.filter(item => {return item.state == 2}).length;
                }
                this.stepSecond.chipPicCon = list[0].queueNumber;
            },
            // 选择芯片孔位
            selectChips() {
                
                this.stepSecond.dialogTableVisible=true
            },
            // 弹出框全选
            handleSelectionChange(val) {
                this.stepSecond.multipleSelection = val;
                let len = 0;
                val.forEach(item => {
                    len += item.unuse;
                });
                this.stepSecond.totalHoles = len;
            },
            // 弹框确定按钮
            dialogConfirm(){
                let len = 0;
                this.stepSecond.multipleSelection.forEach(item => {
                    len += item.unuse;
                });
                this.stepSecond.tableCheckHoles = len;

                this.stepSecond.isSelect = true;
                this.stepSecond.dialogTableVisible = false;
                this.stepSecond.chipTrData = this.stepSecond.multipleSelection[0];

            },
            // 关闭弹窗
            handleClose() {
                this.stepSecond.multipleSelection = this.temp;
                this.stepSecond.dialogTableVisible = false;
            },
            // 芯片选择
            chipSelectionChange(val){
                this.stepSecond.tableCheckedVal = val;
            },
            // 表格选中行
            tableRowClassName(row, index) {
                if (row.queueNumber == this.stepSecond.chipPicCon) {
                  return 'chipsTrStyle';
                }
                return '';
            },
            // 芯片图片切换
            chipsChange(val) {
                this.stepSecond.chipPicCon = val.queueNumber;  //图片底部标题
                this.stepSecond.chipTrData = val;
            },
            // 添加芯片
            addChips(){
                this.temp = JSON.parse(JSON.stringify(this.stepSecond.multipleSelection));
                let len = 0;
                this.temp.forEach(item => {
                    len += item.unuse;
                });
                this.stepSecond.totalHoles = len;

                this.stepSecond.dialogTableVisible=true;
            },
            // 删除芯片
            deleteChips(){

                if(this.stepSecond.tableCheckedVal.length == 0) {
                    this.$alert("请选择芯片");
                    return ;
                }
                for(var i = 0; i < this.stepSecond.multipleSelection.length; i++){
                    for (var j = 0; j < this.stepSecond.tableCheckedVal.length; j++) {
                        if(this.stepSecond.multipleSelection[i].projectId == this.stepSecond.tableCheckedVal[j].projectId){
                            this.stepSecond.multipleSelection.splice(i,1);
                        }
                    }
                }
                let len = 0;
                this.stepSecond.multipleSelection.forEach(item => {
                    len += item.unuse;
                });
                this.stepSecond.tableCheckHoles = len;
            },
            // 芯片排位
            chipsSort(){
                if(this.stepSecond.multipleSelection.length == 0){
                    this.$alert("请选择芯片孔位");
                    return ;
                }
                this.stepThirdTemp = JSON.parse(JSON.stringify(this.stepThird.tableDataList));   //复制数据

                for(var i = 0; i < this.stepSecond.multipleSelection.length; i++){
                    for (var j = 0, len = this.stepSecond.multipleSelection[i].holeList.length; j < len; j++){
                        if(this.stepSecond.multipleSelection[i].holeList[j].state == 1) {
                            var obj = {};
                            obj.queueNumber = this.stepSecond.multipleSelection[i].queueNumber;
                            obj.hole = this.stepSecond.multipleSelection[i].holeList[j];
                            this.stepThird.resetUnuse.push(obj);

                        }
                    }
                }

                for(var i = 0; i < this.stepThird.tableDataList.length; i++){
                    this.stepThird.tableDataList[i].holeId = this.stepThird.resetUnuse[i].hole.id;
                    this.stepThird.tableDataList[i].queueNumber = this.stepThird.resetUnuse[i].queueNumber;
                    this.stepThird.resetUnuse[i].hole.sample = this.stepThird.tableDataList[i];
                    this.stepThird.resetUnuse[i].hole.state = 4;
                }
            },
            // 清除排位
            clearSort() {
                if(this.stepThird.tableDataList[0].queueNumber == '') {
                    this.$alert("芯片未排位");
                    return ;
                }
                this.stepThird.tableDataList = this.stepThirdTemp;
            },
            // 分页
            handleSizeChange(val) {
            },
            handleCurrentChange(val) {
            }
        }
    }
</script>

<style lang="scss" scoped>
    @import "~styles/variable";

    .el-step__head.is-text.is-success {
        background-color: #aad070 !important;
        border-color: #aad070;
    }
    .selectWidth {
        width: 100%;
    }
    .offSel {
        padding-right: 80px;
    }
    .submitSoft {
        float: right;
    }
    .taskList {
        color: #99a9bf;
        font-size: 14px;
    }
    .taskContent {
        color: #2f3445;
        font-size: 14px;
    }
    .hr {
        height: 1px;
        margin: 30px auto;
        background-color: #eee;
    }
    // 步骤二
    .chipsButtonWrap {
        float: right;
        .el-button:hover, 
        .el-button:focus {
            color: none;
            border-color: none;
        }
        .addChips {
            color: #5c7dfe;
            border-color: #5c7dfe;
            background: none;
        }
    }
    .dialogTitle {
        margin-top: -46px;
        font-size: 16px;
        font-weight: 700;
        color: rgb(31, 34, 61);
        span {
            font-size: 12px;
            color: #8798b1;
        }
    }
    .selectText {
        float: left;
        span:first-child {
            color: #fc2f39;
        }
        span:last-child {
            color: #ef456d;
        }
    }
    .haveSelectTable {
        margin-top: 20px;
    }
    .image-title {
        height: 19px;
        font-size: 14px;
        text-align: center;
        color: #99a9bf;
    }
    .remain {
        height: 19px;
        font-size: 14px;
        text-align: center;
        color: #99a9bf;
        float: right;
        span {
            color: #ef456d;
        }
    }
    // .img-wrap {
    //     width: 253px;
    //     height: 253px;
    //     margin: 0 auto;
    //     background: url(~assets/image/pic_xpsy.png);
    //     background-size: contain;
    //     padding-top: 58px;
    //     .circle-wrap {
    //         width: 140px;
    //         height: 140px;
    //         margin: 0 auto;
    //         padding: 7px 10px;
    //         .circle {
    //             display: inline-block;
    //             width: 24px;
    //             height: 24px;
    //             margin: 2px 3px;
    //             border-radius: 50%;
    //             background-color: #5c7dfe;
    //         }
    //         .use {
    //             background-color: #5c7dfe;
    //         }
    //         .unuse {
    //             background-color: #fff;
    //         }
    //         .forbidden {
    //             background-color: #d3dce6;
    //         }
    //         .add {
    //             background-color: #f00;
    //         }
    //     }
    // }
    .chipsTrStyle {
        background-color: #f00;
    }
    // 步骤三
    .stepThree {
        margin-bottom: 10px;
    }
    .printList {
        color: #5c7dfe;
        border-color: #5c7dfe;
        background: none;
        float: right;
    }
    // 表格
    .table {
        color: #2f3445;
        font-size: 13px;
        border: 1px solid #e0e6ed;
        .thead {
            background-color: #e5e9f2;
            th {
                width: 130px;
                height: 44px;
                text-align: center;
                border-right: 1px solid #e0e6ed;
            }
        }
        .tbody {
            tr {
                height: 46px;
                width: 130px;
                text-align: center;
                border-top: 1px solid #e0e6ed;
                    td {
                        border-right: 1px solid #e0e6ed;
                    }
                    .modifyTrData {
                        color: #5c7dfe;
                    }
                }
        }
    }
    // 分页
    .el-pagination {
        text-align: right;
        padding: 10px 0;
        float: right;
    }
    // 右侧选项卡
    .rightTitle,
    .content {
        color: #2f3445;
        font-size: 14px;
    }
    .warn {
        color: #f55f80;
    }

    .footer {
        padding-top: 10px;
        padding-right: 30px;
        p {
            width: 104px;
            height: 40px;
            line-height: 40px;
            text-align: center;
            background-color: #fff;
            border-radius: 4px;
            border: solid 1px #c0ccda;
            float: right;
        }
        .next {
            margin-left: 20px;
        }
    }

</style>
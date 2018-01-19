<template>
    <el-row :gutter="20">
        <el-col :span="24" class="leftReset">
            <el-form label-position="right">
                <el-row type="flex" align="middle">
                    <el-col :span="4">
                        <div class="form-group-title">任务清单</div>
                    </el-col>
                    <el-col :span="20" :offset="2">
                            <div class="buttonWrapper">
                                <el-button v-if="!edit"  icon="document" @click="download">导出</el-button>
                                <el-button v-if="!edit" type="primary"  icon="edit" @click="taskEdit">任务调度</el-button>
                                <el-button v-if="edit" class="cancel"  icon="document" @click="cancel">取消</el-button>
                                <el-button v-if="edit" class="confirm" icon="edit" @click="taskConfirm">确认</el-button>
                            </div>
                    </el-col>
                </el-row>
                <table class="table" ref="taskTable">
                    <thead class="thead">
                    <tr>
                        <th>任务ID</th>
                        <th>工作内容</th>
                        <th>工作流</th>
                        <th>样本数量</th>
                        <th>工时（天）</th>
                        <th>计划开始时间</th>
                        <th>计划完成时间</th>
                        <th>操作员</th>
                        <th v-if="!edit">任务状态</th>
                        <th>任务备注</th>
                        <th v-if="edit">操作</th>
                    </tr>
                    </thead>
                    <tbody class="tbody">
                    <tr v-for="(list, $index) in tableDataList">
                        <td>{{list.id}}</td>
                        <td>{{list.job.typeDesc}}</td>
                        <td>
                            <el-select v-model="list.workflow.id" v-show="edit" placeholder="请选择">
                                <el-option v-for="item in workflowList" :key="item.id" :label="item.name"
                                           :value="item.id">
                                </el-option>
                            </el-select>
                            <span v-show="!edit">{{list.workflow.name}}</span>
                        </td>
                        <td>
                            <el-input v-show="edit" size="small" v-model="list.sampleAmount"
                                      @change="changeSampleAmount(list)"></el-input>
                            <span v-show="!edit">{{list.sampleAmount}}</span>
                        </td>
                        <td>
                            <el-input v-show="edit" size="small" v-model="list.planLaborHour" @change="changePlanLaborHour(list)"></el-input>
                            <span v-show="!edit">{{list.planLaborHour}}</span>
                        </td>
                        <td>
                            <el-date-picker
                                    v-model="list.planStartTime"
                                    align="right"
                                    type="date"
                                    placeholder="选择日期"
                                    :picker-options="pickerOptions0"
                                    v-show="edit"
                                    @change="completeTimeCheck(list)"
                            >
                            </el-date-picker>
                            <span v-show="!edit">{{list.planStartTime | formatDate}}</span>
                        </td>
                        <td>
                            <el-date-picker
                                    v-model="list.planCompleteTime"
                                    align="right"
                                    type="date"
                                    placeholder="选择日期"
                                    :picker-options="pickerOptions0"
                                    v-show="edit"
                                    @change="completeTimeCheck(list)"
                            >
                            </el-date-picker>
                            <span v-show="!edit">{{list.planCompleteTime | formatDate}}</span>
                        </td>
                        <td>
                            <el-select v-model="list.operator.id" v-show="edit" placeholder="请选择">
                                <el-option v-for="item in operatorList" :key="item.id" :label="item.nickname"
                                           :value="item.id">
                                </el-option>
                            </el-select>
                            <span v-show="!edit">{{list.operator.nickname}}</span>
                        </td>
                        <td v-if="!edit">{{list.statusDesc}}</td>
                        <td>
                            <el-input v-show="edit" size="small" v-model="list.note"></el-input>
                            <span v-show="!edit">{{list.note}}</span>
                        </td>
                        <td v-if="edit">
                            <el-button type="primary" size="small" @click="resolve(list,$index)"
                                       v-if="list.sampleAmount>1">分解
                            </el-button>
                            <el-button type="danger" size="small" v-if="!list.defaultTask"
                                       @click="deleteTask($index,list)">
                                删除
                            </el-button>
                        </td>
                    </tr>
                    </tbody>
                </table>

                <el-row type="fix" align="middle" style="margin-top: 20px">
                    <el-col :span="16">
                        <el-pagination
                                @size-change="handleSizeChange"
                                @current-change="handleCurrentChange"
                                :current-page="filter.page"
                                :page-sizes="[10, 20, 30, 40]"
                                :page-size="filter.length"
                                layout="total, sizes, prev, pager, next, jumper"
                                :total="totalCount">
                        </el-pagination>
                    </el-col>
                </el-row>
            </el-form>
        </el-col>
    </el-row>
</template>

<script>
    import Util from '@/utils/util';
    import ElCol from "element-ui/packages/col/src/col";
    import Task from '@/api/task';
    import User from '@/api/user';
    import Project from '@/api/project';
    import Workflow from '@/api/workflowCfg';
    import {mapGetters} from 'vuex';
    import ElButton from "../../../../../node_modules/element-ui/packages/button/src/button";
    import {setTabDisabled} from '@/utils/projectTabUtil';
    import {exportCsv} from '@/utils/excelUtils';

    export default {
        components: {
            ElButton,
            ElCol
        },
        computed: {
            ...mapGetters([
                'projectNo',
                'projectId'
            ]),
        },
        mounted() {
            this.$store.commit("setProjectId", this.$route.query.projectId);
            this.$store.commit("setProjectNo", this.$route.query.projectNo);
            this.getData();
            this.getOperator();
            this.getWorkflowList();
        },
        data() {
            return {
                sampleCount: null,
                edit: false,
                operatorList: [],
                workflowList: [],
                filter: {
                    page: 1,
                    length: 10
                },
                checkAll: false,
                tableDataList: [],
                tableChecked: [],
                totalPage: 0,
                totalCount: 0,
                pickerOptions0: {
                    disabledDate(time) {
                        return time.getTime() < Date.now() - 8.64e7;
                    }
                },
                deleteList: []
            };
        },
        methods: {
            changeSampleAmount(item){
                var sampleAmountCheck = /^\+?[1-9][0-9]*$/; //正整数
                if (!sampleAmountCheck.test(item.sampleAmount)) {
                    this.$message({type: 'info', message: '样本数量为大于0的整数,请重新输入'});
                    this.$set(item, "sampleAmount", null);
                }
            },
            changePlanLaborHour(item){
                var planLaborHourCheck = /^(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*))$/; //正浮点数
                if (!planLaborHourCheck.test(item.planLaborHour)) {
                    this.$message({type: 'info', message: '工时需大于0,请重新输入'});
                    this.$set(item, "planLaborHour", null);
                } else if (item.planStartTime != null) {
                    var mills = (item.planLaborHour-1) * 24 * 60 * 60 * 1000;
                    this.$set(item, "planCompleteTime", new Date(item.planStartTime).getTime() + mills);
                }
            },
            completeTimeCheck(item){
                if (item.planStartTime != null && item.planLaborHour != null) {
                    var mills = (item.planLaborHour-1) * 24 * 60 * 60 * 1000;
                    this.$set(item, "planCompleteTime", new Date(item.planStartTime).getTime() + mills);
                }else if (item.planStartTime != null && item.planCompleteTime != null) {
                    var end = new Date(item.planCompleteTime).getTime();
                    var start = new Date(item.planStartTime).getTime();
                    if (end < start) {
                        this.$message({type: 'info', message: '完成时间不能早于开始时间,请重新选择完成时间'});
                        this.$set(item, "planCompleteTime", null);
                    } else {
                        //计算工时
                        var total = (end - start) / 1000;
                        this.$set(item, "planLaborHour", parseInt(total / (24 * 60 * 60))+1);
                    }
                }
            },
            download(){
                let table = this.$refs['taskTable'].children;
                var th = table[0].children[0].children;
                var fieldNames = [];
                for (var i = 0; i < th.length; i++) {
                    fieldNames.push(th[i].innerText);
                }
                var tr = table[1].children;
                var data = [];
                if (tr.length > 0) {
                    for (var i = 0; i < tr.length; i++) {
                        var tdData = [];
                        var td = tr[i].children;
                        for (var j = 0; j < td.length; j++) {
                            tdData.push(td[j].innerText)
                        }
                        data.push(tdData);
                    }
                }
                exportCsv(data, null, fieldNames, '任务清单');
            },
            taskConfirm(){
                var that = this;
                var tempData = [];
                for (var j in this.tableDataList) {
                    tempData[j] = this.tableDataList[j];
                }
                for (var i in tempData) {
                    var item = tempData[i];
                    if ((item.operator == null || item.operator.id == null) && item.planStartTime == null && item.planCompleteTime == null
                        && (item.workflow == null || item.workflow.id == null)) {
                        var index = this.tableDataList.indexOf(item)
                        if (index != -1) {
                            this.tableDataList.splice(index, 1);
                        }
                        continue;
                    } else if (item.operator == null || item.operator.id == null || item.planStartTime == null || item.planCompleteTime == null ||
                    item.workflow == null || item.workflow.id == null) {
                        this.$message({type: 'info', message: '请完善任务信息'});
                        return;
                    }
                    item.planStartTime = Util.dateUtil.dateFormatNewDate(item.planStartTime);
                    item.planCompleteTime = Util.dateUtil.dateFormatNewDate(item.planCompleteTime);
                }
                if (this.tableDataList.length > 0) {
                    var jobList = [];
                    for (var index in this.tableDataList) {
                        var item = this.tableDataList[index];
                        if (jobList.indexOf(item.job.id) == -1) {
                            jobList.push(item.job.id);
                        }
                    }
                    var sampleCountList = [];
                    //按工作内容计算样本数量
                    jobList.forEach(function (value, index) {
                        sampleCountList[index] = 0;
                        that.tableDataList.forEach(function (val) {
                            if (val.job.id == value) {
                                sampleCountList[index] += Number(val.sampleAmount);
                            }
                        });
                    });
                    Project.getSampleCount(this.projectId).then(response => {
                        if (response.code == 0) {
                            this.sampleCount = response.data;
                            for (var i in sampleCountList) {
                                if (sampleCountList[i] != this.sampleCount) {
                                    this.$message({type: 'info', message: '样本数量有误请核对'});
                                    return;
                                }
                            }
                            Task.dispatch({
                                projectId: this.projectId,
                                tasks: {taskList: this.tableDataList, deleteList: this.deleteList}
                            }).then(response => {
                                if (response.code == 0) {
                                    this.$message({type: 'success', message: '任务调度成功'});
                                    this.getData();
                                    this.edit = false;
                                    setTabDisabled(false);
                                } else {
                                    this.$message({type: 'error', message: response.reason});
                                }
                            });
                        }
                    });
                } else {
                    this.$message({type: 'info', message: '请完善任务信息'});
                    this.getData();
                }

            },
            deleteTask(index, item){
                this.tableDataList.splice(index, 1);
                if (item.id != null) {
                    this.deleteList.push(item.id);
                }
                this.tableDataList[index-1].sampleAmount += item.sampleAmount; //将删除任务的样本数量加到上一个任务
            },
            resolve(item, index){
                var amount = item.sampleAmount;
                item.sampleAmount = Math.ceil(amount / 2);//向上取整
                var newItem = {};
                for (var i in item) {
                    newItem[i] = item[i];
                }
                newItem.id = null;
                newItem.defaultTask = false;
                newItem.sampleAmount = Math.floor(amount / 2);//向下取整
                newItem.operator = {id: null, nickname: null};
                this.tableDataList.splice(index + 1, 0, newItem);
            },
            cancel(){
                this.edit = false;
                setTabDisabled(false);
                this.getData();
            },
            getOperator(){
                User.getSimpleList().then((response) => {
                    if (response.code == 0) {
                        this.operatorList = response.data;
                    } else {
                        this.$message({type: 'error', message: response.reason});
                    }
                })
            },
            getWorkflowList(){
              Workflow.getSimpleList().then((response) => {
                  if (response.code == 0) {
                      this.workflowList = response.data;
                  } else {
                      this.$message({type: 'error', message: response.reason});
                  }
              })
            },
            taskEdit(){
                this.edit = true;
                setTabDisabled(true);
                //todo 设置每一个任务是否可以调度
//                this.tableDataList.forEach();
            },
            getData(){
                if (this.projectId != null && this.projectId != undefined) {
                    this.filter.projectId = this.projectId;
                    Task.getList(this.filter).then((response) => {
                        if (response.code == 0) {
                            this.tableDataList = response.data.rows;
                            var that = this;
                            if (this.tableDataList != null && this.tableDataList.length > 0) {
                                this.tableDataList.forEach(function (value) {
                                    if (value.planCompleteTime == undefined) {
                                        that.$set(value, "planCompleteTime", null);
                                    }
                                    if (value.planStartTime == undefined) {
                                        that.$set(value, "planStartTime", null);
                                    }
                                    if (value.operator == undefined) {
                                        that.$set(value, "operator", {id: null, nickname: null});
                                    }
                                    if (value.workflow == undefined) {
                                        that.$set(value, "workflow", {id: null, name: null});
                                    }
                                });
                            }
                            this.totalPage = response.totalPage;
                            this.totalCount = response.data.totalCount;
                        } else {
                            this.$message({type: 'error', message: response.reason});
                        }
                    })
                }
            },
            handleSizeChange(val) {
                this.filter.length = val;
                this.getData();
            },
            handleCurrentChange(val) {
                this.filter.page = val;
                this.getData();
            },
        }
    };
</script>

<style lang="scss" scoped>
    @import "~styles/variable";

    .el-form-item span {
        width: 180px;
        display: inline-block;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }

    .seachpre {
        width: 74px;
    }

    .filter-div {
        margin: 1% auto;
    }

    .table-button {
        width: 100px;
        height: 36px;
        margin-left: 20px;
        margin-right: 20px !important;
        border: 1px solid $color-theme;
        border-radius: 4px !important;
    }

    .filter-date {
        width: 10%;
        margin-right: 1%;
    }

    .filter-input {
        width: 10%;
        margin-right: 1%
    }

    .filter-select {
        width: 10%;
        margin-right: 1%
    }

    .filter-label {
        font-size: 10pt;
    }

    .buttonWrapper {
        font-size: 12px;
        float: right;
        .confirm,
        .cancel {
            width: 76px;
            padding: 7px 15px;
            color: $color-red;
            border: 1px solid $color-red;
        }
        .confirm {
            color: $color-theme;
            border: 1px solid $color-theme;
        }
    }

    .tableEditWrapper {
        float: right;
        .edit {
            width: 102px;
            padding: 8px 15px;
            font-size: 13px;
            color: $color-theme;
            border: 1px solid $color-theme;
        }
        .cancel {
            width: 102px;
            padding: 8px 15px;
            font-size: 13px;
            color: $color-red;
            border: 1px solid $color-red;
        }
    }

    // 分页
    .el-pagination {
        text-align: right;
        padding: 10px 0;
        float: right;
    }

    .el-pagination__total {
        float: left;
    }

    .leftReset {
        padding-right: 20px !important;
    }

    .rightTitle {
        height: 50px;
        padding: 18px 0 18px 10px;
        line-height: 50px;
        box-sizing: border-box;
        background-color: #eff2f7;
        .form-group-title {
            margin: 0;
        }
    }

    // 表格
    .table {
        color: #2f3445;
        font-size: 13px;
        border: 1px solid #e0e6ed;
        width: 100%;
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

    .head-bar{
        .right{
            display: flex;
            align-items: center;
            float: right;
            &>div{
                margin-left: 10px;
            }
        }
    }
</style>
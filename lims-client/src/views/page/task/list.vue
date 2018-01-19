<template>
    <div>
        <div style="margin-bottom: 1%">
            <page-label title="任务列表" icon="new"></page-label>
        </div>
        <el-row :gutter="20">
            <el-col :span="24" class="leftReset">
                <el-form label-position="right">
                    <el-row type="flex" align="middle">
                        <el-col :span="24">
                            <div class="filter-container filter-div">
                                <span class="filter-label">任务编号</span>
                                <el-input class="filter-input" v-model="filter.taskId" placeholder="任务编号"></el-input>
                                <span class="filter-label">任务状态</span>
                                <el-select class="filter-select" v-model="filter.taskStatus" placeholder="请选择">
                                    <el-option v-for="item in taskStatusList" :key="item.value" :label="item.label"
                                               :value="item.value">
                                    </el-option>
                                </el-select>
                                <span class="filter-label">项目编号</span>
                                <el-input class="filter-input" v-model="filter.projectNo" placeholder="项目编号"></el-input>
                                <span class="filter-label">项目名称</span>
                                <el-input class="filter-input" v-model="filter.projectName"
                                          placeholder="项目名称"></el-input>
                                <span class="filter-label">项目状态</span>
                                <el-select class="filter-select" v-model="filter.projectStatus" placeholder="请选择">
                                    <el-option v-for="item in projectStatusList" :key="item.value" :label="item.label"
                                               :value="item.value">
                                    </el-option>
                                </el-select>

                                <el-button type="primary" icon="search" @click="handleFilter">查询</el-button>
                            </div>
                        </el-col>

                    </el-row>
                    <table class="table" v-noDataShow>
                        <thead class="thead">
                        <tr>
                            <th>任务编号</th>
                            <th>项目编号</th>
                            <th>项目名称</th>
                            <th>工作内容</th>
                            <th>工作流</th>
                            <th>样品数量</th>
                            <th>计划开始时间</th>
                            <th>计划完成时间</th>
                            <th>实际开始时间</th>
                            <th>实际完成时间</th>
                            <th>任务状态</th>
                            <th>操作员</th>
                            <th>操作</th>
                        </tr>
                        </thead>

                        <tbody class="tbody">
                        <tr v-for="(list, $index) in tableDataList">
                            <td>{{list.id}}</td>
                            <td>
                                <el-button class="href" type="text" @click='viewTask(list)' size="small">
                                    {{list.project.no}}
                                </el-button>
                            </td>
                            <td>{{list.project.name}}</td>
                            <td>{{list.job.typeDesc}}</td>
                            <td>{{list.workflow.name}}</td>
                            <td>{{list.sampleAmount}}</td>
                            <td>{{list.planStartTime | formatDate}}</td>
                            <td>{{list.planCompleteTime | formatDate}}</td>
                            <td>{{list.actualStartTime | formatDate}}</td>
                            <td>{{list.actualCompleteTime | formatDate}}</td>
                            <td>{{list.statusDesc}}</td>
                            <td>{{list.operator == null ? null : list.operator.nickname}}</td>
                            <td class="modifyTrData">
                                <el-button type="primary" @click='viewDetail(list)' size="small">详情</el-button>
                                <router-link :to="{name:'execute',params:{id:list.id,task:list}}">
                                    <el-button type="primary" v-show="showExecution" size="small">执行</el-button>
                                </router-link>
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

        <el-dialog title="任务详情" :visible.sync="dialogVisible">
            <el-form :model="task">
                <el-row>
                    <el-col :span="8">
                        <el-form-item label="任务编号:">
                            <span>{{task.id}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8" style="display: flex;">
                        <el-form-item label="任务状态:" style="flex-grow: 1">
                            <span>{{task.statusDesc}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="8">
                        <el-form-item label="项目编号:">
                            <span>{{task.project.no}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="16" style="display: flex;">
                        <el-form-item label="项目名称:" style="flex-grow: 1">
                            <span>{{task.project.name}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="8" style="display: flex;">
                        <el-form-item label="工作内容:" style="flex-grow: 1">
                            <span>{{task.job.typeDesc}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="样品数量:">
                            <span>{{task.sampleAmount}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="保存形式:">
                            <span>{{task.project.sampleLot.saveWayDesc}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="8" style="display: flex;">
                        <el-form-item label="物种分类:" style="flex-grow: 1">
                            <span>{{task.project.sampleLot.speciesDesc}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="样本类别:">
                            <span>{{task.project.sampleLot.sampleCategoryDesc}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="样本类型:">
                            <span>{{task.project.sampleLot.sampleTypeDesc}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="24" style="display: flex;">
                        <el-form-item label="工作流:" style="flex-grow: 1">
                            <span>{{task.workflow.name}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="8">
                        <el-form-item label="计划开始时间:">
                            <span>{{task.planStartTime | formatDate}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8" style="display: flex;">
                        <el-form-item label="计划完成时间:" style="flex-grow: 1">
                            <span>{{task.planCompleteTime | formatDate}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="调度员:">
                            <span>{{task.allotOperator == null ? null : task.allotOperator.nickname}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row>
                    <el-col :span="8">
                        <el-form-item label="实际开始时间:">
                            <span>{{task.actualStartTime | formatDate}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8" style="display: flex;">
                        <el-form-item label="实际完成时间:" style="flex-grow: 1">
                            <span>{{task.actualCompleteTime | formatDate}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="操作员:">
                            <span>{{task.operator == null ? null : task.operator.nickname}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>

                <el-row>

                </el-row>
            </el-form>
        </el-dialog>
    </div>
</template>

<script>
    import ElCol from "element-ui/packages/col/src/col";
    import Task from '@/api/task';
    import PageLabel from 'components/pageLabel'
    import { mapGetters } from 'vuex';

    export default {
        components: {
            ElCol,
            PageLabel,
        },
        computed: {
            ...mapGetters([
                'id'
            ])
        },
        mounted() {
            let path = this.$route.path;
            let param = path.substr(path.lastIndexOf("/") + 1);
            if (param === "my") {
                this.filter.operator = this.$store.getters.id;
                this.showExecution = true;
            } else {
                this.filter.taskStatus = Number(param);
                if (!this.filter.taskStatus) {
                    this.filter.taskStatus = null;
                }
            }
            this.getData();
        },
        data() {
            return {
                filter: {
                    taskId: null,
                    projectNo: null,
                    projectStatus: null,
                    taskStatus: null,
                    projectName: null,
                    page: 1,
                    length: 10,
                    operator:null
                },
                /*
                是否显示执行
                 */
                showExecution:false,
                dialogVisible: false,
                tableDataList: [],
                totalPage: 0,
                totalCount: 0,
                projectStatusList: this.GLOBAL.projectStatusList,
                taskStatusList: this.GLOBAL.taskStatusList,
                task: {
                    id: null,
                    sampleAmount: null,
                    planStartTime: null,
                    planCompleteTime: null,
                    actualStartTime: null,
                    actualCompleteTime: null,
                    statusDesc: null,
                    operator: {
                        nickname: null
                    },
                    allotOperator: {
                        nickname: null
                    },
                    job: {
                        typeDesc: null
                    },
                    project: {
                        no: null,
                        name: null,
                        sampleLot: {
                            sampleCategoryDesc: null,
                            sampleTypeDesc: null,
                            speciesDesc: null,
                            saveWayDesc: null
                        }
                    },
                    workflow: {
                        name: null
                    }
                }
            };
        },
        methods: {
            viewTask(task){
                this.$store.commit("setProjectNo", task.project.no);
                this.$store.commit("setProjectId", task.project.id);
                this.$store.commit("setProjectStatus", task.project.projectStatus);
                this.$router.push({
                    name: 'projectDetail',
                    query: {title: 'task', projectId: task.project.id, projectNo: task.project.no}
                });
            },
            viewDetail(task){
                this.dialogVisible = true;
                this.task = task;
            },
            getData(){
                Task.getList(this.filter).then((response) => {
                    if (response.code == 0) {
                        this.tableDataList = response.data.rows;
                        this.totalPage = response.totalPage;
                        this.totalCount = response.data.totalCount;
                    } else {
                        this.$message({type: 'error', message: response.reason});
                    }
                })
            },
            handleFilter(){
                this.getData();
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

    .href {
        color: #5c7dfe;
    }

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
        margin-right: 1%;
        font-size: 10pt;
    }

    .buttonWrapper {
        font-size: 12px;
        float: right;
        .confirm,
        .cancle {
            width: 76px;
            padding: 7px 15px;
        }
        .confirm {
            color: $color-theme;
            border: 1px solid $color-theme;
        }
        .cancle {
            color: $color-red;
            border: 1px solid $color-red;
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
        .cancle {
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
        padding-right: 10px !important;
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
</style>
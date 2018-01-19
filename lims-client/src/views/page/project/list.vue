<template>
    <div>
        <div style="margin-bottom: 1%" class="title-wrap">
            <page-label title="项目列表" icon="new"></page-label>
            <el-button-group>
                <el-button class="table-button" type="primary" icon="edit" v-if="delivery" @click="deliveryConfirm">批量交付</el-button>
                <router-link :to="{ name: 'projectDetail'}">
                    <el-button class="table-button" type="primary" icon="document">新建项目</el-button>
                </router-link>
            </el-button-group>
        </div>
        <el-row :gutter="20">
            <el-col :span="24" class="leftReset">
                <el-form label-position="right">
                    <el-row type="flex" align="middle">
                        <el-col :span="24">
                            <div class="filter-container filter-div">
                                <wrap label-info='项目状态'>
                                    <el-select slot="input" class="filter-common filter-status" v-model="filter.projectStatus" multiple placeholder="请选择">
                                        <el-option v-for="item in projectStatusList" :key="item.value" :label="item.label"
                                                :value="item.value">
                                        </el-option>
                                    </el-select>
                                </wrap>
                                <wrap label-info='项目编号'>
                                    <el-input slot="input" class="filter-common filter-input" v-model="filter.projectNo" placeholder="项目编号"></el-input>
                                </wrap>
                                <wrap label-info='项目名称'>
                                    <el-input slot="input" class="filter-common filter-input" v-model="filter.projectName" placeholder="项目名称"></el-input>
                                </wrap>
                                <wrap label-info='创建时间'>
                                    <el-date-picker slot="input"
                                            v-model="filter.createTime"
                                            type="date"
                                            placeholder="选择日期"
                                            class="filter-common filter-date"
                                    >
                                    </el-date-picker>
                                </wrap>
                                <wrap label-info='生产状态'>
                                <el-select slot="input" clearable  class="filter-common filter-select" v-model="filter.productStatus" placeholder="请选择">
                                    <el-option v-for="item in productStatusList" :key="item.value" :label="item.label"
                                            :value="item.value" clearable></el-option>
                                </el-select>
                                </wrap>
                                
                                <el-button class="filter-common filter-search" type="primary" icon="search" @click="handleFilter">查询</el-button>
                            </div>
                        </el-col>

                    </el-row>
                    <table class="table" v-noDataShow>
                        <thead class="thead">
                        <tr>
                            <th v-if="delivery">
                                <el-checkbox v-model="checkAll" @change="changeState()"></el-checkbox>
                            </th>
                            <th>项目编号</th>
                            <th>项目名称</th>
                            <th>项目状态</th>
                            <th>项目类型</th>
                            <th>样本种类</th>
                            <th>生产状态</th>
                            <th>创建时间</th>
                            <th>计划完成时间</th>
                            <th>实际完成时间</th>
                            <th>样品总数</th>
                            <th>操作</th>
                        </tr>
                        </thead>

                        <tbody class="tbody">
                        <tr v-for="(list, $index) in tableDataList">
                            <td v-if="delivery">
                                <el-checkbox v-model="list.checked" @change="singleSelect(list)"></el-checkbox>
                            </td>
                            <td>{{list.no}}</td>
                            <td>{{list.name}}</td>
                            <td>{{list.projectStatusDesc}}</td>
                            <td>{{list.projectTypeDesc}}</td>
                            <td>{{list.sampleCategoryDesc}}</td>
                            <td>{{list.productStatusDesc}}</td>
                            <td>{{list.createTime | formatDate}}</td>
                            <td>{{list.planCompleteTime | formatDate}}</td>
                            <td>{{list.actualCompleteTime | formatDate}}</td>
                            <td>{{list.sampleCount}}</td>
                            <td class="modifyTrData">
                                <el-button type="primary" @click='viewDetail(list)' size="small">查看</el-button>
                            </td>
                        </tr>
                        </tbody>
                    </table>

                    <el-row type="fix" align="middle" style="margin-top: 20px">
                        <el-col :span="14">
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
    </div>
</template>

<script>
    import ElCol from "element-ui/packages/col/src/col";
    import Project from '@/api/project';
    import PageLabel from 'components/pageLabel'
    import Wrap from '../modal/wrap'

    export default {
        components: {
            ElCol,
            PageLabel,
            Wrap
        },
        mounted() {
            let path = this.$route.path;
            let status = path.substr(path.lastIndexOf("/") + 1).split(",");
            this.filter.projectStatus = status.map(function (item) {
                return parseInt (item);
            });
            if (path.indexOf("delivery") != -1) {
                this.delivery = true;
            } else if (path.indexOf("dispatch") != -1) {
                this.dispatch = true;
            }
            this.getData();
        },
        data() {
            return {
                dispatch: false,//任务调度
                delivery: false,//交付生产
                filter: {
                    projectNo: null,
                    projectStatus: [],
                    projectName: null,
                    createTime: null,
                    productStatus: null,
                    page: 1,
                    length: 10
                },
                checkAll: false,
                tableDataList: [],
                tableChecked: [],
                totalPage: 0,
                totalCount: 0,
                productStatusList:this.GLOBAL.productStatusList,
                projectStatusList:this.GLOBAL.projectStatusList,
            };
        },
        methods: {
            deliveryConfirm(){
                if (this.tableChecked.length == 0) {
                    this.$message({type: 'info', message: '请选择交付的项目'});
                } else {
                    Project.delivery(this.tableChecked).then((response => {
                        if (response.code == 0) {
                            this.$message({type: 'success', message: '项目已交付生产'});
                            this.getData();
                        }
                    }))
                }
            },
            viewDetail(project){
                this.$store.commit("setProjectNo", project.no);
                this.$store.commit("setProjectId", project.id);
                this.$store.commit("setProjectStatus", project.projectStatus);
                if (this.dispatch) {
                    this.$router.push({name: 'projectDetail',query:{title:'task',projectId:project.id,projectNo:project.no}});
                } else {
                    this.$router.push({name: 'projectDetail',query:{title:'project',projectId:project.id}})
                }
            },
            getData(){
                let createTime = this.filter.createTime;
                if (createTime != null && createTime != undefined) {
                    createTime.getTime();
                    this.filter.createTime = new Date(createTime).getTime();
                }
                let projectStatus = this.filter.projectStatus;
                this.filter.projectStatus = this.filter.projectStatus.toString();
                Project.getList(this.filter).then((response) => {
                    if (response.code == 0) {
                        this.tableDataList = response.data.rows;
                        this.totalPage = response.totalPage;
                        this.totalCount = response.data.totalCount;
                        this.filter.projectStatus = projectStatus;
                    }
                })
            },
            handleFilter(){
                this.getData();
            },
            // 全选、单选
            changeState(){
                let checked = this.checkAll;
                this.tableDataList.forEach(item => {
                    this.$set(item, "checked", checked)
                    if (checked) {
                        if (this.tableChecked.indexOf(item.id) == -1) {
                            this.tableChecked.push(item.id);
                        }
                    } else {
                        this.tableChecked.pop(item.id);
                    }
                })
            },
            singleSelect(item) {
                if (item.checked) {
                    this.tableChecked.push(item.id);
                } else {
                    this.tableChecked.pop(item.id);
                }
                let selectData = this.tableDataList.filter(item => {
                    return item.checked == true;
                })
                // 全选与否
                selectData.length == this.tableDataList.length ? this.checkAll = true : this.checkAll = false;
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

    .title-wrap {
        display: flex;
        justify-content: space-between;
        align-items: center;
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

    .table-button {
        width: 100px;
        height: 36px;
        margin-left: 10px;
        margin-right: 10px !important;
        border: 1px solid $color-theme;
        border-radius: 4px !important;
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
        width:100%;
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

    .filter-div {
        margin: 1% auto;
        width: 100%;
    }

    .filter-common{
        margin-right: 1%;
        margin-bottom: 10px;
    }

    .filter-date {
        width: 10%;
    }

    .filter-input {
        width: 10%;
    }

    .filter-select {
        width: 10%;
    }

    .filter-label {
        font-size: 10pt;
    }

    .filter-status {
        width: 18%;
    }

    // .filter-search{
    //     float: right;
    // }
</style>
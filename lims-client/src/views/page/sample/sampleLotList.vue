<template>
    <div>
        <div style="margin-bottom: 1%">
            <page-label title="待接收样本批次" icon="new" v-if="receive"></page-label>
            <page-label title="样本批次" icon="new" v-if="!receive"></page-label>
        </div>
    <el-row :gutter="20">
        <el-col :span="24" class="leftReset">
            <el-form label-position="right">
                <el-row type="flex" align="middle">
                    <el-col :span="24">
                        <div class="filter-container filter-div">
                            <span class="filter-label">项目编号</span>
                            <el-input class="filter-input" v-model="filter.projectNo" placeholder="项目编号"></el-input>
                            <span class="filter-label" v-if="!receive">项目状态</span>
                            <el-select class="filter-status" v-if="!receive" v-model="filter.projectStatus" multiple placeholder="请选择">
                                <el-option v-for="item in projectStatusList" :key="item.value" :label="item.label"
                                           :value="item.value">
                                </el-option>
                            </el-select>
                            <span class="filter-label">样本批次编号</span>
                            <el-input class="filter-input" v-model="filter.sampleLotNo" placeholder="样本批次编号"></el-input>
                            <span class="filter-label">批次描述</span>
                            <el-input class="filter-input" v-model="filter.sampleLotDesc" placeholder="批次描述"></el-input>
                            <el-button class="filter-search" type="primary" icon="search" @click="handleFilter">查询</el-button>
                        </div>
                    </el-col>

                </el-row>
                <table class="table" v-noDataShow>
                    <thead class="thead">
                    <tr>
                        <th>样本批次编号</th>
                        <th>样本批次描述</th>
                        <th>项目状态</th>
                        <th>项目编号</th>
                        <th>项目名称</th>
                        <th>物种分类</th>
                        <th>样本类别</th>
                        <th>样本类型</th>
                        <th>保存形式</th>
                        <th>样本总数</th>
                        <th>样本来源</th>
                        <th>备注</th>
                        <th>操作</th>
                    </tr>
                    </thead>

                    <tbody class="tbody">
                    <tr v-for="(list, $index) in tableDataList">
                        <td>{{list.sampleLotNo}}</td>
                        <td>{{list.description}}</td>
                        <td>{{list.projectStatusDesc}}</td>
                        <td>{{list.no}}</td>
                        <td>{{list.name}}</td>
                        <td>{{list.speciesDesc}}</td>
                        <td>{{list.sampleCategoryDesc}}</td>
                        <td>{{list.sampleTypeDesc}}</td>
                        <td>{{list.saveWayDesc}}</td>
                        <td>{{list.sampleCount}}</td>
                        <td>{{list.sampleSourceDesc}}</td>
                        <td>{{list.sampleNote}}</td>
                        <td class="modifyTrData">
                            <el-button type="primary" @click="viewDetail(list)" size="small">查看</el-button>
                            <el-button type="primary" @click='receiveSample(list)' size="small"
                                       :disabled="!(list.projectStatus==this.GLOBAL.ProjectStatusEnum.NEW_PROJECT && list.sampleCount > 0)">接收</el-button>
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
    </div>
</template>

<script>
    import ElCol from "element-ui/packages/col/src/col";
    import SampleLot from '@/api/sampleLot';
    import Sample from '@/api/sample';
    import PageLabel from 'components/pageLabel'

    export default {
        components: {
            ElCol,
            PageLabel
        },
        mounted() {
            let path = this.$route.path;
            if (path.indexOf("receive") != -1) {
                this.filter.projectStatus.push(1);
                this.receive = true;
            }
            this.getData();
        },
        data() {
            return {
                receive: false,
                filter: {
                    projectStatus: [],
                    projectNo: null,
                    sampleLotNo: null,
                    sampleLotDesc: null,
                    page: 1,
                    length: 10
                },
                checkAll: false,
                tableDataList: [],
                tableChecked: [],
                totalPage: 0,
                totalCount: 0,
                projectStatusList: this.GLOBAL.projectStatusList,
            };
        },
        methods: {
            viewDetail(list){
                this.$store.commit("setProjectId", list.id);
                this.$store.commit("setProjectNo", list.no);
                this.$store.commit("setProjectStatus", list.projectStatus);
                this.$router.push({
                    name: 'projectDetail',
                    query: {title: 'sample',projectId:list.id},
                    params: {
                        projectNo: list.no,
                        id: list.id,
                        sampleCategory: list.sampleCategory,
                        species: list.species
                    }
                });
            },
            receiveSample(item){
                let data = {sampleLotId: item.sampleLotId, sampleIds: []}
                Sample.receive(data).then((response) => {
                    if (response.code == 0) {
                        this.$message({type: 'success', message: '样本批次接收成功'});
                        this.getData();
                    }else {
                        this.$message({type: 'error', message: response.reason});
                    }
                })
            },
            getData(){
                let projectStatus = this.filter.projectStatus;
                this.filter.projectStatus = this.filter.projectStatus.toString();
                SampleLot.getReceiveList(this.filter).then((response) => {
                    if (response.code == 0) {
                        this.tableDataList = response.data.rows;
                        this.totalPage = response.totalPage;
                        this.totalCount = response.data.totalCount;
                        this.filter.projectStatus = projectStatus;
                    }else {
                        this.$message({type: 'error', message: response.reason});
                    }
                })
            },
            handleFilter(){
                this.getData();
            },
            // 分页
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

    .table-button {
        width: 100px;
        height: 36px;
        margin-left: 20px;
        margin-right: 20px !important;
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

    .filter-status {
        width: 20%;
        margin-right: 1%
    }
</style>
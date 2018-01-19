<template>
    <div>
        <el-row :gutter="20">
            <el-col :span="24" class="leftReset">
                <el-form label-position="right">
                    <el-row type="flex" align="middle">
                        <el-col :span="24">
                            <div class="filter-div">
                                <span class="filter-label">样本名称</span>
                                <el-input class="filter-input" v-model="filter.filter" placeholder="样本名称"></el-input>
                                <span class="filter-label">样本状态</span>
                                <el-select class="filter-select" v-model="filter.sampleStatus"  placeholder="请选择">
                                    <el-option v-for="item in sampleStatusList" :key="item.value" :label="item.label"
                                               :value="item.value">
                                    </el-option>
                                </el-select>
                                <span class="filter-label">样本生产状态</span>
                                <el-select class="filter-select" v-model="filter.sampleProductStatus"  placeholder="请选择" clearable>
                                    <el-option v-for="item in sampleProductStatusList" :key="item.value" :label="item.label"
                                               :value="item.value">
                                    </el-option>
                                </el-select>
                                <span class="filter-label">样本批次编号</span>
                                <el-input class="filter-input" v-model="filter.sampleLotNo" placeholder="样本批次编号"></el-input>
                                <el-button class="filter-search" type="primary" icon="search" @click="handleFilter">查询</el-button>
                            </div>
                        </el-col>
                    </el-row>
                    <table class="table" v-noDataShow>
                        <thead class="thead">
                        <tr>
                            <th>样本批次编号</th>
                            <th>样本ID</th>
                            <th>样本名称</th>
                            <th>样本状态</th>
                            <th>样本生产状态</th>
                            <th>接收时间</th>
                            <th>保质期</th>
                            <th>备注</th>
                            <th>是否合格</th>
                            <th>不合格原因</th>
                        </tr>
                        </thead>

                        <tbody class="tbody">
                        <tr v-for="(list, $index) in tableDataList">
                            <td>{{list.sampleLot.no}}</td>
                            <td>{{list.id}}</td>
                            <td>{{list.name}}</td>
                            <td>{{list.sampleStatusDesc}}</td>
                            <td>{{list.productStatusDesc}}</td>
                            <td>{{list.receiveTime | formatDate }}</td>
                            <td>{{list.limitTime}}</td>
                            <td>{{list.note}}</td>
                            <td>{{list.qualified == null?'':(list.qualified == true?'是':'否')}}</td>
                            <td>{{list.disqualifiedReason}}</td>
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
    import Sample from '@/api/sample';
    import PageLabel from 'components/pageLabel'

    export default {
        components: {
            PageLabel
        },
        mounted() {
            this.getData();
        },
        data() {
            return {
                filter: {
                    sampleCategory:[16],//组织样本
                    sampleStatus: null,
                    sampleProductStatus: null,
                    filter: null,
                    sampleLotNo: null,
                    page: 1,
                    length: 10
                },
                tableDataList: [],
                totalPage: 0,
                totalCount: 0,
                sampleStatusList: this.GLOBAL.sampleStatusList,
                sampleProductStatusList: this.GLOBAL.productStatusList,
            };
        },
        methods: {
            getData(){
                this.filter.sampleCategory =this.filter.sampleCategory.toString();
                Sample.getList(this.filter).then((response) => {
                    if (response.code == 0) {
                        this.tableDataList = response.data.rows;
                        this.totalPage = response.totalPage;
                        this.totalCount = response.data.totalCount;
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

    // 分页
    .el-pagination {
        text-align: right;
        padding: 10px 0;
        float: right;
    }

    .leftReset {
        padding-right: 10px !important;
    }

    // 表格
    .table {
        width: 100%;
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
        margin-top: -20px;
        margin-bottom: 10px;
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
        font-size: 10pt;
    }

    .filter-status {
        width: 20%;
        margin-right: 1%
    }
</style>
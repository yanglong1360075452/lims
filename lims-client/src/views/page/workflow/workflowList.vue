<template>
    <div>
        <div style="margin-bottom: 1%" class="title-wrap">
            <page-label title="工作流列表" icon="new"></page-label>
        </div>
        <el-row :gutter="20">
            <el-col :span="24" class="leftReset">
                <el-form label-position="right">
                    <table class="table" v-noDataShow>
                        <thead class="thead">
                        <tr>
                            <th>工作流模板ID</th>
                            <th>应用分类</th>
                            <th>工作流类型</th>
                            <th>工作流名称</th>
                            <th>工作流说明</th>
                            <th>版本</th>
                            <th>发布时间</th>
                            <th>操作</th>
                        </tr>
                        </thead>

                        <tbody class="tbody">
                        <tr v-for="(list, $index) in tableDataList">
                            <td>{{list.id}}</td>
                            <td>{{list.applicationDesc}}</td>
                            <td>{{list.categoryDesc}}</td>
                            <td>{{list.name}}</td>
                            <td>{{list.description}}</td>
                            <td>{{list.ver}}</td>
                            <td>{{list.releaseTime | formatDate}}</td>
                            <td><router-link :to="{ path: 'detail/'+list.id}"><el-button type="primary">查看</el-button></router-link></td>
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
    import Workflow from '@/api/workflowCfg';
    import PageLabel from 'components/pageLabel'
    import Wrap from '../modal/wrap'
    import ElButton from "../../../../node_modules/element-ui/packages/button/src/button";

    export default {
        components: {
            ElButton,
            ElCol,
            PageLabel,
            Wrap
        },
        mounted() {
            this.getData();
        },
        data() {
            return {
                filter: {
                    page: 1,
                    length: 10
                },
                totalPage: 0,
                totalCount: 0,
                tableDataList:[]
            };
        },
        methods: {
            viewDetail(){
            },
            getData(){
                Workflow.getWorkflowList(this.filter).then((response) => {
                    if (response.code == 0) {
                        this.tableDataList = response.data.rows;
                        this.totalPage = response.totalPage;
                        this.totalCount = response.data.totalCount;
                    }
                })
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

    // 分页
    .el-pagination {
        text-align: right;
        padding: 10px 0;
        float: right;
    }

    .el-pagination__total {
        float: left;
    }
</style>
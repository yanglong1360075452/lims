<template>
    <div>
        <div style="margin-bottom: 1%" class="title-wrap">
            <page-label title="权限列表" icon="new"></page-label>
        </div>
        <el-row :gutter="20">
            <el-col :span="24" class="leftReset">
                <el-form ref="form" label-position="right" label-width="120px">
                    <table class="table">
                        <thead class="thead">
                        <tr>
                            <th>权限ID</th>
                            <th>权限名</th>
                            <th>权限描述</th>
                            <th>权限代码</th>
                        </tr>
                        </thead>

                        <tbody class="tbody">
                        <tr v-for="(item, $index) in permissions">
                            <td>{{item.id}}</td>
                            <td>{{item.name}}</td>
                            <td>{{item.description}}</td>
                            <td>{{item.code}}</td>
                        </tr>
                        </tbody>
                    </table>

                    <el-row type="fix" align="middle" style="margin-top: 20px">
                        <el-col :span="14">
                            <el-pagination
                                    @size-change="sizeChange"
                                    @current-change="handleCurrentChange"
                                    :current-page="currentPage"
                                    :page-sizes="pageSizes"
                                    :page-size="pageSize"
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
    import permission from '@/api/permissions';
    import PageLabel from 'components/pageLabel'

    export default {
        components: {PageLabel},

        beforeCreate() {
            this.temp = {};
            this.tableDataTemp = {};
        },
        mounted() {
            this.getPermissionsList();
        },
        data() {

            return {
                totalCount: 0,
                currentPage: 1,
                pageSize: 10,
                pageSizes: [10, 20, 30, 40],
                permissions: [],

            };
        },
        methods: {
            handleCurrentChange (val) {
                this.currentPage = val;
                this.getPermissionsList();
            },
            sizeChange(val){
                this.pageSize = val;
                this.getPermissionsList();
            },
            getPermissionsList(){
                setTimeout(() => {
                    let self = this;
                    permission.getList({
                        page: self.currentPage,
                        length: self.pageSize
                    }).then(function (response) {
                        if (response.code == 0) {
                            self.permissions = response.data.rows;
                            self.totalPage = response.totalPage;
                            self.totalCount = response.data.totalCount;
                        }
                        else self.$message({type: 'error', message: response.reason});
                    });
                }, 300);
            },
        }
    }
</script>
<style lang="scss">
    @import "~styles/variable";

    .seachpre {
        width: 74px;
    }

    // button
    .editWrapper {
        float: right;
        .edit {
            width: 76px;
            padding: 7px 15px;
            color: $color-theme;
            border: 1px solid $color-theme;
        }
    }

    .filter-item {
        width: 100px;
        // width: 130px;
        height: 36px;
        margin-left: 20px;
        // color: $color-theme;
        border: 1px solid $color-theme;
        // background: none;
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

    //  弹框
    .el-dialog__body .el-input,
    .el-dialog__body .el-date-editor {
        width: 360px !important;
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

    .upload-demo {
        float: left;
        .el-button {
            color: $color-theme;
            border-radius: 0px;
            background: none;
            border: 1px solid $color-theme;
        }
    }

    .loadTemplate {
        color: #2f3445;
        background: none;
        border: solid 1px #c0ccda !important;
    }

    .leftReset {
        padding-right: 10px !important;
        padding-top: 10px;
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
</style>

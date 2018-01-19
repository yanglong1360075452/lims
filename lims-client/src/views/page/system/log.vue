<template>
    <div>
        <div style="margin-bottom: 1%" class="title-wrap">
            <page-label title="日志列表" icon="new"></page-label>
        </div>
        <el-row :gutter="20">
            <el-col :span="24" class="leftReset">
                <el-form label-position="right">
                    <el-row type="flex" align="middle">
                        <el-col :span="24">
                            <div class="filter-container filter-div">
                                <span class="demonstration">操作时间</span>
                                <el-date-picker
                                        v-model="selectTime"
                                        type="daterange"
                                        align="right"
                                        placeholder="选择日期范围"
                                        :picker-options="pickerOptions"
                                        clearable
                                >
                                </el-date-picker>
                                &nbsp;&nbsp;&nbsp;
                                <span class="label">操作类型</span>
                                <el-select v-model="filter.operateType" placeholder="请选择" clearable>
                                    <el-option
                                            v-for="item in type"
                                            :key="item.code"
                                            :label="item.name"
                                            :value="item.code"
                                    >
                                    </el-option>
                                </el-select>
                                &nbsp;&nbsp;&nbsp;
                                <span class="label">操作者</span>
                                <el-select v-model="filter.operator" placeholder="请选择" clearable>
                                    <el-option
                                            v-for="item in users"
                                            :key="item.id"
                                            :label="item.nickname"
                                            :value="item.id"
                                    >
                                    </el-option>
                                </el-select>
                                <el-button class="filter-search" type="primary" icon="search" @click="getData">查询
                                </el-button>
                            </div>
                        </el-col>
                    </el-row>

                    <table class="table" v-noDataShow>
                        <thead class="thead">
                        <tr>
                            <th>操作时间</th>
                            <th>IP</th>
                            <th>操作者</th>
                            <th>操作类型</th>
                            <th>操作</th>
                            <th>
                                <div class="desc" style="text-align: center">请求参数</div>
                            </th>
                        </tr>
                        </thead>
                        <tbody class="tbody">
                        <tr v-for="(list, $index) in tableDataList">
                            <td>{{list.operateTime | formatTimestamp}}</td>
                            <td>{{list.ip}}</td>
                            <td>{{list.operatorUser.nickname}}</td>
                            <td>{{list.operateTypeDesc}}</td>
                            <td>{{list.operateDesc}}</td>
                            <td>
                                <div class="desc">{{list.description}}</div>
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
    import Log from '@/api/log';
    import User from '@/api/user';
    import PageLabel from 'components/pageLabel'

    export default {
        components: {
            ElCol,
            PageLabel
        },
        mounted() {
            this.getData();
            this.getType();
            this.getUsers();
        },
        watch: {
            '$route': 'getData',
//            'selectTime': 'getData',
//            'operator': 'getData'
        },
        data() {
            return {
                filter: {
                    length: 10,
                    page: 1,
                    operateTimeStart: null,
                    operateTimeEnd: null,
                    operator: null,
                    operateType: null,
                },
                type: null,
                users: null,
                totalPage: 0,
                totalCount: 0,
                tableDataList: [],
                pickerOptions: {
                    shortcuts: [{
                        text: '最近一周',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '最近一个月',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30);
                            picker.$emit('pick', [start, end]);
                        }
                    }, {
                        text: '最近三个月',
                        onClick(picker) {
                            const end = new Date();
                            const start = new Date();
                            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90);
                            picker.$emit('pick', [start, end]);
                        }
                    }]
                },
                selectTime: ''
            };
        },
        methods: {
            /**获取日志操作类型**/
            getType() {
                Log.getType({}).then(response => {
                    if (response.code == 0) {
                        this.type = response.data;
                    }
                });
            },
            getUsers() {
                User.getSimpleList({}).then(response => {
                    if (response.code == 0) {
                        this.users = response.data;
                    }
                });
            },
            getData(){
                if (this.selectTime != undefined) {
                    let start = this.selectTime[0];
                    let end = this.selectTime[1];
                    if (start != undefined) {
                        this.filter.operateTimeStart = new Date(start).getTime();
                    }
                    if (end != undefined) {
                        this.filter.operateTimeEnd = new Date(end).getTime() + 1000 * 60 * 60 * 24;
                    }
                }
                Log.getList(this.filter).then((response) => {
                    if (response.code == 0) {
                        if (response.code == 0) {
                            this.tableDataList = response.data.rows;
                            this.totalPage = response.totalPage;
                            this.totalCount = response.data.totalCount;
                        }
                        else this.$message({type: 'error', message: response.reason});
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
    .demonstration, 
    .label {
        margin-right: 1%;
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
        table-layout: fixed;
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

    .desc {
        width: 800px !important;
        text-align: left;
        /*设置单元格内容超过限制显示省略号*/
        overflow: hidden;
        white-space: nowrap;
        text-overflow: ellipsis;
        -o-text-overflow: ellipsis;
        -moz-text-overflow: ellipsis;
        -webkit-text-overflow: ellipsis;

    }
</style>
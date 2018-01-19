<template>
    <div>
        <div style="margin-bottom: 1%" class="title-wrap">
            <page-label title="角色列表" icon="new"></page-label>
            <div class="tableEditWrapper">
                <el-button v-show="ifTableEdit" class="new" @click.native="add()" type="primary" icon="edit">新建角色</el-button>
                <el-button v-show="!ifTableEdit" class="edit" icon="edit" @click.native="tableEdit()">编辑</el-button>
                <el-button v-show="ifTableEdit" class="cancel" icon="edit" @click.native="tableCancel()">退出编辑
                </el-button>
            </div>
        </div>
        <el-row :gutter="20">
            <el-col :span="24" class="leftReset">
                <el-form ref="form" label-position="right" label-width="120px">
                    <table class="table">
                        <thead class="thead">
                        <tr>
                            <th width="100px">角色名</th>
                            <th>角色描述</th>
                            <th>权限列表</th>
                            <th width="200px"  v-show="ifTableEdit">操作</th>
                        </tr>
                        </thead>

                        <tbody class="tbody">
                        <tr v-for="(item, $index) in roleDataList">
                            <td width="100px">{{item.name}}</td>
                            <td>{{item.description}}</td>
                            <td>
                                <template v-for="(permission,index) in item.permissions">
                                    <span>{{permission.name}}</span>
                                    <span v-show="index != item.permissions.length-1">， </span>
                                </template>
                            </td>
                            <td width="200px" v-show="ifTableEdit">
                                <el-button type="primary" @click='edit(item)'>编辑</el-button>
                                <el-button :plain="true" type="danger" @click='deleteRole(item)' :disabled="item.id==1">删除</el-button>
                            </td>
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

            <el-dialog title="角色信息" :visible.sync="dialogFormVisible" :before-close="Cancel">
                <el-form :model="role" ref="roleForm" :rules="roleRules">
                    <el-form-item label="角色名" :label-width="formLabelWidth" v-if="role.id == 1" prop="name">
                        <el-input v-model="role.name" placeholder="角色名" auto-complete="off" :disabled="true"></el-input>
                    </el-form-item>
                    <el-form-item label="角色名" :label-width="formLabelWidth" v-else prop="name">
                        <el-input v-model="role.name" prop="name" auto-complete="off" placeholder="角色名"
                                  :disabled="false"></el-input>
                    </el-form-item>

                    <el-form-item label="角色描述" :label-width="formLabelWidth" prop="description">
                        <el-input v-model="role.description" placeholder="角色描述" :label-width="formLabelWidth"
                                  :disabled="false"></el-input>
                    </el-form-item>

                    <el-form-item label="权限列表" :label-width="formLabelWidth">
                        <el-checkbox-group v-model="checkedPermissions">
                            <el-checkbox v-for="permission in permissions" :label="permission.id"
                                         :disabled="role.id == 1 && permission.id==1?true:false" :key="permission">
                                {{permission.name}}
                            </el-checkbox>
                        </el-checkbox-group>
                    </el-form-item>

                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="Cancel()">取 消</el-button>
                    <el-button type="primary" @click="submit()">确 定</el-button>
                </div>
            </el-dialog>

        </el-row>
    </div>
</template>
<script>
    import role from '@/api/roles';
    import permission from '@/api/permissions';
    import PageLabel from 'components/pageLabel'

    export default {
        components: {PageLabel},
        beforeCreate() {
            this.temp = {};
            this.tableDataTemp = {};
        },
        mounted() {
            this.getRoleList();
        },
        data() {
            return {
                roleRules:{
                    name: [{required: true, message: '请输入角色名', trigger: 'blur'}],
                },
                totalCount: 0,
                currentPage: 1,
                pageSize: 10,
                pageSizes: [10, 20, 30, 40],
                checkAll: false,
                dialogFormVisible: false,
                ifEdit: false,
                ifTableEdit: false,
                roleDataList: [],
                checkedPermissions: [],
                roles: [],
                permissions: [],
                role: {
                    id: null,
                    name: null,
                    description: null,
                    permissions: null,
                },
                checked: [],
                formLabelWidth: '120px',
            };
        },
        methods: {

            add(){
                this.dialogFormVisible = true;
                this.getAppPermissions();
            },
            edit(role) {
                this.dialogFormVisible = true;
                this.getAppPermissions();
                if (role != null) {
                    this.role = role;
                    for (let i = 0; i < role.permissions.length; i++) {
                        this.checkedPermissions.push(role.permissions[i].id);
                    }
                }
            },
            deleteRole(item){
                this.$confirm('确认删除' + item.name + '?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    if (item.id != undefined) {
                        role.deleteRole(item.id).then((response)=> {
                            this.getRoleList();
                            if (response.code == 0) {
                                this.$message({type: 'success', message: '角色删除成功'});
                                this.getRoleList();
                            } else {
                                this.$message({type: 'error', message: '角色删除失败'});
                            }
                        });
                    }
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消操作'
                    });
                });
            },
            getAppPermissions(){
                permission.getPermissionsList({
                    page: 1,
                    length: 1000,
                }).then((response)=> {
                    if (response.code == 0) {
                        this.permissions = response.data.rows;
                    }
                });
            },
            handleCurrentChange (val) {
                this.currentPage = val;
                this.getRoleList();
            },
            sizeChange(val){
                this.pageSize = val;
                this.getRoleList();
            },
            getRoleList(){
                setTimeout(() => {
                    role.getRoleList({
                        page: this.currentPage,
                        length: this.pageSize
                    }).then((response)=> {
                        if (response.code == 0) {
                            this.roleDataList = response.data.rows;
                            this.totalPage = response.totalPage;
                            this.totalCount = response.data.totalCount;
                        }
                        else this.$message({type: 'error', message: response.reason});
                    });
                }, 300);
            },
            submit() {
                this.role.permissions = this.checkedPermissions;
                if (this.role.id == null) {
                    if ("" != this.role.name && null != this.role.name) {
                        role.create(this.role).then((response)=> {
                            if (response.code == 0) {
                                this.$message({type: 'success', message: "创建角色成功"});
                                this.Cancel();
                                this.getRoleList();
                            }
                            else this.$message({type: 'error', message: "创建角色失败"});
                            this.Cancel();
                            this.getRoleList();
                        });

                    } else {
                        this.$message({type: 'error', message: "创建角色失败!请输入角色名"});
                    }
                } else {
                    role.update(this.role).then((response)=> {
                        if (response.code == 0) {
                            this.$message({type: 'success', message: "编辑角色成功"});
                            this.Cancel();
                            this.getRoleList();
                        }
                        else this.$message({type: 'error', message: response.reason});
                    });
                }
            },
            Cancel() {
                this.ifEdit = false;
                this.dialogFormVisible = false;
                this.role = {
                    name: null,
                    description: null,
                    permissions: null,
                },
                    this.checkedPermissions = [];
                this.getRoleList();
            },
            confirm() {
                this.ifEdit = false;
            },
            tableEdit() {
                this.ifTableEdit = true;
            },
            tableCancel() {
                this.ifTableEdit = false;
            }
        }
    };
</script>
<style lang="scss">
    @import "~styles/variable";

    .title-wrap {
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .tableEditWrapper {
        margin-bottom: 10px;
        margin-right: 10px;
        float: right;
        .edit {
            height: 36px;
            width: 102px;
            padding: 8px 15px;
            font-size: 13px;
            color: $color-theme;
            border: 1px solid $color-theme;
        }
        .cancel {
            height: 36px;
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
                height: 44px;
                text-align: center;
                border-right: 1px solid #e0e6ed;
            }
        }
        .tbody {
            tr {
                height: 46px;
                text-align: center;
                border-top: 1px solid #e0e6ed;
                td {
                    border-right: 1px solid #e0e6ed;
                }
            }
        }
    }
</style>

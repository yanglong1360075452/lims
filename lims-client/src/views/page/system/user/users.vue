<template>
    <div>
        <div style="margin-bottom: 1%" class="title-wrap">
            <page-label title="用户列表" icon="new"></page-label>
            <div class="tableEditWrapper">
                <el-button v-show="ifTableEdit" class="new" @click="add()" type="primary" icon="edit">新建用户</el-button>
                <el-button v-show="!ifTableEdit" class="edit" icon="edit" @click="tableEdit()">
                    编辑
                </el-button>
                <el-button v-show="ifTableEdit" class="cancel" icon="edit" @click="tableCancel()">退出编辑
                </el-button>
            </div>

        </div>

        <el-row :gutter="20">
            <el-col :span="24" class="leftReset">
                <el-form ref="form" label-position="right" label-width="120px">
                    <table class="table">
                        <thead class="thead">
                        <tr>
                            <th width="50px">用户ID</th>
                            <th width="100px">用户名</th>
                            <th width="150px">手机号码</th>
                            <th width="100px">用户昵称</th>
                            <th width="100px">部门</th>
                            <th width="100px">职位</th>
                            <th>角色列表</th>
                            <th>用户说明</th>
                            <th width="100px">状态</th>
                            <th width="200px" v-show="ifTableEdit">操作</th>
                        </tr>
                        </thead>

                        <tbody class="tbody">
                        <tr v-for="(item, $index) in userDataList">
                            <td width="50px">{{item.id}}</td>
                            <td width="100px">{{item.username}}</td>
                            <td width="150px">{{item.phone}}</td>
                            <td width="100px">{{item.nickname}}</td>
                            <td width="100px">{{item.department}}</td>
                            <td width="100px">{{item.position}}</td>
                            <td>
                                <template v-for="(role,index) in item.roles">
                                    <span>{{role.name}}</span>
                                    <span v-show="index != item.roles.length-1">， </span>
                                </template>
                            </td>
                            <td>{{item.note}}</td>
                            <td width="100px">{{item.status == false ? '禁用' : '活动'}}</td>
                            <td width="200px" class="modifyTrData" v-show="ifTableEdit">
                                <el-button type="primary" @click='edit(item)'>修改</el-button>
                                <el-button type="primary" @click='updateUserStatus(item)' :disabled="item.id==1">
                                    {{item.status == false ? '激活' : '禁用'}}
                                </el-button>
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

            <el-dialog title="用户信息" :visible.sync="dialogFormVisible" :before-close="cancel">
                <el-form :model="user" ref="userForm" :rules="userInfoRules">
                    <el-form-item label="用户名" :label-width="formLabelWidth" v-if="user.id != null" prop="username">
                        <el-input v-model="user.username" placeholder="用户名" auto-complete="off"
                                  :disabled="true"></el-input>
                    </el-form-item>
                    <el-form-item label="用户名" :label-width="formLabelWidth" v-else prop="username">
                        <el-input v-model="user.username" prop="username" auto-complete="off" placeholder="用户名"
                                  :disabled="false"></el-input>
                    </el-form-item>

                    <el-form-item label="密码" :label-width="formLabelWidth" v-if="user.id == null" prop="password">
                        <el-input v-model="user.password" placeholder="密码" :label-width="formLabelWidth" type="password"
                                  :disabled="false"></el-input>
                    </el-form-item>
                    <el-form-item label="手机号码" :label-width="formLabelWidth" prop="phone">
                        <el-input v-model="user.phone" placeholder="手机号码" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="用户昵称" :label-width="formLabelWidth" prop="nickname">
                        <el-input v-model="user.nickname" placeholder="用户昵称" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="部门" :label-width="formLabelWidth" prop="department">
                        <el-input v-model="user.department" placeholder="部门" auto-complete="off"></el-input>
                    </el-form-item>
                    <el-form-item label="职位" :label-width="formLabelWidth" prop="position">
                        <el-input v-model="user.position" placeholder="职位" auto-complete="off"></el-input>
                    </el-form-item>

                    <el-form-item label="角色列表" :label-width="formLabelWidth">
                        <el-checkbox-group v-model="checkedRoles">
                            <el-checkbox v-for="role in roles" :label="role.id"
                                         :disabled="user.id == 1 && role.id==1?true:false" :key="role">{{role.name}}
                            </el-checkbox>
                        </el-checkbox-group>
                    </el-form-item>

                    <el-form-item label="用户说明" :label-width="formLabelWidth" prop="note">
                        <el-input v-model="user.note" placeholder="用户说明" auto-complete="off"></el-input>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button type="text" @click="resetPassword = true"
                               style="float:left;border-bottom:2px solid cornflowerblue;" v-if="user.id!=null">重置用户密码?
                    </el-button>
                    <el-button @click="cancel()">取 消</el-button>
                    <el-button type="primary" @click="submit()">确 定</el-button>
                </div>
            </el-dialog>

            <el-col :span="12">
                <div class="grid-content bg-purple-dark" align="right">
                    <el-dialog :visible.sync="resetPassword" size="tiny" top="30%" title="重置密码" ref="resetForm">
                        <el-form :model="reset" :rules="resetRule" ref="reset">
                            <el-form-item label="新密码" prop="pass">
                                <el-input type="password" v-model="reset.pass" auto-complete="off"
                                          placeholder="请输入密码"></el-input>
                            </el-form-item>
                            <el-form-item label="确认密码" prop="checkPass">
                                <el-input type="password" v-model="reset.checkPass" auto-complete="off"
                                          placeholder="请再次输入密码"></el-input>
                            </el-form-item>
                        </el-form>
                        <div slot="footer" class="dialog-footer">
                            <el-button @click="resetPassCancel()">取 消</el-button>
                            <el-button type="primary" @click="submitForm1('reset')">确 定</el-button>
                        </div>
                    </el-dialog>
                </div>
            </el-col>
        </el-row>
    </div>
</template>
<script>
    import us from '@/api/user';
    import role from '@/api/roles';
    import PageLabel from 'components/pageLabel'
    import ElButtonGroup from "../../../../../node_modules/element-ui/packages/button/src/button-group";

    export default {
        components: {
            ElButtonGroup,
            PageLabel},
        props: {
            type: {  //弹出框出现状态：新建：0，编辑：1
                type: Number,
                require: true,
            }
        },
        beforeCreate() {
            this.temp = {};
            this.tableDataTemp = {};
        },
        mounted() {
            this.getUserList();
        },
        data() {
            let validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    if (this.reset.checkPass !== '') {
                        this.$refs.reset.validateField('checkPass');
                    }
                    callback();
                }
            };
            let validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.reset.pass) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return {
                userInfoRules: {
                    username: [{required: true, message: '请输入用户名', trigger: 'blur'}],
                    password: [{required: true, message: '请输入密码', trigger: 'blur'}],
                    nickname: [{required: true, message: '请输入昵称', trigger: 'blur'}],
                },
                totalCount: 0,
                currentPage: 1,
                pageSize: 10,
                pageSizes: [10, 20, 30, 40],
                checkAll: false,
                dialogFormVisible: false,
                resetPassword: false,
                reset: {
                    pass: "",
                    checkPass: ""
                },
                resetRule: {
                    pass: [
                        {required: true, message: '请输入新密码', trigger: 'blur'},
                        {validator: validatePass, trigger: 'blur'}
                    ],
                    checkPass: [
                        {required: true, message: '请再次输入新密码', trigger: 'blur'},
                        {validator: validatePass2, trigger: 'blur'}
                    ]
                },
                ifEdit: false,
                ifTableEdit: false,
                userDataList: [],
                checkedRoles: [],
                roles: [],
                ids: [],
                user: {
                    id: null,
                    username: null,
                    password: null,
                    phone: null,
                    nickname: null,
                    note: null,
                    status: null,
                    department: null,
                    position: null,
                    roles: null
                },
                formLabelWidth: '120px',
            };
        },
        methods: {
            add(){
                this.dialogFormVisible = true;
                this.getAppRoles();
            },
            edit(user) {
                this.dialogFormVisible = true;
                this.getAppRoles();
                if (user != null) {
                    this.user = user;
                    for (let i = 0; i < user.roles.length; i++) {
                        this.checkedRoles.push(user.roles[i].id);
                    }
                }
            },
            updateUserStatus(item){
                us.updateStatus(item.id).then(response => {
                    this.getUserList();
                    if (response.code == 0) {
                        this.$message({type: 'success', message: '用户状态更新成功'});
                        this.getUserList();
                    } else {
                        this.$message({type: 'error', message: '用户状态更新失败'});
                    }
                });
            },
            getAppRoles(){

                role.getRoleList({
                    page: 1,
                    length: 1000,
                }).then((response) => {
                    if (response.code == 0) {
                        this.roles = response.data.rows;
                    }
                });
            },
            handleCurrentChange (val) {
                this.currentPage = val;
                this.getUserList();
            },
            sizeChange(val){
                this.pageSize = val;
                this.getUserList();
            },
            getUserList(){
                setTimeout(() => {

                    us.getList({
                        page: this.currentPage,
                        length: this.pageSize
                    }).then((response) => {
                        if (response.code == 0) {
                            this.userDataList = response.data.rows;
                            this.totalPage = response.totalPage;
                            this.totalCount = response.data.totalCount;
                        }
                        else this.$message({type: 'error', message: response.reason});
                    });
                }, 300);
            },
            submitForm1(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        let user = {
                            id: this.user.id,
                            password: this.reset.pass
                        };

                        us.resetPassword(user).then((response) => {
                            if (response.code == 0) {
                                this.$message({type: 'success', message: "密码修改成功"});
                                this.resetPassCancel();
                            } else {
                                this.$message({type: 'error', message: response.reason});
                            }
                        });
                    } else {
                        this.$message({type: 'error', message: "密码修改失败"});
                        return false;
                    }
                });
            },
            submit() {
                this.user.roles = this.checkedRoles;

                this.$refs['userForm'].validate((valid) => {
                    if (valid) {
                        if (this.user.id == null) {
                                us.getByName(this.user.username).then((response) => {
                                    if (response.code == 0) {
                                        if (response.data != undefined && response.data.username != undefined) {
                                            this.$message({type: 'error', message: "创建用户失败!用户名已存在"});
                                        } else {
                                            us.create(this.user).then((response) => {
                                                if (response.code == 0) {
                                                    this.$message({type: 'success', message: "创建用户成功"});
                                                    this.cancel();
                                                    this.getUserList();
                                                }
                                                else this.$message({type: 'error', message: "创建用户失败"});
                                                this.cancel();
                                                this.getUserList();
                                            });
                                        }
                                    }
                                });
                        } else {
                            us.update(this.user).then((response) => {
                                if (response.code == 0) {
                                    this.$message({type: 'success', message: "编辑用户成功"});
                                    this.cancel();
                                    this.getUserList();
                                }
                                else this.$message({type: 'error', message: response.reason});
                            });
                        }
                    }else {
                        this.$message({type: 'error', message: "请完善用户信息"});
                    }
                });
            },
            resetPassCancel(){
                this.resetPassword = false;
                this.reset.pass = "";
                this.reset.checkPass = "";

            },
            cancel() {
                this.ifEdit = false;
                this.dialogFormVisible = false;
                this.user = {
                    roles: [],
                    username: null,
                    password: null,
                    phone: null,
                    nickname: null,
                    department: null,
                    position: null,
                    note: null,
                };
                this.checkedRoles = [];
            },
            confirm() {
                this.ifEdit = false;
            },
            tableEdit() {
                this.ifTableEdit = true;
            },
            tableCancel() {
                this.ifTableEdit = false;
            },
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

    .table-button {
        width: 100px;
        height: 36px;
        margin-left: 10px;
        margin-right: 10px !important;
        border: 1px solid $color-theme;
        border-radius: 4px !important;
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

<template>
    <div class="header-wrapper">
        <el-row :gutter="20">
            <el-col :span="16">
                <div class="logo">
                    <svg>
                        <use xlink:href="#logo"/>
                    </svg>
                </div>
                <div class="search">
                    <icon-svg icon-class="sousuo"></icon-svg>
                    <input type="text" placeholder="请输入搜索内容">
                </div>
            </el-col>
            <el-col :span="8">
                <div class="message-wrapper">
                    <el-badge :value="1" class="item">
                        <icon-svg icon-class="message"></icon-svg>
                    </el-badge>

                </div>
                <div class="user-info">
                    <div class="head-pic">
                        <img src="~assets/image/headPic.jpg">
                    </div>

                    <el-dropdown @command="handleCommand">
                          <span class="el-dropdown-link">
                              <div class="name">
                                  <el-input v-model="name" style="display: none" ></el-input>
                                {{name}}
                              </div>
                              <icon-svg class="arrow-down" icon-class="arrow-down"></icon-svg>
                          </span>
                        <el-dropdown-menu slot="dropdown">
                            <el-dropdown-item command="open">个人信息</el-dropdown-item>
                            <el-dropdown-item divided command="logout">登出</el-dropdown-item>
                        </el-dropdown-menu>
                    </el-dropdown>

                </div>

            </el-col>
        </el-row>
        <!--个人信息弹框-->
        <el-dialog title="个人信息" :modal-append-to-body="false":visible.sync="dialogFormVisible" :before-close="cancel">
            <el-form :model="user" ref="addForm">
                <el-form-item label="用户名" :label-width="formLabelWidth" v-if="user.id != null" prop="username">
                    <el-input v-model="user.username" placeholder="用户名" auto-complete="off" :disabled="true" ></el-input>
                </el-form-item>
                <el-form-item label="用户名" :label-width="formLabelWidth" v-else>
                    <el-input v-model="user.username" prop="username" auto-complete="off" placeholder="用户名" :disabled="false" ></el-input>
                </el-form-item>

                <el-form-item label="密码" :label-width="formLabelWidth"  v-if="user.id == null">
                    <el-input v-model="user.password" placeholder="密码"  :label-width="formLabelWidth" :disabled="false" ></el-input>
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
                        <el-checkbox v-for="role in roles" :label="role.id" :disabled="user.id == 1 && role.id==1?true:false" :key="role">{{role.name}}</el-checkbox>
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
                <el-button type="primary" @click="operateUser()">确 定</el-button>
            </div>
        </el-dialog>
        <!--修改密码弹框-->
        <div class="grid-content bg-purple-dark" align="right">
            <el-dialog  :visible.sync="resetPassword" top="30%" :modal-append-to-body="false" size="tiny" title="重置用户密码" ref="reset1" @close="rpCancel">
                <el-form :model="reset1"  ref="reset1">
                    <el-form-item label="原密码" prop="ypass">
                        <el-input type="password" v-model="reset1.ypass" v-on:blur="validPassword()" auto-complete="off" placeholder="请输入原密码">
                        </el-input>
                        <div class="el-form-item__error" v-if="this.error!=1">{{this.error}}</div>
                    </el-form-item>
                    <el-form-item label="新密码" prop="pass">
                        <el-input type="password" v-model="reset1.pass" auto-complete="off" v-on:blur="validPassword1()" placeholder="请输入密码"></el-input>
                        <div class="el-form-item__error" v-if="this.error1!=2">{{this.error1}}</div>
                    </el-form-item>
                    <el-form-item label="确认密码" prop="checkPass">
                        <el-input type="password" v-model="reset1.checkPass" auto-complete="off" v-on:blur="validPassword2()" placeholder="请再次输入密码"></el-input>
                        <div class="el-form-item__error" v-if="this.error2!=3">{{this.error2}}</div>
                    </el-form-item>
                </el-form>
                <div slot="footer" class="dialog-footer">
                    <el-button @click="rpCancel">取消</el-button>
                    <el-button type="primary" @click="submitForm('reset1')">确定</el-button>
                </div>
            </el-dialog>
        </div>



    </div>
</template>

<script>
    import {mapGetters} from 'vuex';
    import UserService from '@/api/user';
    import {getInfo} from '@/api/user';
    import {logout} from '@/api/login';
    import RoleService from '@/api/roles';
    import IconSvg from 'components/Icon-svg';

    export default {
        components: {
            IconSvg
        },
        computed: {
            ...mapGetters([
                'id',
                'name',
                'avatar'
            ])
        },
        data(){
            return {
                error:'1',
                error1:'2',
                error2:'3',
                user_name: '',
                user_id:'',
                resetPassword: false,
                dialogFormVisible:false,
                formLabelWidth: '120px',
                roles:[],
                checkedRoles:[],
                user:{
                    id:null,
                    username:null,
                    password:null,
                    phone:null,
                    nickname:null,
                    note:null,
                    status:null,
                    department:null,
                    position:null,
                    roles:null
                },
                reset1: {
                    ypass:'',
                    pass: '',
                    checkPass: ''
                },
            }
        },
        methods: {
            handleCommand(command){
                if(command == "open"){
                 this.open();
                }else if(command == "logout"){
                    this.userLogout();
                }
            },
            userLogout() {
                logout().then(response=>{
                    if(response.code == 0){
                        this.$router.push({name:"login"});
                        this.$store.dispatch('LogOut').then(() => {
                            location.reload();  // 为了重新实例化vue-router对象 避免bug
                        });
                    }
                })
            },
            getAppRoles(){
                RoleService.getRoleList({
                    page: 1,
                    length: 1000,
                }).then( (response) => {
                    if(response.code == 0) {
                        this.roles = response.data.rows;
                    }
                });
            },
            open(){
                this.dialogFormVisible = true;
                this.getAppRoles();
                getInfo(this.id).then( (response)=> {
                    if(response.code==0){
                        this.user = response.data;
                        if(this.user.roles != null){
                            for (var i=0;i<this.user.roles.length;i++) {
                                this.checkedRoles.push(this.user.roles[i].id);
                            }
                        }
                    }else{
                        this.$message({type: 'error', message: response.data.reason});
                    }
                });

            },
            operateUser(){
                this.$refs.addForm.validate((valid) => {
                    if (valid) {
                        this.user.roles = this.checkedRoles;
                        if(this.user.id != undefined){
                            let that = this;
                            UserService.update(that.user).then(function (response) {
                                if(response.code == 0) {
                                    that.$message({type: 'success', message: "编辑用户成功"});
                                    that.cancel();
                                }
                                else that.$message({type: 'error', message: response.data.reason});
                                
                            });
                        }
                    }else {
                        this.$message({type: 'error', message: "编辑用户失败"});
                        this.cancel();
                        return false;
                    }
                });
            },
            validPassword: function() {
                if("" != this.reset1.ypass){
                    let that = this;
                    UserService.getUserByNameP(that.reset1.ypass).then(function (response) {
                        if(response.code == 0) {
                            that.error='';
                            that.user_id = response.data.id;
                        } else {
                            that.error = "原密码输入错误";
                        }
                    });
                }else{
                    this.error = "请输入原密码";
                }
            },
            validPassword1: function() {
                if (this.reset1.pass == '') {
                    this.error1 = "请输入新密码";
                }
                else {
                    this.error1 = "";
                }
            },
            validPassword2: function() {
                if (this.reset1.checkPass == '') {
                    this.error2 = "请再次输入新密码";
                } else if (this.reset1.checkPass != this.reset1.pass) {
                    this.error2 = "两次输入密码不一致";
                } else {
                    this.error2 = "";
                }
            },
            rpCancel(){
                this.resetPassword = false;
                this.error='';
                this.error1='';
                this.error2='';
                this.reset1={
                    ypass:'',
                    pass: '',
                    checkPass: ''
                },
                    this.user_id = '';
            },
            cancel(){
                this.user_id = '';
                this.dialogFormVisible = false;
                this.user = {
                    roles:null,
                    username:null,
                    password:null,
                    phone:null,
                    nickname:null,
                    department:null,
                    position:null,
                    note:null,
                };
                this.checkedRoles = [];
            },
            submitForm(formName) {
                if (this.error =='' && this.error1 =='' && this.error2 =='') {
                    var user = {
                        id: this.user_id,
                        password:this.reset1.checkPass
                    };
                    
                    let that = this;
                    UserService.resetPassword(user).then(function (response) {
                        
                        if(response.code == 0) {
                            that.resetPassword = false;
                            that.user_id = '';
                            that.reset1={
                                ypass:'',
                                pass: '',
                                checkPass: ''
                            }
                            that.$message({type: 'success', message: "密码修改成功"});
                        } else {
                            that.$message({type: 'error', message: response.data.reason});
                        }
                    });
                } else {
                    this.$message({type: 'error', message: "密码修改失败"});
                    return false;
                }
            },
        }
    }
</script>

<style rel="stylesheet/scss" lang="scss">
    @import '~styles/variable.scss';
    @import '~styles/mixin.scss';

    .header-wrapper {
        position: fixed;
        height: 70px;
        line-height: 70px;
        width: 100%;
        top: 0;
        left: 0;
        background-color: #fff;
        z-index: 99;
        box-shadow: 0 6px 10px 0 rgba(214, 221, 229, 0.3);

        :-moz-placeholder { /* Mozilla Firefox 4 to 18 */
            color: $color-text-ll;
        }

        ::-moz-placeholder { /* Mozilla Firefox 19+ */
            color: $color-text-ll;
        }

        input:-ms-input-placeholder {
            color: $color-text-ll;
        }

        input::-webkit-input-placeholder {
            color: $color-text-ll;
        }

        .logo {
            margin-left: 30px;
            margin-right: 10%;
            float: left;
            svg {
                width: 133px;
                height: 29px;
                vertical-align: middle;
            }
        }

        .search {
            float: left;
            svg{
                fill: $color-text-ll;
            }
            input {
                margin-left: 5px;
                color: $color-text-ll;
                border: 0;
                line-height: normal;
                font-size: 14px;
            }
        }

        .user-info {
            float: right;

            & > div {
                float: left;
            }

            .el-dropdown-link{
                @include flexBox();
                .name {
                    margin-left: 20px;
                    color: $color-text-l;
                }
                .arrow-down {
                    margin-left: 5px;
                    width: 10px;
                }
            }

            .head-pic {
                img {
                    vertical-align: middle;

                    width: 44px;
                    height: 44px;
                    border-radius: 50%;
                }

            }
        }

        .message-wrapper {
            float: right;

            margin: 0 50px;
            .el-badge__content.is-fixed {
                top: 23px;
            }
            svg {
                width: 1.1em;
                height: 1.1em;
            }
        }

    }
</style>




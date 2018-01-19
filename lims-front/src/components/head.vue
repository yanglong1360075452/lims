<template xmlns:v-popover="http://www.w3.org/1999/XSL/Transform">
  <div class="header-wrap">
    <h1 class="header-logo">

      <el-menu theme="dark"   class="el-menu-demo " mode="horizontal" @select="handleSelect">
        <el-menu-item index="1"><h1 class="header-logo"><font size="6">NovoBio</font><font size="3">LIMS</font></h1></el-menu-item>

        <el-submenu index="2">
          <template slot="title">项目管理</template>
          <el-menu-item index="2-1">
            <router-link :to="{ name: 'detail'}" style="color: #20A0FF">新建项目</router-link>
          </el-menu-item>
          <el-menu-item index="2-2" >
            <router-link :to="{ name: 'projects'}" style="color: #20A0FF">未交付项目</router-link>
          </el-menu-item>
          <el-menu-item index="2-3">进行中项目</el-menu-item>
          <el-menu-item index="2-4">已完成项目</el-menu-item>
          <el-menu-item index="2-5">支付生产</el-menu-item>
        </el-submenu>
        <el-submenu index="3">
          <template slot="title">样本管理</template>
          <el-menu-item index="3-1">样本接收</el-menu-item>
          <el-menu-item index="3-2">样本批次查询</el-menu-item>
          <el-menu-item index="3-3">全局样本查询</el-menu-item>
        </el-submenu>
        <el-submenu index="4">
          <template slot="title">任务管理</template>
          <el-menu-item index="4-1">任务调度</el-menu-item>
          <el-menu-item index="4-2">已调度任务</el-menu-item>
          <el-menu-item index="4-3">进行中任务</el-menu-item>
          <el-menu-item index="4-3">已完成任务</el-menu-item>
          <el-menu-item index="4-3">人员工时</el-menu-item>
        </el-submenu>
        <el-menu-item index="5">任务执行</el-menu-item>
        <el-menu-item index="6">库存管理</el-menu-item>
        <el-menu-item index="7">仪器管理</el-menu-item>
        <el-menu-item index="8">试剂耗材</el-menu-item>
        <el-menu-item index="9">统计报告</el-menu-item>
        <el-menu-item index="10">质控</el-menu-item>
        <el-submenu index="11">
          <template slot="title">系统管理</template>

          <el-menu default-active="2" class="el-menu-vertical-demo" theme="">
            <el-submenu index="1">
              <template slot="title">用户角色</template>
              <el-menu-item index="1-1">
                <router-link :to="{ name: 'users'}" style="color: #20A0FF">用户列表</router-link>
              </el-menu-item>
              <el-menu-item index="1-2">
                <router-link :to="{ name: 'roles'}" style="color: #20A0FF">角色列表</router-link>
              </el-menu-item>
              <el-menu-item index="1-3">
                <router-link :to="{ name: 'permission'}" style="color: #20A0FF">权限列表</router-link>
              </el-menu-item>
            </el-submenu>

          </el-menu>
          <el-menu-item index="11-2">应用商店</el-menu-item>
          <el-menu-item index="11-3">流程配置</el-menu-item>
          <el-menu-item index="11-4">系统配置</el-menu-item>
        </el-submenu>
      </el-menu>
    </h1>
    <!--编辑界面-->
          <el-dialog title="用户" :visible.sync="dialogFormVisible" @close="cancels()">
            <el-form :model="user"  label-width="80px" ref="addForm">
              <el-form-item label="用户名">
                <el-input v-model="user.username" placeholder="用户名" :readonly="true" style="width: 200px"></el-input>
              </el-form-item>
              <el-form-item label="密码" v-if="user.id == null">
                <el-input v-model="user.password" placeholder="密码"  :readonly="true" style="width: 200px"></el-input>
              </el-form-item>
              <el-form-item label="用户昵称">
                <el-input v-model="user.nickname" placeholder="用户昵称" :readonly="true" style="width: 200px"></el-input>
              </el-form-item>
              <el-form-item label="手机号">
                <el-input v-model="user.phone" placeholder="手机号"   style="width: 200px"></el-input>
              </el-form-item>
              <el-form-item label="用户说明">
                <el-input v-model="user.note"  placeholder="用户说明" :readonly="true" style="width: 400px"></el-input>
              </el-form-item>
              <el-form-item label="部门">
                <el-input v-model="user.department"  placeholder="部门" :readonly="true" style="width: 400px"></el-input>
              </el-form-item>
              <el-form-item label="职位">
                <el-input v-model="user.position"  placeholder="职位" :readonly="true" style="width: 400px"></el-input>
              </el-form-item>
              <el-form-item label="角色列表">
                <el-checkbox-group v-model="checkedroles">
                  <el-checkbox v-for="role in roles" :label="role.id" :disabled="true" :key="role">{{role.name}}</el-checkbox>
                </el-checkbox-group>
              </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
              <el-button type="text" @click="resetPassword = true" style="float:left;border-bottom:2px solid cornflowerblue;" v-if="user.id!=null">重置用户密码?</el-button>
              <el-button @click="cancels">取 消</el-button>
              <el-button type="primary" @click="operateUser()">确 定</el-button>
            </div>
          </el-dialog>
    <div class="grid-content bg-purple-dark" align="right">
      <el-dialog  :visible.sync="resetPassword" size="tiny" title="重置用户密码" ref="reset1" @close="rpCancle">
        <el-form :model="reset1" :rules="resetRule1" ref="reset1">
          <el-form-item label="原密码" prop="ypass">
            <el-input type="password" v-model="reset1.ypass" v-on:blur="vailpassword()" auto-complete="off" placeholder="请输入原密码">
            </el-input>
            <div class="el-form-item__error" v-if="this.error!=1">{{this.error}}</div>
          </el-form-item>
          <el-form-item label="新密码" prop="pass">
            <el-input type="password" v-model="reset1.pass" auto-complete="off" v-on:blur="vailpassword1()" placeholder="请输入密码"></el-input>
            <div class="el-form-item__error" v-if="this.error1!=2">{{this.error1}}</div>
          </el-form-item>
          <el-form-item label="确认密码" prop="checkPass">
            <el-input type="password" v-model="reset1.checkPass" auto-complete="off" v-on:blur="vailpassword2()" placeholder="请再次输入密码"></el-input>
            <div class="el-form-item__error" v-if="this.error2!=3">{{this.error2}}</div>
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="submitForm('reset1')">提交</el-button>
          <el-button @click="rpCancle">取消</el-button>
        </div>
      </el-dialog>
    </div>
    <div class="user-info">
      <el-dropdown>
              <span class="el-dropdown-link user-name">
              <img class="user-img" @click="open" src="../assets/images/header-img.jpg" alt="">
                {{ user_name }}<i class="el-icon-caret-bottom el-icon--right"></i>
              </span>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item><a @click="safeExit">安全退出</a></el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>


    <!--<el-tabs type="card" style="width:80%;padding-top:4%;margin-left:10%" @tab-click="req">-->
        <!--<el-tab-pane>-->
          <!--<span slot="label"><i class="el-icon-date"></i> 项目详情</span>-->
          <!--我的行程-->
        <!--</el-tab-pane>-->
         <!--<el-tab-pane label="原始样本" ></el-tab-pane>-->
        <!--<el-tab-pane label="任务清单">角色管理</el-tab-pane>-->
        <!--<el-tab-pane label="工作样本">定时任务补偿</el-tab-pane>-->
        <!--<el-tab-pane label="项目报告">定时任务补偿</el-tab-pane>-->
        <!--<el-tab-pane label="项目日志">定时任务补偿</el-tab-pane>-->
      <!--</el-tabs>-->
  </div>
</template>

<script>
  import Util from '../assets/lib/util';
  import LoginService from '../service/login';
  import UserService from '../service/user';
  import RoleService from '../service/role';
  export default {

    name: 'header',
    data () {
      return {
        error:'1',
        error1:'2',
        error2:'3',
        user_name: '',
        user_id:'',
        resetPassword: false,
        dialogFormVisible:false,
        roles:[],
        checkedroles:[],
        user:{
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
        resetRule1: {
//          ypass: [
//            { validator: validatePass, trigger: 'blur' }
//          ],
//          pass: [
//            { validator: validatePass1, trigger: 'blur' }
//          ],
//          checkPass: [
//            { validator: validatePass2, trigger: 'blur' }
//          ]
        },
      };
    },
    created () {
      this.achieveUser();
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      },
      onTabSelected(value) {
        this.selected = value
      },
      open(){
              this.dialogFormVisible = true;
              let that = this;
              UserService.getByName(that.user_name).then(function (response) {

                if(response.code==0 && response.data.username != ""){
                  that.user = response.data;
                  that.getAppRoles();
                  if(that.user.roles != null){
                    for (var i=0;i<that.user.roles.length;i++) {
                      that.checkedroles.push(that.user.roles[i].id);
                    }
                  }
                }else{
                  console.log("没有数据111");
                }
              });

            },
       operateUser(){
               this.$refs.addForm.validate((valid) => {
                 if (valid) {
                   this.is_loading = true;
                   this.user.roles = this.checkedroles;
                   if(this.user.id != undefined){
                       let that = this;
                     UserService.update(that.user).then(function (response) {
                       if(response.code == 0) {
                         that.$message({type: 'success', message: "编辑角色成功"});
                         that.cancels();
                       }
                       else that.$message({type: 'error', message: response.data.reason});
                       that.is_loading = false;
                     });
                   }
                 }else {
                   this.$message({type: 'error', message: "创建用户失败"});
                   this.cancels();
                   return false;
                 }
               });
             },
       getAppRoles(){
           let that = this;
               RoleService.getList({
                 page: 1,
                 length: 1000,
               }).then(function (response) {
                 if(response.data.code == 0) {
                   that.roles = response.data.data.rows;
                 }
               });
             },
      vailpassword: function() {
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
      vailpassword1: function() {
        if (this.reset1.pass == '') {
          this.error1 = "请输入新密码";
        }
        else {
          this.error1 = "";
        }
      },
      vailpassword2: function() {
        if (this.reset1.checkPass == '') {
          this.error2 = "请再次输入新密码";
        } else if (this.reset1.checkPass != this.reset1.pass) {
            this.error2 = "两次输入密码不一致";
        } else {
          this.error2 = "";
        }
      },
      rpCancle(){
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
      cancels(){
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
        this.checkedroles = [];
      },
      submitForm(formName) {
        //this.$refs[formName].validate((valid) => {
          if (this.error =='' && this.error1 =='' && this.error2 =='') {
            var user = {
              id: this.user_id,
              password:this.reset1.checkPass
            };
            this.is_loading = true;
            let that = this;
              UserService.resetPassword(user).then(function (response) {
                that.is_loading = false;
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
       // });
      },
      achieveUser () {
        this.user_name = Util.dataToSessionStorageOperate.achieve('user').username;
      },
      safeExit () {
        let that = this;
        console.log("*************")
        this.$confirm('是否删除安全退出?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
          Util.dataToSessionStorageOperate.clear();
          LoginService.logout(function (response) {
            if(response.code == 0){

              that.$router.push({name:"login"})
//              Util.jumpPage("login");
            }
          });
        });
      }
    }
  }


</script>

<style lang="scss">
  @import "../assets/scss/define";
  .header-wrap{
    height: 60px;
    background-color:	#3c6ab6;
  }
  .header-logo{
    @extend %fl;
    @extend %f22;
    @extend %cfff;
    line-height: 60px;
    margin-left: 20px;
  }
  .user-info{
    @extend %pa;
    @extend %cp;
    top: 10px;
    right: 20px;
  }
  .user-img{
    @extend %vam;
    width: 40px;
    height: 40px;
    margin-right: 5px;
    border-radius: 50%;
  }
  .user-name{
    @extend %cp;
    @extend %cfff;
    @extend %f12;
    @extend %vam;
  }

</style>

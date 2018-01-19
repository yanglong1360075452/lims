<template>
  <div class="container-wrap"  style="width:76.5%;height:90%;margin-left:3.5%;margin-bottom:5%;margin-right:10%">

    <div class="container-box">
      <div class="">

      </div>

      <div class="container-content">
        <el-button type="primary" style="float:right;margin-bottom:2%;margin-right:2%" @click="open()">+新建</el-button>
        <el-table :data="roles" border stripe tooltip-effect="dark" style="width: 100%">
          <el-table-column prop="name" label="角色名"  align="center" width="200"></el-table-column>
          <el-table-column prop="description" label="角色说明"  show-overflow-tooltip align="center" width="290"></el-table-column>
          <el-table-column prop="permissions" label="权限列表"  align="center">

            <template scope="scope">
              <ul>
                <li v-for="item in scope.row.permissions" style="display: inline">
                  {{ item.name }}
                </li>
              </ul>
            </template>

          </el-table-column>
          <el-table-column label="操作" align="center" width="200">
            <template scope="scope">
              <el-button @click="open(scope.row)" type="primary"  size="small">编辑</el-button>
              <el-button  @click="deleteRole(scope.row)" type="danger" :disabled="scope.row.id==1?true:false" size="small">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
      <div class="page-wrap">
        <el-pagination
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-size="pageSize"
          layout="total, prev, pager, next, jumper"
          :total="totalCount">
        </el-pagination>
      </div>
    </div>

    <el-dialog title="角色" :visible.sync="dialogFormVisible" @close="cancel()">
      <el-form :model="role"  :rules="rules" ref="role">
        <el-form-item label="角色名称" :label-width="formLabelWidth" prop="name">
          <el-input v-model="role.name" auto-complete="off" :disabled="role.id==1?true:false"></el-input>
        </el-form-item>
        <el-form-item label="角色描述" :label-width="formLabelWidth">
          <el-input v-model="role.description" auto-complete="off"></el-input>
        </el-form-item>
        <el-form-item label="权限列表" :label-width="formLabelWidth">
            <el-checkbox-group v-model="checkedPermissions">
              <el-checkbox v-for="permission in permissions" :label="permission.id" :disabled="permission.id==1&&role.id == 1?true:false" :key="permission">{{permission.name}}</el-checkbox>
            </el-checkbox-group>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel()">取 消</el-button>
        <el-button type="primary" @click="operateRole()">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
  import RoleService from '../../service/role';
  import PermissionService from '../../service/permission';
  import types from '../../store/mutation-types';
  export default {
    name: 'list',
    data() {
      return {
        disabled:true,
        currentPage:1,
        totalPage: 0,
        pageSize:18,
        totalCount: 0,
        roles: [],
        dialogFormVisible: false,
        formLabelWidth: '100px',
        role:{
          name:null,
          description:null,
          permissions:[]
        },
        permissions:[],
        checkedPermissions:[],
        rules: {
          name: [
            { required: true, message: '请输入角色名称', trigger: 'blur' }
          ]
        }
      }
    },
    created () {
      this.fetchData();
    },
    watch: {
      '$route': 'fetchData'
    },

    methods: {
      cancel(){
        this.dialogFormVisible = false;
        this.role = {
          name:null,
          description:null,
          permissions:[]
        };
        this.checkedPermissions = [];
      },
      open(role){
        this.dialogFormVisible = true;
        this.getPermissions();
        if(role != null){
          this.role = role;
          for (var i=0;i<role.permissions.length;i++) {
            this.checkedPermissions.push(role.permissions[i].id);
          }
        }
      },
      handleCurrentChange (val) {
        this.currentPage = val;
        this.fetchData();
      },
      getPermissions(){
          let that = this;
        PermissionService.getList({
          page: 1,
          length: 1000,
        }).then(function (response) {
          if(response.code == 0) {
            that.permissions = response.data.rows;
          }
        });
      },
      operateRole(){

        this.$refs["role"].validate((valid) => {
          if (valid) {
            this.role.permissions = this.checkedPermissions;
            let that = this;
            if(this.role.id != undefined){
              RoleService.update(that.role).then(function (response) {
                if(response.code == 0) {
                  that.$message({type: 'success', message: "编辑角色成功"});
                  that.dialogFormVisible = false;
                }
                else that.$message({type: 'error', message: response.reason});
                that.fetchData();
              });
            }else {
              RoleService.create(that.role).then(function (response) {
                if(response.code == 0) {
                  that.$message({type: 'success', message: "创建角色成功"});
                  that.dialogFormVisible = false;
                  that.fetchData();
                } else {
                  that.$message({type: 'error', message: "角色名已存在"});
                }
              });
            }
          } else {
            return false;
          }
        });
      },
      /**删除角色*/
      deleteRole ({id,name}) {
        this.$confirm('是否删除'+ name +'?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning'
        }).then(() => {
            let that = this;
          RoleService.delete(id).then(function (response) {
            if(response.code == 0){
              that.fetchData();
              that.$message({type: 'success', message: "删除成功"});
            }else{
              that.$message({type: 'success', message: response.reason});
            }
          }).catch(function () {
            that.$message({type: 'error', message: '当前角色在使用,无法删除'});
          });
        }).catch(() => {
          this.$message({type: 'info', message: '已取消删除'});
        });
      },
      /**获取用户列表数据*/
      fetchData () {
        setTimeout( () => {
            let that = this;
          RoleService.getList({
            page: this.currentPage,
            length: this.pageSize,
          }).then(function (response) {
            if(response.code == 0) {
              that.roles = response.data.rows;
              that.totalPage = response.totalPage;
              that.totalCount = response.data.totalCount;
            }
            else that.$message({type: 'error', message: response.reason});
          });
        },300);
      }
    }
  }
</script>
<style lang="scss">
  @import "../../assets/scss/define";
  .container-content{
  @extend %pa;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    padding: 70px 20px;
    overflow-x: hidden;
    overflow-y: auto;
  }
  .search-box{
  @extend %pa;
    top: 20px;
    right: 40px;
    z-index: 1;
    width: 360px;
  }
  .container-box{
  @extend %h100;
  }
  .page-wrap{
  @extend %pa;
  @extend %tac;
    background-color: #fff;
    z-index: 1;
    left: 0;
    right: 0;
    padding: 10px 0 20px;
    bottom: 0;
  }
</style>

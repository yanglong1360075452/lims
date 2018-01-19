<template>
  <div class="container-wrap">
    <div class="container-box">
      <div class="container-content">
        <el-row>
          <el-col :span="12" style="width:100%">
            <div style="margin: 20px;"></div>
            <div class="grid-content">
              <div style="margin-top:5%">
                <font size="5">项目列表</font>
                <el-button type="primary" style="margin-left:60%">批量交付</el-button>
                <router-link :to="{ name: 'detail'}">
                  <el-button type="primary">新建项目</el-button>
                </router-link>
              </div>
              <hr>
              <div style="margin: 10px">
                <el-form :inline="true" class="demo-form-inline">
                  <el-form-item label="项目状态">
                    <el-select v-model="projectStatus" placeholder="请选择" style="width:110px">
                      <el-option v-for="item in projectStatusList" :key="item.value" :label="item.label" :value="item.value">
                      </el-option>
                    </el-select>
                  </el-form-item>
                  <el-form-item label="项目编号">
                    <el-input v-model="projectNo" placeholder="项目编号" style="width: 100px"></el-input>
                  </el-form-item>
                  <el-form-item label="项目名称">
                    <el-input v-model="projectName" placeholder="项目名称" style="width: 200px"></el-input>
                  </el-form-item>
                  <el-form-item label="创建时间">
                    <el-date-picker
                      v-model="createTime"
                      type="date"
                      placeholder="选择日期"
                      :picker-options="pickerOptions0">
                      style="width: 100px"
                    </el-date-picker>
                  </el-form-item>
                  <el-form-item label="生产状态">
                    <el-select v-model="productStatus" placeholder="请选择" label-width="100px">
                      <el-option v-for="item in products" :key="item.value" :label="item.label" :value="item.value">
                      </el-option>
                    </el-select>
                  </el-form-item>
                </el-form>
                <el-button type="primary" @click="getProjectList()">查询</el-button>
              </div>
              <el-table :data="projects" border style="width: 90%">
                <!--<el-table-column>-->
                <!--</el-table-column>-->
                <el-table-column prop="no" label="项目编号">
                </el-table-column>
                <el-table-column prop="name" label="项目名称" width="200">
                </el-table-column>
                <el-table-column prop="projectStatusDesc" label="项目状态">
                </el-table-column>
                <el-table-column prop="projectTypeDesc" label="项目类型">
                </el-table-column>
                <el-table-column prop="sampleCategoryDesc" label="样本种类" width="100">
                </el-table-column>
                <el-table-column prop="productStatusDesc" label="生产状态">
                </el-table-column>
                <el-table-column prop="createTime" label="创建时间" width="175">
                  <template scope="scope">
                    {{scope.row.createTime | date}}
                  </template>
                </el-table-column>
                <el-table-column prop="planCompleteTime" label="计划完成时间" width="175">
                  <template scope="scope">
                    {{scope.row.planCompleteTime | date}}
                  </template>
                </el-table-column>
                <el-table-column prop="actualCompleteTime" label="实际完成时间" width="140">
                  <template scope="scope">
                    {{scope.row.actualCompleteTime | date}}
                  </template>
                </el-table-column>
                <el-table-column prop="sampleCount" label="样品总数">
                </el-table-column>
                <el-table-column label="操作">
                  <template scope="scope">
                    <router-link :to="{ name: 'detail',params:  { id: scope.row.id}}">
                      <el-button type="text">查看</el-button>
                    </router-link>
                  </template>
                </el-table-column>
              </el-table>
            </div>
          </el-col>
        </el-row>

      </div>
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


</template>
<script>
  import Util from '../../assets/lib/util';
  import ProjectService from '../../service/project';
  import Global from '../../const/Global.vue';
  export  default{
    data(){
      return {
        productStatus:null,
        projectNo:null,
        projectName:null,
        createTime:null,
        projectStatus:null,
        currentPage: 1,
        totalPage: 0,
        pageSize: 5,
        totalCount: 0,
        projectStatusList: [{
          value: null,
          label: "所有"
        }, {
          value:1,
          label: "新建项目"
        }, {
          value: 2,
          label: "样本送达"
        }, {
          value:3,
          label: "待调度"
        },
          {
            value: 4,
            label: "调度完成"
          },
          {
          value: 5,
          label: "生产中"
        }, {
          value: 6,
          label: "项目完成"
        }, {
          value: 7,
          label: "项目终止"
        }],
        statue: "",
        pickerOptions0: {
//          disabledDate(time) {
//            return time.getTime() < Date.now() - 8.64e7;
//          }
        },
        value1: '',
        products: [{
          value: "选项1",
          label: "样本提取"
        }, {
          value: "选项2",
          label: "样本检测"
        }, {
          value: "选项3",
          label: "文库构建"
        }, {
          value: "选项4",
          label: "送样测序"
        }, {
          value: "选项5",
          label: "数据QC"
        }, {
          value: "选项6",
          label: "生信分析"
        }],
        product: "",

        checked: true,
        projects: [],
      }
    },
    created(){
      this.getProjectList();
    },
    methods: {
      getProjectList(){
          let that = this;
        ProjectService.getList({
          productStatus:this.productStatus,
          projectNo:this.projectNo,
          projectName:this.projectName,
          createTime:this.createTime,
          projectStatus:this.projectStatus,
          page: this.currentPage,
          length: this.pageSize,
          filter: this.projectStatus
        }).then(function (response) {
          if (response.code == 0) {
            Global.projectNo =response.data.rows[0].projectNo;
            that.projects = response.data.rows;
            that.totalPage = response.totalPage;
            that.totalCount = response.data.totalCount;
          }
        })
      },
      handleCurrentChange(val){
        this.currentPage = val;
        this.getProjectList();
      }
    }
  }
</script>


<template>
  <div style="width:100%;height:100px">
    <div style="width:20%;height:50px;;padding-top:2%;margin-left:15%"><span style="font-size: 25px;">项目档案</span>
      <span style="color:blue;font-size:20px;margin-left:2%" v-if="projectNo!=null">#{{projectNo}}</span>
    </div>
    <el-tabs type="card"  @tab-click="handleClick" style="width:80%;margin-left:15%">
      <el-tab-pane>
        <span slot="label"><i class="el-icon-date"></i> 项目详情</span>
      </el-tab-pane>
      <el-tab-pane  label="原始样本" ></el-tab-pane>
      <el-tab-pane  label="任务清单"></el-tab-pane>
      <el-tab-pane label="工作样本"></el-tab-pane>
      <el-tab-pane label="项目报告"></el-tab-pane>
      <el-tab-pane label="项目日志"></el-tab-pane>
    </el-tabs>
  </div>
</template>
<script>
import MySample from'../views/project_manager/sample.vue';
import {mapState} from 'vuex';
import ElInput from "../../node_modules/element-ui/packages/input/src/input";
 export default {
          components: {
            ElInput,
            MySample
          },

    data() {
      return {}
    },
   computed: mapState([
     'projectNo'
   ]),
   methods:{
     handleClick(tab, event) {
       if(tab.index=="0"){
         this.$router.push({path:'/project/detail'})
       }else if(tab.index=="1"){
         this.$router.push({path:'/sample'})
       }
     }
   }

  }
</script>
<style lang="scss">
  @import "../assets/scss/define";

</style>

<template>
   <div>
      <page-label title="工作流活动配置详情" :sub-title="activ.name " icon="detection"></page-label>
      <br>
      <div class="form-group-title">Parameters</div>
      <el-table :data="parameters" border fit highlight-current-row>
         <el-table-column property="" label="ID"></el-table-column>
         <el-table-column property="" label="Type"></el-table-column>
         <el-table-column property="" label="Name"></el-table-column>
         <el-table-column property="" label="Comments"></el-table-column>
      </el-table>
      <br>
      <div class="form-group-title">Formula</div>
      <el-table :data="parameters" border fit highlight-current-row>
         <el-table-column property="" label="ID"></el-table-column>
         <el-table-column property="" label="Formula"></el-table-column>
         <el-table-column property="" label="Comments"></el-table-column>
      </el-table>
      <br>
      <div class="form-group-title">Schema Table</div>
      <el-table :data="parameters" border fit highlight-current-row>
         <el-table-column property="" label="Column 1"></el-table-column>
         <el-table-column property="" label="Column 2"></el-table-column>
         <el-table-column property="" label="Column 3"></el-table-column>
      </el-table>
   </div>
</template>

<script>
    import PageLabel from 'components/pageLabel'
    import ElCol from "element-ui/packages/col/src/col";
    import HolesPicture from "../modal/holes";
    import Activ from '@/api/activCfg';

    export default {
        name: 'index',
        components: {
            ElCol,
            PageLabel,
            HolesPicture
        },
        beforeCreate() {

        },
        mounted(){
            this.getInfo(this.$route.params.id);
        },
        data() {
            return {
                activ:{
                    name,
                },
                parameters:[{}]
            }
        },
        methods: {
            getInfo(id){
                Activ.getById(id).then((response) => {
                    if (response.code == 0) {
                        this.activ = response.data;
                    }
                })
            },
        }
    }
</script>

<style lang="scss" scoped>

</style>
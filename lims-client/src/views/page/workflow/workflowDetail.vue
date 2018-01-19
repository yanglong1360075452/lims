<template>
    <div>
        <page-label title="工作流配置详情" :sub-title="workflow.name" icon="detection"></page-label>
        <div class="group">
            <el-row type="flex" justify="space-between">
                <el-col>
                    <span class="taskList">工作流名称：</span><span class="taskContent">{{workflow.name}}</span>
                </el-col>
                <el-col>
                    <span class="taskList">工作流模板ID：</span><span class="taskContent">{{workflow.id}}</span>
                </el-col>
                <el-col>
                    <span class="taskList">版本：</span><span class="taskContent">{{workflow.ver}}</span>
                </el-col>
                <el-col>
                    <span class="taskList">发布时间：</span><span class="taskContent">{{workflow.releaseTime | formatDate}}</span>
                </el-col>
            </el-row>
            <br>
            <el-row type="flex" justify="space-between">
                <el-col>
                    <span class="taskList">工作流描述：</span><span class="taskContent">{{workflow.description}}</span>
                </el-col>
            </el-row>
        </div>
        <br>
        <div class="form-group-title">Workflow Activities</div>
        <el-table :data="workflow.cfgWfActivList" border fit highlight-current-row>
            <el-table-column property="id" label="ActivityID" align="center"></el-table-column>
            <el-table-column property="categoryDesc" label="活动类别" align="center"></el-table-column>
            <el-table-column property="javaClass" label="Class Name" align="center"></el-table-column>
            <el-table-column property="name" label="活动名称" align="center"></el-table-column>
            <el-table-column property="description" label="活动说明" align="center"></el-table-column>
            <el-table-column property="ver" label="版本" align="center"></el-table-column>
            <el-table-column property="releaseTime" label="发布时间" align="center">
                <template scope="scope">
                    <span>{{scope.row.releaseTime | formatDate}}</span>
                </template>
            </el-table-column>
            <el-table-column property="ref" label="引用数"></el-table-column>
        </el-table>
        <br>
        <div class="form-group-title">Workflow Transactions</div>
        <el-table :data="workflow.cfgWfTransList" border fit highlight-current-row>
            <el-table-column property="fromActiv.id" label="From" align="center"></el-table-column>
            <el-table-column property="fromActiv.name" label="Activity" align="center"></el-table-column>
            <el-table-column property="toActiv.id" label="To" align="center"></el-table-column>
            <el-table-column property="toActiv.name" label="Activity" align="center"></el-table-column>
            <el-table-column property="condDesc" label="Condition" align="center"></el-table-column>
            <el-table-column property="condFormula" label="Condition Formula" align="center"></el-table-column>
        </el-table>
        <br>
        <div class="form-group-title">Parameter Dependence Mapping</div>
        <el-table :data="workflow.temp" border fit highlight-current-row>
            <el-table-column property="" label="Activity" align="center"></el-table-column>
            <el-table-column property="" label="Activity Param" align="center"></el-table-column>
            <el-table-column property="" label="Depend Activity" align="center"></el-table-column>
            <el-table-column property="" label="Depend Param" align="center"></el-table-column>
        </el-table>
    </div>
</template>

<script>
    import PageLabel from 'components/pageLabel'
    import ElCol from "element-ui/packages/col/src/col";
    import Workflow from '@/api/workflowCfg';

    export default {
        name: 'index',
        components: {
            ElCol,
            PageLabel
        },
        beforeCreate() {

        },
        mounted(){
            this.getInfo(this.$route.params.id);
        },
        data() {
            return {
                workflow:{
                    id:null,
                    application:null,
                    category:null,
                    categoryDesc:null,
                    name:null,
                    description:null,
                    memo:null,
                    ver:null,
                    releaseTime:null,
                    cfgWfActivList: [],
                    cfgWfTransList:[],
                    temp:[]
                },
            }
        },
        methods: {
            getInfo(id){
                Workflow.getById(id).then((response) => {
                    if (response.code == 0) {
                        this.workflow = response.data;
                    }
                })
            },
        }
    }
</script>

<style lang="scss" scoped>
    @import "~styles/variable";

    .taskList {
        color: #99a9bf;
        font-size: 14px;
    }

    .taskContent {
        color: #2f3445;
        font-size: 14px;
    }
</style>
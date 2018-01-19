<template>
    <div>
        <div class="head-bar clearfix">
            <page-label :title="task.workflow.categoryDesc" :sub-title="task.workflow.name" icon="detection" class="left"></page-label>
            <component v-bind:is="steps" :taskStatus="task.status"></component>
        </div>
        <br>
        <div>
            <el-row :gutter="20">
                <el-col :span="mainTabProportion">
                    <el-tabs type="card" :activeName="paneActive">
                        <el-tab-pane label="任务单" name="taskDetail">
                            <task-detail :task="task" :showButton="true"></task-detail>
                        </el-tab-pane>
                        <el-tab-pane label="任务执行" name="operate" v-if="task.status == this.GLOBAL.TaskStatusEnum.UNDERWAY">
                            <component :task="task" v-bind:is="operate"></component>
                        </el-tab-pane>
                        <el-tab-pane label="报告" name="report" v-if="task.status >= this.GLOBAL.TaskStatusEnum.UNDERWAY">
                            <component :task="task" v-bind:is="report"></component>
                        </el-tab-pane>
                    </el-tabs>
                </el-col>
                <el-col :span="sopTabProportion" v-if="task.status == this.GLOBAL.TaskStatusEnum.UNDERWAY">
                    <el-tabs type="card">
                        <el-tab-pane :label="sopTitle">
                            <component v-bind:is="sop" :task="task"></component>
                        </el-tab-pane>
                    </el-tabs>
                </el-col>
            </el-row>
        </div>
    </div>
</template>

<script>
    import PageLabel from 'components/pageLabel'
    import TaskDetail from 'components/taskDetail'
    import ExtractOperate from 'components/execution/extract/operate'
    import ExtractReport from 'components/execution/extract/report'
    import ExtractSteps from 'components/execution/extract/steps'
    import ExtractSop from 'components/execution/extract/sop'
    import SampleCheckOperate from 'components/execution/sampleCheck/operate'
    import SampleCheckSteps from 'components/execution/sampleCheck/steps'
    import SampleCheckSop from 'components/execution/sampleCheck/sop'
    import Task from '@/api/task';
    import SubTask from '@/api/subTask';
    import ActivCfg from '@/api/activCfg';
    import EventBus from '@/assets/eventBus';

    export default {
        name: 'index',
        components: {
            PageLabel,
            TaskDetail,
            ExtractOperate,
            ExtractReport,
            ExtractSteps,
            ExtractSop,
            SampleCheckOperate,
            SampleCheckSteps,
            SampleCheckSop
        },
        beforeCreate() {

        },
        mounted(){
            let self = this;
            EventBus.$on("paneActive", function (msg) {
                self.paneActive = msg;
            });
            this.id = this.$route.params.id;
            this.getExecutionComponents();
        },
        data() {
            return {
                mainTabProportion:16,//主面板占比
                sopTabProportion:8,//SOP占比
                paneActive:"operate",
                operate: null,
                report: null,
                steps: null,
                sopTitle: null,
                sop: null,
                id:null,//用于接收路径参数
                task: {
                    id: null,
                    sampleAmount: null,
                    planStartTime: null,
                    planCompleteTime: null,
                    actualStartTime: null,
                    actualCompleteTime: null,
                    statusDesc: null,
                    operator: {
                        nickname: null
                    },
                    allotOperator: {
                        nickname: null
                    },
                    job: {
                        typeDesc: null
                    },
                    project: {
                        no: null,
                        name: null,
                        sampleLot: {
                            sampleCategoryDesc: null,
                            sampleTypeDesc: null,
                            speciesDesc: null,
                            saveWayDesc: null
                        }
                    },
                    workflow: {
                        name: null,
                        categoryDesc: null
                    }
                },
            }
        },
        methods: {
            async getTask(){
                if(this.$route.params.task != undefined){
                    this.task=this.$route.params.task;
                }else {
                   await Task.getById(this.id).then(response => {
                        if (response.code == 0) {
                            this.task = response.data;
                        }
                    });
                }
            },
             async getExecutionComponents(){
                await this.getTask();
                 if(this.task.status == this.GLOBAL.TaskStatusEnum.COMPLETE){//完成
                     this.paneActive = "report";
                     this.mainTabProportion = 16;
                     this.sopTabProportion = 8;
                 }
                 if(this.task.status < this.GLOBAL.TaskStatusEnum.UNDERWAY || this.task.status > this.GLOBAL.TaskStatusEnum.COMPLETE){
                     this.paneActive = "taskDetail";
                     this.mainTabProportion = 24;
                     this.sopTabProportion = 0;
                 }else if(this.task.status == this.GLOBAL.TaskStatusEnum.UNDERWAY){//进行中
                     this.paneActive = "operate";
                     this.mainTabProportion = 16;
                     this.sopTabProportion = 8;
                 }
                this.sopTitle = this.task.workflow.name + "SOP";
                 this.steps = this.task.workflow.urlStep;
                 //根据当前subTask查询对应组件名称
                 if(this.task.currentSubTaskId){
                     SubTask.getById(this.task.currentSubTaskId).then(response=>{
                         if(response.code == 0){
                             this.operate = response.data.cfgWfActiv.urlOp;
                             this.report = response.data.cfgWfActiv.urlRpt;
                             this.sop = response.data.cfgWfActiv.urlSop;
                         }
                     })
                 }
            }
        }
    }
</script>

<style lang="scss" scoped>
    @import "~styles/variable";

    .head-bar {
        .left {
            display: flex;
            align-items: center;
            float: left;
        }
    }
</style>
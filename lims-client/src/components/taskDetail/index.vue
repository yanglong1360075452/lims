<template>
    <div>
        <el-form :model="task" class="el-form-custom">
            <el-row>
                <el-col :span="8">
                    <el-form-item label="任务编号:">
                        <span>{{task.id}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="8" style="display: flex;">
                    <el-form-item label="任务状态:" style="flex-grow: 1">
                        <span>{{task.statusDesc}}</span>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="8">
                    <el-form-item label="项目编号:">
                        <span>{{task.project.no}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="16" style="display: flex;">
                    <el-form-item label="项目名称:" style="flex-grow: 1">
                        <span>{{task.project.name}}</span>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="8" style="display: flex;">
                    <el-form-item label="工作内容:" style="flex-grow: 1">
                        <span>{{task.job.typeDesc}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label="样品数量:">
                        <span>{{task.sampleAmount}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label="保存形式:">
                        <span>{{task.project.sampleLot.saveWayDesc}}</span>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="8" style="display: flex;">
                    <el-form-item label="物种分类:" style="flex-grow: 1">
                        <span>{{task.project.sampleLot.speciesDesc}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label="样本类别:">
                        <span>{{task.project.sampleLot.sampleCategoryDesc}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label="样本类型:">
                        <span>{{task.project.sampleLot.sampleTypeDesc}}</span>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="24" style="display: flex;">
                    <el-form-item label="工作流:" style="flex-grow: 1">
                        <span>{{task.workflow.name}}</span>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="8">
                    <el-form-item label="计划开始时间:">
                        <span>{{task.planStartTime | formatDate}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="8" style="display: flex;">
                    <el-form-item label="计划完成时间:" style="flex-grow: 1">
                        <span>{{task.planCompleteTime | formatDate}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label="调度员:">
                        <span>{{task.allotOperator == null ? null : task.allotOperator.nickname}}</span>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="8">
                    <el-form-item label="实际开始时间:">
                        <span>{{task.actualStartTime | formatDate}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="8" style="display: flex;">
                    <el-form-item label="实际完成时间:" style="flex-grow: 1">
                        <span>{{task.actualCompleteTime | formatDate}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="8">
                    <el-form-item label="操作员:">
                        <span>{{task.operator == null ? null : task.operator.nickname}}</span>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="24" style="display: flex;">
                    <el-form-item label="备注:" style="flex-grow: 1">
                        <span>{{task.note}}</span>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
        <div align="center"  v-if="showButton">
            <el-button @click="confirm('开始执行','execute',false)" type="primary" v-if="task.status == this.GLOBAL.TaskStatusEnum.ALLOTTED">开始执行</el-button><!--已分配-->
            <el-button @click="confirm('暂停','pause',false)" v-if="task.status==this.GLOBAL.TaskStatusEnum.UNDERWAY">任务暂停</el-button><!--进行中-->
            <el-button @click="confirm('继续执行','goOn',false)" v-if="task.status==this.GLOBAL.TaskStatusEnum.PAUSE" type="primary">任务继续</el-button><!--暂停-->
            <el-button @click="confirm('终止','termination',true)" v-if="task.status==this.GLOBAL.TaskStatusEnum.UNDERWAY">任务终止</el-button>
            <el-button @click="confirm('完成','finish',false)" v-if="task.status==this.GLOBAL.TaskStatusEnum.UNDERWAY" type="primary">任务完成</el-button>
        </div>
    </div>
</template>

<script>
    import TaskExecution from '@/api/taskExecution';

    export default {
        components: {},
        props: ['task', 'showButton'], //从父组件获取数据
        data(){
            return {}
        },
        methods: {
            confirm(operate, method, danger) {
                if (danger) {
                    this.$confirm('确认' + operate + '任务?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'error',
                        confirmButtonClass: 'el-button--danger'
                    }).then(() => {
                        if (method == "termination") {
                            this.termination();
                        }
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消操作'
                        });
                    });
                } else {
                    this.$confirm('确认' + operate + '任务?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'info',
                    }).then(() => {
                        if (method == "pause") {
                            this.pause();
                        }  else if (method == "goOn") {
                            this.goOn();
                        } else if(method == "finish"){
                            this.finish();
                        }else if(method == "execute"){
                            this.execute();
                        }
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消操作'
                        });
                    });
                }

            },
            execute(){
                TaskExecution.start(this.task.id).then(response=>{
                    if(response.code == 0){
                        this.$message({type: 'success', message: '任务已开始'});
                        location.reload();
                    }else {
                        this.$message.error(response.reason);
                    }
                })
            },
            finish(){
                TaskExecution.finish(this.task.id).then(response=>{
                    if(response.code == 0){
                        this.$message({type: 'success', message: '任务已完成'});
                        location.reload();
                    }else {
                        this.$message.error(response.reason);
                    }
                })
            },
            goOn(){
                TaskExecution.goon(this.task.id).then(response=>{
                    if(response.code == 0){
                        this.$message({type: 'success', message: '任务已继续'});
                        location.reload();
                    }else {
                        this.$message.error(response.reason);
                    }
                })
            },
            termination(){
                TaskExecution.termination(this.task.id).then(response=>{
                    if(response.code == 0){
                        this.$message({type: 'success', message: '任务已终止'});
                        location.reload();
                    }else {
                        this.$message.error(response.reason);
                    }
                })
            },
            pause(){
                TaskExecution.pause(this.task.id).then(response=>{
                    if(response.code == 0){
                        this.$message({type: 'success', message: '任务已暂停'});
                        location.reload();
                    }else {
                        this.$message.error(response.reason);
                    }
                })
            }
        }
    }
</script>

<style  lang="scss">
    .el-form-custom{
        .el-form-item{
            margin-bottom: 10px;
        }
    }
</style>
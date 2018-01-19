<template>
    <div>
        <el-steps :active="active" finish-status="success">
            <el-step title="开始"></el-step>
            <el-step title="样本提取"></el-step>
            <el-step title="结束"></el-step>
        </el-steps>
    </div>
</template>

<script>
    import EventBus from '@/assets/eventBus';

    export default {
        props: ['taskStatus'], //从父组件获取数据
        mounted(){
        },
        computed: {
            //根据父组件传递过来的值,实时计算步骤条active属性值
            active: function () {
                if(this.taskStatus == this.GLOBAL.TaskStatusEnum.COMPLETE){
                    return 3;
                }else if(this.taskStatus == this.GLOBAL.TaskStatusEnum.ALLOTTED){
                    return 1;
                }else {
                    return 2;
                }
            }
        },
        data(){
            return {
            }
        }

    }
</script>
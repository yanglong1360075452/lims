<template>
    <el-steps :active="active" finish-status="success">
        <el-step title="开始"></el-step>
        <el-step title="样本检测"></el-step>
        <el-step title="结束"></el-step>
    </el-steps>
</template>

<script>
    export default {

        data(){
            return {
                active:1
            }
        }

    }
</script>
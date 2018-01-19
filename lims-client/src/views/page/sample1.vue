<template>
    <div>
        <page-label :title="labelData.title" :icon="labelData.icon"></page-label>

        <el-tabs class="tabs-right" v-model="activeName" type="card" @tab-click="handleClick">
            <el-tab-pane label="项目详情" name="first">
                <project-detail-tab @changeState="changeTab"></project-detail-tab>
            </el-tab-pane>
            <el-tab-pane label="样本信息" name="second">
                <sample-info></sample-info>
            </el-tab-pane>
            <el-tab-pane label="任务清单" name="third">角色管理</el-tab-pane>
            <el-tab-pane label="工作样本" name="fourth">定时任务补偿</el-tab-pane>
        </el-tabs>
    </div>
</template>
<script>

    import projectDetailTab  from './tabs/projectDetailTab';
    import sampleInfo  from './tabs/sampleInfo.vue';
    import PageLabel from 'components/pageLabel'

    export default {
        components: {PageLabel, projectDetailTab, sampleInfo},
        mounted(){
            console.log(this.$route)
        },
        data() {
            return {
                activeName: 'first',
            };
        },
//        watch:{
//            "query"(to, from) {
//                console.warn(to, from)
//            }
//        },
        methods: {
            changeTab(name){
                console.log(name)
                this.activeName = name[0];
            },
            handleClick(tab, event) {
                console.log(tab, event);
            }
        },
        computed:{
            query(){
                return this.$route.query;
            },
            labelData(){
                switch (this.activeName){
                    case "first":
                        return {title:"新建项目",icon:"new"};
                        break;
                    case "second":
                        return {title:"项目档案",icon:"record"};
                        break;
                }
            }
        }
    };
</script>

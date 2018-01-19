<template>
    <div>
        <div class="head-bar clearfix" style="margin-bottom: 1%">
            <div class="left">
                <page-label class="pull-left" :title="labelData.title" :icon="labelData.icon"></page-label>
                <span class="pull-left" v-show="projectNo != null">#{{projectNo}}</span>
            </div>
            <div class="right">
                <el-button icon="document" class="pull-left" type="primary" v-show="projectStatus == this.GLOBAL.ProjectStatusEnum.SAMPLE_DELIVERY"
                           @click="confirm('交付生产','delivery',false)">交付生产
                </el-button>
                <el-button icon="document" v-show="projectNo != null && projectStatus<this.GLOBAL.ProjectStatusEnum.DELIVERED" :plain="true" type="danger"
                           @click="confirm('取消','cancel',true)">取消项目
                </el-button>
                <el-button icon="document" v-show="projectStatus==this.GLOBAL.ProjectStatusEnum.CANCEL" type="primary"
                           @click="confirm('恢复','recover',false)">
                    恢复项目
                </el-button>
                <el-button icon="document" v-show="projectStatus>=3 && projectStatus != this.GLOBAL.ProjectStatusEnum.CANCEL" :plain="true" type="danger"
                           @click="confirm('取消生产','cancelProduce',true)">取消生产
                </el-button>
            </div>

        </div>
        <el-tabs class="tabs-right" v-model="activeName" type="card" @tab-click="handleClick">
            <el-tab-pane label="项目详情" name="project">
                <project-detail-tab @changeState="changeState"></project-detail-tab>
            </el-tab-pane>
            <el-tab-pane label="样本信息" name="sample" v-hide="projectStatus < this.GLOBAL.ProjectStatusEnum.NEW_PROJECT">
                <sample-info></sample-info>
            </el-tab-pane>
            <el-tab-pane label="任务清单" name="task" v-if="projectStatus>=this.GLOBAL.ProjectStatusEnum.DELIVERED && projectStatus != this.GLOBAL.ProjectStatusEnum.CANCEL">
                <task-list></task-list>
            </el-tab-pane>
            <!--<el-tab-pane label="工作样本" name="fourth">工作样本</el-tab-pane>-->
        </el-tabs>
    </div>
</template>
<script>
    import {mapGetters} from 'vuex';
    import projectDetailTab  from './tabs/projectDetailTab';
    import sampleInfo  from './tabs/sampleInfo.vue';
    import taskList  from './tabs/taskList.vue';
    import PageLabel from 'components/pageLabel'
    import Project from '@/api/project';

    export default {
        components: {PageLabel, projectDetailTab, sampleInfo, taskList},
        data() {
            return {
                activeName: 'project'
            };
        },
        methods: {
            confirm(operate, method, danger) {
                if (danger) {
                    this.$confirm('确认' + operate + '项目' + this.$store.getters.projectNo + '?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'error',
                        confirmButtonClass: 'el-button--danger'
                    }).then(() => {
                        if (method == "cancel") {
                            this.cancel();
                        } else if (method == "cancelProduce") {
                            this.cancelProduce();
                        }
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消操作'
                        });
                    });
                } else {
                    this.$confirm('确认' + operate + '项目' + this.$store.getters.projectNo + '?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'info',
                    }).then(() => {
                        if (method == "recover") {
                            this.recover();
                        }  else if (method == "delivery") {
                            this.delivery();
                        }
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消操作'
                        });
                    });
                }

            },
            cancel(){
                let id = this.$store.getters.projectId;
                if (id) {
                    Project.cancel(id).then(response => {
                        if (response.code == 0) {
                            this.$message({type: 'success', message: '项目' + this.$store.getters.projectNo + '已取消'});
                            this.$store.commit("setProjectStatus", this.GLOBAL.ProjectStatusEnum.CANCEL);
                        } else {
                            this.$message({type: 'fail', message: response.reason});
                        }
                    });
                } else {
                    this.$message({type: 'info', message: '数据获取有误,请刷新页面重试'});
                }
            },
            recover(){
                let id = this.$store.getters.projectId;
                if (id) {
                    Project.recover(id).then(response => {
                        if (response.code == 0) {
                            this.$message({type: 'success', message: '项目' + this.$store.getters.projectNo + '已恢复'});
                            this.$store.commit("setProjectStatus", response.data);
                        } else {
                            this.$message({type: 'fail', message: response.reason});
                        }
                    });
                } else {
                    this.$message({type: 'info', message: '数据获取有误,请刷新页面重试'});
                }
            },
            cancelProduce(){
                let id = this.$store.getters.projectId;
                if (id) {
                    Project.cancelProduce(id).then(response => {
                        if (response.code == 0) {
                            this.$message({type: 'success', message: '项目' + this.$store.getters.projectNo + '已取消生产'});
                            this.$store.commit("setProjectStatus", this.GLOBAL.ProjectStatusEnum.SAMPLE_DELIVERY);
                            if (this.activeName == "task") {
                                this.activeName = "project";
                            }
                        } else {
                            this.$message({type: 'fail', message: response.reason});
                        }
                    });
                } else {
                    this.$message({type: 'info', message: '数据获取有误,请刷新页面重试'});
                }
            },
            delivery(){
                let id = this.$store.getters.projectId;
                if (id) {
                    Project.delivery([id]).then((response => {
                        if (response.code == 0) {
                            this.$message({type: 'success', message: '项目' + this.$store.getters.projectNo + '已交付生产'});
                            this.$store.commit("setProjectStatus", this.GLOBAL.ProjectStatusEnum.DELIVERED);
                        } else {
                            this.$message({type: 'fail', message: response.reason});
                        }
                    }))
                } else {
                    this.$message({type: 'info', message: '数据获取有误,请刷新页面重试'});
                }
            },
            handleClick(tab, event) {
//                if (this.$route.query.projectId || this.$route.query.projectNo) {
//                    this.$router.replace({
//                        name: 'projectDetail',
//                        query: {title: tab.name, projectId: this.$route.query.projectId,projectNo:this.$route.query.projectNo}
//                    });
//                }
            },
            changeState(val){
                this.activeName = val[0];
            }
        },
        computed: {
            labelData(){
                switch (this.activeName) {
                    case "project":
                        return {title: "项目档案", icon: "new"};
                        break;
                    case "sample":
                        return {title: "项目档案", icon: "record"};
                        break;
                    case "task":
                        return {title: "项目档案", icon: "record"};
                        break;
                }
            },
            ...mapGetters([
                'projectNo',
                'projectId',
                'projectStatus'
            ])
        },
        mounted(){
            let title = this.$route.query.title;
            if (title != null && title != undefined) {
                this.activeName = this.$route.query.title;
            }
            let projectId = this.$route.query.projectId;
            if (projectId != null && projectId != undefined) {
                this.$store.commit("setProjectId", projectId);
            }
            let projectNo = this.$route.query.projectNo;
            if (projectNo != null && projectNo != undefined) {
                this.$store.commit("setProjectNo", projectNo);
            }
        }
    };
</script>
<style rel="stylesheet/scss" lang="scss">

    .head-bar {
        .left {
            display: flex;
            align-items: center;
            float: left;
            /*&>div{*/
            /*margin-right: 5px;*/
            /*}*/
        }

        .right {
            display: flex;
            align-items: center;
            float: right;
            & > div {
                margin-left: 10px;
            }
        }
    }
</style>

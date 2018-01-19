<template>
    <div>
        <el-form :model="task">
            <el-row>
                <el-col :span="6" style="display: flex;">
                    <el-form-item label="物种分类:" style="flex-grow: 1">
                        <span>{{task.project.sampleLot.speciesDesc}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="样本类别:">
                        <span>{{task.project.sampleLot.sampleCategoryDesc}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="样本类型:">
                        <span>{{task.project.sampleLot.sampleTypeDesc}}</span>
                    </el-form-item>
                </el-col>
            </el-row>
            <el-row>
                <el-col :span="6" style="display: flex;">
                    <el-form-item label="提取样本类别:" style="flex-grow: 1">
                        <span>{{task.job.params.sampleCategoryDesc}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="6">
                    <el-form-item label="提取样本类型:" style="flex-grow: 1">
                        <span>{{task.job.params.sampleTypeDesc}}</span>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="提取方法:" :required=true>
                        <el-select v-model="submitData.extractMethod" placeholder="请选择" @change="changeExtractMethod">
                            <el-option v-for="item in extractMethodList" :key="item.id"
                                       :label="item.name"
                                       :value="item.id">
                            </el-option>
                        </el-select>
                    </el-form-item>
                </el-col>
            </el-row>
        </el-form>
        <el-table :data="samples" ref="sampleTable"
                  element-loading-text="拼命加载中"
                  @selection-change="handleSelectionChange" border fit highlight-current-row id="sampleTable">
            <el-table-column type="selection" width="50" v-if="!end">
            </el-table-column>
            <el-table-column align="center" label="样本ID" width="80px" prop="no">
                <template scope="scope"><span>{{scope.row.no}}</span></template>
            </el-table-column>
            <el-table-column width="130px" align="center" label="样本名称" prop="name">
                <template scope="scope">
                    <span>{{scope.row.name}}</span>
                </template>
            </el-table-column>
            <el-table-column width="130px" align="center" label="提取类别" prop="name">
                <template scope="scope">
                    <span>{{scope.row.extractCategoryDesc}}</span>
                </template>
            </el-table-column>
            <el-table-column width="130px" align="center" label="提取类型" prop="name">
                <template scope="scope">
                    <span>{{scope.row.extractTypeDesc}}</span>
                </template>
            </el-table-column>
            <el-table-column align="center" label="提取方法" width="180px" prop="sampleStatusDesc">
                <template scope="scope">
                    <span>{{scope.row.extractMethodDesc}}</span>
                </template>
            </el-table-column>
            <el-table-column align="center" width="110px" label="提取结果" prop="libraryIndex">
                <template scope="scope">
                    <span>{{scope.row.statusDesc}}</span>
                </template>
            </el-table-column>
            <el-table-column width="180px" align="center" label="操作时间" prop="receiveTime">
                <template scope="scope">
                    <span>{{scope.row.operateTime | formatDate}}</span>
                </template>
            </el-table-column>
            <el-table-column align="center" label="操作员" prop="deliverQuality" width="150px">
                <template scope="scope">
                    <span>{{scope.row.operator == null ? null : scope.row.operator.nickname}}</span>
                </template>
            </el-table-column>
            <el-table-column align="center" label="说明" prop="note">
                <template scope="scope">
                    <span>{{scope.row.note}}</span>
                </template>
            </el-table-column>
        </el-table>
        <el-row type="fix" align="middle" style="margin-top: 20px">
            <el-col :span="8">
                <el-button @click="openDialog(1)" v-show="!end">提取成功</el-button>
                <el-button @click="openDialog(2)" v-show="!end">提取失败</el-button>
            </el-col>
            <el-col :span="16" style="float:right;">
                <el-pagination
                        @size-change="sizeChange"
                        @current-change="handleCurrentChange"
                        :current-page="currentPage"
                        :page-sizes="pageSizes"
                        :page-size="pageSize"
                        layout="total, sizes, prev, pager, next, jumper"
                        :total="totalCount">
                </el-pagination>
            </el-col>
        </el-row>

        <el-dialog :visible.sync="dialogFormVisible" size="tiny">
            <el-form :model="submitData">
                <el-form-item label="提取结果:">
                    <el-radio-group @change="changeExecuteStatus" v-model="submitData.executionStatus">
                        <el-radio class="radio" :label=1>成功</el-radio>
                        <el-radio class="radio" :label=2>失败</el-radio>
                    </el-radio-group>
                </el-form-item>
                <el-form-item label="操作说明:" :required="noteRequired">
                    <el-input type="textarea" v-model="submitData.note"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click='extract'>确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    import Task from '@/api/task';
    import DataDict from '@/api/dataDict';
    import SubTask from '@/api/subTask';
    import TaskExecution from '@/api/taskExecution';
    import Extract from '@/api/extract';
    import EventBus from '@/assets/eventBus';

    export default {
        props: ['task'], //从父组件获取数据
        components: {},
        mounted(){
            this.getSampleList();
            if (this.task.status == 4) {
                this.end = true;
            }
            this.getExtractMethod();
        },
        data() {
            return {
                noteRequired: false,
                dialogFormVisible: false,
                subTaskId: null,
                end: false,
                totalCount: 0,
                currentPage: 1,
                pageSize: 10,
                pageSizes: [10, 20, 30, 40],
                activId: 10,
                samples: [],
                extractMethodList: [],
                submitData: {
                    extractMethod: null,
                    sampleIds: [],
                    subTaskId: null,
                    executionId: null,
                    executionStatus: null,
                    note: null
                }
            }
        },
        methods: {
            changeExtractMethod(){
                //通知sop重新加载sop内容
                let sop = "";
                let self = this;
                this.extractMethodList.forEach(function (item) {
                    if(item.id == self.submitData.extractMethod){
                        sop = item.sop;
                        return;
                    }
                })
                EventBus.$emit("extractMethod", sop);
            },
            changeExecuteStatus(){
                if(this.submitData.executionStatus == 2){
                    //失败
                    this.noteRequired = true;
                }else {
                    this.noteRequired = false;
                }
            },
            openDialog(status){
                if (this.submitData.extractMethod == null) {
                    this.$message({type: 'error', message: '请选择提取方法'});
                } else if (this.submitData.sampleIds.length == 0) {
                    this.$message({type: 'error', message: '请勾选样本'});
                } else {
                    this.dialogFormVisible = true;
                    this.submitData.executionStatus = status;
                }
                if (status == 2) {
                    //提取失败,操作说明必填
                    this.noteRequired = true;
                }
            },
            extract(){
                if (this.noteRequired && !this.submitData.note) {
                    this.$message({type: 'error', message: '请填写操作说明'});
                } else {
                    SubTask.start(this.submitData).then(response => {
                        if (response.code == 0) {
                            let executionId = response.data.id;
                            this.submitData.executionId = executionId;
                            SubTask.end(this.submitData).then(response => {
                                if (response.code == 0) {
                                    this.$message({type: 'success', message: '样本提取操作成功'});
                                    this.dialogFormVisible = false;
                                    this.getSampleList();
                                    //通知其他组件更新样本列表
                                    EventBus.$emit("taskStatus", null);
                                    this.submitData.note = null;
                                } else {
                                    this.$message.error(response.reason);
                                }
                            });
                        } else {
                            this.$message.error(response.reason);
                        }
                    });
                }
            },
            getSampleList(){
                this.subTaskId = this.task.currentSubTaskId;
                this.submitData.subTaskId = this.task.currentSubTaskId;
                if (null != this.subTaskId) {
                    SubTask.getSampleListById({
                        id: this.subTaskId,
                        page: this.currentPage,
                        length: this.pageSize
                    }).then(response => {
                        if (response.code == 0 && response.data.totalCount > 0) {
                            this.samples = response.data.rows;
                            this.totalPage = response.totalPage;
                            this.totalCount = response.data.totalCount;
                        }
                    })
                }
            },
            getExtractMethod(){
                Extract.getMethodList({
                    sampleType: this.task.job.params.sampleType,
                    species: this.task.project.sampleLot.species
                }).then(response => {
                    if (response.code == 0) {
                        this.extractMethodList = response.data;
                    }
                });
            },
            handleCurrentChange (val) {
                this.currentPage = val;
                this.getSampleList();
            },
            sizeChange(val){
                this.pageSize = val;
                this.getSampleList();
            },
            handleSelectionChange(rows){
                if (this.submitData.sampleIds.length > 0) {
                    this.submitData.sampleIds.splice(0, this.submitData.sampleIds.length);
                }
                for (let i = 0; i < rows.length; i++) {
                    this.submitData.sampleIds.push(rows[i].id);
                }
            },
        }
    }
</script>

<style lang="scss" scoped>
    @import "~styles/variable";
</style>
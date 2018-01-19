<template>
    <div>
        <task-detail :task="task"></task-detail>
        <el-button type="primary" icon="search" @click="copy">导出pdf页面</el-button>
        <el-table :data="samples" ref="sampleTable"
                  element-loading-text="拼命加载中"
                  border fit highlight-current-row id="sampleTable">
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
        <el-row style="margin-top: 20px;text-align: center">
            <el-col>
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
    </div>
</template>

<script>
    import TaskExecution from '@/api/taskExecution';
    import EventBus from '@/assets/eventBus';
    import TaskDetail from 'components/taskDetail'
    import SubTask from '@/api/subTask';
    import pdfmake from "../../../../node_modules/pdfmake/build/pdfmake";
    import vfsttf from "../../../../node_modules/pdfmake/build/vfs_fonts";
    export default {
        props: ['task'], //从父组件获取数据
        components: {TaskDetail},
        mounted(){
            let self = this;
            EventBus.$on("taskStatus", function (msg) {
                self.getSampleList();
            });
            this.getSampleList();
        },
        data() {
            return {
                ct:{
                    content:[ ],
                    defaultStyle: {
                        font: 'my'
                    },
                },
                totalPage:1,
                totalCount: 0,
                currentPage: 1,
                pageSize: 10,
                pageSizes: [10, 20, 30, 40],
                activId: 10,
                samples: [],
                jobId: this.task.job.id
            }
        },
        methods: {
            htmlToPdfUtil(strs,listTitie,list){
                debugger
                let st = [];
                for(let i=0;i<strs.length;i++){
                    let str = strs[i];
                    let columns= [];
                    for(let j=0;j<str.length;j++){
                        st = str[j].split(",");
                        columns.push({text:st[0]+st[1]});
                    }
                    this.ct.content.push({columns:columns,margin: [ 5, 2, 10, 20 ]});
                }
                let body=[];
                let val=[];
                let lists = [];
                for(let k=0;k<listTitie.length;k++){
                    val.push({ text:listTitie[k],bold:true})
                }
                body.push(val);
                debugger
                for(let i=0;i<list.length;i++){
                    lists=[];
                    lists.push(list[i].no==undefined?"":list[i].no);
                    lists.push(list[i].name==undefined?"":list[i].name);
                    lists.push(list[i].extractCategoryDesc==undefined?"":list[i].extractCategoryDesc);
                    lists.push(list[i].extractTypeDesc==undefined?"":list[i].extractTypeDesc);
                    lists.push(list[i].extractMethodDesc==undefined?"":list[i].extractMethodDesc);
                    lists.push(list[i].statusDesc==undefined?"":list[i].statusDesc);
                    lists.push(list[i].operateTime==undefined?"":this.dateFormatNewDate(list[i].operateTime));
                    lists.push(list[i].operator==undefined?"":list[i].operator.nickname);
                    lists.push(list[i].note==undefined?"":list[i].note);
                    body.push(lists);
                }
                console.log(body)
                this.ct.content.push({table:{headerRows:1,body}});
                console.log(this.ct)
            },
            copy(){
                //数据为空处理
                if(this.task.note==undefined){
                    this.task.note="";
                }
                let strs = [
                    ["任务编号：,"+this.task.id,"任务状态：,"+this.task.statusDesc],
                    ["项目编号：,"+this.task.project.no,"项目名称：,"+this.task.project.name],
                    ["工作内容：,"+this.task.job.typeDesc,"样品数量：,"+this.task.sampleAmount],
                    ["物种分类：,"+this.task.project.sampleLot.speciesDesc,"样本类别：,"+this.task.project.sampleLot.sampleCategoryDesc,"样本类型：,"+this.task.project.sampleLot.sampleTypeDesc],
                    ["工作流：,"+this.task.workflow.name],
                    ["计划开始时间：,"+this.dateFormatNewDate(this.task.planStartTime),"计划完成时间：,"+this.dateFormatNewDate(this.task.planCompleteTime),"调度员：,"+this.task.allotOperator.nickname],
                    ["实际开始时间：,"+this.dateFormatNewDate(this.task.actualStartTime),"实际完成时间：,"+this.dateFormatNewDate(this.task.actualCompleteTime),"操作员：,"+this.task.operator.nickname],
                    ["备注：,"+this.task.note]
                ];
                let listTitle=["样本ID","样本名称","提取类别","提取类型","提取方法","提取结果","操作时间","操作员","说明"];
                //html转pdf通用方法
                this.htmlToPdfUtil(strs,listTitle,this.samples);
                pdfMake.fonts = {
                    my: {
                        normal: 'msyh_boot.ttf',
                        bold: 'yahei.ttf',
                        italics: 'msyh_boot.ttf',
                        bolditalics: 'yahei.ttf'
                    }
                };
                pdfMake.createPdf(this.ct).download();
                this.ct.content=[];
            },
            getSampleList(){
                if (null != this.task.currentSubTaskId) {
                    SubTask.getSampleListById({
                        id: this.task.currentSubTaskId,
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
            handleCurrentChange (val) {
                this.currentPage = val;
                this.getSampleList();
            },
            sizeChange(val){
                this.pageSize = val;
                this.getSampleList();
            },
            dateFormatNewDate(val){
                if (val != null && val != undefined) {
                    var date = new Date(val);
                    var Y = date.getFullYear(),
                        m = date.getMonth() + 1,
                        d = date.getDate();
                    if (m < 10) {
                        m = '0' + m;
                    }
                    if (d < 10) {
                        d = '0' + d;
                    }
                    var t = Y + '-' + m + '-' + d;
                    return t;
                }else{
                    return "";
                }
            }
        }
    }
</script>
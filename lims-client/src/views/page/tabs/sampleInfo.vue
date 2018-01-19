<template>
    <el-row :gutter="20">
        <el-col :span="19" class="leftReset">
            <el-form ref="formInfo" label-position="right" :rules="rules" :model="formInfo" label-width="120px">
                <el-row>
                    <el-col :span="4">
                        <div class="form-group-title">样本信息</div>
                    </el-col>
                    <el-col :span="8" :offset="12">
                        <div v-show="!ifEdit" class="editWrapper">
                            <el-button class="edit" @click.native="edit()">编辑</el-button>
                        </div>
                        <div v-show="ifEdit" class="buttonWrapper">
                            <el-button class="confirm" icon="check" @click.native="confirm()">确认</el-button>
                            <el-button class="cancle" icon="close" @click.native="cancle()">取消</el-button>
                        </div>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="8">
                        <el-form-item label="#批次">
                            <el-input v-show="ifEdit" placeholder="请输入内容" v-model="formInfo.number"></el-input>
                            <span v-show="!ifEdit">{{formInfo.number}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="样本状态">
                            <el-select v-show="ifEdit" placeholder="请选择" v-model="formInfo.statusValue">
                                <el-option v-for="item in formInfo.status" :key="item.value" :label="item.label" :value="item.value">
                                </el-option>
                            </el-select>
                            <span v-show="!ifEdit">{{formInfo.statusValue}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="批次说明">
                            <el-input v-show="ifEdit" placeholder="请输入内容" v-model="formInfo.desc"></el-input>
                            <span v-show="!ifEdit">{{formInfo.desc}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="8">
                        <el-form-item label="样本类别" prop="kinds">
                            <el-select v-show="ifEdit" placeholder="请选择" v-model="formInfo.kinds">
                                <el-option label="DNA" value="1"></el-option>
                                <el-option label="区域二" value="2"></el-option>
                            </el-select>
                            <span v-show="!ifEdit">{{formInfo.kinds | labelToValue}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="物种分类" prop="species">
                            <el-select v-show="ifEdit" placeholder="请选择" v-model="formInfo.species">
                                <el-option label="植物" value="1"></el-option>
                                <el-option label="动物" value="2"></el-option>
                            </el-select>
                            <span v-show="!ifEdit">{{formInfo.species}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                         <el-form-item label="保存类型" :rules="{required:true, message:'请选择活动资源', trigger:'change'}">
                            <el-select v-show="ifEdit" placeholder="请选择" v-model="formInfo.saveType">
                                <el-option label="沉淀溶于无水乙醇" value="1"></el-option>
                            </el-select>
                            <span v-show="!ifEdit">{{formInfo.saveType}}</span>
                        </el-form-item> 
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="8">
                        <el-form-item label="样本来源">
                            <el-input v-show="ifEdit" placeholder="请输入内容" v-model="formInfo.source"></el-input>
                            <span v-show="!ifEdit">{{formInfo.source}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="样本类型">
                            <el-select v-show="ifEdit" placeholder="请选择" v-model="formInfo.type">
                                <el-option label="已打断样本" value="1"></el-option>
                            </el-select>
                            <span v-show="!ifEdit">{{formInfo.type}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="项目引用数">
                            <el-input v-show="ifEdit" placeholder="请输入内容" v-model="formInfo.proms"></el-input>
                            <span v-show="!ifEdit">{{formInfo.proms}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="16">
                        <el-form-item label="样本备注">
                            <el-input v-show="ifEdit" placeholder="请输入内容" v-model="formInfo.slabel"></el-input>
                            <span v-show="!ifEdit">{{formInfo.slabel}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="操作人员">
                            <el-input v-show="ifEdit" placeholder="请输入内容" v-model="formInfo.operator"></el-input>
                            <span v-show="!ifEdit">{{formInfo.operator}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20" v-show="formInfo.showLibrary">
                    <el-col :span="16">
                        <el-form-item label="文库Index位置">
                            <el-select v-show="ifEdit" placeholder="请选择" v-model="formInfo.index">
                                <el-option label="文库位置" value="1"></el-option>
                            </el-select>
                            <span v-show="!ifEdit">{{formInfo.index}}</span>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="文库片段大小">
                            <el-select v-show="ifEdit" placeholder="请选择" v-model="formInfo.piece">
                                <el-option label="文库片段大小" value="1"></el-option>
                            </el-select>
                            <span v-show="!ifEdit">{{formInfo.piece}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20" v-show="formInfo.showLibrary">
                    <el-col :span="24">
                        <el-form-item label="文库结构示例">
                            <el-input v-show="ifEdit" placeholder="请输入内容" v-model="formInfo.struct"></el-input>
                            <span v-show="!ifEdit">{{formInfo.struct}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20" v-show="formInfo.showLibrary">
                    <el-col :span="24">
                        <el-form-item label="文库片段示例">
                            <el-input v-show="ifEdit" placeholder="请输入内容" v-model="formInfo.seg"></el-input>
                            <span v-show="!ifEdit">{{formInfo.seg}}</span>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20" v-show="formInfo.showLibrary">
                    <el-col :span="24">
                        <el-form-item label="附件资料">
                            <el-upload class="upload-demo" action="https://jsonplaceholder.typicode.com/posts/"  :on-remove="handleRemove" :file-list="fileList">
                                <el-button size="small" type="primary" style="border-radius: 4px;">点击上传</el-button>
                                <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
                            </el-upload>
                        </el-form-item>
                    </el-col>
                </el-row>
                <hr/>

                <!--样本清单部分  -->
                <el-row type="flex" align="middle">
                    <el-col :span="4">
                        <div class="form-group-title">样本清单</div>
                    </el-col>
                    <el-col :span="8" :offset="12">
                        <div v-show="!ifTableEdit" class="tableEditWrapper">
                            <el-button class="edit" icon="edit" @click.native="tableEdit()">编辑</el-button>
                        </div>
                        <div v-show="ifTableEdit" class="tableEditWrapper">
                            <el-button class="cancle" icon="edit" @click.native="tableCancle()">退出编辑</el-button>
                        </div>
                    </el-col>
                </el-row>

                <el-row type="flex" align="middle">
                    <el-col :span="8">
                        <div style="margin-top: 15px;margin-bottom: 20px;">
                            <el-input placeholder="请输入内容" v-model="seachSel">
                                <el-select class="seachpre" v-model="seachSelect" slot="prepend" placeholder="请选择">
                                    <el-option label="编号" value="1"></el-option>
                                    <el-option label="样本名称" value="2"></el-option>
                                </el-select>
                                <el-button slot="append" icon="search"></el-button>
                            </el-input>
                        </div>
                    </el-col>
                    <el-col :span="14" :offset="2" v-show="ifTableEdit">
                        <el-button-group style='float:right'>
                            <el-button class="filter-item" @click="editShow(0)" type="primary" icon="edit">新建样本</el-button>
                            <el-upload action="//jsonplaceholder.typicode.com/posts/"  :on-remove="handleRemove" :file-list="importFileList" class='upload-demo'>
                                <el-button class="filter-item" type="primary" icon="document">导入清单</el-button>
                            </el-upload>
                            <el-button class="filter-item loadTemplate" type="primary" icon="document" @click="handleExport">下载模板</el-button>
                        </el-button-group>
                    </el-col>
                </el-row>
                <table class="table">
                    <thead class="thead">
                        <tr>
                            <th v-show="ifTableEdit">
                                <!-- <input type="checkbox" v-model="checkAll" > -->
                                 <el-checkbox v-model="checkAll" @change="changeState()"></el-checkbox>
                            </th>
                            <th>样本ID</th>
                            <th>样本名称</th>
                            <th>制备浓度</th>
                            <th>实测浓度</th>
                            <th>原始体积</th>
                            <th>剩余体积</th>
                            <th>生产时间</th>
                            <th>接收时间</th>
                            <th v-show="ifTableEdit">操作</th>
                        </tr>
                    </thead>
                    
                    <tbody class="tbody">
                        <tr v-for="(list, $index) in tableDataList">
                            <td v-show="ifTableEdit">
                                <!-- <input type="checkbox"> -->
                                 <el-checkbox v-model="list.checked" @change="singleSelect()"></el-checkbox> 
                            </td>
                            <td>{{list.id}}</td>
                            <td>{{list.name}}</td>
                            <td>{{list.sampleConcentration}}</td>
                            <td>{{list.concentration}}</td>
                            <td>{{list.originalVolumn}}</td>
                            <td>{{list.residualVolume}}</td>
                            <td>{{list.productionTime | formatDate}}</td>
                            <td>{{list.receiptTime | formatDate}}</td>
                            <td class="modifyTrData" v-show="ifTableEdit" @click='editShow(1,list)'>修改</td>
                        </tr>
                    </tbody>
                </table>

                <el-row type="fix" align="middle" style="margin-top: 20px">
                    <el-col :span="8">
                        <el-button @click='tableDelete()' v-show="ifTableEdit">删除</el-button>
                    </el-col>
                    <el-col :span="16" style="float:right;">
                            <el-pagination
                                @size-change="handleSizeChange"
                                @current-change="handleCurrentChange"
                                :current-page="currentPage"
                                :page-sizes="[10, 20, 30, 40]"
                                :page-size="10"
                                layout="total, sizes, prev, pager, next, jumper"
                                :total="400">
                            </el-pagination>
                    </el-col>
                </el-row>
                <!--弹框  -->
               <sample-dialog :data="tableDataTemp" :visable="dialogFormVisible" :type="dialogType" @cancle="editCancle()" @submit="editDo()"></sample-dialog>

            </el-form>
        </el-col>

        <el-col :span="5">
            <div class="rightTitle">
                <div class="form-group-title">样本批次</div>
            </div>
            <el-tree :data="data" :props="defaultProps" node-key="sampleId" :default-expanded-keys="[1]" current-node-key="1" :highlight-current="true" @node-click="handleNodeClick"></el-tree>
        </el-col>
    
    </el-row>
     
</template>

<script>
import SampleDialog from '../modal/sample';
import {parseTime} from '../../../utils/index.js';
    export default {
        components:{SampleDialog},
        beforeCreate() {
            this.temp = {};
            this.formInfoList = {
                1: {
                    showLibrary: true,
                    number: '28917293',
                    status: [{
                        value: '选项1',
                        label: '有效'
                    }, {
                        value: '选项2',
                        label: '无效'
                    }],
                    statusValue: '',
                    desc: '无残次品',
                    kinds: '1',
                    species: '1',
                    saveType: '1',
                    source: '样本接收',
                    type: '',
                    proms: '1263',
                    slabel: '样本备注',
                    operator: '操作员',
                    index: '1',
                    piece: '1',
                    struct: '示例结构',
                    seg: '片段示例'
                },
                2: {
                    showLibrary: false,
                    number: 'asdasdasd',
                    status: [{
                        value: '选项1',
                        label: '有效'
                    }, {
                        value: '选项2',
                        label: '无效'
                    }],
                    statusValue: '',
                    desc: '无残次品',
                    kinds: '1',
                    species: '1',
                    saveType: '1',
                    source: '样本接收',
                    type: '1',
                    proms: '1263',
                    slabel: '样本备注',
                    operator: '操作员',
                    index: '1',
                    piece: '1',
                    struct: '示例结构',
                    seg: '片段示例'
                }
            };
            this.tableDataTemp ={};
        },
        mounted() {
        },
        data() {
            return {
                tableDataTemp: {},
                checkAll: false,
                dialogFormVisible: false,
                visible2: false,
                ifEdit: false,
                ifTableEdit: false,
                dialogType:1,
                rules: {
                    kinds: [{
                        required: true,
                        message: '请选择样本类别',
                        trigger: 'change'
                    }],
                    species: [{
                        required: true,
                        message: '请选择物种分类',
                        trigger: 'change'
                    }]
                },
                formInfo: this.formInfoList['1'],
                fileList: [{
                    name: 'food.jpeg',
                    url: 'https://fuss10.elemecdn.com/3/63/4e7f3a15429bfda99bce42a18cdd1jpeg.jpeg?imageMogr2/thumbnail/360x360/format/webp/quality/100'
                }],
                seachSel: '',
                seachSelect: '',
                importFileList: [],
                tableDataList: [{
                    id: '111',
                    name: '甲状腺组织',
                    sampleConcentration: '65%',
                    concentration: '63%',
                    originalVolumn: '44ml',
                    residualVolume: '20ml',
                    productionTime: '2017-03-28',
                    receiptTime: '2017-03-28'
                }, {
                    id: '222',
                    name: '甲状腺组织',
                    sampleConcentration: '65%',
                    concentration: '63%',
                    originalVolumn: '44ml',
                    residualVolume: '20ml',
                    productionTime: '2017-03-28',
                    receiptTime: '2017-03-28'
                }, {
                    id: '333',
                    name: '甲状腺组织',
                    sampleConcentration: '65%',
                    concentration: '63%',
                    originalVolumn: '44ml',
                    residualVolume: '20ml',
                    productionTime: '2017-03-28',
                    receiptTime: '2017-03-28'
                }],
                tableChecked: [],
                // 弹出框数据
                dialogFormData: {},
                listIndex: '',
                listQuery: {
                    page: 1,
                    limit: 10
                },
                currentPage: 1,
                data: [{
                    label: '一级 1',
                    children: [{
                        label: '二级 1-1',
                        children: [{
                            label: '三级 1-1-1',
                            sampleId: '1'
                        }]
                    }]
                }, {
                    label: '一级 2',
                    children: [{
                        label: '二级 2-1',
                        children: [{
                            label: '三级 2-1-1',
                            sampleId: '2'
                        }]
                    }, {
                        label: '二级 2-2',
                        children: [{
                            label: '三级 2-2-1'
                        }]
                    }]
                }],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }
            };
        },
        methods: {
            edit() {
                this.ifEdit = true;
                this.temp = Object.assign({}, this.formInfo);
            },
            cancle() {
                this.ifEdit = false;
                this.formInfo = this.temp;
            },
            confirm() {
                this.$refs.formInfo.validate((valid) => {
                    if (valid) {
                        this.ifEdit = false;
                    } else {
                        return false;
                        this.ifEdit = true;
                    }
                });
            },
            tableEdit() {
                this.ifTableEdit = true;
            },
            tableCancle() {
                this.ifTableEdit = false;
            },
            handleRemove(file, fileList) {
            },
            // 全选、单选
            changeState(){
                let checked = this.checkAll;
                this.tableDataList.forEach(item => {
                    this.$set(item,"checked",checked)
//                    item.checked = checked;
                })
            },
            singleSelect() {
                let selectData = this.tableDataList.filter(item => {
                    return item.checked == true
                })
                // 全选与否
                selectData.length == this.tableDataList.length ? this.checkAll = true : this.checkAll = false;
            },
            //删除表格
            tableDelete() {
                let len = this.tableDataList.length;
                for (let i = 0; i < len; i++) {
                    console.log(this.tableDataList[i].checked,i);
                    if(this.tableDataList[i].checked) {
                        this.tableChecked.push(i);
                    }
                }
                let checkedLength = this.tableChecked.length;
                for(let i = 0; i < checkedLength; i++) {
                    console.log(this.tableChecked[i],"删除数据");
                    this.tableDataList.splice(this.tableChecked[i],1);
                }
            },
            // 下载模板
            handleExport() {
                // require.ensure([], () => {
                //   const { export_json_to_excel } = require('../../vendor/Export2Excel');
                //   const tHeader = ['时间', '地区', '类型', '标题', '重要性'];
                //   const filterVal = ['timestamp', 'province', 'type', 'title', 'importance'];
                //   const data = this.formatJson(filterVal, this.list);
                //   export_json_to_excel(tHeader, data, 'table数据');
                // })
            },
            // 显示弹框
            editShow(type,row){
                 this.dialogType=type;
                //  this.listIndex=_index;
                 //记录数据
                 this.dialogFormData=row || {
                    id: '',
                    name: '',
                    sampleConcentration: '',
                    concentration: '',
                    originalVolumn: '',
                    residualVolume: '',
                    productionTime: '',
                    receiptTime: ''
                 };
                this.tableDataTemp = Object.assign({}, this.dialogFormData);
                 //显示弹窗
                 this.dialogFormVisible=true;
            },
            // 弹框取消按钮
            editCancle() {
                this.dialogFormData = this.tableDataTemp;
                this.dialogFormVisible=false;
            },
            // 弹框确定按钮
            editDo(){
                // 请求后台
                this.tableDataTemp = this.dialogFormData;
                this.dialogFormVisible=false;
            },
            // 分页
            handleSizeChange(val) {
                console.log(`每页 ${val} 条`);
            },
            handleCurrentChange(val) {
                this.currentPage = val;
                console.log(`当前页: ${val}`);
            },
            // 样本批次树
            handleNodeClick(data) {
                let sampleId = data.sampleId;
                console.log(data, sampleId);
                if (sampleId) {
                    console.log(this.formInfo, this.formInfoList, this.formInfoList[sampleId])
                    this.formInfo = this.formInfoList[sampleId];
                }
            }
        },
        filters: {
            formatDate(time) {
                let date = new Date(time);
                return parseTime(date, '{y}-{m}-{d}');
            }
        }
    };
</script>

<style lang="scss" scoped>
    @import "~styles/variable";
    .el-form-item span {
        width: 180px;
        display: inline-block;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
    }
    .seachpre {
        width: 74px;
    } 
    // button
    .editWrapper {
        float: right;
        .edit {
            width: 76px;
            padding: 7px 15px;
            color: $color-theme;
            border: 1px solid $color-theme;
        }
    }
    .filter-item {
        width: 100px;
        // width: 130px;
        height: 36px;
        margin-left: 20px;
        // color: $color-theme;
        border: 1px solid $color-theme;
        // background: none;
        border-radius: 4px !important;
    }

    .buttonWrapper {
        font-size: 12px;
        float: right;
        .confirm,
        .cancle {
            width: 76px;
            padding: 7px 15px;
        }
        .confirm {
            color: $color-theme;
            border: 1px solid $color-theme;
        }
        .cancle {
            color: $color-red;
            border: 1px solid $color-red;
        }
    }
    .tableEditWrapper {
        float: right;
        .edit {
            width: 102px;
            padding: 8px 15px;
            font-size: 13px;
            color: $color-theme;
            border: 1px solid $color-theme;
        }
        .cancle {
            width: 102px;
            padding: 8px 15px;
            font-size: 13px;
            color: $color-red;
            border: 1px solid $color-red;
        }
    }
    //  弹框
    .el-dialog__body .el-input,
    .el-dialog__body .el-date-editor {
        width: 360px !important;
    }
    // 分页
    .el-pagination {
        text-align: right;
        padding: 10px 0;
        float: right;
    }
    .el-pagination__total {
        float: left;
    }
    .upload-demo {
        float: left;
        .el-button {
            color: $color-theme;
            border-radius: 0px;
            background: none;
            border: 1px solid $color-theme;
        }
    }
    .loadTemplate {
        color: #2f3445;
        background: none;
        border: solid 1px #c0ccda !important;
    }
    .leftReset {
        padding-right: 20px !important;
    }
    .rightTitle {
        height: 50px;
        padding: 18px 0 18px 10px;
        line-height: 50px;
        box-sizing: border-box;
        background-color: #eff2f7;
        .form-group-title {
            margin: 0;
        }
    }
    // 表格
    .table {
        color: #2f3445;
        font-size: 13px;
        border: 1px solid #e0e6ed;
        .thead {
            background-color: #e5e9f2;
            th {
                width: 130px;
                height: 44px;
                text-align: center;
                border-right: 1px solid #e0e6ed;
            }
        }
        .tbody {
            tr {
                height: 46px;
                width: 130px;
                text-align: center;
                border-top: 1px solid #e0e6ed;
                    td {
                        border-right: 1px solid #e0e6ed;
                    }
                    .modifyTrData {
                        color: #5c7dfe;
                    }
                }
        }
    }
</style>
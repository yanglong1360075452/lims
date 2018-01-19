<template>
    <el-row :gutter="20">
        <el-col :span="showRightTab ? 19 : 24" class="leftReset">
            <el-row>
                <el-col :span="4">
                    <div class="form-group-title" style="margin-top: 8px">样本信息</div>
                </el-col>
                <el-col :span="8" :offset="12">
                    <div v-show="!ifEdit" class="tableEditWrapper">
                        <el-button class="edit" icon="edit" @click.native="edit()" v-show="commonEdit">
                            {{sampleLot.id == null ? "新建" : "编辑"}}
                        </el-button>
                        <el-button @click.native="showRight()">{{buttonText}}</el-button>
                    </div>
                    <div v-show="ifEdit" class="buttonWrapper">
                        <el-button class="confirm" icon="check" @click.native="confirm()">确认</el-button>
                        <el-button class="cancel" icon="close" @click.native="cancel()">取消</el-button>
                    </div>
                </el-col>
            </el-row>
            <el-form ref="form" label-position="right" :rules="rules" :model="sampleLot" label-width="120px"
                     v-show="sampleLot.id != null || ifEdit">
                <el-row :gutter="20">
                    <el-col :span="8">
                        <el-form-item label="批次" prop="no">
                            <el-input readonly="true" :readonly="true" v-model="sampleLot.no"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="16">
                        <el-form-item label="批次说明">
                            <el-input :readonly="!ifEdit" placeholder="请输入批次说明"
                                      v-model="sampleLot.description"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="8">
                        <el-form-item label="样本类别" prop="sampleCategory">
                            <el-select :readonly="true" v-model="sampleLot.sampleCategory">
                                <el-option v-for="item in sampleCategoryList" :key="item.id" :label="item.description"
                                           :value="item.id"></el-option>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="物种分类" prop="species">
                            <el-select :readonly="true" v-model="sampleLot.species">
                                <el-option v-for="item in speciesList" :key="item.id" :label="item.description"
                                           :value="item.id"/>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="样本来源" prop="sampleSource">
                            <el-input :readonly="true" v-model="sampleLot.sampleSourceDesc==null?'原始样本':sampleLot.sampleSourceDesc"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="8">
                        <el-form-item label="保存形式" prop="saveWay">
                            <el-select :readonly="!ifEdit" placeholder="请选择" v-model="sampleLot.saveWay"
                                       @change="changeSave()">
                                <el-option v-for="item in saveWayList" :key="item.id" :label="item.description"
                                           :value="item.id"/>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="样本类型" prop="sampleType">
                            <el-select :class="{readonly:true}" placeholder="请选择" v-model="sampleLot.sampleType">
                                <el-option v-for="item in sampleTypeList" :key="item.id" :label="item.description"
                                           :value="item.id"/>
                            </el-select>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="项目引用数">
                            <el-input :readonly="true" placeholder="请输入内容" value="1"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <el-row :gutter="20">
                    <el-col :span="16">
                        <el-form-item label="样本备注">
                            <el-input :readonly="!ifEdit" placeholder="请输入样本备注"
                                      v-model="sampleLot.sampleNote"></el-input>
                        </el-form-item>
                    </el-col>
                    <el-col :span="8">
                        <el-form-item label="操作人员">
                            <el-input :readonly="true" v-model="name"></el-input>
                        </el-form-item>
                    </el-col>
                </el-row>
                <div v-show="showLibrary">
                    <el-row :gutter="20">
                        <el-col :span="16">
                            <el-form-item label="文库Index位置">
                                <el-select :class="{readonly:!ifEdit}" placeholder="请选择"
                                           v-model="sampleLot.libraryIndex">
                                    <el-option v-for="item in libraryIndexList" :key="item.id" :label="item.description"
                                               :value="item.id"/>
                                </el-select>
                            </el-form-item>
                        </el-col>
                        <el-col :span="8">
                            <el-form-item label="文库片段大小">
                                <el-select :readonly="!ifEdit" placeholder="请选择" v-model="sampleLot.librarySize">
                                    <el-option v-for="item in librarySizeList" :key="item.id" :label="item.description"
                                               :value="item.id"/>
                                </el-select>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="24">
                            <el-form-item label="文库结构示例">
                                <el-input :readonly="!ifEdit" placeholder="请输入文库结构示例"
                                          v-model="sampleLot.libraryStructure"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                    <el-row :gutter="20">
                        <el-col :span="24">
                            <el-form-item label="文库片段示例">
                                <el-input :readonly="!ifEdit" placeholder="请输入文库片段示例"
                                          v-model="sampleLot.libraryFragment"></el-input>
                            </el-form-item>
                        </el-col>
                    </el-row>
                </div>

                <el-row :gutter="20">
                    <el-col :span="24">
                        <el-form-item label="附件资料">
                            <el-upload
                                    class="upload-demo"
                                    ref="upload"
                                    :action="uploadUrl"
                                    :data="uploadData"
                                    :file-list="fileList"
                                    :on-change="changeFile"
                                    :with-credentials="true"
                                    :auto-upload="false"
                                    v-show="ifEdit"
                            >
                                <el-button slot="trigger" size="small" type="primary">选取文件</el-button>
                            </el-upload>
                            <div v-show="!ifEdit && sampleLot.affix != null" class="flex-y-center">
                                <span style="width: auto">{{affixShow}}</span>
                                &nbsp;
                                <el-button type="primary" @click="downloadAffix">下载</el-button>
                            </div>
                        </el-form-item>
                    </el-col>
                </el-row>
                <hr/>

                <!--样本清单部分  -->
                <el-row type="flex" align="middle" v-show="sampleLot.id!=null">
                    <el-col :span="4">
                        <div class="form-group-title">样本清单</div>
                    </el-col>
                    <el-col :span="8" :offset="12">
                        <div v-show="!ifTableEdit" class="tableEditWrapper">
                            <el-button class="edit" icon="edit" @click.native="tableEdit()" v-show="commonEdit">编辑
                            </el-button>
                        </div>
                        <div v-show="ifTableEdit" class="buttonWrapper">
                            <el-button class="confirm" icon="check" @click.native="samplesConfirm()">确认</el-button>
                            <el-button class="cancel" icon="close" @click.native="samplesCancel()">取消</el-button>
                        </div>
                    </el-col>
                </el-row>

                <el-row type="flex" align="middle" v-show="sampleLot.id!=null">
                    <el-col :span="8">
                        <div style="margin-top: 15px;margin-bottom: 20px;">
                            <el-input :readonly="false" placeholder="请输入内容" v-model="key_word">
                                <el-select class="searchPre" v-model="searchSelect" slot="prepend" placeholder="请选择">
                                    <el-option label="编号" value="1"></el-option>
                                    <el-option label="样本名称" value="2"></el-option>
                                </el-select>
                                <el-button slot="append" icon="search" @click="handleIconClick"></el-button>
                            </el-input>
                        </div>
                    </el-col>
                    <div class="filter-container">
                        <el-button-group class="buttonGroup">
                            <el-button v-show="ifTableEdit" @click="handleCreate" type="primary">
                                <icon-svg icon-class="xjyb"/>
                                新建样本
                            </el-button>
                            <el-upload v-show="ifTableEdit" action="" class="upload-demo" :file-list="importSampleFile"
                                       :on-change="importExcel"
                                       :show-file-list="false" :auto-upload="false" ref="importSample">
                                <el-button slot="trigger">
                                    <icon-svg icon-class="lead"/>
                                    导入清单
                                </el-button>
                            </el-upload>
                        </el-button-group>

                        <span class="wrapper buttonLine">
                            <el-button @click="download()" v-show="!ifTableEdit">
                                <icon-svg icon-class="download"/>
                                导出清单
                            </el-button>
                            <el-button style="margin-left: 10px" @click='sampleReceive' :plain="true" type="success"
                                       v-show="sampleTable.samples.length>0 && !ifTableEdit && projectStatus < this.GLOBAL.ProjectStatusEnum.DELIVERED">
                                <icon-svg icon-class="download"/>
                                样本接收
                            </el-button>
                            <el-button style="margin-left: 10px" @click='samplesReject' :plain="true" type="danger"
                                       v-show="sampleTable.samples.length>0 && !ifTableEdit && projectStatus < this.GLOBAL.ProjectStatusEnum.DELIVERED">
                                <icon-svg icon-class="download"/>
                                样本退回
                            </el-button>
                        </span>
                    </div>
                </el-row>

                <el-table :data="sampleTable.samples" ref="sampleTable" v-show="sampleLot.id!=null"
                          element-loading-text="拼命加载中"
                          @selection-change="handleSelectionChange" border fit highlight-current-row id="sampleTable">
                    <el-table-column type="selection" width="55">
                    </el-table-column>
                    <el-table-column align="center" label="样本ID" width="80px" prop="no">
                        <template scope="scope"><span>{{scope.row.no}}</span></template>
                    </el-table-column>

                    <el-table-column width="150px" align="center" label="样本名称" prop="name">
                        <template scope="scope">
                            <el-input v-show="ifTableEdit" size="small" v-model="scope.row.name"></el-input>
                            <span v-show="!ifTableEdit">{{scope.row.name}}</span>
                        </template>
                    </el-table-column>
                    <el-table-column align="center" label="样本状态" width="95px" prop="sampleStatusDesc">
                        <template scope="scope">
                            <span>{{scope.row.sampleStatusDesc}}</span>
                        </template>
                    </el-table-column>

                    <el-table-column align="center" label="文库Index" prop="libraryIndex" v-if="showLibrary">
                        <template scope="scope">
                            <el-input v-show="ifTableEdit" size="small" v-model="scope.row.libraryIndex"></el-input>
                            <span v-show="!ifTableEdit">{{scope.row.libraryIndex}}</span>
                        </template>
                    </el-table-column>

                    <el-table-column align="center" label="送样质量" prop="deliverQuality" v-if="showDeliveryQuality">
                        <template scope="scope">
                            <el-input v-show="ifTableEdit" size="small"
                                      v-model="scope.row.deliverQuality"></el-input>
                            <span v-show="!ifTableEdit">{{scope.row.deliverQuality}}</span>
                        </template>
                    </el-table-column>

                    <el-table-column align="center" label="送样浓度" prop="deliverConcentration" v-if="showLiquidAttribute">
                        <template scope="scope">
                            <el-input v-show="ifTableEdit" size="small"
                                      v-model="scope.row.deliverConcentration"></el-input>
                            <span v-show="!ifTableEdit">{{scope.row.deliverConcentration}}</span>
                        </template>
                    </el-table-column>
                    <el-table-column align="center" label="实测浓度" prop="actualConcentration" v-if="showLiquidAttribute">
                        <template scope="scope">
                            <span>{{scope.row.actualConcentration}}</span>
                        </template>
                    </el-table-column>
                    <el-table-column label="原始体积" align="center" prop="initVolume" v-if="showLiquidAttribute">
                        <template scope="scope">
                            <el-input v-show="ifTableEdit" size="small"
                                      v-model="scope.row.initVolume"></el-input>
                            <span v-show="!ifTableEdit">{{scope.row.initVolume}}</span>
                        </template>
                    </el-table-column>
                    <el-table-column align="center" label="剩余体积" prop="surplusVolume" v-if="showLiquidAttribute">
                        <template scope="scope">
                            <span>{{scope.row.surplusVolume}}</span>
                        </template>
                    </el-table-column>
                    <el-table-column align="center" label="备注" prop="note">
                        <template scope="scope">
                            <el-input v-show="ifTableEdit" size="small" v-model="scope.row.note"></el-input>
                            <span v-show="!ifTableEdit">{{scope.row.note}}</span>
                        </template>
                    </el-table-column>

                    <el-table-column width="180px" align="center" label="生产时间" prop="productTime">
                        <template scope="scope">
                            <span>{{scope.row.productTime | formatDate}}</span>
                        </template>
                    </el-table-column>
                    <el-table-column width="180px" align="center" label="接收时间" prop="receiveTime">
                        <template scope="scope">
                            <span>{{scope.row.receiveTime | formatDate}}</span>
                        </template>
                    </el-table-column>
                </el-table>

                <el-row type="fix" align="middle" style="margin-top: 20px" v-show="sampleLot.id!=null">
                    <el-col :span="2">
                        <el-button @click='deleteBatch' v-show="ifTableEdit && sampleTable.samples.length>0">批量删除
                        </el-button>
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
            </el-form>
        </el-col>

        <el-col :span="5" v-show="showRightTab">
            <div class="rightTitle">
                <div class="form-group-title">样本批次</div>
            </div>
            <el-tree :data="sampleLotBarList" :props="defaultProps" node-key="sampleLotId" :default-expanded-keys="[1]"
                     current-node-key="1" :highlight-current="true" @node-click="handleNodeClick"></el-tree>
        </el-col>

    </el-row>

</template>

<script>
    import SampleDialog from '../../modal/sample';
    import dataDict from '@/api/dataDict';
    import sampleLot from '@/api/sampleLot';
    import sample from '@/api/sample';
    import Project from '@/api/project';
    import Util from '@/utils/util';
    import {setTabDisabled} from '@/utils/projectTabUtil';
    import {readExcel, exportExcel} from '@/utils/excelUtils';
    import {mapGetters} from 'vuex';

    export default {
        components: {
            SampleDialog
        },
        mounted() {
            this.$store.commit("setProjectId", this.$route.query.projectId);
            //获取项目样本批次信息
            if (this.$route.query.projectId) {
                this.projectId = this.$route.query.projectId;
                this.getSampleLotByProjectId();
                this.getSampleLotBarList();
            }
            let id = null;
            for (let i = 0; i < this.typeArray.length; i++) {
                //查询数据字典(将所有的不需要联动的数据查询出来)
                this.getDict(id, this.typeArray[i].type);
            }
        },
        data() {
            return {
                projectStatus: null,
                importSampleFile: [],
                commonEdit: true,
                buttonText: '>',
                showRightTab: true,
                uploadData: {id: null},
                affixShow: "",
                projectId: null,
                sampleIds: [],
                checkAll: false,
                key_word: null,
                sampleNo: null,
                showLibrary: false,
                showDeliveryQuality: false,
                showLiquidAttribute: false, //保存方式为液体显示特质(送样浓度/原始体积/实测浓度/送样体积)
                totalCount: 0,
                currentPage: 1,
                pageSize: 10,
                pageSizes: [10, 20, 30, 40],
                qualifiedList: [
                    {
                        value: null,
                        label: "请选择"
                    },
                    {
                        value: true,
                        label: '是'
                    },
                    {
                        value: false,
                        label: '否'
                    }
                ],
                rules: {
                    saveWay: [{required: true, message: '请选择保存形式', trigger: 'blur', type: 'number'}],
                },
                //数据字典字段
                typeArray: [{type: 3}, {type: 4}, {type: 11}, {type: 12}],
                saveWayList: [],
                speciesList: [],
                sampleTypeList: [],
                libraryIndexList: [],
                librarySizeList: [],
                sampleCategoryList: [],
                //样本批次model
                sampleLot: {
                    id: null,
                    projectId: null,
                    no: '',
                    affix: null,
                    operator: null,
                    sampleNote: '',
                    description: '',
                    sampleSource: null,
                    sampleSourceDesc: null,
                    sampleCategory: null,
                    species: null,
                    saveWay: null,
                    sampleType: null,
                    libraryIndex: null,
                    librarySize: null,
                    libraryStructure: '',
                    libraryFragment: ''
                },
                sampleTable: {
                    id: null,
                    samples: []
                },
                //样本清单model
                sample: {
                    id: null,
                    no: '',
                    name: '',
                    deliverConcentration: '',
                    actualConcentration: '',
                    deliverQuality: '',
                    initVolume: '',
                    libraryIndex: '',
                    surplusVolume: '',
                    productTime: null,
                    receiveTime: null,
                    storageLocation: '',
                    productStatus: null,
                    qualified: null,
                    disqualifiedReason: '',
                    note: '',
                },
                checkAll: false,
                ifEdit: false,
                ifTableEdit: false,
                fileList: [],
                searchSelect: '',
                importFileList: [],
                currentPage: 1,
                sampleLotBarList: [{
                    label: '原始样本',
                    children: [{
                        label: '',
                        sampleLotId: null,
                    }]
                }, {
                    label: '工作样本',
                    children: [{
                        label: '',
                        sampleLotId: null,
                    }]
                }],
                defaultProps: {
                    children: 'children',
                    label: 'label'
                }
            };
        },
        computed: {
            uploadUrl(){
                return process.env.BASE_API + "/sampleLot/upload";//+ this.sampleLot.id;
            },
            ...mapGetters(['name'])
        },
        methods: {
            //导出清单
            download(){
                let columns = this.$refs.sampleTable.$children.filter(t => t.prop != null);
                const fieldNames = columns.map(t => t.label);
                let data = [];
                let table = document.querySelectorAll("#sampleTable table");
                let trs = table[1].children[1].children;
                if (trs.length > 0) {
                    for (let i = 0; i < trs.length; i++) {
                        let td = trs[i].children;
                        let json = {};
                        for (let j = 1; j < td.length; j++) {//不包括CheckBox,下标从1开始
                            json[fieldNames[j - 1]] = td[j].innerText.replace(new RegExp("\n", "gm"), "");//替换\n
                        }
                        data.push(json);
                    }
                } else {
                    let json = {};
                    for (let i = 0; i < fieldNames.length; i++) {
                        json[fieldNames[i]] = "";
                    }
                    data.push(json);
                }
                exportExcel(data, "xlsx", "样本清单");
            },
            //导入清单
            importExcel(file, fileList) {
                if (fileList.length > 1) {
                    fileList.splice(0, 1);//文件列表保留最后一个文件
                }
                if (this.$refs["importSample"].uploadFiles.length == 0) {
                    return;
                }
                let finalFile = this.$refs["importSample"].uploadFiles[0],
                    types = finalFile.name.split('.')[1],
                    fileType = ["xlsx", "xlc", "xlm", "xls", "xlt", "xlw", "csv"].some(item => item === types);
                if (!fileType) {
                    this.$message({type: 'info', message: "文件格式有误,请重新选择!"});
                    return;
                }
                readExcel(finalFile.raw).then(tabJson => {
                    if (tabJson && tabJson.length > 0) {
                        let columns = this.$refs.sampleTable.$children.filter(t => t.prop != null);
                        for (let i = 0; i < tabJson.length; i++) {
                            let sample = {};
                            for (let prop in tabJson[i]) {
                                for (let j = 0; j < columns.length; j++) {
                                    if (prop == columns[j].label) {
                                        sample[columns[j].prop] = tabJson[i][prop];
                                        break;
                                    }
                                }
                            }
                            sample.no = null;
                            sample.sampleStatusDesc = null;
                            this.sampleTable.samples.push(sample);
                        }
                    }
                });
            },
            samplesConfirm(){
                if (this.sampleTable.samples.length > 0) {
                    let sampleLot = {id: this.sampleLot.id, samples: []};
                    for (let i = 0; i < this.sampleTable.samples.length; i++) {
                        let item = this.sampleTable.samples[i];
                        if (item.name == null || item.name == '') {
                            this.$message({type: 'info', message: "请完善样本信息"});
                            return;
                        }
                        if (Util.dateUtil.checkDate(item.productTime)) {
                            item.productTime = Util.dateUtil.dateFormatNewDate(item.productTime);
                        } else {
                            item.productTime = null;
                        }
                        if (Util.dateUtil.checkDate(item.receiveTime)) {
                            item.receiveTime = Util.dateUtil.dateFormatNewDate(item.receiveTime);
                        } else {
                            item.receiveTime = null;
                        }
                        sampleLot.samples.push(item);
                    }
                    sample.batchOperate(sampleLot).then(response => {
                        if (response.code == 0) {
                            this.$message({type: 'success', message: '保存成功'});
                            this.ifTableEdit = false;
                            setTabDisabled(false);
                            this.getSampleList();
                        }
                    });
                } else {
                    this.ifTableEdit = false;
                }
            },
            samplesCancel(){
                this.ifTableEdit = false;
                setTabDisabled(false);
                this.getSampleList();
            },
            changeFile(file, fileList){
                if (fileList.length > 1) {
                    fileList.shift();
                }
            },
            downloadAffix(){
                window.open(process.env.BASE_API + "/sampleLot/download/" + this.sampleLot.id, "_self");
            },

            handleSelectionChange(rows){
                if (this.sampleIds.length > 0) {
                    this.sampleIds.splice(0, this.sampleIds.length);
                }
                for (let i = 0; i < rows.length; i++) {
                    this.sampleIds.push(rows[i].id);
                }
            },
            //样本接收
            sampleReceive(){
                if (this.sampleIds.length <= 0) {
                    this.$message({type: 'info', message: '请选中需要接收的样本'});
                    return;
                } else {
                    sample.receive({
                        sampleLotId: this.sampleLot.id,
                        sampleIds: this.sampleIds
                    }).then(response => {
                        if (response.code == 0) {
                            this.getSampleList();
                            this.$message({type: 'success', message: "样本接收成功"});
                        }
                    });
                }
            },
            //样本退回
            samplesReject(){
                if (this.sampleIds.length <= 0) {
                    this.$message({type: 'info', message: '请选中需要退回的样本'});
                    return;
                } else {
                    sample.reject({
                        sampleLotId: this.sampleLot.id,
                        sampleIds: this.sampleIds
                    }).then(response => {
                        if (response.code == 0) {
                            this.getSampleList();
                            this.$message({type: 'success', message: "样本退回成功"});
                        } else {
                            this.$message({type: 'success', message: response.response});
                        }
                    });
                }
            },
            //样本批量删除
            deleteBatch(){
                if (this.sampleIds.length == 0) {
                    this.$message({type: 'info', message: '请勾选需要删除的样本'});
                } else {
                    this.$confirm('确认删除所有勾选的样本?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        sample.delete(this.sampleIds).then(response => {
                            if (response.code == 0) {
                                this.$message({type: 'success', message: '样本删除成功'});
                                this.ifTableEdit = false;
                                setTabDisabled(false);
                                this.getSampleList();
                            } else {
                                this.$message({type: 'error', message: '删除失败'});
                            }
                        });
                    }).catch(() => {
                        this.$message({type: 'info', message: '已取消删除'});
                    });
                }
            },
            handleIconClick(){
                if (!this.searchSelect) {
                    this.$message({type: 'info', message: '请选择要查询的内容'});
                    return;
                } else if (this.searchSelect == 1 && this.key_word != null) {
                    this.sampleNo = this.key_word;
                    this.filter = null;
                } else if (this.searchSelect == 2 && this.key_word != null) {
                    this.filter = this.key_word;
                    this.sampleNo = null;
                }
                this.getSampleList();
            },
            handleCurrentChange (val) {
                this.currentPage = val;
                this.getSampleList();
            },
            sizeChange(val){
                this.pageSize = val;
                this.getSampleList();
            },
            //获取项目批次列表信息
            getSampleLotBarList(){
                let projectId = this.$route.query.projectId;
                if (projectId) {
                    sampleLot.getBarList(projectId, (result) => {
                    }).then(response => {
                        if (response.code == 0) {
                            let originalSampleLot = response.data.originalSampleLot;
                            if (originalSampleLot != null) {
                                this.sampleLotBarList[0].children[0].sampleLotId = originalSampleLot.id;
                                this.sampleLotBarList[0].children[0].label = "#" + originalSampleLot.no + " " + originalSampleLot.sampleCategoryDesc + originalSampleLot.saveWayDesc;
                                let workSampleLots = response.data.workSampleLots;
                                if (workSampleLots != null && workSampleLots.length > 0) {
                                    let that = this;
                                    workSampleLots.forEach(function (item, index) {
                                        that.sampleLotBarList[1].children[index].sampleLotId = item.id;
                                        that.sampleLotBarList[1].children[index].label = "#" + item.no + " " + item.sampleCategoryDesc + item.saveWayDesc;
                                    })
                                }
                            }
                        }
                    });
                }
            },
            getSampleList(){
                if (null != this.sampleLot.id) {
                    sample.getList({
                        sampleLotId: this.sampleLot.id,
                        page: this.currentPage,
                        length: this.pageSize,
                        filter: this.filter,
                        sampleNo: this.sampleNo
                    }).then(response => {
                        if (response.code == 0 && response.data.totalCount > 0) {
                            this.sampleTable.samples = response.data.rows;
                            this.totalPage = response.totalPage;
                            this.totalCount = response.data.totalCount;
                            Project.getById(this.projectId).then(response => {
                                if (response.code == 0) {
                                    this.$store.commit("setProjectStatus", response.data.projectStatus);
                                }
                            });
                        }
                    })
                }
            },
            //获取项目样本批次信息
            getSampleLotByProjectId(){
                if (this.projectId) {
                    sampleLot.getByProjectId({projectId:this.projectId,sampleLotId:this.sampleLot.id}).then(response => {
                        if (response.code == 0) {
                            if (response.data.id != null && response.data.id != undefined) {
                                this.sampleLot = response.data;
                                if (this.sampleLot.affix != null) {
                                    let position = this.sampleLot.affix.lastIndexOf("\\");
                                    if (position != -1) {
                                        let file = {
                                            uid: new Date().getTime(),
                                            name: this.sampleLot.affix.substr(position + 1)
                                        };
                                        this.affixShow = file.name;
                                        this.fileList = [];
                                        this.fileList.push(file);
                                    }
                                }
                                this.sampleLot.projectId = response.data.project.id;
                                if (this.sampleLot != null && (this.sampleLot.sampleCategory == 13 || this.sampleLot.sampleCategory == 15)) {
                                    this.showLibrary = true;
                                } else {
                                    this.showLibrary = false;
                                }
                                this.getSampleList();
                                this.projectStatus = response.data.project.projectStatus;
                                if (this.projectStatus >= this.GLOBAL.ProjectStatusEnum.DELIVERED) { //已交付生产不能修改
                                    this.commonEdit = false;
                                }
                            } else {
                                this.sampleLot.projectId = this.projectId;
                                this.sampleLot.sampleCategory = response.data.project.sampleCategory;
                                this.sampleLot.species = response.data.project.species;
                                this.sampleLot.sampleType = response.data.project.sampleType;
                            }
                            //查询保存方式列表
                            this.getDict(response.data.project.sampleCategory,  this.GLOBAL.DictTypeEnum.SAMPLE_SAVE_WAY);
                            this.getSaveWay(this.sampleLot.saveWay);
                            this.getSampleType(this.sampleLot.sampleType);
                            this.changeSave();
                            this.$store.commit("setProjectNo", response.data.project.no);
                            this.$store.commit("setProjectStatus", this.projectStatus);
                        }
                    });
                }
            },
            getSampleType(id){
                dataDict.getDictById(id).then(response => {
                    if (response.code == 0) {
                        let sampleType = {id: id, description: response.data};
                        this.sampleTypeList.push(sampleType);
                    }
                })
            },
            getSaveWay(id){
                dataDict.getDictById(id).then(response => {
                    if (response.code == 0) {
                        let saveWay = {id: id, description: response.data};
                        this.saveWayList.push(saveWay);
                    }
                })
            },
            changeSave(){
                let sampleCategory = this.sampleLot.sampleCategory;
                let saveWayId = this.sampleLot.saveWay;
                if (sampleCategory == 16 || sampleCategory == 143) {//组织样本/核酸序列
                    this.showLiquidAttribute = false;
                    this.showDeliveryQuality = false;
                    this.showLibrary = false;
                } else if (sampleCategory == 13 || sampleCategory == 15) { //DNA/RNA文库
                    this.showLibrary = true;
                    if (saveWayId == 78 || saveWayId == 81) {//溶于ddH2O
                        this.showLiquidAttribute = true;
                        this.showDeliveryQuality = false;
                    } else {
                        this.showLiquidAttribute = false;
                        this.showDeliveryQuality = true;
                    }
                } else if (sampleCategory == 12 || sampleCategory == 14) { //DNA/RNA
                    this.showLibrary = false;
                    if (saveWayId == 68 || saveWayId == 69 || saveWayId == 75 || saveWayId == 76) {//沉淀溶于无水乙醇/干粉
                        this.showLiquidAttribute = false;
                        this.showDeliveryQuality = true;
                    } else {
                        this.showLiquidAttribute = true;
                        this.showDeliveryQuality = false;
                    }
                }
            },
            getDict(id, type){
                dataDict.get({
                    parentId: id,
                    type: type
                }).then(response => {
                    if (response.code == 0) {
                        if (type == this.GLOBAL.DictTypeEnum.SAMPLE_CATEGORY) {
                            this.sampleCategoryList = response.data;
                        } else if (type == this.GLOBAL.DictTypeEnum.SPECIES) {
                            this.speciesList = response.data;
                        } else if (id != null && type == this.GLOBAL.DictTypeEnum.SAMPLE_SAVE_WAY) {
                            this.saveWayList = response.data;
                        } else if (id != null && type == this.GLOBAL.DictTypeEnum.SAMPLE_TYPE) {
                            this.sampleTypeList = response.data;
                        } else if (type == this.GLOBAL.DictTypeEnum.LIBRARY_INDEX) {
                            this.libraryIndexList = response.data;
                        } else if (type == this.GLOBAL.DictTypeEnum.LIBRARY_SIZE) {
                            this.librarySizeList = response.data;
                        }
                    }
                });
            },
            showRight() {
                this.showRightTab = !this.showRightTab;
                this.buttonText = this.showRightTab ? '>' : '<';
            },
            edit() {
                if (this.ifTableEdit) {
                    this.$message({type: 'info', message: '请先保存样本清单内容'});
                } else {
                    this.ifEdit = true;
                    setTabDisabled(true);
                }
            },
            cancel() {
                this.ifEdit = false;
                setTabDisabled(false);
                this.getSampleLotByProjectId();
            },
            confirm() {
                this.$refs.form.validate((valid) => {
                    if (valid) {
                        if (this.sampleLot.id == null && this.sampleLot.projectId != null) {
                            sampleLot.create(this.sampleLot).then(response => {
                                if (response.code == 0) {
                                    this.sampleLot.id = response.data;
                                    if (this.$refs.upload.uploadFiles.length > 0) {
                                        this.uploadData.id = this.sampleLot.id;
                                        this.$refs.upload.submit();
                                    }
                                    this.$message({type: 'success', message: "创建样本批次成功"});
                                    this.ifEdit = false;
                                    setTabDisabled(false);
                                    this.getSampleLotBarList();
                                    this.getSampleLotByProjectId();
                                }
                                else  this.$message({type: 'error', message: response.reason});
                            });
                        } else if (null != this.sampleLot.id && null != this.$route.query.projectId) {
                            if (this.$refs.upload.uploadFiles.length == 0) {
                                this.sampleLot.deleteAffix = true;
                            } else {
                                this.sampleLot.deleteAffix = false;
                            }
                            sampleLot.update(this.sampleLot).then(response => {
                                if (response.code == 0) {
                                    this.uploadData.id = this.sampleLot.id;
                                    this.$refs.upload.submit();
                                    this.getSampleLotBarList();
                                    setTimeout(() => {
                                        this.getSampleLotByProjectId();
                                    }, 1000);
                                    this.ifEdit = false;
                                    setTabDisabled(false);
                                    this.$message({type: 'success', message: "修改样本批次成功"});
                                }
                                else  this.$message({type: 'error', message: response.reason});
                            });
                        }
                    }
                });
            },
            tableEdit() {
                if (this.ifEdit) {
                    this.$message({type: 'info', message: '请先保存样本批次信息'});
                } else {
                    this.ifTableEdit = true;
                    setTabDisabled(true);
                }

            },
            // 行内创建表格
            handleCreate() {
                this.sampleTable.samples.unshift({
                    id: null,
                    name: "",
                    no: null,
                    libraryIndex: null,
                    deliverQuality: null,
                    deliverConcentration: null,
                    actualConcentration: null,
                    initVolume: null,
                    surplusVolume: null,
                    qualified: null,
                    disqualifiedReason: "",
                    storageLocation: "",
                    note: "",
                    productTime: null,
                    receiveTime: null,
                    edit: true
                })
            },
            // 样本批次树
            handleNodeClick(data) {
                let sampleLotId = data.sampleLotId;
                if (sampleLotId) {
                    console.log(sampleLotId);
                    this.sampleLot.id = sampleLotId;
                    this.getSampleLotByProjectId();
                }
            }
        },
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

    .searchPre {
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
        .cancel {
            width: 76px;
            padding: 7px 15px;
        }
        .confirm {
            color: $color-theme;
            border: 1px solid $color-theme;
        }
        .cancel {
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
        .cancel {
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

    .buttonGroup {
        float: right;
        button {
            margin-left: 10px;
        }
    }

    .buttonLine {
        margin-left: 10px;

    }
</style>
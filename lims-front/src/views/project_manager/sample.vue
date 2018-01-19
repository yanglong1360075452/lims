<template>
<div class="container-wrap" style="width:100%;height:1200px;margin-top:8%">
  <!--<div style="width:20%;height:50px;;padding-top:2%;margin-left:5%"><span style="font-size: 25px;">项目档案</span><span style="color:blue;font-size:20px;margin-left:2%" v-if="this.sampleLotDto.no!=''">#{{this.sampleLotDto.no}}</span></div>-->
     <div style="width:70%;height:30px;margin-left:4.5%;background-color:#D7D7D7"><span style="font-size:18px">样本信息</span> </div>
     <div style="position:absolute;left:75.5%;top:-0%">
              <div style="width:99%;height:30px;background-color:#D7D7D7;margin-left:0.5%"><span style="font-size:18px">样本批次</span> </div>
                 <el-row class="tac">
                  <el-col :span="8" style="width:170px">
                    <el-menu default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose">
                      <el-submenu index="1">
                        <template slot="title"><i class="el-icon-message"></i>原始样本</template>
                        <el-menu-item-group>
                          <el-menu-item index="1-1" >{{this.sampleLotBarVO.textValue}}</el-menu-item>
                        </el-menu-item-group>
                      </el-submenu>
                      <el-menu-item index="2"><i class="el-icon-menu"></i>工作样本</el-menu-item>
                    </el-menu>
                  </el-col>
                 </el-row>
               </div>
                    <div style="margin: 20px"></div>
                    <el-row style="width:70%;margin-left:4.5%;background-color:#D7D7D7">
                      <el-col :span="12" style="width:100%">
                        <div style="margin: 20px;"></div>
                        <div class="grid-content">
                          <el-form :inline="true" :model="sampleLotDto" :rules="sampleRules" ref="sample"  class="demo-form-inline" label-width="100px">
                            <el-form-item label="#批次">
                              <el-input  placeholder="" v-model="sampleLotDto.no" :readonly="this.sampleLotDto.id==null?false:true" style="width: 200px"></el-input>
                            </el-form-item>

                            <el-form-item label="批次说明">
                              <el-input placeholder="" v-model="sampleLotDto.description" :readonly="isShow==false?true:false" style="width: 400px"></el-input>
                            </el-form-item>

                            <el-form-item label="状态">
                              <el-select v-model="status" placeholder="请选择" :disabled="isShow==false?true:false">
                                    <el-option v-for="item in statu" :key="item.value" :label="item.label" :value="item.value">
                                  </el-option>
                                </el-select>
                              </el-form-item>
                              <el-button type="primary" v-show="isShow" v-on:click="cancle">取消</el-button>
                                <el-button type="primary" ref="show1" id="edit" @click="editOradd" v-if="this.$route.params.id!=null">{{isShow==false?'编辑':'保存'}}</el-button>
                            <br>

                             <el-form-item label="样本类别*">
                                <el-select v-model="sampleLotDto.sampleCategory"  placeholder="请选择" :disabled="true"   @change="changeData">
                                    <el-option  v-for="item in sampleCategoryList"  :key="item.id" :label="item.description" :value="item.id">
                                    </el-option>
                                </el-select>
                              </el-form-item>

                            <el-form-item label="物种分类*">
                              <el-select v-model="sampleLotDto.species" placeholder="请选择" :disabled="true" >
                                  <el-option  v-for="item in speciesList"  :key="item.id" :label="item.description" :value="item.id">
                                  </el-option>
                                </el-select>
                            </el-form-item>

                            <el-form-item label="保存形式">
                                <el-select v-model="sampleLotDto.saveWay" placeholder="请选择" :disabled="isShow==false?true:false" @change ="changeSave()">
                                    <el-option  v-for="item in saveWayList" :key="item.id" :label="item.description" :value="item.id">
                                    </el-option>
                                  </el-select>
                              </el-form-item>

                            <el-form-item label="样本来源">
                              <el-input placeholder="" v-model="sampleLotDto.sampleSource" :readonly="isShow==false?true:false" style="width: 200px"></el-input>
                            </el-form-item>
                            <br>

                            <el-form-item label="样本类型*">
                                <el-select v-model="sampleLotDto.sampleType" placeholder="请选择" :disabled="isShow==false?true:false">
                                    <el-option  v-for="item in sampleTypeList" :key="item.id" :label="item.description" :value="item.id">
                                    </el-option>
                                  </el-select>
                             </el-form-item>

                             <el-form-item label="项目引用数">
                                  <el-input placeholder="":readonly="isShow==false?true:false" style="width: 200px" value="1"></el-input>
                              </el-form-item>
                           <el-form-item label="操作人员">
                                <el-input placeholder=""  :readonly="true" style="width: 200px" value="墨白"></el-input>
                            </el-form-item>
                                <br>
                            <el-form-item label="样本备注">
                              <el-input placeholder="" v-model="sampleLotDto.sampleNote" :readonly="isShow==false?true:false" style="width: 1000px"></el-input>
                            </el-form-item>
                            <br>
                            <el-form-item label="" v-show="samplleTYpe==true?true:false">
                            <label class="el-form-item__label" style="width: 120px;">文件Index位置</label>
                                <el-select v-model="sampleLotDto.libraryIndex" placeholder="请选择">
                                    <el-option  v-for="item in libraryIndexList" :key="item.id" :label="item.description" :value="item.id">
                                    </el-option>
                               </el-select>
                             </el-form-item>

                             <el-form-item label="" v-show="samplleTYpe==true?true:false">
                             <label class="el-form-item__label" style="width: 120px;">文库片段大小</label>
                                 <el-select v-model="sampleLotDto.librarySize" placeholder="请选择">
                                     <el-option  v-for="item in librarySizeList" :key="item.id" :label="item.description" :value="item.id">
                                     </el-option>
                                   </el-select>
                              </el-form-item>
                            <el-form-item style="position: absolute; margin-left:170px" label="" v-show="samplleTYpe==true?true:false">
                              <label class="el-form-item__label" style="width: 120px">附件资料</label>
                                <div style="float:right">
                                    <el-upload class="upload-demo" drag action="https://jsonplaceholder.typicode.com/posts/"  multiple>
                                      <i class="el-icon-upload"></i>
                                      <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                                      <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
                                    </el-upload>
                                   </div>
                            </el-form-item>
                             <br>
                             <el-form-item style="margin-top:40px" label="文库结构示例" v-show="samplleTYpe==true?true:false">
                               <el-input placeholder="" v-model="sampleLotDto.libraryStructure" :disabled="false" style="width: 800px"></el-input>
                             </el-form-item>
                             <br>
                             <el-form-item style="padding-bottom: 60px;" label="文库片段示例" v-show="samplleTYpe==true?true:false">
                                <el-input placeholder="" v-model="sampleLotDto.libraryFragment" :disabled="false" style="width: 800px"></el-input>
                              </el-form-item>
                          </el-form>
                        </div>
                      </el-col>
                    </el-row>

                    <div style="width:70%;height:30px;margin-top:2%;margin-left:4.5%;background-color:#D7D7D7"><span style="font-size:18px">样本清单</span></div>
                     <!--新增界面-->
                       <el-dialog title="样本信息" size="large" style="margin-top:25%" :visible.sync="dialogFormVisible" @close="cancels()">
                               <el-table :data="tableData3" border stripe tooltip-effect="dark" style="width: 100%">
                                    <el-table-column inline-template label="样本ID" v-if="sampleDto.no!=''">
                                      <div>
                                        <el-input  v-model="sampleDto.no" :readonly="true"> </el-input>
                                      </div>
                                    </el-table-column>
                                    <el-table-column inline-template label="样本名称">
                                     <div>
                                       <el-input  v-model="sampleDto.name"> </el-input>
                                     </div>
                                     </el-table-column>

                                 <el-table-column inline-template label="文库Index" v-if="this.wk==true">
                                   <div>
                                     <el-input  v-model="sampleDto.libraryIndex"> </el-input>
                                   </div>
                                 </el-table-column>
                                 <el-table-column inline-template label="送样质量" v-if="this.syll==true">
                                   <div>
                                     <el-input  v-model="sampleDto.deliverQuality"> </el-input>
                                   </div>
                                 </el-table-column>

                                 <el-table-column inline-template label="送样浓度" v-if="this.synd==true">
                                   <div>
                                     <el-input  v-model="sampleDto.deliverConcentration"> </el-input>
                                   </div>
                                 </el-table-column>
                                 <el-table-column inline-template label="实测浓度" v-if="this.scnd==true">
                                   <div>
                                     <el-input  v-model="sampleDto.actualConcentration"> </el-input>
                                   </div>
                                 </el-table-column>
                                     <el-table-column  inline-template label="原始体积" v-if="this.ystj==true">
                                       <div>
                                          <el-input  v-model="sampleDto.initVolume"> </el-input>
                                        </div>
                                    </el-table-column>
                                    <el-table-column  inline-template label="剩余体积" v-if="this.sytj==true">
                                      <div>
                                         <el-input  v-model="sampleDto.surplusVolume"> </el-input>
                                       </div>
                                   </el-table-column>
                                   <el-table-column  inline-template label="生产时间">
                                       <div>
                                         <el-date-picker v-model="sampleDto.productTime" format="yyyy-MM-dd" type="date" placeholder="选择日期">
                                         </el-date-picker>
                                        </div>
                                    </el-table-column>
                                   <el-table-column  inline-template label="接收时间">
                                     <div>
                                       <el-date-picker  v-model="sampleDto.receiveTime" format="yyyy-MM-dd"  type="date" placeholder="选择日期">
                                       </el-date-picker>
                                      </div>
                                   </el-table-column>
                                     <el-table-column  inline-template label="是否合格">
                                       <div>
                                         <el-select v-model="sampleDto.qualified" placeholder="请选择">
                                           <el-option v-for="item in qualifiedList" :key="item.value" :label="item.label" :value="item.value"></el-option>
                                         </el-select>
                                       </div>
                                     </el-table-column>

                                     <el-table-column  inline-template label="不合格原因">
                                       <div>
                                         <el-input  v-model="sampleDto.disqualifiedReason"> </el-input>
                                       </div>
                                     </el-table-column>

                                     <el-table-column  inline-template label="备注">
                                       <div>
                                         <el-input  v-model="sampleDto.note"> </el-input>
                                       </div>
                                     </el-table-column>

                                  <el-table-column  inline-template label="库位">
                                    <div>
                                       <el-input  v-model="sampleDto.storageLocation"> </el-input>
                                     </div>
                                 </el-table-column>

                                 <el-table-column  inline-template label="生产状态">
                                   <div>
                                      <el-select v-model="sampleDto.productStatus" placeholder="请选择">

                                      </el-select>
                                    </div>
                                </el-table-column>

                                  </el-table>

                             <div slot="footer" class="dialog-footer">
                               <el-button type="primary" @click="saveSample()">保  存</el-button>
                             </div>
                       </el-dialog>
                  <div class="" style="width:70%;height:100%;margin-left:4.5%">
                  <label class="el-form-item__label">编号/名称</label>
                                    <el-input placeholder="" :disabled="false" v-model="key_word" style="width: 200px"></el-input>
                                    <el-button type="primary" icon="search"  @click="handleIconClick">查询</el-button>
                           <el-button type="primary" style="float:right" @click="download()" v-if="this.$route.params.id!=null">下载模板</el-button>
                           <el-button type="primary" style="float:right" v-if="this.$route.params.id!=null">导入清单</el-button>
                           <el-button type="primary" style="float:right" @click="addSample" v-if="this.$route.params.id!=null">新建样本</el-button>
                          <el-table :data="samples1" border stripe tooltip-effect="dark" style="width:100%" ref="sampleTable">
                                  <el-table-column  label="样本ID" prop="no" class="el-table__column-resize-proxy"> </el-table-column>
                                  <el-table-column  label="样本名称" prop="name"> </el-table-column>
                                  <el-table-column  label="文库Index" prop="libraryIndex"  v-if="this.wk==true"> </el-table-column>
                                  <el-table-column  label="送样质量" prop="deliverQuality" v-if="this.syll==true"> </el-table-column>
                                  <el-table-column  label="送样浓度" prop="deliverConcentration" v-if="this.synd==true"> </el-table-column>
                                  <el-table-column  label="实测浓度" prop="actualConcentration" v-if="this.scnd==true"> </el-table-column>
                                  <el-table-column  label="原始体积" prop="initVolume" v-if="this.ystj==true"> </el-table-column>
                                  <el-table-column  label="剩余体积" prop = "surplusVolume" v-if="this.sytj==true"> </el-table-column>
                                  <el-table-column  label="生产时间" prop = "productTime">
                                   <template scope="scope">
                                     {{scope.row.productTime | date}}
                                   </template>
                                   </el-table-column>
                                  <el-table-column  label="接收时间" prop = "receiveTime">
                                     <template scope="scope">
                                       {{scope.row.receiveTime | date}}
                                     </template>
                                   </el-table-column>

                                  <el-table-column  label="是否合格" prop = "qualified">
                                    <template scope="scope">
                                      {{scope.row.qualified==true?'是':'否'}}
                                    </template>
                                  </el-table-column>

                                  <el-table-column  label="不合格原因" prop = "disqualifiedReason"> </el-table-column>
                                  <el-table-column  label="备注" prop = "note"> </el-table-column>
                                  <el-table-column  label="库位" prop = "storageLocation"> </el-table-column>
                                  <el-table-column  label="生产状态" prop = "productStatus"> </el-table-column>
                                  <el-table-column label="操作" align="center" width="100">
                                    <template scope="scope">
                                      <el-button  @click="deleteSample(scope.row)" type="text" size="small" >删除</el-button>
                                      <el-button  @click="editSample(scope.row)" type="text" size="small">编辑</el-button>
                                    </template>
                                  </el-table-column>
                          </el-table>
                          <div class="page-wrap" style="width:70%">
                            <el-pagination
                              @current-change="handleCurrentChange"
                              :current-page="currentPage"
                              :page-size="pageSize"
                              layout="total, prev, pager, next, jumper"
                              :total="totalCount">
                            </el-pagination>
                          </div>
                      </div>


 </div>



</template>
<script>
  import Util from '../../assets/lib/util';
  import UserService from '../../service/user';
  import SampleService from '../../service/sample';
  import SampleLotService from '../../service/sampleLot';
  import DataDictService from '../../service/dataDict';
  import types from '../../store/mutation-types';
  export default {
    data() {
      return {
         tableData3: [{id: '',name:''}],
        isShow:false,
        key_word:null,
        samplleTYpe:false,
        sampleShow:false,
        wk:false,
        syll:false,
        synd:false,
        scnd:false,
        ystj:false,
        sytj:false,
        dialogFormVisible:false,
        currentPage:1,
        totalPage: 0,
        pageSize:5,
        totalCount: 0,
        sampleRules: {
          no: [
            {required: true, message: '请输入项目编号', trigger: 'blur'}
          ]
        },
        statu: [{
                  value: '1',
                  label: '活动'
                }, {
                  value: '2',
                  label: '删除'
                }],
                status: '',
        qualifiedList:[{
          value: true,
          label: '是'
        },
        {
          value:false,
          label:'否'
        }
        ],
        //数据字典字段
        typeArray:[{type:3},{type:4},{type:11},{type:12}],
        saveWayList:[],
        speciesList:[],
        sampleTypeList:[],
        libraryIndexList:[],
        librarySizeList:[],
        sampleCategoryList:[],
        //样本批次model
        sampleLotDto:{
          id:null,
          projectId:null,
          no:'',
          operator:null,
          sampleNote:'',
          description:'',
          sampleSource:null,
          sampleCategory:null,
          species:null,
          saveWay:null,
          sampleType:null,
          libraryIndex:null,
          librarySize:null,
          libraryStructure:'',
          libraryFragment:''
        },
//        //项目样本批次信息
//        projectId:null,

        sampleLotDto1:{
          id:null,
          samples:[],
          productTime:null,
          receiveTime:null,
          productStatus:null
        },
        //操作人员信息
        user:{},
        //样本清单model
        sampleDto:{
          id:null,
          no:'',
          name:'',
          deliverConcentration:'',
          actualConcentration:'',
          deliverQuality:'',
          initVolume:'',
          libraryIndex:'',
          surplusVolume:'',
          productTime:null,
          receiveTime:null,
          storageLocation:'',
          productStatus:null,
          qualified:null,
          disqualifiedReason:'',
          note:'',
        },
        //项目样本批次列表
        sampleLotBarVOList:null,
        sampleLotBarVO:{
          id:null,
          no:'',
          sampleCategory:null,
          sampleCategoryDesc:'',
          saveWay:null,
          saveWayDesc:'',
          textValue:''
        },
        //显示项目样本列表数据modelData
        samples1:[],
      }
   },
            created () {
              //获取项目样本批次信息
              this.sampleLotDto.projectId = this.$route.params.id;
              this.getsampleLotDtoByProjectId();
              this.getsampleLotBarList();
              var id = null;
              for(let i=0; i<this.typeArray.length;i++){
                //查询数据字典(将所有的不需要联动的数据查询出来)
                 this.getDict(id,this.typeArray[i].type);
              }
             },
      methods:{
        handleOpen(key, keyPath) {
          console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
          console.log(key, keyPath);
        },
        download(){
          let columns = this.$refs.sampleTable.$children.filter(t => t.prop != null);
          const fields = columns.map(t => t.prop);
          const fieldNames =  columns.map(t => t.label);
          Util.download(null, fields, fieldNames, '样本清单模板')
        },
        handleCurrentChange(val){
          this.currentPage = val;
          this.getSampleList();
        },
        //获取项目批次列表信息
        getsampleLotBarList(){
            let that = this;
          if(null!=this.sampleLotDto.projectId) {
            SampleLotService.getBarList(this.sampleLotDto.projectId, (result) => {
            }).then(function (response) {
              if (response.code == 0) {
                that.sampleLotBarVOList = response.data;
                // for(let i=0;i<this.sampleLotBarVOList.length;i++){
                that.sampleLotBarVO.id = that.sampleLotBarVOList.originalSampleLot.id;
                that.sampleLotBarVO.textValue = "#"+that.sampleLotBarVOList.originalSampleLot.no+" "+that.sampleLotBarVOList.originalSampleLot.sampleCategoryDesc+that.sampleLotBarVOList.originalSampleLot.saveWayDesc;
                // }
              } else {
                that.$message({type: 'error', message: '获取样本批次列表信息失败'});
              }
            });
          }
        },
        //获取项目样本批次信息
        getsampleLotDtoByProjectId(){
            let that = this;
            let projectId = that.sampleLotDto.projectId;
            if(null!=projectId){
            SampleLotService.getByProjectId(projectId).then(function (response) {
              if(response.code==0){
                that.sampleLotDto = response.data;
                that.sampleLotDto.projectId = projectId;
                if(that.sampleLotDto != null && that.sampleLotDto.sampleCategory==13 || that.sampleLotDto.sampleCategory==15){
                  that.samplleTYpe = true;
                }else{
                  that.samplleTYpe = false;
                }
                //that.getUserById(that.sampleLotDto.operator);
              }else{
                that.sampleLotDto.projectId = that.$route.params.id;
                that.sampleLotDto.sampleCategory = that.$route.params.sampleCategory;
                that.sampleLotDto.species = that.$route.params.species;
                //this.$message({type: 'error', message: '获取信息失败'});
              }
              that.getSampleList();
            });
            }
        },
        //查询操作人员信息(方法暂时没有)
//        getUserById(id){
//            console.log(id);
//
//          UserService.get(id).then(function (response) {
//            if(response.code==0){
//              this.user = response.data;
//              console.log(this.user);
//            }else{
//              this.$message({type: 'success', message: '获取信息失败'});
//            }
//          });
//
//        },
        addSample(){
          this.dialogFormVisible = true;
        },
        editSample(sample){
          this.sampleDto.id= sample.id;
          this.sampleDto.no= sample.no;
          this.sampleDto.name= sample.name;
          this.sampleDto.actualConcentration = sample.actualConcentration;
          this.sampleDto.deliverConcentration= sample.deliverConcentration;
          this.sampleDto.deliverQuality = sample.deliverQuality;
          this.sampleDto.libraryIndex = sample.libraryIndex;
          this.sampleDto.initVolume= sample.initVolume;
          this.sampleDto.surplusVolume= sample.surplusVolume;
          this.sampleDto.productTime= sample.productTime;
          this.sampleDto.receiveTime= sample.receiveTime;
          this.sampleDto.storageLocation= sample.storageLocation;
          this.sampleDto.productStatus= sample.productStatus;
          this.sampleDto.disqualifiedReason = sample.disqualifiedReason;
          this.sampleDto.qualified = sample.qualified;
          this.sampleDto.note = sample.note;
          this.dialogFormVisible = true;
        },
        saveSample(){
              if(this.sampleDto.name == "" || this.sampleDto.name == null){
                this.$message({type: 'error', message: "创建样本失败!请输入样本名称"});
                return;
              }else{
              if(this.sampleDto.id == null) {
                this.sampleLotDto1.id = this.sampleLotDto.id;
                if(this.sampleDto.productTime!=null){
                this.sampleDto.productTime = Util.dateUtil.dateFormatNewDate(this.sampleDto.productTime);
                }else{
                  this.sampleDto.productTime = Util.dateUtil.dateFormatNewDate(new Date());
                }
                if(this.sampleDto.receiveTime!=null) {
                  this.sampleDto.receiveTime = Util.dateUtil.dateFormatNewDate(this.sampleDto.receiveTime);
                }else{
                  this.sampleDto.receiveTime = Util.dateUtil.dateFormatNewDate(new Date());
                }
                  this.sampleLotDto1.samples.push(this.sampleDto);
                let that = this;
                SampleService.create(that.sampleLotDto1).then(function (response) {
                  if (response.code == 0) {
                    that.$message({type: 'success', message: "创建样本成功"});
                    that.sampleLotDto1 = {
                      samples: [],
                      productTime: null,
                      receiveTime: null,
                      productStatus: null
                    },
                      that.cancels();
                  }else{
                    that.$message({type: 'error', message: "创建样本失败"});
                    that.sampleLotDto1 = {
                      samples: [],
                      productTime: null,
                      receiveTime: null,
                      productStatus: null
                    },
                      that.cancels();
                  }
                });
              }else{
                if(this.sampleDto.productTime!=null){
                  this.sampleDto.productTime = Util.dateUtil.dateFormatNewDate(this.sampleDto.productTime);
                }
                let that = this;
                SampleService.update(this.sampleDto).then(function (response) {
                  if (response.code == 0) {
                    that.$message({type: 'success', message: "修改样本成功"});
                    that.cancels();
                  }
                  else that.$message({type: 'error', message: "修改样本失败"});
                  that.cancels();
                });
              }
              }
        },
        deleteSample(sample){
        this.$confirm('是否将样本名称为'+ sample.name +'的样本删除?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                 type: 'warning'
               }).then(() => {
            let that = this;
                 SampleService.delete(sample.id).then(function (response) {
                   if(response.code==0){
                     that.$message({type: 'success', message: '删除样本'+ sample.name +'成功'});
                     that.getSampleList();
                   }else{
                     that.$message({type: 'success', message: '删除失败'});
                   }
                 });
               }).catch(() => {
                 this.$message({type: 'info', message: '已取消删除'});
               });
        },
        getSampleList(){
            let that = this;
           SampleService.getList({
           sampleLotId:this.sampleLotDto.id,
           page: this.currentPage,
           length: this.pageSize,
           filter: this.key_word
           }).then(function (response) {
             if(response.code==0){
               that.samples1 = response.data.rows;
               that.totalPage = response.totalPage;
               that.totalCount = response.data.totalCount;
             }
           })
        },
        handleIconClick () {
          if(!this.key_word){
            this.$message({type: 'info', message: '请输入关键字'});
            this.getSampleList();
            return;
          }
          this.getSampleList();
        },
        cancels(){
          this.sampleDto={
              id:null,
              no:'',
              name:'',
              deliverConcentration:'',
              initVolume:'',
              surplusVolume:'',
              productTime:null,
              receiveTime:null,
              storageLocation:'',
              productStatus:null,
              deliverQuality:'',
              libraryIndex:'',
              disqualifiedReason:'',
              qualified:null,
              note:''
        },
          this.dialogFormVisible = false;
          this.getSampleList();
        },
        changeData(){
          var id = this.sampleLotDto.sampleCategory;
          if(id==13 || id==15){
            this.samplleTYpe = true;
            this.wk = true;
            this.syll = false;
            this.synd = true;
            this.ystj = true;
            this.scnd = true;
            this.sytj = true;
          }else if(id==12 || id==14){
            this.samplleTYpe = false;
            this.wk = false;
            this.syll = false;
            this.synd = true;
            this.ystj = true;
            this.scnd = true;
            this.sytj = true;
          }else if(id==16){
            this.samplleTYpe = false;
            this.wk = false;
            this.syll = false;
            this.synd = false;
            this.ystj = false;
            this.scnd = false;
            this.sytj = false;
          }
          var type = "6";
          var type1 = "5";
          //this.sampleLotDto.saveWay = null;
          //this.sampleLotDto.sampleType = null;
          this.getDict(id,type);
          this.getDict1(id,type1);
        },
        changeSave(){
          var id = this.sampleLotDto.sampleCategory;
          var saveWayId = this.sampleLotDto.saveWay;
          if(saveWayId==68 || saveWayId==69 && id==12 || id==14){
              this.wk = false;
              this.syll = true;
              this.synd = false;
              this.ystj = false;
              this.scnd = false;
              this.sytj = false;
          }else if(saveWayId!=68 && saveWayId!=69 && id==12 || id==14){
              this.wk = false;
              this.syll = false;
              this.synd = true;
              this.ystj = true;
              this.scnd = true;
              this.sytj = true;
          }else if(saveWayId==79 && id==13 || saveWayId==82 &&  id==15){
              this.wk = true;
              this.syll = true;
              this.synd = false;
              this.ystj = false;
              this.scnd = false;
              this.sytj = false;
          }else if(id==13 && saveWayId!=79 || id==15 && saveWayId!=82  ){
              this.syll = false;
              this.wk = true;
              this.synd = true;
              this.ystj = true;
              this.scnd = true;
              this.sytj = true;
          }
        },
        //中间方法
        getDict1(id,type){
          this.getDict(id,type);
        },
        getDict(id,type){
            let that = this;
        DataDictService.get({
            parentId: id,
            type: type
          }).then(function (response) {
          if(response.code == 0) {
            if(type=="4"){
              that.sampleCategoryList = response.data;
            }else if(type=="3"){
              that.speciesList = response.data;
            }else if(id!=null && type=="6"){
              that.saveWayList = response.data;
            }else if(id!=null && type=="5"){
              that.sampleTypeList = response.data;
            }else if(type=="11"){
              that.libraryIndexList = response.data;
            }else if(type=="12"){
              that.librarySizeList = response.data;
            }
          }
        });
        },
        editOradd(){
          if (!this.isShow) {
            this.isShow = !this.isShow;
          } else {
            var verify = true;
            if (this.sampleLotDto.no == '') {
              this.$message({type: 'info', message: '请填写样本批次'});
              return;
            }else if(this.sampleLotDto.saveWay == null) {
              this.$message({type: 'info', message: '请选择保存形式'});
              return;
            }else if(this.sampleLotDto.sampleType == null){
              this.$message({type: 'info', message: '请选择样本类型'});
              return;
          }else {
                let that = this;
              if (that.sampleLotDto.id == null && that.sampleLotDto.projectId != null) {
                SampleLotService.create(that.sampleLotDto).then(function (response) {
                  if (response.code == 0) {
                    that.sampleLotDto.id = response.data;
                    that.$message({type: 'success', message: "创建样本批次成功"});
                    that.getsampleLotBarList();
                    that.getSampleList();
                    that.isShow = false;
                  }
                  else that.$message({type: 'error', message: "创建样本批次失败"});
                });

              } else if (null != that.sampleLotDto.id && null != that.$route.params.id) {
                SampleLotService.update(that.sampleLotDto).then(function (response) {
                  if (response.code == 0) {
                    that.$message({type: 'success', message: "修改样本批次成功"});
                    that.getSampleList();
                    that.getsampleLotBarList();
                    that.isShow = false;
                  }
                  else that.$message({type: 'error', message: "修改样本批次失败"});
                });
              }
            }
          }
        },
       cancle(){
         if(this.isShow==true){
         this.isShow = false;
        }else{

        }
      }
    }
  }

</script>
<style lang="scss">
  #app, html, body{
    overflow: auto !important;
  }
  @import "../../assets/scss/define";
  .container-content{
  @extend %pa;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
    padding: 70px 20px;
    overflow-x: hidden;
    overflow-y: auto;
  }
  .search-box{
  @extend %pa;
    top: 20px;
    right: 40px;
    z-index: 1;
    width: 360px;
  }
  .container-box{
  @extend %h100;
  }
  .page-wrap{
  @extend %pa;
  @extend %tac;
    background-color: #fff;
    z-index: 1;
    left: 0;
    right: 0;
    padding: 10px 0 20px;
    bottom: 0;
  }
</style>

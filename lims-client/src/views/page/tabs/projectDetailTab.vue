<template>
    <el-form ref="form" label-position="right" :rules="rules" :model="form" label-width="100px">
        <el-row :gutter="10">
            <el-col :span="10">
                <el-form-item label="项目编号" prop="id">
                    <el-input v-model="form.id"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="10" :offset="1">
                <el-form-item label="项目名称" prop="name">
                    <el-input v-model="form.name"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="3">
                <el-button @click="$router.push({name:'sample1',query:{type:1}})">导入合同</el-button>
            </el-col>
        </el-row>
        <hr/>
        <div class="form-group-title">合同摘要</div>
        <el-row :gutter="20">
            <el-col :span="10">
                <el-form-item label="合同编号">
                    <el-input v-model="form.cnid"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="13" :offset="1">
                <el-form-item label="合同名称">
                    <el-input v-model="form.cnname"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="10">
                <el-form-item label="子合同编号">
                    <el-input v-model="form.scnid"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="13" :offset="1">
                <el-form-item label="子合同名称">
                    <el-input v-model="form.scnname"></el-input>
                </el-form-item>
            </el-col>
        </el-row>

        <el-row :gutter="20">
            <el-col :span="10">
                <el-form-item label="商机编号">
                    <el-input v-model="form.cnid"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="13" :offset="1">
                <el-form-item label="临时合同">
                    <el-input v-model="form.cnname"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="10">
                <el-form-item label="客户代表">
                    <el-input v-model="form.cnid"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="13" :offset="1">
                <el-form-item label="合同备注">
                    <el-input v-model="form.cnname"></el-input>
                </el-form-item>
            </el-col>
        </el-row>

        <hr/>
        <div class="form-group-title">项目摘要</div>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-form-item label="客户编号">
                    <el-input v-model="form.cid"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="16">
                <el-form-item label="客户单位">
                    <el-input v-model="form.ccmpname"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-form-item label="客户姓名">
                    <el-input v-model="form.cid"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="客户电话">
                    <el-input v-model="form.ccmpname"></el-input>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="Email">
                    <el-input v-model="form.ccmpname"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="8">
                <el-form-item label="项目类型">
                    <el-radio class="radio" v-model="form.type" label="1" value="1">收费</el-radio>
                    <el-radio class="radio" v-model="form.type" label="2" value="2">免费</el-radio>
                </el-form-item>
            </el-col>
            <el-col :span="8">
                <el-form-item label="优先级别">
                    <el-select v-model="form.prior" placeholder="请选择">
                        <el-option

                                :value="3">
                        </el-option>
                        <el-option

                                :value="2">
                        </el-option>
                        <el-option

                                :value="1">
                        </el-option>
                    </el-select>
                </el-form-item>

            </el-col>
            <el-col :span="8">
                <el-form-item label="计划完成时间">
                    <el-date-picker
                            v-model="form.plandate"
                            align="right"
                            type="date"
                            placeholder="选择日期">
                    </el-date-picker>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="24">
                <el-form-item label="概要备注">
                    <el-input v-model="form.brief"></el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <el-row :gutter="20">
            <el-col :span="24">
                <el-form-item label="特殊要求">
                    <el-input
                            type="textarea"
                            :rows="4"
                            placeholder="请输入内容"
                            v-model="form.memo">
                    </el-input>
                </el-form-item>
            </el-col>
        </el-row>
        <hr/>

        <div class="form-group-title">工作任务</div>
        <el-row :gutter="20">
            <div class="task-line-wrapper">
                <div class="task-line"></div>
            </div>

            <el-row class="task-item-wrapper" :class="{disable:taskEnableList[0]}" :gutter="20">
                <el-col @click.native="changeTaskStatus(0)" class="task-icon-wrapper" :span="4">
                    <!--图标-->
                    <!--<icon-svg class="task-icon" icon-class="ybtq-sel"></icon-svg>-->
                    <img class="task-icon" v-show="!taskEnableList[0]" src="~assets/image/task/icon_ybtq_sel@2x.png"/>
                    <img class="task-icon" v-show="taskEnableList[0]" src="~assets/image/task/icon_ybtq_nor@2x.png"/>

                    <div class="task-text">样本提取</div>
                </el-col>

                <el-col class="task-item-content" :span="20">
                    <el-col :span="12">
                        <el-form-item label="提取内容">
                            <el-select :disabled="taskEnableList[0]" v-model="form.prior" placeholder="请选择">
                                <el-option
                                        :value="3">
                                </el-option>
                                <el-option
                                        :value="2">
                                </el-option>
                                <el-option
                                        :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="提取方法">
                            <el-select :disabled="taskEnableList[0]" v-model="form.prior" placeholder="请选择">
                                <el-option
                                        :value="3">
                                </el-option>
                                <el-option
                                        :value="2">
                                </el-option>
                                <el-option
                                        :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                </el-col>

            </el-row>

            <el-row class="task-item-wrapper" :class="{disable:taskEnableList[1]}" :gutter="20">
                <el-col @click.native="changeTaskStatus(1)" class="task-icon-wrapper" :span="4">
                    <!--图标-->
                    <!--<icon-svg class="task-icon" icon-class="ybjc-sel"></icon-svg>-->
                    <img class="task-icon" v-show="!taskEnableList[1]" src="~assets/image/task/icon_ybjc_sel@2x.png"/>
                    <img class="task-icon" v-show="taskEnableList[1]" src="~assets/image/task/icon_ybjc_nor@2x.png"/>

                    <div class="task-text">样本检测</div>
                </el-col>

                <el-col class="task-item-content" :span="20">
                    <el-form-item label="检测方法">
                        <el-checkbox-group v-model="form.detectionCheckList">
                            <el-checkbox :disabled="taskEnableList[1]" label="电泳"></el-checkbox>
                            <el-checkbox :disabled="taskEnableList[1]" label="Nano Drop"></el-checkbox>
                            <el-checkbox :disabled="taskEnableList[1]" label="Qubit"></el-checkbox>
                            <el-checkbox :disabled="taskEnableList[1]" label="AB2100"></el-checkbox>
                        </el-checkbox-group>
                    </el-form-item>

                </el-col>
            </el-row>

            <el-row class="task-item-wrapper" :class="{disable:taskEnableList[2]}" :gutter="20">
                <el-col @click.native="changeTaskStatus(2)" class="task-icon-wrapper" :span="4">
                    <!--图标-->
                    <!--<icon-svg class="task-icon" icon-class="wkgj-sel"></icon-svg>-->
                    <img class="task-icon" v-show="!taskEnableList[2]" src="~assets/image/task/icon_wkgj_sel@2x.png"/>
                    <img class="task-icon" v-show="taskEnableList[2]" src="~assets/image/task/icon_wkgj_nor@2x.png"/>

                    <div class="task-text">文库构建</div>
                </el-col>

                <el-col class="task-item-content" :span="20">
                    <el-col :span="12">
                        <el-form-item label="测序平台">
                            <el-select :disabled="taskEnableList[2]" v-model="form.prior" placeholder="请选择">
                                <el-option
                                        :value="3">
                                </el-option>
                                <el-option
                                        :value="2">
                                </el-option>
                                <el-option
                                        :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="测试盒">
                            <el-select :disabled="taskEnableList[2]" v-model="form.prior" placeholder="请选择">
                                <el-option
                                        :value="3">
                                </el-option>
                                <el-option
                                        :value="2">
                                </el-option>
                                <el-option
                                        :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                </el-col>

            </el-row>

            <el-row class="task-item-wrapper" :class="{disable:taskEnableList[3]}" :gutter="20">
                <el-col @click.native="changeTaskStatus(3)" class="task-icon-wrapper" :span="4">
                    <!--图标-->
                    <!--<icon-svg class="task-icon" icon-class="wkjc-sel"></icon-svg>-->

                    <img class="task-icon" v-show="!taskEnableList[3]" src="~assets/image/task/icon_wkjc_sel@2x.png"/>
                    <img class="task-icon" v-show="taskEnableList[3]" src="~assets/image/task/icon_wkjc_nor@2x.png"/>

                    <div class="task-text">文库检测</div>
                </el-col>

                <el-col class="task-item-content" :span="20">
                    <el-col :span="12">
                        <el-form-item label="测序平台">
                            <el-select :disabled="taskEnableList[3]" v-model="form.prior" placeholder="请选择">
                                <el-option
                                        :value="3">
                                </el-option>
                                <el-option
                                        :value="2">
                                </el-option>
                                <el-option
                                        :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="测试策略">
                            <el-select :disabled="taskEnableList[3]" v-model="form.prior" placeholder="请选择">
                                <el-option
                                        :value="3">
                                </el-option>
                                <el-option
                                        :value="2">
                                </el-option>
                                <el-option
                                        :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                </el-col>

            </el-row>

            <el-row class="task-item-wrapper" :class="{disable:taskEnableList[4]}" :gutter="20">
                <el-col @click.native="changeTaskStatus(4)" class="task-icon-wrapper" :span="4">
                    <!--图标-->
                    <!--<icon-svg class="task-icon" icon-class="wkdl-sel"></icon-svg>-->

                    <img class="task-icon" v-show="!taskEnableList[4]" src="~assets/image/task/icon_wkdl_sel@2x.png"/>
                    <img class="task-icon" v-show="taskEnableList[4]" src="~assets/image/task/icon_wkdl_nor@2x.png"/>

                    <div class="task-text">文库定量</div>
                </el-col>

                <el-col class="task-item-content" :span="20">
                    <el-col :span="12">
                        <el-form-item label="测序平台">
                            <el-select :disabled="taskEnableList[4]" v-model="form.prior" placeholder="请选择">
                                <el-option
                                        :value="3">
                                </el-option>
                                <el-option
                                        :value="2">
                                </el-option>
                                <el-option
                                        :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="测试策略">
                            <el-select :disabled="taskEnableList[4]" v-model="form.prior" placeholder="请选择">
                                <el-option
                                        :value="3">
                                </el-option>
                                <el-option
                                        :value="2">
                                </el-option>
                                <el-option
                                        :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>

                    <el-col :span="12">
                        <el-form-item label="数据量">
                            <el-input :disabled="taskEnableList[4]" v-model="form.amount"></el-input>
                        </el-form-item>

                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="单位">
                            <el-select :disabled="taskEnableList[4]" v-model="form.prior" placeholder="请选择">
                                <el-option
                                        :value="3">
                                </el-option>
                                <el-option
                                        :value="2">
                                </el-option>
                                <el-option
                                        :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                </el-col>

            </el-row>


            <el-row class="task-item-wrapper" :class="{disable:taskEnableList[5]}" :gutter="20">
                <el-col @click.native="changeTaskStatus(5)" class="task-icon-wrapper" :span="4">
                    <!--图标-->
                    <!--<icon-svg class="task-icon" icon-class="cxjg-nor"></icon-svg>-->
                    <img class="task-icon" v-show="!taskEnableList[5]" src="~assets/image/task/icon_cxjg_sel@2x.png"/>
                    <img class="task-icon" v-show="taskEnableList[5]" src="~assets/image/task/icon_cxjg_nor@2x.png"/>

                    <div class="task-text">测试结果QC</div>
                </el-col>

                <el-col class="task-item-content" :span="20">
                    <el-col :span="12">
                        <el-form-item label="待定内容">
                            <el-select :disabled="taskEnableList[5]" v-model="form.prior" placeholder="请选择">
                                <el-option
                                        :value="3">
                                </el-option>
                                <el-option
                                        :value="2">
                                </el-option>
                                <el-option
                                        :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="待定内容">
                            <el-select :disabled="taskEnableList[5]" v-model="form.prior" placeholder="请选择">
                                <el-option
                                        :value="3">
                                </el-option>
                                <el-option
                                        :value="2">
                                </el-option>
                                <el-option
                                        :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                </el-col>

            </el-row>


            <el-row class="task-item-wrapper" :class="{disable:taskEnableList[6]}" :gutter="20">
                <el-col @click.native="changeTaskStatus(6)" class="task-icon-wrapper" :span="4">
                    <!--图标-->
                    <!--<icon-svg class="task-icon" icon-class="sxfx-nor"></icon-svg>-->
                    <img class="task-icon" v-show="!taskEnableList[6]" src="~assets/image/task/icon_sxfx_sel@2x.png"/>
                    <img class="task-icon" v-show="taskEnableList[6]" src="~assets/image/task/icon_sxfx_nor@2x.png"/>

                    <div class="task-text">生信分析</div>
                </el-col>

                <el-col class="task-item-content" :span="20">
                    <el-col :span="12">
                        <el-form-item label="待定内容">
                            <el-select :disabled="taskEnableList[6]" v-model="form.prior" placeholder="请选择">
                                <el-option
                                        :value="3">
                                </el-option>
                                <el-option
                                        :value="2">
                                </el-option>
                                <el-option
                                        :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                    <el-col :span="12">
                        <el-form-item label="待定内容">
                            <el-select :disabled="taskEnableList[6]" v-model="form.prior" placeholder="请选择">
                                <el-option
                                        :value="3">
                                </el-option>
                                <el-option
                                        :value="2">
                                </el-option>
                                <el-option
                                        :value="1">
                                </el-option>
                            </el-select>
                        </el-form-item>

                    </el-col>
                </el-col>

            </el-row>


            <el-row class="task-item-wrapper" :class="{disable:taskEnableList[7]}" :gutter="20">
                <el-col @click.native="changeTaskStatus(7)" class="task-icon-wrapper" :span="4">
                    <!--图标-->
                    <!--<icon-svg class="task-icon" icon-class="other-nor"></icon-svg>-->
                    <img class="task-icon" v-show="!taskEnableList[7]" src="~assets/image/task/icon_other_sel@2x.png"/>
                    <img class="task-icon" v-show="taskEnableList[7]" src="~assets/image/task/icon_other_nor@2x.png"/>

                    <div class="task-text">其他</div>
                </el-col>

                <el-col class="task-item-content" :span="20">
                    <el-col :span="24">
                        <el-form-item label="其他">
                            <el-input :disabled="taskEnableList[7]" v-model="form.others" placeholder="请输入内容"></el-input>
                        </el-form-item>

                    </el-col>
                </el-col>

            </el-row>

        </el-row>

        <hr/>
        <el-row>
            <el-button type="primary" @click="submitForm()">保存</el-button>
        </el-row>

    </el-form>
</template>

<script>
    import IconSvg from "components/Icon-svg/index";
    export default {
        components: {
            IconSvg
        },
        data() {
            return {
                activeName2: 'first',
                rules: {
                    id: [
                        {required: true, message: '请输入项目编号', trigger: 'blur'},
                    ],
                    name: [
                        {required: true, message: '请输入项目名称', trigger: 'blur'},
                        {min: 3, max: 5, message: '长度在 3 到 5 个字符', trigger: 'blur'}
                    ],
                },
                taskEnableList: new Array(8),
                form: {
                    id: '',
                    name: '',
                    cnid: '',
                    cnname: '',
                    scnid: '',
                    scnname: '',
                    cid: '',
                    ccmpname: '',
                    type: "1",
                    prior: '',
                    plandate: '',
                    brief: '',
                    memo: '',
                    region: '',
                    date1: '',
                    date2: '',
                    delivery: false,
                    type: "1",
                    resource: '',
                    desc: '',
                    detectionCheckList: [],
                    amount: 0,
                    others: "",
                    work: {
                        c1: {
                            check: false,
                            content: '',
                            method: ''
                        },
                        c2: {
                            check: false,
                            content: '',
                            method: ''
                        }
                    }
                }
            };
        },
//
//        watch:{
//            "$route"(to, from) {
//                console.warn(to, from)
//            }
//        },
        methods: {
            submitForm() {
                this.$refs.form.validate((valid) => {
                    if (valid) {
                        alert('submit!');
                    } else {
                        console.log('error submit!!');
                        this.$alert("信息填写错误")
                        return false;
                    }
                });
            },
            handleClick(tab, event) {
                console.log(tab, event);
            },
            changeTaskStatus(index){
                this.$set(this.taskEnableList,index,!this.taskEnableList[index]);
            }
        }
    };
</script>

<style lang="scss" scoped>
    @import "~styles/variable";

    .task-line-wrapper {
        position: absolute;
        left: 0;
        top: 30px;
        bottom: 50px;
        margin-left: -10px;
        box-sizing: border-box;
        width: 16.66%;
        text-align: center;

        .task-line {
            display: inline-block;
            width: 2px;
            height: 100%;
            background-color: $color-text-ll;

        }
    }

    .task-item-wrapper {
        margin: 15px 0;

        &.disable{
            input,select{
                pointer-events: none;
            }
            .task-icon {
                fill: $color-theme-l !important;
            }
            .task-text{
                color: $color-theme-l !important;;
            }
        }

        .task-icon-wrapper {
            text-align: center;
            position: relative;
            z-index: 10;
            background-color: #fff;
            padding: 10px;

            .task-icon {
                height: 45px;
                fill: $color-theme;

            }

            .task-text {
                color: $color-theme;
                font-size: 14px;
            }
        }

        .task-item-content {
            background-color: $color-text-lll;
            border-radius: 10px;
            padding-top: 22px;
            position: relative;
            &:after{
                color: white;
                content: '';
                position: absolute;
                width: 0;
                height: 0;
                border: 8px solid;
                border-right-color: $color-text-lll;
                top: 30px;
                left: -15px;
                z-index: 100;
            }
        }
    }

</style>
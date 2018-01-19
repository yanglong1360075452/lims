<template>
    <el-dialog title="样本清单" :visible.sync="visable" :before-close="cancle" :rules="dialogRules">
        <el-form :model="data" prop="id">
            <el-form-item label="样本ID" :label-width="formLabelWidth">
                <el-input v-model="data.id" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="样本名称" :label-width="formLabelWidth" prop="name">
                <el-input v-model="data.name" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="制备浓度" :label-width="formLabelWidth" prop="sampleConcentration">
                <el-input v-model="data.sampleConcentration" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="实测浓度" :label-width="formLabelWidth" prop="concentration">
                <el-input v-model="data.concentration" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="原始体积" :label-width="formLabelWidth" prop="originalVolumn">
                <el-input v-model="data.originalVolumn" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="剩余体积" :label-width="formLabelWidth" prop="residualVolume">
                <el-input v-model="data.residualVolume" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="生产时间" :label-width="formLabelWidth" prop="productionTime">
                <el-date-picker type="date" placeholder="生产时间" format='yyyy-MM-dd' style='width:100%' v-model="data.productionTime">
                </el-date-picker>
            </el-form-item>
            <el-form-item label="接收时间" :label-width="formLabelWidth" prop="receiptTime">
                <el-date-picker type="date" placeholder="接收时间" format='yyyy-MM-dd' style='width:100%' v-model="data.receiptTime">
                </el-date-picker>
            </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
            <el-button @click="cancle()">取 消</el-button>
            <el-button type="primary" @click="submit()">确 定</el-button>
        </div>
    </el-dialog>
</template>

<script>
    export default {
        props: {
            data: {
                type: Object,
                require: true,
                default:{
                    productionTime:"",
                    receiptTime: ""
                }
            },
            visable: {
                type: Boolean,
                require: true
            },
            type: {  //弹出框出现状态：新建：0，编辑：1
                type: Number,
                require: true,
            }
        },
        data() {
            return {
                formLabelWidth: '120px',
                dialogRules: {
                    id: [{
                            required: true,
                            message: '请输入活动名称',
                            trigger: 'blur'
                        },
                        {
                            min: 3,
                            max: 5,
                            message: '长度在 3 到 5 个字符',
                            trigger: 'blur'
                        }
                    ],
                    name: [{
                            required: true,
                            message: '请输入活动名称',
                            trigger: 'blur'
                        },
                        {
                            min: 3,
                            max: 5,
                            message: '长度在 3 到 5 个字符',
                            trigger: 'blur'
                        }
                    ],
                    sampleConcentration: [{
                            required: true,
                            message: '请输入活动名称',
                            trigger: 'blur'
                        },
                        {
                            min: 3,
                            max: 5,
                            message: '长度在 3 到 5 个字符',
                            trigger: 'blur'
                        }
                    ],
                    concentration: [{
                            required: true,
                            message: '请输入活动名称',
                            trigger: 'blur'
                        },
                        {
                            min: 3,
                            max: 5,
                            message: '长度在 3 到 5 个字符',
                            trigger: 'blur'
                        }
                    ],
                    originalVolumn: [{
                            required: true,
                            message: '请输入活动名称',
                            trigger: 'blur'
                        },
                        {
                            min: 3,
                            max: 5,
                            message: '长度在 3 到 5 个字符',
                            trigger: 'blur'
                        }
                    ],
                    residualVolume: [{
                            required: true,
                            message: '请输入活动名称',
                            trigger: 'blur'
                        },
                        {
                            min: 3,
                            max: 5,
                            message: '长度在 3 到 5 个字符',
                            trigger: 'blur'
                        }
                    ],
                    date1: [{
                        type: 'date',
                        required: true,
                        message: '请选择日期',
                        trigger: 'change'
                    }],
                    date2: [{
                        type: 'date',
                        required: true,
                        message: '请选择时间',
                        trigger: 'change'
                    }]
                }
            }
        },
        methods: {
            submit() {
                this.$emit("submit")
            },
            cancle() {
                this.$emit("cancle");
            },
           
        }
    }
</script>
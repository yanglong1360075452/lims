<script type="text/javascript">

    const productStatusList = [{
        value: 1,
        label: "样本提取"
    }, {
        value: 2,
        label: "样本检测"
    }, {
        value: 3,
        label: "文库构建"
    }, {
        value: 4,
        label: "文库检测"
    }, {
        value: 5,
        label: "文库定量"
    }, {
        value: 6,
        label: "测序"
    }, {
        value: 7,
        label: "测序QC结果"
    }, {
        value: 8,
        label: "生信分析"
    }, {
        value: 9,
        label: "其他"
    }
    ];
    const projectStatusList = [
        {
        value: 1,
        label: "新项目"
        },
        {
        value: 2,
        label: "样本送达"
        },
        {
        value: 3,
        label: "已交付生产"
        },
        {
        value: 4,
        label: "已调度"
        },
        {
        value: 5,
        label: "生产进行中"
        },
        {
        value: 6,
        label: "项目暂停"
        },
        {
        value: 7,
        label: "项目完成"
        },
        {
        value: 8,
        label: "项目终止"
        },
        {
        value: 9,
        label: "项目取消"
        }
    ];
    const taskStatusList = [{
        value: null,
        label: "所有"
    }, {
        value: 1,
        label: "未分配"
    }, {
        value: 2,
        label: "已分配"
    }, {
        value: 3,
        label: "进行中"
    }, {
        value: 4,
        label: "完成"
    }, {
        value: 5,
        label: "暂停"
    }, {
        value: 6,
        label: "终止"
    }];
    const sampleStatusList = [{
        value: null,
        label: "所有"
    }, {
        value: 1,
        label: "已建档"
    }, {
        value: 2,
        label: "已接收"
    }, {
        value: 3,
        label: "已退回"
    }, {
        value: 4,
        label: "库存中"
    }, {
        value: 5,
        label: "使用中"
    }, {
        value: 6,
        label: "已销毁"
    }];
    const TaskStatusEnum = {
        ALL: null,
        NOT_ALLOT: 1, /*未分配*/
        ALLOTTED: 2, /*已分配*/
        UNDERWAY: 3, /*进行中*/
        COMPLETE: 4, /*完成*/
        PAUSE: 5, /*暂停*/
        TERMINATION: 6/*终止*/
    };
    const ProjectStatusEnum = {
        NEW_PROJECT:1,/*新项目*/
        SAMPLE_DELIVERY:2,/*样本送达*/
        DELIVERED:3,/*已交付生产*/
        SCHEDULED:4,/*已调度*/
        IN_THE_PRODUCTION:5,/*生产进行中*/
        PAUSE:6,/*项目暂停*/
        COMPLETE:7,/*项目完成*/
        TERMINATION:8,/*项目终止*/
        CANCEL:9/*项目取消*/
    };
    const DictTypeEnum = {
        PROJECT_TYPE:1, /*项目类型*/
        PROJECT_PRIORITY:2, /*项目优先级*/
        SPECIES:3, /*物种分类*/
        SAMPLE_CATEGORY:4,/*样本类别*/
        SAMPLE_TYPE:5,/*样本类型*/
        SAMPLE_SAVE_WAY:6, /*样本保存形式*/
        SAMPLE_EXTRACT_CONTENT:7, /*样本提取内容*/
        SAMPLE_EXTRACT_METHOD:8, /*样本提取方法*/
        SAMPLE_CHECK_METHOD:9, /*样本检测方法*/
        LIBRARY_CHECK_METHOD:10, /*文库检测方法*/
        LIBRARY_INDEX:11, /*文库INDEX位置*/
        LIBRARY_SIZE:12, /*文库片段大小*/
        SEQ_PLATFORM:13, /*测序平台*/
        SEQ_STRATEGY:14, /*测序策略*/
        DATA_AMOUNT_UNIT:15, /*数据量单位*/
        LIBRARY_TYPE:16, /*文库类型*/
    };
    export default{
        productStatusList,
        projectStatusList,
        taskStatusList,
        sampleStatusList,
        TaskStatusEnum,
        ProjectStatusEnum,
        DictTypeEnum
    }
</script>

<template>
    <div>
        <div style="margin-bottom: 1%">
            <page-label title="全局样本列表" icon="new"></page-label>
        </div>
        <el-tabs type="card" v-model="activeName">
            <el-tab-pane label="组织样本" name="corpseSample">
                <corpse-sample></corpse-sample>
            </el-tab-pane>
            <el-tab-pane label="RNA/DNA" name="dnaRna">
                <dna-rna></dna-rna>
            </el-tab-pane>
            <el-tab-pane label="文库" name="library">
                <library></library>
            </el-tab-pane>
        </el-tabs>
    </div>
</template>

<script>
    import PageLabel from 'components/pageLabel'
    import CorpseSample  from './sampleList/corpseSample.vue';
    import DnaRna  from './sampleList/dnaRna.vue';
    import Library  from './sampleList/library.vue';

    export default {
        components: {
            PageLabel,CorpseSample,DnaRna,Library
        },
        mounted() {
        },
        data() {
            return {
                activeName: 'corpseSample'
            };
        },
        methods: {
        }
    };
</script>

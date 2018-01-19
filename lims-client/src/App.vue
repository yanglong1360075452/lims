<template>
    <div id="app">
        <router-view class="app-container" v-loading="showLoading"  element-loading-text="加载中~~~"></router-view>
    </div>
</template>

<script>
    import {mapGetters} from 'vuex';
    export default {
        computed: {
            ...mapGetters([
                'showLoading'
            ])
        },
        name: 'app'
    }
</script>
<style lang="scss">
    @import './styles/index.scss'; // 全局自定义的css样式
</style>



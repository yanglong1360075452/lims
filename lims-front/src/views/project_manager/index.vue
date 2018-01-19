<template>
  <div>
    <Tab-Header></Tab-Header>
    <router-view></router-view>
  </div>
</template>
<script>
  import TabHeader from '../../components/tabheader.vue';
  export default {
    name:"project",
    components: {
      TabHeader

    }
  }

</script>
<style lang="scss">
  @import "../../assets/scss/define";

</style>

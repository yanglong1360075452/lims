<template>
    <div class="input-list" >
       <span class=" filter-common filter-label">{{labelInfo}}</span>
        <slot name='input'></slot>
    </div>
</template>
<script>
export default {
  props: {
      labelInfo: {
          type: String
      }
  }
}
</script>
<style lang="scss" scoped>
    .input-list {
        display: inline;
        white-space: pre;
        .filter-common{
            white-space: normal
        }
    }
    .filter-label {
        margin-right: 1%;
    }
</style>


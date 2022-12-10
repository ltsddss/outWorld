<template>
  <el-container>
    <el-header style="height: auto">
      <nav-head :user="user" @handleSelect="handle"></nav-head>
    </el-header>
    <el-main>
      <select-table :updateItem="updateItem"></select-table>
    </el-main>
  </el-container>
</template>

<script>
import NavHead from '../components/NavHead.vue'
import Card from "../components/Card";
import SelectTable from "../components/SelectTable";

export default {
  name: "SelectResult",
  components: {
    SelectTable,
    NavHead,
    Card
  },
  data() {
    return {
      oneLine: 4,// 一行多沙card
      ss: null,
      user: null,
      updateItem:
        {
          updateDate: '今天',
          isShow: true,
          updateCards: []
        }
    }
  },
  methods: {
    handle(data) {
      this.updateItem.updateCards = data
    }
  }
}
</script>
<style scoped>
</style>

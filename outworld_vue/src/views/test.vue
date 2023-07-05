<template>
  <div>
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="直播间首页图片地址">
        <el-input v-model="form.borastImg"></el-input>
      </el-form-item>
      <el-form-item label="直播间简介">
        <el-input v-model="form.borastIntroduce"></el-input>
      </el-form-item>
      <el-form-item label="直播间标题">
        <el-input v-model="form.borastTitle"></el-input>
      </el-form-item>
      <el-form-item label="直播间的户主">
        <el-input v-model="form.borastName"></el-input>
      </el-form-item>
      <el-form-item label="直播分区（0学习区，1游戏区）">
        <el-select v-model="form.borastPartition" placeholder="请选择">
          <el-option label="学习区" value="0"></el-option>
          <el-option label="游戏区" value="1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="直播间类型（0公共直播间，1私人直播间）">
        <el-select v-model="form.borastType" placeholder="请选择">
          <el-option label="公共直播间" value="0"></el-option>
          <el-option label="私人直播间" value="1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="直播间密码">
        <el-input v-model="form.borastPassword"></el-input>
      </el-form-item>

      <el-form-item label="直播间状态（0开始直播,1直播结束,2直播封禁中）">
        <el-select v-model="form.borastStatus" placeholder="请选择">
          <el-option label="开始直播" value="0"></el-option>
          <el-option label="直播结束" value="1"></el-option>
          <el-option label="直播封禁中" value="2"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="直播间是否禁言(0不禁言，1禁言)">
        <el-select v-model="form.borastChat" placeholder="请选择">
          <el-option label="不禁言" value="0"></el-option>
          <el-option label="禁言" value="1"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">提交</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "test",
  data() {
    return {
      form: {
        borastImg: undefined,
        borastIntroduce: undefined,
        borastTitle: undefined,
        borastName: undefined,
        borastPartition: undefined,
        borastType: undefined,
        borastPassword: undefined,
        borastStatus: undefined,
        borastChat:undefined
      }
    }
  },
  methods: {
    onSubmit() {
      this.axios({
        url:'/api/outworld_system/elasticsearch/insertLiveBorastInfo',
        method:'post',
        data:this.form
      }).then(response=>{
        console.log(response)
      })
    }
  }
}
</script>

<style scoped>

</style>

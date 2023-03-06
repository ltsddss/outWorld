
<template>
  <div>
    <el-row class="item-line">
      <el-form ref="form"
               :model="form"
               label-width="100px">
        <el-form-item label="直播间图片：">
          <el-input v-model="form.borastImg"
                    class="normal input-class"></el-input>
        </el-form-item>
        <el-form-item label="直播间介绍">
          <el-tag type="info"
                  class="normal tag"
                  :size="'big'">{{form.borastIntroduce}}</el-tag>
        </el-form-item>
        <el-form-item label="直播间标题">
          <el-input v-model="form.borastTitle"
                    class="normal input-class"></el-input>
        </el-form-item>
        <el-form-item label="直播间分区">
          <el-input type="textarea"
                    v-model="form.borastPartition"
                    class="normal textarea"></el-input>
        </el-form-item>
        <el-form-item label="直播间类型"
                      class="normal">
          <el-radio-group v-model="form.borastType">
            <el-radio :label="0">男</el-radio>
            <el-radio :label="1">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="直播间密钥">
          <el-date-picker type="date"
                          placeholder="选择日期"
                          v-model="form.borastPassword"
                          class="normal input-class"></el-date-picker>
        </el-form-item>
        <el-form-item label="直播间状态">
          <el-input type="text"
                    placeholder="请输入号码"
                    v-model="form.borastStatus"
                    show-word-limit
                    class="normal input-class">
          </el-input>
        </el-form-item>
        <el-form-item label="是否禁言">
          <v-region v-model="form.borastChat"
                    class="normal"></v-region>
        </el-form-item>
        <div style="border-bottom: 1px solid #e5e9ef;margin-bottom:20px"></div>
        <el-button type="primary"
                   @click="onSubmit">保存</el-button>
      </el-form>
    </el-row>
  </div>
</template>
<script>
export default {
  name: 'PersonMyInfo',
  data: function () {
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
    onSubmit () {
      console.log('submit form')
    }
  }
}
</script>
<style scoped>
.item-line {
  padding-top: 20px;
  padding-bottom: 20px;
}

.normal {
  display: flex;
}
.tag {
  width: 115px;
}
.input-class {
  width: 200px;
}
.textarea {
  width: 400px;
  height: 150px;
}
</style>


<template>
  <div>
    <el-row class="item-line">
      <el-form ref="form"
               :model="form"
               label-width="100px">
        <el-form-item label="直播间图片：">
          <div v-show="isChange">
            <el-upload class="avatar-uploader"
                       action=""
                       :show-file-list="false"
                       :on-success="handleAvatarSuccess"
                       :before-upload="beforeAvatarUpload">
              <img v-if="form.borastImg"
                   :src="form.borastImg"
                   class="avatar">
              <i v-else
                 class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
          </diV>
        </el-form-item>
        <el-form-item label="直播间介绍">
          <el-input type="textarea"
                    v-model="form.borastIntroduce"
                    class="normal textarea"></el-input>
        </el-form-item>
        <el-form-item label="直播间标题">
          <el-input v-model="form.borastTitle"
                    class="normal input-class"></el-input>
        </el-form-item>
        <el-form-item label="直播间分区">
          <el-radio-group v-model="form.borastPartition">
            <el-radio :label="0">学习区</el-radio>
            <el-radio :label="1">游戏区</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="直播间类型">
          <el-radio-group v-model="form.borastType">
            <el-radio :label="0">公开</el-radio>
            <el-radio :label="1">私密</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="直播间密钥">
          <el-input v-model="form.borastPassword"
                    class="normal input-class"></el-input>
          <el-button type="primary" @click="create">生成</el-button>
        </el-form-item>
        <el-form-item label="直播间状态">
          <el-radio-group v-model="form.borastStatus">
            <el-radio :label="0">正在直播</el-radio>
            <el-radio :label="1">直播结束</el-radio>
            <el-radio :label="2">直播封禁</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="是否禁言">
          <el-radio-group v-model="form.borastChat">
            <el-radio :label="0">是</el-radio>
            <el-radio :label="1">否</el-radio>
          </el-radio-group>
        </el-form-item>
        <div style="border-bottom: 1px solid #e5e9ef;margin-bottom:20px"></div>
        <el-button type="primary"
                   @click="onSubmit">保存</el-button>
      </el-form>
    </el-row>
  </div>
</template>
<script>
import {createSixString} from "../utils/validate";

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
      },
      isChange: true,

    }
  },
  methods: {
    onSubmit () {
      console.log('submit form')
    },
    handleAvatarSuccess (res, file) {
      this.imageUrl = URL.createObjectURL(file.raw)
    },
    //上传之前的验证
    beforeAvatarUpload (file) {
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
      }
      return isJPG && isLt2M
    },
    create(){
      this.form.borastPassword=createSixString()
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
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
</style>

<template>
  <div>
    <el-form ref="sysUser" v-model="sysUser">
      <el-form-item lable="用户名">
        <el-input v-model="sysUser.userName"></el-input>
      </el-form-item>
      <el-form-item lable="密码">
        <el-input v-model="sysUser.userPassword"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">登录</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>

export default {
  name: "Login",
  data () {
    return {
      sysUser: {
        userName: '',
        userPassword: ''
      },
    }
  },
  methods: {
    onSubmit () {
      // 发送登录请求
      this.$axios({
        url: "api/outworld_auth/auth/login",
        method: "post",
        data: this.sysUser
      }).then(r => {
        // 返回结果
        console.log(r.data.data)
      })
    }
  }
}
</script>

<style scoped>

</style>

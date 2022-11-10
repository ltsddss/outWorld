<template>
  <div>
    <el-form :model="sysUser">
      <el-form-item lable="用户名">
        <el-input :model="sysUser.username"></el-input>
      </el-form-item>
      <el-form-item lable="密码">
        <el-input :model="sysUser.password"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "login",
  data(){
    return{
      sysUser:{
        username:null,
        password:null
      },
    }
  },
  methods:{
    onSubmit(){
    //发送登录请求
      this.$
    }
  }
}
</script>

<style scoped>

</style>

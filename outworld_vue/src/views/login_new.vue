<template>
  <div v-loading="loading" element-loading-text="登录中..." element-loading-spinner="el-icon-loading"
       element-loading-background="rgba(0, 0, 0, 0.6)" class="login-container">

    <el-form ref="sysUser" :model="sysUser" :rules="loginRules" class="login-form" auto-complete="on"
             label-position="left">
      <!-- 头像区域 -->
      <div v-if="TxStatus" class="avatar-box">
        <img src="../assets/login.jpeg" alt="">
      </div>

      <div class="title-container">
        <h3 class="title">请先登录</h3>
      </div>

      <el-form-item prop="username">
        <span class="svg-container">
          <svg-icon icon-class="user"/>
        </span>
        <el-input ref="username" v-model="sysUser.userName" placeholder="Username" name="username" type="text"
                  tabindex="1" auto-complete="on"/>
      </el-form-item>

      <el-form-item prop="password">
        <span class="svg-container">
          <svg-icon icon-class="password"/>
        </span>
        <el-input :key="passwordType" ref="password" v-model="sysUser.userPassword" :type="passwordType"
                  placeholder="Password" name="password" tabindex="2" auto-complete="on"
                  @keyup.enter.native="handleLogin"/>
        <span class="show-pwd" @click="showPwd">
          <svg-icon :icon-class="passwordType === 'password' ? 'eye' : 'eye-open'"/>
        </span>
      </el-form-item>
      <div>
        <el-button type="primary" style="width:100%;margin-bottom:20px;" @click.native.prevent="handleLogin">登录
        </el-button>
      </div>
      <div class="tips">
        <span style="margin-right:20px;">如果您还没有账号请先 <span style="color:#409EFF;cursor:pointer"
                                                          @click="register">注册</span></span>
      </div>

    </el-form>
  </div>
</template>

<script>
// 引入去除空格工具
import {validUsername} from '../utils/validate'

export default {
  name: 'Login',
  data() {
    const validateUsername = (rule, value, callback) => {
      if (!validUsername(value)) {
        callback(new Error('用户名不能为空！'))
      } else {
        callback()
      }
    }
    const validatePassword = (rule, value, callback) => {
      if (value.length < 6) {
        callback(new Error('密码最少为6位字符！'))
      } else {
        callback()
      }
    }
    return {
      // 头像状态
      TxStatus: true,
      sysUser: {
        userName: '',
        userPassword: ''
      },
      // 登录规则
      loginRules: {
        username: [{required: true, trigger: 'blur', validator: validateUsername}],
        password: [{required: true, trigger: 'blur', validator: validatePassword}]
      },
      loading: false,
      passwordType: 'password',
      redirect: undefined
    }
  },
  watch: {
    $route: {
      handler: function (route) {
        this.redirect = route.query && route.query.redirect
      },
      immediate: true
    }
  },
  methods: {
    showPwd() {
      if (this.passwordType === 'password') {
        this.passwordType = ''
      } else {
        this.passwordType = 'password'
      }
      this.$nextTick(() => {
        this.$refs.password.focus()
      })
    },
    // 登录业务
    handleLogin() {
      this.$refs.loginForm.validate((valid) => {
        // 如果符合验证规则
        if (valid) {
          this.loading = true
          setTimeout(() => {
            this.axios({
              url: '/api/outworld_auth/auth/login',
              method: 'post',
              data: this.sysUser
            }).then((response) => {
              console.log(response)
              this.$router.push({path: this.redirect || '/'})
              this.loading = false
            }).catch(() => {
              this.loading = false
            })
          }, 1500)
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    // 注册业务
    register() {
      console.log('123')
      this.$router.push({name: 'register'})
    }
  }
}
</script>

<style lang="scss">
$bg: #283443;
$light_gray: #fff;
$cursor: #fff;
@supports (-webkit-mask: none) and (not (cater-color: $cursor)) {
  .login-container .el-input input {
    color: $cursor;
  }
}

.login-container {
  .el-input {
    display: inline-block;
    height: 47px;
    width: 85%;

    input {
      background: transparent;
      border: 0px;
      -webkit-appearance: none;
      border-radius: 0px;
      padding: 12px 5px 12px 15px;
      color: $light_gray;
      height: 47px;
      caret-color: $cursor;

      &:-webkit-autofill {
        box-shadow: 0 0 0px 1000px $bg inset !important;
        -webkit-text-fill-color: $cursor !important;
      }
    }
  }

  .el-form-item {
    border: 1px solid rgba(255, 255, 255, 0.1);
    background: rgba(0, 0, 0, 0.1);
    border-radius: 5px;
    color: #454545;
  }
}
</style>

<style lang="scss" scoped>
$bg: #2d3a4b;
$dark_gray: #889aa4;
$light_gray: #eee;

.login-container {
  min-height: 100%;
  width: 100%;
  overflow: hidden;
  background: url(../assets/login.jpeg);
  background-size: 100% 100%;
  height: 700px;
  // 头像
  .avatar-box {
    margin: 0 auto;
    width: 120px;
    height: 120px;
    border-radius: 50%;
    border: 1px solid #409eff;
    box-shadow: 0 0 10px #409eff;
    position: relative;
    bottom: 20px;

    img {
      width: 100%;
      height: 100%;
      border-radius: 50%;
    }
  }

  .login-form {
    position: relative;
    width: 520px;
    max-width: 100%;
    padding: 160px 35px 0;
    margin: 0 auto;
    overflow: hidden;

  }

  .tips {
    font-size: 18px;
    text-align: center;
    color: #000;
    margin-bottom: 10px;
  }

  .svg-container {
    padding: 6px 5px 6px 15px;
    color: $dark_gray;
    vertical-align: middle;
    width: 30px;
    display: inline-block;
  }

  .title-container {
    position: relative;

    .title {
      font-size: 30px;
      color: $light_gray;
      margin: 0px auto 40px auto;
      text-align: center;
      font-weight: 500;
    }
  }

  .show-pwd {
    position: absolute;
    right: 10px;
    top: 7px;
    font-size: 16px;
    color: $dark_gray;
    cursor: pointer;
    user-select: none;
  }
}
</style>

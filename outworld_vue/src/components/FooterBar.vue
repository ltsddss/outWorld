<script>
export default {
  name: 'FooterBar',
  data: function () {
    return {
      footerTitle: 'lts_419253381@qq.com'
    }
  }
}
</script>

<template>
  <el-row class="footer">
    <el-col :span="4">
      <p></p>
    </el-col>

    <el-col :span="25">
      <el-row>
        <el-col :span="30"
                class="footer-logo">
          <img class="footer-img"
               src="../assets/logo.gif"
               width="68px"
               height="68px" />
          <span class="footer-title">{{footerTitle}}</span>
        </el-col>

        <el-col :span="12">
          <div class="divider"><el-col :span="7">
            <el-row>
              <el-col :span="12"
                      class="footer-word">关于我们</el-col>
              <el-col :span="12"
                      class="footer-word">联系我们</el-col>
            </el-row>
            <el-row>
              <el-col :span="12"
                      class="footer-word">友情链接</el-col>
              <el-col :span="12"
                      class="footer-word">加入我们</el-col>
            </el-row>
          </el-col></div>
        </el-col>
      </el-row>
    </el-col>

    <el-col :span="4">
      <p></p>
    </el-col>
  </el-row>
</template>

<style scoped>
.footer {
  margin-top: 60px;
  background-color: #212121;
  padding-top: 26px;
  padding-bottom: 40px;
  margin: 0 -20px;
}
.footer-logo {
  display: flex;
  align-items: center;
}
.footer-img {
  margin-right: 24px;
  border-radius: 10px;
}
.footer-title {
  color: #fff;
  font-size: 25px;
}
.footer-word {
  cursor: pointer;
  color: #fff;
  font-size: 14px;
  padding: 7px;
}
.divider {
  width: 500px;
  height: 88px;
  background-color: hsla(0, 0%, 100%, 0.2);
}
</style>

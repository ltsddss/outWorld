<template>
  <div>
    <el-container>
      <!-- header -->
      <el-header style="height:auto">
        <nav-head :user="user"></nav-head>
      </el-header>
      <el-main style="width: 1200px;margin: auto">
        <el-row :span="4">
          <el-col :span="2">
            <Video :video-info="videoInfo"></Video>
          </el-col>
          <el-col :span="2">
            <div></div>
          </el-col>
        </el-row>

      </el-main>
      <!-- footer -->
      <el-footer style="height:auto">
        <footer-bar></footer-bar>
      </el-footer>
    </el-container>
  </div>
</template>

<script>
import videojs from "video.js";
import Home from "../home";
import NavHead from '../../components/NavHead.vue'
import FooterBar from '../../components/FooterBar.vue'
import Video from "../../components/Video";

export default {
  data: function () {
    return {
      user: null,
      carousels: null,
      videoInfo:{
        img:'../../static/imgs/notStartBorast.png',
        url:'http://192.168.10.100:8080/lives/livestream.m3u8',
        borastId:null
      },
    }
  },
  components: {
    Video,
    Home,
    NavHead,
    FooterBar
  },
}
</script>

<style scoped>

</style>

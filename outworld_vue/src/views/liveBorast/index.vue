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
            <video
              id="my-video"
              class="video-js vjs-default-skin"
              controls
              poster="../../../static/imgs/notStartBorast.png"
              preload="auto"
              style="width: 668px;height: 376px;"
            >
              <source :src="srcUrl"/>
            </video>
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

export default {
  data: function () {
    return {
      user: null,
      carousels: null
    }
  },
  components: {
    Home,
    NavHead,
    FooterBar
  },
  props: {
    "srcUrl": {
      type: String,
      default: 'http://192.168.10.100:8080/lives/livestream.m3u8'
    }
  },
  mounted() {
    this.getVideo();
  },
  methods: {
    getVideo() {
      videojs(
        "my-video",
        {
          bigPlayButton: true,
          textTrackDisplay: false,
          posterImage: true,
          errorDisplay: false,
          controlBar: false
        },
        function () {
          this.play();
        }
      );
    },
  }
}
</script>

<style scoped>

</style>

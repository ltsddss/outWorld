<template>
  <el-carousel :interval="4000"
               type="card"
               height="480px">
    <el-carousel-item v-for="(item,index) in carousels"
                      :key="index">
      <video
        id="my-video"
        class="video-js vjs-default-skin"
        controls
        poster="../../static/imgs/notStartBorast.png"
        preload="auto"
        style="width: 100%;height: 100%;"
      >
        <source :src="item"/>
      </video>
    </el-carousel-item>
  </el-carousel>

</template>
<script>
import videojs from "video.js";

export default {
  name: 'Carousel',
  data: function () {
    return {
    }
  },
  mounted() {
    this.getVideo();
  },
  methods:{
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
  },
  props: ['carousels']

}
</script>
<style scoped>
.el-carousel {
  background-image: linear-gradient(
    to right,
    rgba(0, 0, 0, 1),
    rgba(0, 0, 0, 0.34),
    rgba(0, 0, 0, 1)
  );
  /* background-color: rgba(0, 0, 0, 0.8); */
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>

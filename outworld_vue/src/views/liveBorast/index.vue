<template>
  <div>
    <video
      id="my-video"
      class="video-js vjs-default-skin"
      controls
      preload="auto"
      width="500px">
      <source :src="srcUrl" />
    </video>
  </div>
</template>

<script>
import videojs from "video.js";
export default {
  props:{
    "srcUrl":{
      type:String,
      default:'http://192.168.10.100:8080/lives/livestream.m3u8'
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
        function() {
          this.play();
        }
      );
    },
  }
}
</script>

<style scoped>

</style>

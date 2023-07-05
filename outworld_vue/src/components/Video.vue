<template>
  <video
    id="roomLive"
    class="video-js vjs-default-skin"
    controls
    :poster="videoInfo.img"
    muted
    style="width: 668px;height: 376px;"
  >
    <source :src="videoInfo.url"/>
  </video>
</template>

<script>
import videojs from "video.js";

export default {
  name: "Video",
  data: function (){
    return{
      //判断视频是否正在加载
      playVideo:false
    }
  },
  props: ['videoInfo'],
  created() {
  //  当用户进入直播间之后，将redis的当前直播间的在线人数加一（考虑到人数很多，可以先存入rabbitmq，在计入redis）
  //  同时获取到在线人数信息
  },
  mounted() {
    this.getVideo();
  },
  methods: {
    getVideo() {
      videojs(
        "roomLive",
        {
          bigPlayButton: true,
          textTrackDisplay: false,
          posterImage: true,
          errorDisplay: false,
          controlBar: false
        },
        function () {
          console.log(this)
          this.on('loadedmetadata', function () {
            console.log('loadedmetadata');
            //加载到元数据后开始播放视频
            this.play();
            this.playVideo=true
          })
          this.on('ended', function () {
            console.log('ended')
          })
          this.on('firstplay', function () {
            console.log('firstplay')
          })
          this.on('loadstart', function () {
            //开始加载
            console.log('loadstart')
          })
          this.on('loadeddata', function () {
            console.log('loadeddata')
          })
          this.on('seeking', function () {
            //正在去拿视频流的路上
            console.log('seeking')
          })
          this.on('seeked', function () {
            //已经拿到视频流,可以播放
            console.log('seeked')
          })
          this.on('waiting', function () {
            console.log('waiting')
            setTimeout(function(){
              if(!this.playVideo===true){
                console.log("视频加载失败")
              }
            },3000);
          })
          this.on('pause', function () {
            console.log('pause')
          })
          this.on('play', function () {
            console.log('play')
          })
        }
      );
    },
  }
}
</script>

<style scoped>

</style>

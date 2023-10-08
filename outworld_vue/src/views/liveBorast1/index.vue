<template>
  <div id="dplayer"></div>
</template>

<script>
import DPlayer from 'dplayer';

const dp=document.getElementById('dplayer')
export default {
  name: "index",
  data: function(){
    return{
      options:{
        container: document.getElementById('dplayer'),
        video: {
          url: 'D:\\outWorld\\outworld_vue\\static\\video\\5d21496aeeb823a9c7c1496b777141d2.mp4',
        },
      }
    }
  }
}
</script>

<style scoped>

</style>

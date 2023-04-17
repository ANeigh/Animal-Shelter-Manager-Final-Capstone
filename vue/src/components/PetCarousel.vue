<template>
  <div class="CatImages">
    <div v-for="(imageUrl, index) in imageUrls" :key="index">
      <img :src="imageUrl" alt="Cat Image" />
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "CatImages",
  data() {
    return {
      imageUrls: [],
    }
  },
  created() {
    axios.get("https://cataas.com/cat")
      .then(response => {
        this.imageUrls.push(response.request.responseURL);
        return axios.get("https://cataas.com/cat");
      })
      .then(response => {
        this.imageUrls.push(response.request.responseURL);
        return axios.get("https://cataas.com/cat");
      })
      .then(response => {
        this.imageUrls.push(response.request.responseURL);
        return axios.get("https://cataas.com/cat");
      })
      .catch(error => console.log(error));
  },
};
</script>

<style>
.CatImages {
 display: flex;
  justify-content:space-between;
  align-items: center;
   margin: 20px 0; 
  background-color: #a28f9d;
  border-top: 15px solid #2F0A28;
  border-bottom: 15px solid #2F0A28;
  border-left: 15px solid #2F0A28;
  border-right: 15px solid #2F0A28;
  border-radius: 10px;
  overflow: hidden;
  max-width: 80%;
  margin: 0 auto; 
  position: relative;
  bottom: 12%;
  left: 50%;
  transform: translateX(-50%);
  max-height: 300px;
  top: 80%;
}


.CatImages img {
  max-width: 300px;
  border-radius: 10px;
}
</style>
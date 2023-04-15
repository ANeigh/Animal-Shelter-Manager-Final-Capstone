<template>
  <div class="home">
    <NavBar />
    <Social />
    <Carousel />
    <Footer />
  </div>
</template>

<script>
import NavBar from "../components/NavBar";
import Social from "../components/Social";
import Carousel from "../components/PetCarousel.vue";
import Footer from "../components/Footer.vue";
// import HomeService from "../services/HomeService";
import axios from 'axios';

export default {
  name: "home",
  components: {
    NavBar,
    Social,
    Carousel,
    Footer,
  },
  methods: {
    // getPic(){
    //   HomeService.pic().then(response => {
    //     const imageUrl = response.request.responseURL;
    //     const img = document.createElement("img");
    //     img.src = imageUrl;
    //     // document.body.appendChild(img);
    //   })
    // }
  },
  created() {
    axios.get("https://cataas.com/cat")
      .then(response => {
        this.imageUrls.push(response.request.responseURL);
        return axios.get("https://cataas.com/cat");
      })
  }
};
</script>
<style>
.home {
 background-image: url("https://cataas.com/cat");
  background-size: 100% 100%;
  background-position: center;
  height: 100vh;
  margin-top: 0px;
  
}
/* .loginButton {
  display: flex;
} */
.NavBar {
  display: flex;
  justify-content: center;
  position: fixed;
  top: 0; 
} 


</style>

<template>
  <div class="home">

    <NavBar />
    <!-- <div>{{getPic()}}</div> -->
    <WelcomeBanner />
    <Social />
    <Carousel />
    <Footer />
  </div>
</template>

<script>
import NavBar from "../components/NavBar";
import WelcomeBanner from "../components/WelcomeBanner.vue";
import Social from "../components/Social";
import Carousel from "../components/PetCarousel.vue";
import Footer from "../components/Footer.vue";
import HomeService from "../services/HomeService";

export default {
  name: "home",
  components: {
    NavBar,
    WelcomeBanner,
    Social,
    Carousel,
    Footer,
  },
  methods: {
    getPic(){
      HomeService.pic().then(response => {
        const imageUrl = response.request.responseURL;
        const img = document.createElement("img");
        img.src = imageUrl;
        // document.body.appendChild(img);
      })
    }
  },
  created() {
    this.getPic();
  }
};
</script>
<style>
.home {
  background: mintcream;
  background-image: url("https://cataas.com/cat");
  background-size: cover;
  background-position: center;
  width: 100%;
  height: 100%;
  
  
}
</style>

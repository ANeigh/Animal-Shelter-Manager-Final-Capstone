<template>
  <div class="home">
    <NavBar />
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

export default {
  name: "home",
  components: {
    NavBar,
    WelcomeBanner,
    Social,
    Carousel,
    Footer
  },
};

</script>
<style>
.home{
  background : cadetblue;
  background-image: url(../assets/BgImage.png);
}
</style>

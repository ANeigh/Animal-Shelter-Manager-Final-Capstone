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
// import axios from 'axios';

export default {
  name: "home",
  components: {
    NavBar,
    Social,
    Carousel,
    Footer,
  },
  methods: {
  
  },
  created() {
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
.loginButton {
  display: flex;
}



</style>

<template>
  <section class="volunteerlist">
    <NavBar />
    <Social />
    <Carousel />
    <Footer />
  </section>
</template>

<script>
import NavBar from "../components/NavBar";
import Social from "../components/Social";
import Carousel from "../components/PetCarousel.vue";
import Footer from "../components/Footer.vue";
export default {
  name: "volunteerlistview",
  components: {
    NavBar,
    Social,
    Carousel,
    Footer,
  },
};
</script>

<style>
.volunteerlist {
  background-image: url("https://cataas.com/cat");
  background-size: 100% 100%;
  background-position: center;
  height: 100vh;
  position: relative;
}
</style>
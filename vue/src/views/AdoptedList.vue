<template>
  <section class="adoptedlist">
    <NavBar />
    <!-- <Carousel /> -->
    <Footer />
  </section>
</template>

<script>
import NavBar from "../components/NavBar";

// import Carousel from "../components/PetCarousel.vue";
import Footer from "../components/Footer.vue";
export default {
  name: "adoptedlistview",
  components: {
    NavBar,
    // Carousel,
    Footer,
  },
};
</script>

<style>
/* .adoptedlist {
  background-image: url("https://cataas.com/cat");
  background-size: 100% 100%;
  background-position: center;
  height: 100vh;
  position: relative;
} */
</style>
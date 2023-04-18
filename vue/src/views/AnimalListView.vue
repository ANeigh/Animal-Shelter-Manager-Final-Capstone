<template>
  <section class="animallist">
    <NavBar />
    <animal-list></animal-list>
    <!-- <Carousel /> -->
    <Footer />
  </section>
</template>

<script>
import NavBar from "../components/NavBar";
// import Carousel from "../components/PetCarousel.vue";
import Footer from "../components/Footer.vue";
import AnimalList from '../components/AnimalList.vue';
export default {
  name: "animallistview",
  components: {
    NavBar,
    // Carousel,
    Footer,
    AnimalList,
  },
};
</script>

<style>
</style>
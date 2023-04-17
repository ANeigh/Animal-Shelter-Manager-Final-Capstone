<template>
  <section class="animallist">
    <NavBar />
    <animal-list></animal-list>
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
import AnimalList from '../components/AnimalList.vue';
export default {
  name: "animallistview",
  components: {
    NavBar,
    Social,
    Carousel,
    Footer,
    AnimalList,
  },
};
</script>

<style>
.animallist {
  background-image: url("https://cataas.com/cat");
  background-size: 100% 100%;
  background-position: center;
  height: 100vh;
  position: relative;
}
</style>
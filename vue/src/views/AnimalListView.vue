<template>
  <section class="animallist">
    <NavBar />
    <animal-list></animal-list>
    <add-animal-form />
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
import AddAnimalForm from '../components/AddAnimalForm.vue';
export default {
  name: "animallistview",
  components: {
    NavBar,
    Social,
    Carousel,
    Footer,
    AnimalList,
    AddAnimalForm,
  },
};
</script>

<style>

</style>
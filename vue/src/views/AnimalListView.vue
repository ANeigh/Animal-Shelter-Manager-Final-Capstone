<template>
  <section class="animallist">
    <NavBar />
    <animal-list></animal-list>
    <Footer />
  </section>
</template>

<script>
import NavBar from "../components/NavBar";
import Footer from "../components/Footer.vue";
import AnimalList from '../components/AnimalList.vue';
export default {
  name: "animallistview",
  components: {
    NavBar,
    Footer,
    AnimalList,
  },
};
</script>

<style>
</style>
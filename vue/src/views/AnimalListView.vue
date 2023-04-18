<template>
  <section class="animallist">
    <NavBar />
    <add-animal-form />
    <animal-list></animal-list>
    <Footer />
  </section>
</template>

<script>
import NavBar from "../components/NavBar";
import Footer from "../components/Footer.vue";
import AnimalList from '../components/AnimalList.vue';
import AddAnimalForm from '../components/AddAnimalForm.vue';
export default {
  name: "animallistview",
  components: {
    NavBar,
    Footer,
    AnimalList,
    AddAnimalForm,
  },
};
</script>

<style>
</style>
<template>
  <div>
    <nav-bar></nav-bar>
    <update-animal v-bind:animal="getAnimal"/>
    <animal-detail v-bind:animal="getAnimal"/>
    <Footer />
  </div>
</template>

<script>
import AnimalDetail from '../components/AnimalDetail.vue';
import Footer from '../components/Footer.vue';

import NavBar from "../components/NavBar.vue";
import UpdateAnimal from '../components/UpdateAnimal.vue';

export default {
  name: "animaldetails",
  components: {
    NavBar,
    AnimalDetail,
    UpdateAnimal,
    Footer
  },
  computed: {
    getAnimal() {
      const animals = this.$store.state.animals;
      return animals.find(animal => animal.animalId == this.$route.params.animalId);
    }
  }
};
</script>

<style>

</style>
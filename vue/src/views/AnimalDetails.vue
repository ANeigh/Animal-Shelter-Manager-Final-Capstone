<template>
  <div class="">
    <nav-bar></nav-bar>
    <animal-detail v-bind:animal="getAnimal"/>
  </div>
</template>

<script>
import AnimalDetail from '../components/AnimalDetail.vue';

import NavBar from "../components/NavBar.vue";

export default {
  name: "animaldetails",
  components: {
    NavBar,
    AnimalDetail
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
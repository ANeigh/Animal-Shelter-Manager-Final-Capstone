<template>
  <div class="list">
    <nav-bar></nav-bar>
    <animal-list></animal-list>

  </div>
</template>

<script>

import AnimalList from "../components/AnimalList.vue";
import NavBar from "../components/NavBar.vue";

export default {
  name: "list",
  components: {
    NavBar,
    AnimalList
  }
};
</script>

<style>

</style>
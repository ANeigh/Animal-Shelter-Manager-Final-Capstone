<template>
  <div class="book-container">
      <animal-card
      v-bind:animal="animals"
      v-for="animal in $store.state.animals"
      v-bind:key="animal.id"      
      >
  </div>
</template>

<script>

import AnimalCard from './AnimalCard.vue';

export default {
    components: {
        AnimalCard
    }
}
</script>

<style>
.book-container {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
}

</style>
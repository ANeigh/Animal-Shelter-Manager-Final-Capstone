<template>
    <section>
        <h1>Animals Available For Adoption</h1>
    <div class="animal-container">
      <animal-card
      v-bind:animal="animal"
      v-for="animal in $store.state.animals"
      v-bind:key="animal.animalId"      
      />
  </div>
    </section>
</template>

<script>
import AnimalCard from './AnimalCard.vue';

export default {
    name: 'animal-list',
    components: {
        AnimalCard
    }
}
</script>

<style>
.animal-container {
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    background: #A28f9D;
    padding-top: 150px;
}

</style>
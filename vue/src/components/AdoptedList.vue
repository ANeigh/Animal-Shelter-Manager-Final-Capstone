<template>
  <div>
        <b-carousel id="adopted-pet-carousel">
          <b-carousel-slide v-for="animal in adoptedPets" :key="animal.id">
              <animal-card :animal="animal"></animal-card>
          </b-carousel-slide>
        </b-carousel>
  </div>
</template>

<script>

import AnimalCard from '@/components/AnimalCard.vue';

export default {
  components: { AnimalCard },

  computed: {
      adoptedPets() {
          return this.$store.state.animals.filter(animal => animal.status === 'Adopted');
      }
  }

}

</script>

<style>


</style>
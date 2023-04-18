<template>
  <div class="CatImages">
    <h2>Celebrate Adopted Pets With Us</h2>
    <div class="Carousel">
      <button @click="previousPage">&#8249;</button>
      <div class="Images">
        <animal-card
          v-bind:animal="animal"
          v-for="(animal, index) in displayedAnimals"
          v-bind:key="animal.animalId"
          v-bind:class="{ active: index === activeIndex }"
        />
      </div>
      <button @click="nextPage">&#8250;</button>
    </div>
  </div>
</template>

<script>
import AnimalCard from "./AnimalCard.vue";

export default {
  name: "CatImages",
  components: {
    AnimalCard,
  },
  data() {
    return {
      activeIndex: 0,
    };
  },
  computed: {
    displayedAnimals() {
  const animals = this.$store.state.animals.filter((a) => a.adopted);
  const start = this.activeIndex;
  const end = this.activeIndex + 3;
  const sortedAnimals = animals.sort((a, b) => b.id - a.id);
  return sortedAnimals.slice(start, end);
},
  },
  methods: {
    previousPage() {
      const animals = this.$store.state.animals.filter((a) => a.adopted);
      if (this.activeIndex > 0) {
        this.activeIndex -= 1;
      } else {
        this.activeIndex = animals.length - 3;
      }
    },
    nextPage() {
      const animals = this.$store.state.animals.filter((a) => a.adopted);
      if (this.activeIndex < animals.length - 3) {
        this.activeIndex += 1;
      } else {
        this.activeIndex = 0;
      }
    },
  },
};
</script>

<style>
.CatImages {
  display: flex;
  justify-content: center;
  background: #a28f9d;
  font-family: "sans-serif";
}

.Carousel {
  display: flex;
  align-items: center;
}

.Images {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.Carousel button {
  font-size: 60px;
  margin: 0 16px;
  border: none;
  background: none;
  color: gray;
  cursor: pointer;
  outline: none;
}

.Carousel button:hover {
  color: black;
}
.CatImages h2 {
  display: flex;
  justify-content: center;
  align-items: center;
  text-align: center;
  font-size: 40px;
  font-weight: bold;
  margin-bottom: 16px;
  margin-right: 500px;
  color:mintcream;
}
</style>
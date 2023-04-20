<template>
  <section class="adoptedlist">
    <NavBar />
    <RandomCatPic mission="These Fur Babies Found A FurrEver Home" />
    <div class="animal-container">
      <animal-card
        v-bind:animal="animal"
        v-for="animal in adoptedAnimals"
        v-bind:key="animal.animalId"
      />
    </div>
    <Footer />
  </section>
</template>

<script>
import NavBar from "../components/NavBar";
import AnimalCard from "../components/AnimalCard.vue";
import Footer from "../components/Footer.vue";
import RandomCatPic from "../components/RandomCatPic.vue";

export default {
  name: "adoptedlistview",
  components: {
    NavBar,
    RandomCatPic,
    AnimalCard,
    Footer,
  },
  computed: {
    adoptedAnimals() {
      return this.$store.state.animals.filter((animal) => animal.adopted);
    },
  },
};
</script>

<style>
.animal-container {
  display: flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  background:#a28f9d;
  padding-top: 150px;
}
</style>
<template>
  <section class="section">
    <carousel class="images">
      <slide v-for="(imgs, index) in getAnimalImages(animal.animalId)"
      v-bind:key="index"> <img :src="imgs.url"> </slide>
    </carousel>
    <div class="information">
    <p class="name">Name: {{ animal.name }}</p>
    <p class = "name">Breed: {{ animal.breed }}</p>
    <p class = "name">Gender: {{ animal.gender }}</p>
    <p class = "name">Age: {{ animal.age }}</p>
    <p class = "name">Color: {{ animal.color }}</p>
    <p class = "name" v-show="animal.tags">Tags: {{ animal.tags }}</p>
    <p class = "description">{{ animal.description }}</p>
    </div>
  </section>
</template>

<script>
import { Carousel, Slide } from "vue-carousel";

export default {
  name: "animaldetail",
  props: ["animal"],
  components: {
    Carousel,
    Slide,
  },
  methods: {
    getAnimalImages(animalId) {
      const animalImages = this.$store.state.imgs.filter(
        (img) => img.animalId === animalId
      );
      return animalImages;
    },
  },
};
</script>


<style>
.images {
  width: auto;
  height: auto;
  max-width: 600px;
  max-height: 600px;
  align-content: center;
  justify-content: center;
  margin: 0 auto;
}
.information {
    margin: 0 auto;
    text-align: center;
}
.name {
    align-content: center;
    justify-content: center;
    margin: 0 auto;
    background-color: #7C909E
}
.description {
    background-color:#a28f9d;
}
.section {
    background-color: #235789;

}


</style>
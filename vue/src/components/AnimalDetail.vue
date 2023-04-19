<template>
  <section class="section2">
      <div>
    <carousel class="images">
      <slide v-for="(imgs, index) in getAnimalImages(animal.animalId)"
      v-bind:key="index"> <img :src="imgs.url"> </slide>
    </carousel>
    <div class="information">
    <p>Breed: {{ animal.breed }}</p>
    <p>Gender: {{ animal.gender }}</p>
    <p>Age: {{ animal.age }}</p>
    <p>Color: {{ animal.color }}</p>
    <p v-show="animal.tags">Tags: {{ animal.tags }}</p>
    </div>
    </div>
    <div class="description">
    <p class="name">{{ animal.name }}</p>
    <p class="description">{{ animal.description }}</p>
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
  min-width: 400px;
  min-height: 400px;
  align-content: center;
  justify-content: center;
  margin: 0 auto;
  padding-top: 70px;
}
.information {
    margin: 0 auto;
    text-align: center;
    background-color: #7C909E;
}
.name {
    background-color: #a28f9d;
    font-size: 50px;
}
.description {
    background-color:#a28f9d;
}
.section2 {
    display: flex;
   background-color: #7c909e;
}


</style>
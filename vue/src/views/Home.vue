<template>
  <div class="home">
    <NavBar />
    <RandomCatPic
      mission="Our Mission"
      description="Caring for animals and getting them to their furrever home!"
      link="/about"
      linkText="Click if you want to know more "
      linkLabel="about us"
    />
    <Carousel />  
    <Footer />
  </div>
</template>

<script>
import NavBar from "../components/NavBar";
import Carousel from "../components/PetCarousel.vue";
import Footer from "../components/Footer.vue";
import animalService from "../services/AnimalService";
import imgService from "../services/ImgService";
import RandomCatPic from "../components/RandomCatPic.vue"


export default {
  name: "home",
  components: {
    NavBar,
    RandomCatPic,
    Carousel,
    Footer,
  },
  methods: {
    getAnimals() {
      animalService.getAllAnimals().then(response => {
        this.$store.commit("SET_ANIMALS", response.data);
      });
    },
    getImgs() {
      imgService.getAllImgs().then(response => {
        this.$store.commit("SET_IMGS", response.data);
      });
    }
  },
  created() {
    if (this.$store.state.animals.length === 0) {
      this.getAnimals();
    }
    if (this.$store.state.imgs.length === 0) {
      this.getImgs();
    }
  }
};
</script>
<style>


</style>

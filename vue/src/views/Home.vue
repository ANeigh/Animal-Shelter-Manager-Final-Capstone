<template>
  <div class="home">
    <NavBar />
    <Social />
    <Carousel />
    <Footer />
  </div>
</template>

<script>
import NavBar from "../components/NavBar";
import Social from "../components/Social";
import Carousel from "../components/PetCarousel.vue";
import Footer from "../components/Footer.vue";
import animalService from "../services/AnimalService";
import imgService from "../services/ImgService";
import { shuffle } from 'lodash';


export default {
  name: "home",
  components: {
    NavBar,
    Social,
    Carousel,
    Footer,
  },
  methods: {
    getAnimals() {
      animalService.getAllAnimals().then(response => {
        this.$store.commit("SET_ANIMALS", shuffle(response.data));
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
.home {
 background-image: url("https://cataas.com/cat");
  background-size: 100% 100%;
  background-position: center;
  height: 100vh;
  margin-top: 0px;
  
}
.loginButton {
  display: flex;
}



</style>

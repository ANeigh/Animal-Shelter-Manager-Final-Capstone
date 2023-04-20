<template>
  <section class="animallist">
    <NavBar />
    <add-animal-form />
    <animal-list></animal-list>
    <Footer />
  </section>
</template>

<script>
import NavBar from "../components/NavBar";
import Footer from "../components/Footer.vue";
import AnimalList from '../components/AnimalList.vue';
import AddAnimalForm from '../components/AddAnimalForm.vue';
import animalService from "../services/AnimalService";
import imgService from "../services/ImgService";
import { shuffle } from 'lodash';
export default {
  name: "animallistview",
  components: {
    NavBar,
    Footer,
    AnimalList,
    AddAnimalForm,
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
</style>
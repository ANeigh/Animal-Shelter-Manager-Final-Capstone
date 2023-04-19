<template>
  <section>
      <figure v-for="(imgs, index) in getAnimalImages(animal.animalId)" v-bind:key="index">
          <img class="images" :src="imgs.url">
      </figure>
      <p>{{animal.name}}</p>
      <p>{{animal.breed}}</p>
      <p>{{animal.gender}}</p>
      <p>{{animal.age}}</p>
      <p>{{animal.color}}</p>
      <p>{{animal.tags}}</p>
      <p>{{animal.description}}</p>
      
  </section>
</template>

<script>

export default {
    name: 'animaldetail',
    props: ['animal'],
    methods: {
        getAnimalImages(animalId) {
            const animalImages = this.$store.state.imgs.filter(img => img.animalId === animalId);
            return animalImages;
        }
    },
}
</script>


<style>
.images{
    width: auto;
    height: auto;
    max-width: 200px;
    max-height: 200px;
    margin-top: 200px;
}

.animal-details{
    
}
</style>
<template>
  <div class="animal-card" @click="toAnimalDetails">
      <img v-bind:src='getFirstImageUrl(animal.animalId)' class="animal-image">
      <h1 class='animal-name'>{{animal.name}}</h1>
      <h3 class='animal-breed'>{{animal.breed}}</h3>
  </div>
</template>

<script>
export default {
    name: 'animal-card',
    props: ['animal'],
    methods: {
        toAnimalDetails() {
            this.$router.push({ name: 'animaldetails', params: { animalId: this.animal.animalId}});
        },
        getFirstImageUrl(animalId) {
            const animalImages = this.$store.state.imgs.filter(img => img.animalId === animalId);
            return animalImages && animalImages.length > 0 ? animalImages[0].url : '';
        }
    }
}
</script>

<style>
.animal-card {
    border-radius: 10px;
    width: 250px;
    height: 300px;
    margin: 20px;
    background-color: #8BAAAD;
    transition: transform 0.3s ease-in-out;
}
.animal-card:hover {
    transform: scale(1.05);
}
.animal-card .animal-name {
    font-size: 1.5rem;
    text-align: center;
    color: #235789;
}

.animal-card .animal-breed {
    font-size: 1rem;
    text-align: center;
    color: black;
}

.animal-image {
    max-height: 220px;
    object-fit: cover;
    width: 100%;
    border-top-right-radius: 10px;
    border-top-left-radius: 10px;
}

</style>
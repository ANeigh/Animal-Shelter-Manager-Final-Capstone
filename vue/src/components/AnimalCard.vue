<template>
  <div class="animal-card" @click="toAnimalDetails">
      <h2 class='animal-name'>{{animal.name}}</h2>
      <img v-bind:src='animal.url'>
      <h3 class='animal-breed'>{{animal.breed}}</h3>
  </div>
</template>

<script>
export default {
    name: 'animal-card',
    props: ['animal'],
    methods: {
        toAnimalDetails() {
            this.router.push({ name: '', params: { id: this.animal.id}});
        }
    }

}
</script>

<style>
.animal-card {
    border: 1px solid black;
    border-radius: 10px;
    width: 250px;
    height: 400px;
    margin: 20px;
    background: lightblue;
    transition: transform 0.3s ease-in-out;
}
.animal-card:hover {
    transform: scale(1.05);
}
.animal-card .animal-name {
    font-size: 1.5rem;
    text-align: center;
}

.animal-card .animal-breed {
    font-size: 1rem;
    text-align: center;
}

</style>
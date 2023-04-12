<template>
  <div class="animal-card" @click="toAnimalDetails">
      <h2 class>{{animal.name}}</h2>
      <img>
      <h3>{{animal.breed}}</h3>
      <h3>{{animal.gender}}</h3>

  </div>
</template>

<script>
export default {
    name: 'animal-card',
    props: {
        animal: Object
    },
    methods: {
        toAnimalDetails() {
            this.router.push({ name: '', params: { id: this.animal.id}});
        }
    }

}
</script>

<style>
.animal-card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
    transition: transform 0.3s ease-in-out;
}
.animal-card:hover {
    transform: scale(1.05);
}

</style>
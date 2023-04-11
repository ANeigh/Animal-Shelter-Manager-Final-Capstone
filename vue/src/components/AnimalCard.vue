<template>
  <div class="card">
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
        book: Object
    }

}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}

</style>
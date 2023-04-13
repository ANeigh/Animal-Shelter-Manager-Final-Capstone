<template>
  <section class="Welcome">
    <img class="WelcomePic" src="../assets/Job-AnimalShelter.png" />
    <h1>Welcome to Restful Retreat Shelter</h1>
  </section>
</template>

<script>
export default {};
</script>

<style>
.Welcome {
  display: flex;  
  flex-direction: row;
  align-items: center; 
  justify-content: center;
  position: absolute;
  top: 25px;
  left: 5px;
}
.WelcomePic {
  float: left;
  top: 0;
  left: 0;
  margin-right: 10px;
  width: 200px;
  height: 200px;
}
h1 {  
  font-family: "Oswald", sans-serif;
  font-size: 30px;
  text-transform: uppercase;
  color:  gray;
  margin-left: 20px;

}
</style>
<template>
  <section class="nav">
    <router-link to="/">
    <img class="WelcomePic" src="../assets/Job-AnimalShelter.png" />
    </router-link>
    <h1 class="PicText">Restful Retreat Shelter</h1>
    <router-link class="navButtons" to="{name: ''}">About Us</router-link>&nbsp;                                                                                
    <router-link class="navButtons" to="{name: 'list'}">Animal List</router-link>&nbsp;
    <router-link class="navButtons" to="{name: ''}">Adopted List</router-link>&nbsp;
    <router-link class="navButtons" to="{name: 'register'}">Volunteer Sign up</router-link>&nbsp;
    <router-link class="navButtons" to="{name: 'volunteer'}">Volunteer Directory</router-link>
  </section>
</template>

<script>
export default {
  name: "nav-bar",
};
</script>

<style>
.nav {
  display: flex;
  flex-direction: row;
  justify-content: center;
  position: absolute;
  top: 25px;
  right: 5px;
  background-color: #a28f9d;
  border-top: 15px solid #2F0A28;
  border-bottom: 15px solid #2F0A28;
  border-left: 15px solid #2F0A28;
  border-right: 15px solid #2F0A28;
  border-radius: 10px;
}
.WelcomePic {
  display: flex;
  margin-right: 10px;
  width: 250px;
  height: 150px;
}

.PicText {
  font-family: "Oswald", sans-serif;
  font-size: 50px;
  text-transform: uppercase;
  color: #235789;
  text-align: center;
  margin-right:  10px;
}

.navButtons {
  font-size: 35px;
  color: #2F0A28;
  text-align: center;

}
</style>
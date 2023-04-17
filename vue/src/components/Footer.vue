<template>
  <section class="footer">
    <div class="quick-links">
      <p class="footer-item">
        <router-link class="navButtons" to="/about">About Us</router-link>
      </p>
      <p class="footer-item">
        <router-link class="navButtons" to="/animallist"
          >Animal List</router-link
        >
      </p>
      <p class="footer-item">
        <router-link class="navButtons" to="/adoptedlist"
          >Adopted List</router-link
        >
      </p>
      <p class="footer-item">
        <router-link class="navButtons" to="/register">Register</router-link>
      </p>
    </div>
    <div class="footer-contact">
      <p class="footer-item">Address: 123 Main Street, Pittsburgh, PA 15220</p>
      <p class="footer-item">Phone: (555) 555-5555</p>
      <p class="footer-item">Email: info@restfulretreatshelter.org</p>
      <p class="footer-item">Website: www.restfulretreatshelter.org</p>
    </div>
    <div class="Social">
      <p class="SocialText">Facebook: Name: Restful Retreat Shelter</p>
      <p class="SocialText">Twitter: Handle: @RestfulRetreat</p>
      <p class="SocialText">Instagram: Handle: @restfulretreatshelter</p>
      <p class="SocialText">YouTube: Name: Restful Retreat Shelter</p>
      <p class="SocialText">TikTok: Handle: @restfulretreatshelter</p>

      <img class="SocialPic" src="../assets/SocialIcons.png" />
    </div>
  </section>
</template>

<style>
.footer {
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  align-content: center;
  position: relative;
  background-color: #2f0a28;
  color: #f4fff8;
  padding: 20px;
  text-align: center;
}
.footer-item {
  margin: 0;
  padding: 5px 0;
  font-size: 20px;
  display: block;
  text-align: left;
}
.footer-contact {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-left: auto;
}
.Social {
  margin-left: auto;
}
.SocialPic {
  width: 100px;
  height: auto;
  margin-top: 10px;
}
.SocialText {
  padding: 5px 0;
  font-size: 20px;
  display: flex;
  justify-content: center;
  padding: 5px;
}
</style>
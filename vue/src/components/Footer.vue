<template>
  <section class="footer">
    <div class="quick-links">
      <p class="Ql-title">Quick Links</p>
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
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: center;
  background-color: #2f0a28;
  padding: 10px 0 20px;
  color:mintcream;
}

.Ql-title {
  text-decoration: underline;
  font-size: 20px;
  margin-bottom: 10px;
}

.quick-links {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-right: 30px;
}

.footer-item {
  padding: 3px 0;
  margin: 0 10px;
  font-size: 20px;
}

.navButtons {
  text-decoration: none;
  transition: all 0.3s ease-in-out;
  font-weight: bold;
}

.navButtons:hover {
  color: #235789;
}

.footer-contact {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-right: 30px;
}

.Social {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-right: 10px;
}

.SocialText {
  margin: 0 0 5px 0;
  font-size: 18px;
}

.SocialPic {
  
  margin-top: 20px;
  width: 150px;
}

</style>
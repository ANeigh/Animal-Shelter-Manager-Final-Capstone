<template>
  <section class="about">
    <h1 class="content">
      Welcome to Restful Retreat Shelter! We are a non-profit animal shelter
      located in the heart of Pittsburgh, PA. Our mission is to provide a safe
      and loving environment for cats, dogs, birds, and rabbits who have been
      abandoned, neglected, or surrendered. At Restful Retreat Shelter, we
      believe that every animal deserves a chance to live a happy and healthy
      life. That's why we work tirelessly to provide our animals with the care
      and attention they need to thrive. Our experienced staff and dedicated
      volunteers are committed to ensuring that each and every animal in our
      care receives the love and support they need to find their forever homes.
      We are proud to be a part of the Pittsburgh community and are committed to
      making a difference in the lives of animals and the people who love them.
      Whether you're looking to adopt a new furry friend or support our mission
      through volunteering, we invite you to join us on our journey
      to help these beautiful fur babies find their forever homes. Thank you for
      considering Restful Retreat Shelter as your trusted partner in animal
      rescue and adoption.
    </h1>
    <NavBar />
    <Social />
    <Carousel />
    <Footer />
  </section>
</template>

<script>
import NavBar from "../components/NavBar";
import Social from "../components/Social";
import Carousel from "../components/PetCarousel.vue";
import Footer from "../components/Footer.vue";
export default {
  name: "about",
  components: {
    NavBar,
    Social,
    Carousel,
    Footer,
  },
};
</script>

<style>
.about {
  background-image: url("https://cataas.com/cat");
  background-size: 100% 100%;
  background-position: center;
  height: 100vh;
  position: relative;
  
}
.content {
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #a28f9d;
  border-top: 15px solid #2F0A28;
  border-bottom: 15px solid #2F0A28;
  border-left: 15px solid #2F0A28;
  border-right: 15px solid #2F0A28;
  border-radius: 10px;
  height: 50vh;
  font-size: 20px;
  text-transform: uppercase;
  padding-top: 80px;
}
.Social {
     margin-top: 65px;
}

</style>
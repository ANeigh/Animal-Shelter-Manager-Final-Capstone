<template>
  <section class="about">
    <RandomCatPic mission="About us" />
    <div class="content">
      <h1 class="content-title">Welcome to Restful Retreat Shelter!</h1>
      <h2 class="content-title">Our Mission Statement</h2>
      <p>Our mission is to provide a safe
      and loving environment for cats, dogs, birds, and rabbits who have been
      abandoned, neglected, or surrendered. At Restful Retreat Shelter, we
      believe that every animal deserves a chance to live a happy and healthy
      life.</p>
      <h2 class="content-title">What We Do</h2>
      <p>We work tirelessly to provide our animals with the care
      and attention they need to thrive. Our experienced staff and dedicated
      volunteers are committed to ensuring that each and every animal in our
      care receives the love and support they need to find their forever homes.
      We are proud to be a part of the Pittsburgh community and are committed to
      making a difference in the lives of animals and the people who love them.</p>
      <h2 class="content-title">What You Can Do</h2>
      <p> Whether you're looking to adopt a new furry friend or support our mission
      through volunteering, we invite you to join us on our journey to help
      these beautiful fur babies find their forever homes. Thank you for
      considering Restful Retreat Shelter as your trusted partner in animal
      rescue and adoption.</p>
    </div>
    <NavBar />
    <Carousel /> 
    <Footer />
  </section>
</template>

<script>
import NavBar from "../components/NavBar";
import Carousel from "../components/PetCarousel.vue";
import Footer from "../components/Footer.vue";
import RandomCatPic from "../components/RandomCatPic.vue";

export default {
  name: "about",
  components: {
    NavBar,
    RandomCatPic,
    Carousel,
    Footer,
  },
};
</script>

<style>
.about {
  font-family: "sans-serif";
}

.content-title{
  color: mintcream !important;
}

.content {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: #a28f9d;
  padding: 20px;
  font-size: 20px;
  line-height: 1.5;
  text-transform: uppercase;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.5);
  height: 70vh;
  margin-top: 0px;
  margin-bottom: 0 !important;
  color: mintcream;
  text-align: center;
}
</style>
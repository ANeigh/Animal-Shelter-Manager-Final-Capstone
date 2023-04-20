<template>
  <div class="RandomCatCard">
    <div class="CatImage">
      <img :src="imageUrl" alt="Cat Image" />
    </div>
    <div class="CatText">
      <p>{{ mission }}</p>
      <p>{{ description }}</p>
      <p>{{ linkText }}<router-link :to="link" class="test">{{ linkLabel }}</router-link></p>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: "CatImageWithText",
  props: {
    mission: {
      type: String,
      required: true
    },
    description: {
      type: String,
      required: false
    },
    link: {
      type: String,
      required: false
    },
    linkText: {
      type: String,
      required: false
    },
    linkLabel: {
      type: String,
      required: false
    }
  },
  data() {
    return {
      imageUrl: "",
    }
  },
  created() {
    axios.get("https://cataas.com/cat")
      .then(response => {
        this.imageUrl = response.request.responseURL;
      })
      .catch(error => console.log(error));
  },
};
</script>

<style>
.RandomCatCard {
  display: flex;
  flex-direction: row;
  justify-content: center;
  align-items: center;
  width: 100%;
  max-width: 100%;
  padding-top: 90px;
  background: #235789;
    font-family: "sans-serif";
}

.CatImage {
  width: 70%;
  display: flex;
  justify-content: left;
  margin-right: 20px;
}

.CatImage img {
  width: 400px;
  height: 400px;
  border-radius: 10px;
}

.CatText {
  display: flex;
  flex-direction: column;
  justify-content: center;
  height: 400px;
  width: 60%;
  font-size: 30px;
  font-weight: 500;
  color:linen;
}
.test {
  color: #08f1ce;
}


</style>
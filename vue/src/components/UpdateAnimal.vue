<template>
  <section class="section" v-if="isLoggedIn">
    <div class="container">
      <div class="header">
        <button id ="bulmaSucks" class="button is-primary is-rounded button-color:white" @click="toggleForm">
          Update Pet Listing
        </button>
      </div>
      <div class="container" v-if="showForm">
        <div class="field">
          <label class="label">Name</label>
          <div class="control">
            <input
              class="input"
              type="text"
              placeholder="Text input"
              v-model="updatedAnimal.name"
            />
          </div>
        </div>

        <div class="field">
          <label class="label">Type</label>
          <div class="control">
            <div class="select">
              <select v-model="updatedAnimal.type">
                <option disabled value="">Please select one</option>
                <option value="Cat">Cat</option>
                <option value="Dog">Dog</option>
                <option value="Rabbit">Rabbit</option>
                <option value="Bird">Bird</option>
              </select>
            </div>
          </div>
        </div>

        <div class="field">
          <label class="label">Age</label>
          <div class="control">
            <div class="select">
              <select v-model="updatedAnimal.age">
                <option disabled value="">Please select one</option>
                <option value="Baby">Baby</option>
                <option value="Young">Young</option>
                <option value="Adult">Adult</option>
                <option value="Senior">Senior</option>
              </select>
            </div>
          </div>
        </div>

        <div class="field">
          <label class="label">Breed</label>
          <div class="control">
            <input
              class="input"
              type="text"
              placeholder="Text input"
              v-model="updatedAnimal.breed"
            />
          </div>
        </div>

        <div class="field">
          <label class="label">Gender</label>
          <div class="control">
            <input
              class="input"
              type="text"
              placeholder="Text input"
              v-model="updatedAnimal.gender"
            />
          </div>
        </div>

        <div class="field">
          <label class="label">Color</label>
          <div class="control">
            <input
              class="input"
              type="text"
              placeholder="Text input"
              v-model="updatedAnimal.color"
            />
          </div>
        </div>

        <div class="field">
          <label class="label">Tags</label>
          <div class="control">
            <input
              class="input"
              type="text"
              placeholder="Text input"
              v-model="updatedAnimal.tags"
            />
          </div>
        </div>

        <div class="field">
          <label class="label">Picture</label>
          <button @click.prevent="openUploadModal">Upload files</button>
          <!--<div class="control">
            <input
              class="input"
              type="text"
              placeholder="URL input"
              v-model="newImg.url"
            />
          </div>-->
        </div>
        <label class="checkbox">
          Adopted
          <input v-model="updatedAnimal.adopted" type="checkbox" />
        </label>

        <div class="field">
          <label class="label">Description</label>
          <div class="control">
            <textarea
              class="textarea"
              placeholder="Animal Description"
              v-model="updatedAnimal.description"
            ></textarea>
          </div>
        </div>

        <div class="field is-grouped">
          <div class="control">
            <button
              class="button is-link"
              @click.prevent="
                updateAnimal();
                toggleForm();
              "
            >
              Submit
            </button>
          </div>
          <div class="control">
            <button class="button is-link is-light" @click.prevent="toggleForm">
              Cancel
            </button>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import animalService from "../services/AnimalService";
import imgService from "../services/ImgService";

export default {
  name: "update-animal-form",
  props: ["animal"],
  data() {
    return {
      showForm: false,
      updatedAnimal: {
        name: this.animal.name,
        breed: this.animal.breed,
        color: this.animal.color,
        tags: this.animal.tags,
        type: this.animal.type,
        age: this.animal.age,
        gender: this.animal.gender,
        adopted: this.animal.adopted,
        description: this.animal.description,
      },
      newImg: {
        animalId: this.animal.animalId,
        url: "",
      },
    };
  },
  computed: {
    isLoggedIn () {
      return !!this.$store.state.token;
    }
  },
  methods: {
    updateAnimal() {
      animalService
        .updateAnimal(this.animal.animalId, this.updatedAnimal)
        .then((response) => {
          if (response.status === 200) {
            this.$store.commit("UPDATE_ANIMAL", this.updatedAnimal);
            if (this.newImg.url != "") {
              imgService.createImg(this.newImg).then((response) => {
                if (response.status === 201) {
                  this.$store.commit("ADD_IMG", this.newImg);
                }
              });
            }
          }
        });
    },
    openUploadModal() {
      window.cloudinary
        .openUploadWidget(
          { cloud_name: "dlh24zlzm", upload_preset: "ml_default" },
          (error, result) => {
            console.log("Cloudinary result:", result);
            if (!error && result && result.event === "success") {
              console.log("Done uploading..: ", result.info);
              if (result.info.url) {
                this.newImg.url = result.info.url;
                console.log("URL:", this.newImg.url);
              }
            }
          }
        )
        .open();
    },
    toggleForm() {
      this.showForm = !this.showForm;
      this.goToTop();
    },
    goToTop() {
      window.scrollTo(0, 0);
    },
  },
};
</script>

<style>
.container {
  display: flex;
  width: 400px;
  margin-top: 60px;
  margin-bottom: 20px;
  flex-direction: column;
  align-content: left;
}
.header {
  text-align: center;
}
.section {
     background-color: #235789;
}
#bulmaSucks { 
  color: #235789;
  font-weight: bold;
}
</style>
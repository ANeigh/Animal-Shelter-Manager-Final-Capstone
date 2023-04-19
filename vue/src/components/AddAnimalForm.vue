<template>
  <section>
    <div class="container">
      <div class="header">
        <button class="button is-link is-outlined" @click="toggleForm">
          Add New Pet
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
              v-model="newAnimal.name"
            />
          </div>
        </div>

        <div class="field">
          <label class="label">Type</label>
          <div class="control">
            <div class="select">
              <select v-model="newAnimal.type">
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
              <select v-model="newAnimal.age">
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
              v-model="newAnimal.breed"
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
              v-model="newAnimal.gender"
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
              v-model="newAnimal.color"
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
              v-model="newAnimal.tags"
            />
          </div>
        </div>

        <div class="field">
          <label class="label">Picture</label>
          <button @click="openUploadModal">Upload files</button>
          <!--<div class="control">
            <input
              class="input"
              type="text"
              placeholder="URL input"
              v-model="newImg.url"
            />
          </div>-->
        </div>

        <div class="field">
          <label class="label">Description</label>
          <div class="control">
            <textarea
              class="textarea"
              placeholder="Animal Description"
              v-model="newAnimal.description"
            ></textarea>
          </div>
        </div>

        <div class="field is-grouped">
          <div class="control">
            <button
              class="button is-link"
              @click.prevent="addNewAnimal"
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
  name: "add-animal-form",
  data() {
    return {
      url: '',
      showForm: false,
      newAnimal: {
        name: "",
        breed: "",
        color: "",
        tags: "",
        type: "",
        age: "",
        gender: "",
        description: "",
      },
      newImg: {
        url: '',
      },
    };
  },  
  methods: {
    openUploadModal() {
      window.cloudinary.openUploadWidget(
        { cloud_name: 'dlh24zlzm',
          upload_preset: 'ml_default'
        },
        (error, result) => {
          console.log('Cloudinary result:', result);
          if (!error && result && result.event === "success") {
            console.log('Done uploading..: ', result.info); 
            if (result.info.url) {
              this.newImg.yurl = result.info.url;
              console.log('URL:', this.newImg.url);
            } 
          }
        }).open();
    },
    toggleForm() {
      this.showForm = !this.showForm;
      this.clearForm();
      this.goToTop();
    },
    addNewAnimal() {
      animalService
        .createAnimal(this.newAnimal)
        .then((response) => {
          if (response.status === 201) {
            const animalId = response.data;
            const newImage = { animalId: animalId, url: this.newImg.url };
            imgService
              .createImg(newImage)
              .then((response) => {
                if (response.status === 201) {
                  const imgId = response.data;
                  const animal = {
                    animalId: animalId,
                    addedBy: "",
                    name: this.newAnimal.name,
                    type: this.newAnimal.type,
                    description: this.newAnimal.description,
                    age: this.newAnimal.age,
                    gender: this.newAnimal.gender,
                    adopted: false,
                    breed: this.newAnimal.breed,
                    color: this.newAnimal.color,
                    tags: this.newAnimal.tags,
                  };
                  const img = {
                    imgId: imgId,
                    url: newImage.url,
                    animalId: newImage.animalId,
                  };
                  this.$store.commit("ADD_ANIMAL", animal);
                  this.$store.commit("ADD_IMG", img);
                }
              })
              .catch((error) => {
                this.handleErrorResponse(error, "Error adding new image.");
              });
          }
        })
        .catch((error) => {
          this.handleErrorResponse(error, "Error adding new animal.");
        });
        this.clearForm();
        this.toggleForm();
    },
    clearForm() {
      this.newAnimal.name = "";
      this.newAnimal.breed = "";
      this.newAnimal.color = "";
      this.newAnimal.tags = "";
      this.newAnimal.type = "";
      this.newAnimal.age = "";
      this.newAnimal.description = "";
      this.newImg.url = "";
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
  margin-top: 200px;
  margin-bottom: 20px;
  flex-direction: column;
  align-content: left;
}
.header {
  text-align: center;
}
</style>
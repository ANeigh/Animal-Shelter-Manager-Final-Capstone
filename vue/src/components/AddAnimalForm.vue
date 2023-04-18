<template>
  <section>
    <div class="container">
      <div class="header">
        <button class="button is-link is-outlined" @click="toggleForm">
          Add Pet For Adoption
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
            <input class="input" type="text" placeholder="Text input" v-model="newAnimal.breed"/>
          </div>
        </div>

        <div class="field">
          <label class="label">Gender</label>
          <div class="control">
            <input class="input" type="text" placeholder="Text input" v-model="newAnimal.gender"/>
          </div>
        </div>

        <div class="field">
          <label class="label">Color</label>
          <div class="control">
            <input class="input" type="text" placeholder="Text input" v-model="newAnimal.color"/>
          </div>
        </div>

        <div class="field">
          <label class="label">Tags</label>
          <div class="control">
            <input class="input" type="text" placeholder="Text input" v-model="newAnimal.tags"/>
          </div>
        </div>

        <div class="field">
          <label class="label">Picture</label>
          <div class="control">
            <input class="input" type="text" placeholder="URL input" v-model="newImg.url"/>
          </div>
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
            <button class="button is-link" @click.prevent="toggleForm, addNewAnimal">Submit</button>
          </div>
          <div class="control">
            <button class="button is-link is-light" @click.prevent="toggleForm">Cancel</button>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import animalService from "../services/AnimalService";

export default {
  name: "add-animal-form",
  data() {
    return {
      showForm: false,
      newAnimal: {
        name: "",
        breed: "",
        color: "",
        tags: "",
        type: "",
        age: "",
        description: "",
      },
      newImg: {
          url: ""
      }
    };
  },
  methods: {
    toggleForm() {
      this.showForm = !this.showForm;
    },
    addNewAnimal() {
      animalService.createAnimal(this.newAnimal)
      .then(response => {
          if (response.status === 201) {
              //const animalId = response.data;

          }
      })
      .catch(error => {
          this.handleErrorResponse(error, "Error Adding New Animal");
      });
    }
  },
};
</script>

<style>
.container {
  width: 400px;
}
.header {
  text-align: center;
}
</style>
<template>
<section>
    <button class="button is-link is-outlined addButton">Add Pet For Adoption</button>
  <div class="container">
    <div class="field">
      <label class="label">Name</label>
      <div class="control">
        <input class="input" type="text" placeholder="Text input" v-model="newAnimal.name" />
      </div>
    </div>

    <div class="field">
      <label class="label">Type</label>
      <div class="control">
        <div class="select">
          <select v-model="newAnimal.type">
            <option disabled value="">Please select one</option>
            <option>Cat</option>
            <option>Dog</option>
            <option>Rabbit</option>
            <option>Bird</option>
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
            <option>Baby</option>
            <option>Young</option>
            <option>Adult</option>
            <option>Senior</option>
          </select>
        </div>
      </div>
    </div>

    <div class="field">
      <label class="label">Breed</label>
      <div class="control">
        <input class="input" type="text" placeholder="Text input" />
      </div>
    </div>

    <div class="field">
      <label class="label">Gender</label>
      <div class="control">
        <input class="input" type="text" placeholder="Text input" />
      </div>
    </div>

    <div class="field">
      <label class="label">Color</label>
      <div class="control">
        <input class="input" type="text" placeholder="Text input" />
      </div>
    </div>

    <div class="field">
      <label class="label">Tags</label>
      <div class="control">
        <input class="input" type="text" placeholder="Text input" />
      </div>
    </div>

    <div class="field">
      <label class="label">Picture</label>
      <div class="control">
        <input class="input" type="text" placeholder="URL input" />
      </div>
    </div>

    <div class="field">
      <label class="label">Description</label>
      <div class="control">
        <textarea class="textarea" placeholder="Animal Description"></textarea>
      </div>
    </div>

    <div class="field is-grouped">
      <div class="control">
        <button class="button is-link" @click.prevent>Submit</button>
      </div>
      <div class="control">
        <button class="button is-link is-light">Cancel</button>
      </div>
    </div>
  </div>
</section>
</template>

<script>
export default {
  name: "add-animal-form",
  data() {
    return {
      newAnimal: {
        name: "",
        breed: "",
        color: "",
        tags: "",
        url: "",
        type: "",
        age: "",
        description: "",
      },
    };
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

.addButton {
    align-content: center;
}

</style>
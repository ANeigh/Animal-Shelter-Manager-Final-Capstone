import axios from "axios";

export default {
    list() {
        return axios.get("/animals");
    },

    createAnimal(animal) {
        return axios.post("/animals", animal);
    
    },

    updateAnimal(animalID, animal) {
        return axios.put("/animals/" + animalID, animal);
    },

    deleteAnimal(animalID) {
        return axios.delete("/animals/" + animalID);
    }

}
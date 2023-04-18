import axios from "axios";

export default {
    getAllImgs() {
        return axios.get("/imgs");
    },

    getImgsByPet(animalId) {
        return axios.get("/imgs/" + animalId);
    },

    createImg(img) {
        return axios.post("/imgs", img);
    }

}
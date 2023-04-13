import axios from "axios";

export default {

    pic() {
    return axios.get("https://cataas.com/cat")
    }
}

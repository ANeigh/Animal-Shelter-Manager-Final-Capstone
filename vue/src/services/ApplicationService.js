import axios from "axios";

export default {
    /* All applications- Pending, Approved, and Declined */
    /* Displays all but they can be filtered to Pending */
    listAllApps() {
        return axios.get("/volunteer/apps");
    },


    createApp(newApp) {
        return axios.post("/appapproval", newApp);
    
    },

    updateApp(appID, app) {
        return axios.put("/volunteer/apps/" + appID, app);
    },

    deleteApp(appID) {
        return axios.delete("/volunteer/apps/" + appID);
    }

}
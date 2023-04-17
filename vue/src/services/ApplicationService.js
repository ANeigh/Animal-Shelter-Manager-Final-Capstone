import axios from "axios";

export default {
    /* All applications- Pending, Approved, and Declined */
    listAllApps() {
        return axios.get("/volunteer/apps");
    },

      /* Only pending applications*/
    listPendingApps() {
        return axios.get("/volunteer/apps/pending");
    },

    createNewApp(newApp) {
        return axios.post("/volunteer", newApp);
    
    },

    updateApp(appID, app) {
        return axios.put("/volunteer/apps/" + appID, app);
    },

    deleteApp(appID) {
        return axios.delete("/volunteer/apps/" + appID);
    }

}
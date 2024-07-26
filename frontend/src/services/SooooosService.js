import axios from 'axios';

//const SOOOOOS_REST_API_URL = "https://api.leon-wegener.de/api/v1/getSongChange";
const SOOOOOS_REST_API_URL = "http://192.168.178.90/api/v1/getSongChange";

class SooooosService {
    constructor(){}

    async getSongChange(){
        try {
            const response = await axios.get(SOOOOOS_REST_API_URL);
            return response.data; // return the data from the response
        } catch (error) {
            console.error("There was an error getting the song change!", error);
            throw error; // rethrow the error so it can be handled by the caller
        }
    }
}

export default new SooooosService();
import axios from 'axios';

const SOOOOOS_REST_API_URL_SONGCHANGE = "https://api.leon-wegener.de/api/v1/getSongChange";
//const SOOOOOS_REST_API_URL_SONGCHANGE = "http://192.168.178.90:8082/api/v1/getSongChange";
const SOOOOOS_REST_API_URL_PLAYLIST_STATS = "https://api.leon-wegener.de/api/v1/getPlaylistStatsForDuration";
//const SOOOOOS_REST_API_URL_PLAYLIST_STATS = "http://192.168.178.90:8082/api/v1/getPlaylistStatsForDuration";

class SooooosService {
    constructor(){}

    async getSongChange(){
        try {
            const response = await axios.get(SOOOOOS_REST_API_URL_SONGCHANGE);
            return response.data; // return the data from the response
        } catch (error) {
            console.error("There was an error getting the song change!", error);
            throw error; // rethrow the error so it can be handled by the caller
        }
    }

    async getPlaylistStats(){
        try {
            const response = await axios.get(SOOOOOS_REST_API_URL_PLAYLIST_STATS);
            return response.data; // return the data from the response
        } catch (error) {
            console.error("There was an error getting the song change!", error);
            throw error; // rethrow the error so it can be handled by the caller
        }
    }
}

export default new SooooosService();
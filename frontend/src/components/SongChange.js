import React, { useEffect, useState } from 'react';
import SooooosService from '../services/SooooosService';


const SongChange = () => {
    const [songChanges, setSongChanges] = useState([]);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const data = await SooooosService.getSongChange();
                setSongChanges(data);
            } catch (error) {
                setError(error.message);
            }
        };

        fetchData();
    }, []);

    if (error) {
        return <div className="alert alert-danger">Error: {error}</div>;
    }

    if (!songChanges.length) {
        return <div>Loading...</div>;
    }

    return (
        <div className="container">
            <h1 className="my-4">Song Changes</h1>
            <ul className="list-group">
                {songChanges.map((songChange, index) => (
                    <li key={index} className="list-group-item">
                        <h2 className="h5">{songChange.songName}</h2>
                        <p>Added by: {songChange.addedBy}</p>
                        <p>Change Occurred At: {new Date(songChange.changeOccurredAt).toLocaleDateString('de-DE')}</p>
                        <p>Duration: {Math.floor(songChange.durationMs/1000/60)}:{Math.floor(songChange.durationMs/1000%60)}min </p>
                        <p>
                            Spotify URL: 
                            {songChange.spotifyExternalUrl && songChange.spotifyExternalUrl.match(/spotify=(https:\/\/open.spotify.com\/track\/[^\}]*)/) ? (
                                <a href={songChange.spotifyExternalUrl.match(/spotify=(https:\/\/open.spotify.com\/track\/[^\}]*)/)[1]} target="_blank" rel="noopener noreferrer">Listen</a>
                            ) : (
                                'N/A'
                            )}
                        </p>
                        <p>Spotify Song ID: {songChange.spotifySongId}</p>
                        <p>Status: <span className={songChange.deleted ? 'badge bg-danger' : 'badge bg-success'}>{songChange.deleted ? 'Deleted' : 'Added'}</span></p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default SongChange;
import React, { useState, useEffect } from 'react';
import SooooosService from '../services/SooooosService';

const PlaylistStats = () => {
    const [stats, setStats] = useState(null);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const data = await SooooosService.getPlaylistStats();
                setStats(data);
            } catch (error) {
                setError(error.message);
            }
        };

        fetchData();
    }, []);

    const formatDuration = (ms) => {
        const totalSeconds = Math.floor(ms / 1000);
        const hours = Math.floor(totalSeconds / 3600);
        const minutes = Math.floor((totalSeconds % 3600) / 60);
        const seconds = totalSeconds % 60;

        return `${hours}h ${minutes}m ${seconds}s`;
    };

    if (error) {
        return <div className="alert alert-danger">Error: {error}</div>;
    }

    if (!stats) {
        return <div>Loading...</div>;
    }

    const sortedKeys = Object.keys(stats).sort((a, b) => (a === "Total" ? -1 : b === "Total" ? 1 : 0));

    return (
        <div className="container">
            <h1 className="my-4">Playlist Stats - Duration</h1>
            <ul className="list-group">
                {sortedKeys.map((key) => (
                    <li key={key} className={`list-group-item ${key === "Total" ? "total-highlight" : ""}`}>
                        <h2 className="h5">{key}</h2>
                        <p>{formatDuration(stats[key])}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default PlaylistStats;
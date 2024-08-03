import React, { useState, useEffect } from 'react';
import SooooosService from '../services/SooooosService';

const PlaylistStats = () => {
    const [stats, setStats] = useState(null);
    const [error, setError] = useState(null);
    const [showMilliseconds, setShowMilliseconds] = useState(false);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const data = await SooooosService.getPlaylistStats();
                setStats(data);
            } catch (err) {
                setError(err.message || "An unexpected error occurred");
            }
        };

        fetchData();
    }, []);

    const formatDuration = (ms) => {
        const totalSeconds = Math.floor(ms / 1000);
        const hours = Math.floor(totalSeconds / 3600);
        const minutes = Math.floor((totalSeconds % 3600) / 60);
        const seconds = totalSeconds % 60;
        const milliseconds = ms % 1000;

        if (showMilliseconds) {
            return `${hours}h ${minutes}m ${seconds}s ${milliseconds}ms`;
        } else {
            return `${hours}h ${minutes}m ${seconds}s`;
        }
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
                {sortedKeys.map((key) => {
                    const duration = stats[key];
                    const isShortDuration = duration < 14400000; // 4 hours in ms
                    const isExactDuration = duration === 14400000; // exactly 4 hours
                    const colorClass = key !== "Total" ? (isExactDuration ? 'rainbow-text' : isShortDuration ? 'text-success' : 'text-danger') : '';
                    const emoji = key !== "Total" ? (isExactDuration ? '🌚' : isShortDuration ? '😊' : '😢') : '';

                    return (
                        <li key={key} className={`list-group-item ${key === "Total" ? "total-highlight" : ""}`}>
                            <h2 className={`h5 ${colorClass}`}>
                                {key} {emoji}
                            </h2>
                            <p className={colorClass}>{formatDuration(duration)}</p>
                        </li>
                    );
                })}
            </ul>
            <button 
                className="btn btn-primary my-3" 
                onClick={() => setShowMilliseconds(!showMilliseconds)}
            >
                {showMilliseconds ? 'Show Duration' : 'Show Detailed Duration'}
            </button>
        </div>
    );
};

export default PlaylistStats;
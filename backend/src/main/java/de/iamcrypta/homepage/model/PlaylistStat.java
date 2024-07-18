package de.iamcrypta.homepage.model;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.Date;
import java.util.Map;

@Entity
@Table(name = "playlist_stats")
public class PlaylistStat {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "durations", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Integer> durations;

    public PlaylistStat() {
    }

    public PlaylistStat(Date date, Map<String, Integer> durations) {
        this.date = date;
        this.durations = durations;
    }

    public Map<String, Integer> getDurations() {
        return durations;
    }

    public void setDurations(Map<String, Integer> durations) {
        this.durations = durations;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

package com.genspark.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="wikimedia_recentchange")
public class WikimediaRecentChange {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(name="wiki_event_data")
    @Lob
    String wikiEventData;
}

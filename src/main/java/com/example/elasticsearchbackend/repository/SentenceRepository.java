package com.example.elasticsearchbackend.repository;

import com.example.elasticsearchbackend.model.Sentence;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SentenceRepository extends ElasticsearchRepository<Sentence, String> {
}

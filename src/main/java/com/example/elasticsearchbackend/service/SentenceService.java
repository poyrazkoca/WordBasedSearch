package com.example.elasticsearchbackend.service;

import com.example.elasticsearchbackend.model.Sentence;
import com.example.elasticsearchbackend.repository.SentenceRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.lucene.search.join.ScoreMode;

@Service
public class SentenceService {

    private final SentenceRepository sentenceRepository;
    private final ElasticsearchRestTemplate elasticsearchTemplate;

    public SentenceService(SentenceRepository sentenceRepository, ElasticsearchRestTemplate elasticsearchTemplate) {
        this.sentenceRepository = sentenceRepository;
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    public List<Sentence> findByWord(String word) {
        var searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.termQuery("word", word))
                .build();

        SearchHits<Sentence> searchHits = elasticsearchTemplate.search(searchQuery, Sentence.class);
        return searchHits.getSearchHits().stream().map(hit -> hit.getContent()).collect(Collectors.toList());
    }

    public List<Sentence> findBySentence(String sentence) {
        var searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("word", sentence))
                .build();

        SearchHits<Sentence> searchHits = elasticsearchTemplate.search(searchQuery, Sentence.class);
        return searchHits.getSearchHits().stream().map(hit -> hit.getContent()).collect(Collectors.toList());
    }

    public List<Sentence> findByWordWithinTimestamp(String word, double start, double end) {
        var boolQuery = QueryBuilders.boolQuery()
                .must(QueryBuilders.termQuery("word", word))
                .filter(QueryBuilders.nestedQuery("timestamps",
                        QueryBuilders.boolQuery()
                                .must(QueryBuilders.rangeQuery("timestamps.start").gte(start).lte(end))
                                .must(QueryBuilders.rangeQuery("timestamps.end").gte(start).lte(end)),
                        ScoreMode.Avg));

        var searchQuery = new NativeSearchQueryBuilder()
                .withQuery(boolQuery)
                .build();

        SearchHits<Sentence> searchHits = elasticsearchTemplate.search(searchQuery, Sentence.class);
        return searchHits.getSearchHits().stream().map(hit -> hit.getContent()).collect(Collectors.toList());
    }

    // CRUD işlemleri
    public Sentence save(Sentence sentence) {
        return sentenceRepository.save(sentence);
    }

    public void deleteById(String id) {
        sentenceRepository.deleteById(id);
    }

    public Iterable<Sentence> findAll() {
        return sentenceRepository.findAll();
    }

    public Sentence findById(String id) {
        return sentenceRepository.findById(id).orElse(null);
    }
}

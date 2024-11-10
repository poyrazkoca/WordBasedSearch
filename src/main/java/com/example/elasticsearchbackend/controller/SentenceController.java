package com.example.elasticsearchbackend.controller;

import com.example.elasticsearchbackend.model.Sentence;
import com.example.elasticsearchbackend.service.SentenceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SentenceController {

    private final SentenceService sentenceService;

    public SentenceController(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }

    @GetMapping("/search/word")
    public List<Sentence> searchByWord(@RequestParam String word) {
        return sentenceService.findByWord(word);
    }

    @GetMapping("/search/sentence")
    public List<Sentence> searchBySentence(@RequestParam String sentence) {
        return sentenceService.findBySentence(sentence);
    }
}

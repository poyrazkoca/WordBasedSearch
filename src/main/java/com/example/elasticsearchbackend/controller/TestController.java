package com.example.elasticsearchbackend.controller;

import com.example.elasticsearchbackend.model.Sentence;
import com.example.elasticsearchbackend.service.SentenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestController {

   private final SentenceService sentenceService;

    public TestController(SentenceService sentenceService) {
        this.sentenceService = sentenceService;
    }

    @GetMapping("/test")
  public ResponseEntity<String> testElasticsearchConnection() {
      try {
         List<Sentence> sentences = sentenceService.findByWord("test");
         return ResponseEntity.ok("Elasticsearch bağlantısı başarılı " + sentences.size() + " sonuç bulundu.");
     } catch (Exception e) {
           return ResponseEntity.status(500).body("Elasticsearch bağlantısında hata: " + e.getMessage());
      }
  }
}

package com.example.elasticsearchbackend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "my_index")
public class Sentence {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String word;

    @Field(type = FieldType.Text)
    private String start;

    @Field(type = FieldType.Text)
    private String end;

    // Getter ve Setter'lar
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    // Varsayılan yapılandırıcı (Constructor)
    public Sentence() {
    }

    // Parametreli yapılandırıcı (Constructor)
    public Sentence(String id, String word, String start, String end) {
        this.id = id;
        this.word = word;
        this.start = start;
        this.end = end;
    }
}

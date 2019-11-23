package br.com.thiagoaos.testitau.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "tweets")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tweet {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String text;
    private String lang;
    private String searchTag;
    private Date date;
}









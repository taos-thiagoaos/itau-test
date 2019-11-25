package br.com.thiagoaos.testitau.dto;

import lombok.Setter;

@Setter
public class TotalTweetBySearchTagLangDTOImpl implements  TotalTweetBySearchTagLangDTO {

    private String tag;
    private String lang;
    private Long total;

    public TotalTweetBySearchTagLangDTOImpl(String tag, String lang, Long total) {
        this.tag = tag;
        this.lang = lang;
        this.total = total;
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public String getLang() {
        return lang;
    }

    @Override
    public Long getTotal() {
        return total;
    }
}

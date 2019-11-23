package br.com.thiagoaos.testitau.dtos;

import java.util.Date;

public interface TotalTweetByHourDTO {
    public Date getDate();
    public Integer getHour();
    public Long getTotal();
}

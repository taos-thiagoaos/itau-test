package br.com.thiagoaos.testitau;

import br.com.thiagoaos.testitau.dto.TotalTweetByHourDTO;

import java.util.Date;

public class TotalTweetByHourDTOImpl implements TotalTweetByHourDTO {
    private Date date;
    private Integer hour;
    private Long total;

    public TotalTweetByHourDTOImpl(Date date, Integer hour, Long total) {
        this.date = date;
        this.hour = hour;
        this.total = total;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public Integer getHour() {
        return hour;
    }

    @Override
    public Long getTotal() {
        return total;
    }
}

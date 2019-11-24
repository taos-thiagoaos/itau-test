package br.com.thiagoaos.testitau.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(description = "Total Tweets By Date and Hour")
public interface TotalTweetByHourDTO {
    @ApiModelProperty(notes = "Posted Date")
    public Date getDate();

    @ApiModelProperty(notes = "Posted Hour")
    public Integer getHour();

    @ApiModelProperty(notes = "Total Tweets")
    public Long getTotal();
}

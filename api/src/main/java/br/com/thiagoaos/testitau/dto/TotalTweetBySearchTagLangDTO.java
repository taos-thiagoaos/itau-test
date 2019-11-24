package br.com.thiagoaos.testitau.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Total Tweets Search Tag and Lang")
public interface TotalTweetBySearchTagLangDTO {

    @ApiModelProperty(notes = "Search Tag")
    public String getTag();

    @ApiModelProperty(notes = "Tweet Lang")
    public String getLang();

    @ApiModelProperty(notes = "Total Tweets")
    public Long getTotal();
}

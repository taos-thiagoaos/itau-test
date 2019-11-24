package br.com.thiagoaos.testitau.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ApiModel(description = "Tweet User")
public class User {
    @Id
    private Long id;
    private String name;

    @ApiModelProperty(notes = "Total Followers")
    private Long followers;
}

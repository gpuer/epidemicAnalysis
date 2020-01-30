package com.gpu.epidemic.common;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class BaseEntity implements Serializable{
    private Long id;
    private LocalDateTime createdAt;
    private Date updatedAt;
    private Integer isDel;
}

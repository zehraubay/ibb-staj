package com.example.StajEnvanterProjesi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class GenericObjectEntity implements Serializable {

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone = "Europe/Istanbul")
    @DateTimeFormat(pattern = "dd/MM/yy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date")
    private LocalDateTime createDate;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss",timezone = "Europe/Istanbul")
    @DateTimeFormat(pattern = "dd/MM/yy HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @JsonIgnore
    @Column(name = "status")
    private Boolean status = true;

    @PrePersist
    protected void onCreate() {
        createDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updateDate = LocalDateTime.now();
    }

}

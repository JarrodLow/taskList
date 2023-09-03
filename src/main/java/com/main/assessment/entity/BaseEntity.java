package com.main.assessment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity implements Serializable {

    private static final long serialVersionID = 1778847390000617814L;

    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue
    private UUID id;

    @Version
    @Column(
            name = "version"
    )
    private int version;

    @Column(
            name = "crt_by",
            updatable = false
    )
    private String createdBy;

    @Column(
            name = "crt_time",
            updatable = false
    )
    private OffsetDateTime createdTime;

    @Column(
            name = "upd_by",
            insertable = false
    )
    private String updatedBy;

    @Column(
            name = "upd_time",
            insertable = false
    )
    private OffsetDateTime updatedTime;
}

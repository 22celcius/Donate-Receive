package com.gl.donate_receive.donate_receive.model;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
@Data
public class Report {
    @EmbeddedId
    private ReportId reportId;

    private String comment;
    private String mediaType;




}

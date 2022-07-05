package com.gl.donate_receive.donate_receive.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.UUID;

@Embeddable
@Data
public class ReportId implements Serializable {
    private static final long serialVersionUID = -5582052851164019066L;
    private UUID itemId;
    private UUID receiverId;

}

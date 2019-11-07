package org.normal.framework.domain;

import javax.persistence.*;

@Table(name = "authority")
@Entity
public class Authority extends SuperEntity{
    @Id
    @GeneratedValue
    @Column(name = "PK_ID")
    public Long id;
    @Column(name = "MEMBER_RESOURCE_ROUTER")
    public String memberResourceRouter;
}

package com.prographer.pagination.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends AbstractPersistable<Long> {

    @NotNull
    private String name;
    @Type(type = "text")
    private String description;
    private String contact;
    private String email;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    private Date updated;

    @PrePersist
    protected void onCreate() {
        created = new Date();
        updated = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void copy(Advertiser advertiser) {
        this.name = advertiser.getName();
        this.contact = advertiser.getContact();
        this.email = advertiser.getEmail();
        this.description = advertiser.getDescription();
    }

}

package ru.antonov.subscriber.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subscription")
@Getter
@Setter
public class Subscription {
    @Id
    private Integer id;
    @NotNull
    private Integer msisdn;
    @NotNull
    private Long timestamp;
}

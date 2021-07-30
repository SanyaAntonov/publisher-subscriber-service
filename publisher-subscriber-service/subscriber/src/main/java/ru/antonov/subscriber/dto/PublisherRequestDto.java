package ru.antonov.subscriber.dto;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;
import ru.antonov.subscriber.enums.Action;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PublisherRequestDto {
    @NotNull
    @Range(min = 1)
    private Integer id;
    @NotNull
    @Range(min = 1)
    private Integer msisdn;
    @NotNull
    private Action action;
    @NotNull
    @Range(min = 1)
    private Long timestamp;
}

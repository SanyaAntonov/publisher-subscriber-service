package ru.antonov.publisher.dto;

import lombok.Getter;
import lombok.Setter;
import ru.antonov.publisher.enums.Action;

@Getter
@Setter
public class PublisherRequestDto {
    private Integer id;
    private Integer msisdn;
    private Action action;
    private Long timestamp;
}

package ru.antonov.subscriber.mapper;

import org.mapstruct.Mapper;
import ru.antonov.subscriber.dto.PublisherRequestDto;
import ru.antonov.subscriber.model.Purchase;
import ru.antonov.subscriber.model.Subscription;

@Mapper(componentModel = "spring")
public interface EntityMapper {

    Purchase toPurchase(PublisherRequestDto requestDto);

    Subscription toSubscription(PublisherRequestDto requestDto);
}

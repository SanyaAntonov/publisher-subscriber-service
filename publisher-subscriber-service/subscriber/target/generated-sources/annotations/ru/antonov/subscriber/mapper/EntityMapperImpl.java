package ru.antonov.subscriber.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.antonov.subscriber.dto.PublisherRequestDto;
import ru.antonov.subscriber.model.Purchase;
import ru.antonov.subscriber.model.Subscription;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-10-23T20:58:09+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class EntityMapperImpl implements EntityMapper {

    @Override
    public Purchase toPurchase(PublisherRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Purchase purchase = new Purchase();

        purchase.setId( requestDto.getId() );
        purchase.setMsisdn( requestDto.getMsisdn() );
        purchase.setTimestamp( requestDto.getTimestamp() );

        return purchase;
    }

    @Override
    public Subscription toSubscription(PublisherRequestDto requestDto) {
        if ( requestDto == null ) {
            return null;
        }

        Subscription subscription = new Subscription();

        subscription.setId( requestDto.getId() );
        subscription.setMsisdn( requestDto.getMsisdn() );
        subscription.setTimestamp( requestDto.getTimestamp() );

        return subscription;
    }
}

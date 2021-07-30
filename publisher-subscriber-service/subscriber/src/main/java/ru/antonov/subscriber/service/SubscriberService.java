package ru.antonov.subscriber.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.antonov.subscriber.dto.PublisherRequestDto;
import ru.antonov.subscriber.mapper.EntityMapper;
import ru.antonov.subscriber.repository.PurchaseRepository;
import ru.antonov.subscriber.repository.SubscriptionRepository;

@Service
@Slf4j
public class SubscriberService {

    private final PurchaseRepository purchaseRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final EntityMapper entityMapper;

    public SubscriberService(PurchaseRepository purchaseRepository, SubscriptionRepository subscriptionRepository, EntityMapper entityMapper) {
        this.purchaseRepository = purchaseRepository;
        this.subscriptionRepository = subscriptionRepository;
        this.entityMapper = entityMapper;
    }

    public void savePostRequest(PublisherRequestDto requestDto) {
        switch (requestDto.getAction()) {
            case PURCHASE : {
                log.info("Saving to purchase repository");
                purchaseRepository.save(entityMapper.toPurchase(requestDto));
                break;
            }
            case SUBSCRIPTION : {
                log.info("Saving to subscription repository");
                subscriptionRepository.save(entityMapper.toSubscription(requestDto));
                break;
            }
            default: {
                log.warn("Action type invalid");
                throw new RuntimeException("Action type invalid");
            }
        }
    }
}

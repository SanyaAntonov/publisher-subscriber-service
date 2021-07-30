package ru.antonov.subscriber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonov.subscriber.model.Subscription;

public interface SubscriptionRepository extends JpaRepository<Subscription, Integer> {
}

package ru.antonov.subscriber.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.antonov.subscriber.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {
}

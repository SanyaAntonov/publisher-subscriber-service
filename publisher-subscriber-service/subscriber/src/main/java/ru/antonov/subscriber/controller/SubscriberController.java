package ru.antonov.subscriber.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.antonov.subscriber.dto.PublisherRequestDto;
import ru.antonov.subscriber.service.SubscriberService;

import javax.validation.Valid;

@RestController
@Slf4j
public class SubscriberController {
    private final SubscriberService subscriberService;

    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @PostMapping
    public void receiveRequest(@RequestBody @Valid PublisherRequestDto requestDto) {
        log.info("ReceiveRequest");
        subscriberService.savePostRequest(requestDto);
    }

}

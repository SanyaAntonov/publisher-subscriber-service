package ru.antonov.publisher.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.antonov.publisher.service.PublisherService;

@RestController
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }


    @GetMapping("/start")
    public String startService() {
        publisherService.runService();
        return "Service started";
    }
}

package ru.antonov.publisher.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.antonov.publisher.config.ApplicationSubscriber;
import ru.antonov.publisher.dto.PublisherRequestDto;
import ru.antonov.publisher.enums.Action;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
@AllArgsConstructor
public class PublisherService {

    private final ObjectMapper objectMapper;
    private final ApplicationSubscriber applicationSubscriber;

    private final AtomicInteger atomicInteger = new AtomicInteger(0);
    private final HttpClient httpClient = HttpClient.newHttpClient();
    private final Runnable runnable = getRunnable();
    private final Thread thread1 = new Thread(runnable);
    private final Thread thread2 = new Thread(runnable);
    private final Thread thread3 = new Thread(runnable);
    private final Thread thread4 = new Thread(runnable);
    private final Thread thread5 = new Thread(runnable);

    public void runService() {
        startIfNotAlive(thread1);
        startIfNotAlive(thread2);
        startIfNotAlive(thread3);
        startIfNotAlive(thread4);
        startIfNotAlive(thread5);
    }

    @SneakyThrows
    private void startIfNotAlive(Thread thread) {
        if (!thread.isAlive()) {
            thread.start();
            log.info(thread.getName() + " is started!");
        }
    }

    private Runnable getRunnable() {
        return () -> {
            while (true) {
                Random random = new Random();
                Action[] values = Action.values();

                PublisherRequestDto requestDto = new PublisherRequestDto();
                requestDto.setId(atomicInteger.incrementAndGet());
                requestDto.setMsisdn(random.nextInt(Integer.MAX_VALUE));
                requestDto.setAction(values[random.nextInt(2)]);
                requestDto.setTimestamp(System.currentTimeMillis() / 1000L);
                try {
                    HttpRequest httpRequest = HttpRequest
                            .newBuilder()
                            .POST(HttpRequest.BodyPublishers.ofByteArray(objectMapper.writeValueAsBytes(requestDto)))
                            .uri(URI.create(applicationSubscriber.getPostApi()))
                            .header("Content-Type", "application/json")
                            .build();
                    HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
                    Thread.sleep(15_000);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

}

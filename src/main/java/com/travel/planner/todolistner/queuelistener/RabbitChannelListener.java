package com.travel.planner.todolistner.queuelistener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface RabbitChannelListener {
    final String GREETING = "greetingChannel";

    @Input(GREETING)
    SubscribableChannel greeting();
}

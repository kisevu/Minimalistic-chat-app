package com.chat.app.app.config;/*
*
@author ameda
@project app
*
*/

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    /*
    *
    @author ameda
    @project app
    *
    */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat") //server
                .setAllowedOrigins("http://localhost:8080") //client but given we'll use thymeleaf then 8080
                .withSockJS();  //for compatibility for clients that don't support websockets
    }


    /*
     *
     @author ameda
     @project app
     *
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //set simple message broker which is responsible to route messages
        //the message broker is an in-memory which is built in to the spring and is not for production
        //purposes hence is not responsible to persisting the messages
        registry.enableSimpleBroker("/topic");
        //when to expect a message i.e /app/sendMessage (so given the message is received with prefix /app then it should be
        // scheduled for processing...)
        registry.setApplicationDestinationPrefixes("/app");
    }
}

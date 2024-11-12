package com.chat.app.app.controller;
/*
*
@author ameda
@project app
*
*/

import com.chat.app.app.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {


    @MessageMapping("/sendMessage") // /app/sendMessage
    @SendTo("/topic/messages") //return of sendMessage()
    public ChatMessage sendMessage(ChatMessage message){
        return message;
    }

    @GetMapping("chat")
    public String chat(){
        return "chat";
    }

}

package com.chat.app.app.model;
/*
*
@author ameda
@project app
*
*/


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChatMessage {
    private long id;
    private String sender;
    private String content;

}

package com.example.springboot.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
@Service("messageService")
public class MessageService {
    private static AtomicLong idCounter = new AtomicLong();
    private static ConcurrentMap<Long, Message> messages = new ConcurrentHashMap<>();

    static {
        Message msg = new Message(idCounter.incrementAndGet(), "title1", "content1");
        messages.put(msg.getId(), msg);
    }

    public List<Message> findAll() {
        return new ArrayList<>(messages.values());
    }

    public Message save(Message message) {
        Long id = message.getId();
        if (id==null) {
            id = idCounter.incrementAndGet();
            message.setId(id);
        }
        messages.put(id, message);
        return message;
    }

    public Message update(Message message) {
        if (messages.containsKey(message.getId())) {
            messages.put(message.getId(), message);
        }
        return message;
    }

    public Message findById(Long id) {
        return messages.get(id);
    }

    public void deleteById(Long id) {
        messages.remove(id);
    }
}

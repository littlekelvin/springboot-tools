package com.example.springboot.service;

/**
 * @author Kelvin Mai
 * @date 4/15/2019
 */
public class Message {
    private Long id;
    private String title;
    private String content;

    public Message(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

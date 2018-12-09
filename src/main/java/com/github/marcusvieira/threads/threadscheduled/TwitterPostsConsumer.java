package com.github.marcusvieira.threads.threadscheduled;

import com.github.marcusvieira.dto.TwitterPost;

import java.util.List;

public class TwitterPostsConsumer {

    public void consume(List<TwitterPost> posts) {
        posts.forEach(System.out::println);
    }
}

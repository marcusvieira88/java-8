package com.github.marcusvieira.threads.threadscheduled;

import com.github.marcusvieira.dto.TwitterPost;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

public class PostTask implements Runnable {

    private final TwitterPostsConsumer postsConsumer;
    private final ConcurrentLinkedQueue<TwitterPost> posts;
    private final int maxPostsPerSecond;

    public PostTask(TwitterPostsConsumer postsConsumer, ConcurrentLinkedQueue<TwitterPost> posts, int maxPostsPerSecond) {
        this.postsConsumer = postsConsumer;
        this.posts = posts;
        this.maxPostsPerSecond = maxPostsPerSecond;
    }

    @Override
    public void run() {
        Map<String,TwitterPost> postsProcessed = new HashMap<>();
        int amountOfPosts = this.posts.size() > maxPostsPerSecond ? maxPostsPerSecond : this.posts.size();
        for(int index = 0 ; index < amountOfPosts; index++) {
            TwitterPost item = posts.poll();
            postsProcessed.put(item.getUserId(),item);
        }
        postsConsumer.consume(postsProcessed.values().stream().collect(Collectors.toList()));
    }
}

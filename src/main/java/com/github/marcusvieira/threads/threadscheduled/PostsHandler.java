package com.github.marcusvieira.threads.threadscheduled;

import com.github.marcusvieira.dto.TwitterPost;

import java.util.concurrent.*;

public class PostsHandler {

    private static final int MAX_POSTS_PROCESS_PER_SECOND = 300;
    private ConcurrentLinkedQueue posts;
    private ScheduledExecutorService threadPool;

    public PostsHandler(TwitterPostsConsumer postsConsumer) {
        this.posts = new ConcurrentLinkedQueue<>();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors(), new ThreadsFactory());
        scheduledExecutorService.scheduleWithFixedDelay(new PostTask(postsConsumer, this.posts, MAX_POSTS_PROCESS_PER_SECOND),1 ,1, TimeUnit.SECONDS);
    }

    /**
     * The consumer can only process 300 items per second
     */
    public void process(TwitterPost post) {
        this.posts.add(post);
    }

}

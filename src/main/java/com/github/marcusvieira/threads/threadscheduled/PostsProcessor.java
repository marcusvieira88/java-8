package com.github.marcusvieira.threads.threadscheduled;

import java.time.Instant;

/**
 * This is the code without modification, it is a sequencial algorithm
 */
public class PostsProcessor {

    public static void main(String[] args) {
        Instant startDate = Instant.now();
        System.out.println("Start Date: " + startDate);
        //create a twitter consumer
        TwitterPostsConsumer twitterConsumer = new TwitterPostsConsumer();
        //crete a handler for process the twitter posts
        PostsHandler postsHandler = new PostsHandler(twitterConsumer);
        //create a twitter producer for producer the posts
        TwitterPostsProducer twitterPostsProducer = new TwitterPostsProducer(postsHandler);
        //execute the sequencial code
        twitterPostsProducer.run();
        Instant endDate = Instant.now();
        System.out.println("Execution Time: " + (endDate.toEpochMilli() - startDate.toEpochMilli()));

    }
}

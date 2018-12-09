package com.github.marcusvieira.threads.threadscheduled;

import com.github.marcusvieira.dto.TwitterPost;

import java.time.LocalDate;

public class TwitterPostsProducer extends Thread {

    private PostsHandler postsHandler;

    public TwitterPostsProducer(PostsHandler postsHandler) {
        this.postsHandler = postsHandler;
    }

    @Override
    public void run() {
        generatePosts(900);
    }

    public void generatePosts(int amountOfPosts) {
        for (int index = 0; index < (amountOfPosts / 10); index++) {
            postsHandler.process(new TwitterPost("marcus88", "soccer", LocalDate.now()));
            postsHandler.process(new TwitterPost("paulo86", "party", LocalDate.now()));
            postsHandler.process(new TwitterPost("mary90", "film", LocalDate.now()));
            postsHandler.process(new TwitterPost("sophia89", "soccer", LocalDate.now()));
            postsHandler.process(new TwitterPost("ricardo87", "party", LocalDate.now()));
            postsHandler.process(new TwitterPost("paulo86", "film", LocalDate.now()));
            postsHandler.process(new TwitterPost("joao75", "soccer", LocalDate.now()));
            postsHandler.process(new TwitterPost("gustavo87", "party", LocalDate.now()));
            postsHandler.process(new TwitterPost("marcus88", "film", LocalDate.now()));
            postsHandler.process(new TwitterPost("gustavo87", "party", LocalDate.now()));
        }
    }
}

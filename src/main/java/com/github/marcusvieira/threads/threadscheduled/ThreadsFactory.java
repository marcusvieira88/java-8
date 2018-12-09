package com.github.marcusvieira.threads.threadscheduled;

import java.util.concurrent.ThreadFactory;

/**
 * This class is responsible for create threads with a customized name
 *
 */
 public class ThreadsFactory implements ThreadFactory {

    private static int threadNumber = 1;

    @Override
    public Thread newThread(Runnable task) {
        Thread thread = new Thread(task, "Thread Tasks Server " + threadNumber);
        threadNumber++;
        return thread;
    }
}

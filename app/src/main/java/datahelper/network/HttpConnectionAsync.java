package datahelper.network;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by j-xuanyu on 2015/12/9.
 */
public class HttpConnectionAsync {

    static final int THREAD_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 2;
    static final ExecutorService THREAD_POOL = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public void sendRequest(RequestTask task, ResponseCallback callback) {
        if (task == null) return;
        task.callback = callback;
        THREAD_POOL.submit(task);
    }
}

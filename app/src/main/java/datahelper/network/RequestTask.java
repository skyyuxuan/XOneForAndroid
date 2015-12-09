package datahelper.network;

/**
 * Created by j-xuanyu on 2015/12/9.
 */
public abstract class RequestTask implements Runnable {

    public ResponseCallback callback;
    @Override
    public final void run() {

        execute();
    }
    protected abstract void execute();

}

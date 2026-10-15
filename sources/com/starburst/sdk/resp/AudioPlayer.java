package com.starburst.sdk.resp;

import android.content.Context;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.starburst.sdk.utils.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class AudioPlayer {
    private Handler audioHandler;
    private AudioLooperThread audioLooperThread;
    private AudioPlayStateChangeListener audioPlayStateChangeListener;
    private AudioTrack audioTrack;
    private int bufferSize;
    private Context context;
    private final int MSG_PLAY = 101;
    private final int MSG_PLAY_OVER = 102;
    private String TAG = "AudioPlayer";
    private List<byte[]> playList = new ArrayList();
    private boolean isPlaying = false;
    private Queue<byte[]> queueMsg = new ConcurrentLinkedQueue();
    private final Object lock = new Object();

    public class AudioLooperThread extends Thread {
        private AudioLooperThread() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            Looper.prepare();
            AudioPlayer.this.audioHandler = new Handler() { // from class: com.starburst.sdk.resp.AudioPlayer.AudioLooperThread.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    super.handleMessage(message);
                    int i9 = message.what;
                    if (i9 != 101) {
                        if (i9 != 102) {
                            return;
                        }
                        AudioPlayer.this.isPlaying = false;
                        j.k(AudioPlayer.this.TAG, "MSG_PLAY_OVER");
                        if (AudioPlayer.this.audioPlayStateChangeListener != null) {
                            AudioPlayer.this.audioPlayStateChangeListener.onStateChange(AudioPlayer.this.isPlaying);
                            return;
                        }
                        return;
                    }
                    synchronized (AudioPlayer.this.lock) {
                        try {
                            AudioPlayer.this.audioHandler.removeMessages(102);
                            j.k(AudioPlayer.this.TAG, "play---111---");
                            byte[] bArr = (byte[]) AudioPlayer.this.queueMsg.poll();
                            if (bArr == null) {
                                j.k(AudioPlayer.this.TAG, "play data == null");
                                AudioPlayer.this.audioHandler.sendEmptyMessageDelayed(102, 1000L);
                                return;
                            }
                            if (AudioPlayer.this.audioTrack != null && AudioPlayer.this.isPlaying) {
                                AudioPlayer.this.audioTrack.play();
                                int length = bArr.length;
                                while (length > 0 && AudioPlayer.this.audioTrack != null && AudioPlayer.this.isPlaying) {
                                    try {
                                        length -= AudioPlayer.this.audioTrack.write(bArr, 0, length);
                                    } catch (Exception e9) {
                                        j.j(AudioPlayer.this.TAG, "play failed", e9);
                                    }
                                }
                                j.k(AudioPlayer.this.TAG, "play---end---");
                            }
                            AudioPlayer.this.audioHandler.sendEmptyMessage(101);
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            };
            Looper.loop();
        }
    }

    public interface AudioPlayStateChangeListener {
        void onStateChange(boolean z8);
    }

    public AudioPlayer(int i9, int i10, int i11) {
        this.bufferSize = AudioTrack.getMinBufferSize(i9, i10, i11);
        this.audioTrack = new AudioTrack(3, i9, i10, i11, this.bufferSize, 1);
    }

    private void init(Context context) {
        this.bufferSize = AudioTrack.getMinBufferSize(16000, 12, 3);
        AudioTrack audioTrack = new AudioTrack(3, 16000, 4, 2, this.bufferSize, 1);
        this.audioTrack = audioTrack;
        audioTrack.setPositionNotificationPeriod(this.bufferSize);
        AudioLooperThread audioLooperThread = new AudioLooperThread();
        this.audioLooperThread = audioLooperThread;
        audioLooperThread.start();
    }

    public boolean isPlaying() {
        AudioTrack audioTrack = this.audioTrack;
        return audioTrack != null && audioTrack.getState() == 3;
    }

    public void play(byte[] bArr) {
        if (this.audioTrack == null) {
            init(this.context);
        }
        this.queueMsg.add(bArr);
        if (!this.isPlaying) {
            this.isPlaying = true;
            AudioPlayStateChangeListener audioPlayStateChangeListener = this.audioPlayStateChangeListener;
            if (audioPlayStateChangeListener != null) {
                audioPlayStateChangeListener.onStateChange(true);
            }
        }
        this.audioHandler.sendEmptyMessage(101);
    }

    public void setAudioPlayStateChangeListener(AudioPlayStateChangeListener audioPlayStateChangeListener) {
        this.audioPlayStateChangeListener = audioPlayStateChangeListener;
    }

    public void stop() {
        j.f(this.TAG, "stop");
        this.isPlaying = false;
        this.queueMsg.clear();
        this.audioHandler.removeMessages(101);
        this.audioHandler.removeMessages(102);
        this.isPlaying = false;
        new Thread() { // from class: com.starburst.sdk.resp.AudioPlayer.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                if (AudioPlayer.this.audioPlayStateChangeListener != null) {
                    AudioPlayer.this.audioPlayStateChangeListener.onStateChange(AudioPlayer.this.isPlaying);
                }
            }
        }.start();
        AudioTrack audioTrack = this.audioTrack;
        if (audioTrack != null) {
            audioTrack.stop();
        }
        synchronized (this.lock) {
            try {
                AudioTrack audioTrack2 = this.audioTrack;
                if (audioTrack2 != null) {
                    audioTrack2.release();
                    this.audioTrack = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public AudioPlayer(Context context) {
        this.context = context.getApplicationContext();
        init(context);
    }
}

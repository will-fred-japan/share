package com.starburst.sdk.utils;

import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioTrack f16439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f16440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f16441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0180a.HandlerC0181a f16442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConcurrentLinkedQueue f16443e;

    /* JADX INFO: renamed from: com.starburst.sdk.utils.a$a, reason: collision with other inner class name */
    public class C0180a extends Thread {

        /* JADX INFO: renamed from: com.starburst.sdk.utils.a$a$a, reason: collision with other inner class name */
        public class HandlerC0181a extends Handler {
            public HandlerC0181a() {
            }

            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                super.handleMessage(message);
                int i9 = message.what;
                a aVar = a.this;
                if (i9 != 101) {
                    if (i9 != 102) {
                        return;
                    }
                    aVar.f16441c = false;
                    return;
                }
                aVar.f16441c = true;
                aVar.f16442d.removeMessages(102);
                aVar.getClass();
                j.k("AudioPlayer", "play---111---");
                byte[] bArr = (byte[]) aVar.f16443e.poll();
                if (bArr == null) {
                    aVar.f16442d.sendEmptyMessageDelayed(102, 1000L);
                    return;
                }
                AudioTrack audioTrack = aVar.f16439a;
                if (audioTrack != null) {
                    audioTrack.play();
                    int length = bArr.length;
                    while (length > 0) {
                        AudioTrack audioTrack2 = aVar.f16439a;
                        if (audioTrack2 == null || !aVar.f16441c) {
                            break;
                        }
                        try {
                            length -= audioTrack2.write(bArr, 0, length);
                        } catch (Exception e9) {
                            aVar.getClass();
                            j.j("AudioPlayer", "play failed", e9);
                        }
                    }
                    aVar.getClass();
                    j.k("AudioPlayer", "play---end---");
                }
                if (aVar.f16441c) {
                    aVar.f16442d.sendEmptyMessage(101);
                }
            }
        }

        public C0180a() {
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            super.run();
            Looper.prepare();
            a.this.f16442d = new HandlerC0181a();
            Looper.loop();
        }
    }

    public final void a() {
        this.f16440b = AudioTrack.getMinBufferSize(16000, 12, 2);
        AudioTrack audioTrack = new AudioTrack(3, 16000, 4, 2, this.f16440b, 1);
        this.f16439a = audioTrack;
        audioTrack.setPositionNotificationPeriod(this.f16440b);
        new C0180a().start();
    }
}

package com.starburst.sdk.core.tts;

/* JADX INFO: loaded from: classes.dex */
public final class EventType {
    public static final byte ERROR = 100;
    public static final byte FINISH_SESSION = 3;
    public static final EventType INSTANCE = new EventType();
    public static final byte START_SESSION = 1;
    public static final byte TASK_REQUEST = 2;
    public static final byte TTS_RESULT = 4;

    private EventType() {
    }
}

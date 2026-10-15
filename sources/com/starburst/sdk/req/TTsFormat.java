package com.starburst.sdk.req;

/* JADX INFO: loaded from: classes.dex */
public enum TTsFormat {
    MP3("mp3"),
    OGG("ogg_opus"),
    PCM("pcm");

    private final String type;

    TTsFormat(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }
}

package com.starburst.sdk.api;

/* JADX INFO: loaded from: classes.dex */
public interface IPodcastManager {
    void cancelPodcast();

    void setPodcastCallback(IPodcastCallback iPodcastCallback);

    void startPodcast(String str, IPodcastCallback iPodcastCallback);
}

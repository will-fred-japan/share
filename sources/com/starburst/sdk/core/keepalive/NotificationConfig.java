package com.starburst.sdk.core.keepalive;

/* JADX INFO: loaded from: classes.dex */
public class NotificationConfig {
    private final String channelId;
    private final String channelName;
    private final String content;
    private final int iconResId;
    private final int importance;
    private final String title;

    public static class Builder {
        private int iconResId;
        private String channelId = "KeepAliveChannel";
        private String channelName = "Background Service";
        private int importance = 2;
        private String title = "Service Running";
        private String content = "Keeping app alive";

        public NotificationConfig build() {
            if (this.iconResId != 0) {
                return new NotificationConfig(this);
            }
            throw new IllegalArgumentException("Notification icon must be set");
        }

        public Builder setChannelId(String str) {
            this.channelId = str;
            return this;
        }

        public Builder setChannelName(String str) {
            this.channelName = str;
            return this;
        }

        public Builder setContent(String str) {
            this.content = str;
            return this;
        }

        public Builder setIconResId(int i9) {
            this.iconResId = i9;
            return this;
        }

        public Builder setImportance(int i9) {
            this.importance = i9;
            return this;
        }

        public Builder setTitle(String str) {
            this.title = str;
            return this;
        }
    }

    private NotificationConfig(Builder builder) {
        this.channelId = builder.channelId;
        this.channelName = builder.channelName;
        this.importance = builder.importance;
        this.iconResId = builder.iconResId;
        this.title = builder.title;
        this.content = builder.content;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getContent() {
        return this.content;
    }

    public int getIconResId() {
        return this.iconResId;
    }

    public int getImportance() {
        return this.importance;
    }

    public String getTitle() {
        return this.title;
    }
}

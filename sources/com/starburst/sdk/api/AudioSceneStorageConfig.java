package com.starburst.sdk.api;

import java.io.File;
import p171w.a;

/* JADX INFO: loaded from: classes.dex */
public final class AudioSceneStorageConfig {
    private final String directory;
    private final boolean saveEnabled;

    public static final class Builder {
        private String directory;
        private boolean saveEnabled = true;

        public AudioSceneStorageConfig build() {
            return new AudioSceneStorageConfig(this);
        }

        public Builder directory(String str) {
            this.directory = str;
            return this;
        }

        public Builder saveEnabled(boolean z8) {
            this.saveEnabled = z8;
            return this;
        }
    }

    private AudioSceneStorageConfig(Builder builder) {
        this.saveEnabled = builder.saveEnabled;
        this.directory = normalizeAbsolutePath(builder.directory, "directory");
    }

    public static Builder builder() {
        return new Builder();
    }

    public static String normalizeAbsolutePath(String str, String str2) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        File file = new File(str.trim());
        if (file.isAbsolute()) {
            return file.getAbsolutePath();
        }
        throw new IllegalArgumentException(a.a(str2, " must be an absolute path: ", str));
    }

    public String getDirectory() {
        return this.directory;
    }

    public boolean isSaveEnabled() {
        return this.saveEnabled;
    }
}

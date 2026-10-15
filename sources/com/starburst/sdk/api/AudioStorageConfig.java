package com.starburst.sdk.api;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class AudioStorageConfig {
    private static final AudioSceneStorageConfig DEFAULT_SCENE_CONFIG = AudioSceneStorageConfig.builder().build();
    private final Map<AudioScene, AudioSceneStorageConfig> sceneConfigs;

    public static final class Builder {
        private final EnumMap<AudioScene, AudioSceneStorageConfig> sceneConfigs = new EnumMap<>(AudioScene.class);

        public AudioStorageConfig build() {
            return new AudioStorageConfig(this);
        }

        public Builder sceneConfig(AudioScene audioScene, AudioSceneStorageConfig audioSceneStorageConfig) {
            if (audioScene == null) {
                throw new IllegalArgumentException("scene must not be null");
            }
            if (audioSceneStorageConfig == null) {
                this.sceneConfigs.remove(audioScene);
                return this;
            }
            this.sceneConfigs.put(audioScene, audioSceneStorageConfig);
            return this;
        }
    }

    private AudioStorageConfig(Builder builder) {
        this.sceneConfigs = Collections.unmodifiableMap(new EnumMap(builder.sceneConfigs));
    }

    public static Builder builder() {
        return new Builder();
    }

    public AudioSceneStorageConfig getSceneConfig(AudioScene audioScene) {
        AudioSceneStorageConfig audioSceneStorageConfig = this.sceneConfigs.get(audioScene);
        return audioSceneStorageConfig != null ? audioSceneStorageConfig : DEFAULT_SCENE_CONFIG;
    }
}

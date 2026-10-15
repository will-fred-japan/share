package com.starburst.sdk.core.feed.deviceconfig;

import com.starburst.sdk.utils.j;

/* JADX INFO: loaded from: classes.dex */
public class DeviceConfig {
    private static final String TAG = "lishunDeviceConfig";
    public TextConfig text = new TextConfig();
    public RecordConfig audioRecord = new RecordConfig();
    public PlayConfig audioPlay = new PlayConfig();
    public ImageConfig wallpaper = new ImageConfig();
    public ImageConfig aiImage = new ImageConfig();

    public enum AudioEncoding {
        PCM(0),
        OPUS(1);

        private final int value;

        AudioEncoding(int i9) {
            this.value = i9;
        }

        public static AudioEncoding fromValue(int i9) {
            for (AudioEncoding audioEncoding : values()) {
                if (audioEncoding.value == i9) {
                    return audioEncoding;
                }
            }
            return PCM;
        }
    }

    public static class ImageConfig {
        public int maxStoreCount;
        public boolean needPreview;
        public ImageEncoding encoding = ImageEncoding.JPEG;
        public int originalWidth = 320;
        public int originalHeight = 240;
        public int previewWidth = 80;
        public int previewHeight = 60;
    }

    public enum ImageEncoding {
        JPEG(0),
        PNG(1),
        RGB565(2);

        private final int value;

        ImageEncoding(int i9) {
            this.value = i9;
        }

        public static ImageEncoding fromValue(int i9) {
            for (ImageEncoding imageEncoding : values()) {
                if (imageEncoding.value == i9) {
                    return imageEncoding;
                }
            }
            return JPEG;
        }
    }

    public static class PlayConfig {
        public AudioEncoding encoding = AudioEncoding.PCM;
        public int sampleRate = 16000;
        public int channels = 1;
        public int pcmFrameSize = 320;
        public int opusFrameSize = 40;
        public int isSupportA2dp = 1;
    }

    public static class RecordConfig {
        public AudioEncoding encoding = AudioEncoding.PCM;
        public int sampleRate = 16000;
        public int channels = 1;
        public int pcmFrameSize = 320;
        public int opusFrameSize = 40;
    }

    public static class TextConfig {
        public TextEncoding encoding = TextEncoding.UTF8;
        public int isTextSyncLowLatency;
        public int jokesCount;
        public int newsCount;
    }

    public enum TextEncoding {
        UTF8(0),
        GBK(1);

        private final int value;

        TextEncoding(int i9) {
            this.value = i9;
        }

        public static TextEncoding fromValue(int i9) {
            for (TextEncoding textEncoding : values()) {
                if (textEncoding.value == i9) {
                    return textEncoding;
                }
            }
            return UTF8;
        }
    }

    public void printConfig() {
        j.f(TAG, toFormattedString());
    }

    public String toFormattedString() {
        StringBuilder sb = new StringBuilder("=== 设备配置 ===\n[文本配置]\n");
        sb.append("编码格式: " + this.text.encoding + "\n");
        sb.append(String.format("新闻数量: %d\n", Integer.valueOf(this.text.newsCount)));
        sb.append(String.format("笑话数量: %d\n", Integer.valueOf(this.text.jokesCount)));
        sb.append(String.format("是否低延迟文本同步: %d\n\n", Integer.valueOf(this.text.isTextSyncLowLatency)));
        sb.append("[录音配置]\n");
        sb.append("编码格式: " + this.audioRecord.encoding + "\n");
        sb.append(String.format("采样率: %d Hz\n", Integer.valueOf(this.audioRecord.sampleRate)));
        sb.append(String.format("声道数: %d\n", Integer.valueOf(this.audioRecord.channels)));
        sb.append(String.format("PCM帧大小: %d\n", Integer.valueOf(this.audioRecord.pcmFrameSize)));
        sb.append(String.format("Opus帧大小: %d\n\n", Integer.valueOf(this.audioRecord.opusFrameSize)));
        sb.append("[音频播放配置]\n");
        sb.append("编码格式: " + this.audioPlay.encoding + "\n");
        sb.append(String.format("采样率: %d Hz\n", Integer.valueOf(this.audioPlay.sampleRate)));
        sb.append(String.format("声道数: %d\n", Integer.valueOf(this.audioPlay.channels)));
        sb.append(String.format("PCM帧大小: %d\n", Integer.valueOf(this.audioPlay.pcmFrameSize)));
        sb.append(String.format("Opus帧大小: %d\n\n", Integer.valueOf(this.audioPlay.opusFrameSize)));
        sb.append(String.format("是否支持A2DP: %d\n\n", Integer.valueOf(this.audioPlay.isSupportA2dp)));
        sb.append("[壁纸配置]\n");
        sb.append("编码类型: " + this.wallpaper.encoding + "\n");
        sb.append("需要预览: " + this.wallpaper.needPreview + "\n");
        sb.append(String.format("最大存储数量: %d\n", Integer.valueOf(this.wallpaper.maxStoreCount)));
        sb.append(String.format("原始尺寸: %dx%d px\n", Integer.valueOf(this.wallpaper.originalWidth), Integer.valueOf(this.wallpaper.originalHeight)));
        sb.append(String.format("预览尺寸: %dx%d px\n\n", Integer.valueOf(this.wallpaper.previewWidth), Integer.valueOf(this.wallpaper.previewHeight)));
        sb.append("[AI图片配置]\n");
        sb.append("编码类型: " + this.aiImage.encoding + "\n");
        sb.append("需要预览: " + this.aiImage.needPreview + "\n");
        sb.append(String.format("最大生成数量: %d\n", Integer.valueOf(this.aiImage.maxStoreCount)));
        sb.append(String.format("原始尺寸: %dx%d px\n", Integer.valueOf(this.aiImage.originalWidth), Integer.valueOf(this.aiImage.originalHeight)));
        sb.append(String.format("预览尺寸: %dx%d px\n", Integer.valueOf(this.aiImage.previewWidth), Integer.valueOf(this.aiImage.previewHeight)));
        return sb.toString();
    }
}

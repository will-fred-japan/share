package com.starburst.sdk.req;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class PodcastRequest {
    private int action;

    @SerializedName("aigc_watermark")
    private boolean aigcWatermark;

    @SerializedName("audio_config")
    private AudioConfig audioConfig;

    @SerializedName("input_id")
    private String inputId;

    @SerializedName("input_info")
    private InputInfo inputInfo;

    @SerializedName("input_text")
    private String inputText;

    @SerializedName("nlp_texts")
    private List<NlpText> nlpTexts;

    @SerializedName("prompt_text")
    private String promptText;

    @SerializedName("retry_info")
    private RetryInfo retryInfo;

    @SerializedName("speaker_info")
    private SpeakerInfo speakerInfo;

    @SerializedName("use_head_music")
    private boolean useHeadMusic = true;

    @SerializedName("use_tail_music")
    private boolean useTailMusic = false;

    public static class AudioConfig {
        private String format = "pcm";

        @SerializedName("sample_rate")
        private int sampleRate = 24000;

        @SerializedName("speech_rate")
        private int speechRate = 0;

        public String getFormat() {
            return this.format;
        }

        public int getSampleRate() {
            return this.sampleRate;
        }

        public int getSpeechRate() {
            return this.speechRate;
        }

        public void setFormat(String str) {
            this.format = str;
        }

        public void setSampleRate(int i9) {
            this.sampleRate = i9;
        }

        public void setSpeechRate(int i9) {
            this.speechRate = i9;
        }
    }

    public static class InputInfo {

        @SerializedName("input_text_max_length")
        private int inputTextMaxLength;

        @SerializedName("input_url")
        private String inputUrl;

        @SerializedName("max_char_length_per_round")
        private int maxCharLengthPerRound;

        @SerializedName("only_nlp_text")
        private boolean onlyNlpText;

        @SerializedName("return_audio_url")
        private boolean returnAudioUrl;

        @SerializedName("strict_audit")
        private boolean strictAudit;

        public int getInputTextMaxLength() {
            return this.inputTextMaxLength;
        }

        public String getInputUrl() {
            return this.inputUrl;
        }

        public int getMaxCharLengthPerRound() {
            return this.maxCharLengthPerRound;
        }

        public boolean isOnlyNlpText() {
            return this.onlyNlpText;
        }

        public boolean isReturnAudioUrl() {
            return this.returnAudioUrl;
        }

        public boolean isStrictAudit() {
            return this.strictAudit;
        }

        public void setInputTextMaxLength(int i9) {
            this.inputTextMaxLength = i9;
        }

        public void setInputUrl(String str) {
            this.inputUrl = str;
        }

        public void setMaxCharLengthPerRound(int i9) {
            this.maxCharLengthPerRound = i9;
        }

        public void setOnlyNlpText(boolean z8) {
            this.onlyNlpText = z8;
        }

        public void setReturnAudioUrl(boolean z8) {
            this.returnAudioUrl = z8;
        }

        public void setStrictAudit(boolean z8) {
            this.strictAudit = z8;
        }
    }

    public static class NlpText {
        private String speaker;
        private String text;

        public String getSpeaker() {
            return this.speaker;
        }

        public String getText() {
            return this.text;
        }

        public void setSpeaker(String str) {
            this.speaker = str;
        }

        public void setText(String str) {
            this.text = str;
        }
    }

    public static class RetryInfo {

        @SerializedName("last_finished_round_id")
        private long lastFinishedRoundId;

        @SerializedName("retry_task_id")
        private String retryTaskId;

        public long getLastFinishedRoundId() {
            return this.lastFinishedRoundId;
        }

        public String getRetryTaskId() {
            return this.retryTaskId;
        }

        public void setLastFinishedRoundId(long j) {
            this.lastFinishedRoundId = j;
        }

        public void setRetryTaskId(String str) {
            this.retryTaskId = str;
        }
    }

    public static class SpeakerInfo {

        @SerializedName("random_order")
        private boolean randomOrder = true;
        private List<String> speakers;

        public List<String> getSpeakers() {
            return this.speakers;
        }

        public boolean isRandomOrder() {
            return this.randomOrder;
        }

        public void setRandomOrder(boolean z8) {
            this.randomOrder = z8;
        }

        public void setSpeakers(List<String> list) {
            this.speakers = list;
        }
    }

    public int getAction() {
        return this.action;
    }

    public AudioConfig getAudioConfig() {
        return this.audioConfig;
    }

    public String getInputId() {
        return this.inputId;
    }

    public InputInfo getInputInfo() {
        return this.inputInfo;
    }

    public String getInputText() {
        return this.inputText;
    }

    public List<NlpText> getNlpTexts() {
        return this.nlpTexts;
    }

    public String getPromptText() {
        return this.promptText;
    }

    public RetryInfo getRetryInfo() {
        return this.retryInfo;
    }

    public SpeakerInfo getSpeakerInfo() {
        return this.speakerInfo;
    }

    public boolean isAigcWatermark() {
        return this.aigcWatermark;
    }

    public boolean isUseHeadMusic() {
        return this.useHeadMusic;
    }

    public boolean isUseTailMusic() {
        return this.useTailMusic;
    }

    public void setAction(int i9) {
        this.action = i9;
    }

    public void setAigcWatermark(boolean z8) {
        this.aigcWatermark = z8;
    }

    public void setAudioConfig(AudioConfig audioConfig) {
        this.audioConfig = audioConfig;
    }

    public void setInputId(String str) {
        this.inputId = str;
    }

    public void setInputInfo(InputInfo inputInfo) {
        this.inputInfo = inputInfo;
    }

    public void setInputText(String str) {
        this.inputText = str;
    }

    public void setNlpTexts(List<NlpText> list) {
        this.nlpTexts = list;
    }

    public void setPromptText(String str) {
        this.promptText = str;
    }

    public void setRetryInfo(RetryInfo retryInfo) {
        this.retryInfo = retryInfo;
    }

    public void setSpeakerInfo(SpeakerInfo speakerInfo) {
        this.speakerInfo = speakerInfo;
    }

    public void setUseHeadMusic(boolean z8) {
        this.useHeadMusic = z8;
    }

    public void setUseTailMusic(boolean z8) {
        this.useTailMusic = z8;
    }
}

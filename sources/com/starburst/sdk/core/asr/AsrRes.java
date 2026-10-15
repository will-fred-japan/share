package com.starburst.sdk.core.asr;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class AsrRes {

    @SerializedName("code")
    private Integer code;

    @SerializedName("definite")
    private Boolean definite;

    @SerializedName("definiteIndex")
    private Integer definiteIndex;

    @SerializedName("detectedLanguage")
    private String detectedLanguage;
    private boolean isLastPackage;

    @SerializedName("language")
    private String language;

    @SerializedName("msg")
    private String msg;

    @SerializedName("requestId")
    private String requestId;

    @SerializedName("sequence")
    private Integer sequence;

    @SerializedName("source")
    private String source;

    @SerializedName("speakerResult")
    private List<SpeakerResultDTO> speakerResult;

    @SerializedName("textResult")
    private String textResult;

    @SerializedName("translateResult")
    private TranslateResultDTO translateResult;

    @SerializedName("ttsResult")
    private TtsResultDTO ttsResult;

    public static class SpeakerResultDTO {

        @SerializedName("definiteIndex")
        private Integer definiteIndex;

        @SerializedName("endTime")
        private Integer endTime;

        @SerializedName("speakerId")
        private String speakerId;

        @SerializedName("startTime")
        private Integer startTime;

        @SerializedName("text")
        private String text;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                SpeakerResultDTO speakerResultDTO = (SpeakerResultDTO) obj;
                if (Objects.equals(this.speakerId, speakerResultDTO.speakerId) && Objects.equals(this.startTime, speakerResultDTO.startTime) && Objects.equals(this.endTime, speakerResultDTO.endTime) && Objects.equals(this.text, speakerResultDTO.text) && Objects.equals(this.definiteIndex, speakerResultDTO.definiteIndex)) {
                    return true;
                }
            }
            return false;
        }

        public Integer getDefiniteIndex() {
            return this.definiteIndex;
        }

        public Integer getEndTime() {
            return this.endTime;
        }

        public String getFeatureFingerprint() {
            String str = this.speakerId;
            if (str == null) {
                str = "null_speaker";
            }
            Integer num = this.startTime;
            Long lValueOf = Long.valueOf(num != null ? num.intValue() : -1L);
            Integer num2 = this.endTime;
            Long lValueOf2 = Long.valueOf(num2 != null ? num2.intValue() : -1L);
            Integer num3 = this.definiteIndex;
            Integer numValueOf = Integer.valueOf(num3 != null ? num3.intValue() : -1);
            String str2 = this.text;
            return String.format("%s|%d|%d|%d|%s", str, lValueOf, lValueOf2, numValueOf, str2 != null ? str2.trim().toLowerCase() : "null_text");
        }

        public String getSpeakerId() {
            return this.speakerId;
        }

        public Integer getStartTime() {
            return this.startTime;
        }

        public String getText() {
            return this.text;
        }

        public int hashCode() {
            return Objects.hash(this.speakerId, this.startTime, this.endTime, this.text, this.definiteIndex);
        }

        public void setDefiniteIndex(Integer num) {
            this.definiteIndex = num;
        }

        public void setEndTime(Integer num) {
            this.endTime = num;
        }

        public void setSpeakerId(String str) {
            this.speakerId = str;
        }

        public void setStartTime(Integer num) {
            this.startTime = num;
        }

        public void setText(String str) {
            this.text = str;
        }
    }

    public static class TranslateResultDTO {

        @SerializedName("definite")
        private Boolean definite;

        @SerializedName("definiteIndex")
        private Integer definiteIndex;

        @SerializedName("text")
        private String text;

        public Integer getDefiniteIndex() {
            return this.definiteIndex;
        }

        public String getText() {
            return this.text;
        }

        public Boolean isDefinite() {
            return this.definite;
        }

        public void setDefinite(Boolean bool) {
            this.definite = bool;
        }

        public void setDefiniteIndex(Integer num) {
            this.definiteIndex = num;
        }

        public void setText(String str) {
            this.text = str;
        }
    }

    public static class TtsResultDTO {

        @SerializedName("index")
        private Integer index;

        @SerializedName("streamPiece")
        private String streamPiece;

        @SerializedName("translateIndex")
        private Integer translateIndex;

        public Integer getIndex() {
            return this.index;
        }

        public String getStreamPiece() {
            return this.streamPiece;
        }

        public Integer getTranslateIndex() {
            return this.translateIndex;
        }

        public void setIndex(Integer num) {
            this.index = num;
        }

        public void setStreamPiece(String str) {
            this.streamPiece = str;
        }

        public void setTranslateIndex(Integer num) {
            this.translateIndex = num;
        }
    }

    public Integer getCode() {
        return this.code;
    }

    public Boolean getDefinite() {
        return this.definite;
    }

    public Integer getDefiniteIndex() {
        return this.definiteIndex;
    }

    public String getDetectedLanguage() {
        return this.detectedLanguage;
    }

    public String getLanguage() {
        return this.language;
    }

    public String getMsg() {
        return this.msg;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public Integer getSequence() {
        return this.sequence;
    }

    public String getSource() {
        return this.source;
    }

    public List<SpeakerResultDTO> getSpeakerResult() {
        return this.speakerResult;
    }

    public String getTextResult() {
        return this.textResult;
    }

    public TranslateResultDTO getTranslateResult() {
        return this.translateResult;
    }

    public TtsResultDTO getTtsResult() {
        return this.ttsResult;
    }

    public Boolean isDefinite() {
        return this.definite;
    }

    public boolean isLastPackage() {
        return this.isLastPackage;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public void setDefinite(Boolean bool) {
        this.definite = bool;
    }

    public void setDefiniteIndex(Integer num) {
        this.definiteIndex = num;
    }

    public void setDetectedLanguage(String str) {
        this.detectedLanguage = str;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void setLastPackage(boolean z8) {
        this.isLastPackage = z8;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public void setSequence(Integer num) {
        this.sequence = num;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setSpeakerResult(List<SpeakerResultDTO> list) {
        this.speakerResult = list;
    }

    public void setTextResult(String str) {
        this.textResult = str;
    }

    public void setTranslateResult(TranslateResultDTO translateResultDTO) {
        this.translateResult = translateResultDTO;
    }

    public void setTtsResult(TtsResultDTO ttsResultDTO) {
        this.ttsResult = ttsResultDTO;
    }
}

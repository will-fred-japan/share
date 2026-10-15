package com.starburst.sdk.api;

import com.starburst.sdk.core.feature.FeatureIds;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class SpeechProcessingTypes {
    public static final String A2DP_TRANSLATE = "a2dp_translate";
    public static final String CALL_RECORD = "call_record";
    public static final String CALL_TRANSLATE = "call_translate";
    public static final String FACE_TO_FACE = "face_to_face";
    public static final String LIVE_RECORD = "live_record";
    public static final String SIMULTANEOUS = "simultaneous";
    public static final String UNKNOWN = "unknown";

    private SpeechProcessingTypes() {
    }

    public static String normalize(String str) {
        if (str == null) {
            return null;
        }
        return str.trim().toLowerCase(Locale.ROOT);
    }

    public static String resolveFeatureId(String str, boolean z8) {
        String strNormalize = normalize(str);
        if (SIMULTANEOUS.equals(strNormalize)) {
            return FeatureIds.FEATURE_SIMULTANEOUS_INTERPRETATION;
        }
        if (CALL_RECORD.equals(strNormalize) || CALL_TRANSLATE.equals(strNormalize)) {
            return FeatureIds.FEATURE_CALL_RECORD;
        }
        if (A2DP_TRANSLATE.equals(strNormalize)) {
            return FeatureIds.FEATURE_SUBTITLE_TRANSLATE;
        }
        if (LIVE_RECORD.equals(strNormalize)) {
            return FeatureIds.FEATURE_MEETING_RECORD;
        }
        return (FACE_TO_FACE.equals(strNormalize) || z8) ? FeatureIds.FEATURE_TALK_TRANSLATE : FeatureIds.FEATURE_MEETING_RECORD;
    }
}

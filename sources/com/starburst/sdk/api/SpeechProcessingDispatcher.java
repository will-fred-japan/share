package com.starburst.sdk.api;

import com.starburst.sdk.core.asr.AsrRes;
import com.starburst.sdk.utils.j;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import p171w.a;

/* JADX INFO: loaded from: classes.dex */
public final class SpeechProcessingDispatcher implements ISpeechProcessingCallback {
    private static final SpeechProcessingDispatcher INSTANCE = new SpeechProcessingDispatcher();
    private static final String TAG = "SpeechDispatcher";
    private ISpeechProcessingCallback singleCallback;
    private final CopyOnWriteArrayList<ISpeechProcessingCallback> listeners = new CopyOnWriteArrayList<>();
    private volatile ISpeechProcessingCallback[] dispatchSnapshot = new ISpeechProcessingCallback[0];

    private SpeechProcessingDispatcher() {
    }

    public static SpeechProcessingDispatcher getInstance() {
        return INSTANCE;
    }

    private void logError(String str, ISpeechProcessingCallback iSpeechProcessingCallback, Throwable th) {
        StringBuilder sbC = a.c(str, " dispatch error in ");
        sbC.append(iSpeechProcessingCallback.getClass().getSimpleName());
        sbC.append(": ");
        sbC.append(th.getMessage());
        j.f(TAG, sbC.toString());
    }

    private void updateDispatchSnapshot() {
        ArrayList arrayList = new ArrayList(this.listeners);
        ISpeechProcessingCallback iSpeechProcessingCallback = this.singleCallback;
        if (iSpeechProcessingCallback != null && !arrayList.contains(iSpeechProcessingCallback)) {
            arrayList.add(0, this.singleCallback);
        }
        this.dispatchSnapshot = (ISpeechProcessingCallback[]) arrayList.toArray(new ISpeechProcessingCallback[0]);
    }

    public synchronized void addListener(ISpeechProcessingCallback iSpeechProcessingCallback) {
        if (iSpeechProcessingCallback == null || iSpeechProcessingCallback == this) {
            return;
        }
        if (this.listeners.addIfAbsent(iSpeechProcessingCallback)) {
            updateDispatchSnapshot();
            j.f(TAG, "addListener: " + iSpeechProcessingCallback.getClass().getSimpleName() + ", size=" + this.listeners.size());
        }
    }

    public synchronized void clearListeners() {
        this.singleCallback = null;
        this.listeners.clear();
        updateDispatchSnapshot();
        j.f(TAG, "clearListeners");
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onClose() {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onClose();
            } catch (Throwable th) {
                logError("onClose", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onError(int i9, String str) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onError(i9, str);
            } catch (Throwable th) {
                logError("onError", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onFileSaved(String str) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onFileSaved(str);
            } catch (Throwable th) {
                logError("onFileSaved", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onIntensityData(int i9, float[][] fArr) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onIntensityData(i9, fArr);
            } catch (Throwable th) {
                logError("onIntensityData", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onLastPackage() {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onLastPackage();
            } catch (Throwable th) {
                logError("onLastPackage", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onRecognizeText(AsrRes asrRes) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onRecognizeText(asrRes);
            } catch (Throwable th) {
                logError("onRecognizeText", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onSpeakerResult(AsrRes asrRes) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onSpeakerResult(asrRes);
            } catch (Throwable th) {
                logError("onSpeakerResult", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onStereoFileSaved(String str, String str2) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onStereoFileSaved(str, str2);
            } catch (Throwable th) {
                logError("onStereoFileSaved", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onStereoRecognizeText(int i9, AsrRes asrRes) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onStereoRecognizeText(i9, asrRes);
            } catch (Throwable th) {
                logError("onStereoRecognizeText", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onStereoSpeakerResult(int i9, AsrRes asrRes) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onStereoSpeakerResult(i9, asrRes);
            } catch (Throwable th) {
                logError("onStereoSpeakerResult", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onStereoTranslateText(int i9, AsrRes asrRes) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onStereoTranslateText(i9, asrRes);
            } catch (Throwable th) {
                logError("onStereoTranslateText", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onStereoTtsResult(int i9, int i10, byte[] bArr) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onStereoTtsResult(i9, i10, bArr);
            } catch (Throwable th) {
                logError("onStereoTtsResult", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onStop(String str) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onStop(str);
            } catch (Throwable th) {
                logError("onStop", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onTranslateText(AsrRes asrRes) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onTranslateText(asrRes);
            } catch (Throwable th) {
                logError("onTranslateText", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onTtsResult(int i9, byte[] bArr, int i10, String str) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onTtsResult(i9, bArr, i10, str);
            } catch (Throwable th) {
                logError("onTtsResult", iSpeechProcessingCallback, th);
            }
        }
    }

    @Override // com.starburst.sdk.api.ISpeechProcessingCallback
    public void onVoiceRecord(byte[] bArr) {
        for (ISpeechProcessingCallback iSpeechProcessingCallback : this.dispatchSnapshot) {
            try {
                iSpeechProcessingCallback.onVoiceRecord(bArr);
            } catch (Throwable th) {
                logError("onVoiceRecord", iSpeechProcessingCallback, th);
            }
        }
    }

    public synchronized void removeListener(ISpeechProcessingCallback iSpeechProcessingCallback) {
        if (iSpeechProcessingCallback == null) {
            return;
        }
        try {
            this.listeners.remove(iSpeechProcessingCallback);
            if (this.singleCallback == iSpeechProcessingCallback) {
                this.singleCallback = null;
            }
            updateDispatchSnapshot();
            j.f(TAG, "removeListener: " + iSpeechProcessingCallback.getClass().getSimpleName() + ", size=" + this.listeners.size());
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setCallback(ISpeechProcessingCallback iSpeechProcessingCallback) {
        if (iSpeechProcessingCallback == this) {
            return;
        }
        this.singleCallback = iSpeechProcessingCallback;
        updateDispatchSnapshot();
    }
}

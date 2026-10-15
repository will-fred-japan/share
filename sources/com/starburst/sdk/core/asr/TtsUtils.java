package com.starburst.sdk.core.asr;

import R7.l;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import p188x7.k;

/* JADX INFO: loaded from: classes.dex */
public final class TtsUtils {
    public static final String DEFAULT_TTS_BIT = "16bit";
    public static final int DEFAULT_TTS_SR = 16000;
    public static final Companion Companion = new Companion(null);
    private static final Object ttsPlayParamLock = new Object();
    private static final Map<String, TtsPlayProtocol600001> ttsPlayParamMap = new LinkedHashMap<String, TtsPlayProtocol600001>() { // from class: com.starburst.sdk.core.asr.TtsUtils$Companion$ttsPlayParamMap$1
        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof String) {
                return containsKey((String) obj);
            }
            return false;
        }

        public /* bridge */ boolean containsValue(TtsPlayProtocol600001 ttsPlayProtocol600001) {
            return super.containsValue((Object) ttsPlayProtocol600001);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<Map.Entry<String, TtsPlayProtocol600001>> entrySet() {
            return getEntries();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ TtsPlayProtocol600001 get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        public /* bridge */ Set<Map.Entry<String, TtsPlayProtocol600001>> getEntries() {
            return super.entrySet();
        }

        public /* bridge */ Set<String> getKeys() {
            return super.keySet();
        }

        public final /* bridge */ TtsPlayProtocol600001 getOrDefault(Object obj, TtsPlayProtocol600001 ttsPlayProtocol600001) {
            return !(obj instanceof String) ? ttsPlayProtocol600001 : getOrDefault((String) obj, ttsPlayProtocol600001);
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        public /* bridge */ Collection<TtsPlayProtocol600001> getValues() {
            return super.values();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Set<String> keySet() {
            return getKeys();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ TtsPlayProtocol600001 remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry<String, TtsPlayProtocol600001> entry) {
            return size() > 10;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ Collection<TtsPlayProtocol600001> values() {
            return getValues();
        }

        public /* bridge */ boolean containsKey(String str) {
            return super.containsKey((Object) str);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof TtsPlayProtocol600001) {
                return containsValue((TtsPlayProtocol600001) obj);
            }
            return false;
        }

        public /* bridge */ TtsPlayProtocol600001 get(String str) {
            return (TtsPlayProtocol600001) super.get((Object) str);
        }

        public /* bridge */ TtsPlayProtocol600001 getOrDefault(String str, TtsPlayProtocol600001 ttsPlayProtocol600001) {
            return (TtsPlayProtocol600001) super.getOrDefault((Object) str, ttsPlayProtocol600001);
        }

        public /* bridge */ TtsPlayProtocol600001 remove(String str) {
            return (TtsPlayProtocol600001) super.remove((Object) str);
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof String) {
                return get((String) obj);
            }
            return null;
        }

        @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (TtsPlayProtocol600001) obj2);
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof String) {
                return remove((String) obj);
            }
            return null;
        }

        @Override // java.util.HashMap, java.util.Map
        public final /* bridge */ boolean remove(Object obj, Object obj2) {
            if ((obj instanceof String) && (obj2 instanceof TtsPlayProtocol600001)) {
                return remove((String) obj, (TtsPlayProtocol600001) obj2);
            }
            return false;
        }

        public /* bridge */ boolean remove(String str, TtsPlayProtocol600001 ttsPlayProtocol600001) {
            return super.remove((Object) str, (Object) ttsPlayProtocol600001);
        }
    };

    public static final class Companion {
        private Companion() {
        }

        public final void clearTtsPlayParam() {
            synchronized (TtsUtils.ttsPlayParamLock) {
                TtsUtils.ttsPlayParamMap.clear();
                k kVar = k.f22364a;
            }
        }

        public final TtsPlayProtocol600001 getTtsPlayParam(String str) {
            TtsPlayProtocol600001 ttsPlayProtocol600001;
            if (str == null || str.length() == 0) {
                return null;
            }
            synchronized (TtsUtils.ttsPlayParamLock) {
                ttsPlayProtocol600001 = (TtsPlayProtocol600001) TtsUtils.ttsPlayParamMap.get(str);
            }
            return ttsPlayProtocol600001;
        }

        public final String normalizePlayBit(String str) {
            String string;
            if (str == null || (string = l.d0(str).toString()) == null) {
                return TtsUtils.DEFAULT_TTS_BIT;
            }
            if (string.length() <= 0) {
                string = null;
            }
            return string == null ? TtsUtils.DEFAULT_TTS_BIT : string;
        }

        public final int normalizeSampleRate(Integer num) {
            if (num == null) {
                return 16000;
            }
            if (num.intValue() <= 0) {
                num = null;
            }
            if (num != null) {
                return num.intValue();
            }
            return 16000;
        }

        public final void putTtsPlayParam(String requestId, TtsPlayProtocol600001 param) {
            kotlin.jvm.internal.k.e(requestId, "requestId");
            kotlin.jvm.internal.k.e(param, "param");
            synchronized (TtsUtils.ttsPlayParamLock) {
                TtsUtils.ttsPlayParamMap.put(requestId, param);
                k kVar = k.f22364a;
            }
        }

        public final void removeTtsPlayParam(String str) {
            if (str == null || str.length() == 0) {
                return;
            }
            synchronized (TtsUtils.ttsPlayParamLock) {
            }
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    public static final void clearTtsPlayParam() {
        Companion.clearTtsPlayParam();
    }

    public static final TtsPlayProtocol600001 getTtsPlayParam(String str) {
        return Companion.getTtsPlayParam(str);
    }

    public static final String normalizePlayBit(String str) {
        return Companion.normalizePlayBit(str);
    }

    public static final int normalizeSampleRate(Integer num) {
        return Companion.normalizeSampleRate(num);
    }

    public static final void putTtsPlayParam(String str, TtsPlayProtocol600001 ttsPlayProtocol600001) {
        Companion.putTtsPlayParam(str, ttsPlayProtocol600001);
    }

    public static final void removeTtsPlayParam(String str) {
        Companion.removeTtsPlayParam(str);
    }
}

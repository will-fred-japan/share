package com.xiaomi.push.service;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.starburst.sdk.core.opus.OpusCodecConfig;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseArray<ao.a<String, String, String>> f18316a = new SparseArray<ao.a<String, String, String>>(6) { // from class: com.xiaomi.push.service.b.1
        {
            put(1, ao.f18231g);
            put(2, ao.f18230f);
            put(4, ao.f18229e);
            put(8, ao.f18226b);
            put(16, ao.f18227c);
            put(32, ao.f18232h);
        }
    };

    public static int a(String str, int i9) {
        return ao.a(com.xiaomi.push.t.m835a(), str, null, f18316a.get(i9));
    }

    private static Bundle a(String str) {
        return ao.a(com.xiaomi.push.t.m835a(), str, (String) null);
    }

    /* JADX WARN: Code duplicated, block: B:66:0x00ed A[Catch: all -> 0x0138, TryCatch #0 {all -> 0x0138, blocks: (B:4:0x0003, B:6:0x0009, B:12:0x001a, B:14:0x002b, B:17:0x0032, B:19:0x003e, B:22:0x0049, B:23:0x004c, B:25:0x0058, B:28:0x0063, B:29:0x0066, B:31:0x0072, B:35:0x0081, B:36:0x0083, B:38:0x008f, B:42:0x009e, B:43:0x00a0, B:45:0x00ac, B:49:0x00bb, B:50:0x00bd, B:52:0x00c9, B:55:0x00d4, B:58:0x00d8, B:60:0x00de, B:64:0x00e7, B:66:0x00ed, B:70:0x00f6, B:72:0x00fc, B:76:0x0105, B:78:0x010b, B:82:0x0114, B:84:0x011a, B:88:0x0123, B:90:0x0129, B:93:0x012e, B:87:0x0120, B:81:0x0111, B:75:0x0102, B:69:0x00f3, B:63:0x00e4, B:9:0x0015, B:96:0x0132), top: B:100:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x00f1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:69:0x00f3 A[Catch: all -> 0x0138, TryCatch #0 {all -> 0x0138, blocks: (B:4:0x0003, B:6:0x0009, B:12:0x001a, B:14:0x002b, B:17:0x0032, B:19:0x003e, B:22:0x0049, B:23:0x004c, B:25:0x0058, B:28:0x0063, B:29:0x0066, B:31:0x0072, B:35:0x0081, B:36:0x0083, B:38:0x008f, B:42:0x009e, B:43:0x00a0, B:45:0x00ac, B:49:0x00bb, B:50:0x00bd, B:52:0x00c9, B:55:0x00d4, B:58:0x00d8, B:60:0x00de, B:64:0x00e7, B:66:0x00ed, B:70:0x00f6, B:72:0x00fc, B:76:0x0105, B:78:0x010b, B:82:0x0114, B:84:0x011a, B:88:0x0123, B:90:0x0129, B:93:0x012e, B:87:0x0120, B:81:0x0111, B:75:0x0102, B:69:0x00f3, B:63:0x00e4, B:9:0x0015, B:96:0x0132), top: B:100:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x00fc A[Catch: all -> 0x0138, TryCatch #0 {all -> 0x0138, blocks: (B:4:0x0003, B:6:0x0009, B:12:0x001a, B:14:0x002b, B:17:0x0032, B:19:0x003e, B:22:0x0049, B:23:0x004c, B:25:0x0058, B:28:0x0063, B:29:0x0066, B:31:0x0072, B:35:0x0081, B:36:0x0083, B:38:0x008f, B:42:0x009e, B:43:0x00a0, B:45:0x00ac, B:49:0x00bb, B:50:0x00bd, B:52:0x00c9, B:55:0x00d4, B:58:0x00d8, B:60:0x00de, B:64:0x00e7, B:66:0x00ed, B:70:0x00f6, B:72:0x00fc, B:76:0x0105, B:78:0x010b, B:82:0x0114, B:84:0x011a, B:88:0x0123, B:90:0x0129, B:93:0x012e, B:87:0x0120, B:81:0x0111, B:75:0x0102, B:69:0x00f3, B:63:0x00e4, B:9:0x0015, B:96:0x0132), top: B:100:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0100 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x0102 A[Catch: all -> 0x0138, TryCatch #0 {all -> 0x0138, blocks: (B:4:0x0003, B:6:0x0009, B:12:0x001a, B:14:0x002b, B:17:0x0032, B:19:0x003e, B:22:0x0049, B:23:0x004c, B:25:0x0058, B:28:0x0063, B:29:0x0066, B:31:0x0072, B:35:0x0081, B:36:0x0083, B:38:0x008f, B:42:0x009e, B:43:0x00a0, B:45:0x00ac, B:49:0x00bb, B:50:0x00bd, B:52:0x00c9, B:55:0x00d4, B:58:0x00d8, B:60:0x00de, B:64:0x00e7, B:66:0x00ed, B:70:0x00f6, B:72:0x00fc, B:76:0x0105, B:78:0x010b, B:82:0x0114, B:84:0x011a, B:88:0x0123, B:90:0x0129, B:93:0x012e, B:87:0x0120, B:81:0x0111, B:75:0x0102, B:69:0x00f3, B:63:0x00e4, B:9:0x0015, B:96:0x0132), top: B:100:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x010b A[Catch: all -> 0x0138, TryCatch #0 {all -> 0x0138, blocks: (B:4:0x0003, B:6:0x0009, B:12:0x001a, B:14:0x002b, B:17:0x0032, B:19:0x003e, B:22:0x0049, B:23:0x004c, B:25:0x0058, B:28:0x0063, B:29:0x0066, B:31:0x0072, B:35:0x0081, B:36:0x0083, B:38:0x008f, B:42:0x009e, B:43:0x00a0, B:45:0x00ac, B:49:0x00bb, B:50:0x00bd, B:52:0x00c9, B:55:0x00d4, B:58:0x00d8, B:60:0x00de, B:64:0x00e7, B:66:0x00ed, B:70:0x00f6, B:72:0x00fc, B:76:0x0105, B:78:0x010b, B:82:0x0114, B:84:0x011a, B:88:0x0123, B:90:0x0129, B:93:0x012e, B:87:0x0120, B:81:0x0111, B:75:0x0102, B:69:0x00f3, B:63:0x00e4, B:9:0x0015, B:96:0x0132), top: B:100:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x010f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:81:0x0111 A[Catch: all -> 0x0138, TryCatch #0 {all -> 0x0138, blocks: (B:4:0x0003, B:6:0x0009, B:12:0x001a, B:14:0x002b, B:17:0x0032, B:19:0x003e, B:22:0x0049, B:23:0x004c, B:25:0x0058, B:28:0x0063, B:29:0x0066, B:31:0x0072, B:35:0x0081, B:36:0x0083, B:38:0x008f, B:42:0x009e, B:43:0x00a0, B:45:0x00ac, B:49:0x00bb, B:50:0x00bd, B:52:0x00c9, B:55:0x00d4, B:58:0x00d8, B:60:0x00de, B:64:0x00e7, B:66:0x00ed, B:70:0x00f6, B:72:0x00fc, B:76:0x0105, B:78:0x010b, B:82:0x0114, B:84:0x011a, B:88:0x0123, B:90:0x0129, B:93:0x012e, B:87:0x0120, B:81:0x0111, B:75:0x0102, B:69:0x00f3, B:63:0x00e4, B:9:0x0015, B:96:0x0132), top: B:100:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x011a A[Catch: all -> 0x0138, TryCatch #0 {all -> 0x0138, blocks: (B:4:0x0003, B:6:0x0009, B:12:0x001a, B:14:0x002b, B:17:0x0032, B:19:0x003e, B:22:0x0049, B:23:0x004c, B:25:0x0058, B:28:0x0063, B:29:0x0066, B:31:0x0072, B:35:0x0081, B:36:0x0083, B:38:0x008f, B:42:0x009e, B:43:0x00a0, B:45:0x00ac, B:49:0x00bb, B:50:0x00bd, B:52:0x00c9, B:55:0x00d4, B:58:0x00d8, B:60:0x00de, B:64:0x00e7, B:66:0x00ed, B:70:0x00f6, B:72:0x00fc, B:76:0x0105, B:78:0x010b, B:82:0x0114, B:84:0x011a, B:88:0x0123, B:90:0x0129, B:93:0x012e, B:87:0x0120, B:81:0x0111, B:75:0x0102, B:69:0x00f3, B:63:0x00e4, B:9:0x0015, B:96:0x0132), top: B:100:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:86:0x011e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x0120 A[Catch: all -> 0x0138, TryCatch #0 {all -> 0x0138, blocks: (B:4:0x0003, B:6:0x0009, B:12:0x001a, B:14:0x002b, B:17:0x0032, B:19:0x003e, B:22:0x0049, B:23:0x004c, B:25:0x0058, B:28:0x0063, B:29:0x0066, B:31:0x0072, B:35:0x0081, B:36:0x0083, B:38:0x008f, B:42:0x009e, B:43:0x00a0, B:45:0x00ac, B:49:0x00bb, B:50:0x00bd, B:52:0x00c9, B:55:0x00d4, B:58:0x00d8, B:60:0x00de, B:64:0x00e7, B:66:0x00ed, B:70:0x00f6, B:72:0x00fc, B:76:0x0105, B:78:0x010b, B:82:0x0114, B:84:0x011a, B:88:0x0123, B:90:0x0129, B:93:0x012e, B:87:0x0120, B:81:0x0111, B:75:0x0102, B:69:0x00f3, B:63:0x00e4, B:9:0x0015, B:96:0x0132), top: B:100:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0129 A[Catch: all -> 0x0138, TryCatch #0 {all -> 0x0138, blocks: (B:4:0x0003, B:6:0x0009, B:12:0x001a, B:14:0x002b, B:17:0x0032, B:19:0x003e, B:22:0x0049, B:23:0x004c, B:25:0x0058, B:28:0x0063, B:29:0x0066, B:31:0x0072, B:35:0x0081, B:36:0x0083, B:38:0x008f, B:42:0x009e, B:43:0x00a0, B:45:0x00ac, B:49:0x00bb, B:50:0x00bd, B:52:0x00c9, B:55:0x00d4, B:58:0x00d8, B:60:0x00de, B:64:0x00e7, B:66:0x00ed, B:70:0x00f6, B:72:0x00fc, B:76:0x0105, B:78:0x010b, B:82:0x0114, B:84:0x011a, B:88:0x0123, B:90:0x0129, B:93:0x012e, B:87:0x0120, B:81:0x0111, B:75:0x0102, B:69:0x00f3, B:63:0x00e4, B:9:0x0015, B:96:0x0132), top: B:100:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x012c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:93:0x012e A[Catch: all -> 0x0138, TryCatch #0 {all -> 0x0138, blocks: (B:4:0x0003, B:6:0x0009, B:12:0x001a, B:14:0x002b, B:17:0x0032, B:19:0x003e, B:22:0x0049, B:23:0x004c, B:25:0x0058, B:28:0x0063, B:29:0x0066, B:31:0x0072, B:35:0x0081, B:36:0x0083, B:38:0x008f, B:42:0x009e, B:43:0x00a0, B:45:0x00ac, B:49:0x00bb, B:50:0x00bd, B:52:0x00c9, B:55:0x00d4, B:58:0x00d8, B:60:0x00de, B:64:0x00e7, B:66:0x00ed, B:70:0x00f6, B:72:0x00fc, B:76:0x0105, B:78:0x010b, B:82:0x0114, B:84:0x011a, B:88:0x0123, B:90:0x0129, B:93:0x012e, B:87:0x0120, B:81:0x0111, B:75:0x0102, B:69:0x00f3, B:63:0x00e4, B:9:0x0015, B:96:0x0132), top: B:100:0x0003 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0131 A[RETURN] */
    public static int a(Context context, String str) {
        int i9;
        int iA;
        int i10;
        int iA2;
        int i11;
        int iA3;
        int i12;
        int iA4;
        int i13;
        int iA5;
        int i14 = 0;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    com.xiaomi.push.h.b bVarA = com.xiaomi.push.h.a(context, str, true);
                    if (bVarA == com.xiaomi.push.h.b.ALLOWED) {
                        i14 = 1;
                    } else if (bVarA == com.xiaomi.push.h.b.NOT_ALLOWED) {
                        i14 = 2;
                    }
                    if (ao.a()) {
                        Bundle bundleA = a(str);
                        if (bundleA == null) {
                            return i14;
                        }
                        ao.a<String, String, String> aVar = ao.f18231g;
                        if (bundleA.containsKey(aVar.f18235c)) {
                            i14 |= bundleA.getBoolean(aVar.f18235c) ? 4 : 8;
                        }
                        ao.a<String, String, String> aVar2 = ao.f18229e;
                        if (bundleA.containsKey(aVar2.f18235c)) {
                            i14 |= bundleA.getBoolean(aVar2.f18235c) ? 16 : 32;
                        }
                        ao.a<String, String, String> aVar3 = ao.f18230f;
                        if (bundleA.containsKey(aVar3.f18235c)) {
                            i14 = (bundleA.getBoolean(aVar3.f18235c) ? 64 : 128) | i14;
                        }
                        ao.a<String, String, String> aVar4 = ao.f18226b;
                        if (bundleA.containsKey(aVar4.f18235c)) {
                            i14 = (bundleA.getBoolean(aVar4.f18235c) ? 256 : 512) | i14;
                        }
                        ao.a<String, String, String> aVar5 = ao.f18227c;
                        if (bundleA.containsKey(aVar5.f18235c)) {
                            i14 = (bundleA.getBoolean(aVar5.f18235c) ? 1024 : OpusCodecConfig.APPLICATION_VOIP) | i14;
                        }
                        ao.a<String, String, String> aVar6 = ao.f18232h;
                        if (bundleA.containsKey(aVar6.f18235c)) {
                            return i14 | (bundleA.getBoolean(aVar6.f18235c) ? 4096 : 8192);
                        }
                        return i14;
                    }
                    int iA6 = a(str, 1);
                    if (iA6 != 1) {
                        if (iA6 == 0) {
                            i9 = i14 | 8;
                        }
                        iA = a(str, 4);
                        if (iA == 1) {
                            if (iA == 0) {
                                i10 = i14 | 32;
                            }
                            iA2 = a(str, 2);
                            if (iA2 == 1) {
                                if (iA2 == 0) {
                                    i11 = i14 | 128;
                                }
                                iA3 = a(str, 8);
                                if (iA3 == 1) {
                                    if (iA3 == 0) {
                                        i12 = i14 | 512;
                                    }
                                    iA4 = a(str, 16);
                                    if (iA4 == 1) {
                                        if (iA4 == 0) {
                                            i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                                        }
                                        iA5 = a(str, 32);
                                        if (iA5 == 1) {
                                            return i14 | 4096;
                                        }
                                        if (iA5 == 0) {
                                            return i14 | 8192;
                                        }
                                        return i14;
                                    }
                                    i13 = i14 | 1024;
                                    i14 = i13;
                                    iA5 = a(str, 32);
                                    if (iA5 == 1) {
                                        return i14 | 4096;
                                    }
                                    if (iA5 == 0) {
                                        return i14 | 8192;
                                    }
                                    return i14;
                                }
                                i12 = i14 | 256;
                                i14 = i12;
                                iA4 = a(str, 16);
                                if (iA4 == 1) {
                                    if (iA4 == 0) {
                                        i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                                    }
                                    iA5 = a(str, 32);
                                    if (iA5 == 1) {
                                        return i14 | 4096;
                                    }
                                    if (iA5 == 0) {
                                        return i14 | 8192;
                                    }
                                    return i14;
                                }
                                i13 = i14 | 1024;
                                i14 = i13;
                                iA5 = a(str, 32);
                                if (iA5 == 1) {
                                    return i14 | 4096;
                                }
                                if (iA5 == 0) {
                                    return i14 | 8192;
                                }
                                return i14;
                            }
                            i11 = i14 | 64;
                            i14 = i11;
                            iA3 = a(str, 8);
                            if (iA3 == 1) {
                                if (iA3 == 0) {
                                    i12 = i14 | 512;
                                }
                                iA4 = a(str, 16);
                                if (iA4 == 1) {
                                    if (iA4 == 0) {
                                        i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                                    }
                                    iA5 = a(str, 32);
                                    if (iA5 == 1) {
                                        return i14 | 4096;
                                    }
                                    if (iA5 == 0) {
                                        return i14 | 8192;
                                    }
                                    return i14;
                                }
                                i13 = i14 | 1024;
                                i14 = i13;
                                iA5 = a(str, 32);
                                if (iA5 == 1) {
                                    return i14 | 4096;
                                }
                                if (iA5 == 0) {
                                    return i14 | 8192;
                                }
                                return i14;
                            }
                            i12 = i14 | 256;
                            i14 = i12;
                            iA4 = a(str, 16);
                            if (iA4 == 1) {
                                if (iA4 == 0) {
                                    i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                                }
                                iA5 = a(str, 32);
                                if (iA5 == 1) {
                                    return i14 | 4096;
                                }
                                if (iA5 == 0) {
                                    return i14 | 8192;
                                }
                                return i14;
                            }
                            i13 = i14 | 1024;
                            i14 = i13;
                            iA5 = a(str, 32);
                            if (iA5 == 1) {
                                return i14 | 4096;
                            }
                            if (iA5 == 0) {
                                return i14 | 8192;
                            }
                            return i14;
                        }
                        i10 = i14 | 16;
                        i14 = i10;
                        iA2 = a(str, 2);
                        if (iA2 == 1) {
                            if (iA2 == 0) {
                                i11 = i14 | 128;
                            }
                            iA3 = a(str, 8);
                            if (iA3 == 1) {
                                if (iA3 == 0) {
                                    i12 = i14 | 512;
                                }
                                iA4 = a(str, 16);
                                if (iA4 == 1) {
                                    if (iA4 == 0) {
                                        i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                                    }
                                    iA5 = a(str, 32);
                                    if (iA5 == 1) {
                                        return i14 | 4096;
                                    }
                                    if (iA5 == 0) {
                                        return i14 | 8192;
                                    }
                                    return i14;
                                }
                                i13 = i14 | 1024;
                                i14 = i13;
                                iA5 = a(str, 32);
                                if (iA5 == 1) {
                                    return i14 | 4096;
                                }
                                if (iA5 == 0) {
                                    return i14 | 8192;
                                }
                                return i14;
                            }
                            i12 = i14 | 256;
                            i14 = i12;
                            iA4 = a(str, 16);
                            if (iA4 == 1) {
                                if (iA4 == 0) {
                                    i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                                }
                                iA5 = a(str, 32);
                                if (iA5 == 1) {
                                    return i14 | 4096;
                                }
                                if (iA5 == 0) {
                                    return i14 | 8192;
                                }
                                return i14;
                            }
                            i13 = i14 | 1024;
                            i14 = i13;
                            iA5 = a(str, 32);
                            if (iA5 == 1) {
                                return i14 | 4096;
                            }
                            if (iA5 == 0) {
                                return i14 | 8192;
                            }
                            return i14;
                        }
                        i11 = i14 | 64;
                        i14 = i11;
                        iA3 = a(str, 8);
                        if (iA3 == 1) {
                            if (iA3 == 0) {
                                i12 = i14 | 512;
                            }
                            iA4 = a(str, 16);
                            if (iA4 == 1) {
                                if (iA4 == 0) {
                                    i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                                }
                                iA5 = a(str, 32);
                                if (iA5 == 1) {
                                    return i14 | 4096;
                                }
                                if (iA5 == 0) {
                                    return i14 | 8192;
                                }
                                return i14;
                            }
                            i13 = i14 | 1024;
                            i14 = i13;
                            iA5 = a(str, 32);
                            if (iA5 == 1) {
                                return i14 | 4096;
                            }
                            if (iA5 == 0) {
                                return i14 | 8192;
                            }
                            return i14;
                        }
                        i12 = i14 | 256;
                        i14 = i12;
                        iA4 = a(str, 16);
                        if (iA4 == 1) {
                            if (iA4 == 0) {
                                i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                            }
                            iA5 = a(str, 32);
                            if (iA5 == 1) {
                                return i14 | 4096;
                            }
                            if (iA5 == 0) {
                                return i14 | 8192;
                            }
                            return i14;
                        }
                        i13 = i14 | 1024;
                        i14 = i13;
                        iA5 = a(str, 32);
                        if (iA5 == 1) {
                            return i14 | 4096;
                        }
                        if (iA5 == 0) {
                            return i14 | 8192;
                        }
                        return i14;
                    }
                    i9 = i14 | 4;
                    i14 = i9;
                    iA = a(str, 4);
                    if (iA == 1) {
                        if (iA == 0) {
                            i10 = i14 | 32;
                        }
                        iA2 = a(str, 2);
                        if (iA2 == 1) {
                            if (iA2 == 0) {
                                i11 = i14 | 128;
                            }
                            iA3 = a(str, 8);
                            if (iA3 == 1) {
                                if (iA3 == 0) {
                                    i12 = i14 | 512;
                                }
                                iA4 = a(str, 16);
                                if (iA4 == 1) {
                                    if (iA4 == 0) {
                                        i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                                    }
                                    iA5 = a(str, 32);
                                    if (iA5 == 1) {
                                        return i14 | 4096;
                                    }
                                    if (iA5 == 0) {
                                        return i14 | 8192;
                                    }
                                    return i14;
                                }
                                i13 = i14 | 1024;
                                i14 = i13;
                                iA5 = a(str, 32);
                                if (iA5 == 1) {
                                    return i14 | 4096;
                                }
                                if (iA5 == 0) {
                                    return i14 | 8192;
                                }
                                return i14;
                            }
                            i12 = i14 | 256;
                            i14 = i12;
                            iA4 = a(str, 16);
                            if (iA4 == 1) {
                                if (iA4 == 0) {
                                    i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                                }
                                iA5 = a(str, 32);
                                if (iA5 == 1) {
                                    return i14 | 4096;
                                }
                                if (iA5 == 0) {
                                    return i14 | 8192;
                                }
                                return i14;
                            }
                            i13 = i14 | 1024;
                            i14 = i13;
                            iA5 = a(str, 32);
                            if (iA5 == 1) {
                                return i14 | 4096;
                            }
                            if (iA5 == 0) {
                                return i14 | 8192;
                            }
                            return i14;
                        }
                        i11 = i14 | 64;
                        i14 = i11;
                        iA3 = a(str, 8);
                        if (iA3 == 1) {
                            if (iA3 == 0) {
                                i12 = i14 | 512;
                            }
                            iA4 = a(str, 16);
                            if (iA4 == 1) {
                                if (iA4 == 0) {
                                    i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                                }
                                iA5 = a(str, 32);
                                if (iA5 == 1) {
                                    return i14 | 4096;
                                }
                                if (iA5 == 0) {
                                    return i14 | 8192;
                                }
                                return i14;
                            }
                            i13 = i14 | 1024;
                            i14 = i13;
                            iA5 = a(str, 32);
                            if (iA5 == 1) {
                                return i14 | 4096;
                            }
                            if (iA5 == 0) {
                                return i14 | 8192;
                            }
                            return i14;
                        }
                        i12 = i14 | 256;
                        i14 = i12;
                        iA4 = a(str, 16);
                        if (iA4 == 1) {
                            if (iA4 == 0) {
                                i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                            }
                            iA5 = a(str, 32);
                            if (iA5 == 1) {
                                return i14 | 4096;
                            }
                            if (iA5 == 0) {
                                return i14 | 8192;
                            }
                            return i14;
                        }
                        i13 = i14 | 1024;
                        i14 = i13;
                        iA5 = a(str, 32);
                        if (iA5 == 1) {
                            return i14 | 4096;
                        }
                        if (iA5 == 0) {
                            return i14 | 8192;
                        }
                        return i14;
                    }
                    i10 = i14 | 16;
                    i14 = i10;
                    iA2 = a(str, 2);
                    if (iA2 == 1) {
                        if (iA2 == 0) {
                            i11 = i14 | 128;
                        }
                        iA3 = a(str, 8);
                        if (iA3 == 1) {
                            if (iA3 == 0) {
                                i12 = i14 | 512;
                            }
                            iA4 = a(str, 16);
                            if (iA4 == 1) {
                                if (iA4 == 0) {
                                    i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                                }
                                iA5 = a(str, 32);
                                if (iA5 == 1) {
                                    return i14 | 4096;
                                }
                                if (iA5 == 0) {
                                    return i14 | 8192;
                                }
                                return i14;
                            }
                            i13 = i14 | 1024;
                            i14 = i13;
                            iA5 = a(str, 32);
                            if (iA5 == 1) {
                                return i14 | 4096;
                            }
                            if (iA5 == 0) {
                                return i14 | 8192;
                            }
                            return i14;
                        }
                        i12 = i14 | 256;
                        i14 = i12;
                        iA4 = a(str, 16);
                        if (iA4 == 1) {
                            if (iA4 == 0) {
                                i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                            }
                            iA5 = a(str, 32);
                            if (iA5 == 1) {
                                return i14 | 4096;
                            }
                            if (iA5 == 0) {
                                return i14 | 8192;
                            }
                            return i14;
                        }
                        i13 = i14 | 1024;
                        i14 = i13;
                        iA5 = a(str, 32);
                        if (iA5 == 1) {
                            return i14 | 4096;
                        }
                        if (iA5 == 0) {
                            return i14 | 8192;
                        }
                        return i14;
                    }
                    i11 = i14 | 64;
                    i14 = i11;
                    iA3 = a(str, 8);
                    if (iA3 == 1) {
                        if (iA3 == 0) {
                            i12 = i14 | 512;
                        }
                        iA4 = a(str, 16);
                        if (iA4 == 1) {
                            if (iA4 == 0) {
                                i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                            }
                            iA5 = a(str, 32);
                            if (iA5 == 1) {
                                return i14 | 4096;
                            }
                            if (iA5 == 0) {
                                return i14 | 8192;
                            }
                            return i14;
                        }
                        i13 = i14 | 1024;
                        i14 = i13;
                        iA5 = a(str, 32);
                        if (iA5 == 1) {
                            return i14 | 4096;
                        }
                        if (iA5 == 0) {
                            return i14 | 8192;
                        }
                        return i14;
                    }
                    i12 = i14 | 256;
                    i14 = i12;
                    iA4 = a(str, 16);
                    if (iA4 == 1) {
                        if (iA4 == 0) {
                            i13 = i14 | OpusCodecConfig.APPLICATION_VOIP;
                        }
                        iA5 = a(str, 32);
                        if (iA5 == 1) {
                            return i14 | 4096;
                        }
                        if (iA5 == 0) {
                            return i14 | 8192;
                        }
                        return i14;
                    }
                    i13 = i14 | 1024;
                    i14 = i13;
                    iA5 = a(str, 32);
                    if (iA5 == 1) {
                        return i14 | 4096;
                    }
                    if (iA5 == 0) {
                        return i14 | 8192;
                    }
                    return i14;
                }
            } catch (Throwable unused) {
                com.xiaomi.channel.commonutils.logger.c.d("A exception occurred while querying app notification switch status");
                return 0;
            }
        }
        com.xiaomi.channel.commonutils.logger.c.m9a("context | packageName must not be null");
        return 0;
    }
}

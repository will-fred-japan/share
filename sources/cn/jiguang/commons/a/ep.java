package cn.jiguang.commons.a;

import android.content.Context;
import com.starburst.sdk.core.tts.EventType;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public final class ep {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f9975a = jr.a(new byte[]{80, 59, 80, 96, 112, 82, 77, 79});

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9976b = jr.a(new byte[]{104, 13, 76, 65, 82});

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9977c = jr.a(new byte[]{65, 37, 85, 126, 94, 84, 124, 102, 98, 60, 125, EventType.ERROR, 44});

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9978d = jr.a(new byte[]{72, 13, 122, 103, 101, 60, 93, 69, 109, 105, 59, 124, 84, 21, 106, 125, 123});

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f9979e = jr.a(new byte[]{105, 29, 67, 118, 123, 59, 124, 85, 84, 120, 37, 117, 126, 94, 84, 124, 102, 98, 60, 93, 68, 44});

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f9980f = jr.a(new byte[]{105, 29, 65, 116, 114, 59, 124, 85, 84, 120, 37, 117, 126, 94, 84, 124, 102, 98, 60, 93, 68, 44});

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f9981g = jr.a(new byte[]{76, 112, 106, 124, EventType.ERROR, 68, 73, 117, 123, 56, 98, 95});

    public static String a(Context context, String str) {
        if (context == null) {
            context = jg.a();
        }
        File filesDir = context.getFilesDir();
        File file = new File(filesDir, "zl");
        return (file.exists() || file.mkdirs()) ? new File(file, str).getAbsolutePath() : new File(filesDir, str).getAbsolutePath();
    }
}

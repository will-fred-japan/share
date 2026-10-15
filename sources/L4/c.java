package L4;

import java.io.File;
import java.io.FilenameFilter;
import java.io.Serializable;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: ReLinkerInstance.java */
/* JADX INFO: loaded from: classes.dex */
public final class c implements FilenameFilter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Serializable f2843b;

    public c() {
        this.f2842a = 1;
        this.f2843b = Pattern.compile("^cpu[\\d]+$");
    }

    @Override // java.io.FilenameFilter
    public final boolean accept(File file, String str) {
        switch (this.f2842a) {
            case 0:
                return str.startsWith((String) this.f2843b);
            default:
                return ((Pattern) this.f2843b).matcher(str).matches();
        }
    }

    public c(String str) {
        this.f2842a = 0;
        this.f2843b = str;
    }
}

package p167v3;

import com.bytedance.services.apm.api.HttpResponse;
import java.io.File;
import java.util.HashMap;

/* JADX INFO: compiled from: IMultipartUploader.java */
/* JADX INFO: loaded from: classes.dex */
public interface e {
    HttpResponse a();

    void a(String str, String str2);

    void a(String str, String str2, String str3, String str4, HashMap map);

    void b(String str, HashMap map);

    void c(File file, String str, HashMap map);

    void d(String str, File file, String str2, String str3, HashMap map);
}

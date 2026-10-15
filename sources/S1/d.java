package S1;

import com.bytedance.retrofit2.Call;
import com.bytedance.retrofit2.http.GET;
import com.bytedance.retrofit2.http.Multipart;
import com.bytedance.retrofit2.http.POST;

/* JADX INFO: compiled from: RetrofitMonitorService.java */
/* JADX INFO: loaded from: classes.dex */
public interface d {
    @POST
    Call a();

    @Multipart
    @POST
    Call b();

    @GET
    Call c();
}

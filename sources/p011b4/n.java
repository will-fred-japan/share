package p011b4;

import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static a f8577a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f8578b;

    public static class a implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList f8579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f8580b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f8581c;

        @Override // android.util.Printer
        public final void println(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            char cCharAt = str.charAt(0);
            ArrayList<Printer> arrayList = this.f8580b;
            ArrayList<Printer> arrayList2 = this.f8579a;
            if (cCharAt == '>' && this.f8581c) {
                for (Printer printer : arrayList) {
                    if (!arrayList2.contains(printer)) {
                        arrayList2.add(printer);
                    }
                }
                arrayList.clear();
                this.f8581c = false;
            }
            if (arrayList2.size() > 5) {
                Log.e("LooperPrinterUtils", "wrapper contains too many printer,please check if the useless printer have been removed");
            }
            for (Printer printer2 : arrayList2) {
                if (printer2 != null) {
                    printer2.println(str);
                }
            }
            str.charAt(0);
        }
    }
}

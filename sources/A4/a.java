package A4;

import android.text.TextUtils;
import android.util.Log;
import android.util.Printer;
import java.util.ArrayList;

/* JADX INFO: compiled from: LooperPrinterUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static C0000a f1452a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f1453b;

    /* JADX INFO: renamed from: A4.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LooperPrinterUtils.java */
    public static class C0000a implements Printer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ArrayList f1454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList f1455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1456c;

        @Override // android.util.Printer
        public final void println(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            char cCharAt = str.charAt(0);
            ArrayList<Printer> arrayList = this.f1455b;
            ArrayList<Printer> arrayList2 = this.f1454a;
            if (cCharAt == '>' && this.f1456c) {
                for (Printer printer : arrayList) {
                    if (!arrayList2.contains(printer)) {
                        arrayList2.add(printer);
                    }
                }
                arrayList.clear();
                this.f1456c = false;
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

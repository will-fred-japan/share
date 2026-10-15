package R6;

/* JADX INFO: compiled from: GeneratedFileSelectorApi.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f4045a = a.f4046a;

    /* JADX INFO: compiled from: GeneratedFileSelectorApi.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f4046a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final p188x7.h f4047b = p011b4.h.E(new c(0));

        public static void a(p096m7.c binaryMessenger, k kVar) {
            kotlin.jvm.internal.k.e(binaryMessenger, "binaryMessenger");
            String strL = W5.e.l("dev.flutter.pigeon.file_selector_android.FileSelectorApi.openFile", "");
            p188x7.h hVar = f4047b;
            new p096m7.b(binaryMessenger, strL, (p096m7.i) hVar.getValue(), null).b(new R3.a(2, kVar));
            new p096m7.b(binaryMessenger, W5.e.l("dev.flutter.pigeon.file_selector_android.FileSelectorApi.openFiles", ""), (p096m7.i) hVar.getValue(), null).b(new R3.c(2, kVar));
            new p096m7.b(binaryMessenger, W5.e.l("dev.flutter.pigeon.file_selector_android.FileSelectorApi.getDirectoryPath", ""), (p096m7.i) hVar.getValue(), null).b(new R3.e(1, kVar));
        }
    }
}

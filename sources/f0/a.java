package f0;

import android.widget.EditText;

/* JADX INFO: compiled from: EmojiEditTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0197a f18644a;

    /* JADX INFO: renamed from: f0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EmojiEditTextHelper.java */
    public static class C0197a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final EditText f18645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g f18646b;

        public C0197a(EditText editText) {
            this.f18645a = editText;
            g gVar = new g(editText);
            this.f18646b = gVar;
            editText.addTextChangedListener(gVar);
            if (f0.b.f18648b == null) {
                synchronized (f0.b.f18647a) {
                    try {
                        if (f0.b.f18648b == null) {
                            f0.b bVar = new f0.b();
                            try {
                                f0.b.f18649c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, f0.b.class.getClassLoader());
                            } catch (Throwable unused) {
                            }
                            f0.b.f18648b = bVar;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            editText.setEditableFactory(f0.b.f18648b);
        }
    }

    /* JADX INFO: compiled from: EmojiEditTextHelper.java */
    public static class b {
    }

    public a(EditText editText) {
        this.f18644a = new C0197a(editText);
    }
}

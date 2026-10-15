package androidx.appcompat.widget;

/* JADX INFO: renamed from: androidx.appcompat.widget.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AppCompatSpinner.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0502n extends x {
    public final /* synthetic */ AppCompatSpinner.e j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ AppCompatSpinner f6633k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0502n(AppCompatSpinner appCompatSpinner, AppCompatSpinner appCompatSpinner2, AppCompatSpinner.e eVar) {
        super(appCompatSpinner2);
        this.f6633k = appCompatSpinner;
        this.j = eVar;
    }

    @Override // androidx.appcompat.widget.x
    public final p097n.f b() {
        return this.j;
    }

    @Override // androidx.appcompat.widget.x
    public final boolean c() {
        AppCompatSpinner appCompatSpinner = this.f6633k;
        if (appCompatSpinner.getInternalPopup().b()) {
            return true;
        }
        appCompatSpinner.f6348f.l(appCompatSpinner.getTextDirection(), appCompatSpinner.getTextAlignment());
        return true;
    }
}

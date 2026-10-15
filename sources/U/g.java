package U;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AccessibilityNodeProvider f4591a;

    /* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
    public static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final g f4592a;

        public a(g gVar) {
            this.f4592a = gVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i9) {
            f fVarA = this.f4592a.a(i9);
            if (fVarA == null) {
                return null;
            }
            return fVarA.f4577a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i9) {
            this.f4592a.getClass();
            return null;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final AccessibilityNodeInfo findFocus(int i9) {
            f fVarB = this.f4592a.b(i9);
            if (fVarB == null) {
                return null;
            }
            return fVarB.f4577a;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final boolean performAction(int i9, int i10, Bundle bundle) {
            return this.f4592a.c(i9, i10, bundle);
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
    public static class b extends a {
        @Override // android.view.accessibility.AccessibilityNodeProvider
        public final void addExtraDataToAccessibilityNodeInfo(int i9, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f4592a.getClass();
        }
    }

    public g() {
        this.f4591a = new b(this);
    }

    public f a(int i9) {
        return null;
    }

    public f b(int i9) {
        return null;
    }

    public boolean c(int i9, int i10, Bundle bundle) {
        return false;
    }

    public g(AccessibilityNodeProvider accessibilityNodeProvider) {
        this.f4591a = accessibilityNodeProvider;
    }
}

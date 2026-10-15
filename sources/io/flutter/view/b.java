package io.flutter.view;

import android.R;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import com.xiaomi.mipush.sdk.api.MiPushSdk;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.plugin.platform.i;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: AccessibilityBridge.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends AccessibilityNodeProvider {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final /* synthetic */ int f19705y = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f19706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p088l7.a f19707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AccessibilityManager f19708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AccessibilityViewEmbedder f19709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i f19710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ContentResolver f19711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap f19712g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f19713h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f19714i;
    public Integer j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f19715k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f19716l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f19717m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public f f19718n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public f f19719o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public f f19720p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList f19721q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f19722r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public FlutterView.a f19723s;
    public boolean t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f19724u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final AccessibilityManagerAccessibilityStateChangeListenerC0218b f19725v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final io.flutter.view.c f19726w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final c f19727x;

    /* JADX INFO: compiled from: AccessibilityBridge.java */
    public class a implements FlutterJNI.a {
        public a() {
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            int i9;
            int i10;
            i iVar;
            ArrayList arrayList;
            int i11;
            int i12;
            f fVar;
            int i13;
            int i14;
            f fVar2;
            String str;
            float f6;
            float f9;
            View viewH;
            Integer num;
            b bVar;
            View viewH2;
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            for (ByteBuffer byteBuffer2 : byteBufferArr) {
                byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
            }
            b bVar2 = b.this;
            bVar2.getClass();
            ArrayList<f> arrayList2 = new ArrayList();
            while (true) {
                boolean zHasRemaining = byteBuffer.hasRemaining();
                i9 = 1;
                i10 = 14;
                iVar = bVar2.f19710e;
                if (!zHasRemaining) {
                    break;
                }
                f fVarC = bVar2.c(byteBuffer.getInt());
                fVarC.f19764E = true;
                fVarC.f19770K = fVarC.f19803r;
                fVarC.f19771L = fVarC.f19801p;
                fVarC.f19765F = fVarC.f19788c;
                fVarC.f19766G = fVarC.f19790d;
                fVarC.f19767H = fVarC.f19793g;
                fVarC.f19768I = fVarC.f19794h;
                fVarC.f19769J = fVarC.f19797l;
                fVarC.f19788c = byteBuffer.getLong();
                fVarC.f19790d = byteBuffer.getInt();
                fVarC.f19791e = byteBuffer.getInt();
                fVarC.f19792f = byteBuffer.getInt();
                fVarC.f19793g = byteBuffer.getInt();
                fVarC.f19794h = byteBuffer.getInt();
                fVarC.f19795i = byteBuffer.getInt();
                fVarC.j = byteBuffer.getInt();
                fVarC.f19796k = byteBuffer.getInt();
                byteBuffer.getInt();
                fVarC.f19797l = byteBuffer.getFloat();
                fVarC.f19798m = byteBuffer.getFloat();
                fVarC.f19799n = byteBuffer.getFloat();
                fVarC.f19800o = b.d(byteBuffer, strArr);
                fVarC.f19801p = b.d(byteBuffer, strArr);
                fVarC.f19802q = f.f(byteBuffer, byteBufferArr);
                fVarC.f19803r = b.d(byteBuffer, strArr);
                fVarC.f19804s = f.f(byteBuffer, byteBufferArr);
                fVarC.t = b.d(byteBuffer, strArr);
                fVarC.f19805u = f.f(byteBuffer, byteBufferArr);
                fVarC.f19806v = b.d(byteBuffer, strArr);
                fVarC.f19807w = f.f(byteBuffer, byteBufferArr);
                fVarC.f19808x = b.d(byteBuffer, strArr);
                fVarC.f19809y = f.f(byteBuffer, byteBufferArr);
                fVarC.f19810z = b.d(byteBuffer, strArr);
                fVarC.f19760A = b.d(byteBuffer, strArr);
                fVarC.f19761B = b.d(byteBuffer, strArr);
                fVarC.f19762C = byteBuffer.getInt();
                byteBuffer.getInt();
                fVarC.f19772M = byteBuffer.getFloat();
                fVarC.f19773N = byteBuffer.getFloat();
                fVarC.O = byteBuffer.getFloat();
                fVarC.f19774P = byteBuffer.getFloat();
                float[] fArr = fVarC.f19775Q;
                if (fArr == null) {
                    fArr = new float[16];
                }
                for (int i15 = 0; i15 < 16; i15++) {
                    fArr[i15] = byteBuffer.getFloat();
                }
                fVarC.f19775Q = fArr;
                float[] fArr2 = fVarC.f19776R;
                if (fArr2 == null) {
                    fArr2 = new float[16];
                }
                for (int i16 = 0; i16 < 16; i16++) {
                    fArr2[i16] = byteBuffer.getFloat();
                }
                fVarC.f19776R = fArr2;
                fVarC.f19783Y = true;
                fVarC.a0 = true;
                int i17 = byteBuffer.getInt();
                ArrayList arrayList3 = fVarC.f19778T;
                arrayList3.clear();
                int i18 = 0;
                while (true) {
                    bVar = fVarC.f19785a;
                    if (i18 >= i17) {
                        break;
                    }
                    f fVarC2 = bVar.c(byteBuffer.getInt());
                    fVarC2.f19777S = fVarC;
                    arrayList3.add(fVarC2);
                    i18++;
                }
                int i19 = byteBuffer.getInt();
                ArrayList arrayList4 = fVarC.f19779U;
                arrayList4.clear();
                for (int i20 = 0; i20 < i19; i20++) {
                    f fVarC3 = bVar.c(byteBuffer.getInt());
                    fVarC3.f19777S = fVarC;
                    arrayList4.add(fVarC3);
                }
                int i21 = byteBuffer.getInt();
                if (i21 == 0) {
                    fVarC.f19780V = null;
                } else {
                    ArrayList arrayList5 = fVarC.f19780V;
                    if (arrayList5 == null) {
                        fVarC.f19780V = new ArrayList(i21);
                    } else {
                        arrayList5.clear();
                    }
                    for (int i22 = 0; i22 < i21; i22++) {
                        e eVarB = bVar.b(byteBuffer.getInt());
                        int i23 = eVarB.f19757c;
                        if (i23 == 1) {
                            fVarC.f19781W = eVarB;
                        } else if (i23 == 2) {
                            fVarC.f19782X = eVarB;
                        } else {
                            fVarC.f19780V.add(eVarB);
                        }
                        fVarC.f19780V.add(eVarB);
                    }
                }
                if (!fVarC.g(14)) {
                    if (fVarC.g(6)) {
                        bVar2.f19718n = fVarC;
                    }
                    if (fVarC.f19764E) {
                        arrayList2.add(fVarC);
                    }
                    int i24 = fVarC.f19795i;
                    if (i24 != -1 && !iVar.f(i24) && (viewH2 = iVar.h(fVarC.f19795i)) != null) {
                        viewH2.setImportantForAccessibility(0);
                    }
                }
            }
            HashSet hashSet = new HashSet();
            HashMap map = bVar2.f19712g;
            f fVar3 = (f) map.get(0);
            ArrayList arrayList6 = new ArrayList();
            if (fVar3 != null) {
                float[] fArr3 = new float[16];
                Matrix.setIdentityM(fArr3, 0);
                fVar3.k(fArr3, hashSet, false);
                fVar3.c(arrayList6);
            }
            Iterator it = arrayList6.iterator();
            f fVar4 = null;
            while (true) {
                boolean zHasNext = it.hasNext();
                arrayList = bVar2.f19721q;
                if (!zHasNext) {
                    break;
                }
                f fVar5 = (f) it.next();
                if (!arrayList.contains(Integer.valueOf(fVar5.f19786b))) {
                    fVar4 = fVar5;
                }
            }
            if (fVar4 == null && !arrayList6.isEmpty()) {
                fVar4 = (f) arrayList6.get(arrayList6.size() - 1);
            }
            if (fVar4 != null && (fVar4.f19786b != bVar2.f19722r || arrayList6.size() != arrayList.size())) {
                bVar2.f19722r = fVar4.f19786b;
                String strE = fVar4.e();
                if (strE == null) {
                    strE = " ";
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    bVar2.f19706a.setAccessibilityPaneTitle(strE);
                } else {
                    AccessibilityEvent accessibilityEventE = bVar2.e(fVar4.f19786b, 32);
                    accessibilityEventE.getText().add(strE);
                    bVar2.i(accessibilityEventE);
                }
            }
            arrayList.clear();
            Iterator it2 = arrayList6.iterator();
            while (it2.hasNext()) {
                arrayList.add(Integer.valueOf(((f) it2.next()).f19786b));
            }
            Iterator it3 = map.entrySet().iterator();
            while (true) {
                i11 = 4;
                if (!it3.hasNext()) {
                    break;
                }
                f fVar6 = (f) ((Map.Entry) it3.next()).getValue();
                if (!hashSet.contains(fVar6)) {
                    fVar6.f19777S = null;
                    if (fVar6.f19795i != -1 && (num = bVar2.j) != null && bVar2.f19709d.platformViewOfNode(num.intValue()) == iVar.h(fVar6.f19795i)) {
                        bVar2.h(bVar2.j.intValue(), 65536);
                        bVar2.j = null;
                    }
                    int i25 = fVar6.f19795i;
                    if (i25 != -1 && (viewH = iVar.h(i25)) != null) {
                        viewH.setImportantForAccessibility(4);
                    }
                    f fVar7 = bVar2.f19714i;
                    if (fVar7 == fVar6) {
                        bVar2.h(fVar7.f19786b, 65536);
                        bVar2.f19714i = null;
                    }
                    if (bVar2.f19718n == fVar6) {
                        bVar2.f19718n = null;
                    }
                    if (bVar2.f19720p == fVar6) {
                        bVar2.f19720p = null;
                    }
                    it3.remove();
                }
            }
            int i26 = OpusCodecConfig.APPLICATION_VOIP;
            int i27 = 0;
            AccessibilityEvent accessibilityEventE2 = bVar2.e(0, OpusCodecConfig.APPLICATION_VOIP);
            accessibilityEventE2.setContentChangeTypes(1);
            bVar2.i(accessibilityEventE2);
            for (f fVar8 : arrayList2) {
                if (!Float.isNaN(fVar8.f19797l) && !Float.isNaN(fVar8.f19769J) && fVar8.f19769J != fVar8.f19797l) {
                    AccessibilityEvent accessibilityEventE3 = bVar2.e(fVar8.f19786b, 4096);
                    float f10 = fVar8.f19797l;
                    float f11 = fVar8.f19798m;
                    if (Float.isInfinite(f11)) {
                        if (f10 > 70000.0f) {
                            f10 = 70000.0f;
                        }
                        f11 = 100000.0f;
                    }
                    if (Float.isInfinite(fVar8.f19799n)) {
                        f6 = f11 + 100000.0f;
                        if (f10 < -70000.0f) {
                            f10 = -70000.0f;
                        }
                        f9 = f10 + 100000.0f;
                    } else {
                        float f12 = fVar8.f19799n;
                        f6 = f11 - f12;
                        f9 = f10 - f12;
                    }
                    int i28 = fVar8.f19766G;
                    if ((i28 & 16) != 0 || (i28 & 32) != 0) {
                        accessibilityEventE3.setScrollY((int) f9);
                        accessibilityEventE3.setMaxScrollY((int) f6);
                    } else if ((i28 & 4) != 0 || (i28 & 8) != 0) {
                        accessibilityEventE3.setScrollX((int) f9);
                        accessibilityEventE3.setMaxScrollX((int) f6);
                    }
                    int i29 = fVar8.j;
                    if (i29 > 0) {
                        accessibilityEventE3.setItemCount(i29);
                        accessibilityEventE3.setFromIndex(fVar8.f19796k);
                        Iterator it4 = fVar8.f19779U.iterator();
                        int i30 = i27;
                        while (it4.hasNext()) {
                            if (!((f) it4.next()).g(i10)) {
                                i30++;
                            }
                        }
                        accessibilityEventE3.setToIndex((fVar8.f19796k + i30) - i9);
                    }
                    bVar2.i(accessibilityEventE3);
                }
                if (fVar8.g(16) && (((str = fVar8.f19801p) != null || fVar8.f19771L != null) && (str == null || !str.equals(fVar8.f19771L)))) {
                    AccessibilityEvent accessibilityEventE4 = bVar2.e(fVar8.f19786b, i26);
                    accessibilityEventE4.setContentChangeTypes(i9);
                    bVar2.i(accessibilityEventE4);
                }
                f fVar9 = bVar2.f19714i;
                if (fVar9 != null && fVar9.f19786b == fVar8.f19786b) {
                    if ((((long) W5.f.g(3)) & fVar8.f19765F) == 0 && fVar8.g(3)) {
                        AccessibilityEvent accessibilityEventE5 = bVar2.e(fVar8.f19786b, i11);
                        accessibilityEventE5.getText().add(fVar8.f19801p);
                        bVar2.i(accessibilityEventE5);
                    }
                }
                f fVar10 = bVar2.f19718n;
                if (fVar10 != null && (i13 = fVar10.f19786b) == (i14 = fVar8.f19786b) && ((fVar2 = bVar2.f19719o) == null || fVar2.f19786b != i13)) {
                    bVar2.f19719o = fVar10;
                    bVar2.i(bVar2.e(i14, 8));
                } else if (fVar10 == null) {
                    bVar2.f19719o = null;
                }
                f fVar11 = bVar2.f19718n;
                if (fVar11 == null || fVar11.f19786b != fVar8.f19786b) {
                    i12 = i9;
                } else {
                    i12 = i9;
                    if ((fVar8.f19765F & ((long) W5.f.g(5))) != 0 && fVar8.g(5) && ((fVar = bVar2.f19714i) == null || fVar.f19786b == bVar2.f19718n.f19786b)) {
                        String str2 = fVar8.f19770K;
                        if (str2 == null) {
                            str2 = "";
                        }
                        String str3 = fVar8.f19803r;
                        String str4 = str3 != null ? str3 : "";
                        AccessibilityEvent accessibilityEventE6 = bVar2.e(fVar8.f19786b, 16);
                        accessibilityEventE6.setBeforeText(str2);
                        accessibilityEventE6.getText().add(str4);
                        int i31 = 0;
                        while (i31 < str2.length() && i31 < str4.length() && str2.charAt(i31) == str4.charAt(i31)) {
                            i31++;
                        }
                        if (i31 < str2.length() || i31 < str4.length()) {
                            accessibilityEventE6.setFromIndex(i31);
                            int length = str2.length() - i12;
                            int length2 = str4.length() - i12;
                            while (length >= i31 && length2 >= i31 && str2.charAt(length) == str4.charAt(length2)) {
                                length--;
                                length2--;
                            }
                            accessibilityEventE6.setRemovedCount((length - i31) + i12);
                            accessibilityEventE6.setAddedCount((length2 - i31) + i12);
                        } else {
                            accessibilityEventE6 = null;
                        }
                        if (accessibilityEventE6 != null) {
                            bVar2.i(accessibilityEventE6);
                        }
                        if (fVar8.f19767H != fVar8.f19793g || fVar8.f19768I != fVar8.f19794h) {
                            AccessibilityEvent accessibilityEventE7 = bVar2.e(fVar8.f19786b, 8192);
                            accessibilityEventE7.getText().add(str4);
                            accessibilityEventE7.setFromIndex(fVar8.f19793g);
                            accessibilityEventE7.setToIndex(fVar8.f19794h);
                            accessibilityEventE7.setItemCount(str4.length());
                            bVar2.i(accessibilityEventE7);
                        }
                    }
                    i9 = i12;
                    i26 = OpusCodecConfig.APPLICATION_VOIP;
                    i27 = 0;
                    i11 = 4;
                    i10 = 14;
                }
                i9 = i12;
                i26 = OpusCodecConfig.APPLICATION_VOIP;
                i27 = 0;
                i11 = 4;
                i10 = 14;
            }
        }
    }

    /* JADX INFO: renamed from: io.flutter.view.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccessibilityBridge.java */
    public class AccessibilityManagerAccessibilityStateChangeListenerC0218b implements AccessibilityManager.AccessibilityStateChangeListener {
        public AccessibilityManagerAccessibilityStateChangeListenerC0218b() {
        }

        @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
        public final void onAccessibilityStateChanged(boolean z8) {
            b bVar = b.this;
            if (bVar.f19724u) {
                return;
            }
            boolean z9 = false;
            p088l7.a aVar = bVar.f19707b;
            if (z8) {
                aVar.f20109b.setSemanticsEnabled(true);
            } else {
                bVar.j(false);
                aVar.f20109b.setSemanticsEnabled(false);
            }
            FlutterView.a aVar2 = bVar.f19723s;
            if (aVar2 != null) {
                boolean zIsTouchExplorationEnabled = bVar.f19708c.isTouchExplorationEnabled();
                int i9 = FlutterView.f19344D;
                FlutterView flutterView = FlutterView.this;
                if (flutterView.j.f19408b.f19448a.getIsSoftwareRenderingEnabled()) {
                    flutterView.setWillNotDraw(false);
                    return;
                }
                if (!z8 && !zIsTouchExplorationEnabled) {
                    z9 = true;
                }
                flutterView.setWillNotDraw(z9);
            }
        }
    }

    /* JADX INFO: compiled from: AccessibilityBridge.java */
    public enum d {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(OpusCodecConfig.APPLICATION_VOIP),
        COPY(4096),
        CUT(8192),
        PASTE(Http2.INITIAL_MAX_FRAME_SIZE),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(MiPushSdk.FLAG_IS_PHONE_SUPPORT_EXTENSION),
        MOVE_CURSOR_FORWARD_BY_WORD(MiPushSdk.FLAG_SUPPORT_CALLKIT),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152),
        /* JADX INFO: Fake field, exist only in values array */
        FOCUS(4194304),
        /* JADX INFO: Fake field, exist only in values array */
        SCROLL_TO_OFFSET(8388608),
        EXPAND(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE),
        COLLAPSE(33554432);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f19754a;

        d(int i9) {
            this.f19754a = i9;
        }
    }

    /* JADX INFO: compiled from: AccessibilityBridge.java */
    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19755a = -1;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19756b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19757c = -1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f19758d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f19759e;
    }

    /* JADX INFO: compiled from: AccessibilityBridge.java */
    public static class f {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public String f19760A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public String f19761B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public int f19762C;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public long f19765F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public int f19766G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public int f19767H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public int f19768I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public float f19769J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public String f19770K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public String f19771L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public float f19772M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public float f19773N;
        public float O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public float f19774P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public float[] f19775Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public float[] f19776R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public f f19777S;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public ArrayList f19780V;

        /* JADX INFO: renamed from: W, reason: collision with root package name */
        public e f19781W;

        /* JADX INFO: renamed from: X, reason: collision with root package name */
        public e f19782X;

        /* JADX INFO: renamed from: Z, reason: collision with root package name */
        public float[] f19784Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f19785a;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public float[] f19787b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f19788c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public Rect f19789c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19790d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f19791e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19792f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f19793g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f19794h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19795i;
        public int j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f19796k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public float f19797l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public float f19798m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float f19799n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f19800o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public String f19801p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public ArrayList f19802q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public String f19803r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public ArrayList f19804s;
        public String t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public ArrayList f19805u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public String f19806v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public ArrayList f19807w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public String f19808x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public ArrayList f19809y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public String f19810z;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19786b = -1;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public int f19763D = -1;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public boolean f19764E = false;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public final ArrayList f19778T = new ArrayList();

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public final ArrayList f19779U = new ArrayList();

        /* JADX INFO: renamed from: Y, reason: collision with root package name */
        public boolean f19783Y = true;
        public boolean a0 = true;

        public f(b bVar) {
            this.f19785a = bVar;
        }

        public static boolean a(f fVar, d dVar) {
            return (fVar.f19790d & dVar.f19754a) != 0;
        }

        public static CharSequence b(f fVar) {
            io.flutter.view.d dVar = new io.flutter.view.d();
            dVar.f19813a = fVar.f19803r;
            dVar.f19814b = fVar.f19804s;
            dVar.f19815c = fVar.d();
            SpannableString spannableStringA = dVar.a();
            io.flutter.view.d dVar2 = new io.flutter.view.d();
            dVar2.f19813a = fVar.f19801p;
            dVar2.f19814b = fVar.f19802q;
            dVar2.f19816d = fVar.f19760A;
            dVar2.f19815c = fVar.d();
            SpannableString spannableStringA2 = dVar2.a();
            io.flutter.view.d dVar3 = new io.flutter.view.d();
            dVar3.f19813a = fVar.f19808x;
            dVar3.f19814b = fVar.f19809y;
            dVar3.f19815c = fVar.d();
            CharSequence[] charSequenceArr = {spannableStringA, spannableStringA2, dVar3.a()};
            CharSequence charSequenceConcat = null;
            for (int i9 = 0; i9 < 3; i9++) {
                CharSequence charSequence = charSequenceArr[i9];
                if (charSequence != null && charSequence.length() > 0) {
                    charSequenceConcat = (charSequenceConcat == null || charSequenceConcat.length() == 0) ? charSequence : TextUtils.concat(charSequenceConcat, ", ", charSequence);
                }
            }
            return charSequenceConcat;
        }

        public static ArrayList f(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
            int i9 = byteBuffer.getInt();
            if (i9 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i9);
            for (int i10 = 0; i10 < i9; i10++) {
                int i11 = byteBuffer.getInt();
                int i12 = byteBuffer.getInt();
                io.flutter.view.d.EnumC0219d enumC0219d = io.flutter.view.d.EnumC0219d.values()[byteBuffer.getInt()];
                int iOrdinal = enumC0219d.ordinal();
                if (iOrdinal == 0) {
                    byteBuffer.getInt();
                    io.flutter.view.d.b bVar = new io.flutter.view.d.b();
                    bVar.f19818a = i11;
                    bVar.f19819b = i12;
                    bVar.f19820c = enumC0219d;
                    arrayList.add(bVar);
                } else if (iOrdinal == 1) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    io.flutter.view.d.a aVar = new io.flutter.view.d.a();
                    aVar.f19818a = i11;
                    aVar.f19819b = i12;
                    aVar.f19820c = enumC0219d;
                    aVar.f19817d = StandardCharsets.UTF_8.decode(byteBuffer2).toString();
                    arrayList.add(aVar);
                }
            }
            return arrayList;
        }

        public static void j(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f6 = fArr[3];
            fArr[0] = fArr[0] / f6;
            fArr[1] = fArr[1] / f6;
            fArr[2] = fArr[2] / f6;
            fArr[3] = 0.0f;
        }

        public final void c(ArrayList arrayList) {
            if (g(12)) {
                arrayList.add(this);
            }
            Iterator it = this.f19778T.iterator();
            while (it.hasNext()) {
                ((f) it.next()).c(arrayList);
            }
        }

        public final String d() {
            String str = this.f19761B;
            return (str == null || str.isEmpty()) ? this.f19785a.f19717m : this.f19761B;
        }

        public final String e() {
            String str;
            if (g(13) && (str = this.f19801p) != null && !str.isEmpty()) {
                return this.f19801p;
            }
            Iterator it = this.f19778T.iterator();
            while (it.hasNext()) {
                String strE = ((f) it.next()).e();
                if (strE != null && !strE.isEmpty()) {
                    return strE;
                }
            }
            return null;
        }

        public final boolean g(int i9) {
            return (this.f19788c & ((long) W5.f.g(i9))) != 0;
        }

        public final f h(float[] fArr, boolean z8) {
            float f6 = fArr[3];
            boolean z9 = false;
            float f9 = fArr[0] / f6;
            float f10 = fArr[1] / f6;
            if (f9 < this.f19772M || f9 >= this.O || f10 < this.f19773N || f10 >= this.f19774P) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (f fVar : this.f19779U) {
                if (!fVar.g(14)) {
                    if (fVar.f19783Y) {
                        fVar.f19783Y = false;
                        if (fVar.f19784Z == null) {
                            fVar.f19784Z = new float[16];
                        }
                        if (!Matrix.invertM(fVar.f19784Z, 0, fVar.f19776R, 0)) {
                            Arrays.fill(fVar.f19784Z, 0.0f);
                        }
                    }
                    float[] fArr3 = fArr;
                    Matrix.multiplyMV(fArr2, 0, fVar.f19784Z, 0, fArr3, 0);
                    f fVarH = fVar.h(fArr2, z8);
                    if (fVarH != null) {
                        return fVarH;
                    }
                    fArr = fArr3;
                }
            }
            if (z8 && this.f19795i != -1) {
                z9 = true;
            }
            if (i() || z9) {
                return this;
            }
            return null;
        }

        public final boolean i() {
            if (g(12)) {
                return false;
            }
            if (g(22)) {
                return true;
            }
            if (g(32)) {
                return false;
            }
            int i9 = this.f19790d;
            int i10 = b.f19705y;
            if ((i9 & (-61)) != 0 || (this.f19788c & ((long) 10682871)) != 0) {
                return true;
            }
            String str = this.f19801p;
            if (str != null && !str.isEmpty()) {
                return true;
            }
            String str2 = this.f19803r;
            if (str2 != null && !str2.isEmpty()) {
                return true;
            }
            String str3 = this.f19808x;
            return (str3 == null || str3.isEmpty()) ? false : true;
        }

        public final void k(float[] fArr, HashSet hashSet, boolean z8) {
            hashSet.add(this);
            if (this.a0) {
                z8 = true;
            }
            if (z8) {
                if (this.f19787b0 == null) {
                    this.f19787b0 = new float[16];
                }
                if (this.f19775Q == null) {
                    this.f19775Q = new float[16];
                }
                Matrix.multiplyMM(this.f19787b0, 0, fArr, 0, this.f19775Q, 0);
                float[] fArr2 = {this.f19772M, this.f19773N, 0.0f, 1.0f};
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                j(fArr3, this.f19787b0, fArr2);
                fArr2[0] = this.O;
                fArr2[1] = this.f19773N;
                j(fArr4, this.f19787b0, fArr2);
                fArr2[0] = this.O;
                fArr2[1] = this.f19774P;
                j(fArr5, this.f19787b0, fArr2);
                fArr2[0] = this.f19772M;
                fArr2[1] = this.f19774P;
                j(fArr6, this.f19787b0, fArr2);
                if (this.f19789c0 == null) {
                    this.f19789c0 = new Rect();
                }
                this.f19789c0.set(Math.round(Math.min(fArr3[0], Math.min(fArr4[0], Math.min(fArr5[0], fArr6[0])))), Math.round(Math.min(fArr3[1], Math.min(fArr4[1], Math.min(fArr5[1], fArr6[1])))), Math.round(Math.max(fArr3[0], Math.max(fArr4[0], Math.max(fArr5[0], fArr6[0])))), Math.round(Math.max(fArr3[1], Math.max(fArr4[1], Math.max(fArr5[1], fArr6[1])))));
                this.a0 = false;
            }
            int i9 = -1;
            for (f fVar : this.f19778T) {
                fVar.f19763D = i9;
                i9 = fVar.f19786b;
                fVar.k(this.f19787b0, hashSet, z8);
            }
        }
    }

    public b(View view, p088l7.a aVar, AccessibilityManager accessibilityManager, ContentResolver contentResolver, i iVar) {
        AccessibilityViewEmbedder accessibilityViewEmbedder = new AccessibilityViewEmbedder(view, 65536);
        this.f19712g = new HashMap();
        this.f19713h = new HashMap();
        this.f19716l = 0;
        this.f19721q = new ArrayList();
        this.f19722r = 0;
        this.t = false;
        this.f19724u = false;
        a aVar2 = new a();
        AccessibilityManagerAccessibilityStateChangeListenerC0218b accessibilityManagerAccessibilityStateChangeListenerC0218b = new AccessibilityManagerAccessibilityStateChangeListenerC0218b();
        this.f19725v = accessibilityManagerAccessibilityStateChangeListenerC0218b;
        c cVar = new c(new Handler());
        this.f19727x = cVar;
        this.f19706a = view;
        this.f19707b = aVar;
        this.f19708c = accessibilityManager;
        this.f19711f = contentResolver;
        this.f19709d = accessibilityViewEmbedder;
        this.f19710e = iVar;
        aVar.f20110c = aVar2;
        aVar.f20109b.setAccessibilityDelegate(aVar2);
        accessibilityManagerAccessibilityStateChangeListenerC0218b.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(accessibilityManagerAccessibilityStateChangeListenerC0218b);
        io.flutter.view.c cVar2 = new io.flutter.view.c(this, accessibilityManager);
        this.f19726w = cVar2;
        cVar2.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(cVar2);
        this.f19716l |= 128;
        cVar.onChange(false, null);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, cVar);
        if (Build.VERSION.SDK_INT >= 31 && view != null && view.getResources() != null) {
            int i9 = view.getResources().getConfiguration().fontWeightAdjustment;
            if (i9 == Integer.MAX_VALUE || i9 < 300) {
                this.f19716l &= -9;
            } else {
                this.f19716l |= 8;
            }
            aVar.f20109b.setAccessibilityFeatures(this.f19716l);
        }
        iVar.b(this);
    }

    public static String d(ByteBuffer byteBuffer, String[] strArr) {
        int i9 = byteBuffer.getInt();
        if (i9 == -1) {
            return null;
        }
        return strArr[i9];
    }

    @SuppressLint({"SwitchIntDef"})
    public final boolean a(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        AccessibilityViewEmbedder accessibilityViewEmbedder = this.f19709d;
        if (!accessibilityViewEmbedder.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = accessibilityViewEmbedder.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 8) {
            this.f19715k = recordFlutterId;
            this.f19718n = null;
            return true;
        }
        if (eventType == 128) {
            this.f19720p = null;
            return true;
        }
        if (eventType == 32768) {
            this.j = recordFlutterId;
            this.f19714i = null;
            return true;
        }
        if (eventType != 65536) {
            return true;
        }
        this.f19715k = null;
        this.j = null;
        return true;
    }

    public final e b(int i9) {
        HashMap map = this.f19713h;
        e eVar = (e) map.get(Integer.valueOf(i9));
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        eVar2.f19756b = i9;
        eVar2.f19755a = 267386881 + i9;
        map.put(Integer.valueOf(i9), eVar2);
        return eVar2;
    }

    public final f c(int i9) {
        HashMap map = this.f19712g;
        f fVar = (f) map.get(Integer.valueOf(i9));
        if (fVar != null) {
            return fVar;
        }
        f fVar2 = new f(this);
        fVar2.f19786b = i9;
        map.put(Integer.valueOf(i9), fVar2);
        return fVar2;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    @SuppressLint({"NewApi"})
    public final AccessibilityNodeInfo createAccessibilityNodeInfo(int i9) {
        boolean zG;
        String str;
        int i10;
        int i11;
        j(true);
        AccessibilityViewEmbedder accessibilityViewEmbedder = this.f19709d;
        if (i9 >= 65536) {
            return accessibilityViewEmbedder.createAccessibilityNodeInfo(i9);
        }
        HashMap map = this.f19712g;
        View view = this.f19706a;
        if (i9 == -1) {
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(view);
            view.onInitializeAccessibilityNodeInfo(accessibilityNodeInfoObtain);
            if (map.containsKey(0)) {
                accessibilityNodeInfoObtain.addChild(view, 0);
            }
            accessibilityNodeInfoObtain.setImportantForAccessibility(false);
            return accessibilityNodeInfoObtain;
        }
        f fVar = (f) map.get(Integer.valueOf(i9));
        if (fVar != null) {
            int i12 = fVar.f19795i;
            i iVar = this.f19710e;
            if (i12 == -1 || !iVar.f(i12)) {
                AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain(view, i9);
                accessibilityNodeInfoObtain2.setImportantForAccessibility((fVar.g(12) || (f.b(fVar) == null && fVar.f19790d == 0)) ? false : true);
                accessibilityNodeInfoObtain2.setViewIdResourceName("");
                String str2 = fVar.f19800o;
                if (str2 != null) {
                    accessibilityNodeInfoObtain2.setViewIdResourceName(str2);
                }
                accessibilityNodeInfoObtain2.setPackageName(view.getContext().getPackageName());
                accessibilityNodeInfoObtain2.setClassName("android.view.View");
                accessibilityNodeInfoObtain2.setSource(view, i9);
                accessibilityNodeInfoObtain2.setFocusable(fVar.i());
                f fVar2 = this.f19718n;
                if (fVar2 != null) {
                    accessibilityNodeInfoObtain2.setFocused(fVar2.f19786b == i9);
                }
                f fVar3 = this.f19714i;
                if (fVar3 != null) {
                    accessibilityNodeInfoObtain2.setAccessibilityFocused(fVar3.f19786b == i9);
                }
                if (fVar.g(5)) {
                    accessibilityNodeInfoObtain2.setPassword(fVar.g(11));
                    if (!fVar.g(21)) {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.EditText");
                    }
                    accessibilityNodeInfoObtain2.setEditable(!fVar.g(21));
                    int i13 = fVar.f19793g;
                    if (i13 != -1 && (i11 = fVar.f19794h) != -1) {
                        accessibilityNodeInfoObtain2.setTextSelection(i13, i11);
                    }
                    f fVar4 = this.f19714i;
                    if (fVar4 != null && fVar4.f19786b == i9) {
                        accessibilityNodeInfoObtain2.setLiveRegion(1);
                    }
                    if (f.a(fVar, d.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                        accessibilityNodeInfoObtain2.addAction(256);
                        i10 = 1;
                    } else {
                        i10 = 0;
                    }
                    if (f.a(fVar, d.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                        accessibilityNodeInfoObtain2.addAction(512);
                        i10 = 1;
                    }
                    if (f.a(fVar, d.MOVE_CURSOR_FORWARD_BY_WORD)) {
                        accessibilityNodeInfoObtain2.addAction(256);
                        i10 |= 2;
                    }
                    if (f.a(fVar, d.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                        accessibilityNodeInfoObtain2.addAction(512);
                        i10 |= 2;
                    }
                    accessibilityNodeInfoObtain2.setMovementGranularities(i10);
                    if (fVar.f19791e >= 0) {
                        String str3 = fVar.f19803r;
                        accessibilityNodeInfoObtain2.setMaxTextLength(((str3 == null ? 0 : str3.length()) - fVar.f19792f) + fVar.f19791e);
                    }
                }
                if (f.a(fVar, d.SET_SELECTION)) {
                    accessibilityNodeInfoObtain2.addAction(131072);
                }
                if (f.a(fVar, d.COPY)) {
                    accessibilityNodeInfoObtain2.addAction(Http2.INITIAL_MAX_FRAME_SIZE);
                }
                if (f.a(fVar, d.CUT)) {
                    accessibilityNodeInfoObtain2.addAction(65536);
                }
                if (f.a(fVar, d.PASTE)) {
                    accessibilityNodeInfoObtain2.addAction(32768);
                }
                if (f.a(fVar, d.SET_TEXT)) {
                    accessibilityNodeInfoObtain2.addAction(2097152);
                }
                if (fVar.g(4)) {
                    zG = true;
                } else {
                    String str4 = fVar.f19760A;
                    zG = (str4 == null || str4.isEmpty()) ? fVar.g(23) : false;
                }
                if (zG) {
                    accessibilityNodeInfoObtain2.setClassName("android.widget.Button");
                }
                if (fVar.g(15)) {
                    accessibilityNodeInfoObtain2.setClassName("android.widget.ImageView");
                }
                if (f.a(fVar, d.DISMISS)) {
                    accessibilityNodeInfoObtain2.setDismissable(true);
                    accessibilityNodeInfoObtain2.addAction(1048576);
                }
                f fVar5 = fVar.f19777S;
                if (fVar5 != null) {
                    accessibilityNodeInfoObtain2.setParent(view, fVar5.f19786b);
                } else {
                    accessibilityNodeInfoObtain2.setParent(view);
                }
                int i14 = fVar.f19763D;
                if (i14 != -1) {
                    accessibilityNodeInfoObtain2.setTraversalAfter(view, i14);
                }
                Rect rect = fVar.f19789c0;
                f fVar6 = fVar.f19777S;
                if (fVar6 != null) {
                    Rect rect2 = fVar6.f19789c0;
                    Rect rect3 = new Rect(rect);
                    rect3.offset(-rect2.left, -rect2.top);
                    accessibilityNodeInfoObtain2.setBoundsInParent(rect3);
                } else {
                    accessibilityNodeInfoObtain2.setBoundsInParent(rect);
                }
                Rect rect4 = new Rect(rect);
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                rect4.offset(iArr[0], iArr[1]);
                accessibilityNodeInfoObtain2.setBoundsInScreen(rect4);
                accessibilityNodeInfoObtain2.setVisibleToUser(true);
                accessibilityNodeInfoObtain2.setEnabled(!fVar.g(7) || fVar.g(8));
                if (f.a(fVar, d.TAP)) {
                    if (fVar.f19781W != null) {
                        accessibilityNodeInfoObtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, fVar.f19781W.f19759e));
                        accessibilityNodeInfoObtain2.setClickable(true);
                    } else {
                        accessibilityNodeInfoObtain2.addAction(16);
                        accessibilityNodeInfoObtain2.setClickable(true);
                    }
                } else if (fVar.g(24)) {
                    accessibilityNodeInfoObtain2.addAction(16);
                    accessibilityNodeInfoObtain2.setClickable(true);
                }
                if (f.a(fVar, d.LONG_PRESS)) {
                    if (fVar.f19782X != null) {
                        accessibilityNodeInfoObtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, fVar.f19782X.f19759e));
                        accessibilityNodeInfoObtain2.setLongClickable(true);
                    } else {
                        accessibilityNodeInfoObtain2.addAction(32);
                        accessibilityNodeInfoObtain2.setLongClickable(true);
                    }
                }
                d dVar = d.SCROLL_LEFT;
                boolean zA = f.a(fVar, dVar);
                d dVar2 = d.SCROLL_DOWN;
                d dVar3 = d.SCROLL_UP;
                d dVar4 = d.SCROLL_RIGHT;
                if (zA || f.a(fVar, dVar3) || f.a(fVar, dVar4) || f.a(fVar, dVar2)) {
                    accessibilityNodeInfoObtain2.setScrollable(true);
                    if (fVar.g(19)) {
                        if (f.a(fVar, dVar) || f.a(fVar, dVar4)) {
                            accessibilityNodeInfoObtain2.setClassName("android.widget.HorizontalScrollView");
                        } else {
                            accessibilityNodeInfoObtain2.setClassName("android.widget.ScrollView");
                        }
                    }
                }
                if (k(fVar)) {
                    if (f.a(fVar, dVar) || f.a(fVar, dVar4)) {
                        if (Build.VERSION.SDK_INT < 33) {
                            accessibilityNodeInfoObtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(1, fVar.j, false));
                        } else {
                            accessibilityNodeInfoObtain2.setCollectionInfo(K0.b.l(fVar.j));
                        }
                    } else if (Build.VERSION.SDK_INT < 33) {
                        accessibilityNodeInfoObtain2.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(fVar.j, 1, false));
                    } else {
                        accessibilityNodeInfoObtain2.setCollectionInfo(K0.a.k(fVar.j));
                    }
                }
                f fVar7 = fVar.f19777S;
                if (fVar7 != null && k(fVar7) && fVar.f19777S.g(19)) {
                    f fVar8 = fVar.f19777S;
                    ArrayList arrayList = fVar8.f19778T;
                    boolean z8 = (f.a(fVar8, dVar) || f.a(fVar8, dVar4)) ? false : true;
                    int iIndexOf = arrayList.indexOf(fVar);
                    if (z8) {
                        if (Build.VERSION.SDK_INT < 33) {
                            accessibilityNodeInfoObtain2.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(iIndexOf, 1, 0, 1, fVar.g(10)));
                        } else {
                            accessibilityNodeInfoObtain2.setCollectionItemInfo(K0.c.k(iIndexOf, fVar.g(10)));
                        }
                    } else if (Build.VERSION.SDK_INT < 33) {
                        accessibilityNodeInfoObtain2.setCollectionItemInfo(AccessibilityNodeInfo.CollectionItemInfo.obtain(0, 1, iIndexOf, 1, fVar.g(10)));
                    } else {
                        accessibilityNodeInfoObtain2.setCollectionItemInfo(K0.a.l(iIndexOf, fVar.g(10)));
                    }
                }
                if (f.a(fVar, dVar) || f.a(fVar, dVar3)) {
                    accessibilityNodeInfoObtain2.addAction(4096);
                }
                if (f.a(fVar, dVar4) || f.a(fVar, dVar2)) {
                    accessibilityNodeInfoObtain2.addAction(8192);
                }
                d dVar5 = d.INCREASE;
                boolean zA2 = f.a(fVar, dVar5);
                d dVar6 = d.DECREASE;
                if (zA2 || f.a(fVar, dVar6)) {
                    accessibilityNodeInfoObtain2.setClassName("android.widget.SeekBar");
                    if (f.a(fVar, dVar5)) {
                        accessibilityNodeInfoObtain2.addAction(4096);
                    }
                    if (f.a(fVar, dVar6)) {
                        accessibilityNodeInfoObtain2.addAction(8192);
                    }
                }
                if (fVar.g(16)) {
                    accessibilityNodeInfoObtain2.setLiveRegion(1);
                }
                if (fVar.g(5)) {
                    io.flutter.view.d dVar7 = new io.flutter.view.d();
                    dVar7.f19813a = fVar.f19803r;
                    dVar7.f19814b = fVar.f19804s;
                    dVar7.f19815c = fVar.d();
                    accessibilityNodeInfoObtain2.setText(dVar7.a());
                    if (Build.VERSION.SDK_INT >= 28) {
                        io.flutter.view.d dVar8 = new io.flutter.view.d();
                        dVar8.f19813a = fVar.f19801p;
                        dVar8.f19814b = fVar.f19802q;
                        dVar8.f19816d = fVar.f19760A;
                        dVar8.f19815c = fVar.d();
                        SpannableString spannableStringA = dVar8.a();
                        io.flutter.view.d dVar9 = new io.flutter.view.d();
                        dVar9.f19813a = fVar.f19808x;
                        dVar9.f19814b = fVar.f19809y;
                        dVar9.f19815c = fVar.d();
                        CharSequence[] charSequenceArr = {spannableStringA, dVar9.a()};
                        int i15 = 0;
                        CharSequence charSequence = null;
                        for (int i16 = 2; i15 < i16; i16 = 2) {
                            CharSequence charSequenceConcat = charSequenceArr[i15];
                            if (charSequenceConcat != null && charSequenceConcat.length() > 0) {
                                if (charSequence != null && charSequence.length() != 0) {
                                    charSequenceConcat = TextUtils.concat(charSequence, ", ", charSequenceConcat);
                                }
                                charSequence = charSequenceConcat;
                            }
                            i15++;
                        }
                        accessibilityNodeInfoObtain2.setHintText(charSequence);
                    }
                } else if (!fVar.g(12)) {
                    CharSequence charSequenceB = f.b(fVar);
                    if (Build.VERSION.SDK_INT < 28 && fVar.f19810z != null) {
                        charSequenceB = ((Object) (charSequenceB != null ? charSequenceB : "")) + "\n" + fVar.f19810z;
                    }
                    if (charSequenceB != null) {
                        accessibilityNodeInfoObtain2.setContentDescription(charSequenceB);
                    }
                }
                int i17 = Build.VERSION.SDK_INT;
                if (i17 >= 28 && (str = fVar.f19810z) != null) {
                    accessibilityNodeInfoObtain2.setTooltipText(str);
                    if (f.b(fVar) == null) {
                        accessibilityNodeInfoObtain2.setContentDescription(fVar.f19810z);
                    }
                }
                boolean zG2 = fVar.g(1);
                boolean zG3 = fVar.g(17);
                accessibilityNodeInfoObtain2.setCheckable(zG2 || zG3);
                if (zG2) {
                    accessibilityNodeInfoObtain2.setChecked(fVar.g(2));
                    if (fVar.g(9)) {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.RadioButton");
                    } else {
                        accessibilityNodeInfoObtain2.setClassName("android.widget.CheckBox");
                    }
                } else if (zG3) {
                    accessibilityNodeInfoObtain2.setChecked(fVar.g(18));
                    accessibilityNodeInfoObtain2.setClassName("android.widget.Switch");
                }
                accessibilityNodeInfoObtain2.setSelected(fVar.g(3));
                if (i17 >= 36 && fVar.g(27)) {
                    accessibilityNodeInfoObtain2.setExpandedState(fVar.g(28) ? 3 : 1);
                    if (f.a(fVar, d.EXPAND)) {
                        accessibilityNodeInfoObtain2.addAction(MiPushSdk.FLAG_IS_PHONE_SUPPORT_EXTENSION);
                    }
                    if (f.a(fVar, d.COLLAPSE)) {
                        accessibilityNodeInfoObtain2.addAction(MiPushSdk.FLAG_SUPPORT_CALLKIT);
                    }
                }
                if (i17 >= 28) {
                    accessibilityNodeInfoObtain2.setHeading(fVar.f19762C > 0);
                }
                f fVar9 = this.f19714i;
                if (fVar9 == null || fVar9.f19786b != i9) {
                    accessibilityNodeInfoObtain2.addAction(64);
                } else {
                    accessibilityNodeInfoObtain2.addAction(128);
                }
                ArrayList<e> arrayList2 = fVar.f19780V;
                if (arrayList2 != null) {
                    for (e eVar : arrayList2) {
                        accessibilityNodeInfoObtain2.addAction(new AccessibilityNodeInfo.AccessibilityAction(eVar.f19755a, eVar.f19758d));
                    }
                }
                for (f fVar10 : fVar.f19778T) {
                    if (!fVar10.g(14)) {
                        int i18 = fVar10.f19795i;
                        if (i18 != -1) {
                            View viewH = iVar.h(i18);
                            if (!iVar.f(fVar10.f19795i) && viewH != null) {
                                viewH.setImportantForAccessibility(0);
                                accessibilityNodeInfoObtain2.addChild(viewH);
                            }
                        }
                        accessibilityNodeInfoObtain2.addChild(view, fVar10.f19786b);
                    }
                }
                return accessibilityNodeInfoObtain2;
            }
            View viewH2 = iVar.h(fVar.f19795i);
            if (viewH2 != null) {
                return accessibilityViewEmbedder.getRootNode(viewH2, fVar.f19786b, fVar.f19789c0);
            }
        }
        return null;
    }

    public final AccessibilityEvent e(int i9, int i10) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i10);
        View view = this.f19706a;
        accessibilityEventObtain.setPackageName(view.getContext().getPackageName());
        accessibilityEventObtain.setSource(view, i9);
        return accessibilityEventObtain;
    }

    public final boolean f(MotionEvent motionEvent, boolean z8) {
        f fVarH;
        if (this.f19708c.isTouchExplorationEnabled()) {
            HashMap map = this.f19712g;
            if (!map.isEmpty()) {
                f fVarH2 = ((f) map.get(0)).h(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f}, z8);
                if (fVarH2 == null || fVarH2.f19795i == -1) {
                    if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
                        float x8 = motionEvent.getX();
                        float y8 = motionEvent.getY();
                        if (!map.isEmpty() && (fVarH = ((f) map.get(0)).h(new float[]{x8, y8, 0.0f, 1.0f}, z8)) != this.f19720p) {
                            if (fVarH != null) {
                                h(fVarH.f19786b, 128);
                            }
                            f fVar = this.f19720p;
                            if (fVar != null) {
                                h(fVar.f19786b, 256);
                            }
                            this.f19720p = fVarH;
                        }
                    } else {
                        if (motionEvent.getAction() != 10) {
                            motionEvent.toString();
                            return false;
                        }
                        f fVar2 = this.f19720p;
                        if (fVar2 != null) {
                            h(fVar2.f19786b, 256);
                            this.f19720p = null;
                        }
                    }
                    return true;
                }
                if (!z8) {
                    return this.f19709d.onAccessibilityHoverEvent(fVarH2.f19786b, motionEvent);
                }
            }
        }
        return false;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final AccessibilityNodeInfo findFocus(int i9) {
        if (i9 == 1) {
            f fVar = this.f19718n;
            if (fVar != null) {
                return createAccessibilityNodeInfo(fVar.f19786b);
            }
            Integer num = this.f19715k;
            if (num != null) {
                return createAccessibilityNodeInfo(num.intValue());
            }
        } else if (i9 != 2) {
            return null;
        }
        f fVar2 = this.f19714i;
        if (fVar2 != null) {
            return createAccessibilityNodeInfo(fVar2.f19786b);
        }
        Integer num2 = this.j;
        if (num2 != null) {
            return createAccessibilityNodeInfo(num2.intValue());
        }
        return null;
    }

    public final boolean g(f fVar, int i9, Bundle bundle, boolean z8) {
        int i10;
        int i11 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z9 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i12 = fVar.f19793g;
        int i13 = fVar.f19794h;
        if (i13 >= 0 && i12 >= 0) {
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 4) {
                        if (i11 == 8 || i11 == 16) {
                            if (z8) {
                                fVar.f19794h = fVar.f19803r.length();
                            } else {
                                fVar.f19794h = 0;
                            }
                        }
                    } else if (z8 && i13 < fVar.f19803r.length()) {
                        Matcher matcher = Pattern.compile("(?!^)(\\n)").matcher(fVar.f19803r.substring(fVar.f19794h));
                        if (matcher.find()) {
                            fVar.f19794h += matcher.start(1);
                        } else {
                            fVar.f19794h = fVar.f19803r.length();
                        }
                    } else if (!z8 && fVar.f19794h > 0) {
                        Matcher matcher2 = Pattern.compile("(?s:.*)(\\n)").matcher(fVar.f19803r.substring(0, fVar.f19794h));
                        if (matcher2.find()) {
                            fVar.f19794h = matcher2.start(1);
                        } else {
                            fVar.f19794h = 0;
                        }
                    }
                } else if (z8 && i13 < fVar.f19803r.length()) {
                    Matcher matcher3 = Pattern.compile("\\p{L}(\\b)").matcher(fVar.f19803r.substring(fVar.f19794h));
                    matcher3.find();
                    if (matcher3.find()) {
                        fVar.f19794h += matcher3.start(1);
                    } else {
                        fVar.f19794h = fVar.f19803r.length();
                    }
                } else if (!z8 && fVar.f19794h > 0) {
                    Matcher matcher4 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher(fVar.f19803r.substring(0, fVar.f19794h));
                    if (matcher4.find()) {
                        fVar.f19794h = matcher4.start(1);
                    }
                }
            } else if (z8 && i13 < fVar.f19803r.length()) {
                fVar.f19794h++;
            } else if (!z8 && (i10 = fVar.f19794h) > 0) {
                fVar.f19794h = i10 - 1;
            }
            if (!z9) {
                fVar.f19793g = fVar.f19794h;
            }
        }
        if (i12 != fVar.f19793g || i13 != fVar.f19794h) {
            String str = fVar.f19803r;
            if (str == null) {
                str = "";
            }
            AccessibilityEvent accessibilityEventE = e(fVar.f19786b, 8192);
            accessibilityEventE.getText().add(str);
            accessibilityEventE.setFromIndex(fVar.f19793g);
            accessibilityEventE.setToIndex(fVar.f19794h);
            accessibilityEventE.setItemCount(str.length());
            i(accessibilityEventE);
        }
        p088l7.a aVar = this.f19707b;
        if (i11 == 1) {
            if (z8) {
                d dVar = d.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (f.a(fVar, dVar)) {
                    aVar.b(i9, dVar, Boolean.valueOf(z9));
                    return true;
                }
            }
            if (!z8) {
                d dVar2 = d.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
                if (f.a(fVar, dVar2)) {
                    aVar.b(i9, dVar2, Boolean.valueOf(z9));
                    return true;
                }
            }
        } else if (i11 == 2) {
            if (z8) {
                d dVar3 = d.MOVE_CURSOR_FORWARD_BY_WORD;
                if (f.a(fVar, dVar3)) {
                    aVar.b(i9, dVar3, Boolean.valueOf(z9));
                    return true;
                }
            }
            if (!z8) {
                d dVar4 = d.MOVE_CURSOR_BACKWARD_BY_WORD;
                if (f.a(fVar, dVar4)) {
                    aVar.b(i9, dVar4, Boolean.valueOf(z9));
                    return true;
                }
            }
        } else if (i11 == 4 || i11 == 8 || i11 == 16) {
            return true;
        }
        return false;
    }

    public final void h(int i9, int i10) {
        if (this.f19708c.isEnabled()) {
            i(e(i9, i10));
        }
    }

    public final void i(AccessibilityEvent accessibilityEvent) {
        if (this.f19708c.isEnabled()) {
            View view = this.f19706a;
            view.getParent().requestSendAccessibilityEvent(view, accessibilityEvent);
        }
    }

    public final void j(boolean z8) {
        if (this.t == z8) {
            return;
        }
        this.t = z8;
        if (z8) {
            this.f19716l |= 1;
        } else {
            this.f19716l &= -2;
        }
        this.f19707b.f20109b.setAccessibilityFeatures(this.f19716l);
    }

    public final boolean k(f fVar) {
        if (fVar.j > 1) {
            f fVar2 = this.f19714i;
            f fVar3 = null;
            if (fVar2 != null) {
                f fVar4 = fVar2.f19777S;
                while (true) {
                    if (fVar4 == null) {
                        fVar4 = null;
                        break;
                    }
                    if (fVar4 == fVar) {
                        break;
                    }
                    fVar4 = fVar4.f19777S;
                }
                if (fVar4 != null) {
                    return true;
                }
            }
            f fVar5 = this.f19714i;
            io.flutter.view.a aVar = new io.flutter.view.a();
            if (fVar5 != null) {
                for (f fVar6 = fVar5.f19777S; fVar6 != null; fVar6 = fVar6.f19777S) {
                    if (aVar.test(fVar6)) {
                        fVar3 = fVar6;
                        break;
                    }
                }
                if (fVar3 != null) {
                }
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    public final boolean performAction(int i9, int i10, Bundle bundle) {
        if (i9 >= 65536) {
            boolean zPerformAction = this.f19709d.performAction(i9, i10, bundle);
            if (zPerformAction && i10 == 128) {
                this.j = null;
            }
            return zPerformAction;
        }
        HashMap map = this.f19712g;
        f fVar = (f) map.get(Integer.valueOf(i9));
        if (fVar != null) {
            d dVar = d.INCREASE;
            d dVar2 = d.DECREASE;
            p088l7.a aVar = this.f19707b;
            switch (i10) {
                case 16:
                    aVar.a(i9, d.TAP);
                    return true;
                case 32:
                    aVar.a(i9, d.LONG_PRESS);
                    return true;
                case 64:
                    if (this.f19714i == null) {
                        this.f19706a.invalidate();
                    }
                    this.f19714i = fVar;
                    aVar.a(i9, d.DID_GAIN_ACCESSIBILITY_FOCUS);
                    HashMap map2 = new HashMap();
                    map2.put("type", "didGainFocus");
                    map2.put("nodeId", Integer.valueOf(fVar.f19786b));
                    aVar.f20108a.a(map2, null);
                    h(i9, 32768);
                    if (!f.a(fVar, dVar) && !f.a(fVar, dVar2)) {
                        return true;
                    }
                    h(i9, 4);
                    return true;
                case 128:
                    f fVar2 = this.f19714i;
                    if (fVar2 != null && fVar2.f19786b == i9) {
                        this.f19714i = null;
                    }
                    Integer num = this.j;
                    if (num != null && num.intValue() == i9) {
                        this.j = null;
                    }
                    aVar.a(i9, d.DID_LOSE_ACCESSIBILITY_FOCUS);
                    h(i9, 65536);
                    return true;
                case 256:
                    return g(fVar, i9, bundle, true);
                case 512:
                    return g(fVar, i9, bundle, false);
                case 4096:
                    d dVar3 = d.SCROLL_UP;
                    if (f.a(fVar, dVar3)) {
                        aVar.a(i9, dVar3);
                        return true;
                    }
                    d dVar4 = d.SCROLL_LEFT;
                    if (f.a(fVar, dVar4)) {
                        aVar.a(i9, dVar4);
                        return true;
                    }
                    if (f.a(fVar, dVar)) {
                        fVar.f19803r = fVar.t;
                        fVar.f19804s = fVar.f19805u;
                        h(i9, 4);
                        aVar.a(i9, dVar);
                        return true;
                    }
                    break;
                case 8192:
                    d dVar5 = d.SCROLL_DOWN;
                    if (f.a(fVar, dVar5)) {
                        aVar.a(i9, dVar5);
                        return true;
                    }
                    d dVar6 = d.SCROLL_RIGHT;
                    if (f.a(fVar, dVar6)) {
                        aVar.a(i9, dVar6);
                        return true;
                    }
                    if (f.a(fVar, dVar2)) {
                        fVar.f19803r = fVar.f19806v;
                        fVar.f19804s = fVar.f19807w;
                        h(i9, 4);
                        aVar.a(i9, dVar2);
                        return true;
                    }
                    break;
                case Http2.INITIAL_MAX_FRAME_SIZE /* 16384 */:
                    aVar.a(i9, d.COPY);
                    return true;
                case 32768:
                    aVar.a(i9, d.PASTE);
                    return true;
                case 65536:
                    aVar.a(i9, d.CUT);
                    return true;
                case 131072:
                    HashMap map3 = new HashMap();
                    if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                        map3.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                        map3.put("extent", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT")));
                    } else {
                        map3.put("base", Integer.valueOf(fVar.f19794h));
                        map3.put("extent", Integer.valueOf(fVar.f19794h));
                    }
                    aVar.b(i9, d.SET_SELECTION, map3);
                    f fVar3 = (f) map.get(Integer.valueOf(i9));
                    fVar3.f19793g = ((Integer) map3.get("base")).intValue();
                    fVar3.f19794h = ((Integer) map3.get("extent")).intValue();
                    return true;
                case MiPushSdk.FLAG_IS_PHONE_SUPPORT_EXTENSION /* 262144 */:
                    aVar.a(i9, d.EXPAND);
                    return true;
                case MiPushSdk.FLAG_SUPPORT_CALLKIT /* 524288 */:
                    aVar.a(i9, d.COLLAPSE);
                    return true;
                case 1048576:
                    aVar.a(i9, d.DISMISS);
                    return true;
                case 2097152:
                    String string = (bundle == null || !bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) ? "" : bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
                    aVar.b(i9, d.SET_TEXT, string);
                    fVar.f19803r = string;
                    fVar.f19804s = null;
                    return true;
                case R.id.accessibilityActionShowOnScreen:
                    aVar.a(i9, d.SHOW_ON_SCREEN);
                    return true;
                default:
                    e eVar = (e) this.f19713h.get(Integer.valueOf(i10 - 267386881));
                    if (eVar != null) {
                        aVar.b(i9, d.CUSTOM_ACTION, Integer.valueOf(eVar.f19756b));
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    /* JADX INFO: compiled from: AccessibilityBridge.java */
    public class c extends ContentObserver {
        public c(Handler handler) {
            super(handler);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z8, Uri uri) {
            b bVar = b.this;
            if (bVar.f19724u) {
                return;
            }
            if (Settings.Global.getFloat(bVar.f19711f, "transition_animation_scale", 1.0f) == 0.0f) {
                bVar.f19716l |= 4;
            } else {
                bVar.f19716l &= -5;
            }
            bVar.f19707b.f20109b.setAccessibilityFeatures(bVar.f19716l);
        }

        @Override // android.database.ContentObserver
        public final void onChange(boolean z8) {
            onChange(z8, null);
        }
    }
}

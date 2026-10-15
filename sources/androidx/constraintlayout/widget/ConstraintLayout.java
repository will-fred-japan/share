package androidx.constraintlayout.widget;

import A.e;
import A.g;
import A.h;
import A.k;
import A.l;
import A.m;
import B.j;
import B.n;
import B.p;
import C.d;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.starburst.sdk.core.feed.FeedManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.internal.http2.Http2Connection;
import p197z.c;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f6805r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<View> f6806a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<ConstraintHelper> f6807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final h f6808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f6811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f6813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f6814i;
    public androidx.constraintlayout.widget.b j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C.a f6815k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f6816l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public HashMap<String, Integer> f6817m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final SparseArray<g> f6818n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f6819o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f6820p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f6821q;

    public class b implements B.b.InterfaceC0002b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ConstraintLayout f6883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f6885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6886d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6887e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6888f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f6889g;

        public b(ConstraintLayout constraintLayout) {
            this.f6883a = constraintLayout;
        }

        public static boolean a(int i9, int i10, int i11) {
            if (i9 == i10) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i9);
            View.MeasureSpec.getSize(i9);
            int mode2 = View.MeasureSpec.getMode(i10);
            int size = View.MeasureSpec.getSize(i10);
            if (mode2 == 1073741824) {
                return (mode == Integer.MIN_VALUE || mode == 0) && i11 == size;
            }
            return false;
        }

        @SuppressLint({"WrongCall"})
        public final void b(g gVar, B.b.a aVar) {
            int iMakeMeasureSpec;
            int iMakeMeasureSpec2;
            int iMax;
            int i9;
            boolean z8;
            int measuredWidth;
            int baseline;
            int i10;
            if (gVar == null) {
                return;
            }
            if (gVar.f1253c0 == 8 && !gVar.f1282z) {
                aVar.f1538e = 0;
                aVar.f1539f = 0;
                aVar.f1540g = 0;
                return;
            }
            if (gVar.f1238P == null) {
                return;
            }
            g.a aVar2 = aVar.f1534a;
            g.a aVar3 = aVar.f1535b;
            int i11 = aVar.f1536c;
            int i12 = aVar.f1537d;
            int i13 = this.f6884b + this.f6885c;
            int i14 = this.f6886d;
            View view = gVar.f1251b0;
            int iOrdinal = aVar2.ordinal();
            e eVar = gVar.f1229F;
            e eVar2 = gVar.f1227D;
            if (iOrdinal == 0) {
                iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
            } else if (iOrdinal == 1) {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f6888f, i14, -2);
            } else if (iOrdinal != 2) {
                iMakeMeasureSpec = iOrdinal != 3 ? 0 : ViewGroup.getChildMeasureSpec(this.f6888f, eVar2.f1211g + eVar.f1211g + i14, -1);
            } else {
                iMakeMeasureSpec = ViewGroup.getChildMeasureSpec(this.f6888f, i14, -2);
                boolean z9 = gVar.f1269l == 1;
                int i15 = aVar.j;
                if (i15 == 1 || i15 == 2) {
                    boolean z10 = view.getMeasuredHeight() == gVar.k();
                    if (aVar.j == 2 || !z9 || ((z9 && z10) || (view instanceof Placeholder) || gVar.w())) {
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(gVar.n(), 1073741824);
                    }
                }
            }
            int iOrdinal2 = aVar3.ordinal();
            if (iOrdinal2 == 0) {
                iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i12, 1073741824);
            } else if (iOrdinal2 == 1) {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f6889g, i13, -2);
            } else if (iOrdinal2 != 2) {
                iMakeMeasureSpec2 = iOrdinal2 != 3 ? 0 : ViewGroup.getChildMeasureSpec(this.f6889g, gVar.f1228E.f1211g + gVar.f1230G.f1211g + i13, -1);
            } else {
                iMakeMeasureSpec2 = ViewGroup.getChildMeasureSpec(this.f6889g, i13, -2);
                boolean z11 = gVar.f1270m == 1;
                int i16 = aVar.j;
                if (i16 == 1 || i16 == 2) {
                    boolean z12 = view.getMeasuredWidth() == gVar.n();
                    if (aVar.j == 2 || !z11 || ((z11 && z12) || (view instanceof Placeholder) || gVar.x())) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(gVar.k(), 1073741824);
                    }
                }
            }
            h hVar = (h) gVar.f1238P;
            ConstraintLayout constraintLayout = ConstraintLayout.this;
            if (hVar != null && l.b(constraintLayout.f6814i, 256) && view.getMeasuredWidth() == gVar.n() && view.getMeasuredWidth() < hVar.n() && view.getMeasuredHeight() == gVar.k() && view.getMeasuredHeight() < hVar.k() && view.getBaseline() == gVar.f1245W && !gVar.v() && a(gVar.f1225B, iMakeMeasureSpec, gVar.n()) && a(gVar.f1226C, iMakeMeasureSpec2, gVar.k())) {
                aVar.f1538e = gVar.n();
                aVar.f1539f = gVar.k();
                aVar.f1540g = gVar.f1245W;
                return;
            }
            g.a aVar4 = g.a.f1285c;
            boolean z13 = aVar2 == aVar4;
            boolean z14 = aVar3 == aVar4;
            g.a aVar5 = g.a.f1286d;
            g.a aVar6 = g.a.f1283a;
            boolean z15 = aVar3 == aVar5 || aVar3 == aVar6;
            boolean z16 = aVar2 == aVar5 || aVar2 == aVar6;
            boolean z17 = z13 && gVar.f1241S > 0.0f;
            boolean z18 = z14 && gVar.f1241S > 0.0f;
            if (view == null) {
                return;
            }
            a aVar7 = (a) view.getLayoutParams();
            int i17 = aVar.j;
            if (i17 != 1 && i17 != 2 && z13 && gVar.f1269l == 0 && z14 && gVar.f1270m == 0) {
                z8 = false;
                measuredWidth = 0;
                baseline = 0;
                i10 = -1;
                iMax = 0;
            } else {
                if ((view instanceof VirtualLayout) && (gVar instanceof m)) {
                    ((VirtualLayout) view).l((m) gVar, iMakeMeasureSpec, iMakeMeasureSpec2);
                } else {
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                }
                gVar.f1225B = iMakeMeasureSpec;
                gVar.f1226C = iMakeMeasureSpec2;
                gVar.f1260g = false;
                int measuredWidth2 = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                int baseline2 = view.getBaseline();
                int i18 = gVar.f1272o;
                int iMax2 = i18 > 0 ? Math.max(i18, measuredWidth2) : measuredWidth2;
                int i19 = gVar.f1273p;
                if (i19 > 0) {
                    iMax2 = Math.min(i19, iMax2);
                }
                int i20 = gVar.f1275r;
                iMax = i20 > 0 ? Math.max(i20, measuredHeight) : measuredHeight;
                boolean z19 = z16;
                int i21 = gVar.f1276s;
                if (i21 > 0) {
                    iMax = Math.min(i21, iMax);
                }
                if (!l.b(constraintLayout.f6814i, 1)) {
                    if (z17 && z15) {
                        iMax2 = (int) ((iMax * gVar.f1241S) + 0.5f);
                    } else if (z18 && z19) {
                        iMax = (int) ((iMax2 / gVar.f1241S) + 0.5f);
                    }
                }
                if (measuredWidth2 == iMax2 && measuredHeight == iMax) {
                    baseline = baseline2;
                    measuredWidth = iMax2;
                    z8 = false;
                } else {
                    if (measuredWidth2 != iMax2) {
                        i9 = 1073741824;
                        iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMax2, 1073741824);
                    } else {
                        i9 = 1073741824;
                    }
                    if (measuredHeight != iMax) {
                        iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMax, i9);
                    }
                    view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                    gVar.f1225B = iMakeMeasureSpec;
                    gVar.f1226C = iMakeMeasureSpec2;
                    z8 = false;
                    gVar.f1260g = false;
                    measuredWidth = view.getMeasuredWidth();
                    int measuredHeight2 = view.getMeasuredHeight();
                    baseline = view.getBaseline();
                    iMax = measuredHeight2;
                }
                i10 = -1;
            }
            boolean z20 = baseline != i10 ? true : z8;
            if (measuredWidth != aVar.f1536c || iMax != aVar.f1537d) {
                z8 = true;
            }
            aVar.f1542i = z8;
            boolean z21 = aVar7.f6844X ? true : z20;
            if (z21 && baseline != -1 && gVar.f1245W != baseline) {
                aVar.f1542i = true;
            }
            aVar.f1538e = measuredWidth;
            aVar.f1539f = iMax;
            aVar.f1541h = z21;
            aVar.f1540g = baseline;
        }
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6806a = new SparseArray<>();
        this.f6807b = new ArrayList<>(4);
        this.f6808c = new h();
        this.f6809d = 0;
        this.f6810e = 0;
        this.f6811f = Integer.MAX_VALUE;
        this.f6812g = Integer.MAX_VALUE;
        this.f6813h = true;
        this.f6814i = FeedManager.FILE_TYPE_INT_AIGC_ORIGIN_PNG;
        this.j = null;
        this.f6815k = null;
        this.f6816l = -1;
        this.f6817m = new HashMap<>();
        this.f6818n = new SparseArray<>();
        this.f6819o = new b(this);
        this.f6820p = 0;
        this.f6821q = 0;
        d(attributeSet, 0);
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public final View b(int i9) {
        return this.f6806a.get(i9);
    }

    public final g c(View view) {
        if (view == this) {
            return this.f6808c;
        }
        if (view == null) {
            return null;
        }
        return ((a) view.getLayoutParams()).f6868l0;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public final void d(AttributeSet attributeSet, int i9) {
        h hVar = this.f6808c;
        hVar.f1251b0 = this;
        b bVar = this.f6819o;
        hVar.f1295o0 = bVar;
        hVar.f1294n0.f1550f = bVar;
        this.f6806a.put(getId(), this);
        this.j = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, d.f1778b, i9, 0);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == 9) {
                    this.f6809d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6809d);
                } else if (index == 10) {
                    this.f6810e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6810e);
                } else if (index == 7) {
                    this.f6811f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6811f);
                } else if (index == 8) {
                    this.f6812g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6812g);
                } else if (index == 90) {
                    this.f6814i = typedArrayObtainStyledAttributes.getInt(index, this.f6814i);
                } else if (index == 39) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            f(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f6815k = null;
                        }
                    }
                } else if (index == 18) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        androidx.constraintlayout.widget.b bVar2 = new androidx.constraintlayout.widget.b();
                        this.j = bVar2;
                        bVar2.e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.j = null;
                    }
                    this.f6816l = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        hVar.f1304x0 = this.f6814i;
        c.f22425p = hVar.Q(512);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.f6807b;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i9 = 0; i9 < size; i9++) {
                arrayList.get(i9).j(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            int childCount = getChildCount();
            float width = getWidth();
            float height = getHeight();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (strArrSplit.length == 4) {
                        int i11 = Integer.parseInt(strArrSplit[0]);
                        int i12 = Integer.parseInt(strArrSplit[1]);
                        int i13 = Integer.parseInt(strArrSplit[2]);
                        int i14 = (int) ((i11 / 1080.0f) * width);
                        int i15 = (int) ((i12 / 1920.0f) * height);
                        int i16 = (int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f6 = i14;
                        float f9 = i15;
                        float f10 = i14 + ((int) ((i13 / 1080.0f) * width));
                        canvas.drawLine(f6, f9, f10, f9, paint);
                        float f11 = i15 + i16;
                        canvas.drawLine(f10, f9, f10, f11, paint);
                        canvas.drawLine(f10, f11, f6, f11, paint);
                        canvas.drawLine(f6, f11, f6, f9, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f6, f9, f10, f11, paint);
                        canvas.drawLine(f6, f11, f10, f9, paint);
                    }
                }
            }
        }
    }

    public final boolean e() {
        return (getContext().getApplicationInfo().flags & 4194304) != 0 && 1 == getLayoutDirection();
    }

    public void f(int i9) {
        this.f6815k = new C.a(getContext(), this, i9);
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f6813h = true;
        super.forceLayout();
    }

    public final void g(int i9, int i10, int i11, int i12, boolean z8, boolean z9) {
        b bVar = this.f6819o;
        int i13 = bVar.f6887e;
        int iResolveSizeAndState = View.resolveSizeAndState(i11 + bVar.f6886d, i9, 0);
        int iResolveSizeAndState2 = View.resolveSizeAndState(i12 + i13, i10, 0) & 16777215;
        int iMin = Math.min(this.f6811f, iResolveSizeAndState & 16777215);
        int iMin2 = Math.min(this.f6812g, iResolveSizeAndState2);
        if (z8) {
            iMin |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        if (z9) {
            iMin2 |= Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE;
        }
        setMeasuredDimension(iMin, iMin2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public int getMaxHeight() {
        return this.f6812g;
    }

    public int getMaxWidth() {
        return this.f6811f;
    }

    public int getMinHeight() {
        return this.f6810e;
    }

    public int getMinWidth() {
        return this.f6809d;
    }

    public int getOptimizationLevel() {
        return this.f6808c.f1304x0;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x01dd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:105:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:107:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:110:0x0208  */
    /* JADX WARN: Code duplicated, block: B:112:0x020c  */
    /* JADX WARN: Code duplicated, block: B:116:0x021b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:194:0x03b8  */
    /* JADX WARN: Code duplicated, block: B:196:0x03c8  */
    /* JADX WARN: Code duplicated, block: B:199:0x03d4 A[LOOP:11: B:197:0x03ce->B:199:0x03d4, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:201:0x041b  */
    /* JADX WARN: Code duplicated, block: B:204:0x0437  */
    /* JADX WARN: Code duplicated, block: B:205:0x043e  */
    /* JADX WARN: Code duplicated, block: B:207:0x0442  */
    /* JADX WARN: Code duplicated, block: B:209:0x044c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:210:0x044e  */
    /* JADX WARN: Code duplicated, block: B:211:0x0450  */
    /* JADX WARN: Code duplicated, block: B:213:0x0453  */
    /* JADX WARN: Code duplicated, block: B:214:0x0455  */
    /* JADX WARN: Code duplicated, block: B:216:0x045a  */
    /* JADX WARN: Code duplicated, block: B:218:0x0468  */
    /* JADX WARN: Code duplicated, block: B:224:0x0471  */
    /* JADX WARN: Code duplicated, block: B:226:0x0482  */
    /* JADX WARN: Code duplicated, block: B:228:0x048e  */
    /* JADX WARN: Code duplicated, block: B:229:0x0492  */
    /* JADX WARN: Code duplicated, block: B:247:0x04c1  */
    /* JADX WARN: Code duplicated, block: B:253:0x04cd  */
    /* JADX WARN: Code duplicated, block: B:255:0x04d0  */
    /* JADX WARN: Code duplicated, block: B:260:0x04dc  */
    /* JADX WARN: Code duplicated, block: B:267:0x04eb  */
    /* JADX WARN: Code duplicated, block: B:26:0x00b1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:274:0x04fa A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:275:0x04fc  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:280:0x0506  */
    /* JADX WARN: Code duplicated, block: B:284:0x051b  */
    /* JADX WARN: Code duplicated, block: B:286:0x0523  */
    /* JADX WARN: Code duplicated, block: B:289:0x052a  */
    /* JADX WARN: Code duplicated, block: B:291:0x0545  */
    /* JADX WARN: Code duplicated, block: B:294:0x0556  */
    /* JADX WARN: Code duplicated, block: B:299:0x0570  */
    /* JADX WARN: Code duplicated, block: B:29:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:301:0x0573 A[LOOP:5: B:300:0x0571->B:301:0x0573, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:304:0x058a  */
    /* JADX WARN: Code duplicated, block: B:306:0x058f  */
    /* JADX WARN: Code duplicated, block: B:308:0x0597  */
    /* JADX WARN: Code duplicated, block: B:30:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:310:0x059b  */
    /* JADX WARN: Code duplicated, block: B:313:0x05a2  */
    /* JADX WARN: Code duplicated, block: B:314:0x05a4  */
    /* JADX WARN: Code duplicated, block: B:318:0x05c5  */
    /* JADX WARN: Code duplicated, block: B:31:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:320:0x05d1  */
    /* JADX WARN: Code duplicated, block: B:321:0x05dc  */
    /* JADX WARN: Code duplicated, block: B:323:0x0601  */
    /* JADX WARN: Code duplicated, block: B:325:0x0606  */
    /* JADX WARN: Code duplicated, block: B:32:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:330:0x0627  */
    /* JADX WARN: Code duplicated, block: B:332:0x062c  */
    /* JADX WARN: Code duplicated, block: B:33:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:341:0x066d  */
    /* JADX WARN: Code duplicated, block: B:343:0x0671  */
    /* JADX WARN: Code duplicated, block: B:345:0x067b  */
    /* JADX WARN: Code duplicated, block: B:349:0x0683  */
    /* JADX WARN: Code duplicated, block: B:355:0x068f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:35:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:363:0x06a6  */
    /* JADX WARN: Code duplicated, block: B:366:0x06bf  */
    /* JADX WARN: Code duplicated, block: B:369:0x06d4  */
    /* JADX WARN: Code duplicated, block: B:371:0x06d9  */
    /* JADX WARN: Code duplicated, block: B:376:0x06fa  */
    /* JADX WARN: Code duplicated, block: B:378:0x06ff  */
    /* JADX WARN: Code duplicated, block: B:37:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:384:0x0722  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:390:0x0737 A[LOOP:7: B:339:0x066a->B:390:0x0737, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:392:0x0746  */
    /* JADX WARN: Code duplicated, block: B:394:0x074f  */
    /* JADX WARN: Code duplicated, block: B:395:0x0754  */
    /* JADX WARN: Code duplicated, block: B:398:0x075c  */
    /* JADX WARN: Code duplicated, block: B:399:0x0761  */
    /* JADX WARN: Code duplicated, block: B:401:0x0764  */
    /* JADX WARN: Code duplicated, block: B:403:0x076a  */
    /* JADX WARN: Code duplicated, block: B:406:0x01d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:41:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:434:0x050a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:437:0x0565 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:438:0x0565 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:440:0x065e A[EDGE_INSN: B:440:0x065e->B:338:0x065e BREAK  A[LOOP:6: B:316:0x05bf->B:337:0x0651], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:443:0x0744 A[EDGE_INSN: B:443:0x0744->B:391:0x0744 BREAK  A[LOOP:7: B:339:0x066a->B:390:0x0737], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:448:0x0728 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:48:0x0130  */
    /* JADX WARN: Code duplicated, block: B:49:0x0133  */
    /* JADX WARN: Code duplicated, block: B:52:0x013b  */
    /* JADX WARN: Code duplicated, block: B:53:0x013e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0163  */
    /* JADX WARN: Code duplicated, block: B:60:0x016c  */
    /* JADX WARN: Code duplicated, block: B:63:0x0174  */
    /* JADX WARN: Code duplicated, block: B:65:0x0177  */
    /* JADX WARN: Code duplicated, block: B:67:0x018d  */
    /* JADX WARN: Code duplicated, block: B:68:0x0190  */
    /* JADX WARN: Code duplicated, block: B:71:0x0196  */
    /* JADX WARN: Code duplicated, block: B:72:0x0199  */
    /* JADX WARN: Code duplicated, block: B:74:0x019c A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:78:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ae A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:84:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:97:0x01d4 A[PHI: r2
  0x01d4: PHI (r2v3 boolean) = (r2v2 boolean), (r2v62 boolean) binds: [B:62:0x0172, B:406:0x01d4] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:99:0x01db A[ADDED_TO_REGION] */
    public final void h(h hVar, int i9, int i10, int i11) {
        int iMax;
        int iMax2;
        g.a aVar;
        int iN;
        B.e eVar;
        int[] iArr;
        int i12;
        int i13;
        B.b bVar;
        B.b.InterfaceC0002b interfaceC0002b;
        int size;
        int iN2;
        int iK;
        boolean zB;
        boolean z8;
        g.a aVar2;
        boolean z9;
        boolean z10;
        boolean z11;
        int i14;
        g.a aVar3;
        g.a aVar4;
        int i15;
        boolean zO;
        int i16;
        ArrayList<g> arrayList;
        int size2;
        int i17;
        g.a[] aVarArr;
        boolean z12;
        boolean z13;
        int iMax3;
        int iMax4;
        int i18;
        boolean z14;
        e.a aVar5;
        e.a aVar6;
        boolean z15;
        boolean z16;
        boolean zA;
        B.b.InterfaceC0002b interfaceC0002b2;
        int i19;
        boolean z17;
        boolean z18;
        int i20;
        ArrayList<g> arrayList2;
        int i21;
        g gVar;
        int iN3;
        int iK2;
        int i22;
        ArrayList<g> arrayList3;
        int iN4;
        int i23;
        int iK3;
        g gVar2;
        boolean z19;
        int iN5;
        boolean z20;
        int iK4;
        B.b.InterfaceC0002b interfaceC0002b3;
        boolean zA2;
        int iN6;
        int iK5;
        boolean z21;
        int size3;
        B.b.InterfaceC0002b interfaceC0002b4;
        int i24;
        ConstraintLayout constraintLayout;
        int childCount;
        int i25;
        ArrayList<ConstraintHelper> arrayList4;
        int size4;
        int i26;
        View childAt;
        Placeholder placeholder;
        a aVar7;
        g gVar3;
        g gVar4;
        g gVar5;
        g gVar6;
        g.a aVarJ;
        g.a aVarJ2;
        int i27;
        boolean z22;
        B.l lVar;
        n nVar;
        int iMin;
        boolean z23;
        boolean z24;
        h hVar2;
        int i28;
        int i29;
        Iterator<g> it;
        boolean z25;
        boolean z26;
        int i30;
        boolean z27;
        boolean z28;
        int i31;
        boolean z29;
        g gVar7;
        int i32;
        g.a[] aVarArr2;
        boolean z30;
        boolean z31;
        boolean z32;
        int mode = View.MeasureSpec.getMode(i10);
        int size5 = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i11);
        int size6 = View.MeasureSpec.getSize(i11);
        int iMax5 = Math.max(0, getPaddingTop());
        int iMax6 = Math.max(0, getPaddingBottom());
        int i33 = iMax5 + iMax6;
        int paddingWidth = getPaddingWidth();
        b bVar2 = this.f6819o;
        bVar2.f6884b = iMax5;
        bVar2.f6885c = iMax6;
        bVar2.f6886d = paddingWidth;
        bVar2.f6887e = i33;
        bVar2.f6888f = i10;
        bVar2.f6889g = i11;
        int iMax7 = Math.max(0, getPaddingStart());
        int iMax8 = Math.max(0, getPaddingEnd());
        if (iMax7 <= 0 && iMax8 <= 0) {
            iMax7 = Math.max(0, getPaddingLeft());
        } else if (e()) {
            iMax7 = iMax8;
        }
        int i34 = size5 - paddingWidth;
        int i35 = size6 - i33;
        int i36 = bVar2.f6887e;
        int i37 = bVar2.f6886d;
        g.a aVar8 = g.a.f1283a;
        int childCount2 = getChildCount();
        g.a aVar9 = g.a.f1284b;
        int i38 = Integer.MIN_VALUE;
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                if (childCount2 == 0) {
                    iMax = Math.max(0, this.f6809d);
                } else {
                    iMax = 0;
                }
                i38 = Integer.MIN_VALUE;
            } else if (mode != 1073741824) {
                i36 = i36;
                aVar9 = aVar8;
                iMax = 0;
            } else {
                iMax = Math.min(this.f6811f - i37, i34);
                i36 = i36;
                aVar9 = aVar8;
            }
            if (mode2 != i38) {
                if (mode2 != 0) {
                    if (mode2 != 1073741824) {
                        aVar = aVar8;
                        iMax2 = 0;
                    } else {
                        iMax2 = Math.min(this.f6812g - i36, i35);
                        aVar = aVar8;
                    }
                } else if (childCount2 == 0) {
                    aVar = aVar9;
                    iMax2 = Math.max(0, this.f6810e);
                } else {
                    iMax2 = 0;
                }
                iN = hVar.n();
                eVar = hVar.f1294n0;
                if (iMax == iN || iMax2 != hVar.k()) {
                    eVar.f1547c = true;
                }
                hVar.f1243U = 0;
                hVar.f1244V = 0;
                int i39 = this.f6811f - i37;
                iArr = hVar.f1279w;
                iArr[0] = i39;
                iArr[1] = this.f6812g - i36;
                hVar.f1246X = 0;
                hVar.f1247Y = 0;
                hVar.F(aVar9);
                hVar.H(iMax);
                hVar.G(aVar);
                hVar.E(iMax2);
                i12 = this.f6809d - i37;
                if (i12 < 0) {
                    hVar.f1246X = 0;
                } else {
                    hVar.f1246X = i12;
                }
                i13 = this.f6810e - i36;
                if (i13 < 0) {
                    hVar.f1247Y = 0;
                } else {
                    hVar.f1247Y = i13;
                }
                hVar.f1298r0 = iMax7;
                hVar.f1299s0 = iMax5;
                bVar = hVar.f1293m0;
                bVar.getClass();
                interfaceC0002b = hVar.f1295o0;
                size = hVar.f1366l0.size();
                iN2 = hVar.n();
                iK = hVar.k();
                zB = l.b(i9, 128);
                if (!zB || l.b(i9, 64)) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                aVar2 = g.a.f1285c;
                if (z8) {
                    i31 = 0;
                    while (true) {
                        if (i31 < size) {
                            z29 = z8;
                            gVar7 = hVar.f1366l0.get(i31);
                            i32 = i31;
                            aVarArr2 = gVar7.O;
                            if (aVarArr2[0] == aVar2) {
                                z30 = true;
                            } else {
                                z30 = false;
                            }
                            if (aVarArr2[1] == aVar2) {
                                z31 = true;
                            } else {
                                z31 = false;
                            }
                            if (z30 || !z31 || gVar7.f1241S <= 0.0f) {
                                z32 = false;
                            } else {
                                z32 = true;
                            }
                            if ((gVar7.t() || !z32) && !((gVar7.u() && z32) || (gVar7 instanceof m) || gVar7.t() || gVar7.u())) {
                                i31 = i32 + 1;
                                z8 = z29;
                            } else {
                                z9 = false;
                            }
                        } else {
                            z9 = z8;
                        }
                    }
                } else {
                    z9 = z8;
                }
                z10 = z9 & ((mode != 1073741824 && mode2 == 1073741824) || zB);
                if (z10) {
                    int iMin2 = Math.min(iArr[0], i34);
                    iMin = Math.min(iArr[1], i35);
                    if (mode == 1073741824 || hVar.n() == iMin2) {
                        z23 = true;
                    } else {
                        hVar.H(iMin2);
                        z23 = true;
                        hVar.f1294n0.f1546b = true;
                    }
                    if (mode2 == 1073741824 && hVar.k() != iMin) {
                        hVar.E(iMin);
                        hVar.f1294n0.f1546b = z23;
                    }
                    if (mode == 1073741824 || mode2 != 1073741824) {
                        z11 = z10;
                        interfaceC0002b = interfaceC0002b;
                        i14 = size;
                        aVar3 = aVar8;
                        aVar4 = aVar9;
                        z24 = eVar.f1546b;
                        hVar2 = eVar.f1545a;
                        if (z24) {
                            it = hVar2.f1366l0.iterator();
                            while (it.hasNext()) {
                                g next = it.next();
                                next.h();
                                next.f1249a = false;
                                B.l lVar2 = next.f1254d;
                                Iterator<g> it2 = it;
                                lVar2.f1590e.j = false;
                                lVar2.f1592g = false;
                                lVar2.n();
                                n nVar2 = next.f1256e;
                                nVar2.f1590e.j = false;
                                nVar2.f1592g = false;
                                nVar2.m();
                                it = it2;
                            }
                            i28 = 0;
                            hVar2.h();
                            hVar2.f1249a = false;
                            B.l lVar3 = hVar2.f1254d;
                            lVar3.f1590e.j = false;
                            lVar3.f1592g = false;
                            lVar3.n();
                            n nVar3 = hVar2.f1256e;
                            nVar3.f1590e.j = false;
                            nVar3.f1592g = false;
                            nVar3.m();
                            eVar.c();
                        } else {
                            i28 = 0;
                        }
                        eVar.b(eVar.f1548d);
                        hVar2.f1243U = i28;
                        hVar2.f1244V = i28;
                        hVar2.f1254d.f1593h.d(i28);
                        hVar2.f1256e.f1593h.d(i28);
                        i29 = 1073741824;
                        if (mode == 1073741824) {
                            zO = hVar.O(i28, zB);
                            i15 = 1;
                        } else {
                            i15 = 0;
                            zO = true;
                        }
                        if (mode2 == 1073741824) {
                            zO &= hVar.O(1, zB);
                            i15++;
                        }
                    } else {
                        boolean z33 = eVar.f1546b;
                        h hVar3 = eVar.f1545a;
                        if (z33 || eVar.f1547c) {
                            for (g gVar8 : hVar3.f1366l0) {
                                gVar8.h();
                                gVar8.f1249a = false;
                                gVar8.f1254d.n();
                                gVar8.f1256e.m();
                            }
                            hVar3.h();
                            i30 = 0;
                            hVar3.f1249a = false;
                            hVar3.f1254d.n();
                            hVar3.f1256e.m();
                            eVar.f1547c = false;
                        } else {
                            i30 = 0;
                        }
                        eVar.b(eVar.f1548d);
                        hVar3.f1243U = i30;
                        hVar3.f1244V = i30;
                        g.a aVarJ3 = hVar3.j(i30);
                        g.a aVarJ4 = hVar3.j(1);
                        if (eVar.f1546b) {
                            eVar.c();
                        }
                        int iO = hVar3.o();
                        z11 = z10;
                        int iP = hVar3.p();
                        i14 = size;
                        hVar3.f1254d.f1593h.d(iO);
                        hVar3.f1256e.f1593h.d(iP);
                        eVar.g();
                        ArrayList<p> arrayList5 = eVar.f1549e;
                        aVar4 = aVar9;
                        if (aVarJ3 == aVar4 || aVarJ4 == aVar4) {
                            if (zB) {
                                Iterator<p> it3 = arrayList5.iterator();
                                while (it3.hasNext()) {
                                    if (!it3.next().k()) {
                                        zB = false;
                                        break;
                                    }
                                }
                            }
                            if (zB && aVarJ3 == aVar4) {
                                aVar3 = aVar8;
                                hVar3.F(aVar3);
                                hVar3.H(eVar.d(hVar3, 0));
                                hVar3.f1254d.f1590e.d(hVar3.n());
                            } else {
                                aVar3 = aVar8;
                            }
                            if (zB && aVarJ4 == aVar4) {
                                hVar3.G(aVar3);
                                hVar3.E(eVar.d(hVar3, 1));
                                hVar3.f1256e.f1590e.d(hVar3.k());
                            }
                        } else {
                            arrayList5 = arrayList5;
                            aVar3 = aVar8;
                            iO = iO;
                        }
                        g.a[] aVarArr3 = hVar3.O;
                        g.a aVar10 = aVarArr3[0];
                        g.a aVar11 = g.a.f1286d;
                        if (aVar10 == aVar3 || aVar10 == aVar11) {
                            int iN7 = hVar3.n() + iO;
                            hVar3.f1254d.f1594i.d(iN7);
                            hVar3.f1254d.f1590e.d(iN7 - iO);
                            eVar.g();
                            g.a aVar12 = aVarArr3[1];
                            if (aVar12 == aVar3 || aVar12 == aVar11) {
                                int iK6 = hVar3.k() + iP;
                                hVar3.f1256e.f1594i.d(iK6);
                                hVar3.f1256e.f1590e.d(iK6 - iP);
                            }
                            eVar.g();
                            z27 = true;
                        } else {
                            z27 = false;
                        }
                        for (p pVar : arrayList5) {
                            if (pVar.f1587b != hVar3 || pVar.f1592g) {
                                pVar.e();
                            }
                        }
                        Iterator<p> it4 = arrayList5.iterator();
                        while (true) {
                            if (!it4.hasNext()) {
                                z28 = true;
                                break;
                            }
                            p next2 = it4.next();
                            if (z27 || next2.f1587b != hVar3) {
                                if (!next2.f1593h.j || ((!next2.f1594i.j && !(next2 instanceof j)) || (!next2.f1590e.j && !(next2 instanceof B.c) && !(next2 instanceof j)))) {
                                    z28 = false;
                                    break;
                                }
                            }
                        }
                        hVar3.F(aVarJ3);
                        hVar3.G(aVarJ4);
                        zO = z28;
                        i29 = 1073741824;
                        i15 = 2;
                    }
                    if (zO) {
                        if (mode == i29) {
                            z25 = true;
                        } else {
                            z25 = false;
                        }
                        if (mode2 == i29) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        hVar.I(z25, z26);
                    }
                } else {
                    z11 = z10;
                    interfaceC0002b = interfaceC0002b;
                    i14 = size;
                    aVar3 = aVar8;
                    aVar4 = aVar9;
                    i15 = 0;
                    zO = false;
                }
                if (zO || i15 != 2) {
                    i16 = hVar.f1304x0;
                    if (i14 > 0) {
                        size3 = hVar.f1366l0.size();
                        boolean zQ = hVar.Q(64);
                        interfaceC0002b4 = hVar.f1295o0;
                        i24 = 0;
                        while (i24 < size3) {
                            gVar6 = hVar.f1366l0.get(i24);
                            if (!(gVar6 instanceof A.j) || (gVar6 instanceof A.b) || gVar6.f1224A || (zQ && (lVar = gVar6.f1254d) != null && (nVar = gVar6.f1256e) != null && lVar.f1590e.j && nVar.f1590e.j)) {
                                i27 = size3;
                            } else {
                                aVarJ = gVar6.j(0);
                                aVarJ2 = gVar6.j(1);
                                i27 = size3;
                                if (aVarJ == aVar2 || gVar6.f1269l == 1 || aVarJ2 != aVar2 || gVar6.f1270m == 1) {
                                    z22 = false;
                                } else {
                                    z22 = true;
                                }
                                if (!z22 && hVar.Q(1) && !(gVar6 instanceof m)) {
                                    if (aVarJ == aVar2 && gVar6.f1269l == 0 && aVarJ2 != aVar2 && !gVar6.t()) {
                                        z22 = true;
                                    }
                                    if (aVarJ2 == aVar2 && gVar6.f1270m == 0 && aVarJ != aVar2 && !gVar6.t()) {
                                        z22 = true;
                                    }
                                    if ((aVarJ != aVar2 || aVarJ2 == aVar2) && gVar6.f1241S > 0.0f) {
                                    }
                                }
                                if (z22) {
                                    bVar.a(interfaceC0002b4, gVar6, 0);
                                }
                            }
                            i24++;
                            size3 = i27;
                        }
                        constraintLayout = ((b) interfaceC0002b4).f6883a;
                        childCount = constraintLayout.getChildCount();
                        for (i25 = 0; i25 < childCount; i25++) {
                            childAt = constraintLayout.getChildAt(i25);
                            if (childAt instanceof Placeholder) {
                                placeholder = (Placeholder) childAt;
                                if (placeholder.f6905b == null) {
                                    a aVar13 = (a) placeholder.getLayoutParams();
                                    aVar7 = (a) placeholder.f6905b.getLayoutParams();
                                    gVar3 = aVar7.f6868l0;
                                    gVar3.f1253c0 = 0;
                                    gVar4 = aVar13.f6868l0;
                                    if (gVar4.O[0] != aVar3) {
                                        gVar4.H(gVar3.n());
                                    }
                                    gVar5 = aVar13.f6868l0;
                                    if (gVar5.O[1] != aVar3) {
                                        gVar5.E(aVar7.f6868l0.k());
                                    }
                                    aVar7.f6868l0.f1253c0 = 8;
                                }
                            }
                        }
                        arrayList4 = constraintLayout.f6807b;
                        size4 = arrayList4.size();
                        if (size4 > 0) {
                            for (i26 = 0; i26 < size4; i26++) {
                                arrayList4.get(i26).getClass();
                            }
                        }
                    }
                    bVar.c(hVar);
                    arrayList = bVar.f1531a;
                    size2 = arrayList.size();
                    if (i14 > 0) {
                        bVar.b(hVar, iN2, iK);
                    }
                    if (size2 > 0) {
                        aVarArr = hVar.O;
                        if (aVarArr[0] == aVar4) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (aVarArr[1] == aVar4) {
                            z13 = true;
                        } else {
                            z13 = false;
                        }
                        int iN8 = hVar.n();
                        h hVar4 = bVar.f1533c;
                        iMax3 = Math.max(iN8, hVar4.f1246X);
                        iMax4 = Math.max(hVar.k(), hVar4.f1247Y);
                        i18 = 0;
                        z14 = false;
                        while (true) {
                            aVar5 = e.a.f1217d;
                            aVar6 = e.a.f1216c;
                            if (i18 < size2) {
                                break;
                            }
                            gVar2 = arrayList.get(i18);
                            z19 = z13;
                            if (gVar2 instanceof m) {
                                iN5 = gVar2.n();
                                z20 = z12;
                                iK4 = gVar2.k();
                                boolean z34 = z14;
                                interfaceC0002b3 = interfaceC0002b;
                                zA2 = z34 | bVar.a(interfaceC0002b3, gVar2, 1);
                                iN6 = gVar2.n();
                                iK5 = gVar2.k();
                                if (iN6 != iN5) {
                                    gVar2.H(iN6);
                                    if (z20 && gVar2.o() + gVar2.f1239Q > iMax3) {
                                        iMax3 = Math.max(iMax3, gVar2.i(aVar6).e() + gVar2.o() + gVar2.f1239Q);
                                    }
                                    zA2 = true;
                                }
                                if (iK5 != iK4) {
                                    gVar2.E(iK5);
                                    if (z19 && gVar2.p() + gVar2.f1240R > iMax4) {
                                        iMax4 = Math.max(iMax4, gVar2.i(aVar5).e() + gVar2.p() + gVar2.f1240R);
                                    }
                                    zA2 = true;
                                }
                                z21 = zA2 | ((m) gVar2).f1361t0;
                            } else {
                                z20 = z12;
                                z21 = z14;
                                interfaceC0002b3 = interfaceC0002b;
                            }
                            i18++;
                            interfaceC0002b = interfaceC0002b3;
                            z12 = z20;
                            i16 = i16;
                            z14 = z21;
                            z13 = z19;
                        }
                        z15 = z13;
                        int i40 = i16;
                        z16 = z12;
                        zA = z14;
                        interfaceC0002b2 = interfaceC0002b;
                        i19 = 0;
                        while (i19 < 2) {
                            i20 = 0;
                            while (i20 < size2) {
                                gVar = arrayList.get(i20);
                                if (((gVar instanceof k) || (gVar instanceof m)) && !(gVar instanceof A.j)) {
                                    if (gVar.f1253c0 == 8 && ((!z11 || !gVar.f1254d.f1590e.j || !gVar.f1256e.f1590e.j) && !(gVar instanceof m))) {
                                        iN3 = gVar.n();
                                        iK2 = gVar.k();
                                        i22 = i20;
                                        int i41 = gVar.f1245W;
                                        arrayList3 = arrayList;
                                        zA |= bVar.a(interfaceC0002b2, gVar, i19 == 1 ? 2 : 1);
                                        iN4 = gVar.n();
                                        i23 = size2;
                                        iK3 = gVar.k();
                                        if (iN4 != iN3) {
                                            gVar.H(iN4);
                                            if (z16 && gVar.o() + gVar.f1239Q > iMax3) {
                                                iMax3 = Math.max(iMax3, gVar.i(aVar6).e() + gVar.o() + gVar.f1239Q);
                                            }
                                            zA = true;
                                        }
                                        if (iK3 != iK2) {
                                            gVar.E(iK3);
                                            if (z15 && gVar.p() + gVar.f1240R > iMax4) {
                                                iMax4 = Math.max(iMax4, gVar.i(aVar5).e() + gVar.p() + gVar.f1240R);
                                            }
                                            zA = true;
                                        }
                                        if (!gVar.f1281y && i41 != gVar.f1245W) {
                                            zA = true;
                                        }
                                    }
                                    i20 = i22 + 1;
                                    arrayList = arrayList3;
                                    size2 = i23;
                                }
                                i22 = i20;
                                arrayList3 = arrayList;
                                i23 = size2;
                                i20 = i22 + 1;
                                arrayList = arrayList3;
                                size2 = i23;
                            }
                            arrayList2 = arrayList;
                            i21 = size2;
                            if (zA) {
                                break;
                            }
                            bVar.b(hVar, iN2, iK);
                            i19++;
                            zA = false;
                            arrayList = arrayList2;
                            size2 = i21;
                        }
                        if (zA) {
                            bVar.b(hVar, iN2, iK);
                            if (hVar.n() < iMax3) {
                                hVar.H(iMax3);
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (hVar.k() < iMax4) {
                                hVar.E(iMax4);
                                z18 = true;
                            } else {
                                z18 = z17;
                            }
                            if (z18) {
                                bVar.b(hVar, iN2, iK);
                            }
                        }
                        i17 = i40;
                    } else {
                        i17 = i16;
                    }
                    hVar.f1304x0 = i17;
                    c.f22425p = hVar.Q(512);
                }
                return;
            }
            if (childCount2 == 0) {
                iMax2 = Math.max(0, this.f6810e);
            } else {
                iMax2 = i35;
            }
            aVar = aVar9;
            iN = hVar.n();
            eVar = hVar.f1294n0;
            if (iMax == iN) {
                eVar.f1547c = true;
            } else {
                eVar.f1547c = true;
            }
            hVar.f1243U = 0;
            hVar.f1244V = 0;
            int i310 = this.f6811f - i37;
            iArr = hVar.f1279w;
            iArr[0] = i310;
            iArr[1] = this.f6812g - i36;
            hVar.f1246X = 0;
            hVar.f1247Y = 0;
            hVar.F(aVar9);
            hVar.H(iMax);
            hVar.G(aVar);
            hVar.E(iMax2);
            i12 = this.f6809d - i37;
            if (i12 < 0) {
                hVar.f1246X = 0;
            } else {
                hVar.f1246X = i12;
            }
            i13 = this.f6810e - i36;
            if (i13 < 0) {
                hVar.f1247Y = 0;
            } else {
                hVar.f1247Y = i13;
            }
            hVar.f1298r0 = iMax7;
            hVar.f1299s0 = iMax5;
            bVar = hVar.f1293m0;
            bVar.getClass();
            interfaceC0002b = hVar.f1295o0;
            size = hVar.f1366l0.size();
            iN2 = hVar.n();
            iK = hVar.k();
            zB = l.b(i9, 128);
            if (zB) {
                z8 = true;
            } else {
                z8 = true;
            }
            aVar2 = g.a.f1285c;
            if (z8) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        z29 = z8;
                        gVar7 = hVar.f1366l0.get(i31);
                        i32 = i31;
                        aVarArr2 = gVar7.O;
                        if (aVarArr2[0] == aVar2) {
                            z30 = true;
                        } else {
                            z30 = false;
                        }
                        if (aVarArr2[1] == aVar2) {
                            z31 = true;
                        } else {
                            z31 = false;
                        }
                        if (z30) {
                            z32 = false;
                        } else {
                            z32 = false;
                        }
                        if (gVar7.t()) {
                            i31 = i32 + 1;
                            z8 = z29;
                        } else {
                            i31 = i32 + 1;
                            z8 = z29;
                        }
                        z9 = false;
                    } else {
                        z9 = z8;
                    }
                }
            } else {
                z9 = z8;
            }
            z10 = z9 & ((mode != 1073741824 && mode2 == 1073741824) || zB);
            if (z10) {
                int iMin3 = Math.min(iArr[0], i34);
                iMin = Math.min(iArr[1], i35);
                if (mode == 1073741824) {
                    z23 = true;
                } else {
                    z23 = true;
                }
                if (mode2 == 1073741824) {
                    hVar.E(iMin);
                    hVar.f1294n0.f1546b = z23;
                }
                if (mode == 1073741824) {
                    z11 = z10;
                    interfaceC0002b = interfaceC0002b;
                    i14 = size;
                    aVar3 = aVar8;
                    aVar4 = aVar9;
                    z24 = eVar.f1546b;
                    hVar2 = eVar.f1545a;
                    if (z24) {
                        it = hVar2.f1366l0.iterator();
                        while (it.hasNext()) {
                            g next3 = it.next();
                            next3.h();
                            next3.f1249a = false;
                            B.l lVar4 = next3.f1254d;
                            Iterator<g> it5 = it;
                            lVar4.f1590e.j = false;
                            lVar4.f1592g = false;
                            lVar4.n();
                            n nVar4 = next3.f1256e;
                            nVar4.f1590e.j = false;
                            nVar4.f1592g = false;
                            nVar4.m();
                            it = it5;
                        }
                        i28 = 0;
                        hVar2.h();
                        hVar2.f1249a = false;
                        B.l lVar5 = hVar2.f1254d;
                        lVar5.f1590e.j = false;
                        lVar5.f1592g = false;
                        lVar5.n();
                        n nVar5 = hVar2.f1256e;
                        nVar5.f1590e.j = false;
                        nVar5.f1592g = false;
                        nVar5.m();
                        eVar.c();
                    } else {
                        i28 = 0;
                    }
                    eVar.b(eVar.f1548d);
                    hVar2.f1243U = i28;
                    hVar2.f1244V = i28;
                    hVar2.f1254d.f1593h.d(i28);
                    hVar2.f1256e.f1593h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zO = hVar.O(i28, zB);
                        i15 = 1;
                    } else {
                        i15 = 0;
                        zO = true;
                    }
                    if (mode2 == 1073741824) {
                        zO &= hVar.O(1, zB);
                        i15++;
                    }
                } else {
                    z11 = z10;
                    interfaceC0002b = interfaceC0002b;
                    i14 = size;
                    aVar3 = aVar8;
                    aVar4 = aVar9;
                    z24 = eVar.f1546b;
                    hVar2 = eVar.f1545a;
                    if (z24) {
                        it = hVar2.f1366l0.iterator();
                        while (it.hasNext()) {
                            g next4 = it.next();
                            next4.h();
                            next4.f1249a = false;
                            B.l lVar6 = next4.f1254d;
                            Iterator<g> it6 = it;
                            lVar6.f1590e.j = false;
                            lVar6.f1592g = false;
                            lVar6.n();
                            n nVar6 = next4.f1256e;
                            nVar6.f1590e.j = false;
                            nVar6.f1592g = false;
                            nVar6.m();
                            it = it6;
                        }
                        i28 = 0;
                        hVar2.h();
                        hVar2.f1249a = false;
                        B.l lVar7 = hVar2.f1254d;
                        lVar7.f1590e.j = false;
                        lVar7.f1592g = false;
                        lVar7.n();
                        n nVar7 = hVar2.f1256e;
                        nVar7.f1590e.j = false;
                        nVar7.f1592g = false;
                        nVar7.m();
                        eVar.c();
                    } else {
                        i28 = 0;
                    }
                    eVar.b(eVar.f1548d);
                    hVar2.f1243U = i28;
                    hVar2.f1244V = i28;
                    hVar2.f1254d.f1593h.d(i28);
                    hVar2.f1256e.f1593h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zO = hVar.O(i28, zB);
                        i15 = 1;
                    } else {
                        i15 = 0;
                        zO = true;
                    }
                    if (mode2 == 1073741824) {
                        zO &= hVar.O(1, zB);
                        i15++;
                    }
                }
                if (zO) {
                    if (mode == i29) {
                        z25 = true;
                    } else {
                        z25 = false;
                    }
                    if (mode2 == i29) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    hVar.I(z25, z26);
                }
            } else {
                z11 = z10;
                interfaceC0002b = interfaceC0002b;
                i14 = size;
                aVar3 = aVar8;
                aVar4 = aVar9;
                i15 = 0;
                zO = false;
            }
            if (zO) {
            }
            i16 = hVar.f1304x0;
            if (i14 > 0) {
                size3 = hVar.f1366l0.size();
                boolean zQ2 = hVar.Q(64);
                interfaceC0002b4 = hVar.f1295o0;
                i24 = 0;
                while (i24 < size3) {
                    gVar6 = hVar.f1366l0.get(i24);
                    if (!(gVar6 instanceof A.j)) {
                        i27 = size3;
                    } else {
                        aVarJ = gVar6.j(0);
                        aVarJ2 = gVar6.j(1);
                        i27 = size3;
                        if (aVarJ == aVar2) {
                            z22 = false;
                        } else {
                            z22 = false;
                        }
                        if (!z22) {
                            if (aVarJ == aVar2) {
                                z22 = true;
                            }
                            if (aVarJ2 == aVar2) {
                                z22 = true;
                            }
                            z22 = aVarJ != aVar2 ? true : true;
                        }
                        if (z22) {
                            bVar.a(interfaceC0002b4, gVar6, 0);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = ((b) interfaceC0002b4).f6883a;
                childCount = constraintLayout.getChildCount();
                while (i25 < childCount) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof Placeholder) {
                        placeholder = (Placeholder) childAt;
                        if (placeholder.f6905b == null) {
                            a aVar14 = (a) placeholder.getLayoutParams();
                            aVar7 = (a) placeholder.f6905b.getLayoutParams();
                            gVar3 = aVar7.f6868l0;
                            gVar3.f1253c0 = 0;
                            gVar4 = aVar14.f6868l0;
                            if (gVar4.O[0] != aVar3) {
                                gVar4.H(gVar3.n());
                            }
                            gVar5 = aVar14.f6868l0;
                            if (gVar5.O[1] != aVar3) {
                                gVar5.E(aVar7.f6868l0.k());
                            }
                            aVar7.f6868l0.f1253c0 = 8;
                        }
                    }
                }
                arrayList4 = constraintLayout.f6807b;
                size4 = arrayList4.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        arrayList4.get(i26).getClass();
                    }
                }
            }
            bVar.c(hVar);
            arrayList = bVar.f1531a;
            size2 = arrayList.size();
            if (i14 > 0) {
                bVar.b(hVar, iN2, iK);
            }
            if (size2 > 0) {
                aVarArr = hVar.O;
                if (aVarArr[0] == aVar4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (aVarArr[1] == aVar4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                int iN9 = hVar.n();
                h hVar5 = bVar.f1533c;
                iMax3 = Math.max(iN9, hVar5.f1246X);
                iMax4 = Math.max(hVar.k(), hVar5.f1247Y);
                i18 = 0;
                z14 = false;
                while (true) {
                    aVar5 = e.a.f1217d;
                    aVar6 = e.a.f1216c;
                    if (i18 < size2) {
                        break;
                        break;
                    }
                    gVar2 = arrayList.get(i18);
                    z19 = z13;
                    if (gVar2 instanceof m) {
                        z20 = z12;
                        z21 = z14;
                        interfaceC0002b3 = interfaceC0002b;
                    } else {
                        iN5 = gVar2.n();
                        z20 = z12;
                        iK4 = gVar2.k();
                        boolean z35 = z14;
                        interfaceC0002b3 = interfaceC0002b;
                        zA2 = z35 | bVar.a(interfaceC0002b3, gVar2, 1);
                        iN6 = gVar2.n();
                        iK5 = gVar2.k();
                        if (iN6 != iN5) {
                            gVar2.H(iN6);
                            if (z20) {
                                iMax3 = Math.max(iMax3, gVar2.i(aVar6).e() + gVar2.o() + gVar2.f1239Q);
                            }
                            zA2 = true;
                        }
                        if (iK5 != iK4) {
                            gVar2.E(iK5);
                            if (z19) {
                                iMax4 = Math.max(iMax4, gVar2.i(aVar5).e() + gVar2.p() + gVar2.f1240R);
                            }
                            zA2 = true;
                        }
                        z21 = zA2 | ((m) gVar2).f1361t0;
                    }
                    i18++;
                    interfaceC0002b = interfaceC0002b3;
                    z12 = z20;
                    i16 = i16;
                    z14 = z21;
                    z13 = z19;
                }
                z15 = z13;
                int i42 = i16;
                z16 = z12;
                zA = z14;
                interfaceC0002b2 = interfaceC0002b;
                i19 = 0;
                while (i19 < 2) {
                    i20 = 0;
                    while (i20 < size2) {
                        gVar = arrayList.get(i20);
                        if (gVar instanceof k) {
                            if (gVar.f1253c0 == 8) {
                                i22 = i20;
                                arrayList3 = arrayList;
                                i23 = size2;
                            } else {
                                iN3 = gVar.n();
                                iK2 = gVar.k();
                                i22 = i20;
                                int i43 = gVar.f1245W;
                                arrayList3 = arrayList;
                                zA |= bVar.a(interfaceC0002b2, gVar, i19 == 1 ? 2 : 1);
                                iN4 = gVar.n();
                                i23 = size2;
                                iK3 = gVar.k();
                                if (iN4 != iN3) {
                                    gVar.H(iN4);
                                    if (z16) {
                                        iMax3 = Math.max(iMax3, gVar.i(aVar6).e() + gVar.o() + gVar.f1239Q);
                                    }
                                    zA = true;
                                }
                                if (iK3 != iK2) {
                                    gVar.E(iK3);
                                    if (z15) {
                                        iMax4 = Math.max(iMax4, gVar.i(aVar5).e() + gVar.p() + gVar.f1240R);
                                    }
                                    zA = true;
                                }
                                if (!gVar.f1281y) {
                                }
                            }
                        } else if (gVar.f1253c0 == 8) {
                            i22 = i20;
                            arrayList3 = arrayList;
                            i23 = size2;
                        } else {
                            iN3 = gVar.n();
                            iK2 = gVar.k();
                            i22 = i20;
                            int i44 = gVar.f1245W;
                            arrayList3 = arrayList;
                            zA |= bVar.a(interfaceC0002b2, gVar, i19 == 1 ? 2 : 1);
                            iN4 = gVar.n();
                            i23 = size2;
                            iK3 = gVar.k();
                            if (iN4 != iN3) {
                                gVar.H(iN4);
                                if (z16) {
                                    iMax3 = Math.max(iMax3, gVar.i(aVar6).e() + gVar.o() + gVar.f1239Q);
                                }
                                zA = true;
                            }
                            if (iK3 != iK2) {
                                gVar.E(iK3);
                                if (z15) {
                                    iMax4 = Math.max(iMax4, gVar.i(aVar5).e() + gVar.p() + gVar.f1240R);
                                }
                                zA = true;
                            }
                            if (!gVar.f1281y) {
                            }
                        }
                        i20 = i22 + 1;
                        arrayList = arrayList3;
                        size2 = i23;
                    }
                    arrayList2 = arrayList;
                    i21 = size2;
                    if (zA) {
                        break;
                        break;
                    }
                    bVar.b(hVar, iN2, iK);
                    i19++;
                    zA = false;
                    arrayList = arrayList2;
                    size2 = i21;
                }
                if (zA) {
                    bVar.b(hVar, iN2, iK);
                    if (hVar.n() < iMax3) {
                        hVar.H(iMax3);
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (hVar.k() < iMax4) {
                        hVar.E(iMax4);
                        z18 = true;
                    } else {
                        z18 = z17;
                    }
                    if (z18) {
                        bVar.b(hVar, iN2, iK);
                    }
                }
                i17 = i42;
            } else {
                i17 = i16;
            }
            hVar.f1304x0 = i17;
            c.f22425p = hVar.Q(512);
        }
        iMax = childCount2 == 0 ? Math.max(0, this.f6809d) : i34;
        i38 = Integer.MIN_VALUE;
        if (mode2 != i38) {
            if (mode2 != 0) {
                if (mode2 != 1073741824) {
                    aVar = aVar8;
                    iMax2 = 0;
                } else {
                    iMax2 = Math.min(this.f6812g - i36, i35);
                    aVar = aVar8;
                }
            } else if (childCount2 == 0) {
                aVar = aVar9;
                iMax2 = Math.max(0, this.f6810e);
            } else {
                iMax2 = 0;
            }
            iN = hVar.n();
            eVar = hVar.f1294n0;
            if (iMax == iN) {
                eVar.f1547c = true;
            } else {
                eVar.f1547c = true;
            }
            hVar.f1243U = 0;
            hVar.f1244V = 0;
            int i311 = this.f6811f - i37;
            iArr = hVar.f1279w;
            iArr[0] = i311;
            iArr[1] = this.f6812g - i36;
            hVar.f1246X = 0;
            hVar.f1247Y = 0;
            hVar.F(aVar9);
            hVar.H(iMax);
            hVar.G(aVar);
            hVar.E(iMax2);
            i12 = this.f6809d - i37;
            if (i12 < 0) {
                hVar.f1246X = 0;
            } else {
                hVar.f1246X = i12;
            }
            i13 = this.f6810e - i36;
            if (i13 < 0) {
                hVar.f1247Y = 0;
            } else {
                hVar.f1247Y = i13;
            }
            hVar.f1298r0 = iMax7;
            hVar.f1299s0 = iMax5;
            bVar = hVar.f1293m0;
            bVar.getClass();
            interfaceC0002b = hVar.f1295o0;
            size = hVar.f1366l0.size();
            iN2 = hVar.n();
            iK = hVar.k();
            zB = l.b(i9, 128);
            if (zB) {
                z8 = true;
            } else {
                z8 = true;
            }
            aVar2 = g.a.f1285c;
            if (z8) {
                i31 = 0;
                while (true) {
                    if (i31 < size) {
                        z29 = z8;
                        gVar7 = hVar.f1366l0.get(i31);
                        i32 = i31;
                        aVarArr2 = gVar7.O;
                        if (aVarArr2[0] == aVar2) {
                            z30 = true;
                        } else {
                            z30 = false;
                        }
                        if (aVarArr2[1] == aVar2) {
                            z31 = true;
                        } else {
                            z31 = false;
                        }
                        if (z30) {
                            z32 = false;
                        } else {
                            z32 = false;
                        }
                        if (gVar7.t()) {
                            i31 = i32 + 1;
                            z8 = z29;
                        } else {
                            i31 = i32 + 1;
                            z8 = z29;
                        }
                        z9 = false;
                    } else {
                        z9 = z8;
                    }
                }
            } else {
                z9 = z8;
            }
            z10 = z9 & ((mode != 1073741824 && mode2 == 1073741824) || zB);
            if (z10) {
                int iMin4 = Math.min(iArr[0], i34);
                iMin = Math.min(iArr[1], i35);
                if (mode == 1073741824) {
                    z23 = true;
                } else {
                    z23 = true;
                }
                if (mode2 == 1073741824) {
                    hVar.E(iMin);
                    hVar.f1294n0.f1546b = z23;
                }
                if (mode == 1073741824) {
                    z11 = z10;
                    interfaceC0002b = interfaceC0002b;
                    i14 = size;
                    aVar3 = aVar8;
                    aVar4 = aVar9;
                    z24 = eVar.f1546b;
                    hVar2 = eVar.f1545a;
                    if (z24) {
                        it = hVar2.f1366l0.iterator();
                        while (it.hasNext()) {
                            g next5 = it.next();
                            next5.h();
                            next5.f1249a = false;
                            B.l lVar8 = next5.f1254d;
                            Iterator<g> it7 = it;
                            lVar8.f1590e.j = false;
                            lVar8.f1592g = false;
                            lVar8.n();
                            n nVar8 = next5.f1256e;
                            nVar8.f1590e.j = false;
                            nVar8.f1592g = false;
                            nVar8.m();
                            it = it7;
                        }
                        i28 = 0;
                        hVar2.h();
                        hVar2.f1249a = false;
                        B.l lVar9 = hVar2.f1254d;
                        lVar9.f1590e.j = false;
                        lVar9.f1592g = false;
                        lVar9.n();
                        n nVar9 = hVar2.f1256e;
                        nVar9.f1590e.j = false;
                        nVar9.f1592g = false;
                        nVar9.m();
                        eVar.c();
                    } else {
                        i28 = 0;
                    }
                    eVar.b(eVar.f1548d);
                    hVar2.f1243U = i28;
                    hVar2.f1244V = i28;
                    hVar2.f1254d.f1593h.d(i28);
                    hVar2.f1256e.f1593h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zO = hVar.O(i28, zB);
                        i15 = 1;
                    } else {
                        i15 = 0;
                        zO = true;
                    }
                    if (mode2 == 1073741824) {
                        zO &= hVar.O(1, zB);
                        i15++;
                    }
                } else {
                    z11 = z10;
                    interfaceC0002b = interfaceC0002b;
                    i14 = size;
                    aVar3 = aVar8;
                    aVar4 = aVar9;
                    z24 = eVar.f1546b;
                    hVar2 = eVar.f1545a;
                    if (z24) {
                        it = hVar2.f1366l0.iterator();
                        while (it.hasNext()) {
                            g next6 = it.next();
                            next6.h();
                            next6.f1249a = false;
                            B.l lVar10 = next6.f1254d;
                            Iterator<g> it8 = it;
                            lVar10.f1590e.j = false;
                            lVar10.f1592g = false;
                            lVar10.n();
                            n nVar10 = next6.f1256e;
                            nVar10.f1590e.j = false;
                            nVar10.f1592g = false;
                            nVar10.m();
                            it = it8;
                        }
                        i28 = 0;
                        hVar2.h();
                        hVar2.f1249a = false;
                        B.l lVar11 = hVar2.f1254d;
                        lVar11.f1590e.j = false;
                        lVar11.f1592g = false;
                        lVar11.n();
                        n nVar11 = hVar2.f1256e;
                        nVar11.f1590e.j = false;
                        nVar11.f1592g = false;
                        nVar11.m();
                        eVar.c();
                    } else {
                        i28 = 0;
                    }
                    eVar.b(eVar.f1548d);
                    hVar2.f1243U = i28;
                    hVar2.f1244V = i28;
                    hVar2.f1254d.f1593h.d(i28);
                    hVar2.f1256e.f1593h.d(i28);
                    i29 = 1073741824;
                    if (mode == 1073741824) {
                        zO = hVar.O(i28, zB);
                        i15 = 1;
                    } else {
                        i15 = 0;
                        zO = true;
                    }
                    if (mode2 == 1073741824) {
                        zO &= hVar.O(1, zB);
                        i15++;
                    }
                }
                if (zO) {
                    if (mode == i29) {
                        z25 = true;
                    } else {
                        z25 = false;
                    }
                    if (mode2 == i29) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    hVar.I(z25, z26);
                }
            } else {
                z11 = z10;
                interfaceC0002b = interfaceC0002b;
                i14 = size;
                aVar3 = aVar8;
                aVar4 = aVar9;
                i15 = 0;
                zO = false;
            }
            if (zO) {
            }
            i16 = hVar.f1304x0;
            if (i14 > 0) {
                size3 = hVar.f1366l0.size();
                boolean zQ3 = hVar.Q(64);
                interfaceC0002b4 = hVar.f1295o0;
                i24 = 0;
                while (i24 < size3) {
                    gVar6 = hVar.f1366l0.get(i24);
                    if (!(gVar6 instanceof A.j)) {
                        i27 = size3;
                    } else {
                        aVarJ = gVar6.j(0);
                        aVarJ2 = gVar6.j(1);
                        i27 = size3;
                        if (aVarJ == aVar2) {
                            z22 = false;
                        } else {
                            z22 = false;
                        }
                        if (!z22) {
                            if (aVarJ == aVar2) {
                                z22 = true;
                            }
                            if (aVarJ2 == aVar2) {
                                z22 = true;
                            }
                            if (aVarJ != aVar2) {
                            }
                        }
                        if (z22) {
                            bVar.a(interfaceC0002b4, gVar6, 0);
                        }
                    }
                    i24++;
                    size3 = i27;
                }
                constraintLayout = ((b) interfaceC0002b4).f6883a;
                childCount = constraintLayout.getChildCount();
                while (i25 < childCount) {
                    childAt = constraintLayout.getChildAt(i25);
                    if (childAt instanceof Placeholder) {
                        placeholder = (Placeholder) childAt;
                        if (placeholder.f6905b == null) {
                            a aVar15 = (a) placeholder.getLayoutParams();
                            aVar7 = (a) placeholder.f6905b.getLayoutParams();
                            gVar3 = aVar7.f6868l0;
                            gVar3.f1253c0 = 0;
                            gVar4 = aVar15.f6868l0;
                            if (gVar4.O[0] != aVar3) {
                                gVar4.H(gVar3.n());
                            }
                            gVar5 = aVar15.f6868l0;
                            if (gVar5.O[1] != aVar3) {
                                gVar5.E(aVar7.f6868l0.k());
                            }
                            aVar7.f6868l0.f1253c0 = 8;
                        }
                    }
                }
                arrayList4 = constraintLayout.f6807b;
                size4 = arrayList4.size();
                if (size4 > 0) {
                    while (i26 < size4) {
                        arrayList4.get(i26).getClass();
                    }
                }
            }
            bVar.c(hVar);
            arrayList = bVar.f1531a;
            size2 = arrayList.size();
            if (i14 > 0) {
                bVar.b(hVar, iN2, iK);
            }
            if (size2 > 0) {
                aVarArr = hVar.O;
                if (aVarArr[0] == aVar4) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (aVarArr[1] == aVar4) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                int iN10 = hVar.n();
                h hVar6 = bVar.f1533c;
                iMax3 = Math.max(iN10, hVar6.f1246X);
                iMax4 = Math.max(hVar.k(), hVar6.f1247Y);
                i18 = 0;
                z14 = false;
                while (true) {
                    aVar5 = e.a.f1217d;
                    aVar6 = e.a.f1216c;
                    if (i18 < size2) {
                        break;
                        break;
                    }
                    gVar2 = arrayList.get(i18);
                    z19 = z13;
                    if (gVar2 instanceof m) {
                        z20 = z12;
                        z21 = z14;
                        interfaceC0002b3 = interfaceC0002b;
                    } else {
                        iN5 = gVar2.n();
                        z20 = z12;
                        iK4 = gVar2.k();
                        boolean z36 = z14;
                        interfaceC0002b3 = interfaceC0002b;
                        zA2 = z36 | bVar.a(interfaceC0002b3, gVar2, 1);
                        iN6 = gVar2.n();
                        iK5 = gVar2.k();
                        if (iN6 != iN5) {
                            gVar2.H(iN6);
                            if (z20) {
                                iMax3 = Math.max(iMax3, gVar2.i(aVar6).e() + gVar2.o() + gVar2.f1239Q);
                            }
                            zA2 = true;
                        }
                        if (iK5 != iK4) {
                            gVar2.E(iK5);
                            if (z19) {
                                iMax4 = Math.max(iMax4, gVar2.i(aVar5).e() + gVar2.p() + gVar2.f1240R);
                            }
                            zA2 = true;
                        }
                        z21 = zA2 | ((m) gVar2).f1361t0;
                    }
                    i18++;
                    interfaceC0002b = interfaceC0002b3;
                    z12 = z20;
                    i16 = i16;
                    z14 = z21;
                    z13 = z19;
                }
                z15 = z13;
                int i45 = i16;
                z16 = z12;
                zA = z14;
                interfaceC0002b2 = interfaceC0002b;
                i19 = 0;
                while (i19 < 2) {
                    i20 = 0;
                    while (i20 < size2) {
                        gVar = arrayList.get(i20);
                        if (gVar instanceof k) {
                            if (gVar.f1253c0 == 8) {
                                i22 = i20;
                                arrayList3 = arrayList;
                                i23 = size2;
                            } else {
                                iN3 = gVar.n();
                                iK2 = gVar.k();
                                i22 = i20;
                                int i46 = gVar.f1245W;
                                arrayList3 = arrayList;
                                zA |= bVar.a(interfaceC0002b2, gVar, i19 == 1 ? 2 : 1);
                                iN4 = gVar.n();
                                i23 = size2;
                                iK3 = gVar.k();
                                if (iN4 != iN3) {
                                    gVar.H(iN4);
                                    if (z16) {
                                        iMax3 = Math.max(iMax3, gVar.i(aVar6).e() + gVar.o() + gVar.f1239Q);
                                    }
                                    zA = true;
                                }
                                if (iK3 != iK2) {
                                    gVar.E(iK3);
                                    if (z15) {
                                        iMax4 = Math.max(iMax4, gVar.i(aVar5).e() + gVar.p() + gVar.f1240R);
                                    }
                                    zA = true;
                                }
                                if (!gVar.f1281y) {
                                }
                            }
                        } else if (gVar.f1253c0 == 8) {
                            i22 = i20;
                            arrayList3 = arrayList;
                            i23 = size2;
                        } else {
                            iN3 = gVar.n();
                            iK2 = gVar.k();
                            i22 = i20;
                            int i47 = gVar.f1245W;
                            arrayList3 = arrayList;
                            zA |= bVar.a(interfaceC0002b2, gVar, i19 == 1 ? 2 : 1);
                            iN4 = gVar.n();
                            i23 = size2;
                            iK3 = gVar.k();
                            if (iN4 != iN3) {
                                gVar.H(iN4);
                                if (z16) {
                                    iMax3 = Math.max(iMax3, gVar.i(aVar6).e() + gVar.o() + gVar.f1239Q);
                                }
                                zA = true;
                            }
                            if (iK3 != iK2) {
                                gVar.E(iK3);
                                if (z15) {
                                    iMax4 = Math.max(iMax4, gVar.i(aVar5).e() + gVar.p() + gVar.f1240R);
                                }
                                zA = true;
                            }
                            if (!gVar.f1281y) {
                            }
                        }
                        i20 = i22 + 1;
                        arrayList = arrayList3;
                        size2 = i23;
                    }
                    arrayList2 = arrayList;
                    i21 = size2;
                    if (zA) {
                        break;
                        break;
                    }
                    bVar.b(hVar, iN2, iK);
                    i19++;
                    zA = false;
                    arrayList = arrayList2;
                    size2 = i21;
                }
                if (zA) {
                    bVar.b(hVar, iN2, iK);
                    if (hVar.n() < iMax3) {
                        hVar.H(iMax3);
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (hVar.k() < iMax4) {
                        hVar.E(iMax4);
                        z18 = true;
                    } else {
                        z18 = z17;
                    }
                    if (z18) {
                        bVar.b(hVar, iN2, iK);
                    }
                }
                i17 = i45;
            } else {
                i17 = i16;
            }
            hVar.f1304x0 = i17;
            c.f22425p = hVar.Q(512);
        }
        if (childCount2 == 0) {
            iMax2 = Math.max(0, this.f6810e);
        } else {
            iMax2 = i35;
        }
        aVar = aVar9;
        iN = hVar.n();
        eVar = hVar.f1294n0;
        if (iMax == iN) {
            eVar.f1547c = true;
        } else {
            eVar.f1547c = true;
        }
        hVar.f1243U = 0;
        hVar.f1244V = 0;
        int i312 = this.f6811f - i37;
        iArr = hVar.f1279w;
        iArr[0] = i312;
        iArr[1] = this.f6812g - i36;
        hVar.f1246X = 0;
        hVar.f1247Y = 0;
        hVar.F(aVar9);
        hVar.H(iMax);
        hVar.G(aVar);
        hVar.E(iMax2);
        i12 = this.f6809d - i37;
        if (i12 < 0) {
            hVar.f1246X = 0;
        } else {
            hVar.f1246X = i12;
        }
        i13 = this.f6810e - i36;
        if (i13 < 0) {
            hVar.f1247Y = 0;
        } else {
            hVar.f1247Y = i13;
        }
        hVar.f1298r0 = iMax7;
        hVar.f1299s0 = iMax5;
        bVar = hVar.f1293m0;
        bVar.getClass();
        interfaceC0002b = hVar.f1295o0;
        size = hVar.f1366l0.size();
        iN2 = hVar.n();
        iK = hVar.k();
        zB = l.b(i9, 128);
        if (zB) {
            z8 = true;
        } else {
            z8 = true;
        }
        aVar2 = g.a.f1285c;
        if (z8) {
            i31 = 0;
            while (true) {
                if (i31 < size) {
                    z29 = z8;
                    gVar7 = hVar.f1366l0.get(i31);
                    i32 = i31;
                    aVarArr2 = gVar7.O;
                    if (aVarArr2[0] == aVar2) {
                        z30 = true;
                    } else {
                        z30 = false;
                    }
                    if (aVarArr2[1] == aVar2) {
                        z31 = true;
                    } else {
                        z31 = false;
                    }
                    if (z30) {
                        z32 = false;
                    } else {
                        z32 = false;
                    }
                    if (gVar7.t()) {
                        i31 = i32 + 1;
                        z8 = z29;
                    } else {
                        i31 = i32 + 1;
                        z8 = z29;
                    }
                    z9 = false;
                } else {
                    z9 = z8;
                }
            }
        } else {
            z9 = z8;
        }
        z10 = z9 & ((mode != 1073741824 && mode2 == 1073741824) || zB);
        if (z10) {
            int iMin5 = Math.min(iArr[0], i34);
            iMin = Math.min(iArr[1], i35);
            if (mode == 1073741824) {
                z23 = true;
            } else {
                z23 = true;
            }
            if (mode2 == 1073741824) {
                hVar.E(iMin);
                hVar.f1294n0.f1546b = z23;
            }
            if (mode == 1073741824) {
                z11 = z10;
                interfaceC0002b = interfaceC0002b;
                i14 = size;
                aVar3 = aVar8;
                aVar4 = aVar9;
                z24 = eVar.f1546b;
                hVar2 = eVar.f1545a;
                if (z24) {
                    it = hVar2.f1366l0.iterator();
                    while (it.hasNext()) {
                        g next7 = it.next();
                        next7.h();
                        next7.f1249a = false;
                        B.l lVar12 = next7.f1254d;
                        Iterator<g> it9 = it;
                        lVar12.f1590e.j = false;
                        lVar12.f1592g = false;
                        lVar12.n();
                        n nVar12 = next7.f1256e;
                        nVar12.f1590e.j = false;
                        nVar12.f1592g = false;
                        nVar12.m();
                        it = it9;
                    }
                    i28 = 0;
                    hVar2.h();
                    hVar2.f1249a = false;
                    B.l lVar13 = hVar2.f1254d;
                    lVar13.f1590e.j = false;
                    lVar13.f1592g = false;
                    lVar13.n();
                    n nVar13 = hVar2.f1256e;
                    nVar13.f1590e.j = false;
                    nVar13.f1592g = false;
                    nVar13.m();
                    eVar.c();
                } else {
                    i28 = 0;
                }
                eVar.b(eVar.f1548d);
                hVar2.f1243U = i28;
                hVar2.f1244V = i28;
                hVar2.f1254d.f1593h.d(i28);
                hVar2.f1256e.f1593h.d(i28);
                i29 = 1073741824;
                if (mode == 1073741824) {
                    zO = hVar.O(i28, zB);
                    i15 = 1;
                } else {
                    i15 = 0;
                    zO = true;
                }
                if (mode2 == 1073741824) {
                    zO &= hVar.O(1, zB);
                    i15++;
                }
            } else {
                z11 = z10;
                interfaceC0002b = interfaceC0002b;
                i14 = size;
                aVar3 = aVar8;
                aVar4 = aVar9;
                z24 = eVar.f1546b;
                hVar2 = eVar.f1545a;
                if (z24) {
                    it = hVar2.f1366l0.iterator();
                    while (it.hasNext()) {
                        g next8 = it.next();
                        next8.h();
                        next8.f1249a = false;
                        B.l lVar14 = next8.f1254d;
                        Iterator<g> it10 = it;
                        lVar14.f1590e.j = false;
                        lVar14.f1592g = false;
                        lVar14.n();
                        n nVar14 = next8.f1256e;
                        nVar14.f1590e.j = false;
                        nVar14.f1592g = false;
                        nVar14.m();
                        it = it10;
                    }
                    i28 = 0;
                    hVar2.h();
                    hVar2.f1249a = false;
                    B.l lVar15 = hVar2.f1254d;
                    lVar15.f1590e.j = false;
                    lVar15.f1592g = false;
                    lVar15.n();
                    n nVar15 = hVar2.f1256e;
                    nVar15.f1590e.j = false;
                    nVar15.f1592g = false;
                    nVar15.m();
                    eVar.c();
                } else {
                    i28 = 0;
                }
                eVar.b(eVar.f1548d);
                hVar2.f1243U = i28;
                hVar2.f1244V = i28;
                hVar2.f1254d.f1593h.d(i28);
                hVar2.f1256e.f1593h.d(i28);
                i29 = 1073741824;
                if (mode == 1073741824) {
                    zO = hVar.O(i28, zB);
                    i15 = 1;
                } else {
                    i15 = 0;
                    zO = true;
                }
                if (mode2 == 1073741824) {
                    zO &= hVar.O(1, zB);
                    i15++;
                }
            }
            if (zO) {
                if (mode == i29) {
                    z25 = true;
                } else {
                    z25 = false;
                }
                if (mode2 == i29) {
                    z26 = true;
                } else {
                    z26 = false;
                }
                hVar.I(z25, z26);
            }
        } else {
            z11 = z10;
            interfaceC0002b = interfaceC0002b;
            i14 = size;
            aVar3 = aVar8;
            aVar4 = aVar9;
            i15 = 0;
            zO = false;
        }
        if (zO) {
        }
        i16 = hVar.f1304x0;
        if (i14 > 0) {
            size3 = hVar.f1366l0.size();
            boolean zQ4 = hVar.Q(64);
            interfaceC0002b4 = hVar.f1295o0;
            i24 = 0;
            while (i24 < size3) {
                gVar6 = hVar.f1366l0.get(i24);
                if (!(gVar6 instanceof A.j)) {
                    i27 = size3;
                } else {
                    aVarJ = gVar6.j(0);
                    aVarJ2 = gVar6.j(1);
                    i27 = size3;
                    if (aVarJ == aVar2) {
                        z22 = false;
                    } else {
                        z22 = false;
                    }
                    if (!z22) {
                        if (aVarJ == aVar2) {
                            z22 = true;
                        }
                        if (aVarJ2 == aVar2) {
                            z22 = true;
                        }
                        if (aVarJ != aVar2) {
                        }
                    }
                    if (z22) {
                        bVar.a(interfaceC0002b4, gVar6, 0);
                    }
                }
                i24++;
                size3 = i27;
            }
            constraintLayout = ((b) interfaceC0002b4).f6883a;
            childCount = constraintLayout.getChildCount();
            while (i25 < childCount) {
                childAt = constraintLayout.getChildAt(i25);
                if (childAt instanceof Placeholder) {
                    placeholder = (Placeholder) childAt;
                    if (placeholder.f6905b == null) {
                        a aVar16 = (a) placeholder.getLayoutParams();
                        aVar7 = (a) placeholder.f6905b.getLayoutParams();
                        gVar3 = aVar7.f6868l0;
                        gVar3.f1253c0 = 0;
                        gVar4 = aVar16.f6868l0;
                        if (gVar4.O[0] != aVar3) {
                            gVar4.H(gVar3.n());
                        }
                        gVar5 = aVar16.f6868l0;
                        if (gVar5.O[1] != aVar3) {
                            gVar5.E(aVar7.f6868l0.k());
                        }
                        aVar7.f6868l0.f1253c0 = 8;
                    }
                }
            }
            arrayList4 = constraintLayout.f6807b;
            size4 = arrayList4.size();
            if (size4 > 0) {
                while (i26 < size4) {
                    arrayList4.get(i26).getClass();
                }
            }
        }
        bVar.c(hVar);
        arrayList = bVar.f1531a;
        size2 = arrayList.size();
        if (i14 > 0) {
            bVar.b(hVar, iN2, iK);
        }
        if (size2 > 0) {
            aVarArr = hVar.O;
            if (aVarArr[0] == aVar4) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (aVarArr[1] == aVar4) {
                z13 = true;
            } else {
                z13 = false;
            }
            int iN11 = hVar.n();
            h hVar7 = bVar.f1533c;
            iMax3 = Math.max(iN11, hVar7.f1246X);
            iMax4 = Math.max(hVar.k(), hVar7.f1247Y);
            i18 = 0;
            z14 = false;
            while (true) {
                aVar5 = e.a.f1217d;
                aVar6 = e.a.f1216c;
                if (i18 < size2) {
                    break;
                    break;
                }
                gVar2 = arrayList.get(i18);
                z19 = z13;
                if (gVar2 instanceof m) {
                    z20 = z12;
                    z21 = z14;
                    interfaceC0002b3 = interfaceC0002b;
                } else {
                    iN5 = gVar2.n();
                    z20 = z12;
                    iK4 = gVar2.k();
                    boolean z37 = z14;
                    interfaceC0002b3 = interfaceC0002b;
                    zA2 = z37 | bVar.a(interfaceC0002b3, gVar2, 1);
                    iN6 = gVar2.n();
                    iK5 = gVar2.k();
                    if (iN6 != iN5) {
                        gVar2.H(iN6);
                        if (z20) {
                            iMax3 = Math.max(iMax3, gVar2.i(aVar6).e() + gVar2.o() + gVar2.f1239Q);
                        }
                        zA2 = true;
                    }
                    if (iK5 != iK4) {
                        gVar2.E(iK5);
                        if (z19) {
                            iMax4 = Math.max(iMax4, gVar2.i(aVar5).e() + gVar2.p() + gVar2.f1240R);
                        }
                        zA2 = true;
                    }
                    z21 = zA2 | ((m) gVar2).f1361t0;
                }
                i18++;
                interfaceC0002b = interfaceC0002b3;
                z12 = z20;
                i16 = i16;
                z14 = z21;
                z13 = z19;
            }
            z15 = z13;
            int i48 = i16;
            z16 = z12;
            zA = z14;
            interfaceC0002b2 = interfaceC0002b;
            i19 = 0;
            while (i19 < 2) {
                i20 = 0;
                while (i20 < size2) {
                    gVar = arrayList.get(i20);
                    if (gVar instanceof k) {
                        if (gVar.f1253c0 == 8) {
                            i22 = i20;
                            arrayList3 = arrayList;
                            i23 = size2;
                        } else {
                            iN3 = gVar.n();
                            iK2 = gVar.k();
                            i22 = i20;
                            int i49 = gVar.f1245W;
                            arrayList3 = arrayList;
                            zA |= bVar.a(interfaceC0002b2, gVar, i19 == 1 ? 2 : 1);
                            iN4 = gVar.n();
                            i23 = size2;
                            iK3 = gVar.k();
                            if (iN4 != iN3) {
                                gVar.H(iN4);
                                if (z16) {
                                    iMax3 = Math.max(iMax3, gVar.i(aVar6).e() + gVar.o() + gVar.f1239Q);
                                }
                                zA = true;
                            }
                            if (iK3 != iK2) {
                                gVar.E(iK3);
                                if (z15) {
                                    iMax4 = Math.max(iMax4, gVar.i(aVar5).e() + gVar.p() + gVar.f1240R);
                                }
                                zA = true;
                            }
                            if (!gVar.f1281y) {
                            }
                        }
                    } else if (gVar.f1253c0 == 8) {
                        i22 = i20;
                        arrayList3 = arrayList;
                        i23 = size2;
                    } else {
                        iN3 = gVar.n();
                        iK2 = gVar.k();
                        i22 = i20;
                        int i410 = gVar.f1245W;
                        arrayList3 = arrayList;
                        zA |= bVar.a(interfaceC0002b2, gVar, i19 == 1 ? 2 : 1);
                        iN4 = gVar.n();
                        i23 = size2;
                        iK3 = gVar.k();
                        if (iN4 != iN3) {
                            gVar.H(iN4);
                            if (z16) {
                                iMax3 = Math.max(iMax3, gVar.i(aVar6).e() + gVar.o() + gVar.f1239Q);
                            }
                            zA = true;
                        }
                        if (iK3 != iK2) {
                            gVar.E(iK3);
                            if (z15) {
                                iMax4 = Math.max(iMax4, gVar.i(aVar5).e() + gVar.p() + gVar.f1240R);
                            }
                            zA = true;
                        }
                        if (!gVar.f1281y) {
                        }
                    }
                    i20 = i22 + 1;
                    arrayList = arrayList3;
                    size2 = i23;
                }
                arrayList2 = arrayList;
                i21 = size2;
                if (zA) {
                    break;
                    break;
                }
                bVar.b(hVar, iN2, iK);
                i19++;
                zA = false;
                arrayList = arrayList2;
                size2 = i21;
            }
            if (zA) {
                bVar.b(hVar, iN2, iK);
                if (hVar.n() < iMax3) {
                    hVar.H(iMax3);
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (hVar.k() < iMax4) {
                    hVar.E(iMax4);
                    z18 = true;
                } else {
                    z18 = z17;
                }
                if (z18) {
                    bVar.b(hVar, iN2, iK);
                }
            }
            i17 = i48;
        } else {
            i17 = i16;
        }
        hVar.f1304x0 = i17;
        c.f22425p = hVar.Q(512);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z8, int i9, int i10, int i11, int i12) {
        View content;
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            a aVar = (a) childAt.getLayoutParams();
            g gVar = aVar.f6868l0;
            if ((childAt.getVisibility() != 8 || aVar.f6845Y || aVar.f6846Z || zIsInEditMode) && !aVar.a0) {
                int iO = gVar.o();
                int iP = gVar.p();
                int iN = gVar.n() + iO;
                int iK = gVar.k() + iP;
                childAt.layout(iO, iP, iN, iK);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(iO, iP, iN, iK);
                }
            }
        }
        ArrayList<ConstraintHelper> arrayList = this.f6807b;
        int size = arrayList.size();
        if (size > 0) {
            for (int i14 = 0; i14 < size; i14++) {
                arrayList.get(i14).i();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:118:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:143:0x026b  */
    /* JADX WARN: Code duplicated, block: B:152:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:197:0x03d3  */
    /* JADX WARN: Code duplicated, block: B:199:0x03dd  */
    /* JADX WARN: Code duplicated, block: B:202:0x03eb  */
    /* JADX WARN: Code duplicated, block: B:209:0x0409  */
    /* JADX WARN: Code duplicated, block: B:211:0x0413  */
    /* JADX WARN: Code duplicated, block: B:212:0x0423  */
    /* JADX WARN: Code duplicated, block: B:214:0x042b  */
    /* JADX WARN: Code duplicated, block: B:219:0x0450  */
    /* JADX WARN: Code duplicated, block: B:222:0x0458  */
    /* JADX WARN: Code duplicated, block: B:224:0x0462  */
    /* JADX WARN: Code duplicated, block: B:227:0x0474  */
    /* JADX WARN: Code duplicated, block: B:234:0x0497  */
    /* JADX WARN: Code duplicated, block: B:241:0x04ec  */
    /* JADX WARN: Code duplicated, block: B:244:0x04f3  */
    /* JADX WARN: Code duplicated, block: B:247:0x04fb  */
    /* JADX WARN: Code duplicated, block: B:319:0x061d  */
    @Override // android.view.View
    public void onMeasure(int i9, int i10) {
        boolean z8;
        boolean z9;
        g gVar;
        e.a aVar;
        g gVar2;
        e.a aVar2;
        e.a aVar3;
        e.a aVar4;
        g gVar3;
        e.a aVar5;
        int i11;
        int i12;
        int i13;
        e.a aVar6;
        e.a aVar7;
        g gVar4;
        int i14;
        e.a aVar8;
        int i15;
        g gVar5;
        g gVar6;
        e.a aVar9;
        int i16;
        float f6;
        g gVar7;
        g gVar8;
        g gVar9;
        e.a aVar10;
        g gVar10;
        int i17;
        int i18;
        int i19;
        float fAbs;
        int i20;
        g gVar11;
        byte b9;
        boolean z10;
        boolean z11;
        g gVar12;
        int i21 = 0;
        boolean z12 = true;
        if (!this.f6813h) {
            int childCount = getChildCount();
            for (int i22 = 0; i22 < childCount; i22++) {
                if (getChildAt(i22).isLayoutRequested()) {
                    this.f6813h = true;
                    break;
                }
            }
        }
        boolean z13 = this.f6813h;
        h hVar = this.f6808c;
        if (!z13) {
            int i23 = this.f6820p;
            if (i23 == i9 && this.f6821q == i10) {
                g(i9, i10, hVar.n(), hVar.k(), hVar.f1305y0, hVar.f1306z0);
                return;
            }
            if (i23 == i9 && View.MeasureSpec.getMode(i9) == 1073741824 && View.MeasureSpec.getMode(i10) == Integer.MIN_VALUE && View.MeasureSpec.getMode(this.f6821q) == Integer.MIN_VALUE && View.MeasureSpec.getSize(i10) >= hVar.k()) {
                this.f6820p = i9;
                this.f6821q = i10;
                g(i9, i10, hVar.n(), hVar.k(), hVar.f1305y0, hVar.f1306z0);
                return;
            }
        }
        this.f6820p = i9;
        this.f6821q = i10;
        hVar.f1296p0 = e();
        if (this.f6813h) {
            this.f6813h = false;
            int childCount2 = getChildCount();
            int i24 = 0;
            while (true) {
                if (i24 >= childCount2) {
                    z8 = false;
                    break;
                } else {
                    if (getChildAt(i24).isLayoutRequested()) {
                        z8 = true;
                        break;
                    }
                    i24++;
                }
            }
            if (z8) {
                boolean zIsInEditMode = isInEditMode();
                int childCount3 = getChildCount();
                for (int i25 = 0; i25 < childCount3; i25++) {
                    g gVarC = c(getChildAt(i25));
                    if (gVarC != null) {
                        gVarC.y();
                    }
                }
                SparseArray<View> sparseArray = this.f6806a;
                if (zIsInEditMode) {
                    int i26 = 0;
                    while (i26 < childCount3) {
                        View childAt = getChildAt(i26);
                        try {
                            String resourceName = getResources().getResourceName(childAt.getId());
                            Integer numValueOf = Integer.valueOf(childAt.getId());
                            if (resourceName != null) {
                                z11 = z12;
                                try {
                                    if (this.f6817m == null) {
                                        this.f6817m = new HashMap<>();
                                    }
                                    int iIndexOf = resourceName.indexOf("/");
                                    this.f6817m.put(iIndexOf != -1 ? resourceName.substring(iIndexOf + 1) : resourceName, numValueOf);
                                } catch (Resources.NotFoundException unused) {
                                }
                            } else {
                                z11 = z12;
                            }
                            int iIndexOf2 = resourceName.indexOf(47);
                            if (iIndexOf2 != -1) {
                                resourceName = resourceName.substring(iIndexOf2 + 1);
                            }
                            int id = childAt.getId();
                            if (id != 0) {
                                View viewFindViewById = sparseArray.get(id);
                                if (viewFindViewById == null && (viewFindViewById = findViewById(id)) != null && viewFindViewById != this && viewFindViewById.getParent() == this) {
                                    onViewAdded(viewFindViewById);
                                }
                                gVar12 = viewFindViewById == this ? hVar : viewFindViewById == null ? null : ((a) viewFindViewById.getLayoutParams()).f6868l0;
                            }
                            gVar12.f1255d0 = resourceName;
                        } catch (Resources.NotFoundException unused2) {
                            z11 = z12;
                        }
                        i26++;
                        z12 = z11;
                    }
                }
                boolean z14 = z12;
                if (this.f6816l != -1) {
                    for (int i27 = 0; i27 < childCount3; i27++) {
                        View childAt2 = getChildAt(i27);
                        if (childAt2.getId() == this.f6816l && (childAt2 instanceof Constraints)) {
                            this.j = ((Constraints) childAt2).getConstraintSet();
                        }
                    }
                }
                androidx.constraintlayout.widget.b bVar = this.j;
                if (bVar != null) {
                    bVar.a(this);
                }
                hVar.f1366l0.clear();
                ArrayList<ConstraintHelper> arrayList = this.f6807b;
                int size = arrayList.size();
                if (size > 0) {
                    int i28 = 0;
                    while (i28 < size) {
                        ConstraintHelper constraintHelper = arrayList.get(i28);
                        if (constraintHelper.isInEditMode()) {
                            constraintHelper.setIds(constraintHelper.f6801e);
                        }
                        k kVar = constraintHelper.f6800d;
                        if (kVar == null) {
                            z10 = z8;
                        } else {
                            kVar.f1353m0 = i21;
                            Arrays.fill(kVar.f1352l0, (Object) null);
                            int i29 = i21;
                            while (i29 < constraintHelper.f6798b) {
                                int i30 = constraintHelper.f6797a[i29];
                                View viewB = b(i30);
                                if (viewB == null) {
                                    Integer numValueOf2 = Integer.valueOf(i30);
                                    HashMap<Integer, String> map = constraintHelper.f6804h;
                                    String str = map.get(numValueOf2);
                                    int iE = constraintHelper.e(this, str);
                                    if (iE != 0) {
                                        constraintHelper.f6797a[i29] = iE;
                                        map.put(Integer.valueOf(iE), str);
                                        viewB = b(iE);
                                    }
                                }
                                View view = viewB;
                                if (view != null) {
                                    k kVar2 = constraintHelper.f6800d;
                                    g gVarC2 = c(view);
                                    kVar2.getClass();
                                    if (gVarC2 != kVar2 && gVarC2 != null) {
                                        int i31 = kVar2.f1353m0 + 1;
                                        g[] gVarArr = kVar2.f1352l0;
                                        if (i31 > gVarArr.length) {
                                            kVar2.f1352l0 = (g[]) Arrays.copyOf(gVarArr, gVarArr.length * 2);
                                        }
                                        g[] gVarArr2 = kVar2.f1352l0;
                                        int i32 = kVar2.f1353m0;
                                        gVarArr2[i32] = gVarC2;
                                        kVar2.f1353m0 = i32 + 1;
                                    }
                                }
                                i29++;
                                z8 = z8;
                            }
                            z10 = z8;
                            constraintHelper.f6800d.L();
                        }
                        i28++;
                        z8 = z10;
                        i21 = 0;
                    }
                }
                z9 = z8;
                int i33 = 2;
                int i34 = 0;
                while (i34 < childCount3) {
                    View childAt3 = getChildAt(i34);
                    if (childAt3 instanceof Placeholder) {
                        Placeholder placeholder = (Placeholder) childAt3;
                        if (placeholder.f6904a == -1 && !placeholder.isInEditMode()) {
                            placeholder.setVisibility(placeholder.f6906c);
                        }
                        View viewFindViewById2 = findViewById(placeholder.f6904a);
                        placeholder.f6905b = viewFindViewById2;
                        if (viewFindViewById2 != null) {
                            ((a) viewFindViewById2.getLayoutParams()).a0 = z14;
                            placeholder.f6905b.setVisibility(0);
                            placeholder.setVisibility(0);
                        }
                    }
                    i34++;
                    z14 = true;
                }
                SparseArray<g> sparseArray2 = this.f6818n;
                sparseArray2.clear();
                sparseArray2.put(0, hVar);
                sparseArray2.put(getId(), hVar);
                for (int i35 = 0; i35 < childCount3; i35++) {
                    View childAt4 = getChildAt(i35);
                    sparseArray2.put(childAt4.getId(), c(childAt4));
                }
                int i36 = 0;
                while (i36 < childCount3) {
                    View childAt5 = getChildAt(i36);
                    g gVarC3 = c(childAt5);
                    if (gVarC3 != null) {
                        a aVar11 = (a) childAt5.getLayoutParams();
                        hVar.f1366l0.add(gVarC3);
                        g gVar13 = gVarC3.f1238P;
                        if (gVar13 != null) {
                            ((A.n) gVar13).f1366l0.remove(gVarC3);
                            gVarC3.y();
                        }
                        gVarC3.f1238P = hVar;
                        aVar11.a();
                        gVarC3.f1253c0 = childAt5.getVisibility();
                        if (aVar11.a0) {
                            gVarC3.f1282z = true;
                            gVarC3.f1253c0 = 8;
                        }
                        gVarC3.f1251b0 = childAt5;
                        if (childAt5 instanceof ConstraintHelper) {
                            ((ConstraintHelper) childAt5).h(gVarC3, hVar.f1296p0);
                        }
                        if (aVar11.f6845Y) {
                            A.j jVar = (A.j) gVarC3;
                            int i37 = aVar11.f6863i0;
                            int i38 = aVar11.f6864j0;
                            float f9 = aVar11.f6866k0;
                            if (f9 == -1.0f) {
                                b9 = -1;
                                if (i37 != -1) {
                                    if (i37 > -1) {
                                        jVar.f1346l0 = -1.0f;
                                        jVar.f1347m0 = i37;
                                        jVar.f1348n0 = -1;
                                    }
                                } else if (i38 != -1 && i38 > -1) {
                                    jVar.f1346l0 = -1.0f;
                                    jVar.f1347m0 = -1;
                                    jVar.f1348n0 = i38;
                                }
                            } else if (f9 > -1.0f) {
                                jVar.f1346l0 = f9;
                                b9 = -1;
                                jVar.f1347m0 = -1;
                                jVar.f1348n0 = -1;
                            }
                        } else {
                            int i39 = aVar11.f6849b0;
                            int i40 = aVar11.f6851c0;
                            int i41 = aVar11.f6853d0;
                            int i42 = aVar11.f6855e0;
                            int i43 = aVar11.f6857f0;
                            int i44 = aVar11.f6859g0;
                            float f10 = aVar11.f6861h0;
                            zIsInEditMode = zIsInEditMode;
                            int i45 = aVar11.f6869m;
                            e.a aVar12 = e.a.f1216c;
                            e.a aVar13 = e.a.f1214a;
                            e.a aVar14 = e.a.f1217d;
                            e.a aVar15 = e.a.f1215b;
                            childCount3 = childCount3;
                            if (i45 != -1) {
                                g gVar14 = sparseArray2.get(i45);
                                if (gVar14 != null) {
                                    float f11 = aVar11.f6871o;
                                    int i46 = aVar11.f6870n;
                                    e.a aVar16 = e.a.f1219f;
                                    gVarC3.r(aVar16, gVar14, aVar16, i46, 0);
                                    gVar11 = gVarC3;
                                    gVar11.f1280x = f11;
                                } else {
                                    gVar11 = gVarC3;
                                }
                                sparseArray2 = sparseArray2;
                                gVar6 = gVar11;
                                sparseArray = sparseArray;
                                i36 = i36;
                                aVar5 = aVar12;
                                aVar4 = aVar13;
                                aVar9 = aVar14;
                                aVar8 = aVar15;
                            } else {
                                if (i39 != -1) {
                                    g gVar15 = sparseArray2.get(i39);
                                    if (gVar15 != null) {
                                        gVar = gVarC3;
                                        aVar = aVar13;
                                        gVar.r(aVar, gVar15, aVar13, ((ViewGroup.MarginLayoutParams) aVar11).leftMargin, i43);
                                    } else {
                                        gVar = gVarC3;
                                        aVar = aVar13;
                                    }
                                } else {
                                    gVar = gVarC3;
                                    aVar = aVar13;
                                    if (i40 != -1 && (gVar2 = sparseArray2.get(i40)) != null) {
                                        gVar.r(aVar, gVar2, aVar12, ((ViewGroup.MarginLayoutParams) aVar11).leftMargin, i43);
                                        aVar2 = aVar;
                                        aVar3 = aVar12;
                                    }
                                    if (i41 != -1) {
                                        gVar10 = sparseArray2.get(i41);
                                        if (gVar10 != null) {
                                            gVar.r(aVar3, gVar10, aVar2, ((ViewGroup.MarginLayoutParams) aVar11).rightMargin, i44);
                                        }
                                        aVar4 = aVar2;
                                    } else {
                                        aVar4 = aVar2;
                                        if (i42 != -1 && (gVar3 = sparseArray2.get(i42)) != null) {
                                            gVar.r(aVar3, gVar3, aVar3, ((ViewGroup.MarginLayoutParams) aVar11).rightMargin, i44);
                                        }
                                    }
                                    aVar5 = aVar3;
                                    i11 = aVar11.f6860h;
                                    if (i11 != -1) {
                                        gVar9 = sparseArray2.get(i11);
                                        if (gVar9 != null) {
                                            aVar10 = aVar15;
                                            gVar.r(aVar10, gVar9, aVar15, ((ViewGroup.MarginLayoutParams) aVar11).topMargin, aVar11.f6876u);
                                        } else {
                                            aVar10 = aVar15;
                                        }
                                        aVar6 = aVar10;
                                        aVar7 = aVar14;
                                        i13 = -1;
                                    } else {
                                        i12 = aVar11.f6862i;
                                        i13 = -1;
                                        if (i12 != -1 || (gVar4 = sparseArray2.get(i12)) == null) {
                                            aVar6 = aVar15;
                                            aVar7 = aVar14;
                                        } else {
                                            gVar.r(aVar15, gVar4, aVar14, ((ViewGroup.MarginLayoutParams) aVar11).topMargin, aVar11.f6876u);
                                            aVar6 = aVar15;
                                            aVar7 = aVar14;
                                        }
                                    }
                                    i14 = aVar11.j;
                                    if (i14 != i13) {
                                        gVar8 = sparseArray2.get(i14);
                                        if (gVar8 != null) {
                                            gVar.r(aVar7, gVar8, aVar6, ((ViewGroup.MarginLayoutParams) aVar11).bottomMargin, aVar11.f6878w);
                                        }
                                        aVar8 = aVar6;
                                    } else {
                                        aVar8 = aVar6;
                                        i15 = aVar11.f6865k;
                                        if (i15 != i13 && (gVar5 = sparseArray2.get(i15)) != null) {
                                            gVar.r(aVar7, gVar5, aVar7, ((ViewGroup.MarginLayoutParams) aVar11).bottomMargin, aVar11.f6878w);
                                        }
                                    }
                                    gVar6 = gVar;
                                    aVar9 = aVar7;
                                    i16 = aVar11.f6867l;
                                    if (i16 != -1) {
                                        View view2 = sparseArray.get(i16);
                                        gVar7 = sparseArray2.get(aVar11.f6867l);
                                        if (gVar7 != null || view2 == null) {
                                            sparseArray2 = sparseArray2;
                                        } else {
                                            sparseArray2 = sparseArray2;
                                            if (view2.getLayoutParams() instanceof a) {
                                                a aVar17 = (a) view2.getLayoutParams();
                                                aVar11.f6844X = true;
                                                aVar17.f6844X = true;
                                                e.a aVar18 = e.a.f1218e;
                                                gVar6.i(aVar18).b(gVar7.i(aVar18), 0, -1, true);
                                                gVar6.f1281y = true;
                                                aVar17.f6868l0.f1281y = true;
                                                gVar6.i(aVar8).j();
                                                gVar6.i(aVar9).j();
                                            }
                                        }
                                    } else {
                                        sparseArray2 = sparseArray2;
                                    }
                                    if (f10 >= 0.0f) {
                                        gVar6.f1248Z = f10;
                                    }
                                    f6 = aVar11.f6822A;
                                    if (f6 >= 0.0f) {
                                        gVar6.a0 = f6;
                                    }
                                }
                                aVar2 = aVar;
                                aVar3 = aVar12;
                                if (i41 != -1) {
                                    gVar10 = sparseArray2.get(i41);
                                    if (gVar10 != null) {
                                        gVar.r(aVar3, gVar10, aVar2, ((ViewGroup.MarginLayoutParams) aVar11).rightMargin, i44);
                                    }
                                    aVar4 = aVar2;
                                } else {
                                    aVar4 = aVar2;
                                    if (i42 != -1) {
                                        gVar.r(aVar3, gVar3, aVar3, ((ViewGroup.MarginLayoutParams) aVar11).rightMargin, i44);
                                    }
                                }
                                aVar5 = aVar3;
                                i11 = aVar11.f6860h;
                                if (i11 != -1) {
                                    gVar9 = sparseArray2.get(i11);
                                    if (gVar9 != null) {
                                        aVar10 = aVar15;
                                        gVar.r(aVar10, gVar9, aVar15, ((ViewGroup.MarginLayoutParams) aVar11).topMargin, aVar11.f6876u);
                                    } else {
                                        aVar10 = aVar15;
                                    }
                                    aVar6 = aVar10;
                                    aVar7 = aVar14;
                                    i13 = -1;
                                } else {
                                    i12 = aVar11.f6862i;
                                    i13 = -1;
                                    if (i12 != -1) {
                                        aVar6 = aVar15;
                                        aVar7 = aVar14;
                                    } else {
                                        aVar6 = aVar15;
                                        aVar7 = aVar14;
                                    }
                                }
                                i14 = aVar11.j;
                                if (i14 != i13) {
                                    gVar8 = sparseArray2.get(i14);
                                    if (gVar8 != null) {
                                        gVar.r(aVar7, gVar8, aVar6, ((ViewGroup.MarginLayoutParams) aVar11).bottomMargin, aVar11.f6878w);
                                    }
                                    aVar8 = aVar6;
                                } else {
                                    aVar8 = aVar6;
                                    i15 = aVar11.f6865k;
                                    if (i15 != i13) {
                                        gVar.r(aVar7, gVar5, aVar7, ((ViewGroup.MarginLayoutParams) aVar11).bottomMargin, aVar11.f6878w);
                                    }
                                }
                                gVar6 = gVar;
                                aVar9 = aVar7;
                                i16 = aVar11.f6867l;
                                if (i16 != -1) {
                                    View view3 = sparseArray.get(i16);
                                    gVar7 = sparseArray2.get(aVar11.f6867l);
                                    if (gVar7 != null) {
                                        sparseArray2 = sparseArray2;
                                    } else {
                                        sparseArray2 = sparseArray2;
                                    }
                                } else {
                                    sparseArray2 = sparseArray2;
                                }
                                if (f10 >= 0.0f) {
                                    gVar6.f1248Z = f10;
                                }
                                f6 = aVar11.f6822A;
                                if (f6 >= 0.0f) {
                                    gVar6.a0 = f6;
                                }
                            }
                            if (zIsInEditMode && ((i20 = aVar11.f6836P) != -1 || aVar11.f6837Q != -1)) {
                                int i47 = aVar11.f6837Q;
                                gVar6.f1243U = i20;
                                gVar6.f1244V = i47;
                            }
                            boolean z15 = aVar11.f6842V;
                            g.a aVar19 = g.a.f1284b;
                            g.a aVar20 = g.a.f1283a;
                            g.a aVar21 = g.a.f1286d;
                            g.a aVar22 = g.a.f1285c;
                            if (z15) {
                                gVar6.F(aVar20);
                                gVar6.H(((ViewGroup.MarginLayoutParams) aVar11).width);
                                if (((ViewGroup.MarginLayoutParams) aVar11).width == -2) {
                                    gVar6.F(aVar19);
                                }
                            } else if (((ViewGroup.MarginLayoutParams) aVar11).width == -1) {
                                if (aVar11.f6839S) {
                                    gVar6.F(aVar22);
                                } else {
                                    gVar6.F(aVar21);
                                }
                                gVar6.i(aVar4).f1211g = ((ViewGroup.MarginLayoutParams) aVar11).leftMargin;
                                gVar6.i(aVar5).f1211g = ((ViewGroup.MarginLayoutParams) aVar11).rightMargin;
                            } else {
                                gVar6.F(aVar22);
                                gVar6.H(0);
                            }
                            if (aVar11.f6843W) {
                                i17 = -1;
                                gVar6.G(aVar20);
                                gVar6.E(((ViewGroup.MarginLayoutParams) aVar11).height);
                                if (((ViewGroup.MarginLayoutParams) aVar11).height == -2) {
                                    gVar6.G(aVar19);
                                }
                            } else {
                                i17 = -1;
                                if (((ViewGroup.MarginLayoutParams) aVar11).height == -1) {
                                    if (aVar11.f6840T) {
                                        gVar6.G(aVar22);
                                    } else {
                                        gVar6.G(aVar21);
                                    }
                                    gVar6.i(aVar8).f1211g = ((ViewGroup.MarginLayoutParams) aVar11).topMargin;
                                    gVar6.i(aVar9).f1211g = ((ViewGroup.MarginLayoutParams) aVar11).bottomMargin;
                                } else {
                                    gVar6.G(aVar22);
                                    gVar6.E(0);
                                }
                            }
                            String str2 = aVar11.f6823B;
                            if (str2 == null || str2.length() == 0) {
                                gVar6.f1241S = 0.0f;
                            } else {
                                int length = str2.length();
                                int iIndexOf3 = str2.indexOf(44);
                                if (iIndexOf3 <= 0 || iIndexOf3 >= length - 1) {
                                    i18 = i17;
                                    i19 = 0;
                                } else {
                                    String strSubstring = str2.substring(0, iIndexOf3);
                                    i18 = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : i17;
                                    i19 = iIndexOf3 + 1;
                                }
                                int iIndexOf4 = str2.indexOf(58);
                                if (iIndexOf4 < 0 || iIndexOf4 >= length - 1) {
                                    String strSubstring2 = str2.substring(i19);
                                    if (strSubstring2.length() > 0) {
                                        fAbs = Float.parseFloat(strSubstring2);
                                    } else {
                                        fAbs = 0.0f;
                                    }
                                } else {
                                    String strSubstring3 = str2.substring(i19, iIndexOf4);
                                    String strSubstring4 = str2.substring(iIndexOf4 + 1);
                                    if (strSubstring3.length() <= 0 || strSubstring4.length() <= 0) {
                                        fAbs = 0.0f;
                                    } else {
                                        try {
                                            float f12 = Float.parseFloat(strSubstring3);
                                            float f13 = Float.parseFloat(strSubstring4);
                                            if (f12 <= 0.0f || f13 <= 0.0f) {
                                                fAbs = 0.0f;
                                            } else {
                                                fAbs = i18 == 1 ? Math.abs(f13 / f12) : Math.abs(f12 / f13);
                                            }
                                        } catch (NumberFormatException unused3) {
                                        }
                                    }
                                }
                                if (fAbs > 0.0f) {
                                    gVar6.f1241S = fAbs;
                                    gVar6.f1242T = i18;
                                }
                            }
                            float f14 = aVar11.f6825D;
                            float[] fArr = gVar6.f1261g0;
                            fArr[0] = f14;
                            fArr[1] = aVar11.f6826E;
                            gVar6.f1257e0 = aVar11.f6827F;
                            gVar6.f1259f0 = aVar11.f6828G;
                            int i48 = aVar11.f6829H;
                            int i49 = aVar11.f6831J;
                            int i50 = aVar11.f6833L;
                            float f15 = aVar11.f6835N;
                            gVar6.f1269l = i48;
                            gVar6.f1272o = i49;
                            if (i50 == Integer.MAX_VALUE) {
                                i50 = 0;
                            }
                            gVar6.f1273p = i50;
                            gVar6.f1274q = f15;
                            if (f15 > 0.0f && f15 < 1.0f && i48 == 0) {
                                gVar6.f1269l = i33;
                            }
                            int i51 = aVar11.f6830I;
                            int i52 = aVar11.f6832K;
                            int i53 = aVar11.f6834M;
                            float f16 = aVar11.O;
                            gVar6.f1270m = i51;
                            gVar6.f1275r = i52;
                            if (i53 == Integer.MAX_VALUE) {
                                i53 = 0;
                            }
                            gVar6.f1276s = i53;
                            gVar6.t = f16;
                            if (f16 <= 0.0f || f16 >= 1.0f || i51 != 0) {
                                i33 = 2;
                            } else {
                                i33 = 2;
                                gVar6.f1270m = 2;
                            }
                        }
                    }
                    i36++;
                    i33 = i33;
                    sparseArray2 = sparseArray2;
                    zIsInEditMode = zIsInEditMode;
                    sparseArray = sparseArray;
                    childCount3 = childCount3;
                }
            } else {
                z9 = z8;
            }
            if (z9) {
                hVar.f1293m0.c(hVar);
            }
        }
        h(hVar, this.f6814i, i9, i10);
        g(i9, i10, hVar.n(), hVar.k(), hVar.f1305y0, hVar.f1306z0);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        g gVarC = c(view);
        if ((view instanceof Guideline) && !(gVarC instanceof A.j)) {
            a aVar = (a) view.getLayoutParams();
            A.j jVar = new A.j();
            aVar.f6868l0 = jVar;
            aVar.f6845Y = true;
            jVar.L(aVar.f6838R);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.k();
            ((a) view.getLayoutParams()).f6846Z = true;
            ArrayList<ConstraintHelper> arrayList = this.f6807b;
            if (!arrayList.contains(constraintHelper)) {
                arrayList.add(constraintHelper);
            }
        }
        this.f6806a.put(view.getId(), view);
        this.f6813h = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f6806a.remove(view.getId());
        g gVarC = c(view);
        this.f6808c.f1366l0.remove(gVarC);
        gVarC.y();
        this.f6807b.remove(view);
        this.f6813h = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.f6813h = true;
        super.requestLayout();
    }

    public void setConstraintSet(androidx.constraintlayout.widget.b bVar) {
        this.j = bVar;
    }

    @Override // android.view.View
    public void setId(int i9) {
        int id = getId();
        SparseArray<View> sparseArray = this.f6806a;
        sparseArray.remove(id);
        super.setId(i9);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i9) {
        if (i9 == this.f6812g) {
            return;
        }
        this.f6812g = i9;
        requestLayout();
    }

    public void setMaxWidth(int i9) {
        if (i9 == this.f6811f) {
            return;
        }
        this.f6811f = i9;
        requestLayout();
    }

    public void setMinHeight(int i9) {
        if (i9 == this.f6810e) {
            return;
        }
        this.f6810e = i9;
        requestLayout();
    }

    public void setMinWidth(int i9) {
        if (i9 == this.f6809d) {
            return;
        }
        this.f6809d = i9;
        requestLayout();
    }

    public void setOnConstraintsChanged(C.b bVar) {
        C.a aVar = this.f6815k;
        if (aVar != null) {
            aVar.getClass();
        }
    }

    public void setOptimizationLevel(int i9) {
        this.f6814i = i9;
        h hVar = this.f6808c;
        hVar.f1304x0 = i9;
        c.f22425p = hVar.Q(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i9) {
        super(context, attributeSet, i9);
        this.f6806a = new SparseArray<>();
        this.f6807b = new ArrayList<>(4);
        this.f6808c = new h();
        this.f6809d = 0;
        this.f6810e = 0;
        this.f6811f = Integer.MAX_VALUE;
        this.f6812g = Integer.MAX_VALUE;
        this.f6813h = true;
        this.f6814i = FeedManager.FILE_TYPE_INT_AIGC_ORIGIN_PNG;
        this.j = null;
        this.f6815k = null;
        this.f6816l = -1;
        this.f6817m = new HashMap<>();
        this.f6818n = new SparseArray<>();
        this.f6819o = new b(this);
        this.f6820p = 0;
        this.f6821q = 0;
        d(attributeSet, i9);
    }

    public static class a extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public float f6822A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public String f6823B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public final int f6824C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public float f6825D;

        /* JADX INFO: renamed from: E, reason: collision with root package name */
        public float f6826E;

        /* JADX INFO: renamed from: F, reason: collision with root package name */
        public int f6827F;

        /* JADX INFO: renamed from: G, reason: collision with root package name */
        public int f6828G;

        /* JADX INFO: renamed from: H, reason: collision with root package name */
        public int f6829H;

        /* JADX INFO: renamed from: I, reason: collision with root package name */
        public int f6830I;

        /* JADX INFO: renamed from: J, reason: collision with root package name */
        public int f6831J;

        /* JADX INFO: renamed from: K, reason: collision with root package name */
        public int f6832K;

        /* JADX INFO: renamed from: L, reason: collision with root package name */
        public int f6833L;

        /* JADX INFO: renamed from: M, reason: collision with root package name */
        public int f6834M;

        /* JADX INFO: renamed from: N, reason: collision with root package name */
        public float f6835N;
        public float O;

        /* JADX INFO: renamed from: P, reason: collision with root package name */
        public int f6836P;

        /* JADX INFO: renamed from: Q, reason: collision with root package name */
        public int f6837Q;

        /* JADX INFO: renamed from: R, reason: collision with root package name */
        public int f6838R;

        /* JADX INFO: renamed from: S, reason: collision with root package name */
        public boolean f6839S;

        /* JADX INFO: renamed from: T, reason: collision with root package name */
        public boolean f6840T;

        /* JADX INFO: renamed from: U, reason: collision with root package name */
        public String f6841U;

        /* JADX INFO: renamed from: V, reason: collision with root package name */
        public boolean f6842V;

        /* JADX INFO: renamed from: W, reason: collision with root package name */
        public boolean f6843W;

        /* JADX INFO: renamed from: X, reason: collision with root package name */
        public boolean f6844X;

        /* JADX INFO: renamed from: Y, reason: collision with root package name */
        public boolean f6845Y;

        /* JADX INFO: renamed from: Z, reason: collision with root package name */
        public boolean f6846Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f6847a;
        public boolean a0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f6848b;

        /* JADX INFO: renamed from: b0, reason: collision with root package name */
        public int f6849b0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f6850c;

        /* JADX INFO: renamed from: c0, reason: collision with root package name */
        public int f6851c0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f6852d;

        /* JADX INFO: renamed from: d0, reason: collision with root package name */
        public int f6853d0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f6854e;

        /* JADX INFO: renamed from: e0, reason: collision with root package name */
        public int f6855e0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f6856f;

        /* JADX INFO: renamed from: f0, reason: collision with root package name */
        public int f6857f0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f6858g;

        /* JADX INFO: renamed from: g0, reason: collision with root package name */
        public int f6859g0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f6860h;

        /* JADX INFO: renamed from: h0, reason: collision with root package name */
        public float f6861h0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f6862i;

        /* JADX INFO: renamed from: i0, reason: collision with root package name */
        public int f6863i0;
        public int j;

        /* JADX INFO: renamed from: j0, reason: collision with root package name */
        public int f6864j0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f6865k;

        /* JADX INFO: renamed from: k0, reason: collision with root package name */
        public float f6866k0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f6867l;

        /* JADX INFO: renamed from: l0, reason: collision with root package name */
        public g f6868l0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f6869m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f6870n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public float f6871o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f6872p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f6873q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f6874r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f6875s;
        public final int t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public int f6876u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final int f6877v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f6878w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public int f6879x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f6880y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public float f6881z;

        /* JADX INFO: renamed from: androidx.constraintlayout.widget.ConstraintLayout$a$a, reason: collision with other inner class name */
        public static class C0096a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final SparseIntArray f6882a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f6882a = sparseIntArray;
                sparseIntArray.append(64, 8);
                sparseIntArray.append(65, 9);
                sparseIntArray.append(67, 10);
                sparseIntArray.append(68, 11);
                sparseIntArray.append(74, 12);
                sparseIntArray.append(73, 13);
                sparseIntArray.append(46, 14);
                sparseIntArray.append(45, 15);
                sparseIntArray.append(43, 16);
                sparseIntArray.append(47, 2);
                sparseIntArray.append(49, 3);
                sparseIntArray.append(48, 4);
                sparseIntArray.append(82, 49);
                sparseIntArray.append(83, 50);
                sparseIntArray.append(53, 5);
                sparseIntArray.append(54, 6);
                sparseIntArray.append(55, 7);
                sparseIntArray.append(0, 1);
                sparseIntArray.append(69, 17);
                sparseIntArray.append(70, 18);
                sparseIntArray.append(52, 19);
                sparseIntArray.append(51, 20);
                sparseIntArray.append(86, 21);
                sparseIntArray.append(89, 22);
                sparseIntArray.append(87, 23);
                sparseIntArray.append(84, 24);
                sparseIntArray.append(88, 25);
                sparseIntArray.append(85, 26);
                sparseIntArray.append(60, 29);
                sparseIntArray.append(75, 30);
                sparseIntArray.append(50, 44);
                sparseIntArray.append(62, 45);
                sparseIntArray.append(77, 46);
                sparseIntArray.append(61, 47);
                sparseIntArray.append(76, 48);
                sparseIntArray.append(41, 27);
                sparseIntArray.append(40, 28);
                sparseIntArray.append(78, 31);
                sparseIntArray.append(56, 32);
                sparseIntArray.append(80, 33);
                sparseIntArray.append(79, 34);
                sparseIntArray.append(81, 35);
                sparseIntArray.append(58, 36);
                sparseIntArray.append(57, 37);
                sparseIntArray.append(59, 38);
                sparseIntArray.append(63, 39);
                sparseIntArray.append(72, 40);
                sparseIntArray.append(66, 41);
                sparseIntArray.append(44, 42);
                sparseIntArray.append(42, 43);
                sparseIntArray.append(71, 51);
            }
        }

        public a(Context context, AttributeSet attributeSet) {
            int i9;
            super(context, attributeSet);
            this.f6847a = -1;
            this.f6848b = -1;
            this.f6850c = -1.0f;
            this.f6852d = -1;
            this.f6854e = -1;
            this.f6856f = -1;
            this.f6858g = -1;
            this.f6860h = -1;
            this.f6862i = -1;
            this.j = -1;
            this.f6865k = -1;
            this.f6867l = -1;
            this.f6869m = -1;
            this.f6870n = 0;
            this.f6871o = 0.0f;
            this.f6872p = -1;
            this.f6873q = -1;
            this.f6874r = -1;
            this.f6875s = -1;
            this.t = -1;
            this.f6876u = -1;
            this.f6877v = -1;
            this.f6878w = -1;
            this.f6879x = -1;
            this.f6880y = -1;
            this.f6881z = 0.5f;
            this.f6822A = 0.5f;
            this.f6823B = null;
            this.f6824C = 1;
            this.f6825D = -1.0f;
            this.f6826E = -1.0f;
            this.f6827F = 0;
            this.f6828G = 0;
            this.f6829H = 0;
            this.f6830I = 0;
            this.f6831J = 0;
            this.f6832K = 0;
            this.f6833L = 0;
            this.f6834M = 0;
            this.f6835N = 1.0f;
            this.O = 1.0f;
            this.f6836P = -1;
            this.f6837Q = -1;
            this.f6838R = -1;
            this.f6839S = false;
            this.f6840T = false;
            this.f6841U = null;
            this.f6842V = true;
            this.f6843W = true;
            this.f6844X = false;
            this.f6845Y = false;
            this.f6846Z = false;
            this.a0 = false;
            this.f6849b0 = -1;
            this.f6851c0 = -1;
            this.f6853d0 = -1;
            this.f6855e0 = -1;
            this.f6857f0 = -1;
            this.f6859g0 = -1;
            this.f6861h0 = 0.5f;
            this.f6868l0 = new g();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.f1778b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                int i11 = C0096a.f6882a.get(index);
                switch (i11) {
                    case 1:
                        this.f6838R = typedArrayObtainStyledAttributes.getInt(index, this.f6838R);
                        break;
                    case 2:
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, this.f6869m);
                        this.f6869m = resourceId;
                        if (resourceId == -1) {
                            this.f6869m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 3:
                        this.f6870n = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6870n);
                        break;
                    case 4:
                        float f6 = typedArrayObtainStyledAttributes.getFloat(index, this.f6871o) % 360.0f;
                        this.f6871o = f6;
                        if (f6 < 0.0f) {
                            this.f6871o = (360.0f - f6) % 360.0f;
                        }
                        break;
                    case 5:
                        this.f6847a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6847a);
                        break;
                    case 6:
                        this.f6848b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6848b);
                        break;
                    case 7:
                        this.f6850c = typedArrayObtainStyledAttributes.getFloat(index, this.f6850c);
                        break;
                    case 8:
                        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, this.f6852d);
                        this.f6852d = resourceId2;
                        if (resourceId2 == -1) {
                            this.f6852d = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 9:
                        int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, this.f6854e);
                        this.f6854e = resourceId3;
                        if (resourceId3 == -1) {
                            this.f6854e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 10:
                        int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, this.f6856f);
                        this.f6856f = resourceId4;
                        if (resourceId4 == -1) {
                            this.f6856f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 11:
                        int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, this.f6858g);
                        this.f6858g = resourceId5;
                        if (resourceId5 == -1) {
                            this.f6858g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 12:
                        int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, this.f6860h);
                        this.f6860h = resourceId6;
                        if (resourceId6 == -1) {
                            this.f6860h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 13:
                        int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, this.f6862i);
                        this.f6862i = resourceId7;
                        if (resourceId7 == -1) {
                            this.f6862i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 14:
                        int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, this.j);
                        this.j = resourceId8;
                        if (resourceId8 == -1) {
                            this.j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 15:
                        int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, this.f6865k);
                        this.f6865k = resourceId9;
                        if (resourceId9 == -1) {
                            this.f6865k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 16:
                        int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, this.f6867l);
                        this.f6867l = resourceId10;
                        if (resourceId10 == -1) {
                            this.f6867l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 17:
                        int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, this.f6872p);
                        this.f6872p = resourceId11;
                        if (resourceId11 == -1) {
                            this.f6872p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 18:
                        int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, this.f6873q);
                        this.f6873q = resourceId12;
                        if (resourceId12 == -1) {
                            this.f6873q = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 19:
                        int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, this.f6874r);
                        this.f6874r = resourceId13;
                        if (resourceId13 == -1) {
                            this.f6874r = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 20:
                        int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, this.f6875s);
                        this.f6875s = resourceId14;
                        if (resourceId14 == -1) {
                            this.f6875s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        }
                        break;
                    case 21:
                        this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.t);
                        break;
                    case 22:
                        this.f6876u = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6876u);
                        break;
                    case 23:
                        this.f6877v = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6877v);
                        break;
                    case 24:
                        this.f6878w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6878w);
                        break;
                    case 25:
                        this.f6879x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6879x);
                        break;
                    case 26:
                        this.f6880y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6880y);
                        break;
                    case 27:
                        this.f6839S = typedArrayObtainStyledAttributes.getBoolean(index, this.f6839S);
                        break;
                    case 28:
                        this.f6840T = typedArrayObtainStyledAttributes.getBoolean(index, this.f6840T);
                        break;
                    case 29:
                        this.f6881z = typedArrayObtainStyledAttributes.getFloat(index, this.f6881z);
                        break;
                    case 30:
                        this.f6822A = typedArrayObtainStyledAttributes.getFloat(index, this.f6822A);
                        break;
                    case 31:
                        int i12 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f6829H = i12;
                        if (i12 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        }
                        break;
                    case 32:
                        int i13 = typedArrayObtainStyledAttributes.getInt(index, 0);
                        this.f6830I = i13;
                        if (i13 == 1) {
                            Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        }
                        break;
                    case 33:
                        try {
                            this.f6831J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6831J);
                        } catch (Exception unused) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f6831J) == -2) {
                                this.f6831J = -2;
                            }
                        }
                        break;
                    case 34:
                        try {
                            this.f6833L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6833L);
                        } catch (Exception unused2) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f6833L) == -2) {
                                this.f6833L = -2;
                            }
                        }
                        break;
                    case 35:
                        this.f6835N = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.f6835N));
                        this.f6829H = 2;
                        break;
                    case 36:
                        try {
                            this.f6832K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6832K);
                        } catch (Exception unused3) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f6832K) == -2) {
                                this.f6832K = -2;
                            }
                        }
                        break;
                    case 37:
                        try {
                            this.f6834M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, this.f6834M);
                        } catch (Exception unused4) {
                            if (typedArrayObtainStyledAttributes.getInt(index, this.f6834M) == -2) {
                                this.f6834M = -2;
                            }
                        }
                        break;
                    case 38:
                        this.O = Math.max(0.0f, typedArrayObtainStyledAttributes.getFloat(index, this.O));
                        this.f6830I = 2;
                        break;
                    default:
                        switch (i11) {
                            case 44:
                                String string = typedArrayObtainStyledAttributes.getString(index);
                                this.f6823B = string;
                                this.f6824C = -1;
                                if (string != null) {
                                    int length = string.length();
                                    int iIndexOf = this.f6823B.indexOf(44);
                                    if (iIndexOf <= 0 || iIndexOf >= length - 1) {
                                        i9 = 0;
                                    } else {
                                        String strSubstring = this.f6823B.substring(0, iIndexOf);
                                        if (strSubstring.equalsIgnoreCase("W")) {
                                            this.f6824C = 0;
                                        } else if (strSubstring.equalsIgnoreCase("H")) {
                                            this.f6824C = 1;
                                        }
                                        i9 = iIndexOf + 1;
                                    }
                                    int iIndexOf2 = this.f6823B.indexOf(58);
                                    if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                                        String strSubstring2 = this.f6823B.substring(i9);
                                        if (strSubstring2.length() > 0) {
                                            Float.parseFloat(strSubstring2);
                                        }
                                    } else {
                                        String strSubstring3 = this.f6823B.substring(i9, iIndexOf2);
                                        String strSubstring4 = this.f6823B.substring(iIndexOf2 + 1);
                                        if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                                            try {
                                                float f9 = Float.parseFloat(strSubstring3);
                                                float f10 = Float.parseFloat(strSubstring4);
                                                if (f9 > 0.0f && f10 > 0.0f) {
                                                    if (this.f6824C == 1) {
                                                        Math.abs(f10 / f9);
                                                    } else {
                                                        Math.abs(f9 / f10);
                                                    }
                                                }
                                            } catch (NumberFormatException unused5) {
                                            }
                                        }
                                    }
                                }
                                break;
                            case 45:
                                this.f6825D = typedArrayObtainStyledAttributes.getFloat(index, this.f6825D);
                                break;
                            case 46:
                                this.f6826E = typedArrayObtainStyledAttributes.getFloat(index, this.f6826E);
                                break;
                            case 47:
                                this.f6827F = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.f6828G = typedArrayObtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.f6836P = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6836P);
                                break;
                            case 50:
                                this.f6837Q = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f6837Q);
                                break;
                            case 51:
                                this.f6841U = typedArrayObtainStyledAttributes.getString(index);
                                break;
                        }
                        break;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
            a();
        }

        public final void a() {
            this.f6845Y = false;
            this.f6842V = true;
            this.f6843W = true;
            int i9 = ((ViewGroup.MarginLayoutParams) this).width;
            if (i9 == -2 && this.f6839S) {
                this.f6842V = false;
                if (this.f6829H == 0) {
                    this.f6829H = 1;
                }
            }
            int i10 = ((ViewGroup.MarginLayoutParams) this).height;
            if (i10 == -2 && this.f6840T) {
                this.f6843W = false;
                if (this.f6830I == 0) {
                    this.f6830I = 1;
                }
            }
            if (i9 == 0 || i9 == -1) {
                this.f6842V = false;
                if (i9 == 0 && this.f6829H == 1) {
                    ((ViewGroup.MarginLayoutParams) this).width = -2;
                    this.f6839S = true;
                }
            }
            if (i10 == 0 || i10 == -1) {
                this.f6843W = false;
                if (i10 == 0 && this.f6830I == 1) {
                    ((ViewGroup.MarginLayoutParams) this).height = -2;
                    this.f6840T = true;
                }
            }
            if (this.f6850c == -1.0f && this.f6847a == -1 && this.f6848b == -1) {
                return;
            }
            this.f6845Y = true;
            this.f6842V = true;
            this.f6843W = true;
            if (!(this.f6868l0 instanceof A.j)) {
                this.f6868l0 = new A.j();
            }
            ((A.j) this.f6868l0).L(this.f6838R);
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0048  */
        /* JADX WARN: Code duplicated, block: B:20:0x004f  */
        /* JADX WARN: Code duplicated, block: B:23:0x0056  */
        /* JADX WARN: Code duplicated, block: B:26:0x005c  */
        /* JADX WARN: Code duplicated, block: B:29:0x0062  */
        /* JADX WARN: Code duplicated, block: B:36:0x0074  */
        /* JADX WARN: Code duplicated, block: B:37:0x007c A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:38:0x007e  */
        /* JADX WARN: Code duplicated, block: B:39:0x0085 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:40:0x0087  */
        @Override // android.view.ViewGroup.MarginLayoutParams, android.view.ViewGroup.LayoutParams
        @TargetApi(17)
        public final void resolveLayoutDirection(int i9) {
            int i10;
            int i11;
            int i12;
            int i13;
            int i14 = ((ViewGroup.MarginLayoutParams) this).leftMargin;
            int i15 = ((ViewGroup.MarginLayoutParams) this).rightMargin;
            super.resolveLayoutDirection(i9);
            boolean z8 = false;
            boolean z9 = 1 == getLayoutDirection();
            this.f6853d0 = -1;
            this.f6855e0 = -1;
            this.f6849b0 = -1;
            this.f6851c0 = -1;
            this.f6857f0 = this.t;
            this.f6859g0 = this.f6877v;
            float f6 = this.f6881z;
            this.f6861h0 = f6;
            int i16 = this.f6847a;
            this.f6863i0 = i16;
            int i17 = this.f6848b;
            this.f6864j0 = i17;
            float f9 = this.f6850c;
            this.f6866k0 = f9;
            if (z9) {
                int i18 = this.f6872p;
                if (i18 != -1) {
                    this.f6853d0 = i18;
                } else {
                    int i19 = this.f6873q;
                    if (i19 != -1) {
                        this.f6855e0 = i19;
                    } else {
                        i10 = this.f6874r;
                        if (i10 != -1) {
                            this.f6851c0 = i10;
                            z8 = true;
                        }
                        i11 = this.f6875s;
                        if (i11 != -1) {
                            this.f6849b0 = i11;
                            z8 = true;
                        }
                        i12 = this.f6879x;
                        if (i12 != -1) {
                            this.f6859g0 = i12;
                        }
                        i13 = this.f6880y;
                        if (i13 != -1) {
                            this.f6857f0 = i13;
                        }
                        if (z8) {
                            this.f6861h0 = 1.0f - f6;
                        }
                        if (this.f6845Y && this.f6838R == 1) {
                            if (f9 != -1.0f) {
                                this.f6866k0 = 1.0f - f9;
                                this.f6863i0 = -1;
                                this.f6864j0 = -1;
                            } else if (i16 != -1) {
                                this.f6864j0 = i16;
                                this.f6863i0 = -1;
                                this.f6866k0 = -1.0f;
                            } else if (i17 != -1) {
                                this.f6863i0 = i17;
                                this.f6864j0 = -1;
                                this.f6866k0 = -1.0f;
                            }
                        }
                    }
                }
                z8 = true;
                i10 = this.f6874r;
                if (i10 != -1) {
                    this.f6851c0 = i10;
                    z8 = true;
                }
                i11 = this.f6875s;
                if (i11 != -1) {
                    this.f6849b0 = i11;
                    z8 = true;
                }
                i12 = this.f6879x;
                if (i12 != -1) {
                    this.f6859g0 = i12;
                }
                i13 = this.f6880y;
                if (i13 != -1) {
                    this.f6857f0 = i13;
                }
                if (z8) {
                    this.f6861h0 = 1.0f - f6;
                }
                if (this.f6845Y) {
                    if (f9 != -1.0f) {
                        this.f6866k0 = 1.0f - f9;
                        this.f6863i0 = -1;
                        this.f6864j0 = -1;
                    } else if (i16 != -1) {
                        this.f6864j0 = i16;
                        this.f6863i0 = -1;
                        this.f6866k0 = -1.0f;
                    } else if (i17 != -1) {
                        this.f6863i0 = i17;
                        this.f6864j0 = -1;
                        this.f6866k0 = -1.0f;
                    }
                }
            } else {
                int i20 = this.f6872p;
                if (i20 != -1) {
                    this.f6851c0 = i20;
                }
                int i21 = this.f6873q;
                if (i21 != -1) {
                    this.f6849b0 = i21;
                }
                int i22 = this.f6874r;
                if (i22 != -1) {
                    this.f6853d0 = i22;
                }
                int i23 = this.f6875s;
                if (i23 != -1) {
                    this.f6855e0 = i23;
                }
                int i24 = this.f6879x;
                if (i24 != -1) {
                    this.f6857f0 = i24;
                }
                int i25 = this.f6880y;
                if (i25 != -1) {
                    this.f6859g0 = i25;
                }
            }
            if (this.f6874r == -1 && this.f6875s == -1 && this.f6873q == -1 && this.f6872p == -1) {
                int i26 = this.f6856f;
                if (i26 != -1) {
                    this.f6853d0 = i26;
                    if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i15 > 0) {
                        ((ViewGroup.MarginLayoutParams) this).rightMargin = i15;
                    }
                } else {
                    int i27 = this.f6858g;
                    if (i27 != -1) {
                        this.f6855e0 = i27;
                        if (((ViewGroup.MarginLayoutParams) this).rightMargin <= 0 && i15 > 0) {
                            ((ViewGroup.MarginLayoutParams) this).rightMargin = i15;
                        }
                    }
                }
                int i28 = this.f6852d;
                if (i28 != -1) {
                    this.f6849b0 = i28;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i14 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i14;
                    return;
                }
                int i29 = this.f6854e;
                if (i29 != -1) {
                    this.f6851c0 = i29;
                    if (((ViewGroup.MarginLayoutParams) this).leftMargin > 0 || i14 <= 0) {
                        return;
                    }
                    ((ViewGroup.MarginLayoutParams) this).leftMargin = i14;
                }
            }
        }

        public a() {
            super(-2, -2);
            this.f6847a = -1;
            this.f6848b = -1;
            this.f6850c = -1.0f;
            this.f6852d = -1;
            this.f6854e = -1;
            this.f6856f = -1;
            this.f6858g = -1;
            this.f6860h = -1;
            this.f6862i = -1;
            this.j = -1;
            this.f6865k = -1;
            this.f6867l = -1;
            this.f6869m = -1;
            this.f6870n = 0;
            this.f6871o = 0.0f;
            this.f6872p = -1;
            this.f6873q = -1;
            this.f6874r = -1;
            this.f6875s = -1;
            this.t = -1;
            this.f6876u = -1;
            this.f6877v = -1;
            this.f6878w = -1;
            this.f6879x = -1;
            this.f6880y = -1;
            this.f6881z = 0.5f;
            this.f6822A = 0.5f;
            this.f6823B = null;
            this.f6824C = 1;
            this.f6825D = -1.0f;
            this.f6826E = -1.0f;
            this.f6827F = 0;
            this.f6828G = 0;
            this.f6829H = 0;
            this.f6830I = 0;
            this.f6831J = 0;
            this.f6832K = 0;
            this.f6833L = 0;
            this.f6834M = 0;
            this.f6835N = 1.0f;
            this.O = 1.0f;
            this.f6836P = -1;
            this.f6837Q = -1;
            this.f6838R = -1;
            this.f6839S = false;
            this.f6840T = false;
            this.f6841U = null;
            this.f6842V = true;
            this.f6843W = true;
            this.f6844X = false;
            this.f6845Y = false;
            this.f6846Z = false;
            this.a0 = false;
            this.f6849b0 = -1;
            this.f6851c0 = -1;
            this.f6853d0 = -1;
            this.f6855e0 = -1;
            this.f6857f0 = -1;
            this.f6859g0 = -1;
            this.f6861h0 = 0.5f;
            this.f6868l0 = new g();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f6847a = -1;
            this.f6848b = -1;
            this.f6850c = -1.0f;
            this.f6852d = -1;
            this.f6854e = -1;
            this.f6856f = -1;
            this.f6858g = -1;
            this.f6860h = -1;
            this.f6862i = -1;
            this.j = -1;
            this.f6865k = -1;
            this.f6867l = -1;
            this.f6869m = -1;
            this.f6870n = 0;
            this.f6871o = 0.0f;
            this.f6872p = -1;
            this.f6873q = -1;
            this.f6874r = -1;
            this.f6875s = -1;
            this.t = -1;
            this.f6876u = -1;
            this.f6877v = -1;
            this.f6878w = -1;
            this.f6879x = -1;
            this.f6880y = -1;
            this.f6881z = 0.5f;
            this.f6822A = 0.5f;
            this.f6823B = null;
            this.f6824C = 1;
            this.f6825D = -1.0f;
            this.f6826E = -1.0f;
            this.f6827F = 0;
            this.f6828G = 0;
            this.f6829H = 0;
            this.f6830I = 0;
            this.f6831J = 0;
            this.f6832K = 0;
            this.f6833L = 0;
            this.f6834M = 0;
            this.f6835N = 1.0f;
            this.O = 1.0f;
            this.f6836P = -1;
            this.f6837Q = -1;
            this.f6838R = -1;
            this.f6839S = false;
            this.f6840T = false;
            this.f6841U = null;
            this.f6842V = true;
            this.f6843W = true;
            this.f6844X = false;
            this.f6845Y = false;
            this.f6846Z = false;
            this.a0 = false;
            this.f6849b0 = -1;
            this.f6851c0 = -1;
            this.f6853d0 = -1;
            this.f6855e0 = -1;
            this.f6857f0 = -1;
            this.f6859g0 = -1;
            this.f6861h0 = 0.5f;
            this.f6868l0 = new g();
        }
    }
}

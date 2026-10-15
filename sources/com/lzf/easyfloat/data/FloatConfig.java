package com.lzf.easyfloat.data;

import C6.a;
import C6.b;
import C6.c;
import C6.d;
import C6.f;
import android.view.View;
import com.starburst.sdk.core.opus.OpusCodecConfig;
import com.xiaomi.mipush.sdk.api.MiPushSdk;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.k;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import p188x7.e;

/* JADX INFO: compiled from: FloatConfig.kt */
/* JADX INFO: loaded from: classes.dex */
public final class FloatConfig {
    private int bottomBorder;
    private d callbacks;
    private b displayHeight;
    private boolean dragEnable;
    private boolean filterSelf;
    private final Set<String> filterSet;
    private c floatAnimator;
    private a floatCallbacks;
    private String floatTag;
    private int gravity;
    private boolean hasEditText;
    private boolean heightMatch;
    private boolean immersionStatusBar;
    private f invokeView;
    private boolean isAnim;
    private boolean isDrag;
    private boolean isShow;
    private int layoutChangedGravity;
    private Integer layoutId;
    private View layoutView;
    private int leftBorder;
    private e<Integer, Integer> locationPair;
    private boolean needShow;
    private e<Integer, Integer> offsetPair;
    private int rightBorder;
    private B6.a showPattern;
    private B6.b sidePattern;
    private int topBorder;
    private boolean widthMatch;

    public FloatConfig() {
        this(null, null, null, false, false, false, false, false, false, null, null, false, false, 0, null, null, 0, 0, 0, 0, null, null, null, null, null, null, false, false, 0, 536870911, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FloatConfig copy$default(FloatConfig floatConfig, Integer num, View view, String str, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, B6.b bVar, B6.a aVar, boolean z14, boolean z15, int i9, e eVar, e eVar2, int i10, int i11, int i12, int i13, f fVar, d dVar, a aVar2, c cVar, b bVar2, Set set, boolean z16, boolean z17, int i14, int i15, Object obj) {
        d dVar2;
        int i16;
        boolean z18;
        Integer num2 = (i15 & 1) != 0 ? floatConfig.layoutId : num;
        View view2 = (i15 & 2) != 0 ? floatConfig.layoutView : view;
        String str2 = (i15 & 4) != 0 ? floatConfig.floatTag : str;
        boolean z19 = (i15 & 8) != 0 ? floatConfig.dragEnable : z8;
        boolean z20 = (i15 & 16) != 0 ? floatConfig.isDrag : z9;
        boolean z21 = (i15 & 32) != 0 ? floatConfig.isAnim : z10;
        boolean z22 = (i15 & 64) != 0 ? floatConfig.isShow : z11;
        boolean z23 = (i15 & 128) != 0 ? floatConfig.hasEditText : z12;
        boolean z24 = (i15 & 256) != 0 ? floatConfig.immersionStatusBar : z13;
        B6.b bVar3 = (i15 & 512) != 0 ? floatConfig.sidePattern : bVar;
        B6.a aVar3 = (i15 & 1024) != 0 ? floatConfig.showPattern : aVar;
        boolean z25 = (i15 & OpusCodecConfig.APPLICATION_VOIP) != 0 ? floatConfig.widthMatch : z14;
        boolean z26 = (i15 & 4096) != 0 ? floatConfig.heightMatch : z15;
        int i17 = (i15 & 8192) != 0 ? floatConfig.gravity : i9;
        Integer num3 = num2;
        e eVar3 = (i15 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? floatConfig.offsetPair : eVar;
        e eVar4 = (i15 & 32768) != 0 ? floatConfig.locationPair : eVar2;
        int i18 = (i15 & 65536) != 0 ? floatConfig.leftBorder : i10;
        int i19 = (i15 & 131072) != 0 ? floatConfig.topBorder : i11;
        int i20 = (i15 & MiPushSdk.FLAG_IS_PHONE_SUPPORT_EXTENSION) != 0 ? floatConfig.rightBorder : i12;
        int i21 = (i15 & MiPushSdk.FLAG_SUPPORT_CALLKIT) != 0 ? floatConfig.bottomBorder : i13;
        f fVar2 = (i15 & 1048576) != 0 ? floatConfig.invokeView : fVar;
        if ((i15 & 2097152) != 0) {
            floatConfig.getClass();
            dVar2 = null;
        } else {
            dVar2 = dVar;
        }
        f fVar3 = fVar2;
        a aVar4 = (i15 & 4194304) != 0 ? floatConfig.floatCallbacks : aVar2;
        c cVar2 = (i15 & 8388608) != 0 ? floatConfig.floatAnimator : cVar;
        b bVar4 = (i15 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? floatConfig.displayHeight : bVar2;
        Set set2 = (i15 & 33554432) != 0 ? floatConfig.filterSet : set;
        boolean z27 = (i15 & 67108864) != 0 ? floatConfig.filterSelf : z16;
        boolean z28 = (i15 & 134217728) != 0 ? floatConfig.needShow : z17;
        if ((i15 & 268435456) != 0) {
            z18 = z28;
            i16 = floatConfig.layoutChangedGravity;
        } else {
            i16 = i14;
            z18 = z28;
        }
        return floatConfig.copy(num3, view2, str2, z19, z20, z21, z22, z23, z24, bVar3, aVar3, z25, z26, i17, eVar3, eVar4, i18, i19, i20, i21, fVar3, dVar2, aVar4, cVar2, bVar4, set2, z27, z18, i16);
    }

    public final Integer component1() {
        return this.layoutId;
    }

    public final B6.b component10() {
        return this.sidePattern;
    }

    public final B6.a component11() {
        return this.showPattern;
    }

    public final boolean component12() {
        return this.widthMatch;
    }

    public final boolean component13() {
        return this.heightMatch;
    }

    public final int component14() {
        return this.gravity;
    }

    public final e<Integer, Integer> component15() {
        return this.offsetPair;
    }

    public final e<Integer, Integer> component16() {
        return this.locationPair;
    }

    public final int component17() {
        return this.leftBorder;
    }

    public final int component18() {
        return this.topBorder;
    }

    public final int component19() {
        return this.rightBorder;
    }

    public final View component2() {
        return this.layoutView;
    }

    public final int component20() {
        return this.bottomBorder;
    }

    public final f component21() {
        return this.invokeView;
    }

    public final d component22() {
        return null;
    }

    public final a component23() {
        return this.floatCallbacks;
    }

    public final c component24() {
        return this.floatAnimator;
    }

    public final b component25() {
        return this.displayHeight;
    }

    public final Set<String> component26() {
        return this.filterSet;
    }

    public final boolean component27$easyfloat_release() {
        return this.filterSelf;
    }

    public final boolean component28$easyfloat_release() {
        return this.needShow;
    }

    public final int component29() {
        return this.layoutChangedGravity;
    }

    public final String component3() {
        return this.floatTag;
    }

    public final boolean component4() {
        return this.dragEnable;
    }

    public final boolean component5() {
        return this.isDrag;
    }

    public final boolean component6() {
        return this.isAnim;
    }

    public final boolean component7() {
        return this.isShow;
    }

    public final boolean component8() {
        return this.hasEditText;
    }

    public final boolean component9() {
        return this.immersionStatusBar;
    }

    public final FloatConfig copy(Integer num, View view, String str, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, B6.b sidePattern, B6.a showPattern, boolean z14, boolean z15, int i9, e<Integer, Integer> offsetPair, e<Integer, Integer> locationPair, int i10, int i11, int i12, int i13, f fVar, d dVar, a aVar, c cVar, b displayHeight, Set<String> filterSet, boolean z16, boolean z17, int i14) {
        k.e(sidePattern, "sidePattern");
        k.e(showPattern, "showPattern");
        k.e(offsetPair, "offsetPair");
        k.e(locationPair, "locationPair");
        k.e(displayHeight, "displayHeight");
        k.e(filterSet, "filterSet");
        return new FloatConfig(num, view, str, z8, z9, z10, z11, z12, z13, sidePattern, showPattern, z14, z15, i9, offsetPair, locationPair, i10, i11, i12, i13, fVar, dVar, aVar, cVar, displayHeight, filterSet, z16, z17, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FloatConfig)) {
            return false;
        }
        FloatConfig floatConfig = (FloatConfig) obj;
        return k.a(this.layoutId, floatConfig.layoutId) && k.a(this.layoutView, floatConfig.layoutView) && k.a(this.floatTag, floatConfig.floatTag) && this.dragEnable == floatConfig.dragEnable && this.isDrag == floatConfig.isDrag && this.isAnim == floatConfig.isAnim && this.isShow == floatConfig.isShow && this.hasEditText == floatConfig.hasEditText && this.immersionStatusBar == floatConfig.immersionStatusBar && this.sidePattern == floatConfig.sidePattern && this.showPattern == floatConfig.showPattern && this.widthMatch == floatConfig.widthMatch && this.heightMatch == floatConfig.heightMatch && this.gravity == floatConfig.gravity && k.a(this.offsetPair, floatConfig.offsetPair) && k.a(this.locationPair, floatConfig.locationPair) && this.leftBorder == floatConfig.leftBorder && this.topBorder == floatConfig.topBorder && this.rightBorder == floatConfig.rightBorder && this.bottomBorder == floatConfig.bottomBorder && k.a(this.invokeView, floatConfig.invokeView) && k.a(this.floatCallbacks, floatConfig.floatCallbacks) && k.a(this.floatAnimator, floatConfig.floatAnimator) && k.a(this.displayHeight, floatConfig.displayHeight) && k.a(this.filterSet, floatConfig.filterSet) && this.filterSelf == floatConfig.filterSelf && this.needShow == floatConfig.needShow && this.layoutChangedGravity == floatConfig.layoutChangedGravity;
    }

    public final int getBottomBorder() {
        return this.bottomBorder;
    }

    public final d getCallbacks() {
        return null;
    }

    public final b getDisplayHeight() {
        return this.displayHeight;
    }

    public final boolean getDragEnable() {
        return this.dragEnable;
    }

    public final boolean getFilterSelf$easyfloat_release() {
        return this.filterSelf;
    }

    public final Set<String> getFilterSet() {
        return this.filterSet;
    }

    public final c getFloatAnimator() {
        return this.floatAnimator;
    }

    public final a getFloatCallbacks() {
        return this.floatCallbacks;
    }

    public final String getFloatTag() {
        return this.floatTag;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final boolean getHasEditText() {
        return this.hasEditText;
    }

    public final boolean getHeightMatch() {
        return this.heightMatch;
    }

    public final boolean getImmersionStatusBar() {
        return this.immersionStatusBar;
    }

    public final f getInvokeView() {
        return this.invokeView;
    }

    public final int getLayoutChangedGravity() {
        return this.layoutChangedGravity;
    }

    public final Integer getLayoutId() {
        return this.layoutId;
    }

    public final View getLayoutView() {
        return this.layoutView;
    }

    public final int getLeftBorder() {
        return this.leftBorder;
    }

    public final e<Integer, Integer> getLocationPair() {
        return this.locationPair;
    }

    public final boolean getNeedShow$easyfloat_release() {
        return this.needShow;
    }

    public final e<Integer, Integer> getOffsetPair() {
        return this.offsetPair;
    }

    public final int getRightBorder() {
        return this.rightBorder;
    }

    public final B6.a getShowPattern() {
        return this.showPattern;
    }

    public final B6.b getSidePattern() {
        return this.sidePattern;
    }

    public final int getTopBorder() {
        return this.topBorder;
    }

    public final boolean getWidthMatch() {
        return this.widthMatch;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v52, types: [int] */
    /* JADX WARN: Type inference failed for: r0v57 */
    /* JADX WARN: Type inference failed for: r0v61 */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15, types: [int] */
    /* JADX WARN: Type inference failed for: r2v17, types: [int] */
    /* JADX WARN: Type inference failed for: r2v23, types: [int] */
    /* JADX WARN: Type inference failed for: r2v25, types: [int] */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r2v51 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53 */
    /* JADX WARN: Type inference failed for: r2v54 */
    /* JADX WARN: Type inference failed for: r2v55 */
    /* JADX WARN: Type inference failed for: r2v58 */
    /* JADX WARN: Type inference failed for: r2v59 */
    /* JADX WARN: Type inference failed for: r2v60 */
    /* JADX WARN: Type inference failed for: r2v61 */
    /* JADX WARN: Type inference failed for: r2v62 */
    /* JADX WARN: Type inference failed for: r2v63 */
    /* JADX WARN: Type inference failed for: r2v64 */
    /* JADX WARN: Type inference failed for: r2v65 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        Integer num = this.layoutId;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        View view = this.layoutView;
        int iHashCode2 = (iHashCode + (view == null ? 0 : view.hashCode())) * 31;
        String str = this.floatTag;
        int iHashCode3 = (iHashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        boolean z8 = this.dragEnable;
        ?? r8 = z8;
        if (z8) {
            r8 = 1;
        }
        int i9 = (iHashCode3 + r8) * 31;
        boolean z9 = this.isDrag;
        ?? r9 = z9;
        if (z9) {
            r9 = 1;
        }
        int i10 = (i9 + r9) * 31;
        boolean z10 = this.isAnim;
        ?? r10 = z10;
        if (z10) {
            r10 = 1;
        }
        int i11 = (i10 + r10) * 31;
        boolean z11 = this.isShow;
        ?? r11 = z11;
        if (z11) {
            r11 = 1;
        }
        int i12 = (i11 + r11) * 31;
        boolean z12 = this.hasEditText;
        ?? r12 = z12;
        if (z12) {
            r12 = 1;
        }
        int i13 = (i12 + r12) * 31;
        boolean z13 = this.immersionStatusBar;
        ?? r13 = z13;
        if (z13) {
            r13 = 1;
        }
        int iHashCode4 = (this.showPattern.hashCode() + ((this.sidePattern.hashCode() + ((i13 + r13) * 31)) * 31)) * 31;
        boolean z14 = this.widthMatch;
        ?? r14 = z14;
        if (z14) {
            r14 = 1;
        }
        int i14 = (iHashCode4 + r14) * 31;
        boolean z15 = this.heightMatch;
        ?? r15 = z15;
        if (z15) {
            r15 = 1;
        }
        int iHashCode5 = (Integer.hashCode(this.bottomBorder) + ((Integer.hashCode(this.rightBorder) + ((Integer.hashCode(this.topBorder) + ((Integer.hashCode(this.leftBorder) + ((this.locationPair.hashCode() + ((this.offsetPair.hashCode() + ((Integer.hashCode(this.gravity) + ((i14 + r15) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        f fVar = this.invokeView;
        int iHashCode6 = (iHashCode5 + (fVar == null ? 0 : fVar.hashCode())) * 961;
        a aVar = this.floatCallbacks;
        int iHashCode7 = (iHashCode6 + (aVar == null ? 0 : aVar.hashCode())) * 31;
        c cVar = this.floatAnimator;
        int iHashCode8 = (this.filterSet.hashCode() + ((this.displayHeight.hashCode() + ((iHashCode7 + (cVar != null ? cVar.hashCode() : 0)) * 31)) * 31)) * 31;
        boolean z16 = this.filterSelf;
        ?? r16 = z16;
        if (z16) {
            r16 = 1;
        }
        int i15 = (iHashCode8 + r16) * 31;
        boolean z17 = this.needShow;
        return Integer.hashCode(this.layoutChangedGravity) + ((i15 + (z17 ? 1 : z17)) * 31);
    }

    public final boolean isAnim() {
        return this.isAnim;
    }

    public final boolean isDrag() {
        return this.isDrag;
    }

    public final boolean isShow() {
        return this.isShow;
    }

    public final void setAnim(boolean z8) {
        this.isAnim = z8;
    }

    public final void setBottomBorder(int i9) {
        this.bottomBorder = i9;
    }

    public final void setDisplayHeight(b bVar) {
        k.e(bVar, "<set-?>");
        this.displayHeight = bVar;
    }

    public final void setDrag(boolean z8) {
        this.isDrag = z8;
    }

    public final void setDragEnable(boolean z8) {
        this.dragEnable = z8;
    }

    public final void setFilterSelf$easyfloat_release(boolean z8) {
        this.filterSelf = z8;
    }

    public final void setFloatAnimator(c cVar) {
        this.floatAnimator = cVar;
    }

    public final void setFloatCallbacks(a aVar) {
        this.floatCallbacks = aVar;
    }

    public final void setFloatTag(String str) {
        this.floatTag = str;
    }

    public final void setGravity(int i9) {
        this.gravity = i9;
    }

    public final void setHasEditText(boolean z8) {
        this.hasEditText = z8;
    }

    public final void setHeightMatch(boolean z8) {
        this.heightMatch = z8;
    }

    public final void setImmersionStatusBar(boolean z8) {
        this.immersionStatusBar = z8;
    }

    public final void setInvokeView(f fVar) {
        this.invokeView = fVar;
    }

    public final void setLayoutChangedGravity(int i9) {
        this.layoutChangedGravity = i9;
    }

    public final void setLayoutId(Integer num) {
        this.layoutId = num;
    }

    public final void setLayoutView(View view) {
        this.layoutView = view;
    }

    public final void setLeftBorder(int i9) {
        this.leftBorder = i9;
    }

    public final void setLocationPair(e<Integer, Integer> eVar) {
        k.e(eVar, "<set-?>");
        this.locationPair = eVar;
    }

    public final void setNeedShow$easyfloat_release(boolean z8) {
        this.needShow = z8;
    }

    public final void setOffsetPair(e<Integer, Integer> eVar) {
        k.e(eVar, "<set-?>");
        this.offsetPair = eVar;
    }

    public final void setRightBorder(int i9) {
        this.rightBorder = i9;
    }

    public final void setShow(boolean z8) {
        this.isShow = z8;
    }

    public final void setShowPattern(B6.a aVar) {
        k.e(aVar, "<set-?>");
        this.showPattern = aVar;
    }

    public final void setSidePattern(B6.b bVar) {
        k.e(bVar, "<set-?>");
        this.sidePattern = bVar;
    }

    public final void setTopBorder(int i9) {
        this.topBorder = i9;
    }

    public final void setWidthMatch(boolean z8) {
        this.widthMatch = z8;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FloatConfig(layoutId=");
        sb.append(this.layoutId);
        sb.append(", layoutView=");
        sb.append(this.layoutView);
        sb.append(", floatTag=");
        sb.append((Object) this.floatTag);
        sb.append(", dragEnable=");
        sb.append(this.dragEnable);
        sb.append(", isDrag=");
        sb.append(this.isDrag);
        sb.append(", isAnim=");
        sb.append(this.isAnim);
        sb.append(", isShow=");
        sb.append(this.isShow);
        sb.append(", hasEditText=");
        sb.append(this.hasEditText);
        sb.append(", immersionStatusBar=");
        sb.append(this.immersionStatusBar);
        sb.append(", sidePattern=");
        sb.append(this.sidePattern);
        sb.append(", showPattern=");
        sb.append(this.showPattern);
        sb.append(", widthMatch=");
        sb.append(this.widthMatch);
        sb.append(", heightMatch=");
        sb.append(this.heightMatch);
        sb.append(", gravity=");
        sb.append(this.gravity);
        sb.append(", offsetPair=");
        sb.append(this.offsetPair);
        sb.append(", locationPair=");
        sb.append(this.locationPair);
        sb.append(", leftBorder=");
        sb.append(this.leftBorder);
        sb.append(", topBorder=");
        sb.append(this.topBorder);
        sb.append(", rightBorder=");
        sb.append(this.rightBorder);
        sb.append(", bottomBorder=");
        sb.append(this.bottomBorder);
        sb.append(", invokeView=");
        sb.append(this.invokeView);
        sb.append(", callbacks=null, floatCallbacks=");
        sb.append(this.floatCallbacks);
        sb.append(", floatAnimator=");
        sb.append(this.floatAnimator);
        sb.append(", displayHeight=");
        sb.append(this.displayHeight);
        sb.append(", filterSet=");
        sb.append(this.filterSet);
        sb.append(", filterSelf=");
        sb.append(this.filterSelf);
        sb.append(", needShow=");
        sb.append(this.needShow);
        sb.append(", layoutChangedGravity=");
        return H2.a.a(sb, this.layoutChangedGravity, ')');
    }

    public FloatConfig(Integer num, View view, String str, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, B6.b sidePattern, B6.a showPattern, boolean z14, boolean z15, int i9, e<Integer, Integer> offsetPair, e<Integer, Integer> locationPair, int i10, int i11, int i12, int i13, f fVar, d dVar, a aVar, c cVar, b displayHeight, Set<String> filterSet, boolean z16, boolean z17, int i14) {
        k.e(sidePattern, "sidePattern");
        k.e(showPattern, "showPattern");
        k.e(offsetPair, "offsetPair");
        k.e(locationPair, "locationPair");
        k.e(displayHeight, "displayHeight");
        k.e(filterSet, "filterSet");
        this.layoutId = num;
        this.layoutView = view;
        this.floatTag = str;
        this.dragEnable = z8;
        this.isDrag = z9;
        this.isAnim = z10;
        this.isShow = z11;
        this.hasEditText = z12;
        this.immersionStatusBar = z13;
        this.sidePattern = sidePattern;
        this.showPattern = showPattern;
        this.widthMatch = z14;
        this.heightMatch = z15;
        this.gravity = i9;
        this.offsetPair = offsetPair;
        this.locationPair = locationPair;
        this.leftBorder = i10;
        this.topBorder = i11;
        this.rightBorder = i12;
        this.bottomBorder = i13;
        this.invokeView = fVar;
        this.floatCallbacks = aVar;
        this.floatAnimator = cVar;
        this.displayHeight = displayHeight;
        this.filterSet = filterSet;
        this.filterSelf = z16;
        this.needShow = z17;
        this.layoutChangedGravity = i14;
    }

    public final void setCallbacks(d dVar) {
    }

    public FloatConfig(Integer num, View view, String str, boolean z8, boolean z9, boolean z10, boolean z11, boolean z12, boolean z13, B6.b bVar, B6.a aVar, boolean z14, boolean z15, int i9, e eVar, e eVar2, int i10, int i11, int i12, int i13, f fVar, d dVar, a aVar2, c cVar, b bVar2, Set set, boolean z16, boolean z17, int i14, int i15, kotlin.jvm.internal.f fVar2) {
        this((i15 & 1) != 0 ? null : num, (i15 & 2) != 0 ? null : view, (i15 & 4) != 0 ? null : str, (i15 & 8) != 0 ? true : z8, (i15 & 16) != 0 ? false : z9, (i15 & 32) != 0 ? false : z10, (i15 & 64) != 0 ? false : z11, (i15 & 128) != 0 ? false : z12, (i15 & 256) != 0 ? false : z13, (i15 & 512) != 0 ? B6.b.f1750a : bVar, (i15 & 1024) != 0 ? B6.a.f1745a : aVar, (i15 & OpusCodecConfig.APPLICATION_VOIP) != 0 ? false : z14, (i15 & 4096) != 0 ? false : z15, (i15 & 8192) != 0 ? 0 : i9, (i15 & Http2.INITIAL_MAX_FRAME_SIZE) != 0 ? new e(0, 0) : eVar, (i15 & 32768) != 0 ? new e(0, 0) : eVar2, (i15 & 65536) != 0 ? 0 : i10, (i15 & 131072) != 0 ? -999 : i11, (i15 & MiPushSdk.FLAG_IS_PHONE_SUPPORT_EXTENSION) != 0 ? 9999 : i12, (i15 & MiPushSdk.FLAG_SUPPORT_CALLKIT) == 0 ? i13 : 9999, (i15 & 1048576) != 0 ? null : fVar, (i15 & 2097152) != 0 ? null : dVar, (i15 & 4194304) != 0 ? null : aVar2, (i15 & 8388608) != 0 ? new p027d5.a() : cVar, (i15 & Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE) != 0 ? new p199z2.b() : bVar2, (i15 & 33554432) != 0 ? new LinkedHashSet() : set, (i15 & 67108864) != 0 ? false : z16, (i15 & 134217728) != 0 ? true : z17, (i15 & 268435456) != 0 ? 8388659 : i14);
    }
}

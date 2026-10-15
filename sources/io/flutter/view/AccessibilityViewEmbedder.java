package io.flutter.view;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.Keep;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@Keep
class AccessibilityViewEmbedder {
    private static final String TAG = "AccessibilityBridge";
    private int nextFlutterId;
    private final View rootAccessibilityView;
    private final a reflectionAccessors = new a();
    private final SparseArray<b> flutterIdToOrigin = new SparseArray<>();
    private final Map<b, Integer> originToFlutterId = new HashMap();
    private final Map<View, Rect> embeddedViewToDisplayBounds = new HashMap();

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f19694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f19695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f19696c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Method f19697d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Field f19698e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Method f19699f;

        /* JADX WARN: Multi-variable type inference failed */
        public a() throws NoSuchMethodException {
            Method method;
            Method method2;
            Method method3;
            Method method4;
            Field field;
            Method method5;
            Method method6 = null;
            try {
                method = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", new Class[0]);
            } catch (NoSuchMethodException unused) {
                Log.w(AccessibilityViewEmbedder.TAG, "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection");
                method = null;
            }
            try {
                method2 = AccessibilityRecord.class.getMethod("getSourceNodeId", new Class[0]);
            } catch (NoSuchMethodException unused2) {
                Log.w(AccessibilityViewEmbedder.TAG, "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection");
                method2 = null;
            }
            int i9 = Build.VERSION.SDK_INT;
            Class cls = Integer.TYPE;
            if (i9 > 26) {
                try {
                    Field declaredField = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
                    declaredField.setAccessible(true);
                    method5 = Class.forName("android.util.LongArray").getMethod("get", cls);
                    field = declaredField;
                    method4 = null;
                } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException unused3) {
                    Log.w(AccessibilityViewEmbedder.TAG, "can't access childNodeIdsField with reflection");
                    method4 = null;
                    field = null;
                    method5 = field;
                }
                this.f19694a = method;
                this.f19695b = method6;
                this.f19696c = method2;
                this.f19697d = method4;
                this.f19698e = field;
                this.f19699f = method5;
            }
            try {
                method3 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", new Class[0]);
            } catch (NoSuchMethodException unused4) {
                Log.w(AccessibilityViewEmbedder.TAG, "can't invoke getParentNodeId with reflection");
                method3 = null;
            }
            try {
                method4 = AccessibilityNodeInfo.class.getMethod("getChildId", cls);
                field = null;
            } catch (NoSuchMethodException unused5) {
                Log.w(AccessibilityViewEmbedder.TAG, "can't invoke getChildId with reflection");
                method4 = null;
                field = null;
            }
            method6 = method3;
            method5 = field;
            this.f19694a = method;
            this.f19695b = method6;
            this.f19696c = method2;
            this.f19697d = method4;
            this.f19698e = field;
            this.f19699f = method5;
        }

        public static Long a(a aVar, AccessibilityRecord accessibilityRecord) {
            Method method = aVar.f19696c;
            if (method == null) {
                return null;
            }
            try {
                return (Long) method.invoke(accessibilityRecord, new Object[0]);
            } catch (IllegalAccessException e9) {
                Log.w(AccessibilityViewEmbedder.TAG, "Failed to access the getRecordSourceNodeId method.", e9);
                return null;
            } catch (InvocationTargetException e10) {
                Log.w(AccessibilityViewEmbedder.TAG, "The getRecordSourceNodeId method threw an exception when invoked.", e10);
                return null;
            }
        }

        public static boolean b(int i9, long j) {
            return (j & (1 << i9)) != 0;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f19700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19701b;

        public b(View view, int i9) {
            this.f19700a = view;
            this.f19701b = i9;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f19701b == bVar.f19701b && this.f19700a.equals(bVar.f19700a);
        }

        public final int hashCode() {
            return ((this.f19700a.hashCode() + 31) * 31) + this.f19701b;
        }
    }

    public AccessibilityViewEmbedder(View view, int i9) {
        this.rootAccessibilityView = view;
        this.nextFlutterId = i9;
    }

    private void addChildrenToFlutterNode(AccessibilityNodeInfo accessibilityNodeInfo, View view, AccessibilityNodeInfo accessibilityNodeInfo2) {
        Long l8;
        int iIntValue;
        for (int i9 = 0; i9 < accessibilityNodeInfo.getChildCount(); i9++) {
            a aVar = this.reflectionAccessors;
            Method method = aVar.f19699f;
            Field field = aVar.f19698e;
            Method method2 = aVar.f19697d;
            if (method2 == null && (field == null || method == null)) {
                l8 = null;
            } else if (method2 != null) {
                try {
                    l8 = (Long) method2.invoke(accessibilityNodeInfo, Integer.valueOf(i9));
                } catch (IllegalAccessException e9) {
                    Log.w(TAG, "Failed to access getChildId method.", e9);
                    l8 = null;
                } catch (InvocationTargetException e10) {
                    Log.w(TAG, "The getChildId method threw an exception when invoked.", e10);
                    l8 = null;
                }
            } else {
                try {
                    l8 = (Long) method.invoke(field.get(accessibilityNodeInfo), Integer.valueOf(i9));
                    l8.getClass();
                } catch (ArrayIndexOutOfBoundsException e11) {
                    e = e11;
                    Log.w(TAG, "The longArrayGetIndex method threw an exception when invoked.", e);
                    l8 = null;
                } catch (IllegalAccessException e12) {
                    Log.w(TAG, "Failed to access longArrayGetIndex method or the childNodeId field.", e12);
                    l8 = null;
                } catch (InvocationTargetException e13) {
                    e = e13;
                    Log.w(TAG, "The longArrayGetIndex method threw an exception when invoked.", e);
                    l8 = null;
                }
            }
            if (l8 != null) {
                int iLongValue = (int) (l8.longValue() >> 32);
                b bVar = new b(view, iLongValue);
                if (this.originToFlutterId.containsKey(bVar)) {
                    iIntValue = this.originToFlutterId.get(bVar).intValue();
                } else {
                    int i10 = this.nextFlutterId;
                    this.nextFlutterId = i10 + 1;
                    cacheVirtualIdMappings(view, iLongValue, i10);
                    iIntValue = i10;
                }
                accessibilityNodeInfo2.addChild(this.rootAccessibilityView, iIntValue);
            }
        }
    }

    private void cacheVirtualIdMappings(View view, int i9, int i10) {
        b bVar = new b(view, i9);
        this.originToFlutterId.put(bVar, Integer.valueOf(i10));
        this.flutterIdToOrigin.put(i10, bVar);
    }

    private AccessibilityNodeInfo convertToFlutterNode(AccessibilityNodeInfo accessibilityNodeInfo, int i9, View view) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, i9);
        accessibilityNodeInfoObtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        accessibilityNodeInfoObtain.setSource(this.rootAccessibilityView, i9);
        accessibilityNodeInfoObtain.setClassName(accessibilityNodeInfo.getClassName());
        Rect rect = this.embeddedViewToDisplayBounds.get(view);
        copyAccessibilityFields(accessibilityNodeInfo, accessibilityNodeInfoObtain);
        setFlutterNodesTranslateBounds(accessibilityNodeInfo, rect, accessibilityNodeInfoObtain);
        addChildrenToFlutterNode(accessibilityNodeInfo, view, accessibilityNodeInfoObtain);
        setFlutterNodeParent(accessibilityNodeInfo, view, accessibilityNodeInfoObtain);
        return accessibilityNodeInfoObtain;
    }

    private void copyAccessibilityFields(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) {
        accessibilityNodeInfo2.setAccessibilityFocused(accessibilityNodeInfo.isAccessibilityFocused());
        accessibilityNodeInfo2.setCheckable(accessibilityNodeInfo.isCheckable());
        accessibilityNodeInfo2.setChecked(accessibilityNodeInfo.isChecked());
        accessibilityNodeInfo2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityNodeInfo2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityNodeInfo2.setClickable(accessibilityNodeInfo.isClickable());
        accessibilityNodeInfo2.setFocusable(accessibilityNodeInfo.isFocusable());
        accessibilityNodeInfo2.setFocused(accessibilityNodeInfo.isFocused());
        accessibilityNodeInfo2.setLongClickable(accessibilityNodeInfo.isLongClickable());
        accessibilityNodeInfo2.setMovementGranularities(accessibilityNodeInfo.getMovementGranularities());
        accessibilityNodeInfo2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityNodeInfo2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityNodeInfo2.setSelected(accessibilityNodeInfo.isSelected());
        accessibilityNodeInfo2.setText(accessibilityNodeInfo.getText());
        accessibilityNodeInfo2.setVisibleToUser(accessibilityNodeInfo.isVisibleToUser());
        accessibilityNodeInfo2.setEditable(accessibilityNodeInfo.isEditable());
        accessibilityNodeInfo2.setCanOpenPopup(accessibilityNodeInfo.canOpenPopup());
        accessibilityNodeInfo2.setCollectionInfo(accessibilityNodeInfo.getCollectionInfo());
        accessibilityNodeInfo2.setCollectionItemInfo(accessibilityNodeInfo.getCollectionItemInfo());
        accessibilityNodeInfo2.setContentInvalid(accessibilityNodeInfo.isContentInvalid());
        accessibilityNodeInfo2.setDismissable(accessibilityNodeInfo.isDismissable());
        accessibilityNodeInfo2.setInputType(accessibilityNodeInfo.getInputType());
        accessibilityNodeInfo2.setLiveRegion(accessibilityNodeInfo.getLiveRegion());
        accessibilityNodeInfo2.setMultiLine(accessibilityNodeInfo.isMultiLine());
        accessibilityNodeInfo2.setRangeInfo(accessibilityNodeInfo.getRangeInfo());
        accessibilityNodeInfo2.setError(accessibilityNodeInfo.getError());
        accessibilityNodeInfo2.setMaxTextLength(accessibilityNodeInfo.getMaxTextLength());
        accessibilityNodeInfo2.setContextClickable(accessibilityNodeInfo.isContextClickable());
        accessibilityNodeInfo2.setDrawingOrder(accessibilityNodeInfo.getDrawingOrder());
        accessibilityNodeInfo2.setImportantForAccessibility(accessibilityNodeInfo.isImportantForAccessibility());
        accessibilityNodeInfo2.setAvailableExtraData(accessibilityNodeInfo.getAvailableExtraData());
        accessibilityNodeInfo2.setHintText(accessibilityNodeInfo.getHintText());
        accessibilityNodeInfo2.setShowingHintText(accessibilityNodeInfo.isShowingHintText());
    }

    /* JADX WARN: Code duplicated, block: B:14:0x003f  */
    /* JADX WARN: Code duplicated, block: B:17:0x0049  */
    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    /* JADX WARN: Code duplicated, block: B:23:0x005d  */
    /* JADX WARN: Code duplicated, block: B:24:0x0066  */
    private void setFlutterNodeParent(AccessibilityNodeInfo accessibilityNodeInfo, View view, AccessibilityNodeInfo accessibilityNodeInfo2) {
        Long l8;
        Parcel parcelObtain;
        long j;
        Long lValueOf;
        Method method = this.reflectionAccessors.f19695b;
        if (method != null) {
            try {
                l8 = (Long) method.invoke(accessibilityNodeInfo, new Object[0]);
                l8.getClass();
            } catch (IllegalAccessException e9) {
                Log.w(TAG, "Failed to access getParentNodeId method.", e9);
                AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                parcelObtain = Parcel.obtain();
                parcelObtain.setDataPosition(0);
                accessibilityNodeInfoObtain.writeToParcel(parcelObtain, 0);
                parcelObtain.setDataPosition(0);
                j = parcelObtain.readLong();
                if (a.b(0, j)) {
                    parcelObtain.readInt();
                }
                if (a.b(1, j)) {
                    parcelObtain.readLong();
                }
                if (a.b(2, j)) {
                    parcelObtain.readInt();
                }
                if (a.b(3, j)) {
                    lValueOf = Long.valueOf(parcelObtain.readLong());
                } else {
                    lValueOf = null;
                }
                parcelObtain.recycle();
                l8 = lValueOf;
            } catch (InvocationTargetException e10) {
                Log.w(TAG, "The getParentNodeId method threw an exception when invoked.", e10);
                AccessibilityNodeInfo accessibilityNodeInfoObtain2 = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
                parcelObtain = Parcel.obtain();
                parcelObtain.setDataPosition(0);
                accessibilityNodeInfoObtain2.writeToParcel(parcelObtain, 0);
                parcelObtain.setDataPosition(0);
                j = parcelObtain.readLong();
                if (a.b(0, j)) {
                    parcelObtain.readInt();
                }
                if (a.b(1, j)) {
                    parcelObtain.readLong();
                }
                if (a.b(2, j)) {
                    parcelObtain.readInt();
                }
                if (a.b(3, j)) {
                    lValueOf = Long.valueOf(parcelObtain.readLong());
                } else {
                    lValueOf = null;
                }
                parcelObtain.recycle();
                l8 = lValueOf;
            }
        } else {
            AccessibilityNodeInfo accessibilityNodeInfoObtain3 = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            parcelObtain = Parcel.obtain();
            parcelObtain.setDataPosition(0);
            accessibilityNodeInfoObtain3.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            j = parcelObtain.readLong();
            if (a.b(0, j)) {
                parcelObtain.readInt();
            }
            if (a.b(1, j)) {
                parcelObtain.readLong();
            }
            if (a.b(2, j)) {
                parcelObtain.readInt();
            }
            if (a.b(3, j)) {
                lValueOf = Long.valueOf(parcelObtain.readLong());
            } else {
                lValueOf = null;
            }
            parcelObtain.recycle();
            l8 = lValueOf;
        }
        if (l8 == null) {
            return;
        }
        Integer num = this.originToFlutterId.get(new b(view, (int) (l8.longValue() >> 32)));
        if (num != null) {
            accessibilityNodeInfo2.setParent(this.rootAccessibilityView, num.intValue());
        }
    }

    private void setFlutterNodesTranslateBounds(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect, AccessibilityNodeInfo accessibilityNodeInfo2) {
        Rect rect2 = new Rect();
        accessibilityNodeInfo.getBoundsInParent(rect2);
        accessibilityNodeInfo2.setBoundsInParent(rect2);
        Rect rect3 = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect3);
        rect3.offset(rect.left, rect.top);
        accessibilityNodeInfo2.setBoundsInScreen(rect3);
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i9) {
        AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo;
        b bVar = this.flutterIdToOrigin.get(i9);
        if (bVar == null) {
            return null;
        }
        Map<View, Rect> map = this.embeddedViewToDisplayBounds;
        View view = bVar.f19700a;
        if (!map.containsKey(view) || view.getAccessibilityNodeProvider() == null || (accessibilityNodeInfoCreateAccessibilityNodeInfo = view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(bVar.f19701b)) == null) {
            return null;
        }
        return convertToFlutterNode(accessibilityNodeInfoCreateAccessibilityNodeInfo, i9, view);
    }

    public Integer getRecordFlutterId(View view, AccessibilityRecord accessibilityRecord) {
        Long lA = a.a(this.reflectionAccessors, accessibilityRecord);
        if (lA == null) {
            return null;
        }
        return this.originToFlutterId.get(new b(view, (int) (lA.longValue() >> 32)));
    }

    public AccessibilityNodeInfo getRootNode(View view, int i9, Rect rect) {
        Long l8;
        AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo = view.createAccessibilityNodeInfo();
        Method method = this.reflectionAccessors.f19694a;
        if (method == null) {
            l8 = null;
        } else {
            try {
                l8 = (Long) method.invoke(accessibilityNodeInfoCreateAccessibilityNodeInfo, new Object[0]);
            } catch (IllegalAccessException e9) {
                Log.w(TAG, "Failed to access getSourceNodeId method.", e9);
                l8 = null;
            } catch (InvocationTargetException e10) {
                Log.w(TAG, "The getSourceNodeId method threw an exception when invoked.", e10);
                l8 = null;
            }
        }
        if (l8 == null) {
            return null;
        }
        this.embeddedViewToDisplayBounds.put(view, rect);
        cacheVirtualIdMappings(view, (int) (l8.longValue() >> 32), i9);
        return convertToFlutterNode(accessibilityNodeInfoCreateAccessibilityNodeInfo, i9, view);
    }

    public boolean onAccessibilityHoverEvent(int i9, MotionEvent motionEvent) {
        b bVar = this.flutterIdToOrigin.get(i9);
        if (bVar == null) {
            return false;
        }
        Map<View, Rect> map = this.embeddedViewToDisplayBounds;
        View view = bVar.f19700a;
        Rect rect = map.get(view);
        int pointerCount = motionEvent.getPointerCount();
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i10 = 0; i10 < motionEvent.getPointerCount(); i10++) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerPropertiesArr[i10] = pointerProperties;
            motionEvent.getPointerProperties(i10, pointerProperties);
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(i10, pointerCoords);
            MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords(pointerCoords);
            pointerCoordsArr[i10] = pointerCoords2;
            pointerCoords2.x -= rect.left;
            pointerCoords2.y -= rect.top;
        }
        return view.dispatchGenericMotionEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getPointerCount(), pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags()));
    }

    public boolean performAction(int i9, int i10, Bundle bundle) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        b bVar = this.flutterIdToOrigin.get(i9);
        if (bVar == null || (accessibilityNodeProvider = bVar.f19700a.getAccessibilityNodeProvider()) == null) {
            return false;
        }
        return accessibilityNodeProvider.performAction(bVar.f19701b, i10, bundle);
    }

    public View platformViewOfNode(int i9) {
        b bVar = this.flutterIdToOrigin.get(i9);
        if (bVar == null) {
            return null;
        }
        return bVar.f19700a;
    }

    public boolean requestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(accessibilityEvent);
        Long lA = a.a(this.reflectionAccessors, accessibilityEvent);
        if (lA != null) {
            int iLongValue = (int) (lA.longValue() >> 32);
            Integer num = this.originToFlutterId.get(new b(view, iLongValue));
            if (num == null) {
                int i9 = this.nextFlutterId;
                this.nextFlutterId = i9 + 1;
                Integer numValueOf = Integer.valueOf(i9);
                cacheVirtualIdMappings(view, iLongValue, i9);
                num = numValueOf;
            }
            accessibilityEventObtain.setSource(this.rootAccessibilityView, num.intValue());
            accessibilityEventObtain.setClassName(accessibilityEvent.getClassName());
            accessibilityEventObtain.setPackageName(accessibilityEvent.getPackageName());
            for (int i10 = 0; i10 < accessibilityEventObtain.getRecordCount(); i10++) {
                AccessibilityRecord record = accessibilityEventObtain.getRecord(i10);
                Long lA2 = a.a(this.reflectionAccessors, record);
                if (lA2 != null) {
                    b bVar = new b(view, (int) (lA2.longValue() >> 32));
                    if (this.originToFlutterId.containsKey(bVar)) {
                        record.setSource(this.rootAccessibilityView, this.originToFlutterId.get(bVar).intValue());
                    }
                }
            }
            return this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(view2, accessibilityEventObtain);
        }
        return false;
    }
}

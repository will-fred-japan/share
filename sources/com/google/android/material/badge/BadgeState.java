package com.google.android.material.badge;

import E5.c;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import cn.ikaile.ruoshui.client.R;
import com.google.android.material.internal.h;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class BadgeState {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final State f12849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final State f12850b = new State();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f12851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f12852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f12853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f12854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f12855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f12856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f12857i;
    public final int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f12858k;

    public static final class State implements Parcelable {
        public static final Parcelable.Creator<State> CREATOR = new a();

        /* JADX INFO: renamed from: A, reason: collision with root package name */
        public Integer f12859A;

        /* JADX INFO: renamed from: B, reason: collision with root package name */
        public Integer f12860B;

        /* JADX INFO: renamed from: C, reason: collision with root package name */
        public Integer f12861C;

        /* JADX INFO: renamed from: D, reason: collision with root package name */
        public Boolean f12862D;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Integer f12864b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Integer f12865c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Integer f12866d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f12867e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Integer f12868f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Integer f12869g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Integer f12870h;
        public String j;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public Locale f12875n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public String f12876o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public CharSequence f12877p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f12878q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f12879r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public Integer f12880s;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public Integer f12881u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public Integer f12882v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public Integer f12883w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public Integer f12884x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public Integer f12885y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public Integer f12886z;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f12871i = 255;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f12872k = -2;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f12873l = -2;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f12874m = -2;
        public Boolean t = Boolean.TRUE;

        public class a implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            public final State createFromParcel(Parcel parcel) {
                State state = new State();
                state.f12871i = 255;
                state.f12872k = -2;
                state.f12873l = -2;
                state.f12874m = -2;
                state.t = Boolean.TRUE;
                state.f12863a = parcel.readInt();
                state.f12864b = (Integer) parcel.readSerializable();
                state.f12865c = (Integer) parcel.readSerializable();
                state.f12866d = (Integer) parcel.readSerializable();
                state.f12867e = (Integer) parcel.readSerializable();
                state.f12868f = (Integer) parcel.readSerializable();
                state.f12869g = (Integer) parcel.readSerializable();
                state.f12870h = (Integer) parcel.readSerializable();
                state.f12871i = parcel.readInt();
                state.j = parcel.readString();
                state.f12872k = parcel.readInt();
                state.f12873l = parcel.readInt();
                state.f12874m = parcel.readInt();
                state.f12876o = parcel.readString();
                state.f12877p = parcel.readString();
                state.f12878q = parcel.readInt();
                state.f12880s = (Integer) parcel.readSerializable();
                state.f12881u = (Integer) parcel.readSerializable();
                state.f12882v = (Integer) parcel.readSerializable();
                state.f12883w = (Integer) parcel.readSerializable();
                state.f12884x = (Integer) parcel.readSerializable();
                state.f12885y = (Integer) parcel.readSerializable();
                state.f12886z = (Integer) parcel.readSerializable();
                state.f12861C = (Integer) parcel.readSerializable();
                state.f12859A = (Integer) parcel.readSerializable();
                state.f12860B = (Integer) parcel.readSerializable();
                state.t = (Boolean) parcel.readSerializable();
                state.f12875n = (Locale) parcel.readSerializable();
                state.f12862D = (Boolean) parcel.readSerializable();
                return state;
            }

            @Override // android.os.Parcelable.Creator
            public final State[] newArray(int i9) {
                return new State[i9];
            }
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i9) {
            parcel.writeInt(this.f12863a);
            parcel.writeSerializable(this.f12864b);
            parcel.writeSerializable(this.f12865c);
            parcel.writeSerializable(this.f12866d);
            parcel.writeSerializable(this.f12867e);
            parcel.writeSerializable(this.f12868f);
            parcel.writeSerializable(this.f12869g);
            parcel.writeSerializable(this.f12870h);
            parcel.writeInt(this.f12871i);
            parcel.writeString(this.j);
            parcel.writeInt(this.f12872k);
            parcel.writeInt(this.f12873l);
            parcel.writeInt(this.f12874m);
            String str = this.f12876o;
            parcel.writeString(str != null ? str.toString() : null);
            CharSequence charSequence = this.f12877p;
            parcel.writeString(charSequence != null ? charSequence.toString() : null);
            parcel.writeInt(this.f12878q);
            parcel.writeSerializable(this.f12880s);
            parcel.writeSerializable(this.f12881u);
            parcel.writeSerializable(this.f12882v);
            parcel.writeSerializable(this.f12883w);
            parcel.writeSerializable(this.f12884x);
            parcel.writeSerializable(this.f12885y);
            parcel.writeSerializable(this.f12886z);
            parcel.writeSerializable(this.f12861C);
            parcel.writeSerializable(this.f12859A);
            parcel.writeSerializable(this.f12860B);
            parcel.writeSerializable(this.t);
            parcel.writeSerializable(this.f12875n);
            parcel.writeSerializable(this.f12862D);
        }
    }

    public BadgeState(Context context) {
        AttributeSet attributeSet;
        int styleAttribute;
        int next;
        State state = new State();
        int i9 = state.f12863a;
        if (i9 != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(i9);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (!TextUtils.equals(xml.getName(), "badge")) {
                    throw new XmlPullParserException("Must have a <" + ((Object) "badge") + "> start tag");
                }
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                attributeSet = attributeSetAsAttributeSet;
                styleAttribute = attributeSetAsAttributeSet.getStyleAttribute();
            } catch (IOException | XmlPullParserException e9) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i9));
                notFoundException.initCause(e9);
                throw notFoundException;
            }
        } else {
            attributeSet = null;
            styleAttribute = 0;
        }
        TypedArray typedArrayD = h.d(context, attributeSet, p103n5.a.f20590b, R.attr.badgeStyle, styleAttribute == 0 ? R.style.Widget_MaterialComponents_Badge : styleAttribute, new int[0]);
        Resources resources = context.getResources();
        this.f12851c = typedArrayD.getDimensionPixelSize(4, -1);
        this.f12857i = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.j = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.f12852d = typedArrayD.getDimensionPixelSize(14, -1);
        this.f12853e = typedArrayD.getDimension(12, resources.getDimension(R.dimen.m3_badge_size));
        this.f12855g = typedArrayD.getDimension(17, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.f12854f = typedArrayD.getDimension(3, resources.getDimension(R.dimen.m3_badge_size));
        this.f12856h = typedArrayD.getDimension(13, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.f12858k = typedArrayD.getInt(24, 1);
        State state2 = this.f12850b;
        int i10 = state.f12871i;
        state2.f12871i = i10 == -2 ? 255 : i10;
        int i11 = state.f12872k;
        if (i11 != -2) {
            state2.f12872k = i11;
        } else if (typedArrayD.hasValue(23)) {
            this.f12850b.f12872k = typedArrayD.getInt(23, 0);
        } else {
            this.f12850b.f12872k = -1;
        }
        String str = state.j;
        if (str != null) {
            this.f12850b.j = str;
        } else if (typedArrayD.hasValue(7)) {
            this.f12850b.j = typedArrayD.getString(7);
        }
        State state3 = this.f12850b;
        state3.f12876o = state.f12876o;
        CharSequence charSequence = state.f12877p;
        state3.f12877p = charSequence == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : charSequence;
        State state4 = this.f12850b;
        int i12 = state.f12878q;
        state4.f12878q = i12 == 0 ? R.plurals.mtrl_badge_content_description : i12;
        int i13 = state.f12879r;
        state4.f12879r = i13 == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : i13;
        Boolean bool = state.t;
        state4.t = Boolean.valueOf(bool == null || bool.booleanValue());
        State state5 = this.f12850b;
        int i14 = state.f12873l;
        state5.f12873l = i14 == -2 ? typedArrayD.getInt(21, -2) : i14;
        State state6 = this.f12850b;
        int i15 = state.f12874m;
        state6.f12874m = i15 == -2 ? typedArrayD.getInt(22, -2) : i15;
        State state7 = this.f12850b;
        Integer num = state.f12867e;
        state7.f12867e = Integer.valueOf(num == null ? typedArrayD.getResourceId(5, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num.intValue());
        State state8 = this.f12850b;
        Integer num2 = state.f12868f;
        state8.f12868f = Integer.valueOf(num2 == null ? typedArrayD.getResourceId(6, 0) : num2.intValue());
        State state9 = this.f12850b;
        Integer num3 = state.f12869g;
        state9.f12869g = Integer.valueOf(num3 == null ? typedArrayD.getResourceId(15, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num3.intValue());
        State state10 = this.f12850b;
        Integer num4 = state.f12870h;
        state10.f12870h = Integer.valueOf(num4 == null ? typedArrayD.getResourceId(16, 0) : num4.intValue());
        State state11 = this.f12850b;
        Integer num5 = state.f12864b;
        state11.f12864b = Integer.valueOf(num5 == null ? c.a(context, typedArrayD, 1).getDefaultColor() : num5.intValue());
        State state12 = this.f12850b;
        Integer num6 = state.f12866d;
        state12.f12866d = Integer.valueOf(num6 == null ? typedArrayD.getResourceId(8, R.style.TextAppearance_MaterialComponents_Badge) : num6.intValue());
        Integer num7 = state.f12865c;
        if (num7 != null) {
            this.f12850b.f12865c = num7;
        } else if (typedArrayD.hasValue(9)) {
            this.f12850b.f12865c = Integer.valueOf(c.a(context, typedArrayD, 9).getDefaultColor());
        } else {
            int iIntValue = this.f12850b.f12866d.intValue();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iIntValue, p103n5.a.f20585C);
            typedArrayObtainStyledAttributes.getDimension(0, 0.0f);
            ColorStateList colorStateListA = c.a(context, typedArrayObtainStyledAttributes, 3);
            c.a(context, typedArrayObtainStyledAttributes, 4);
            c.a(context, typedArrayObtainStyledAttributes, 5);
            typedArrayObtainStyledAttributes.getInt(2, 0);
            typedArrayObtainStyledAttributes.getInt(1, 1);
            int i16 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
            typedArrayObtainStyledAttributes.getResourceId(i16, 0);
            typedArrayObtainStyledAttributes.getString(i16);
            typedArrayObtainStyledAttributes.getBoolean(14, false);
            c.a(context, typedArrayObtainStyledAttributes, 6);
            typedArrayObtainStyledAttributes.getFloat(7, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(8, 0.0f);
            typedArrayObtainStyledAttributes.getFloat(9, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iIntValue, p103n5.a.f20607u);
            typedArrayObtainStyledAttributes2.hasValue(0);
            typedArrayObtainStyledAttributes2.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes2.recycle();
            this.f12850b.f12865c = Integer.valueOf(colorStateListA.getDefaultColor());
        }
        State state13 = this.f12850b;
        Integer num8 = state.f12880s;
        state13.f12880s = Integer.valueOf(num8 == null ? typedArrayD.getInt(2, 8388661) : num8.intValue());
        State state14 = this.f12850b;
        Integer num9 = state.f12881u;
        state14.f12881u = Integer.valueOf(num9 == null ? typedArrayD.getDimensionPixelSize(11, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding)) : num9.intValue());
        State state15 = this.f12850b;
        Integer num10 = state.f12882v;
        state15.f12882v = Integer.valueOf(num10 == null ? typedArrayD.getDimensionPixelSize(10, resources.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding)) : num10.intValue());
        State state16 = this.f12850b;
        Integer num11 = state.f12883w;
        state16.f12883w = Integer.valueOf(num11 == null ? typedArrayD.getDimensionPixelOffset(18, 0) : num11.intValue());
        State state17 = this.f12850b;
        Integer num12 = state.f12884x;
        state17.f12884x = Integer.valueOf(num12 == null ? typedArrayD.getDimensionPixelOffset(25, 0) : num12.intValue());
        State state18 = this.f12850b;
        Integer num13 = state.f12885y;
        state18.f12885y = Integer.valueOf(num13 == null ? typedArrayD.getDimensionPixelOffset(19, state18.f12883w.intValue()) : num13.intValue());
        State state19 = this.f12850b;
        Integer num14 = state.f12886z;
        state19.f12886z = Integer.valueOf(num14 == null ? typedArrayD.getDimensionPixelOffset(26, state19.f12884x.intValue()) : num14.intValue());
        State state20 = this.f12850b;
        Integer num15 = state.f12861C;
        state20.f12861C = Integer.valueOf(num15 == null ? typedArrayD.getDimensionPixelOffset(20, 0) : num15.intValue());
        State state21 = this.f12850b;
        Integer num16 = state.f12859A;
        state21.f12859A = Integer.valueOf(num16 == null ? 0 : num16.intValue());
        State state22 = this.f12850b;
        Integer num17 = state.f12860B;
        state22.f12860B = Integer.valueOf(num17 == null ? 0 : num17.intValue());
        State state23 = this.f12850b;
        Boolean bool2 = state.f12862D;
        state23.f12862D = Boolean.valueOf(bool2 == null ? typedArrayD.getBoolean(0, false) : bool2.booleanValue());
        typedArrayD.recycle();
        Locale locale = state.f12875n;
        if (locale == null) {
            this.f12850b.f12875n = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            this.f12850b.f12875n = locale;
        }
        this.f12849a = state;
    }
}

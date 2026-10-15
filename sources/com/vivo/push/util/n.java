package com.vivo.push.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;

/* JADX INFO: compiled from: DefaultNotifyLayoutAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public final class n implements BaseNotifyLayoutAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Resources f16884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f16885b;

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getNotificationLayout() {
        return this.f16884a.getIdentifier("push_notify", "layout", this.f16885b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getSuitIconId() {
        Resources resources;
        String str;
        if (o.f16889d) {
            resources = this.f16884a;
            str = "notify_icon_rom30";
        } else if (o.f16888c) {
            resources = this.f16884a;
            str = "notify_icon_rom20";
        } else {
            resources = this.f16884a;
            str = "notify_icon";
        }
        return resources.getIdentifier(str, "id", this.f16885b);
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final int getTitleColor() {
        int iIntValue;
        try {
            iIntValue = ((Integer) ak.a("com.android.internal.R$color", "vivo_notification_title_text_color")).intValue();
        } catch (Exception e9) {
            e9.printStackTrace();
            iIntValue = 0;
        }
        if (iIntValue > 0) {
            return this.f16884a.getColor(iIntValue);
        }
        boolean z8 = o.f16889d;
        if (z8) {
            return -1;
        }
        if (!o.f16888c) {
            return -16777216;
        }
        if (z8) {
            return Color.parseColor("#ff999999");
        }
        return -1;
    }

    @Override // com.vivo.push.util.BaseNotifyLayoutAdapter
    public final void init(Context context) {
        this.f16885b = context.getPackageName();
        this.f16884a = context.getResources();
    }
}

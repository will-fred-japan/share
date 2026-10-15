package com.pichillilorenzo.flutter_inappwebview_android.pull_to_refresh;

import android.graphics.Color;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl;
import java.util.HashMap;
import p096m7.j;
import p096m7.l;

/* JADX INFO: loaded from: classes.dex */
public class PullToRefreshChannelDelegate extends ChannelDelegateImpl {
    private PullToRefreshLayout pullToRefreshView;

    public PullToRefreshChannelDelegate(PullToRefreshLayout pullToRefreshLayout, l lVar) {
        super(lVar);
        this.pullToRefreshView = pullToRefreshLayout;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.Disposable
    public void dispose() {
        super.dispose();
        this.pullToRefreshView = null;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.ChannelDelegateImpl, com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, m7.l.c
    public void onMethodCall(j jVar, l.d dVar) {
        String str = jVar.f20496a;
        str.getClass();
        switch (str) {
            case "setSlingshotDistance":
                if (this.pullToRefreshView == null) {
                    dVar.success(Boolean.FALSE);
                    break;
                } else {
                    this.pullToRefreshView.setSlingshotDistance(((Integer) jVar.a("slingshotDistance")).intValue());
                    dVar.success(Boolean.TRUE);
                    break;
                }
                break;
            case "setRefreshing":
                if (this.pullToRefreshView == null) {
                    dVar.success(Boolean.FALSE);
                    break;
                } else {
                    this.pullToRefreshView.setRefreshing(((Boolean) jVar.a("refreshing")).booleanValue());
                    dVar.success(Boolean.TRUE);
                    break;
                }
                break;
            case "getDefaultSlingshotDistance":
                dVar.success(-1);
                break;
            case "setEnabled":
                if (this.pullToRefreshView == null) {
                    dVar.success(Boolean.FALSE);
                    break;
                } else {
                    Boolean bool = (Boolean) jVar.a("enabled");
                    PullToRefreshLayout pullToRefreshLayout = this.pullToRefreshView;
                    pullToRefreshLayout.settings.enabled = bool;
                    pullToRefreshLayout.setEnabled(bool.booleanValue());
                    dVar.success(Boolean.TRUE);
                    break;
                }
                break;
            case "setColor":
                if (this.pullToRefreshView == null) {
                    dVar.success(Boolean.FALSE);
                    break;
                } else {
                    this.pullToRefreshView.setColorSchemeColors(Color.parseColor((String) jVar.a(RemoteMessageConst.Notification.COLOR)));
                    dVar.success(Boolean.TRUE);
                    break;
                }
                break;
            case "setBackgroundColor":
                if (this.pullToRefreshView == null) {
                    dVar.success(Boolean.FALSE);
                    break;
                } else {
                    this.pullToRefreshView.setProgressBackgroundColorSchemeColor(Color.parseColor((String) jVar.a(RemoteMessageConst.Notification.COLOR)));
                    dVar.success(Boolean.TRUE);
                    break;
                }
                break;
            case "setDistanceToTriggerSync":
                if (this.pullToRefreshView == null) {
                    dVar.success(Boolean.FALSE);
                    break;
                } else {
                    this.pullToRefreshView.setDistanceToTriggerSync(((Integer) jVar.a("distanceToTriggerSync")).intValue());
                    dVar.success(Boolean.TRUE);
                    break;
                }
                break;
            case "isRefreshing":
                PullToRefreshLayout pullToRefreshLayout2 = this.pullToRefreshView;
                dVar.success(Boolean.valueOf(pullToRefreshLayout2 != null && pullToRefreshLayout2.isRefreshing()));
                break;
            case "setSize":
                if (this.pullToRefreshView == null) {
                    dVar.success(Boolean.FALSE);
                    break;
                } else {
                    this.pullToRefreshView.setSize(((Integer) jVar.a("size")).intValue());
                    dVar.success(Boolean.TRUE);
                    break;
                }
                break;
            case "isEnabled":
                PullToRefreshLayout pullToRefreshLayout3 = this.pullToRefreshView;
                if (pullToRefreshLayout3 == null) {
                    dVar.success(Boolean.FALSE);
                    break;
                } else {
                    dVar.success(Boolean.valueOf(pullToRefreshLayout3.isEnabled()));
                    break;
                }
                break;
            default:
                dVar.notImplemented();
                break;
        }
    }

    public void onRefresh() {
        l channel = getChannel();
        if (channel == null) {
            return;
        }
        channel.a("onRefresh", new HashMap(), null);
    }
}

package com.pichillilorenzo.flutter_inappwebview_android.types;

import p096m7.j;
import p096m7.l;

/* JADX INFO: loaded from: classes.dex */
public class ChannelDelegateImpl implements IChannelDelegate {
    private l channel;

    public ChannelDelegateImpl(l lVar) {
        this.channel = lVar;
        lVar.b(this);
    }

    public void dispose() {
        l lVar = this.channel;
        if (lVar != null) {
            lVar.b(null);
            this.channel = null;
        }
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate
    public l getChannel() {
        return this.channel;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.IChannelDelegate, m7.l.c
    public void onMethodCall(j jVar, l.d dVar) {
    }
}

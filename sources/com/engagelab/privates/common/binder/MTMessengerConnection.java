package com.engagelab.privates.common.binder;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: loaded from: classes.dex */
public class MTMessengerConnection implements ServiceConnection {
    private final Context context;

    public MTMessengerConnection(Context context) {
        this.context = context;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        MTMessenger.getInstance().onServiceConnected(this.context, iBinder);
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        MTMessenger.getInstance().onServiceDisconnected(this.context);
    }
}

package com.vivo.push;

import android.content.Intent;
import com.vivo.push.h.ag;

/* JADX INFO: loaded from: classes.dex */
public interface IPushClientFactory {
    ag createReceiveTask(w wVar);

    w createReceiverCommand(Intent intent);

    t createTask(w wVar);
}

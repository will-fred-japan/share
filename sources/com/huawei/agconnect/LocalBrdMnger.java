package com.huawei.agconnect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class LocalBrdMnger {
    private static final int MSG_EXEC_PENDING_BROADCASTS = 1;
    private static final Object M_LOCK = new Object();
    private static LocalBrdMnger mInstance;
    private final Context mAppContext;
    private final Handler mHandler;
    private final HashMap<BroadcastReceiver, ArrayList<IntentFilter>> mReceivers = new HashMap<>();
    private final HashMap<String, ArrayList<ReceiverRecord>> mActions = new HashMap<>();
    private final ArrayList<BroadcastRecord> mPendingBroadcasts = new ArrayList<>();

    public static class BroadcastRecord {
        final Intent intent;
        final ArrayList<ReceiverRecord> receivers;

        public BroadcastRecord(Intent intent, ArrayList<ReceiverRecord> arrayList) {
            this.intent = intent;
            this.receivers = arrayList;
        }
    }

    public static class ReceiverRecord {
        boolean broadcasting;
        final IntentFilter filter;
        final BroadcastReceiver receiver;

        public ReceiverRecord(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
            this.filter = intentFilter;
            this.receiver = broadcastReceiver;
        }

        public String toString() {
            return "Receiver{" + this.receiver + " filter=" + this.filter + "}";
        }
    }

    private LocalBrdMnger(Context context) {
        this.mAppContext = context;
        this.mHandler = new Handler(context.getMainLooper()) { // from class: com.huawei.agconnect.LocalBrdMnger.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == 1) {
                    LocalBrdMnger.this.executePendingBroadcasts();
                } else {
                    super.handleMessage(message);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void executePendingBroadcasts() {
        int size;
        BroadcastRecord[] broadcastRecordArr;
        while (true) {
            synchronized (this.mReceivers) {
                try {
                    size = this.mPendingBroadcasts.size();
                    if (size <= 0) {
                        return;
                    }
                    broadcastRecordArr = new BroadcastRecord[size];
                    this.mPendingBroadcasts.toArray(broadcastRecordArr);
                    this.mPendingBroadcasts.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            for (int i9 = 0; i9 < size; i9++) {
                BroadcastRecord broadcastRecord = broadcastRecordArr[i9];
                for (int i10 = 0; i10 < broadcastRecord.receivers.size(); i10++) {
                    broadcastRecord.receivers.get(i10).receiver.onReceive(this.mAppContext, broadcastRecord.intent);
                }
            }
        }
    }

    public static LocalBrdMnger getInstance(Context context) {
        LocalBrdMnger localBrdMnger;
        synchronized (M_LOCK) {
            try {
                if (mInstance == null) {
                    mInstance = new LocalBrdMnger(context.getApplicationContext());
                }
                localBrdMnger = mInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return localBrdMnger;
    }

    public void registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.mReceivers) {
            try {
                ReceiverRecord receiverRecord = new ReceiverRecord(intentFilter, broadcastReceiver);
                ArrayList<IntentFilter> arrayList = this.mReceivers.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList<>(1);
                    this.mReceivers.put(broadcastReceiver, arrayList);
                }
                arrayList.add(intentFilter);
                for (int i9 = 0; i9 < intentFilter.countActions(); i9++) {
                    String action = intentFilter.getAction(i9);
                    ArrayList<ReceiverRecord> arrayList2 = this.mActions.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList<>(1);
                        this.mActions.put(action, arrayList2);
                    }
                    arrayList2.add(receiverRecord);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean sendBroadcast(Intent intent) {
        synchronized (this.mReceivers) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.mAppContext.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                ArrayList<ReceiverRecord> arrayList = this.mActions.get(intent.getAction());
                if (arrayList != null) {
                    ArrayList arrayList2 = null;
                    for (int i9 = 0; i9 < arrayList.size(); i9++) {
                        ReceiverRecord receiverRecord = arrayList.get(i9);
                        if (!receiverRecord.broadcasting && receiverRecord.filter.match(action, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager") >= 0) {
                            if (arrayList2 == null) {
                                arrayList2 = new ArrayList();
                            }
                            arrayList2.add(receiverRecord);
                            receiverRecord.broadcasting = true;
                        }
                    }
                    if (arrayList2 != null) {
                        for (int i10 = 0; i10 < arrayList2.size(); i10++) {
                            ((ReceiverRecord) arrayList2.get(i10)).broadcasting = false;
                        }
                        this.mPendingBroadcasts.add(new BroadcastRecord(intent, arrayList2));
                        if (!this.mHandler.hasMessages(1)) {
                            this.mHandler.sendEmptyMessage(1);
                        }
                        return true;
                    }
                }
                return false;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        synchronized (this.mReceivers) {
            try {
                ArrayList<IntentFilter> arrayListRemove = this.mReceivers.remove(broadcastReceiver);
                if (arrayListRemove != null) {
                    for (int i9 = 0; i9 < arrayListRemove.size(); i9++) {
                        IntentFilter intentFilter = arrayListRemove.get(i9);
                        for (int i10 = 0; i10 < intentFilter.countActions(); i10++) {
                            String action = intentFilter.getAction(i10);
                            ArrayList<ReceiverRecord> arrayList = this.mActions.get(action);
                            if (arrayList != null) {
                                int i11 = 0;
                                while (i11 < arrayList.size()) {
                                    if (arrayList.get(i11).receiver == broadcastReceiver) {
                                        arrayList.remove(i11);
                                        i11--;
                                    }
                                    i11++;
                                }
                                if (arrayList.size() <= 0) {
                                    this.mActions.remove(action);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}

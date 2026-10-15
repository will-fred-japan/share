package com.heytap.msp.push.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import androidx.datastore.preferences.protobuf.C0524s;
import com.heytap.mcssdk.constant.MessageConstant;
import com.heytap.mcssdk.d.d;
import com.heytap.mcssdk.utils.Utils;
import com.heytap.mcssdk.utils.e;
import com.heytap.mcssdk.utils.i;
import com.heytap.msp.push.callback.ICallkitDataMessageCallback;
import com.heytap.msp.push.mode.BaseMode;
import com.heytap.msp.push.mode.CallkitDataMessage;
import com.heytap.msp.push.mode.EnhanceDataMessage;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public class EnhancedDataMessageService extends Service implements ICallkitDataMessageCallback {
    private static final String TAG = "EnhancedDataMessageService";
    private static final AtomicInteger sHandledMessageCount = new AtomicInteger(0);
    private static final AtomicLong sLastHandleTime = new AtomicLong(0);
    private final Object mProcessingLock = new Object();
    private final b mParserFactory = b.a();

    private static String getHandleStats() {
        return "Handled messages: " + sHandledMessageCount.get() + ", Last handle time: " + sLastHandleTime.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CallkitDataMessage parseCallkitMessage(Intent intent, int i9) {
        if (intent == null) {
            e.d(TAG, "Intent is null, cannot parse CallkitDataMessage");
            return null;
        }
        try {
            com.heytap.mcssdk.d.e eVarA = this.mParserFactory.a(i9);
            if (eVarA != null) {
                BaseMode baseModeA = eVarA.a(getBaseContext(), i9, intent);
                if (baseModeA instanceof CallkitDataMessage) {
                    return (CallkitDataMessage) baseModeA;
                }
                e.d(TAG, "Parsed message is not CallkitDataMessage type");
                return null;
            }
        } catch (Exception e9) {
            e.e(TAG, "Error parsing CallkitDataMessage: " + e9.getMessage());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public EnhanceDataMessage parseMessage(Intent intent) {
        if (intent == null) {
            e.d(TAG, "Intent is null, cannot parse message");
            return null;
        }
        try {
            com.heytap.mcssdk.d.e eVarA = this.mParserFactory.a(MessageConstant.MessageType.MESSAGE_SPT_ENHANCED_DATA);
            if (eVarA != null) {
                BaseMode baseModeA = eVarA.a(getBaseContext(), MessageConstant.MessageType.MESSAGE_SPT_ENHANCED_DATA, intent);
                if (baseModeA instanceof EnhanceDataMessage) {
                    return (EnhanceDataMessage) baseModeA;
                }
                e.d(TAG, "Parsed message is not EnhanceDataMessage type");
                return null;
            }
        } catch (Exception e9) {
            e.e(TAG, "Error parsing message: " + e9.getMessage());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processCallkitMessage(CallkitDataMessage callkitDataMessage) {
        if (callkitDataMessage == null) {
            e.d(TAG, "Received null CallkitDataMessage");
            return;
        }
        int iIncrementAndGet = sHandledMessageCount.incrementAndGet();
        sLastHandleTime.set(System.currentTimeMillis());
        try {
            onCallkitMessageReceived(callkitDataMessage);
            e.b(TAG, "Successfully processed CallkitDataMessage #" + iIncrementAndGet + ", ID: " + callkitDataMessage.getMessageID());
        } catch (Exception e9) {
            String str = TAG;
            StringBuilder sbA = C0524s.a(iIncrementAndGet, "Error processing CallkitDataMessage #", ": ");
            sbA.append(e9.getMessage());
            e.e(str, sbA.toString());
        }
    }

    private void processIncomingMessage(final Intent intent, int i9) {
        e.b(TAG, "Processing incoming message, startId: " + i9);
        try {
            i.a(new Runnable() { // from class: com.heytap.msp.push.service.EnhancedDataMessageService.1
                @Override // java.lang.Runnable
                public void run() {
                    String str;
                    String str2;
                    synchronized (EnhancedDataMessageService.this.mProcessingLock) {
                        try {
                            if (EnhancedDataMessageService.this.validateParams(intent)) {
                                int iA = d.a(intent);
                                if (iA == 4117) {
                                    EnhanceDataMessage message = EnhancedDataMessageService.this.parseMessage(intent);
                                    if (message != null) {
                                        EnhancedDataMessageService.this.processMessage(message);
                                    } else {
                                        str = EnhancedDataMessageService.TAG;
                                        str2 = "Failed to parse EnhanceDataMessage from intent";
                                        e.d(str, str2);
                                    }
                                } else if (iA == 4120) {
                                    CallkitDataMessage callkitMessage = EnhancedDataMessageService.this.parseCallkitMessage(intent, iA);
                                    if (callkitMessage != null) {
                                        EnhancedDataMessageService.this.processCallkitMessage(callkitMessage);
                                    } else {
                                        str = EnhancedDataMessageService.TAG;
                                        str2 = "Failed to parse CallkitDataMessage from intent";
                                        e.d(str, str2);
                                    }
                                } else {
                                    e.d(EnhancedDataMessageService.TAG, "Unknown message type: " + iA);
                                }
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
            });
        } catch (Exception e9) {
            e.e(TAG, "Error in processIncomingMessage: " + e9.getMessage());
            onMessageHandleError(e9);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processMessage(EnhanceDataMessage enhanceDataMessage) {
        if (enhanceDataMessage == null) {
            e.d(TAG, "Received null message");
            return;
        }
        int iIncrementAndGet = sHandledMessageCount.incrementAndGet();
        sLastHandleTime.set(System.currentTimeMillis());
        try {
            onMessageReceived(enhanceDataMessage);
            e.b(TAG, "Successfully processed message #" + iIncrementAndGet + ", ID: " + enhanceDataMessage.getMessageID());
        } catch (Exception e9) {
            String str = TAG;
            StringBuilder sbA = C0524s.a(iIncrementAndGet, "Error processing message #", ": ");
            sbA.append(e9.getMessage());
            e.e(str, sbA.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean validateParams(Intent intent) {
        String str;
        String str2;
        if (getBaseContext() == null) {
            str = TAG;
            str2 = "Context is null";
        } else if (intent == null) {
            str = TAG;
            str2 = "Intent is null";
        } else {
            if (Utils.isSupportPushByClient(getBaseContext())) {
                return true;
            }
            str = TAG;
            str2 = "Push is not supported on this client";
        }
        e.e(str, str2);
        return false;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    public void onCallkitMessageReceived(CallkitDataMessage callkitDataMessage) {
        e.b(TAG, "onCallkitMessageReceived() - Message ID: " + callkitDataMessage.getMessageID());
    }

    @Override // android.app.Service
    public void onCreate() {
        e.b(TAG, "EnhancedDataMessageService created.");
    }

    @Override // android.app.Service
    public void onDestroy() {
        e.b(TAG, "EnhancedDataMessageService destroyed, " + getHandleStats());
    }

    public void onMessageHandleError(Exception exc) {
        e.e(TAG, "Enhanced data message processing error: " + exc.getMessage());
    }

    public void onMessageReceived(EnhanceDataMessage enhanceDataMessage) {
        e.b(TAG, "onMessageReceived() - Message ID: " + enhanceDataMessage.getMessageID());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i9, int i10) {
        String str = TAG;
        e.b(str, "EnhancedDataMessageService onStartCommand called, startId: " + i10);
        if (intent == null) {
            e.d(str, "Received null intent in onStartCommand");
            return 2;
        }
        processIncomingMessage(intent, i10);
        return 2;
    }
}

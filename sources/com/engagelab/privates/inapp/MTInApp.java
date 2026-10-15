package com.engagelab.privates.inapp;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.engagelab.privates.common.a0;
import com.engagelab.privates.common.api.MTCommonPrivatesApi;
import com.engagelab.privates.common.constants.MTCommonConstants;
import com.engagelab.privates.common.observer.MTObserver;
import com.starburst.sdk.core.feed.aigc.TextToImageManager;

/* JADX INFO: loaded from: classes.dex */
public class MTInApp extends MTObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f12421a = MTCommonConstants.getLogTag() + "INAPP";

    @Override // com.engagelab.privates.common.observer.MTObserver
    public void dispatchMessage(Context context, int i9, Bundle bundle) {
        if (i9 != 1005) {
            if (i9 != 1006) {
                if (i9 != 1013 && i9 != 1014 && i9 != 1017 && i9 != 1018) {
                    if (i9 != 1994) {
                        if (i9 != 1995) {
                            if (i9 != 3304) {
                                switch (i9) {
                                    case 4000:
                                    case TextToImageManager.AIGC_ERROR_QUOTA_EXCEEDED /* 4001 */:
                                    case 4002:
                                    case 4003:
                                    case 4004:
                                    case 4005:
                                    case 4006:
                                    case 4007:
                                    case 4008:
                                        break;
                                    default:
                                        MTCommonPrivatesApi.sendMessage(context, f12421a, i9, bundle);
                                        break;
                                }
                                return;
                            }
                        }
                    }
                }
                a0.a().a(context, i9, bundle);
                return;
            }
            a0.a().a(false);
            return;
        }
        a0.a().a(true);
    }

    @Override // com.engagelab.privates.common.observer.MTObserver
    public String[] getThreadName() {
        return new String[]{f12421a};
    }

    @Override // com.engagelab.privates.common.observer.MTObserver
    public void handleDelayMessage(Context context, int i9, Bundle bundle) {
        if (i9 == 4002 || i9 == 4005) {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                a0.a().a(context, i9, bundle);
            } else {
                MTCommonPrivatesApi.sendMessageToMainProcess(context, i9, bundle);
            }
        }
    }

    @Override // com.engagelab.privates.common.observer.MTObserver
    public void handleMessage(Context context, int i9, Bundle bundle) {
        if (i9 == 59) {
            a0.a().c(context, bundle);
        } else {
            if (i9 == 3795) {
                a0.a().b(context, bundle);
                return;
            }
            switch (i9) {
                case 4996:
                case 4997:
                case 4998:
                case 4999:
                    a0.a().b(context, i9, bundle);
                    break;
            }
        }
    }

    @Override // com.engagelab.privates.common.observer.MTObserver
    public boolean isSupport(int i9) {
        if (i9 == 59 || i9 == 3304 || i9 == 3795 || i9 == 1005 || i9 == 1006 || i9 == 1013 || i9 == 1014 || i9 == 1017 || i9 == 1018 || i9 == 1994 || i9 == 1995) {
            return true;
        }
        switch (i9) {
            case 4000:
            case TextToImageManager.AIGC_ERROR_QUOTA_EXCEEDED /* 4001 */:
            case 4002:
            case 4003:
            case 4004:
            case 4005:
            case 4006:
            case 4007:
            case 4008:
                return true;
            default:
                switch (i9) {
                    case 4996:
                    case 4997:
                    case 4998:
                    case 4999:
                        return true;
                    default:
                        return false;
                }
        }
    }
}

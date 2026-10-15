package N6;

import com.starburst.sdk.api.IVoiceCloneCallback;
import com.starburst.sdk.api.OnDeviceRecordStateListener;
import com.starburst.sdk.req.VcSpeaker;

/* JADX INFO: compiled from: StarburstBleAuthPlugin.kt */
/* JADX INFO: loaded from: classes.dex */
public final class p implements OnDeviceRecordStateListener, IVoiceCloneCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0344o f3423a;

    @Override // com.starburst.sdk.api.IVoiceCloneCallback
    public void onError(int i9, String str) {
        if (str == null) {
            str = "";
        }
        C0344o.j(this.f3423a, "voiceClone.error", i9, str, null, null, 24);
    }

    @Override // com.starburst.sdk.api.OnDeviceRecordStateListener
    public void onRemoteFunctionRequest(int i9) {
        C0344o.j(this.f3423a, "deviceRecord.remoteFunctionRequest", 0, null, y7.t.B(new p188x7.e("function", Integer.valueOf(i9))), null, 22);
    }

    @Override // com.starburst.sdk.api.OnDeviceRecordStateListener
    public void onStateChange(int i9, int i10) {
        C0344o.j(this.f3423a, "deviceRecord.stateChange", 0, null, y7.u.D(new p188x7.e("recordType", Integer.valueOf(i9)), new p188x7.e("state", Integer.valueOf(i10))), null, 22);
    }

    @Override // com.starburst.sdk.api.IVoiceCloneCallback
    public void onSuccess(VcSpeaker vcSpeaker) {
        C0344o c0344o = this.f3423a;
        C0344o.j(c0344o, "voiceClone.success", 0, null, y7.t.B(new p188x7.e("speaker", vcSpeaker != null ? C0344o.d(c0344o, vcSpeaker) : null)), null, 22);
    }

    @Override // com.starburst.sdk.api.OnDeviceRecordStateListener
    public void onError(int i9, int i10) {
        C0344o.j(this.f3423a, "deviceRecord.error", i10, null, y7.t.B(new p188x7.e("recordType", Integer.valueOf(i9))), null, 20);
    }
}

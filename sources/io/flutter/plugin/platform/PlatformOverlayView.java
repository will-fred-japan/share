package io.flutter.plugin.platform;

import android.view.MotionEvent;
import io.flutter.embedding.android.FlutterImageView;

/* JADX INFO: loaded from: classes2.dex */
public class PlatformOverlayView extends FlutterImageView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f19571h;

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        a aVar = this.f19571h;
        if (aVar != null) {
            io.flutter.view.b bVar = aVar.f19590a;
            if (bVar == null ? false : bVar.f(motionEvent, true)) {
                return true;
            }
        }
        return super.onHoverEvent(motionEvent);
    }
}

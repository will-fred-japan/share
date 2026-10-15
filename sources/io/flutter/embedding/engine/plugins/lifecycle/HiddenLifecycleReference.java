package io.flutter.embedding.engine.plugins.lifecycle;

import androidx.annotation.Keep;
import androidx.lifecycle.AbstractC0544j;

/* JADX INFO: loaded from: classes2.dex */
@Keep
public class HiddenLifecycleReference {
    private final AbstractC0544j lifecycle;

    public HiddenLifecycleReference(AbstractC0544j abstractC0544j) {
        this.lifecycle = abstractC0544j;
    }

    public AbstractC0544j getLifecycle() {
        return this.lifecycle;
    }
}

package com.starburst.sdk.business;

import kotlin.jvm.internal.l;

/* JADX INFO: loaded from: classes.dex */
public final class FileProcessingManager$mFileResultTaskPoller$2 extends l implements K7.a<FileResultTaskPoller> {
    public static final FileProcessingManager$mFileResultTaskPoller$2 INSTANCE = new FileProcessingManager$mFileResultTaskPoller$2();

    public FileProcessingManager$mFileResultTaskPoller$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // K7.a
    public final FileResultTaskPoller invoke() {
        return new FileResultTaskPoller();
    }
}

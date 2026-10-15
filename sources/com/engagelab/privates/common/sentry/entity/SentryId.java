package com.engagelab.privates.common.sentry.entity;

import com.xiaomi.mipush.sdk.Constants;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public final class SentryId {
    public static final SentryId EMPTY_ID = new SentryId(new UUID(0, 0));
    private final UUID uuid;

    public SentryId() {
        this((UUID) null);
    }

    private UUID fromStringSentryId(String str) {
        if (str == null) {
            return null;
        }
        if (str.length() == 32) {
            str = new StringBuilder(str).insert(8, Constants.ACCEPT_TIME_SEPARATOR_SERVER).insert(13, Constants.ACCEPT_TIME_SEPARATOR_SERVER).insert(18, Constants.ACCEPT_TIME_SEPARATOR_SERVER).insert(23, Constants.ACCEPT_TIME_SEPARATOR_SERVER).toString();
        }
        if (str.length() == 36) {
            return UUID.fromString(str);
        }
        throw new IllegalArgumentException("String representation of SentryId has either 32 (UUID no dashes) or 36 characters long (completed UUID). Received: ".concat(str));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && SentryId.class == obj.getClass() && this.uuid.compareTo(((SentryId) obj).uuid) == 0;
    }

    public int hashCode() {
        return this.uuid.hashCode();
    }

    public String toString() {
        return this.uuid.toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
    }

    public SentryId(UUID uuid) {
        this.uuid = uuid == null ? UUID.randomUUID() : uuid;
    }

    public SentryId(String str) {
        this.uuid = fromStringSentryId(str);
    }
}

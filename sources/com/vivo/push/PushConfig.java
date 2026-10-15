package com.vivo.push;

/* JADX INFO: loaded from: classes.dex */
public class PushConfig {
    private boolean mAgreePrivacyStatement;
    private boolean mOpenMultiUser;

    public static final class Builder {
        private boolean mAgreePrivacyStatement = true;
        private boolean mOpenMultiUser = false;

        public final Builder agreePrivacyStatement(boolean z8) {
            this.mAgreePrivacyStatement = z8;
            return this;
        }

        public final PushConfig build() {
            return new PushConfig(this);
        }

        public final Builder openMultiUserMode(boolean z8) {
            this.mOpenMultiUser = z8;
            return this;
        }
    }

    public boolean isAgreePrivacyStatement() {
        return this.mAgreePrivacyStatement;
    }

    public boolean isOpenMultiUser() {
        return this.mOpenMultiUser;
    }

    private PushConfig(Builder builder) {
        this.mAgreePrivacyStatement = true;
        this.mOpenMultiUser = false;
        this.mAgreePrivacyStatement = builder.mAgreePrivacyStatement;
        this.mOpenMultiUser = builder.mOpenMultiUser;
    }
}

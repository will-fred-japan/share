package com.starburst.sdk.core.model;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class VoiceChatIntent {
    private Integer input_token;
    private String intent;
    private List<IntentItem> intents;
    private Integer output_token;
    private String query;
    private String requestId;
    private String skill;
    private String value;

    public static final class IntentItem {
        private String intent;
        private Integer order;
        private String skill;
        private String span;
        private String value;

        public final String getIntent() {
            return this.intent;
        }

        public final Integer getOrder() {
            return this.order;
        }

        public final String getSkill() {
            return this.skill;
        }

        public final String getSpan() {
            return this.span;
        }

        public final String getValue() {
            return this.value;
        }

        public final void setIntent(String str) {
            this.intent = str;
        }

        public final void setOrder(Integer num) {
            this.order = num;
        }

        public final void setSkill(String str) {
            this.skill = str;
        }

        public final void setSpan(String str) {
            this.span = str;
        }

        public final void setValue(String str) {
            this.value = str;
        }

        public String toString() {
            return "intent = " + this.intent + " ,value = " + this.value + " ,skill = " + this.skill + " ,span = " + this.span + " ,order = " + this.order;
        }
    }

    public final Integer getInput_token() {
        return this.input_token;
    }

    public final String getIntent() {
        return this.intent;
    }

    public final List<IntentItem> getIntents() {
        return this.intents;
    }

    public final Integer getOutput_token() {
        return this.output_token;
    }

    public final String getQuery() {
        return this.query;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final String getSkill() {
        return this.skill;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setInput_token(Integer num) {
        this.input_token = num;
    }

    public final void setIntent(String str) {
        this.intent = str;
    }

    public final void setIntents(List<IntentItem> list) {
        this.intents = list;
    }

    public final void setOutput_token(Integer num) {
        this.output_token = num;
    }

    public final void setQuery(String str) {
        this.query = str;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final void setSkill(String str) {
        this.skill = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        return "intent = " + this.intent + " ,query = " + this.query + " ,requestId = " + this.requestId + " ,value = " + this.value + " ,skill = " + this.skill + " ,intents = " + this.intents;
    }
}

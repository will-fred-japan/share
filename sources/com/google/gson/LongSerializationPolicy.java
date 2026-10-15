package com.google.gson;

/* JADX INFO: loaded from: classes.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l8) {
            return l8 == null ? JsonNull.INSTANCE : new JsonPrimitive(l8);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public JsonElement serialize(Long l8) {
            return l8 == null ? JsonNull.INSTANCE : new JsonPrimitive(l8.toString());
        }
    };

    public abstract JsonElement serialize(Long l8);
}

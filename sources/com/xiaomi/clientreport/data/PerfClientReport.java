package com.xiaomi.clientreport.data;

import com.xiaomi.channel.commonutils.logger.c;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class PerfClientReport extends a {
    private static final long DEFAULT_VALUE = -1;
    public int code;
    public long perfCounts = DEFAULT_VALUE;
    public long perfLatencies = DEFAULT_VALUE;

    public static PerfClientReport getBlankInstance() {
        return new PerfClientReport();
    }

    @Override // com.xiaomi.clientreport.data.a
    public JSONObject toJson() {
        try {
            JSONObject json = super.toJson();
            if (json == null) {
                return null;
            }
            json.put("code", this.code);
            json.put("perfCounts", this.perfCounts);
            json.put("perfLatencies", this.perfLatencies);
            return json;
        } catch (JSONException e9) {
            c.m12a((Throwable) e9);
            return null;
        }
    }

    @Override // com.xiaomi.clientreport.data.a
    public String toJsonString() {
        return super.toJsonString();
    }
}

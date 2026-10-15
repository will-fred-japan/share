package cn.jpush.android.api;

import H2.a;
import cn.jpush.android.helper.g;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class CallBackParams implements Serializable {
    public int action;
    public String alias;
    public Map<String, Object> pros;
    public int protoType;
    private long sendTime;
    public int sequence;
    public TagAliasCallback tagAliasCallBack;
    public Set<String> tags;

    public CallBackParams(int i9, long j, int i10, int i11) {
        this.sequence = i9;
        this.sendTime = j;
        this.protoType = i10;
        this.action = i11;
    }

    public boolean isTimeOut(long j) {
        return this.protoType == 0 && System.currentTimeMillis() - this.sendTime > j + 10000;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CallBackParams{sendTime=");
        sb.append(this.sendTime);
        sb.append(", alias='");
        sb.append(this.alias);
        sb.append("', pros='");
        sb.append(this.pros);
        sb.append("', tags=");
        sb.append(this.tags);
        sb.append(", tagAliasCallBack=");
        sb.append(this.tagAliasCallBack);
        sb.append(", sequence=");
        sb.append(this.sequence);
        sb.append(", protoType=");
        sb.append(this.protoType);
        sb.append(", action=");
        return a.a(sb, this.action, '}');
    }

    public CallBackParams(int i9, String str, long j, int i10, int i11) {
        this.sequence = i9;
        this.alias = str;
        this.sendTime = j;
        this.protoType = i10;
        this.action = i11;
    }

    public CallBackParams(int i9, Map<String, Object> map, long j, int i10, int i11) {
        this.sequence = i9;
        this.pros = map;
        this.sendTime = j;
        this.protoType = i10;
        this.action = i11;
    }

    public CallBackParams(int i9, Set<String> set, long j, int i10, int i11) {
        this.sequence = i9;
        this.tags = set;
        this.sendTime = j;
        this.protoType = i10;
        this.action = i11;
    }

    public CallBackParams(String str, Set<String> set, TagAliasCallback tagAliasCallback, long j, int i9, int i10) {
        this.alias = str;
        this.tags = set;
        this.tagAliasCallBack = tagAliasCallback;
        this.sendTime = j;
        this.protoType = i9;
        this.action = i10;
        this.sequence = (int) g.a();
    }
}

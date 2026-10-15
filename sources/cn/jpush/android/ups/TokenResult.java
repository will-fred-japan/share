package cn.jpush.android.ups;

import A.a;

/* JADX INFO: loaded from: classes.dex */
public class TokenResult {
    private String actionType;
    private int returnCode;
    private String token;

    public TokenResult(String str, int i9) {
        this.token = str;
        this.returnCode = i9;
    }

    public String getActionType() {
        return this.actionType;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getToken() {
        return this.token;
    }

    public void setActionType(String str) {
        this.actionType = str;
    }

    public void setReturnCode(int i9) {
        this.returnCode = i9;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TokenResult{token='");
        sb.append(this.token);
        sb.append("', returnCode=");
        sb.append(this.returnCode);
        sb.append(", actionType='");
        return a.j(sb, this.actionType, "'}");
    }

    public TokenResult(String str, int i9, String str2) {
        this.token = str;
        this.returnCode = i9;
        this.actionType = str2;
    }
}

package cn.jpush.android.api;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class JPushMessage implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11195a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11196b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Set<String> f11198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, Object> f11199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f11200f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f11201g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f11202h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f11203i;
    private int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f11204k;

    public int getAction() {
        return this.f11196b;
    }

    public String getAlias() {
        return this.f11197c;
    }

    public String getCheckTag() {
        return this.f11200f;
    }

    public int getErrorCode() {
        return this.f11201g;
    }

    public String getMobileNumber() {
        return this.f11204k;
    }

    public Map<String, Object> getPros() {
        return this.f11199e;
    }

    public int getProtoType() {
        return this.f11195a;
    }

    public int getSequence() {
        return this.j;
    }

    public boolean getTagCheckStateResult() {
        return this.f11202h;
    }

    public Set<String> getTags() {
        return this.f11198d;
    }

    public boolean isTagCheckOperator() {
        return this.f11203i;
    }

    public void setAction(int i9) {
        this.f11196b = i9;
    }

    public void setAlias(String str) {
        this.f11197c = str;
    }

    public void setCheckTag(String str) {
        this.f11200f = str;
    }

    public void setErrorCode(int i9) {
        this.f11201g = i9;
    }

    public void setMobileNumber(String str) {
        this.f11204k = str;
    }

    public void setPros(Map<String, Object> map) {
        this.f11199e = map;
    }

    public void setProtoType(int i9) {
        this.f11195a = i9;
    }

    public void setSequence(int i9) {
        this.j = i9;
    }

    public void setTagCheckOperator(boolean z8) {
        this.f11203i = z8;
    }

    public void setTagCheckStateResult(boolean z8) {
        this.f11202h = z8;
    }

    public void setTags(Set<String> set) {
        this.f11198d = set;
    }

    public String toString() {
        return "JPushMessage{alias='" + this.f11197c + "', tags=" + this.f11198d + ", pros=" + this.f11199e + ", checkTag='" + this.f11200f + "', errorCode=" + this.f11201g + ", tagCheckStateResult=" + this.f11202h + ", isTagCheckOperator=" + this.f11203i + ", sequence=" + this.j + ", mobileNumber=" + this.f11204k + '}';
    }
}

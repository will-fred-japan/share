package com.pichillilorenzo.flutter_inappwebview_android.types;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class HttpAuthenticationChallenge extends URLAuthenticationChallenge {
    private int previousFailureCount;
    URLCredential proposedCredential;

    public HttpAuthenticationChallenge(URLProtectionSpace uRLProtectionSpace, int i9, URLCredential uRLCredential) {
        super(uRLProtectionSpace);
        this.previousFailureCount = i9;
        this.proposedCredential = uRLCredential;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.URLAuthenticationChallenge
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        HttpAuthenticationChallenge httpAuthenticationChallenge = (HttpAuthenticationChallenge) obj;
        if (this.previousFailureCount != httpAuthenticationChallenge.previousFailureCount) {
            return false;
        }
        URLCredential uRLCredential = this.proposedCredential;
        URLCredential uRLCredential2 = httpAuthenticationChallenge.proposedCredential;
        if (uRLCredential != null) {
            return uRLCredential.equals(uRLCredential2);
        }
        return uRLCredential2 == null;
    }

    public int getPreviousFailureCount() {
        return this.previousFailureCount;
    }

    public URLCredential getProposedCredential() {
        return this.proposedCredential;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.URLAuthenticationChallenge
    public int hashCode() {
        int iHashCode = ((super.hashCode() * 31) + this.previousFailureCount) * 31;
        URLCredential uRLCredential = this.proposedCredential;
        return iHashCode + (uRLCredential != null ? uRLCredential.hashCode() : 0);
    }

    public void setPreviousFailureCount(int i9) {
        this.previousFailureCount = i9;
    }

    public void setProposedCredential(URLCredential uRLCredential) {
        this.proposedCredential = uRLCredential;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.URLAuthenticationChallenge
    public Map<String, Object> toMap() {
        Map<String, Object> map = super.toMap();
        map.put("previousFailureCount", Integer.valueOf(this.previousFailureCount));
        URLCredential uRLCredential = this.proposedCredential;
        map.put("proposedCredential", uRLCredential != null ? uRLCredential.toMap() : null);
        map.put("failureResponse", null);
        map.put("error", null);
        return map;
    }

    @Override // com.pichillilorenzo.flutter_inappwebview_android.types.URLAuthenticationChallenge
    public String toString() {
        return "HttpAuthenticationChallenge{previousFailureCount=" + this.previousFailureCount + ", proposedCredential=" + this.proposedCredential + "} " + super.toString();
    }
}

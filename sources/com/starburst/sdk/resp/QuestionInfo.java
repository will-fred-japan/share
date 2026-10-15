package com.starburst.sdk.resp;

import com.google.gson.annotations.SerializedName;
import defpackage.f;

/* JADX INFO: loaded from: classes.dex */
public class QuestionInfo {
    private boolean correction;
    private int index;
    private String questionNo;
    private String subject;

    @SerializedName("x_max")
    private int xMax;

    @SerializedName("x_min")
    private int xMin;

    @SerializedName("y_max")
    private int yMax;

    @SerializedName("y_min")
    private int yMin;

    public int getIndex() {
        return this.index;
    }

    public String getQuestionNo() {
        return this.questionNo;
    }

    public String getSubject() {
        return this.subject;
    }

    public int getXMax() {
        return this.xMax;
    }

    public int getXMin() {
        return this.xMin;
    }

    public int getYMax() {
        return this.yMax;
    }

    public int getYMin() {
        return this.yMin;
    }

    public boolean isCorrection() {
        return this.correction;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("QuestionInfo{index=");
        sb.append(this.index);
        sb.append(", questionNo='");
        sb.append(this.questionNo);
        sb.append("', subject='");
        sb.append(this.subject);
        sb.append("', xMin=");
        sb.append(this.xMin);
        sb.append(", yMin=");
        sb.append(this.yMin);
        sb.append(", xMax=");
        sb.append(this.xMax);
        sb.append(", yMax=");
        sb.append(this.yMax);
        sb.append(", correction=");
        return f.g(sb, this.correction, '}');
    }
}

package com.starburst.sdk.core.device.bt.domain;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class TrajectoryData {
    private long endTime;
    private String id;
    private long startTime;
    private ArrayList<String> trajectoryList;

    public long getEndTime() {
        return this.endTime;
    }

    public String getId() {
        return this.id;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public ArrayList<String> getTrajectoryList() {
        return this.trajectoryList;
    }

    public void setEndTime(long j) {
        this.endTime = j;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setStartTime(long j) {
        this.startTime = j;
    }

    public void setTrajectoryList(ArrayList<String> arrayList) {
        this.trajectoryList = arrayList;
    }

    public String toString() {
        return "TrajectoryData{startTime=" + this.startTime + ", endTime=" + this.endTime + ", id='" + this.id + "', trajectoryList=" + this.trajectoryList + '}';
    }
}

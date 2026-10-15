package com.heytap.msp.push.mode;

/* JADX INFO: loaded from: classes.dex */
public class NotificationSortMessage implements Comparable<NotificationSortMessage> {
    private int autoDelete;
    private String group;
    private int importantLevel;
    private boolean isMcs;
    private String messageId;
    private int notifyId;
    private long postTime;
    private String statisticData;

    public NotificationSortMessage(String str, int i9, int i10, boolean z8, long j, int i11, String str2) {
        this(str, i9, i10, z8, j, str2);
        this.notifyId = i11;
    }

    @Override // java.lang.Comparable
    public int compareTo(NotificationSortMessage notificationSortMessage) {
        if (notificationSortMessage.getPostTime() < this.postTime) {
            return 1;
        }
        return notificationSortMessage.getPostTime() == this.postTime ? 0 : -1;
    }

    public int getAutoDelete() {
        return this.autoDelete;
    }

    public String getGroup() {
        return this.group;
    }

    public int getImportantLevel() {
        return this.importantLevel;
    }

    public String getMessageId() {
        return this.messageId;
    }

    public int getNotifyId() {
        return this.notifyId;
    }

    public long getPostTime() {
        return this.postTime;
    }

    public String getStatisticData() {
        return this.statisticData;
    }

    public boolean isMcs() {
        return this.isMcs;
    }

    public void setGroup(String str) {
        this.group = str;
    }

    public NotificationSortMessage(String str, int i9, int i10, boolean z8, long j, String str2) {
        this.messageId = str;
        this.importantLevel = i9;
        this.autoDelete = i10;
        this.isMcs = z8;
        this.postTime = j;
        this.statisticData = str2;
    }
}

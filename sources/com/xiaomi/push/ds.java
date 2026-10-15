package com.xiaomi.push;

import com.xiaomi.channel.commonutils.logger.AdvancedLoggerInterface;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;

/* JADX INFO: loaded from: classes2.dex */
public class ds implements AdvancedLoggerInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LoggerInterface f17278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LoggerInterface f17279b;

    public ds(LoggerInterface loggerInterface, LoggerInterface loggerInterface2) {
        this.f17278a = loggerInterface;
        this.f17279b = loggerInterface2;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        LoggerInterface loggerInterface = this.f17278a;
        if (loggerInterface != null) {
            loggerInterface.log(str);
        }
        LoggerInterface loggerInterface2 = this.f17279b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        LoggerInterface loggerInterface = this.f17278a;
        if (loggerInterface != null) {
            loggerInterface.log(str, th);
        }
        LoggerInterface loggerInterface2 = this.f17279b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.AdvancedLoggerInterface
    public void log(int i9, String str) {
        LoggerInterface loggerInterface = this.f17278a;
        if (loggerInterface != null) {
            if (loggerInterface instanceof AdvancedLoggerInterface) {
                ((AdvancedLoggerInterface) loggerInterface).log(i9, str);
            } else {
                loggerInterface.log(str);
            }
        }
        LoggerInterface loggerInterface2 = this.f17279b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.AdvancedLoggerInterface
    public void log(int i9, String str, Throwable th) {
        LoggerInterface loggerInterface = this.f17278a;
        if (loggerInterface != null) {
            if (loggerInterface instanceof AdvancedLoggerInterface) {
                ((AdvancedLoggerInterface) loggerInterface).log(i9, str, th);
            } else {
                loggerInterface.log(str, th);
            }
        }
        LoggerInterface loggerInterface2 = this.f17279b;
        if (loggerInterface2 != null) {
            loggerInterface2.log(str, th);
        }
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
    }
}

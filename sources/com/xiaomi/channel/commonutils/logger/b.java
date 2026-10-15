package com.xiaomi.channel.commonutils.logger;

/* JADX INFO: loaded from: classes.dex */
class b implements AdvancedLoggerInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LoggerInterface f16919a;

    public b(LoggerInterface loggerInterface) {
        this.f16919a = loggerInterface;
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str) {
        LoggerInterface loggerInterface = this.f16919a;
        if (loggerInterface == null) {
            return;
        }
        loggerInterface.log(str);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void setTag(String str) {
        LoggerInterface loggerInterface = this.f16919a;
        if (loggerInterface == null) {
            return;
        }
        loggerInterface.setTag(str);
    }

    @Override // com.xiaomi.channel.commonutils.logger.LoggerInterface
    public void log(String str, Throwable th) {
        LoggerInterface loggerInterface = this.f16919a;
        if (loggerInterface == null) {
            return;
        }
        loggerInterface.log(str, th);
    }

    @Override // com.xiaomi.channel.commonutils.logger.AdvancedLoggerInterface
    public void log(int i9, String str) {
        LoggerInterface loggerInterface = this.f16919a;
        if (loggerInterface == null) {
            return;
        }
        loggerInterface.log(str);
    }

    @Override // com.xiaomi.channel.commonutils.logger.AdvancedLoggerInterface
    public void log(int i9, String str, Throwable th) {
        LoggerInterface loggerInterface = this.f16919a;
        if (loggerInterface == null) {
            return;
        }
        loggerInterface.log(str, th);
    }
}

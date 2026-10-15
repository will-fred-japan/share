package p184x3;

/* JADX INFO: compiled from: AssistConfig.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f22276b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public C0281a f22277a;

    /* JADX INFO: renamed from: x3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssistConfig.java */
    public static class C0281a {
        public final String toString() {
            return "CpuAbnormalConfig{cpuHardWare='unknown', scene='default', cpuSpeed=0.0, smallCpuCoreTimePercent=0.0, middleCpuCoreTimePercent=0.0, BigCpuCoreTimePercent=0.0}";
        }
    }

    static {
        a aVar = new a();
        aVar.f22277a = new C0281a();
        f22276b = aVar;
    }

    public final String toString() {
        return "AssistConfig{enableProcessCpuUsageStat=false, enableThreadCpuUsageStat=false, enableSystemCpuUsageStat=false, enableProcessTimeFreqPercent=false, enableSystemCpuTimeFreqPercent=false, cpuSampleBatteryTemp=37, cpuSampleBatteryLevel=30, cpuAbnormalConfig=" + this.f22277a + '}';
    }
}

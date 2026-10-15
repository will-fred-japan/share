package J;

/* JADX INFO: compiled from: CamUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[][] f2602a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final float[][] f2603b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final float[] f2604c = {95.047f, 100.0f, 108.883f};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final float[][] f2605d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};

    public static int a(float f6) {
        if (f6 < 1.0f) {
            return -16777216;
        }
        if (f6 > 99.0f) {
            return -1;
        }
        float f9 = (f6 + 16.0f) / 116.0f;
        float f10 = f6 > 8.0f ? f9 * f9 * f9 : f6 / 903.2963f;
        float f11 = f9 * f9 * f9;
        boolean z8 = f11 > 0.008856452f;
        float f12 = z8 ? f11 : ((f9 * 116.0f) - 16.0f) / 903.2963f;
        if (!z8) {
            f11 = ((f9 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = f2604c;
        return K.a.a(f12 * fArr[0], f10 * fArr[1], f11 * fArr[2]);
    }

    public static float b(int i9) {
        float f6 = i9 / 255.0f;
        return (f6 <= 0.04045f ? f6 / 12.92f : (float) Math.pow((f6 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static float c() {
        return ((float) Math.pow((((double) 50.0f) + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }
}

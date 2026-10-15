package cn.jpush.android.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class JPushCollectControl implements Serializable {
    private static final int APP_LISTS = 1001;
    public static final int APP_RUNNING = 1013;
    private static final int BSSID = 1007;
    private static final int CELL = 1008;
    private static final int GPS = 1000;
    private static final int IMEI = 1003;
    public static final int IMSI = 1010;
    private static final int MAC = 1005;
    private static final int SSID = 1006;
    public static final int WIFI = 1012;
    private static final long serialVersionUID = -3135447319267654288L;
    private ArrayList<Integer> mEnableDatas = new ArrayList<>();
    private ArrayList<Integer> mDisableDatas = new ArrayList<>();

    public static class Builder {
        private Set<Integer> mEnableDatas = new HashSet();
        private Set<Integer> mDisableDatas = new HashSet();

        private void disable(int i9) {
            this.mEnableDatas.remove(Integer.valueOf(i9));
            this.mDisableDatas.add(Integer.valueOf(i9));
        }

        private void enable(int i9) {
            this.mDisableDatas.remove(Integer.valueOf(i9));
            this.mEnableDatas.add(Integer.valueOf(i9));
        }

        private void set(boolean z8, int i9) {
            if (z8) {
                enable(i9);
            } else {
                disable(i9);
            }
        }

        public Builder bssid(boolean z8) {
            set(z8, 1007);
            if (!z8) {
                wifi(false);
            }
            return this;
        }

        public JPushCollectControl build() {
            return new JPushCollectControl(this);
        }

        public Builder cell(boolean z8) {
            set(z8, 1008);
            return this;
        }

        public Builder imei(boolean z8) {
            set(z8, 1003);
            return this;
        }

        public Builder imsi(boolean z8) {
            set(z8, JPushCollectControl.IMSI);
            return this;
        }

        public Builder mac(boolean z8) {
            set(z8, 1005);
            return this;
        }

        public Builder ssid(boolean z8) {
            set(z8, 1006);
            if (!z8) {
                wifi(false);
            }
            return this;
        }

        public Builder wifi(boolean z8) {
            set(z8, 1012);
            return this;
        }
    }

    public JPushCollectControl(Builder builder) {
        if (builder.mDisableDatas != null && !builder.mDisableDatas.isEmpty()) {
            this.mDisableDatas.addAll(builder.mDisableDatas);
        }
        if (builder.mEnableDatas == null || builder.mEnableDatas.isEmpty()) {
            return;
        }
        this.mEnableDatas.addAll(builder.mEnableDatas);
    }

    public ArrayList<Integer> getDisableDatas() {
        return this.mDisableDatas;
    }

    public ArrayList<Integer> getEnableDatas() {
        return this.mEnableDatas;
    }
}

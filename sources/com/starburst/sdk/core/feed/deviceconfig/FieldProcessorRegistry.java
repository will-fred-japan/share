package com.starburst.sdk.core.feed.deviceconfig;

import android.util.SparseArray;
import java.io.DataInputStream;

/* JADX INFO: loaded from: classes.dex */
class FieldProcessorRegistry {
    private static final SparseArray<FieldProcessor> PROCESSORS = new SparseArray<>();
    private static final String TAG = "lishunFieldProcessorRegistry";

    public interface FieldProcessor {
        void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9);
    }

    static {
        final int i9 = 0;
        register(0, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.a
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i10) {
                switch (i9) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$0(deviceConfig, dataInputStream, i10);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$20(deviceConfig, dataInputStream, i10);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$23(deviceConfig, dataInputStream, i10);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$26(deviceConfig, dataInputStream, i10);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$28(deviceConfig, dataInputStream, i10);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$4(deviceConfig, dataInputStream, i10);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$7(deviceConfig, dataInputStream, i10);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$11(deviceConfig, dataInputStream, i10);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$14(deviceConfig, dataInputStream, i10);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$17(deviceConfig, dataInputStream, i10);
                        break;
                }
            }
        });
        final int i10 = 0;
        register(1, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.c
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i11) {
                switch (i10) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$1(deviceConfig, dataInputStream, i11);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$22(deviceConfig, dataInputStream, i11);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$25(deviceConfig, dataInputStream, i11);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$10(deviceConfig, dataInputStream, i11);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$3(deviceConfig, dataInputStream, i11);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$6(deviceConfig, dataInputStream, i11);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$9(deviceConfig, dataInputStream, i11);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$13(deviceConfig, dataInputStream, i11);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$16(deviceConfig, dataInputStream, i11);
                        break;
                }
            }
        });
        final int i11 = 4;
        register(2, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.b
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i12) {
                switch (i11) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$19(deviceConfig, dataInputStream, i12);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$21(deviceConfig, dataInputStream, i12);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$24(deviceConfig, dataInputStream, i12);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$27(deviceConfig, dataInputStream, i12);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$2(deviceConfig, dataInputStream, i12);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$5(deviceConfig, dataInputStream, i12);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$8(deviceConfig, dataInputStream, i12);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$12(deviceConfig, dataInputStream, i12);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$15(deviceConfig, dataInputStream, i12);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$18(deviceConfig, dataInputStream, i12);
                        break;
                }
            }
        });
        final int i12 = 4;
        register(3, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.c
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i13) {
                switch (i12) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$1(deviceConfig, dataInputStream, i13);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$22(deviceConfig, dataInputStream, i13);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$25(deviceConfig, dataInputStream, i13);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$10(deviceConfig, dataInputStream, i13);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$3(deviceConfig, dataInputStream, i13);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$6(deviceConfig, dataInputStream, i13);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$9(deviceConfig, dataInputStream, i13);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$13(deviceConfig, dataInputStream, i13);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$16(deviceConfig, dataInputStream, i13);
                        break;
                }
            }
        });
        final int i13 = 5;
        register(16, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.a
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i14) {
                switch (i13) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$0(deviceConfig, dataInputStream, i14);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$20(deviceConfig, dataInputStream, i14);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$23(deviceConfig, dataInputStream, i14);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$26(deviceConfig, dataInputStream, i14);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$28(deviceConfig, dataInputStream, i14);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$4(deviceConfig, dataInputStream, i14);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$7(deviceConfig, dataInputStream, i14);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$11(deviceConfig, dataInputStream, i14);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$14(deviceConfig, dataInputStream, i14);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$17(deviceConfig, dataInputStream, i14);
                        break;
                }
            }
        });
        final int i14 = 5;
        register(17, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.b
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i15) {
                switch (i14) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$19(deviceConfig, dataInputStream, i15);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$21(deviceConfig, dataInputStream, i15);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$24(deviceConfig, dataInputStream, i15);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$27(deviceConfig, dataInputStream, i15);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$2(deviceConfig, dataInputStream, i15);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$5(deviceConfig, dataInputStream, i15);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$8(deviceConfig, dataInputStream, i15);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$12(deviceConfig, dataInputStream, i15);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$15(deviceConfig, dataInputStream, i15);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$18(deviceConfig, dataInputStream, i15);
                        break;
                }
            }
        });
        final int i15 = 5;
        register(18, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.c
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i16) {
                switch (i15) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$1(deviceConfig, dataInputStream, i16);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$22(deviceConfig, dataInputStream, i16);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$25(deviceConfig, dataInputStream, i16);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$10(deviceConfig, dataInputStream, i16);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$3(deviceConfig, dataInputStream, i16);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$6(deviceConfig, dataInputStream, i16);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$9(deviceConfig, dataInputStream, i16);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$13(deviceConfig, dataInputStream, i16);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$16(deviceConfig, dataInputStream, i16);
                        break;
                }
            }
        });
        final int i16 = 6;
        register(19, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.a
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i17) {
                switch (i16) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$0(deviceConfig, dataInputStream, i17);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$20(deviceConfig, dataInputStream, i17);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$23(deviceConfig, dataInputStream, i17);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$26(deviceConfig, dataInputStream, i17);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$28(deviceConfig, dataInputStream, i17);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$4(deviceConfig, dataInputStream, i17);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$7(deviceConfig, dataInputStream, i17);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$11(deviceConfig, dataInputStream, i17);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$14(deviceConfig, dataInputStream, i17);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$17(deviceConfig, dataInputStream, i17);
                        break;
                }
            }
        });
        final int i17 = 6;
        register(20, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.b
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i18) {
                switch (i17) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$19(deviceConfig, dataInputStream, i18);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$21(deviceConfig, dataInputStream, i18);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$24(deviceConfig, dataInputStream, i18);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$27(deviceConfig, dataInputStream, i18);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$2(deviceConfig, dataInputStream, i18);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$5(deviceConfig, dataInputStream, i18);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$8(deviceConfig, dataInputStream, i18);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$12(deviceConfig, dataInputStream, i18);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$15(deviceConfig, dataInputStream, i18);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$18(deviceConfig, dataInputStream, i18);
                        break;
                }
            }
        });
        final int i18 = 6;
        register(32, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.c
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i19) {
                switch (i18) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$1(deviceConfig, dataInputStream, i19);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$22(deviceConfig, dataInputStream, i19);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$25(deviceConfig, dataInputStream, i19);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$10(deviceConfig, dataInputStream, i19);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$3(deviceConfig, dataInputStream, i19);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$6(deviceConfig, dataInputStream, i19);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$9(deviceConfig, dataInputStream, i19);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$13(deviceConfig, dataInputStream, i19);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$16(deviceConfig, dataInputStream, i19);
                        break;
                }
            }
        });
        final int i19 = 3;
        register(33, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.c
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i19) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$1(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$22(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$25(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$10(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$3(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$6(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$9(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$13(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$16(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i20 = 7;
        register(34, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.a
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i20) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$0(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$20(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$23(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$26(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$28(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$4(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$7(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$11(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$14(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$17(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i21 = 7;
        register(35, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.b
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i21) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$19(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$21(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$24(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$27(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$2(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$5(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$8(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$12(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$15(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$18(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i22 = 7;
        register(36, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.c
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i22) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$1(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$22(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$25(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$10(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$3(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$6(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$9(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$13(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$16(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i23 = 8;
        register(37, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.a
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i23) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$0(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$20(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$23(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$26(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$28(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$4(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$7(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$11(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$14(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$17(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i24 = 8;
        register(48, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.b
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i24) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$19(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$21(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$24(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$27(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$2(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$5(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$8(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$12(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$15(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$18(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i25 = 8;
        register(49, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.c
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i25) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$1(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$22(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$25(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$10(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$3(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$6(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$9(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$13(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$16(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i26 = 9;
        register(50, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.a
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i26) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$0(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$20(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$23(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$26(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$28(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$4(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$7(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$11(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$14(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$17(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i27 = 9;
        register(51, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.b
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i27) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$19(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$21(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$24(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$27(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$2(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$5(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$8(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$12(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$15(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$18(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i28 = 0;
        register(52, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.b
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i28) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$19(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$21(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$24(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$27(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$2(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$5(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$8(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$12(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$15(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$18(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i29 = 1;
        register(53, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.a
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i29) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$0(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$20(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$23(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$26(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$28(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$4(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$7(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$11(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$14(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$17(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i30 = 1;
        register(54, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.b
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i30) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$19(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$21(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$24(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$27(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$2(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$5(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$8(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$12(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$15(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$18(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i31 = 1;
        register(64, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.c
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i31) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$1(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$22(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$25(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$10(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$3(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$6(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$9(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$13(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$16(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i32 = 2;
        register(65, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.a
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i32) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$0(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$20(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$23(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$26(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$28(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$4(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$7(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$11(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$14(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$17(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i33 = 2;
        register(66, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.b
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i33) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$19(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$21(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$24(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$27(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$2(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$5(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$8(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$12(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$15(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$18(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i34 = 2;
        register(67, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.c
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i34) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$1(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$22(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$25(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$10(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$3(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$6(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$9(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$13(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$16(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i35 = 3;
        register(68, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.a
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i35) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$0(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$20(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$23(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$26(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$28(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$4(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$7(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$11(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$14(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$17(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i36 = 3;
        register(69, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.b
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i36) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$19(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$21(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$24(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$27(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$2(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$5(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$8(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$12(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$15(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$18(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
        final int i37 = 4;
        register(70, new FieldProcessor() { // from class: com.starburst.sdk.core.feed.deviceconfig.a
            @Override // com.starburst.sdk.core.feed.deviceconfig.FieldProcessorRegistry.FieldProcessor
            public final void process(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i110) {
                switch (i37) {
                    case 0:
                        FieldProcessorRegistry.lambda$static$0(deviceConfig, dataInputStream, i110);
                        break;
                    case 1:
                        FieldProcessorRegistry.lambda$static$20(deviceConfig, dataInputStream, i110);
                        break;
                    case 2:
                        FieldProcessorRegistry.lambda$static$23(deviceConfig, dataInputStream, i110);
                        break;
                    case 3:
                        FieldProcessorRegistry.lambda$static$26(deviceConfig, dataInputStream, i110);
                        break;
                    case 4:
                        FieldProcessorRegistry.lambda$static$28(deviceConfig, dataInputStream, i110);
                        break;
                    case 5:
                        FieldProcessorRegistry.lambda$static$4(deviceConfig, dataInputStream, i110);
                        break;
                    case 6:
                        FieldProcessorRegistry.lambda$static$7(deviceConfig, dataInputStream, i110);
                        break;
                    case 7:
                        FieldProcessorRegistry.lambda$static$11(deviceConfig, dataInputStream, i110);
                        break;
                    case 8:
                        FieldProcessorRegistry.lambda$static$14(deviceConfig, dataInputStream, i110);
                        break;
                    default:
                        FieldProcessorRegistry.lambda$static$17(deviceConfig, dataInputStream, i110);
                        break;
                }
            }
        });
    }

    public static FieldProcessor getProcessor(int i9) {
        return PROCESSORS.get(i9);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$0(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.text.encoding = DeviceConfig.TextEncoding.fromValue(readByte(dataInputStream));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$1(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.text.newsCount = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$10(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.audioPlay.sampleRate = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$11(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        int i10 = readByte(dataInputStream);
        DeviceConfig.PlayConfig playConfig = deviceConfig.audioPlay;
        if (i10 != 1 && i10 != 2) {
            i10 = 1;
        }
        playConfig.channels = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$12(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.audioPlay.pcmFrameSize = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$13(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.audioPlay.opusFrameSize = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$14(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        int unsignedShortLE = readUnsignedShortLE(dataInputStream);
        DeviceConfig.PlayConfig playConfig = deviceConfig.audioPlay;
        if (unsignedShortLE != 1 && unsignedShortLE != 0) {
            unsignedShortLE = 1;
        }
        playConfig.isSupportA2dp = unsignedShortLE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$15(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.wallpaper.encoding = DeviceConfig.ImageEncoding.fromValue(readByte(dataInputStream));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$16(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.wallpaper.needPreview = readByte(dataInputStream) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$17(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.wallpaper.maxStoreCount = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$18(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.wallpaper.originalWidth = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$19(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.wallpaper.originalHeight = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$2(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.text.jokesCount = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$20(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.wallpaper.previewWidth = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$21(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.wallpaper.previewHeight = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$22(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.aiImage.encoding = DeviceConfig.ImageEncoding.fromValue(readByte(dataInputStream));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$23(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.aiImage.needPreview = readByte(dataInputStream) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$24(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.aiImage.maxStoreCount = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$25(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.aiImage.originalWidth = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$26(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.aiImage.originalHeight = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$27(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.aiImage.previewWidth = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$28(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.aiImage.previewHeight = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$3(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.text.isTextSyncLowLatency = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$4(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.audioRecord.encoding = DeviceConfig.AudioEncoding.fromValue(readByte(dataInputStream));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$5(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.audioRecord.sampleRate = readUnsignedShortLE(dataInputStream);
        DeviceConfig.RecordConfig recordConfig = deviceConfig.audioRecord;
        if (recordConfig.sampleRate < 8000) {
            recordConfig.sampleRate = 16000;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$6(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        int i10 = readByte(dataInputStream);
        DeviceConfig.RecordConfig recordConfig = deviceConfig.audioRecord;
        if (i10 != 1 && i10 != 2) {
            i10 = 1;
        }
        recordConfig.channels = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$7(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.audioRecord.pcmFrameSize = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$8(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.audioRecord.opusFrameSize = readUnsignedShortLE(dataInputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$static$9(DeviceConfig deviceConfig, DataInputStream dataInputStream, int i9) {
        deviceConfig.audioPlay.encoding = DeviceConfig.AudioEncoding.fromValue(readByte(dataInputStream));
    }

    private static int readByte(DataInputStream dataInputStream) {
        return dataInputStream.readByte() & 255;
    }

    private static int readUnsignedShortLE(DataInputStream dataInputStream) {
        return ((dataInputStream.readByte() & 255) << 8) | (dataInputStream.readByte() & 255);
    }

    private static void register(int i9, FieldProcessor fieldProcessor) {
        PROCESSORS.put(i9, fieldProcessor);
    }
}

package com.alibaba.fastjson.asm;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okio.Utf8;

/* JADX INFO: loaded from: classes.dex */
public class ClassReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f11810b;
    public final int header;
    private final int[] items;
    private final int maxStringLength;
    private boolean readAnnotations;
    private final String[] strings;

    public ClassReader(InputStream inputStream, boolean z8) throws IOException {
        int i9;
        this.readAnnotations = z8;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i10 = inputStream.read(bArr);
            i9 = 0;
            if (i10 == -1) {
                break;
            } else if (i10 > 0) {
                byteArrayOutputStream.write(bArr, 0, i10);
            }
        }
        inputStream.close();
        this.f11810b = byteArrayOutputStream.toByteArray();
        int[] iArr = new int[readUnsignedShort(8)];
        this.items = iArr;
        int length = iArr.length;
        this.strings = new String[length];
        int i11 = 10;
        int i12 = 1;
        while (i12 < length) {
            int i13 = i11 + 1;
            this.items[i12] = i13;
            byte b9 = this.f11810b[i11];
            int unsignedShort = 3;
            if (b9 == 1) {
                unsignedShort = 3 + readUnsignedShort(i13);
                if (unsignedShort > i9) {
                    i9 = unsignedShort;
                }
            } else if (b9 != 15) {
                unsignedShort = 5;
                if (b9 != 18 && b9 != 3 && b9 != 4) {
                    if (b9 != 5 && b9 != 6) {
                        switch (b9) {
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                                break;
                            default:
                                continue;
                        }
                    } else {
                        i12++;
                        unsignedShort = 9;
                    }
                }
            } else {
                unsignedShort = 4;
            }
            i11 += unsignedShort;
            i12++;
        }
        this.maxStringLength = i9;
        this.header = i11;
    }

    private int getAttributes() {
        int i9 = this.header;
        int unsignedShort = (readUnsignedShort(i9 + 6) * 2) + i9 + 8;
        for (int unsignedShort2 = readUnsignedShort(unsignedShort); unsignedShort2 > 0; unsignedShort2--) {
            for (int unsignedShort3 = readUnsignedShort(unsignedShort + 8); unsignedShort3 > 0; unsignedShort3--) {
                unsignedShort += readInt(unsignedShort + 12) + 6;
            }
            unsignedShort += 8;
        }
        int i10 = unsignedShort + 2;
        for (int unsignedShort4 = readUnsignedShort(i10); unsignedShort4 > 0; unsignedShort4--) {
            for (int unsignedShort5 = readUnsignedShort(i10 + 8); unsignedShort5 > 0; unsignedShort5--) {
                i10 += readInt(i10 + 12) + 6;
            }
            i10 += 8;
        }
        return i10 + 2;
    }

    private int readInt(int i9) {
        byte[] bArr = this.f11810b;
        return (bArr[i9 + 3] & 255) | ((bArr[i9] & 255) << 24) | ((bArr[i9 + 1] & 255) << 16) | ((bArr[i9 + 2] & 255) << 8);
    }

    private int readMethod(TypeCollector typeCollector, char[] cArr, int i9) {
        int unsignedShort = readUnsignedShort(i9);
        String utf8 = readUTF8(i9 + 2, cArr);
        String utf9 = readUTF8(i9 + 4, cArr);
        int i10 = i9 + 8;
        int i11 = 0;
        int i12 = 0;
        for (int unsignedShort2 = readUnsignedShort(i9 + 6); unsignedShort2 > 0; unsignedShort2--) {
            String utf10 = readUTF8(i10, cArr);
            int i13 = readInt(i10 + 2);
            int i14 = i10 + 6;
            if (utf10.equals("Code")) {
                i12 = i14;
            }
            i10 = i14 + i13;
        }
        MethodCollector methodCollectorVisitMethod = typeCollector.visitMethod(unsignedShort, utf8, utf9);
        if (methodCollectorVisitMethod != null && i12 != 0) {
            int i15 = i12 + 8 + readInt(i12 + 4);
            int i16 = i15 + 2;
            for (int unsignedShort3 = readUnsignedShort(i15); unsignedShort3 > 0; unsignedShort3--) {
                i16 += 8;
            }
            int i17 = i16 + 2;
            int i18 = 0;
            for (int unsignedShort4 = readUnsignedShort(i16); unsignedShort4 > 0; unsignedShort4--) {
                String utf11 = readUTF8(i17, cArr);
                if (utf11.equals("LocalVariableTable")) {
                    i11 = i17 + 6;
                } else if (utf11.equals("LocalVariableTypeTable")) {
                    i18 = i17 + 6;
                }
                i17 += readInt(i17 + 2) + 6;
            }
            if (i11 != 0) {
                if (i18 != 0) {
                    int unsignedShort5 = readUnsignedShort(i18) * 3;
                    int i19 = i18 + 2;
                    int[] iArr = new int[unsignedShort5];
                    while (unsignedShort5 > 0) {
                        iArr[unsignedShort5 - 1] = i19 + 6;
                        iArr[unsignedShort5 - 2] = readUnsignedShort(i19 + 8);
                        unsignedShort5 -= 3;
                        iArr[unsignedShort5] = readUnsignedShort(i19);
                        i19 += 10;
                    }
                }
                int i20 = i11 + 2;
                for (int unsignedShort6 = readUnsignedShort(i11); unsignedShort6 > 0; unsignedShort6--) {
                    methodCollectorVisitMethod.visitLocalVariable(readUTF8(i20 + 4, cArr), readUnsignedShort(i20 + 8));
                    i20 += 10;
                }
            }
        }
        return i10;
    }

    private String readUTF(int i9, int i10, char[] cArr) {
        int i11;
        int i12 = i10 + i9;
        byte[] bArr = this.f11810b;
        int i13 = 0;
        char c5 = 0;
        char c9 = 0;
        while (i9 < i12) {
            int i14 = i9 + 1;
            byte b9 = bArr[i9];
            if (c5 == 0) {
                int i15 = b9 & 255;
                if (i15 < 128) {
                    cArr[i13] = (char) i15;
                    i13++;
                } else if (i15 >= 224 || i15 <= 191) {
                    c9 = (char) (b9 & 15);
                    c5 = 2;
                } else {
                    i11 = b9 & 31;
                    c9 = (char) i11;
                    c5 = 1;
                }
            } else if (c5 == 1) {
                cArr[i13] = (char) ((b9 & Utf8.REPLACEMENT_BYTE) | (c9 << 6));
                i13++;
                c5 = 0;
            } else if (c5 == 2) {
                i11 = (b9 & Utf8.REPLACEMENT_BYTE) | (c9 << 6);
                c9 = (char) i11;
                c5 = 1;
            }
            i9 = i14;
        }
        return new String(cArr, 0, i13);
    }

    private String readUTF8(int i9, char[] cArr) {
        int unsignedShort = readUnsignedShort(i9);
        String[] strArr = this.strings;
        String str = strArr[unsignedShort];
        if (str != null) {
            return str;
        }
        int i10 = this.items[unsignedShort];
        String utf = readUTF(i10 + 2, readUnsignedShort(i10), cArr);
        strArr[unsignedShort] = utf;
        return utf;
    }

    private int readUnsignedShort(int i9) {
        byte[] bArr = this.f11810b;
        return (bArr[i9 + 1] & 255) | ((bArr[i9] & 255) << 8);
    }

    public void accept(TypeCollector typeCollector) {
        int i9;
        char[] cArr = new char[this.maxStringLength];
        if (!this.readAnnotations) {
            i9 = 0;
            break;
        }
        int attributes = getAttributes();
        int unsignedShort = readUnsignedShort(attributes);
        while (true) {
            if (unsignedShort <= 0) {
                i9 = 0;
                break;
            } else if ("RuntimeVisibleAnnotations".equals(readUTF8(attributes + 2, cArr))) {
                i9 = attributes + 8;
                break;
            } else {
                attributes += readInt(attributes + 4) + 6;
                unsignedShort--;
            }
        }
        int i10 = this.header;
        int unsignedShort2 = readUnsignedShort(i10 + 6);
        int i11 = i10 + 8;
        for (int i12 = 0; i12 < unsignedShort2; i12++) {
            i11 += 2;
        }
        int i13 = i11 + 2;
        int i14 = i13;
        for (int unsignedShort3 = readUnsignedShort(i11); unsignedShort3 > 0; unsignedShort3--) {
            i14 += 8;
            for (int unsignedShort4 = readUnsignedShort(i14 + 6); unsignedShort4 > 0; unsignedShort4--) {
                i14 += readInt(i14 + 2) + 6;
            }
        }
        int i15 = i14 + 2;
        for (int unsignedShort5 = readUnsignedShort(i14); unsignedShort5 > 0; unsignedShort5--) {
            i15 += 8;
            for (int unsignedShort6 = readUnsignedShort(i15 + 6); unsignedShort6 > 0; unsignedShort6--) {
                i15 += readInt(i15 + 2) + 6;
            }
        }
        int i16 = i15 + 2;
        for (int unsignedShort7 = readUnsignedShort(i15); unsignedShort7 > 0; unsignedShort7--) {
            i16 += readInt(i16 + 2) + 6;
        }
        if (i9 != 0) {
            int i17 = i9 + 2;
            for (int unsignedShort8 = readUnsignedShort(i9); unsignedShort8 > 0; unsignedShort8--) {
                typeCollector.visitAnnotation(readUTF8(i17, cArr));
            }
        }
        for (int unsignedShort9 = readUnsignedShort(i11); unsignedShort9 > 0; unsignedShort9--) {
            i13 += 8;
            for (int unsignedShort10 = readUnsignedShort(i13 + 6); unsignedShort10 > 0; unsignedShort10--) {
                i13 += readInt(i13 + 2) + 6;
            }
        }
        int method = i13 + 2;
        for (int unsignedShort11 = readUnsignedShort(i13); unsignedShort11 > 0; unsignedShort11--) {
            method = readMethod(typeCollector, cArr, method);
        }
    }
}

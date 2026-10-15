package okio;

import R7.a;
import R7.i;
import W5.e;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;

/* JADX INFO: compiled from: ByteString.kt */
/* JADX INFO: loaded from: classes2.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final Companion Companion = new Companion(null);
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    private final byte[] data;
    private transient int hashCode;
    private transient String utf8;

    /* JADX INFO: compiled from: ByteString.kt */
    public static final class Companion {
        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ ByteString encodeString$default(Companion companion, String str, Charset charset, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                charset = a.f4067b;
            }
            return companion.encodeString(str, charset);
        }

        public static /* synthetic */ ByteString of$default(Companion companion, byte[] bArr, int i9, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                i9 = 0;
            }
            if ((i11 & 2) != 0) {
                i10 = SegmentedByteString.getDEFAULT__ByteString_size();
            }
            return companion.of(bArr, i9, i10);
        }

        /* JADX INFO: renamed from: -deprecated_decodeBase64, reason: not valid java name */
        public final ByteString m989deprecated_decodeBase64(String string) {
            k.e(string, "string");
            return decodeBase64(string);
        }

        /* JADX INFO: renamed from: -deprecated_decodeHex, reason: not valid java name */
        public final ByteString m990deprecated_decodeHex(String string) {
            k.e(string, "string");
            return decodeHex(string);
        }

        /* JADX INFO: renamed from: -deprecated_encodeString, reason: not valid java name */
        public final ByteString m991deprecated_encodeString(String string, Charset charset) {
            k.e(string, "string");
            k.e(charset, "charset");
            return encodeString(string, charset);
        }

        /* JADX INFO: renamed from: -deprecated_encodeUtf8, reason: not valid java name */
        public final ByteString m992deprecated_encodeUtf8(String string) {
            k.e(string, "string");
            return encodeUtf8(string);
        }

        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m993deprecated_of(ByteBuffer buffer) {
            k.e(buffer, "buffer");
            return of(buffer);
        }

        /* JADX INFO: renamed from: -deprecated_read, reason: not valid java name */
        public final ByteString m995deprecated_read(InputStream inputstream, int i9) {
            k.e(inputstream, "inputstream");
            return read(inputstream, i9);
        }

        public final ByteString decodeBase64(String str) {
            k.e(str, "<this>");
            byte[] bArrDecodeBase64ToArray = Base64.decodeBase64ToArray(str);
            if (bArrDecodeBase64ToArray != null) {
                return new ByteString(bArrDecodeBase64ToArray);
            }
            return null;
        }

        public final ByteString decodeHex(String str) {
            k.e(str, "<this>");
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i9 = 0; i9 < length; i9++) {
                int i10 = i9 * 2;
                bArr[i9] = (byte) (okio.internal.ByteString.decodeHexDigit(str.charAt(i10 + 1)) + (okio.internal.ByteString.decodeHexDigit(str.charAt(i10)) << 4));
            }
            return new ByteString(bArr);
        }

        public final ByteString encodeString(String str, Charset charset) {
            k.e(str, "<this>");
            k.e(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            k.d(bytes, "this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        public final ByteString encodeUtf8(String str) {
            k.e(str, "<this>");
            ByteString byteString = new ByteString(_JvmPlatformKt.asUtf8ToByteArray(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        public final ByteString of(ByteBuffer byteBuffer) {
            k.e(byteBuffer, "<this>");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        public final ByteString read(InputStream inputStream, int i9) throws IOException {
            k.e(inputStream, "<this>");
            if (i9 < 0) {
                throw new IllegalArgumentException(e.i(i9, "byteCount < 0: ").toString());
            }
            byte[] bArr = new byte[i9];
            int i10 = 0;
            while (i10 < i9) {
                int i11 = inputStream.read(bArr, i10, i9 - i10);
                if (i11 == -1) {
                    throw new EOFException();
                }
                i10 += i11;
            }
            return new ByteString(bArr);
        }

        private Companion() {
        }

        /* JADX INFO: renamed from: -deprecated_of, reason: not valid java name */
        public final ByteString m994deprecated_of(byte[] array, int i9, int i10) {
            k.e(array, "array");
            return of(array, i9, i10);
        }

        public final ByteString of(byte... data) {
            k.e(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            k.d(bArrCopyOf, "copyOf(this, size)");
            return new ByteString(bArrCopyOf);
        }

        public final ByteString of(byte[] bArr, int i9, int i10) {
            k.e(bArr, "<this>");
            int iResolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(bArr, i10);
            SegmentedByteString.checkOffsetAndCount(bArr.length, i9, iResolveDefaultParameter);
            return new ByteString(y7.f.f(i9, iResolveDefaultParameter + i9, bArr));
        }
    }

    public ByteString(byte[] data) {
        k.e(data, "data");
        this.data = data;
    }

    public static /* synthetic */ void copyInto$default(ByteString byteString, int i9, byte[] bArr, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
        }
        if ((i12 & 1) != 0) {
            i9 = 0;
        }
        if ((i12 & 4) != 0) {
            i10 = 0;
        }
        byteString.copyInto(i9, bArr, i10, i11);
    }

    public static final ByteString decodeBase64(String str) {
        return Companion.decodeBase64(str);
    }

    public static final ByteString decodeHex(String str) {
        return Companion.decodeHex(str);
    }

    public static final ByteString encodeString(String str, Charset charset) {
        return Companion.encodeString(str, charset);
    }

    public static final ByteString encodeUtf8(String str) {
        return Companion.encodeUtf8(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i9, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i10 & 2) != 0) {
            i9 = 0;
        }
        return byteString.indexOf(byteString2, i9);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i9, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i10 & 2) != 0) {
            i9 = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(byteString2, i9);
    }

    public static final ByteString of(ByteBuffer byteBuffer) {
        return Companion.of(byteBuffer);
    }

    public static final ByteString read(InputStream inputStream, int i9) {
        return Companion.read(inputStream, i9);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException {
        ByteString byteString = Companion.read(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, byteString.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i9, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i11 & 1) != 0) {
            i9 = 0;
        }
        if ((i11 & 2) != 0) {
            i10 = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.substring(i9, i10);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    /* JADX INFO: renamed from: -deprecated_getByte, reason: not valid java name */
    public final byte m987deprecated_getByte(int i9) {
        return getByte(i9);
    }

    /* JADX INFO: renamed from: -deprecated_size, reason: not valid java name */
    public final int m988deprecated_size() {
        return size();
    }

    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        k.d(byteBufferAsReadOnlyBuffer, "wrap(data).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    public String base64() {
        return Base64.encodeBase64$default(getData$okio(), null, 1, null);
    }

    public String base64Url() {
        return Base64.encodeBase64(getData$okio(), Base64.getBASE64_URL_SAFE());
    }

    public void copyInto(int i9, byte[] target, int i10, int i11) {
        k.e(target, "target");
        y7.f.c(getData$okio(), i10, target, i9, i11 + i9);
    }

    public ByteString digest$okio(String algorithm) throws NoSuchAlgorithmException {
        k.e(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(this.data, 0, size());
        byte[] digestBytes = messageDigest.digest();
        k.d(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    public final boolean endsWith(ByteString suffix) {
        k.e(suffix, "suffix");
        return rangeEquals(size() - suffix.size(), suffix, 0, suffix.size());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    public final byte getByte(int i9) {
        return internalGet$okio(i9);
    }

    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int iHashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(iHashCode);
        return iHashCode;
    }

    public String hex() {
        char[] cArr = new char[getData$okio().length * 2];
        int i9 = 0;
        for (byte b9 : getData$okio()) {
            int i10 = i9 + 1;
            cArr[i9] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[(b9 >> 4) & 15];
            i9 += 2;
            cArr[i10] = okio.internal.ByteString.getHEX_DIGIT_CHARS()[b9 & 15];
        }
        return new String(cArr);
    }

    public ByteString hmac$okio(String algorithm, ByteString key) throws NoSuchAlgorithmException {
        k.e(algorithm, "algorithm");
        k.e(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            byte[] bArrDoFinal = mac.doFinal(this.data);
            k.d(bArrDoFinal, "mac.doFinal(data)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e9) {
            throw new IllegalArgumentException(e9);
        }
    }

    public ByteString hmacSha1(ByteString key) {
        k.e(key, "key");
        return hmac$okio("HmacSHA1", key);
    }

    public ByteString hmacSha256(ByteString key) {
        k.e(key, "key");
        return hmac$okio("HmacSHA256", key);
    }

    public ByteString hmacSha512(ByteString key) {
        k.e(key, "key");
        return hmac$okio("HmacSHA512", key);
    }

    public final int indexOf(ByteString other) {
        k.e(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i9) {
        return getData$okio()[i9];
    }

    public final int lastIndexOf(ByteString other) {
        k.e(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    public final ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i9, ByteString other, int i10, int i11) {
        k.e(other, "other");
        return other.rangeEquals(i10, getData$okio(), i9, i11);
    }

    public final void setHashCode$okio(int i9) {
        this.hashCode = i9;
    }

    public final void setUtf8$okio(String str) {
        this.utf8 = str;
    }

    public final ByteString sha1() {
        return digest$okio("SHA-1");
    }

    public final ByteString sha256() {
        return digest$okio("SHA-256");
    }

    public final ByteString sha512() {
        return digest$okio("SHA-512");
    }

    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(ByteString prefix) {
        k.e(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.size());
    }

    public String string(Charset charset) {
        k.e(charset, "charset");
        return new String(this.data, charset);
    }

    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    public ByteString toAsciiLowercase() {
        for (int i9 = 0; i9 < getData$okio().length; i9++) {
            byte b9 = getData$okio()[i9];
            if (b9 >= 65 && b9 <= 90) {
                byte[] data$okio = getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                k.d(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i9] = (byte) (b9 + 32);
                for (int i10 = i9 + 1; i10 < bArrCopyOf.length; i10++) {
                    byte b10 = bArrCopyOf[i10];
                    if (b10 >= 65 && b10 <= 90) {
                        bArrCopyOf[i10] = (byte) (b10 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    public ByteString toAsciiUppercase() {
        for (int i9 = 0; i9 < getData$okio().length; i9++) {
            byte b9 = getData$okio()[i9];
            if (b9 >= 97 && b9 <= 122) {
                byte[] data$okio = getData$okio();
                byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
                k.d(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i9] = (byte) (b9 - 32);
                for (int i10 = i9 + 1; i10 < bArrCopyOf.length; i10++) {
                    byte b10 = bArrCopyOf[i10];
                    if (b10 >= 97 && b10 <= 122) {
                        bArrCopyOf[i10] = (byte) (b10 - 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        byte[] bArrCopyOf = Arrays.copyOf(data$okio, data$okio.length);
        k.d(bArrCopyOf, "copyOf(this, size)");
        return bArrCopyOf;
    }

    public String toString() {
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        int iCodePointIndexToCharIndex = okio.internal.ByteString.codePointIndexToCharIndex(getData$okio(), 64);
        if (iCodePointIndexToCharIndex != -1) {
            String strUtf8 = utf8();
            String strSubstring = strUtf8.substring(0, iCodePointIndexToCharIndex);
            k.d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strL = i.L(i.L(i.L(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (iCodePointIndexToCharIndex >= strUtf8.length()) {
                return "[text=" + strL + ']';
            }
            return "[size=" + getData$okio().length + " text=" + strL + "…]";
        }
        if (getData$okio().length <= 64) {
            return "[hex=" + hex() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(getData$okio().length);
        sb.append(" hex=");
        int iResolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, 64);
        if (iResolveDefaultParameter > getData$okio().length) {
            throw new IllegalArgumentException(H2.a.a(new StringBuilder("endIndex > length("), getData$okio().length, ')').toString());
        }
        if (iResolveDefaultParameter < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        sb.append((iResolveDefaultParameter == getData$okio().length ? this : new ByteString(y7.f.f(0, iResolveDefaultParameter, getData$okio()))).hex());
        sb.append("…]");
        return sb.toString();
    }

    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio != null) {
            return utf8$okio;
        }
        String utf8String = _JvmPlatformKt.toUtf8String(internalArray$okio());
        setUtf8$okio(utf8String);
        return utf8String;
    }

    public void write(OutputStream out) throws IOException {
        k.e(out, "out");
        out.write(this.data);
    }

    public void write$okio(Buffer buffer, int i9, int i10) {
        k.e(buffer, "buffer");
        okio.internal.ByteString.commonWrite(this, buffer, i9, i10);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i9, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i10 & 2) != 0) {
            i9 = 0;
        }
        return byteString.indexOf(bArr, i9);
    }

    public static final ByteString of(byte... bArr) {
        return Companion.of(bArr);
    }

    @Override // java.lang.Comparable
    public int compareTo(ByteString other) {
        k.e(other, "other");
        int size = size();
        int size2 = other.size();
        int iMin = Math.min(size, size2);
        for (int i9 = 0; i9 < iMin; i9++) {
            int i10 = getByte(i9) & 255;
            int i11 = other.getByte(i9) & 255;
            if (i10 != i11) {
                return i10 < i11 ? -1 : 1;
            }
        }
        if (size == size2) {
            return 0;
        }
        return size < size2 ? -1 : 1;
    }

    public final boolean endsWith(byte[] suffix) {
        k.e(suffix, "suffix");
        return rangeEquals(size() - suffix.length, suffix, 0, suffix.length);
    }

    public final int indexOf(byte[] other) {
        k.e(other, "other");
        return indexOf$default(this, other, 0, 2, (Object) null);
    }

    public final int lastIndexOf(byte[] other) {
        k.e(other, "other");
        return lastIndexOf$default(this, other, 0, 2, (Object) null);
    }

    public boolean rangeEquals(int i9, byte[] other, int i10, int i11) {
        k.e(other, "other");
        return i9 >= 0 && i9 <= getData$okio().length - i11 && i10 >= 0 && i10 <= other.length - i11 && SegmentedByteString.arrayRangeEquals(getData$okio(), i9, other, i10, i11);
    }

    public final boolean startsWith(byte[] prefix) {
        k.e(prefix, "prefix");
        return rangeEquals(0, prefix, 0, prefix.length);
    }

    public final ByteString substring(int i9) {
        return substring$default(this, i9, 0, 2, null);
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i9, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i10 & 2) != 0) {
            i9 = SegmentedByteString.getDEFAULT__ByteString_size();
        }
        return byteString.lastIndexOf(bArr, i9);
    }

    public static final ByteString of(byte[] bArr, int i9, int i10) {
        return Companion.of(bArr, i9, i10);
    }

    public final int indexOf(ByteString other, int i9) {
        k.e(other, "other");
        return indexOf(other.internalArray$okio(), i9);
    }

    public final int lastIndexOf(ByteString other, int i9) {
        k.e(other, "other");
        return lastIndexOf(other.internalArray$okio(), i9);
    }

    public ByteString substring(int i9, int i10) {
        int iResolveDefaultParameter = SegmentedByteString.resolveDefaultParameter(this, i10);
        if (i9 >= 0) {
            if (iResolveDefaultParameter > getData$okio().length) {
                throw new IllegalArgumentException(H2.a.a(new StringBuilder("endIndex > length("), getData$okio().length, ')').toString());
            }
            if (iResolveDefaultParameter - i9 >= 0) {
                return (i9 == 0 && iResolveDefaultParameter == getData$okio().length) ? this : new ByteString(y7.f.f(i9, iResolveDefaultParameter, getData$okio()));
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public int indexOf(byte[] other, int i9) {
        k.e(other, "other");
        int length = getData$okio().length - other.length;
        int iMax = Math.max(i9, 0);
        if (iMax > length) {
            return -1;
        }
        while (!SegmentedByteString.arrayRangeEquals(getData$okio(), iMax, other, 0, other.length)) {
            if (iMax == length) {
                return -1;
            }
            iMax++;
        }
        return iMax;
    }

    public int lastIndexOf(byte[] other, int i9) {
        k.e(other, "other");
        for (int iMin = Math.min(SegmentedByteString.resolveDefaultParameter(this, i9), getData$okio().length - other.length); -1 < iMin; iMin--) {
            if (SegmentedByteString.arrayRangeEquals(getData$okio(), iMin, other, 0, other.length)) {
                return iMin;
            }
        }
        return -1;
    }
}

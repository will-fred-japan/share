package p096m7;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: StandardMessageCodec.java */
/* JADX INFO: loaded from: classes2.dex */
public class r implements i<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f20508a = new r();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f20509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f20510c;

    /* JADX INFO: compiled from: StandardMessageCodec.java */
    public static final class a extends ByteArrayOutputStream {
        public final byte[] a() {
            return ((ByteArrayOutputStream) this).buf;
        }
    }

    static {
        f20509b = ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN;
        f20510c = Charset.forName("UTF8");
    }

    public static void c(ByteBuffer byteBuffer, int i9) {
        int iPosition = byteBuffer.position() % i9;
        if (iPosition != 0) {
            byteBuffer.position((byteBuffer.position() + i9) - iPosition);
        }
    }

    public static int d(ByteBuffer byteBuffer) {
        if (!byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        int i9 = byteBuffer.get() & 255;
        if (i9 < 254) {
            return i9;
        }
        return i9 == 254 ? byteBuffer.getChar() : byteBuffer.getInt();
    }

    public static void g(a aVar, int i9) {
        int size = aVar.size() % i9;
        if (size != 0) {
            for (int i10 = 0; i10 < i9 - size; i10++) {
                aVar.write(0);
            }
        }
    }

    public static void h(a aVar, int i9) {
        if (f20509b) {
            aVar.write(i9);
            aVar.write(i9 >>> 8);
            aVar.write(i9 >>> 16);
            aVar.write(i9 >>> 24);
            return;
        }
        aVar.write(i9 >>> 24);
        aVar.write(i9 >>> 16);
        aVar.write(i9 >>> 8);
        aVar.write(i9);
    }

    public static void i(a aVar, long j) {
        if (f20509b) {
            aVar.write((byte) j);
            aVar.write((byte) (j >>> 8));
            aVar.write((byte) (j >>> 16));
            aVar.write((byte) (j >>> 24));
            aVar.write((byte) (j >>> 32));
            aVar.write((byte) (j >>> 40));
            aVar.write((byte) (j >>> 48));
            aVar.write((byte) (j >>> 56));
            return;
        }
        aVar.write((byte) (j >>> 56));
        aVar.write((byte) (j >>> 48));
        aVar.write((byte) (j >>> 40));
        aVar.write((byte) (j >>> 32));
        aVar.write((byte) (j >>> 24));
        aVar.write((byte) (j >>> 16));
        aVar.write((byte) (j >>> 8));
        aVar.write((byte) j);
    }

    public static void j(a aVar, int i9) {
        if (i9 < 254) {
            aVar.write(i9);
            return;
        }
        if (i9 > 65535) {
            aVar.write(255);
            h(aVar, i9);
            return;
        }
        aVar.write(254);
        if (f20509b) {
            aVar.write(i9);
            aVar.write(i9 >>> 8);
        } else {
            aVar.write(i9 >>> 8);
            aVar.write(i9);
        }
    }

    @Override // p096m7.i
    public final ByteBuffer a(Object obj) {
        if (obj == null) {
            return null;
        }
        a aVar = new a();
        k(aVar, obj);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(aVar.size());
        byteBufferAllocateDirect.put(aVar.a(), 0, aVar.size());
        return byteBufferAllocateDirect;
    }

    @Override // p096m7.i
    public final Object b(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        byteBuffer.order(ByteOrder.nativeOrder());
        Object objE = e(byteBuffer);
        if (byteBuffer.hasRemaining()) {
            throw new IllegalArgumentException("Message corrupted");
        }
        return objE;
    }

    public final Object e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            return f(byteBuffer.get(), byteBuffer);
        }
        throw new IllegalArgumentException("Message corrupted");
    }

    public Object f(byte b9, ByteBuffer byteBuffer) {
        Charset charset = f20510c;
        int i9 = 0;
        switch (b9) {
            case 0:
                return null;
            case 1:
                return Boolean.TRUE;
            case 2:
                return Boolean.FALSE;
            case 3:
                return Integer.valueOf(byteBuffer.getInt());
            case 4:
                return Long.valueOf(byteBuffer.getLong());
            case 5:
                byte[] bArr = new byte[d(byteBuffer)];
                byteBuffer.get(bArr);
                return new BigInteger(new String(bArr, charset), 16);
            case 6:
                c(byteBuffer, 8);
                return Double.valueOf(byteBuffer.getDouble());
            case 7:
                byte[] bArr2 = new byte[d(byteBuffer)];
                byteBuffer.get(bArr2);
                return new String(bArr2, charset);
            case 8:
                byte[] bArr3 = new byte[d(byteBuffer)];
                byteBuffer.get(bArr3);
                return bArr3;
            case 9:
                int iD = d(byteBuffer);
                int[] iArr = new int[iD];
                c(byteBuffer, 4);
                byteBuffer.asIntBuffer().get(iArr);
                byteBuffer.position((iD * 4) + byteBuffer.position());
                return iArr;
            case 10:
                int iD2 = d(byteBuffer);
                long[] jArr = new long[iD2];
                c(byteBuffer, 8);
                byteBuffer.asLongBuffer().get(jArr);
                byteBuffer.position((iD2 * 8) + byteBuffer.position());
                return jArr;
            case 11:
                int iD3 = d(byteBuffer);
                double[] dArr = new double[iD3];
                c(byteBuffer, 8);
                byteBuffer.asDoubleBuffer().get(dArr);
                byteBuffer.position((iD3 * 8) + byteBuffer.position());
                return dArr;
            case 12:
                int iD4 = d(byteBuffer);
                ArrayList arrayList = new ArrayList(iD4);
                while (i9 < iD4) {
                    arrayList.add(e(byteBuffer));
                    i9++;
                }
                return arrayList;
            case 13:
                int iD5 = d(byteBuffer);
                HashMap map = new HashMap();
                while (i9 < iD5) {
                    map.put(e(byteBuffer), e(byteBuffer));
                    i9++;
                }
                return map;
            case 14:
                int iD6 = d(byteBuffer);
                float[] fArr = new float[iD6];
                c(byteBuffer, 4);
                byteBuffer.asFloatBuffer().get(fArr);
                byteBuffer.position((iD6 * 4) + byteBuffer.position());
                return fArr;
            default:
                throw new IllegalArgumentException("Message corrupted");
        }
    }

    public void k(a aVar, Object obj) {
        int i9 = 0;
        if (obj == null || obj.equals(null)) {
            aVar.write(0);
            return;
        }
        if (obj instanceof Boolean) {
            aVar.write(((Boolean) obj).booleanValue() ? 1 : 2);
            return;
        }
        boolean z8 = obj instanceof Number;
        Charset charset = f20510c;
        if (z8) {
            if ((obj instanceof Integer) || (obj instanceof Short) || (obj instanceof Byte)) {
                aVar.write(3);
                h(aVar, ((Number) obj).intValue());
                return;
            }
            if (obj instanceof Long) {
                aVar.write(4);
                i(aVar, ((Long) obj).longValue());
                return;
            }
            if ((obj instanceof Float) || (obj instanceof Double)) {
                aVar.write(6);
                g(aVar, 8);
                i(aVar, Double.doubleToLongBits(((Number) obj).doubleValue()));
                return;
            } else {
                if (!(obj instanceof BigInteger)) {
                    throw new IllegalArgumentException("Unsupported Number type: " + obj.getClass());
                }
                aVar.write(5);
                byte[] bytes = ((BigInteger) obj).toString(16).getBytes(charset);
                j(aVar, bytes.length);
                aVar.write(bytes, 0, bytes.length);
                return;
            }
        }
        if (obj instanceof CharSequence) {
            aVar.write(7);
            byte[] bytes2 = obj.toString().getBytes(charset);
            j(aVar, bytes2.length);
            aVar.write(bytes2, 0, bytes2.length);
            return;
        }
        if (obj instanceof byte[]) {
            aVar.write(8);
            byte[] bArr = (byte[]) obj;
            j(aVar, bArr.length);
            aVar.write(bArr, 0, bArr.length);
            return;
        }
        if (obj instanceof int[]) {
            aVar.write(9);
            int[] iArr = (int[]) obj;
            j(aVar, iArr.length);
            g(aVar, 4);
            int length = iArr.length;
            while (i9 < length) {
                h(aVar, iArr[i9]);
                i9++;
            }
            return;
        }
        if (obj instanceof long[]) {
            aVar.write(10);
            long[] jArr = (long[]) obj;
            j(aVar, jArr.length);
            g(aVar, 8);
            int length2 = jArr.length;
            while (i9 < length2) {
                i(aVar, jArr[i9]);
                i9++;
            }
            return;
        }
        if (obj instanceof double[]) {
            aVar.write(11);
            double[] dArr = (double[]) obj;
            j(aVar, dArr.length);
            g(aVar, 8);
            int length3 = dArr.length;
            while (i9 < length3) {
                i(aVar, Double.doubleToLongBits(dArr[i9]));
                i9++;
            }
            return;
        }
        if (obj instanceof List) {
            aVar.write(12);
            List list = (List) obj;
            j(aVar, list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                k(aVar, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            aVar.write(13);
            Map map = (Map) obj;
            j(aVar, map.size());
            for (Map.Entry entry : map.entrySet()) {
                k(aVar, entry.getKey());
                k(aVar, entry.getValue());
            }
            return;
        }
        if (!(obj instanceof float[])) {
            throw new IllegalArgumentException("Unsupported value: '" + obj + "' of type '" + obj.getClass() + "'");
        }
        aVar.write(14);
        float[] fArr = (float[]) obj;
        j(aVar, fArr.length);
        g(aVar, 4);
        int length4 = fArr.length;
        while (i9 < length4) {
            h(aVar, Float.floatToIntBits(fArr[i9]));
            i9++;
        }
    }
}

package cn.jiguang.ad;

import java.io.EOFException;
import java.io.IOException;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

/* JADX INFO: loaded from: classes.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected long f9010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected SelectionKey f9011b;

    public o(long j) throws IOException {
        this.f9010a = j;
        SocketChannel socketChannelOpen = SocketChannel.open();
        try {
            Selector selectorOpen = Selector.open();
            try {
                socketChannelOpen.configureBlocking(false);
                this.f9011b = socketChannelOpen.register(selectorOpen, 1);
                if (selectorOpen != null) {
                    selectorOpen.close();
                }
                socketChannelOpen.close();
            } catch (Throwable th) {
                if (selectorOpen != null) {
                    try {
                        selectorOpen.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (socketChannelOpen != null) {
                try {
                    socketChannelOpen.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    public void a(SocketAddress socketAddress) throws IOException {
        ((SocketChannel) this.f9011b.channel()).socket().bind(socketAddress);
    }

    public void b() throws IOException {
        this.f9011b.selector().close();
        this.f9011b.channel().close();
    }

    public static void a(SelectionKey selectionKey, long j) throws IOException {
        int iSelectNow;
        long jCurrentTimeMillis = j - System.currentTimeMillis();
        if (jCurrentTimeMillis > 0) {
            iSelectNow = selectionKey.selector().select(jCurrentTimeMillis);
        } else {
            iSelectNow = jCurrentTimeMillis == 0 ? selectionKey.selector().selectNow() : 0;
        }
        if (iSelectNow == 0) {
            throw new SocketTimeoutException();
        }
    }

    public void b(SocketAddress socketAddress) {
        SocketChannel socketChannel = (SocketChannel) this.f9011b.channel();
        if (socketChannel.connect(socketAddress)) {
            return;
        }
        this.f9011b.interestOps(8);
        while (true) {
            try {
                if (socketChannel.finishConnect()) {
                    break;
                } else if (!this.f9011b.isConnectable()) {
                    a(this.f9011b, this.f9010a);
                }
            } finally {
                if (this.f9011b.isValid()) {
                    this.f9011b.interestOps(0);
                }
            }
        }
    }

    public void a(byte[] bArr) {
        SocketChannel socketChannel = (SocketChannel) this.f9011b.channel();
        ByteBuffer[] byteBufferArr = {ByteBuffer.wrap(new byte[]{(byte) (bArr.length >>> 8), (byte) (bArr.length & 255)}), ByteBuffer.wrap(bArr)};
        this.f9011b.interestOps(4);
        int i9 = 0;
        while (i9 < bArr.length + 2) {
            try {
                if (this.f9011b.isWritable()) {
                    long jWrite = socketChannel.write(byteBufferArr);
                    if (jWrite < 0) {
                        throw new EOFException();
                    }
                    i9 += (int) jWrite;
                    if (i9 < bArr.length + 2 && System.currentTimeMillis() > this.f9010a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.f9011b, this.f9010a);
                }
            } catch (Throwable th) {
                if (this.f9011b.isValid()) {
                    this.f9011b.interestOps(0);
                }
                throw th;
            }
        }
        if (this.f9011b.isValid()) {
            this.f9011b.interestOps(0);
        }
    }

    public byte[] a() {
        byte[] bArrA = a(2);
        byte[] bArrA2 = a(((bArrA[0] & 255) << 8) + (bArrA[1] & 255));
        return bArrA2;
    }

    private byte[] a(int i9) {
        SocketChannel socketChannel = (SocketChannel) this.f9011b.channel();
        byte[] bArr = new byte[i9];
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.f9011b.interestOps(1);
        int i10 = 0;
        while (i10 < i9) {
            try {
                if (this.f9011b.isReadable()) {
                    long j = socketChannel.read(byteBufferWrap);
                    if (j < 0) {
                        throw new EOFException();
                    }
                    i10 += (int) j;
                    if (i10 < i9 && System.currentTimeMillis() > this.f9010a) {
                        throw new SocketTimeoutException();
                    }
                } else {
                    a(this.f9011b, this.f9010a);
                }
            } catch (Throwable th) {
                if (this.f9011b.isValid()) {
                    this.f9011b.interestOps(0);
                }
                throw th;
            }
        }
        if (this.f9011b.isValid()) {
            this.f9011b.interestOps(0);
        }
        return bArr;
    }

    public static byte[] a(SocketAddress socketAddress, SocketAddress socketAddress2, byte[] bArr, long j) throws IOException {
        o oVar = new o(j);
        if (socketAddress != null) {
            try {
                oVar.a(socketAddress);
            } finally {
                oVar.b();
            }
        }
        oVar.b(socketAddress2);
        oVar.a(bArr);
        return oVar.a();
    }
}

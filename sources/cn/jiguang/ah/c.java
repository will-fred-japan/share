package cn.jiguang.ah;

import androidx.datastore.preferences.protobuf.C0524s;
import cn.jiguang.aw.x;
import cn.jiguang.x.f;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class c extends a {
    private final int j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ByteBuffer f9153k = ByteBuffer.allocate(8192);

    public c(int i9, int i10) {
        this.j = i9;
        this.f9139f = i10;
    }

    private boolean b(byte[] bArr) {
        try {
            if (!b()) {
                f.k("NioSocketClient", "send error -tcp connect was invalid");
                return false;
            }
            if (bArr != null && bArr.length > 0) {
                int iWrite = this.f9135b.write(ByteBuffer.wrap(bArr));
                if (iWrite > 0) {
                    f.a("NioSocketClient", "isWritable has send len:" + iWrite);
                    return true;
                }
                if (iWrite >= 0) {
                    return true;
                }
                f.a("NioSocketClient", "isWritable error:" + iWrite);
                return false;
            }
            f.c("NioSocketClient", "send error - invalide buffer");
            return false;
        } catch (Exception e9) {
            f.j("NioSocketClient", "send data error:" + e9);
            close();
            return false;
        }
    }

    @Override // cn.jiguang.ah.a
    public synchronized int a(String str, int i9) {
        super.a(str, i9);
        try {
            this.f9135b = SocketChannel.open();
            this.f9137d = Selector.open();
            this.f9135b.configureBlocking(false);
            this.f9135b.connect(new InetSocketAddress(str, i9));
            f.c("NioSocketClient", "tcp connecting...");
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (!this.f9135b.finishConnect()) {
                if (!this.f9138e) {
                    f.c("NioSocketClient", "has close channel when connect...");
                    return -991;
                }
                Thread.sleep(10L);
                if (System.currentTimeMillis() - jCurrentTimeMillis > 3000) {
                    close();
                    return -994;
                }
            }
            if (!this.f9138e) {
                f.c("NioSocketClient", "has close channel when connected...");
                return -991;
            }
            f.c("NioSocketClient", "tcp connected [" + str + Constants.COLON_SEPARATOR + i9 + "]");
            this.f9135b.register(this.f9137d, 1);
            return 0;
        } catch (Throwable th) {
            f.j("NioSocketClient", "tcp connect has failed:" + th);
            close();
            return th instanceof SocketTimeoutException ? -994 : -1000;
        }
    }

    @Override // cn.jiguang.ah.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        f.c("NioSocketClient", "close this connect");
        super.close();
        Selector selector = this.f9137d;
        if (selector != null) {
            try {
                selector.close();
            } catch (IOException unused) {
            }
        }
        x.a(this.f9135b);
        this.f9135b = null;
    }

    @Override // cn.jiguang.ah.a
    public synchronized int a(byte[] bArr) {
        try {
            if (bArr == null) {
                f.i("NioSocketClient", "sendData failed, send data was null");
                return 103;
            }
            f.c("NioSocketClient", "send data length:" + bArr.length);
            if (bArr.length < this.j) {
                return b(bArr) ? 0 : 103;
            }
            f.i("NioSocketClient", "sendData failed, data length must less than " + this.j);
            return 6026;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // cn.jiguang.ah.a
    public ByteBuffer a(int i9) throws cn.jiguang.ae.f {
        ByteBuffer byteBufferB;
        try {
            if (!b()) {
                throw new cn.jiguang.ae.f(-991, "recv error,the connect is invalid");
            }
            int iC = c();
            if (iC > 0 && (byteBufferB = b(iC)) != null) {
                return byteBufferB;
            }
            int i10 = 0;
            int iC2 = 1048576;
            while (b() && this.f9136c < iC2) {
                int iSelect = i9 > 0 ? this.f9137d.select(i9) : this.f9137d.select();
                if (iSelect == 0) {
                    f.c("NioSocketClient", "readSelect:" + iSelect + ",time out:" + i9);
                    if (i9 > 0) {
                        throw new cn.jiguang.ae.f(-994, "recv time out");
                    }
                } else {
                    Iterator<SelectionKey> it = this.f9137d.selectedKeys().iterator();
                    while (it.hasNext()) {
                        SelectionKey next = it.next();
                        SocketChannel socketChannel = (SocketChannel) next.channel();
                        if (next.isReadable()) {
                            int i11 = socketChannel.read(this.f9153k);
                            if (i11 < 0) {
                                throw new cn.jiguang.ae.f(-996, "read len < 0:" + i11);
                            }
                            this.f9153k.flip();
                            int iLimit = this.f9153k.limit();
                            if (this.f9134a.remaining() < iLimit) {
                                throw new cn.jiguang.ae.f(-996, "the total buf remaining less than readLen,remaining:" + this.f9134a.remaining() + ",readLen:" + iLimit);
                            }
                            this.f9134a.put(this.f9153k);
                            this.f9136c += iLimit;
                            this.f9153k.compact();
                            if (this.f9136c < this.f9139f) {
                                f.c("NioSocketClient", "totalbuf can not parse head:" + this.f9136c + ",peerNetData len:" + iLimit + ",read:" + i11);
                            } else {
                                iC2 = c();
                            }
                            i10 = iLimit;
                        } else {
                            next.isWritable();
                        }
                        it.remove();
                    }
                }
            }
            if (iC2 == 1048576) {
                throw new cn.jiguang.ae.f(-997, "recv empty data or tcp has close");
            }
            StringBuilder sbA = C0524s.a(i10, "read len:", ",recvTotalLen:");
            sbA.append(this.f9136c);
            sbA.append(",shouldLen:");
            sbA.append(iC2);
            f.c("NioSocketClient", sbA.toString());
            ByteBuffer byteBufferB2 = b(iC2);
            if (byteBufferB2 != null) {
                return byteBufferB2;
            }
            throw new cn.jiguang.ae.f(-1001, "parse error");
        } catch (Throwable th) {
            if (th instanceof SocketTimeoutException) {
                throw new cn.jiguang.ae.f(-994, th.getMessage());
            }
            if (th instanceof cn.jiguang.ae.f) {
                throw th;
            }
            throw new cn.jiguang.ae.f(-997, th.getMessage());
        }
    }
}

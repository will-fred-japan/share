package com.engagelab.privates.common;

import android.content.Context;
import android.text.TextUtils;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.monitor.tcp.TCPTimeManager;
import com.engagelab.privates.common.utils.SystemUtil;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class q extends o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SocketChannel f12348b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Selector f12349c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f12350d;

    @Override // com.engagelab.privates.common.o
    public String a() {
        return "TcpSisClinet";
    }

    public boolean b(Context context, String str, int i9) throws IOException {
        if (!SystemUtil.isNetworkConnecting(context)) {
            MTCommonLog.e("TcpSisClinet", "can't connect, network is disConnected");
            return false;
        }
        long jStart = TCPTimeManager.start(context, 2);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i9);
        if (inetSocketAddress.isUnresolved()) {
            TCPTimeManager.endFail(context, 2, jStart, -1);
            return false;
        }
        TCPTimeManager.endSucc(context, 2, jStart);
        SocketChannel socketChannelOpen = SocketChannel.open();
        this.f12348b = socketChannelOpen;
        socketChannelOpen.configureBlocking(false);
        Selector selectorOpen = Selector.open();
        this.f12349c = selectorOpen;
        this.f12348b.register(selectorOpen, 8);
        this.f12348b.connect(inetSocketAddress);
        this.f12349c.select();
        Set<SelectionKey> setSelectedKeys = this.f12349c.selectedKeys();
        if (setSelectedKeys == null) {
            MTCommonLog.d("TcpSisClinet", "selectionKeys is null");
            return false;
        }
        if (setSelectedKeys.isEmpty()) {
            MTCommonLog.d("TcpSisClinet", "selectionKeys is empty");
            return false;
        }
        SelectionKey next = setSelectedKeys.iterator().next();
        if (next == null || !next.isConnectable()) {
            MTCommonLog.d("TcpSisClinet", "selectionKey is null");
            return false;
        }
        if (!next.isConnectable()) {
            MTCommonLog.d("TcpSisClinet", "selectionKey is disConnected");
            return false;
        }
        SocketChannel socketChannel = (SocketChannel) next.channel();
        if (!socketChannel.isConnectionPending()) {
            MTCommonLog.d("TcpSisClinet", "finish connect");
            return false;
        }
        socketChannel.finishConnect();
        socketChannel.register(this.f12349c, 1);
        MTCommonLog.d("TcpSisClinet", "tcp connect success");
        return true;
    }

    public void h(Context context) {
        MTCommonLog.d("TcpSisClinet", "tcp disconnectImp");
        try {
            Selector selector = this.f12349c;
            if (selector != null && selector.isOpen()) {
                this.f12349c.close();
                this.f12349c = null;
            }
            SocketChannel socketChannel = this.f12348b;
            if (socketChannel == null || !socketChannel.isConnected()) {
                return;
            }
            this.f12348b.finishConnect();
            this.f12348b.close();
            this.f12348b = null;
        } catch (Throwable th) {
            H2.a.k(th, new StringBuilder("disconnect failed "), "TcpSisClinet");
        }
    }

    public byte[] i(Context context) {
        try {
            if (!this.f12350d) {
                MTCommonLog.d("TcpSisClinet", "tcp is not connecting");
                return null;
            }
            this.f12349c.select();
            if (!this.f12349c.isOpen()) {
                MTCommonLog.d("TcpSisClinet", "selector is closed");
                return null;
            }
            Set<SelectionKey> setSelectedKeys = this.f12349c.selectedKeys();
            if (setSelectedKeys == null) {
                MTCommonLog.w("TcpSisClinet", "selectionKeys is null");
                h(context);
                return null;
            }
            if (setSelectedKeys.isEmpty()) {
                MTCommonLog.w("TcpSisClinet", "selectionKeys is empty");
                h(context);
                return null;
            }
            Iterator<SelectionKey> it = setSelectedKeys.iterator();
            if (!it.hasNext()) {
                MTCommonLog.w("TcpSisClinet", "selectionKeys hasn't next");
                h(context);
                return null;
            }
            SelectionKey next = it.next();
            if (next == null) {
                MTCommonLog.w("TcpSisClinet", "selectionKey is null");
                h(context);
                return null;
            }
            if (!next.isReadable()) {
                MTCommonLog.w("TcpSisClinet", "selectionKey is disReadable");
                h(context);
                return null;
            }
            SocketChannel socketChannel = (SocketChannel) next.channel();
            if (!socketChannel.isConnected()) {
                MTCommonLog.w("TcpSisClinet", "socketChannel is disConnected");
                h(context);
                return null;
            }
            if (this.f12350d) {
                ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2);
                int i9 = socketChannel.read(byteBufferAllocate);
                if (i9 < 0) {
                    MTCommonLog.w("TcpSisClinet", "read ahead length = " + i9);
                    h(context);
                    return null;
                }
                byte[] bArrArray = byteBufferAllocate.array();
                int i10 = ByteBuffer.wrap(bArrArray).getShort() & 16383;
                if (i10 == 0) {
                    MTCommonLog.w("TcpSisClinet", "read total length = " + i10);
                    h(context);
                    return null;
                }
                ByteBuffer byteBufferAllocate2 = ByteBuffer.allocate(i10 - 2);
                while (byteBufferAllocate2.hasRemaining()) {
                    long j = socketChannel.read(byteBufferAllocate2);
                    if (j < 0) {
                        MTCommonLog.w("TcpSisClinet", "read content n = " + j);
                        MTCommonLog.w("TcpSisClinet", "read content position = " + byteBufferAllocate2.position());
                        MTCommonLog.w("TcpSisClinet", "read content limit = " + byteBufferAllocate2.limit());
                        h(context);
                        return null;
                    }
                }
                byte[] bArrArray2 = byteBufferAllocate2.array();
                byte[] bArr = new byte[i10];
                System.arraycopy(bArrArray, 0, bArr, 0, bArrArray.length);
                System.arraycopy(bArrArray2, 0, bArr, bArrArray.length, bArrArray2.length);
                return bArr;
            }
            return null;
        } catch (IOException e9) {
            MTCommonLog.w("TcpSisClinet", "receive IOException " + e9.getMessage());
            h(context);
        } catch (Throwable th) {
            MTCommonLog.w("TcpSisClinet", "receive failed " + th.getMessage());
            h(context);
        }
    }

    @Override // com.engagelab.privates.common.o
    public byte[] a(Context context, byte[] bArr, int i9, String str, int i10) {
        int i11;
        try {
            if (TextUtils.isEmpty(str) || (i11 = i10 - 10000) <= 0) {
                return null;
            }
            MTCommonLog.d("TcpSisClinet", "tcp connect " + str + Constants.COLON_SEPARATOR + i11);
            if (!b(context, str, i11)) {
                this.f12350d = false;
                MTCommonLog.d("TcpSisClinet", "tcp connect fail");
                return null;
            }
            this.f12350d = true;
            if (b(context, bArr)) {
                return i(context);
            }
            h(context);
            return null;
        } catch (Throwable th) {
            MTCommonLog.d("TcpSisClinet", "udp connect failed " + th.getMessage());
            return null;
        }
    }

    @Override // com.engagelab.privates.common.o
    public void a(Context context) {
        h(context);
    }

    public boolean b(Context context, byte[] bArr) throws IOException {
        SocketChannel socketChannel = this.f12348b;
        if (socketChannel == null || !socketChannel.isConnected()) {
            return false;
        }
        this.f12348b.write(ByteBuffer.wrap(bArr));
        return true;
    }
}

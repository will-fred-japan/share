package p179w7;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p096m7.d;

/* JADX INFO: compiled from: BluetoothConnection.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BluetoothAdapter f22147a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f22148b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile c f22149c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile BluetoothSocket f22150d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f22151e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f22152f = false;

    /* JADX INFO: compiled from: BluetoothConnection.java */
    public class a extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BluetoothDevice f22153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UUID f22154c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(BluetoothDevice bluetoothDevice, UUID uuid) {
            super("secure-rfcomm");
            this.f22153b = bluetoothDevice;
            this.f22154c = uuid;
        }

        @Override // w7.b.d
        public final BluetoothSocket a() {
            return this.f22153b.createRfcommSocketToServiceRecord(this.f22154c);
        }
    }

    /* JADX INFO: renamed from: w7.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BluetoothConnection.java */
    public class C0279b extends d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BluetoothDevice f22155b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UUID f22156c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0279b(BluetoothDevice bluetoothDevice, UUID uuid) {
            super("insecure-rfcomm");
            this.f22155b = bluetoothDevice;
            this.f22156c = uuid;
        }

        @Override // w7.b.d
        public final BluetoothSocket a() {
            return this.f22155b.createInsecureRfcommSocketToServiceRecord(this.f22156c);
        }
    }

    /* JADX INFO: compiled from: BluetoothConnection.java */
    public class c extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BluetoothSocket f22157a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InputStream f22158b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OutputStream f22159c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public volatile boolean f22160d = false;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ e.m f22161e;

        public c(e.m mVar, BluetoothSocket bluetoothSocket) {
            this.f22161e = mVar;
            this.f22157a = bluetoothSocket;
            this.f22158b = bluetoothSocket.getInputStream();
            this.f22159c = bluetoothSocket.getOutputStream();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public final void run() {
            byte[] bArr = new byte[1024];
            while (!this.f22160d) {
                try {
                    int i9 = this.f22158b.read(bArr);
                    if (i9 < 0) {
                        break;
                    }
                    e.m mVar = this.f22161e;
                    byte[] bArrCopyOf = Arrays.copyOf(bArr, i9);
                    mVar.getClass();
                    e.d(e.this, new G6.b(16, mVar, bArrCopyOf));
                } catch (IOException unused) {
                }
            }
            OutputStream outputStream = this.f22159c;
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception unused2) {
                }
            }
            InputStream inputStream = this.f22158b;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused3) {
                }
            }
            e.m mVar2 = this.f22161e;
            BluetoothSocket bluetoothSocket = this.f22157a;
            mVar2.getClass();
            b.a(bluetoothSocket);
            synchronized (this.f22161e.f22148b) {
                try {
                    if (this.f22161e.f22149c == this) {
                        this.f22161e.f22149c = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            final e.m mVar3 = this.f22161e;
            final boolean z8 = !this.f22160d;
            mVar3.getClass();
            e.d(e.this, new Runnable() { // from class: w7.f
                @Override // java.lang.Runnable
                public final void run() {
                    e.m mVar4 = mVar3;
                    if (!z8) {
                        Log.d("FlutterBluePlugin", "onDisconnected by local (id: " + mVar4.f22221g + ")");
                        return;
                    }
                    Log.d("FlutterBluePlugin", "onDisconnected by remote (id: " + mVar4.f22221g + ")");
                    mVar4.f22224k = true;
                    d.b.a aVar = mVar4.f22222h;
                    if (aVar != null) {
                        aVar.a();
                        mVar4.f22222h = null;
                    }
                }
            });
            this.f22160d = true;
        }
    }

    /* JADX INFO: compiled from: BluetoothConnection.java */
    public static abstract class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f22162a;

        public d(String str) {
            this.f22162a = str;
        }

        public abstract BluetoothSocket a();
    }

    static {
        UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    }

    public b(BluetoothAdapter bluetoothAdapter) {
        this.f22147a = bluetoothAdapter;
    }

    public static void a(BluetoothSocket bluetoothSocket) {
        if (bluetoothSocket == null) {
            return;
        }
        try {
            bluetoothSocket.close();
        } catch (Exception unused) {
        }
    }

    public static void c(final BluetoothSocket bluetoothSocket, String str, long j) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Future futureSubmit = executorServiceNewSingleThreadExecutor.submit(new Callable() { // from class: w7.a
            @Override // java.util.concurrent.Callable
            public final Object call() throws IOException {
                bluetoothSocket.connect();
                return null;
            }
        });
        try {
            try {
                futureSubmit.get(j, TimeUnit.MILLISECONDS);
                executorServiceNewSingleThreadExecutor.shutdownNow();
            } catch (InterruptedException e9) {
                Thread.currentThread().interrupt();
                a(bluetoothSocket);
                throw new IOException(str.concat(" connect interrupted"), e9);
            } catch (ExecutionException e10) {
                Throwable cause = e10.getCause();
                if (!(cause instanceof IOException)) {
                    throw new IOException(str.concat(" connect failed"), cause);
                }
                throw ((IOException) cause);
            } catch (TimeoutException e11) {
                futureSubmit.cancel(true);
                a(bluetoothSocket);
                throw new IOException(str + " connect timeout after " + j + "ms", e11);
            }
        } catch (Throwable th) {
            executorServiceNewSingleThreadExecutor.shutdownNow();
            throw th;
        }
    }

    public final void b(String str, String str2) {
        UUID uuidFromString = UUID.fromString(str2);
        synchronized (this.f22148b) {
            if (this.f22152f) {
                throw new IOException("connect canceled");
            }
            if ((this.f22149c != null && !this.f22149c.f22160d) || this.f22151e) {
                throw new IOException("already connected or connecting");
            }
            this.f22151e = true;
        }
        try {
            BluetoothDevice remoteDevice = this.f22147a.getRemoteDevice(str);
            if (remoteDevice == null) {
                throw new IOException("device not found");
            }
            BluetoothSocket bluetoothSocketD = d(remoteDevice, uuidFromString);
            try {
                c cVar = new c((e.m) this, bluetoothSocketD);
                synchronized (this.f22148b) {
                    if (this.f22152f) {
                        a(bluetoothSocketD);
                        throw new IOException("connect canceled");
                    }
                    this.f22149c = cVar;
                }
                cVar.start();
                synchronized (this.f22148b) {
                    this.f22151e = false;
                    this.f22150d = null;
                }
            } catch (IOException e9) {
                a(bluetoothSocketD);
                throw e9;
            }
        } catch (Throwable th) {
            synchronized (this.f22148b) {
                this.f22151e = false;
                this.f22150d = null;
                throw th;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:77:0x0143 A[Catch: all -> 0x0146, TryCatch #3 {all -> 0x0146, blocks: (B:75:0x013f, B:77:0x0143, B:80:0x0148), top: B:90:0x013f }] */
    /* JADX WARN: Code duplicated, block: B:90:0x013f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public final BluetoothSocket d(BluetoothDevice bluetoothDevice, UUID uuid) throws Throwable {
        BluetoothSocket bluetoothSocketA;
        long nanos = TimeUnit.MILLISECONDS.toNanos(10000L) + System.nanoTime();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new a(bluetoothDevice, uuid));
        arrayList.add(new C0279b(bluetoothDevice, uuid));
        int i9 = 0;
        IOException iOException = null;
        while (i9 < arrayList.size()) {
            d dVar = (d) arrayList.get(i9);
            try {
                if (this.f22152f) {
                    throw new IOException("connect canceled");
                }
                long millis = TimeUnit.NANOSECONDS.toMillis(nanos - System.nanoTime());
                if (millis <= 0) {
                    throw new IOException("SPP connect timeout after 10000ms");
                }
                bluetoothSocketA = dVar.a();
                try {
                    if (bluetoothSocketA == null) {
                        throw new IOException(dVar.f22162a + " socket is null");
                    }
                    synchronized (this.f22148b) {
                        if (this.f22152f) {
                            a(bluetoothSocketA);
                            throw new IOException("connect canceled");
                        }
                        this.f22150d = bluetoothSocketA;
                    }
                    this.f22147a.cancelDiscovery();
                    c(bluetoothSocketA, dVar.f22162a, Math.max(1L, millis / ((long) (arrayList.size() - i9))));
                    if (this.f22152f) {
                        a(bluetoothSocketA);
                        throw new IOException("connect canceled");
                    }
                    Log.i("BluetoothConnection", "SPP connected via " + dVar.f22162a);
                    synchronized (this.f22148b) {
                        try {
                            if (this.f22150d == bluetoothSocketA) {
                                this.f22150d = null;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    return bluetoothSocketA;
                } catch (IOException e9) {
                    e = e9;
                    try {
                        Log.w("BluetoothConnection", "SPP " + dVar.f22162a + " failed: " + e.getMessage());
                        a(bluetoothSocketA);
                        if (this.f22152f) {
                            throw new IOException("connect canceled", e);
                        }
                        try {
                            Thread.sleep(200L);
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                        }
                        synchronized (this.f22148b) {
                            try {
                                if (this.f22150d == bluetoothSocketA) {
                                    this.f22150d = null;
                                }
                            } catch (Throwable th2) {
                                throw th2;
                            }
                        }
                        i9++;
                        iOException = e;
                    } catch (Throwable th3) {
                        th = th3;
                        synchronized (this.f22148b) {
                            try {
                                if (this.f22150d == bluetoothSocketA) {
                                    this.f22150d = null;
                                }
                            } catch (Throwable th4) {
                                throw th4;
                            }
                        }
                        throw th;
                    }
                }
            } catch (IOException e10) {
                e = e10;
                bluetoothSocketA = null;
            } catch (Throwable th5) {
                th = th5;
                bluetoothSocketA = null;
                synchronized (this.f22148b) {
                    if (this.f22150d == bluetoothSocketA) {
                        this.f22150d = null;
                    }
                    throw th;
                }
            }
        }
        if (iOException != null) {
            throw iOException;
        }
        throw new IOException("socket connection not established");
    }

    public final void e() {
        BluetoothSocket bluetoothSocket;
        c cVar;
        synchronized (this.f22148b) {
            this.f22152f = true;
            bluetoothSocket = this.f22150d;
            this.f22150d = null;
            cVar = this.f22149c;
            this.f22149c = null;
        }
        a(bluetoothSocket);
        if (cVar == null || cVar.f22160d) {
            return;
        }
        cVar.f22160d = true;
        BluetoothSocket bluetoothSocket2 = cVar.f22157a;
        if (bluetoothSocket2 != null) {
            try {
                bluetoothSocket2.close();
            } catch (Exception unused) {
            }
        }
    }
}

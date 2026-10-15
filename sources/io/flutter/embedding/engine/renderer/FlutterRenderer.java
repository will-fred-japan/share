package io.flutter.embedding.engine.renderer;

import B0.C0304s;
import G.RunnableC0310a;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Keep;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.view.TextureRegistry;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class FlutterRenderer implements TextureRegistry {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f19448a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Surface f19450c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f19455h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f19449b = new AtomicLong(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f19451d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Handler f19452e = new Handler();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final HashSet f19453f = new HashSet();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList f19454g = new ArrayList();

    @Keep
    public final class ImageTextureRegistryEntry implements TextureRegistry.ImageTextureEntry, TextureRegistry.ImageConsumer {
        private static final String TAG = "ImageTextureRegistryEntry";
        private final long id;
        private boolean ignoringFence = false;
        private Image image;
        private boolean released;

        public ImageTextureRegistryEntry(long j) {
            this.id = j;
        }

        private void maybeWaitOnFence(Image image) {
            if (image == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
            } else {
                this.ignoringFence = true;
            }
        }

        private void waitOnFence(Image image) {
            try {
                image.getFence().awaitForever();
            } catch (IOException unused) {
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() {
            Image image;
            synchronized (this) {
                image = this.image;
                this.image = null;
            }
            maybeWaitOnFence(image);
            return image;
        }

        public void finalize() throws Throwable {
            try {
                if (this.released) {
                    return;
                }
                Image image = this.image;
                if (image != null) {
                    image.close();
                    this.image = null;
                }
                this.released = true;
                FlutterRenderer flutterRenderer = FlutterRenderer.this;
                flutterRenderer.f19452e.post(new d(this.id, flutterRenderer.f19448a));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public long id() {
            return this.id;
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public void pushImage(Image image) {
            Image image2;
            if (this.released) {
                return;
            }
            synchronized (this) {
                image2 = this.image;
                this.image = image;
            }
            if (image2 != null) {
                Log.e(TAG, "Dropping PlatformView Frame");
                image2.close();
            }
            if (image != null) {
                FlutterRenderer.this.f19448a.scheduleFrame();
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageTextureEntry
        public void release() {
            if (this.released) {
                return;
            }
            this.released = true;
            Image image = this.image;
            if (image != null) {
                image.close();
                this.image = null;
            }
            FlutterRenderer flutterRenderer = FlutterRenderer.this;
            flutterRenderer.f19448a.unregisterTexture(this.id);
        }
    }

    public class a implements io.flutter.embedding.engine.renderer.d {
        public a() {
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public final void a() {
            FlutterRenderer.this.f19451d = false;
        }

        @Override // io.flutter.embedding.engine.renderer.d
        public final void b() {
            FlutterRenderer.this.f19451d = true;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f19463a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f19464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f19465c;

        public b(Rect rect, int i9, int i10) {
            this.f19463a = rect;
            this.f19464b = i9;
            this.f19465c = i10;
        }
    }

    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f19471a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FlutterJNI f19472b;

        public d(long j, FlutterJNI flutterJNI) {
            this.f19471a = j;
            this.f19472b = flutterJNI;
        }

        @Override // java.lang.Runnable
        public final void run() {
            FlutterJNI flutterJNI = this.f19472b;
            if (flutterJNI.isAttached()) {
                flutterJNI.unregisterTexture(this.f19471a);
            }
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f19473a = 1.0f;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f19474b = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19475c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19476d = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f19477e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f19478f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f19479g = 0;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f19480h = 0;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f19481i = 0;
        public int j = 0;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f19482k = 0;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f19483l = 0;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f19484m = 0;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f19485n = 0;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f19486o = 0;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f19487p = 0;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f19488q = 0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f19489r = 0;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public int f19490s = 0;
        public int t = -1;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public final ArrayList f19491u = new ArrayList();

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public final ArrayList f19492v = new ArrayList();
    }

    public FlutterRenderer(FlutterJNI flutterJNI) {
        a aVar = new a();
        this.f19455h = aVar;
        this.f19448a = flutterJNI;
        flutterJNI.addIsDisplayingFlutterUiListener(aVar);
    }

    public final void a(TextureRegistry.b bVar) {
        HashSet hashSet = this.f19453f;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((TextureRegistry.b) ((WeakReference) it.next()).get()) == null) {
                it.remove();
            }
        }
        hashSet.add(new WeakReference(bVar));
    }

    public final TextureRegistry.ImageTextureEntry b() {
        ImageTextureRegistryEntry imageTextureRegistryEntry = new ImageTextureRegistryEntry(this.f19449b.getAndIncrement());
        imageTextureRegistryEntry.id();
        this.f19448a.registerImageTexture(imageTextureRegistryEntry.id(), imageTextureRegistryEntry, false);
        return imageTextureRegistryEntry;
    }

    public final TextureRegistry.SurfaceProducer c(TextureRegistry.c cVar) {
        if (Build.VERSION.SDK_INT < 29) {
            c cVarD = d();
            return new g(cVarD.f19466a, this.f19452e, this.f19448a, cVarD);
        }
        long andIncrement = this.f19449b.getAndIncrement();
        ImageReaderSurfaceProducer imageReaderSurfaceProducer = new ImageReaderSurfaceProducer(andIncrement);
        boolean z8 = cVar == TextureRegistry.c.f19703b;
        this.f19448a.registerImageTexture(andIncrement, imageReaderSurfaceProducer, z8);
        if (z8) {
            a(imageReaderSurfaceProducer);
        }
        this.f19454g.add(imageReaderSurfaceProducer);
        return imageReaderSurfaceProducer;
    }

    public final c d() {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        long andIncrement = this.f19449b.getAndIncrement();
        surfaceTexture.detachFromGLContext();
        c cVar = new c(andIncrement, surfaceTexture);
        this.f19448a.registerTexture(cVar.f19466a, cVar.f19467b);
        a(cVar);
        return cVar;
    }

    public final void e(int i9) {
        Iterator it = this.f19453f.iterator();
        while (it.hasNext()) {
            TextureRegistry.b bVar = (TextureRegistry.b) ((WeakReference) it.next()).get();
            if (bVar != null) {
                bVar.onTrimMemory(i9);
            } else {
                it.remove();
            }
        }
    }

    public final void f(TextureRegistry.b bVar) {
        HashSet<WeakReference> hashSet = this.f19453f;
        for (WeakReference weakReference : hashSet) {
            if (weakReference.get() == bVar) {
                hashSet.remove(weakReference);
                return;
            }
        }
    }

    public final void g() {
        Iterator it = this.f19454g.iterator();
        while (it.hasNext()) {
            ((ImageReaderSurfaceProducer) it.next()).getClass();
        }
    }

    public final void h() {
        if (this.f19450c != null) {
            this.f19448a.onSurfaceDestroyed();
            if (this.f19451d) {
                this.f19455h.a();
            }
            this.f19451d = false;
            this.f19450c = null;
        }
    }

    @Keep
    public final class ImageReaderSurfaceProducer implements TextureRegistry.SurfaceProducer, TextureRegistry.ImageConsumer, TextureRegistry.b {
        private static final boolean CLEANUP_ON_MEMORY_PRESSURE = true;
        private static final int MAX_DEQUEUED_IMAGES = 2;
        private static final int MAX_IMAGES = 7;
        private static final String TAG = "ImageReaderSurfaceProducer";
        private static final boolean VERBOSE_LOGS = false;
        private static final boolean trimOnMemoryPressure = true;
        TextureRegistry.SurfaceProducer.a callback;
        private final long id;
        private boolean released;
        private boolean ignoringFence = false;
        private int requestedWidth = 1;
        private int requestedHeight = 1;
        private boolean createNewReader = true;
        boolean notifiedDestroy = false;
        private long lastDequeueTime = 0;
        private long lastQueueTime = 0;
        private long lastScheduleTime = 0;
        private int numTrims = 0;
        private final Object lock = new Object();
        private final ArrayDeque<b> imageReaderQueue = new ArrayDeque<>();
        private final HashMap<ImageReader, b> perImageReaders = new HashMap<>();
        private ArrayList<a> lastDequeuedImage = new ArrayList<>();
        private b lastReaderDequeuedFrom = null;

        public class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Image f19456a;

            public a(Image image) {
                this.f19456a = image;
            }
        }

        public class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ImageReader f19458a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ArrayDeque<a> f19459b = new ArrayDeque<>();

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public boolean f19460c = false;

            public b(ImageReader imageReader) {
                this.f19458a = imageReader;
                imageReader.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: io.flutter.embedding.engine.renderer.b
                    @Override // android.media.ImageReader.OnImageAvailableListener
                    public final void onImageAvailable(ImageReader imageReader2) {
                        Image imageAcquireLatestImage;
                        FlutterRenderer.ImageReaderSurfaceProducer.b bVar = this.f19494a;
                        bVar.getClass();
                        try {
                            imageAcquireLatestImage = imageReader2.acquireLatestImage();
                        } catch (IllegalStateException e9) {
                            Log.e("ImageReaderSurfaceProducer", "onImageAvailable acquireLatestImage failed: " + e9);
                            imageAcquireLatestImage = null;
                        }
                        if (imageAcquireLatestImage == null) {
                            return;
                        }
                        FlutterRenderer.ImageReaderSurfaceProducer imageReaderSurfaceProducer = FlutterRenderer.ImageReaderSurfaceProducer.this;
                        if (imageReaderSurfaceProducer.released || bVar.f19460c) {
                            imageAcquireLatestImage.close();
                        } else {
                            imageReaderSurfaceProducer.onImage(imageReader2, imageAcquireLatestImage);
                        }
                    }
                }, new Handler(Looper.getMainLooper()));
            }
        }

        public ImageReaderSurfaceProducer(long j) {
            this.id = j;
        }

        private void cleanup() {
            synchronized (this.lock) {
                try {
                    for (b bVar : this.perImageReaders.values()) {
                        if (this.lastReaderDequeuedFrom == bVar) {
                            this.lastReaderDequeuedFrom = null;
                        }
                        bVar.f19460c = true;
                        bVar.f19458a.close();
                        bVar.f19459b.clear();
                    }
                    this.perImageReaders.clear();
                    if (this.lastDequeuedImage.size() > 0) {
                        Iterator<a> it = this.lastDequeuedImage.iterator();
                        while (it.hasNext()) {
                            it.next().f19456a.close();
                        }
                        this.lastDequeuedImage.clear();
                    }
                    b bVar2 = this.lastReaderDequeuedFrom;
                    if (bVar2 != null) {
                        bVar2.f19460c = true;
                        bVar2.f19458a.close();
                        bVar2.f19459b.clear();
                        this.lastReaderDequeuedFrom = null;
                    }
                    this.imageReaderQueue.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private ImageReader createImageReader29() {
            return ImageReader.newInstance(this.requestedWidth, this.requestedHeight, 34, 7, 256L);
        }

        private ImageReader createImageReader33() {
            O6.b.i();
            ImageReader.Builder builderG = C0304s.g(this.requestedWidth, this.requestedHeight);
            builderG.setMaxImages(7);
            builderG.setImageFormat(34);
            builderG.setUsage(256L);
            return builderG.build();
        }

        private b getActiveReader() {
            synchronized (this.lock) {
                try {
                    if (!this.createNewReader) {
                        b bVarPeekLast = this.imageReaderQueue.peekLast();
                        if (bVarPeekLast.f19458a.getSurface().isValid()) {
                            return bVarPeekLast;
                        }
                    }
                    this.createNewReader = false;
                    return getOrCreatePerImageReader(createImageReader());
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private b getOrCreatePerImageReader(ImageReader imageReader) {
            b bVar = this.perImageReaders.get(imageReader);
            if (bVar != null) {
                return bVar;
            }
            b bVarCreatePerImageReader = createPerImageReader(imageReader);
            this.perImageReaders.put(imageReader, bVarCreatePerImageReader);
            this.imageReaderQueue.add(bVarCreatePerImageReader);
            return bVarCreatePerImageReader;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void lambda$dequeueImage$0() {
            if (this.released) {
                return;
            }
            FlutterRenderer.this.f19448a.scheduleFrame();
        }

        private void maybeWaitOnFence(Image image) {
            if (image == null || this.ignoringFence) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                waitOnFence(image);
            } else {
                this.ignoringFence = true;
            }
        }

        private void releaseInternal() {
            cleanup();
            this.released = true;
            FlutterRenderer.this.f(this);
            FlutterRenderer.this.f19454g.remove(this);
        }

        private void waitOnFence(Image image) {
            try {
                image.getFence().awaitForever();
            } catch (IOException unused) {
            }
        }

        @Override // io.flutter.view.TextureRegistry.ImageConsumer
        public Image acquireLatestImage() {
            a aVarDequeueImage = dequeueImage();
            if (aVarDequeueImage == null) {
                return null;
            }
            Image image = aVarDequeueImage.f19456a;
            maybeWaitOnFence(image);
            return image;
        }

        public ImageReader createImageReader() {
            int i9 = Build.VERSION.SDK_INT;
            if (i9 >= 33) {
                return createImageReader33();
            }
            if (i9 >= 29) {
                return createImageReader29();
            }
            throw new UnsupportedOperationException("ImageReaderPlatformViewRenderTarget requires API version 29+");
        }

        public b createPerImageReader(ImageReader imageReader) {
            return new b(imageReader);
        }

        public double deltaMillis(long j) {
            return j / 1000000.0d;
        }

        public a dequeueImage() {
            a aVar;
            boolean z8;
            synchronized (this.lock) {
                try {
                    Iterator<b> it = this.imageReaderQueue.iterator();
                    aVar = null;
                    while (true) {
                        z8 = false;
                        if (!it.hasNext()) {
                            break;
                        }
                        b next = it.next();
                        ArrayDeque<a> arrayDeque = next.f19459b;
                        a aVarRemoveFirst = arrayDeque.isEmpty() ? null : arrayDeque.removeFirst();
                        if (aVarRemoveFirst != null) {
                            while (this.lastDequeuedImage.size() > 2) {
                                this.lastDequeuedImage.remove(0).f19456a.close();
                            }
                            this.lastDequeuedImage.add(aVarRemoveFirst);
                            this.lastReaderDequeuedFrom = next;
                            aVar = aVarRemoveFirst;
                            break;
                        }
                        aVar = aVarRemoveFirst;
                    }
                    pruneImageReaderQueue();
                    Iterator<b> it2 = this.imageReaderQueue.iterator();
                    while (it2.hasNext()) {
                        if (!it2.next().f19459b.isEmpty()) {
                            z8 = true;
                            break;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z8) {
                FlutterRenderer.this.f19452e.post(new Runnable() { // from class: io.flutter.embedding.engine.renderer.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f19493a.lambda$dequeueImage$0();
                    }
                });
            }
            return aVar;
        }

        public void disableFenceForTest() {
            this.ignoringFence = true;
        }

        public void finalize() throws Throwable {
            try {
                if (this.released) {
                    return;
                }
                releaseInternal();
                FlutterRenderer flutterRenderer = FlutterRenderer.this;
                flutterRenderer.f19452e.post(new d(this.id, flutterRenderer.f19448a));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public Surface getForcedNewSurface() {
            this.createNewReader = true;
            return getSurface();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getHeight() {
            return this.requestedHeight;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public Surface getSurface() {
            return getActiveReader().f19458a.getSurface();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public int getWidth() {
            return this.requestedWidth;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public boolean handlesCropAndRotation() {
            return false;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public long id() {
            return this.id;
        }

        public int numImageReaders() {
            int size;
            synchronized (this.lock) {
                size = this.imageReaderQueue.size();
            }
            return size;
        }

        public int numImages() {
            int size;
            synchronized (this.lock) {
                try {
                    Iterator<b> it = this.imageReaderQueue.iterator();
                    size = 0;
                    while (it.hasNext()) {
                        size += it.next().f19459b.size();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return size;
        }

        public int numTrims() {
            int i9;
            synchronized (this.lock) {
                i9 = this.numTrims;
            }
            return i9;
        }

        public void onImage(ImageReader imageReader, Image image) {
            a aVar;
            synchronized (this.lock) {
                b orCreatePerImageReader = getOrCreatePerImageReader(imageReader);
                if (orCreatePerImageReader.f19460c) {
                    aVar = null;
                } else {
                    ImageReaderSurfaceProducer imageReaderSurfaceProducer = ImageReaderSurfaceProducer.this;
                    System.nanoTime();
                    a aVar2 = imageReaderSurfaceProducer.new a(image);
                    ArrayDeque<a> arrayDeque = orCreatePerImageReader.f19459b;
                    arrayDeque.add(aVar2);
                    while (arrayDeque.size() > 2) {
                        arrayDeque.removeFirst().f19456a.close();
                    }
                    aVar = aVar2;
                }
            }
            if (aVar == null) {
                return;
            }
            FlutterRenderer.this.f19448a.scheduleFrame();
        }

        @Override // io.flutter.view.TextureRegistry.b
        public void onTrimMemory(int i9) {
            if (i9 < 40) {
                return;
            }
            synchronized (this.lock) {
                this.numTrims++;
            }
            cleanup();
            this.createNewReader = true;
        }

        public int pendingDequeuedImages() {
            return this.lastDequeuedImage.size();
        }

        public void pruneImageReaderQueue() {
            b bVarPeekFirst;
            while (this.imageReaderQueue.size() > 1 && (bVarPeekFirst = this.imageReaderQueue.peekFirst()) != null) {
                ArrayDeque<a> arrayDeque = bVarPeekFirst.f19459b;
                if (!arrayDeque.isEmpty() || ImageReaderSurfaceProducer.this.lastReaderDequeuedFrom == bVarPeekFirst) {
                    return;
                }
                this.imageReaderQueue.removeFirst();
                HashMap<ImageReader, b> map = this.perImageReaders;
                ImageReader imageReader = bVarPeekFirst.f19458a;
                map.remove(imageReader);
                bVarPeekFirst.f19460c = true;
                imageReader.close();
                arrayDeque.clear();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void release() {
            if (this.released) {
                return;
            }
            releaseInternal();
            FlutterRenderer flutterRenderer = FlutterRenderer.this;
            flutterRenderer.f19448a.unregisterTexture(this.id);
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void scheduleFrame() {
            FlutterRenderer.this.f19448a.scheduleFrame();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void setSize(int i9, int i10) {
            int iMax = Math.max(1, i9);
            int iMax2 = Math.max(1, i10);
            if (this.requestedWidth == iMax && this.requestedHeight == iMax2) {
                return;
            }
            this.createNewReader = true;
            this.requestedHeight = iMax2;
            this.requestedWidth = iMax;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceProducer
        public void setCallback(TextureRegistry.SurfaceProducer.a aVar) {
        }
    }

    public final class c implements TextureRegistry.SurfaceTextureEntry, TextureRegistry.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f19466a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SurfaceTextureWrapper f19467b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f19468c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public TextureRegistry.b f19469d;

        public c(long j, SurfaceTexture surfaceTexture) {
            this.f19466a = j;
            SurfaceTextureWrapper surfaceTextureWrapper = new SurfaceTextureWrapper(surfaceTexture, new RunnableC0310a(12, this));
            this.f19467b = surfaceTextureWrapper;
            surfaceTextureWrapper.surfaceTexture().setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() { // from class: io.flutter.embedding.engine.renderer.c
                @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
                public final void onFrameAvailable(SurfaceTexture surfaceTexture2) {
                    FlutterRenderer.c cVar = this.f19495a;
                    if (cVar.f19468c) {
                        return;
                    }
                    FlutterRenderer flutterRenderer = FlutterRenderer.this;
                    if (flutterRenderer.f19448a.isAttached()) {
                        cVar.f19467b.markDirty();
                        flutterRenderer.f19448a.scheduleFrame();
                    }
                }
            }, new Handler());
        }

        public final void finalize() throws Throwable {
            try {
                if (this.f19468c) {
                    return;
                }
                FlutterRenderer flutterRenderer = FlutterRenderer.this;
                flutterRenderer.f19452e.post(new d(this.f19466a, flutterRenderer.f19448a));
            } finally {
                super.finalize();
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public final long id() {
            return this.f19466a;
        }

        @Override // io.flutter.view.TextureRegistry.b
        public final void onTrimMemory(int i9) {
            TextureRegistry.b bVar = this.f19469d;
            if (bVar != null) {
                bVar.onTrimMemory(i9);
            }
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public final void release() {
            if (this.f19468c) {
                return;
            }
            this.f19467b.release();
            FlutterRenderer flutterRenderer = FlutterRenderer.this;
            flutterRenderer.f19448a.unregisterTexture(this.f19466a);
            flutterRenderer.f(this);
            this.f19468c = true;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public final void setOnTrimMemoryListener(TextureRegistry.b bVar) {
            this.f19469d = bVar;
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public final SurfaceTexture surfaceTexture() {
            return this.f19467b.surfaceTexture();
        }

        @Override // io.flutter.view.TextureRegistry.SurfaceTextureEntry
        public final void setOnFrameConsumedListener(TextureRegistry.a aVar) {
        }
    }
}

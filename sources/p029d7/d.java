package p029d7;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.util.Log;
import android.util.Size;
import io.flutter.embedding.engine.FlutterJNI;
import java.io.IOException;
import java.nio.ByteBuffer;
import p005a7.c;

/* JADX INFO: compiled from: ImageDecoderDefaultImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f18529a;

    public d(c cVar) {
        this.f18529a = cVar;
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [d7.c] */
    @Override // p029d7.a
    public Bitmap a(ByteBuffer byteBuffer, h hVar) {
        try {
            return ImageDecoder.decodeBitmap(ImageDecoder.createSource(byteBuffer), new ImageDecoder.OnHeaderDecodedListener() { // from class: d7.c
                @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
                public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
                    d dVar = this.f18528a;
                    dVar.getClass();
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                    imageDecoder.setAllocator(1);
                    p005a7.c cVar = dVar.f18529a;
                    if (cVar != null) {
                        Size size = imageInfo.getSize();
                        FlutterJNI.nativeImageHeaderCallback(cVar.f5746a, size.getWidth(), size.getHeight());
                    }
                }
            });
        } catch (IOException e9) {
            Log.e("FlutterImageDecoderImplDefault", "Failed to decode image", e9);
            return null;
        }
    }
}

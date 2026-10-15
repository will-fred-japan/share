package okhttp3;

import R7.a;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import p199z2.b;

/* JADX INFO: compiled from: RequestBody.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class RequestBody {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: RequestBody.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr) {
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] bArr, int i9) {
            return create$default(this, mediaType, bArr, i9, 0, 8, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i9, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                mediaType = null;
            }
            if ((i11 & 2) != 0) {
                i9 = 0;
            }
            if ((i11 & 4) != 0) {
                i10 = bArr.length;
            }
            return companion.create(bArr, mediaType, i9, i10);
        }

        public final RequestBody create(byte[] bArr) {
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType) {
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i9, int i10, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                i9 = 0;
            }
            if ((i11 & 8) != 0) {
                i10 = bArr.length;
            }
            return companion.create(mediaType, bArr, i9, i10);
        }

        public final RequestBody create(byte[] bArr, MediaType mediaType, int i9) {
            return create$default(this, bArr, mediaType, i9, 0, 4, (Object) null);
        }

        public final RequestBody create(String toRequestBody, MediaType mediaType) {
            k.e(toRequestBody, "$this$toRequestBody");
            Charset charset = a.f4067b;
            if (mediaType != null) {
                Charset charsetCharset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charsetCharset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetCharset$default;
                }
            }
            byte[] bytes = toRequestBody.getBytes(charset);
            k.d(bytes, "(this as java.lang.String).getBytes(charset)");
            return create(bytes, mediaType, 0, bytes.length);
        }

        public final RequestBody create(final ByteString toRequestBody, final MediaType mediaType) {
            k.e(toRequestBody, "$this$toRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return toRequestBody.size();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink sink) {
                    k.e(sink, "sink");
                    sink.write(toRequestBody);
                }
            };
        }

        public final RequestBody create(final byte[] toRequestBody, final MediaType mediaType, final int i9, final int i10) {
            k.e(toRequestBody, "$this$toRequestBody");
            Util.checkOffsetAndCount(toRequestBody.length, i9, i10);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i10;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink sink) {
                    k.e(sink, "sink");
                    sink.write(toRequestBody, i9, i10);
                }
            };
        }

        public final RequestBody create(final File asRequestBody, final MediaType mediaType) {
            k.e(asRequestBody, "$this$asRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return asRequestBody.length();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink sink) throws IOException {
                    k.e(sink, "sink");
                    Source source = Okio.source(asRequestBody);
                    try {
                        sink.writeAll(source);
                        b.r(source, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            b.r(source, th);
                            throw th2;
                        }
                    }
                }
            };
        }

        public final RequestBody create(MediaType mediaType, String content) {
            k.e(content, "content");
            return create(content, mediaType);
        }

        public final RequestBody create(MediaType mediaType, ByteString content) {
            k.e(content, "content");
            return create(content, mediaType);
        }

        public final RequestBody create(MediaType mediaType, byte[] content, int i9, int i10) {
            k.e(content, "content");
            return create(content, mediaType, i9, i10);
        }

        public final RequestBody create(MediaType mediaType, File file) {
            k.e(file, "file");
            return create(file, mediaType);
        }
    }

    public static final RequestBody create(File file, MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    public long contentLength() {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink bufferedSink);

    public static final RequestBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public static final RequestBody create(MediaType mediaType, File file) {
        return Companion.create(mediaType, file);
    }

    public static final RequestBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final RequestBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create$default(Companion, mediaType, bArr, 0, 0, 12, (Object) null);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i9) {
        return Companion.create$default(Companion, mediaType, bArr, i9, 0, 8, (Object) null);
    }

    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i9, int i10) {
        return Companion.create(mediaType, bArr, i9, i10);
    }

    public static final RequestBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    public static final RequestBody create(byte[] bArr) {
        return Companion.create$default(Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create$default(Companion, bArr, mediaType, 0, 0, 6, (Object) null);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i9) {
        return Companion.create$default(Companion, bArr, mediaType, i9, 0, 4, (Object) null);
    }

    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i9, int i10) {
        return Companion.create(bArr, mediaType, i9, i10);
    }
}

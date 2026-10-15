package okhttp3;

import K7.l;
import R7.a;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import p199z2.b;

/* JADX INFO: compiled from: ResponseBody.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion = new Companion(null);
    private Reader reader;

    /* JADX INFO: compiled from: ResponseBody.kt */
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final BufferedSource source;

        public BomAwareReader(BufferedSource source, Charset charset) {
            k.e(source, "source");
            k.e(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(char[] cbuf, int i9, int i10) throws IOException {
            k.e(cbuf, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            Reader inputStreamReader = this.delegate;
            if (inputStreamReader == null) {
                inputStreamReader = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
                this.delegate = inputStreamReader;
            }
            return inputStreamReader.read(cbuf, i9, i10);
        }
    }

    /* JADX INFO: compiled from: ResponseBody.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public final ResponseBody create(String toResponseBody, MediaType mediaType) {
            k.e(toResponseBody, "$this$toResponseBody");
            Charset charset = a.f4067b;
            if (mediaType != null) {
                Charset charsetCharset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charsetCharset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetCharset$default;
                }
            }
            Buffer bufferWriteString = new Buffer().writeString(toResponseBody, charset);
            return create(bufferWriteString, mediaType, bufferWriteString.size());
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, BufferedSource bufferedSource, MediaType mediaType, long j, int i9, Object obj) {
            if ((i9 & 1) != 0) {
                mediaType = null;
            }
            if ((i9 & 2) != 0) {
                j = -1;
            }
            return companion.create(bufferedSource, mediaType, j);
        }

        public final ResponseBody create(byte[] toResponseBody, MediaType mediaType) {
            k.e(toResponseBody, "$this$toResponseBody");
            return create(new Buffer().write(toResponseBody), mediaType, toResponseBody.length);
        }

        public final ResponseBody create(ByteString toResponseBody, MediaType mediaType) {
            k.e(toResponseBody, "$this$toResponseBody");
            return create(new Buffer().write(toResponseBody), mediaType, toResponseBody.size());
        }

        public final ResponseBody create(final BufferedSource asResponseBody, final MediaType mediaType, final long j) {
            k.e(asResponseBody, "$this$asResponseBody");
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    return j;
                }

                @Override // okhttp3.ResponseBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.ResponseBody
                public BufferedSource source() {
                    return asResponseBody;
                }
            };
        }

        public final ResponseBody create(MediaType mediaType, String content) {
            k.e(content, "content");
            return create(content, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, byte[] content) {
            k.e(content, "content");
            return create(content, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, ByteString content) {
            k.e(content, "content");
            return create(content, mediaType);
        }

        public final ResponseBody create(MediaType mediaType, long j, BufferedSource content) {
            k.e(content, "content");
            return create(content, mediaType, j);
        }
    }

    private final Charset charset() {
        Charset charset;
        MediaType mediaTypeContentType = contentType();
        return (mediaTypeContentType == null || (charset = mediaTypeContentType.charset(a.f4067b)) == null) ? a.f4067b : charset;
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [T, java.lang.Object] */
    private final <T> T consumeSource(l<? super BufferedSource, ? extends T> lVar, l<? super T, Integer> lVar2) throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > Integer.MAX_VALUE) {
            throw new IOException(defpackage.f.d(jContentLength, "Cannot buffer entire body for content length: "));
        }
        BufferedSource bufferedSourceSource = source();
        try {
            T tInvoke = lVar.invoke(bufferedSourceSource);
            b.r(bufferedSourceSource, null);
            int iIntValue = lVar2.invoke(tInvoke).intValue();
            if (jContentLength == -1 || jContentLength == iIntValue) {
                return tInvoke;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iIntValue + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.r(bufferedSourceSource, th);
                throw th2;
            }
        }
    }

    public static final ResponseBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final ByteString byteString() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > Integer.MAX_VALUE) {
            throw new IOException(defpackage.f.d(jContentLength, "Cannot buffer entire body for content length: "));
        }
        BufferedSource bufferedSourceSource = source();
        try {
            ByteString byteString = bufferedSourceSource.readByteString();
            b.r(bufferedSourceSource, null);
            int size = byteString.size();
            if (jContentLength == -1 || jContentLength == size) {
                return byteString;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + size + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.r(bufferedSourceSource, th);
                throw th2;
            }
        }
    }

    public final byte[] bytes() throws IOException {
        long jContentLength = contentLength();
        if (jContentLength > Integer.MAX_VALUE) {
            throw new IOException(defpackage.f.d(jContentLength, "Cannot buffer entire body for content length: "));
        }
        BufferedSource bufferedSourceSource = source();
        try {
            byte[] byteArray = bufferedSourceSource.readByteArray();
            b.r(bufferedSourceSource, null);
            int length = byteArray.length;
            if (jContentLength == -1 || jContentLength == length) {
                return byteArray;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + length + ") disagree");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.r(bufferedSourceSource, th);
                throw th2;
            }
        }
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final String string() {
        BufferedSource bufferedSourceSource = source();
        try {
            String string = bufferedSourceSource.readString(Util.readBomAsCharset(bufferedSourceSource, charset()));
            b.r(bufferedSourceSource, null);
            return string;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.r(bufferedSourceSource, th);
                throw th2;
            }
        }
    }

    public static final ResponseBody create(MediaType mediaType, long j, BufferedSource bufferedSource) {
        return Companion.create(mediaType, j, bufferedSource);
    }

    public static final ResponseBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    public static final ResponseBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    public static final ResponseBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    public static final ResponseBody create(BufferedSource bufferedSource, MediaType mediaType, long j) {
        return Companion.create(bufferedSource, mediaType, j);
    }

    public static final ResponseBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    public static final ResponseBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }
}

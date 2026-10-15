package R6;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: FileSelectorApiImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p050g7.b f4054b;

    /* JADX INFO: compiled from: FileSelectorApiImpl.java */
    public class a implements p096m7.n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f4055a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c f4056b;

        public a(int i9, c cVar) {
            this.f4055a = i9;
            this.f4056b = cVar;
        }

        @Override // p096m7.n
        public final boolean onActivityResult(int i9, int i10, Intent intent) {
            if (i9 != this.f4055a) {
                return false;
            }
            this.f4056b.a(i10, intent);
            ((a7.a.b) k.this.f4054b).c(this);
            return true;
        }
    }

    /* JADX INFO: compiled from: FileSelectorApiImpl.java */
    public static class b {
    }

    /* JADX INFO: compiled from: FileSelectorApiImpl.java */
    public static abstract class c {
        public abstract void a(int i9, Intent intent);
    }

    public k(p050g7.b bVar) {
        this.f4054b = bVar;
    }

    public static void a(Intent intent, n nVar) {
        List arrayList;
        HashSet hashSet = new HashSet();
        hashSet.addAll(nVar.f4064a);
        List<String> list = nVar.f4065b;
        if (list.isEmpty()) {
            arrayList = Collections.EMPTY_LIST;
        } else {
            MimeTypeMap singleton = MimeTypeMap.getSingleton();
            HashSet hashSet2 = new HashSet();
            for (String str : list) {
                String mimeTypeFromExtension = singleton.getMimeTypeFromExtension(str);
                if (mimeTypeFromExtension != null) {
                    hashSet2.add(mimeTypeFromExtension);
                } else {
                    Log.w("FileSelectorApiImpl", "Extension not supported: " + str);
                }
            }
            arrayList = new ArrayList(hashSet2);
        }
        hashSet.addAll(arrayList);
        if (hashSet.isEmpty()) {
            intent.setType("*/*");
        } else if (hashSet.size() == 1) {
            intent.setType((String) hashSet.iterator().next());
        } else {
            intent.setType("*/*");
            intent.putExtra("android.intent.extra.MIME_TYPES", (String[]) hashSet.toArray(new String[0]));
        }
    }

    public final void b(Intent intent, int i9, c cVar) {
        p050g7.b bVar = this.f4054b;
        if (bVar == null) {
            throw new Exception("No activity is available.");
        }
        ((a7.a.b) bVar).a(new a(i9, cVar));
        ((a7.a.b) this.f4054b).f5737a.startActivityForResult(intent, i9);
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Multi-variable type inference failed */
    public final R6.a c(Uri uri) {
        String str;
        Integer numValueOf;
        Object objB;
        m mVar;
        p050g7.b bVar = this.f4054b;
        Object mVar2 = null;
        if (bVar == null) {
            Log.d("FileSelectorApiImpl", "Activity is not available.");
            return null;
        }
        ContentResolver contentResolver = ((a7.a.b) bVar).f5737a.getContentResolver();
        Cursor cursorQuery = contentResolver.query(uri, null, null, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    int columnIndex = cursorQuery.getColumnIndex("_display_name");
                    String string = columnIndex >= 0 ? cursorQuery.getString(columnIndex) : null;
                    int columnIndex2 = cursorQuery.getColumnIndex("_size");
                    if (cursorQuery.isNull(columnIndex2)) {
                        str = string;
                        numValueOf = null;
                    } else {
                        numValueOf = Integer.valueOf(cursorQuery.getInt(columnIndex2));
                        str = string;
                    }
                } else {
                    str = null;
                    numValueOf = null;
                }
            } catch (Throwable th) {
                try {
                    cursorQuery.close();
                    throw th;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                    throw th;
                }
            }
        } else {
            str = null;
            numValueOf = null;
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        if (numValueOf == null) {
            return null;
        }
        byte[] bArr = new byte[numValueOf.intValue()];
        try {
            InputStream inputStreamOpenInputStream = contentResolver.openInputStream(uri);
            try {
                new DataInputStream(inputStreamOpenInputStream).readFully(bArr);
                if (inputStreamOpenInputStream != null) {
                    inputStreamOpenInputStream.close();
                }
                try {
                    objB = o.b(((a7.a.b) this.f4054b).f5737a, uri);
                } catch (IOException | SecurityException unused) {
                    mVar = 0;
                } catch (IllegalArgumentException e9) {
                    mVar2 = new m(l.ILLEGAL_ARGUMENT_EXCEPTION, e9.getMessage() == null ? "" : e9.getMessage());
                    objB = "FILE_SELECTOR_EXCEPTION";
                }
                mVar = mVar2;
                mVar2 = objB;
                return new R6.a(mVar2, contentResolver.getType(uri), str, numValueOf.intValue(), bArr, mVar);
            } catch (Throwable th3) {
                if (inputStreamOpenInputStream == null) {
                    throw th3;
                }
                try {
                    inputStreamOpenInputStream.close();
                    throw th3;
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                    throw th3;
                }
            }
        } catch (IOException e10) {
            Log.w("FileSelectorApiImpl", e10.getMessage());
            return null;
        }
    }
}

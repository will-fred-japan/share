package p154t7;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p096m7.c;

/* JADX INFO: compiled from: LegacySharedPreferencesPlugin.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements p042f7.a, b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SharedPreferences f21478a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0258a f21479b = new C0258a();

    /* JADX INFO: renamed from: t7.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: LegacySharedPreferencesPlugin.java */
    public static class C0258a {
        public final String a(List<String> list) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                objectOutputStream.writeObject(list);
                objectOutputStream.flush();
                return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
            } catch (IOException e9) {
                throw new RuntimeException(e9);
            }
        }
    }

    public final Boolean b(String str, List<String> list) {
        SharedPreferences.Editor editorEdit = this.f21478a.edit();
        Map<String, ?> all = this.f21478a.getAll();
        ArrayList arrayList = new ArrayList();
        for (String str2 : all.keySet()) {
            if (str2.startsWith(str) && (list == null || list.contains(str2))) {
                arrayList.add(str2);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            editorEdit.remove((String) it.next());
        }
        return Boolean.valueOf(editorEdit.commit());
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final HashMap c(String str, List list) {
        Object bigInteger;
        Object objValueOf;
        Set hashSet = list == null ? null : new HashSet(list);
        Map<String, ?> all = this.f21478a.getAll();
        HashMap map = new HashMap();
        for (String str2 : all.keySet()) {
            if (str2.startsWith(str) && (hashSet == null || hashSet.contains(str2))) {
                Object obj = all.get(str2);
                Objects.requireNonNull(obj);
                boolean z8 = obj instanceof String;
                C0258a c0258a = this.f21479b;
                if (z8) {
                    String str3 = (String) obj;
                    if (str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu")) {
                        if (!str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu!")) {
                            objValueOf = obj;
                            String strSubstring = str3.substring(40);
                            c0258a.getClass();
                            try {
                                objValueOf = (List) new v(new ByteArrayInputStream(Base64.decode(strSubstring, 0))).readObject();
                            } catch (IOException | ClassNotFoundException e9) {
                                throw new RuntimeException(e9);
                            }
                        }
                    } else if (str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy")) {
                        bigInteger = new BigInteger(str3.substring(44), 36);
                        objValueOf = bigInteger;
                    } else if (str3.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
                        objValueOf = obj;
                        objValueOf = Double.valueOf(str3.substring(40));
                    }
                } else if (obj instanceof Set) {
                    objValueOf = obj;
                    ArrayList arrayList = new ArrayList((Set) obj);
                    this.f21478a.edit().remove(str2).putString(str2, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + c0258a.a(arrayList)).apply();
                    bigInteger = arrayList;
                    objValueOf = bigInteger;
                }
                objValueOf = obj;
                objValueOf = obj;
                objValueOf = obj;
                map.put(str2, objValueOf);
            }
        }
        return map;
    }

    public final Boolean d(String str, String str2) {
        if (str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu") || str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBCaWdJbnRlZ2Vy") || str2.startsWith("VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu")) {
            throw new RuntimeException("StorageError: This string cannot be stored as it clashes with special identifier prefixes");
        }
        return Boolean.valueOf(this.f21478a.edit().putString(str, str2).commit());
    }

    @Override // p042f7.a
    public final void onAttachedToEngine(f7.a.b bVar) {
        c cVar = bVar.f18713c;
        this.f21478a = bVar.f18711a.getSharedPreferences("FlutterSharedPreferences", 0);
        try {
            b.c.a(cVar, this);
        } catch (Exception e9) {
            Log.e("SharedPreferencesPlugin", "Received exception while setting up SharedPreferencesPlugin", e9);
        }
    }

    @Override // p042f7.a
    public final void onDetachedFromEngine(f7.a.b bVar) {
        b.c.a(bVar.f18713c, null);
    }
}

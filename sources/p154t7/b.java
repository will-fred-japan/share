package p154t7;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import p096m7.a;
import p096m7.r;

/* JADX INFO: compiled from: Messages.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: compiled from: Messages.java */
    public static class a extends RuntimeException {
    }

    /* JADX INFO: renamed from: t7.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Messages.java */
    public static class C0259b extends r {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0259b f21480d = new C0259b();
    }

    /* JADX INFO: compiled from: Messages.java */
    public interface c {
        static void a(p096m7.c cVar, final p154t7.a aVar) {
            p096m7.c.InterfaceC0232c interfaceC0232cC = cVar.c(new m7.c.d());
            C0259b c0259b = C0259b.f21480d;
            p096m7.b bVar = new p096m7.b(cVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.remove", c0259b, interfaceC0232cC);
            if (aVar != null) {
                final int i9 = 0;
                bVar.b(new m7.b.c() { // from class: t7.c
                    @Override // m7.b.c
                    public final void d(Object obj, a aVar2) {
                        switch (i9) {
                            case 0:
                                a aVar3 = aVar;
                                ArrayList<Object> arrayList = new ArrayList<>();
                                try {
                                    arrayList.add(0, Boolean.valueOf(aVar3.f21478a.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                                } catch (Throwable th) {
                                    arrayList = b.a(th);
                                }
                                aVar2.c(arrayList);
                                break;
                            case 1:
                                a aVar4 = aVar;
                                ArrayList<Object> arrayList2 = new ArrayList<>();
                                ArrayList arrayList3 = (ArrayList) obj;
                                try {
                                    arrayList2.add(0, Boolean.valueOf(aVar4.f21478a.edit().putLong((String) arrayList3.get(0), ((Long) arrayList3.get(1)).longValue()).commit()));
                                } catch (Throwable th2) {
                                    arrayList2 = b.a(th2);
                                }
                                aVar2.c(arrayList2);
                                break;
                            default:
                                a aVar5 = aVar;
                                ArrayList<Object> arrayList4 = new ArrayList<>();
                                ArrayList arrayList5 = (ArrayList) obj;
                                String str = (String) arrayList5.get(0);
                                List<String> list = (List) arrayList5.get(1);
                                try {
                                    arrayList4.add(0, Boolean.valueOf(aVar5.f21478a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + aVar5.f21479b.a(list)).commit()));
                                } catch (Throwable th3) {
                                    arrayList4 = b.a(th3);
                                }
                                aVar2.c(arrayList4);
                                break;
                        }
                    }
                });
            } else {
                bVar.b(null);
            }
            p096m7.b bVar2 = new p096m7.b(cVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setBool", c0259b, interfaceC0232cC);
            if (aVar != null) {
                final int i10 = 0;
                bVar2.b(new m7.b.c() { // from class: t7.d
                    @Override // m7.b.c
                    public final void d(Object obj, a aVar2) {
                        switch (i10) {
                            case 0:
                                a aVar3 = aVar;
                                ArrayList<Object> arrayList = new ArrayList<>();
                                ArrayList arrayList2 = (ArrayList) obj;
                                try {
                                    arrayList.add(0, Boolean.valueOf(aVar3.f21478a.edit().putBoolean((String) arrayList2.get(0), ((Boolean) arrayList2.get(1)).booleanValue()).commit()));
                                } catch (Throwable th) {
                                    arrayList = b.a(th);
                                }
                                aVar2.c(arrayList);
                                break;
                            case 1:
                                a aVar4 = aVar;
                                ArrayList<Object> arrayList3 = new ArrayList<>();
                                ArrayList arrayList4 = (ArrayList) obj;
                                String str = (String) arrayList4.get(0);
                                Double d9 = (Double) arrayList4.get(1);
                                try {
                                    aVar4.getClass();
                                    String string = Double.toString(d9.doubleValue());
                                    arrayList3.add(0, Boolean.valueOf(aVar4.f21478a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit()));
                                } catch (Throwable th2) {
                                    arrayList3 = b.a(th2);
                                }
                                aVar2.c(arrayList3);
                                break;
                            default:
                                a aVar5 = aVar;
                                ArrayList<Object> arrayList5 = new ArrayList<>();
                                ArrayList arrayList6 = (ArrayList) obj;
                                try {
                                    arrayList5.add(0, aVar5.b((String) arrayList6.get(0), (List) arrayList6.get(1)));
                                } catch (Throwable th3) {
                                    arrayList5 = b.a(th3);
                                }
                                aVar2.c(arrayList5);
                                break;
                        }
                    }
                });
            } else {
                bVar2.b(null);
            }
            p096m7.b bVar3 = new p096m7.b(cVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setString", c0259b, interfaceC0232cC);
            if (aVar != null) {
                final int i11 = 0;
                bVar3.b(new m7.b.c() { // from class: t7.e
                    @Override // m7.b.c
                    public final void d(Object obj, a aVar2) {
                        switch (i11) {
                            case 0:
                                a aVar3 = aVar;
                                ArrayList<Object> arrayList = new ArrayList<>();
                                ArrayList arrayList2 = (ArrayList) obj;
                                try {
                                    arrayList.add(0, aVar3.d((String) arrayList2.get(0), (String) arrayList2.get(1)));
                                } catch (Throwable th) {
                                    arrayList = b.a(th);
                                }
                                aVar2.c(arrayList);
                                break;
                            case 1:
                                a aVar4 = aVar;
                                ArrayList<Object> arrayList3 = new ArrayList<>();
                                ArrayList arrayList4 = (ArrayList) obj;
                                try {
                                    arrayList3.add(0, Boolean.valueOf(aVar4.f21478a.edit().putString((String) arrayList4.get(0), (String) arrayList4.get(1)).commit()));
                                } catch (Throwable th2) {
                                    arrayList3 = b.a(th2);
                                }
                                aVar2.c(arrayList3);
                                break;
                            default:
                                a aVar5 = aVar;
                                ArrayList<Object> arrayList5 = new ArrayList<>();
                                ArrayList arrayList6 = (ArrayList) obj;
                                try {
                                    arrayList5.add(0, aVar5.c((String) arrayList6.get(0), (List) arrayList6.get(1)));
                                } catch (Throwable th3) {
                                    arrayList5 = b.a(th3);
                                }
                                aVar2.c(arrayList5);
                                break;
                        }
                    }
                });
            } else {
                bVar3.b(null);
            }
            p096m7.b bVar4 = new p096m7.b(cVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setInt", c0259b, interfaceC0232cC);
            if (aVar != null) {
                final int i12 = 1;
                bVar4.b(new m7.b.c() { // from class: t7.c
                    @Override // m7.b.c
                    public final void d(Object obj, a aVar2) {
                        switch (i12) {
                            case 0:
                                a aVar3 = aVar;
                                ArrayList<Object> arrayList = new ArrayList<>();
                                try {
                                    arrayList.add(0, Boolean.valueOf(aVar3.f21478a.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                                } catch (Throwable th) {
                                    arrayList = b.a(th);
                                }
                                aVar2.c(arrayList);
                                break;
                            case 1:
                                a aVar4 = aVar;
                                ArrayList<Object> arrayList2 = new ArrayList<>();
                                ArrayList arrayList3 = (ArrayList) obj;
                                try {
                                    arrayList2.add(0, Boolean.valueOf(aVar4.f21478a.edit().putLong((String) arrayList3.get(0), ((Long) arrayList3.get(1)).longValue()).commit()));
                                } catch (Throwable th2) {
                                    arrayList2 = b.a(th2);
                                }
                                aVar2.c(arrayList2);
                                break;
                            default:
                                a aVar5 = aVar;
                                ArrayList<Object> arrayList4 = new ArrayList<>();
                                ArrayList arrayList5 = (ArrayList) obj;
                                String str = (String) arrayList5.get(0);
                                List<String> list = (List) arrayList5.get(1);
                                try {
                                    arrayList4.add(0, Boolean.valueOf(aVar5.f21478a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + aVar5.f21479b.a(list)).commit()));
                                } catch (Throwable th3) {
                                    arrayList4 = b.a(th3);
                                }
                                aVar2.c(arrayList4);
                                break;
                        }
                    }
                });
            } else {
                bVar4.b(null);
            }
            p096m7.b bVar5 = new p096m7.b(cVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setDouble", c0259b, interfaceC0232cC);
            if (aVar != null) {
                final int i13 = 1;
                bVar5.b(new m7.b.c() { // from class: t7.d
                    @Override // m7.b.c
                    public final void d(Object obj, a aVar2) {
                        switch (i13) {
                            case 0:
                                a aVar3 = aVar;
                                ArrayList<Object> arrayList = new ArrayList<>();
                                ArrayList arrayList2 = (ArrayList) obj;
                                try {
                                    arrayList.add(0, Boolean.valueOf(aVar3.f21478a.edit().putBoolean((String) arrayList2.get(0), ((Boolean) arrayList2.get(1)).booleanValue()).commit()));
                                } catch (Throwable th) {
                                    arrayList = b.a(th);
                                }
                                aVar2.c(arrayList);
                                break;
                            case 1:
                                a aVar4 = aVar;
                                ArrayList<Object> arrayList3 = new ArrayList<>();
                                ArrayList arrayList4 = (ArrayList) obj;
                                String str = (String) arrayList4.get(0);
                                Double d9 = (Double) arrayList4.get(1);
                                try {
                                    aVar4.getClass();
                                    String string = Double.toString(d9.doubleValue());
                                    arrayList3.add(0, Boolean.valueOf(aVar4.f21478a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit()));
                                } catch (Throwable th2) {
                                    arrayList3 = b.a(th2);
                                }
                                aVar2.c(arrayList3);
                                break;
                            default:
                                a aVar5 = aVar;
                                ArrayList<Object> arrayList5 = new ArrayList<>();
                                ArrayList arrayList6 = (ArrayList) obj;
                                try {
                                    arrayList5.add(0, aVar5.b((String) arrayList6.get(0), (List) arrayList6.get(1)));
                                } catch (Throwable th3) {
                                    arrayList5 = b.a(th3);
                                }
                                aVar2.c(arrayList5);
                                break;
                        }
                    }
                });
            } else {
                bVar5.b(null);
            }
            p096m7.b bVar6 = new p096m7.b(cVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setEncodedStringList", c0259b, interfaceC0232cC);
            if (aVar != null) {
                final int i14 = 1;
                bVar6.b(new m7.b.c() { // from class: t7.e
                    @Override // m7.b.c
                    public final void d(Object obj, a aVar2) {
                        switch (i14) {
                            case 0:
                                a aVar3 = aVar;
                                ArrayList<Object> arrayList = new ArrayList<>();
                                ArrayList arrayList2 = (ArrayList) obj;
                                try {
                                    arrayList.add(0, aVar3.d((String) arrayList2.get(0), (String) arrayList2.get(1)));
                                } catch (Throwable th) {
                                    arrayList = b.a(th);
                                }
                                aVar2.c(arrayList);
                                break;
                            case 1:
                                a aVar4 = aVar;
                                ArrayList<Object> arrayList3 = new ArrayList<>();
                                ArrayList arrayList4 = (ArrayList) obj;
                                try {
                                    arrayList3.add(0, Boolean.valueOf(aVar4.f21478a.edit().putString((String) arrayList4.get(0), (String) arrayList4.get(1)).commit()));
                                } catch (Throwable th2) {
                                    arrayList3 = b.a(th2);
                                }
                                aVar2.c(arrayList3);
                                break;
                            default:
                                a aVar5 = aVar;
                                ArrayList<Object> arrayList5 = new ArrayList<>();
                                ArrayList arrayList6 = (ArrayList) obj;
                                try {
                                    arrayList5.add(0, aVar5.c((String) arrayList6.get(0), (List) arrayList6.get(1)));
                                } catch (Throwable th3) {
                                    arrayList5 = b.a(th3);
                                }
                                aVar2.c(arrayList5);
                                break;
                        }
                    }
                });
            } else {
                bVar6.b(null);
            }
            p096m7.b bVar7 = new p096m7.b(cVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.setDeprecatedStringList", c0259b, interfaceC0232cC);
            if (aVar != null) {
                final int i15 = 2;
                bVar7.b(new m7.b.c() { // from class: t7.c
                    @Override // m7.b.c
                    public final void d(Object obj, a aVar2) {
                        switch (i15) {
                            case 0:
                                a aVar3 = aVar;
                                ArrayList<Object> arrayList = new ArrayList<>();
                                try {
                                    arrayList.add(0, Boolean.valueOf(aVar3.f21478a.edit().remove((String) ((ArrayList) obj).get(0)).commit()));
                                } catch (Throwable th) {
                                    arrayList = b.a(th);
                                }
                                aVar2.c(arrayList);
                                break;
                            case 1:
                                a aVar4 = aVar;
                                ArrayList<Object> arrayList2 = new ArrayList<>();
                                ArrayList arrayList3 = (ArrayList) obj;
                                try {
                                    arrayList2.add(0, Boolean.valueOf(aVar4.f21478a.edit().putLong((String) arrayList3.get(0), ((Long) arrayList3.get(1)).longValue()).commit()));
                                } catch (Throwable th2) {
                                    arrayList2 = b.a(th2);
                                }
                                aVar2.c(arrayList2);
                                break;
                            default:
                                a aVar5 = aVar;
                                ArrayList<Object> arrayList4 = new ArrayList<>();
                                ArrayList arrayList5 = (ArrayList) obj;
                                String str = (String) arrayList5.get(0);
                                List<String> list = (List) arrayList5.get(1);
                                try {
                                    arrayList4.add(0, Boolean.valueOf(aVar5.f21478a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBhIGxpc3Qu" + aVar5.f21479b.a(list)).commit()));
                                } catch (Throwable th3) {
                                    arrayList4 = b.a(th3);
                                }
                                aVar2.c(arrayList4);
                                break;
                        }
                    }
                });
            } else {
                bVar7.b(null);
            }
            p096m7.b bVar8 = new p096m7.b(cVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.clear", c0259b, interfaceC0232cC);
            if (aVar != null) {
                final int i16 = 2;
                bVar8.b(new m7.b.c() { // from class: t7.d
                    @Override // m7.b.c
                    public final void d(Object obj, a aVar2) {
                        switch (i16) {
                            case 0:
                                a aVar3 = aVar;
                                ArrayList<Object> arrayList = new ArrayList<>();
                                ArrayList arrayList2 = (ArrayList) obj;
                                try {
                                    arrayList.add(0, Boolean.valueOf(aVar3.f21478a.edit().putBoolean((String) arrayList2.get(0), ((Boolean) arrayList2.get(1)).booleanValue()).commit()));
                                } catch (Throwable th) {
                                    arrayList = b.a(th);
                                }
                                aVar2.c(arrayList);
                                break;
                            case 1:
                                a aVar4 = aVar;
                                ArrayList<Object> arrayList3 = new ArrayList<>();
                                ArrayList arrayList4 = (ArrayList) obj;
                                String str = (String) arrayList4.get(0);
                                Double d9 = (Double) arrayList4.get(1);
                                try {
                                    aVar4.getClass();
                                    String string = Double.toString(d9.doubleValue());
                                    arrayList3.add(0, Boolean.valueOf(aVar4.f21478a.edit().putString(str, "VGhpcyBpcyB0aGUgcHJlZml4IGZvciBEb3VibGUu" + string).commit()));
                                } catch (Throwable th2) {
                                    arrayList3 = b.a(th2);
                                }
                                aVar2.c(arrayList3);
                                break;
                            default:
                                a aVar5 = aVar;
                                ArrayList<Object> arrayList5 = new ArrayList<>();
                                ArrayList arrayList6 = (ArrayList) obj;
                                try {
                                    arrayList5.add(0, aVar5.b((String) arrayList6.get(0), (List) arrayList6.get(1)));
                                } catch (Throwable th3) {
                                    arrayList5 = b.a(th3);
                                }
                                aVar2.c(arrayList5);
                                break;
                        }
                    }
                });
            } else {
                bVar8.b(null);
            }
            p096m7.b bVar9 = new p096m7.b(cVar, "dev.flutter.pigeon.shared_preferences_android.SharedPreferencesApi.getAll", c0259b, interfaceC0232cC);
            if (aVar == null) {
                bVar9.b(null);
            } else {
                final int i17 = 2;
                bVar9.b(new m7.b.c() { // from class: t7.e
                    @Override // m7.b.c
                    public final void d(Object obj, a aVar2) {
                        switch (i17) {
                            case 0:
                                a aVar3 = aVar;
                                ArrayList<Object> arrayList = new ArrayList<>();
                                ArrayList arrayList2 = (ArrayList) obj;
                                try {
                                    arrayList.add(0, aVar3.d((String) arrayList2.get(0), (String) arrayList2.get(1)));
                                } catch (Throwable th) {
                                    arrayList = b.a(th);
                                }
                                aVar2.c(arrayList);
                                break;
                            case 1:
                                a aVar4 = aVar;
                                ArrayList<Object> arrayList3 = new ArrayList<>();
                                ArrayList arrayList4 = (ArrayList) obj;
                                try {
                                    arrayList3.add(0, Boolean.valueOf(aVar4.f21478a.edit().putString((String) arrayList4.get(0), (String) arrayList4.get(1)).commit()));
                                } catch (Throwable th2) {
                                    arrayList3 = b.a(th2);
                                }
                                aVar2.c(arrayList3);
                                break;
                            default:
                                a aVar5 = aVar;
                                ArrayList<Object> arrayList5 = new ArrayList<>();
                                ArrayList arrayList6 = (ArrayList) obj;
                                try {
                                    arrayList5.add(0, aVar5.c((String) arrayList6.get(0), (List) arrayList6.get(1)));
                                } catch (Throwable th3) {
                                    arrayList5 = b.a(th3);
                                }
                                aVar2.c(arrayList5);
                                break;
                        }
                    }
                });
            }
        }
    }

    public static ArrayList<Object> a(Throwable th) {
        ArrayList<Object> arrayList = new ArrayList<>(3);
        if (th instanceof a) {
            arrayList.add(null);
            arrayList.add(((a) th).getMessage());
            arrayList.add(null);
            return arrayList;
        }
        arrayList.add(th.toString());
        arrayList.add(th.getClass().getSimpleName());
        arrayList.add("Cause: " + th.getCause() + ", Stacktrace: " + Log.getStackTraceString(th));
        return arrayList;
    }
}

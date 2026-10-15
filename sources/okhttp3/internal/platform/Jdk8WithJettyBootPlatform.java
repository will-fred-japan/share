package okhttp3.internal.platform;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.k;
import okhttp3.Protocol;

/* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Jdk8WithJettyBootPlatform extends Platform {
    public static final Companion Companion = new Companion(null);
    private final Class<?> clientProviderClass;
    private final Method getMethod;
    private final Method putMethod;
    private final Method removeMethod;
    private final Class<?> serverProviderClass;

    /* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
    public static final class AlpnProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public AlpnProvider(List<String> protocols) {
            k.e(protocols, "protocols");
            this.protocols = protocols;
        }

        public final String getSelected() {
            return this.selected;
        }

        public final boolean getUnsupported() {
            return this.unsupported;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] objArr) {
            k.e(proxy, "proxy");
            k.e(method, "method");
            if (objArr == null) {
                objArr = new Object[0];
            }
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (k.a(name, "supports") && k.a(Boolean.TYPE, returnType)) {
                return Boolean.TRUE;
            }
            if (k.a(name, "unsupported") && k.a(Void.TYPE, returnType)) {
                this.unsupported = true;
                return null;
            }
            if (k.a(name, "protocols") && objArr.length == 0) {
                return this.protocols;
            }
            if ((k.a(name, "selectProtocol") || k.a(name, "select")) && String.class.equals(returnType) && objArr.length == 1) {
                Object obj = objArr[0];
                if (obj instanceof List) {
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<*>");
                    }
                    List list = (List) obj;
                    int size = list.size();
                    if (size >= 0) {
                        int i9 = 0;
                        while (true) {
                            Object obj2 = list.get(i9);
                            if (obj2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                            }
                            String str = (String) obj2;
                            if (this.protocols.contains(str)) {
                                this.selected = str;
                                return str;
                            }
                            if (i9 != size) {
                                i9++;
                            }
                        }
                    }
                    String str2 = this.protocols.get(0);
                    this.selected = str2;
                    return str2;
                }
            }
            if ((!k.a(name, "protocolSelected") && !k.a(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj3 = objArr[0];
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.selected = (String) obj3;
            return null;
        }

        public final void setSelected(String str) {
            this.selected = str;
        }

        public final void setUnsupported(boolean z8) {
            this.unsupported = z8;
        }
    }

    /* JADX INFO: compiled from: Jdk8WithJettyBootPlatform.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Platform buildIfSupported() {
            String jvmVersion = System.getProperty("java.specification.version", "unknown");
            try {
                k.d(jvmVersion, "jvmVersion");
                if (Integer.parseInt(jvmVersion) < 9) {
                    try {
                        Class<?> cls = Class.forName("org.eclipse.jetty.alpn.ALPN", true, null);
                        Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider", true, null);
                        Class<?> clientProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider", true, null);
                        Class<?> serverProviderClass = Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider", true, null);
                        Method putMethod = cls.getMethod("put", SSLSocket.class, cls2);
                        Method getMethod = cls.getMethod("get", SSLSocket.class);
                        Method removeMethod = cls.getMethod("remove", SSLSocket.class);
                        k.d(putMethod, "putMethod");
                        k.d(getMethod, "getMethod");
                        k.d(removeMethod, "removeMethod");
                        k.d(clientProviderClass, "clientProviderClass");
                        k.d(serverProviderClass, "serverProviderClass");
                        return new Jdk8WithJettyBootPlatform(putMethod, getMethod, removeMethod, clientProviderClass, serverProviderClass);
                    } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    }
                }
                return null;
            } catch (NumberFormatException unused2) {
            }
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public Jdk8WithJettyBootPlatform(Method putMethod, Method getMethod, Method removeMethod, Class<?> clientProviderClass, Class<?> serverProviderClass) {
        k.e(putMethod, "putMethod");
        k.e(getMethod, "getMethod");
        k.e(removeMethod, "removeMethod");
        k.e(clientProviderClass, "clientProviderClass");
        k.e(serverProviderClass, "serverProviderClass");
        this.putMethod = putMethod;
        this.getMethod = getMethod;
        this.removeMethod = removeMethod;
        this.clientProviderClass = clientProviderClass;
        this.serverProviderClass = serverProviderClass;
    }

    @Override // okhttp3.internal.platform.Platform
    public void afterHandshake(SSLSocket sslSocket) {
        k.e(sslSocket, "sslSocket");
        try {
            this.removeMethod.invoke(null, sslSocket);
        } catch (IllegalAccessException e9) {
            throw new AssertionError("failed to remove ALPN", e9);
        } catch (InvocationTargetException e10) {
            throw new AssertionError("failed to remove ALPN", e10);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public void configureTlsExtensions(SSLSocket sslSocket, String str, List<? extends Protocol> protocols) {
        k.e(sslSocket, "sslSocket");
        k.e(protocols, "protocols");
        try {
            this.putMethod.invoke(null, sslSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new AlpnProvider(Platform.Companion.alpnProtocolNames(protocols))));
        } catch (IllegalAccessException e9) {
            throw new AssertionError("failed to set ALPN", e9);
        } catch (InvocationTargetException e10) {
            throw new AssertionError("failed to set ALPN", e10);
        }
    }

    @Override // okhttp3.internal.platform.Platform
    public String getSelectedProtocol(SSLSocket sslSocket) {
        k.e(sslSocket, "sslSocket");
        try {
            InvocationHandler invocationHandler = Proxy.getInvocationHandler(this.getMethod.invoke(null, sslSocket));
            if (invocationHandler == null) {
                throw new NullPointerException("null cannot be cast to non-null type okhttp3.internal.platform.Jdk8WithJettyBootPlatform.AlpnProvider");
            }
            AlpnProvider alpnProvider = (AlpnProvider) invocationHandler;
            if (!alpnProvider.getUnsupported() && alpnProvider.getSelected() == null) {
                Platform.log$default(this, "ALPN callback dropped: HTTP/2 is disabled. Is alpn-boot on the boot class path?", 0, null, 6, null);
                return null;
            }
            if (alpnProvider.getUnsupported()) {
                return null;
            }
            return alpnProvider.getSelected();
        } catch (IllegalAccessException e9) {
            throw new AssertionError("failed to get ALPN selected protocol", e9);
        } catch (InvocationTargetException e10) {
            throw new AssertionError("failed to get ALPN selected protocol", e10);
        }
    }
}

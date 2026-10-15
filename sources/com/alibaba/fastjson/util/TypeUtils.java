package com.alibaba.fastjson.util;

import A.a;
import O7.d;
import O7.j;
import P7.h;
import W5.e;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPObject;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONScanner;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.parser.deserializer.EnumDeserializer;
import com.alibaba.fastjson.parser.deserializer.JavaBeanDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.serializer.CalendarCodec;
import com.alibaba.fastjson.serializer.SerializeBeanInfo;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.huawei.hms.framework.common.BundleUtil;
import com.huawei.hms.framework.common.ExceptionCode;
import com.vivo.push.PushClientConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.InputStream;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Path;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Currency;
import java.util.Deque;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p188x7.c;

/* JADX INFO: loaded from: classes.dex */
public class TypeUtils {
    private static Object OPTIONAL_EMPTY = null;
    private static boolean OPTIONAL_ERROR = false;
    private static Function<Map<String, Class<?>>, Void> addBaseClassMappingsFunction = null;
    private static BiFunction<Object, Class, Object> castFunction = null;
    private static Function<Object, Object> castToSqlDateFunction = null;
    private static Function<Object, Object> castToSqlTimeFunction = null;
    public static Function<Object, Object> castToTimestampFunction = null;
    private static Class class_deque = null;
    public static boolean compatibleWithFieldName = false;
    public static boolean compatibleWithJavaBean = false;
    public static final long fnv1a_64_magic_hashcode = -3750763034362895579L;
    public static final long fnv1a_64_magic_prime = 1099511628211L;
    private static Function<Class, Boolean> isClobFunction;
    private static final Set<String> isProxyClassNames;
    private static volatile Map<Class, String[]> kotlinIgnores;
    private static volatile boolean kotlinIgnores_error;
    private static volatile boolean kotlin_class_klass_error;
    private static volatile boolean kotlin_error;
    private static volatile Constructor kotlin_kclass_constructor;
    private static volatile Method kotlin_kclass_getConstructors;
    private static volatile Method kotlin_kfunction_getParameters;
    private static volatile Method kotlin_kparameter_getName;
    private static volatile Class kotlin_metadata;
    private static volatile boolean kotlin_metadata_error;
    private static Class<?> optionalClass;
    private static Method oracleDateMethod;
    private static Method oracleTimestampMethod;
    private static Class<?> pathClass;
    private static final Map primitiveTypeMap;
    private static Class<? extends Annotation> transientClass;
    private static final Pattern NUMBER_WITH_TRAILING_ZEROS_PATTERN = Pattern.compile("\\.0*$");
    private static boolean setAccessibleEnable = true;
    private static boolean oracleTimestampMethodInited = false;
    private static boolean oracleDateMethodInited = false;
    private static boolean optionalClassInited = false;
    private static boolean transientClassInited = false;
    private static Class<? extends Annotation> class_OneToMany = null;
    private static boolean class_OneToMany_error = false;
    private static Class<? extends Annotation> class_ManyToMany = null;
    private static boolean class_ManyToMany_error = false;
    private static Method method_HibernateIsInitialized = null;
    private static boolean method_HibernateIsInitialized_error = false;
    private static ConcurrentMap<String, Class<?>> mappings = new ConcurrentHashMap(256, 0.75f, 1);
    private static boolean pathClass_error = false;
    private static Class<? extends Annotation> class_JacksonCreator = null;
    private static boolean class_JacksonCreator_error = false;
    private static volatile Class class_XmlAccessType = null;
    private static volatile Class class_XmlAccessorType = null;
    private static volatile boolean classXmlAccessorType_error = false;
    private static volatile Method method_XmlAccessorType_value = null;
    private static volatile Field field_XmlAccessType_FIELD = null;
    private static volatile Object field_XmlAccessType_FIELD_VALUE = null;

    public static class MethodInheritanceComparator implements Comparator<Method> {
        @Override // java.util.Comparator
        public int compare(Method method, Method method2) {
            int iCompareTo = method.getName().compareTo(method2.getName());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
            Class<?> returnType = method.getReturnType();
            Class<?> returnType2 = method2.getReturnType();
            if (returnType.equals(returnType2)) {
                return 0;
            }
            if (returnType.isAssignableFrom(returnType2)) {
                return -1;
            }
            return returnType2.isAssignableFrom(returnType) ? 1 : 0;
        }
    }

    static {
        compatibleWithJavaBean = false;
        compatibleWithFieldName = false;
        class_deque = null;
        try {
            compatibleWithJavaBean = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHJAVABEAN));
            compatibleWithFieldName = "true".equals(IOUtils.getStringProperty(IOUtils.FASTJSON_COMPATIBLEWITHFIELDNAME));
        } catch (Throwable unused) {
        }
        try {
            class_deque = Deque.class;
        } catch (Throwable unused2) {
        }
        isClobFunction = new Function<Class, Boolean>() { // from class: com.alibaba.fastjson.util.TypeUtils.1
            @Override // com.alibaba.fastjson.util.Function
            public Boolean apply(Class cls) {
                return Boolean.valueOf(Clob.class.isAssignableFrom(cls));
            }
        };
        castToSqlDateFunction = new Function<Object, Object>() { // from class: com.alibaba.fastjson.util.TypeUtils.2
            @Override // com.alibaba.fastjson.util.Function
            public Object apply(Object obj) {
                long jLongValue;
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Date) {
                    return (Date) obj;
                }
                if (obj instanceof java.util.Date) {
                    return new Date(((java.util.Date) obj).getTime());
                }
                if (obj instanceof Calendar) {
                    return new Date(((Calendar) obj).getTimeInMillis());
                }
                if (obj instanceof BigDecimal) {
                    jLongValue = TypeUtils.longValue((BigDecimal) obj);
                } else {
                    jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
                }
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                        return null;
                    }
                    if (TypeUtils.isNumber(str)) {
                        jLongValue = Long.parseLong(str);
                    } else {
                        JSONScanner jSONScanner = new JSONScanner(str);
                        if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                            throw new JSONException("can not cast to Timestamp, value : ".concat(str));
                        }
                        jLongValue = jSONScanner.getCalendar().getTime().getTime();
                    }
                }
                if (jLongValue > 0) {
                    return new Date(jLongValue);
                }
                throw new JSONException(e.k(obj, "can not cast to Date, value : "));
            }
        };
        castToSqlTimeFunction = new Function<Object, Object>() { // from class: com.alibaba.fastjson.util.TypeUtils.3
            @Override // com.alibaba.fastjson.util.Function
            public Object apply(Object obj) {
                long jLongValue;
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Time) {
                    return (Time) obj;
                }
                if (obj instanceof java.util.Date) {
                    return new Time(((java.util.Date) obj).getTime());
                }
                if (obj instanceof Calendar) {
                    return new Time(((Calendar) obj).getTimeInMillis());
                }
                if (obj instanceof BigDecimal) {
                    jLongValue = TypeUtils.longValue((BigDecimal) obj);
                } else {
                    jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
                }
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (str.length() == 0 || "null".equalsIgnoreCase(str)) {
                        return null;
                    }
                    if (TypeUtils.isNumber(str)) {
                        jLongValue = Long.parseLong(str);
                    } else {
                        if (str.length() == 8 && str.charAt(2) == ':' && str.charAt(5) == ':') {
                            return Time.valueOf(str);
                        }
                        JSONScanner jSONScanner = new JSONScanner(str);
                        if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                            throw new JSONException("can not cast to Timestamp, value : ".concat(str));
                        }
                        jLongValue = jSONScanner.getCalendar().getTime().getTime();
                    }
                }
                if (jLongValue > 0) {
                    return new Time(jLongValue);
                }
                throw new JSONException(e.k(obj, "can not cast to Date, value : "));
            }
        };
        castToTimestampFunction = new Function<Object, Object>() { // from class: com.alibaba.fastjson.util.TypeUtils.4
            @Override // com.alibaba.fastjson.util.Function
            public Object apply(Object obj) {
                long jLongValue;
                if (obj == null) {
                    return null;
                }
                if (obj instanceof Calendar) {
                    return new Timestamp(((Calendar) obj).getTimeInMillis());
                }
                if (obj instanceof Timestamp) {
                    return (Timestamp) obj;
                }
                if (obj instanceof java.util.Date) {
                    return new Timestamp(((java.util.Date) obj).getTime());
                }
                if (obj instanceof BigDecimal) {
                    jLongValue = TypeUtils.longValue((BigDecimal) obj);
                } else {
                    jLongValue = obj instanceof Number ? ((Number) obj).longValue() : 0L;
                }
                if (obj instanceof String) {
                    String strH = (String) obj;
                    if (strH.length() == 0 || "null".equals(strH) || "NULL".equals(strH)) {
                        return null;
                    }
                    if (strH.endsWith(".000000000")) {
                        strH = a.h(10, 0, strH);
                    } else if (strH.endsWith(".000000")) {
                        strH = a.h(7, 0, strH);
                    }
                    if (strH.length() == 29 && strH.charAt(4) == '-' && strH.charAt(7) == '-' && strH.charAt(10) == ' ' && strH.charAt(13) == ':' && strH.charAt(16) == ':' && strH.charAt(19) == '.') {
                        return new Timestamp(TypeUtils.num(strH.charAt(0), strH.charAt(1), strH.charAt(2), strH.charAt(3)) - 1900, TypeUtils.num(strH.charAt(5), strH.charAt(6)) - 1, TypeUtils.num(strH.charAt(8), strH.charAt(9)), TypeUtils.num(strH.charAt(11), strH.charAt(12)), TypeUtils.num(strH.charAt(14), strH.charAt(15)), TypeUtils.num(strH.charAt(17), strH.charAt(18)), TypeUtils.num(strH.charAt(20), strH.charAt(21), strH.charAt(22), strH.charAt(23), strH.charAt(24), strH.charAt(25), strH.charAt(26), strH.charAt(27), strH.charAt(28)));
                    }
                    if (TypeUtils.isNumber(strH)) {
                        jLongValue = Long.parseLong(strH);
                    } else {
                        JSONScanner jSONScanner = new JSONScanner(strH);
                        if (!jSONScanner.scanISO8601DateIfMatch(false)) {
                            throw new JSONException("can not cast to Timestamp, value : ".concat(strH));
                        }
                        jLongValue = jSONScanner.getCalendar().getTime().getTime();
                    }
                }
                return new Timestamp(jLongValue);
            }
        };
        castFunction = new BiFunction<Object, Class, Object>() { // from class: com.alibaba.fastjson.util.TypeUtils.5
            @Override // com.alibaba.fastjson.util.BiFunction
            public Object apply(Object obj, Class cls) {
                if (cls == Date.class) {
                    return TypeUtils.castToSqlDate(obj);
                }
                if (cls == Time.class) {
                    return TypeUtils.castToSqlTime(obj);
                }
                if (cls == Timestamp.class) {
                    return TypeUtils.castToTimestamp(obj);
                }
                return null;
            }
        };
        addBaseClassMappingsFunction = new Function<Map<String, Class<?>>, Void>() { // from class: com.alibaba.fastjson.util.TypeUtils.6
            @Override // com.alibaba.fastjson.util.Function
            public Void apply(Map<String, Class<?>> map) {
                Class<?>[] clsArr = {Time.class, Date.class, Timestamp.class};
                for (int i9 = 0; i9 < 3; i9++) {
                    Class<?> cls = clsArr[i9];
                    if (cls != null) {
                        map.put(cls.getName(), cls);
                    }
                }
                return null;
            }
        };
        addBaseClassMappings();
        primitiveTypeMap = new HashMap<Class, String>(8) { // from class: com.alibaba.fastjson.util.TypeUtils.7
            {
                put(Boolean.TYPE, "Z");
                put(Character.TYPE, "C");
                put(Byte.TYPE, "B");
                put(Short.TYPE, "S");
                put(Integer.TYPE, "I");
                put(Long.TYPE, "J");
                put(Float.TYPE, "F");
                put(Double.TYPE, "D");
            }
        };
        isProxyClassNames = new HashSet<String>(6) { // from class: com.alibaba.fastjson.util.TypeUtils.8
            {
                add("net.sf.cglib.proxy.Factory");
                add("org.springframework.cglib.proxy.Factory");
                add("javassist.util.proxy.ProxyObject");
                add("org.apache.ibatis.javassist.util.proxy.ProxyObject");
                add("org.hibernate.proxy.HibernateProxy");
                add("org.springframework.context.annotation.ConfigurationClassEnhancer$EnhancedConfiguration");
            }
        };
        OPTIONAL_ERROR = false;
    }

    private static void addBaseClassMappings() {
        mappings.put("byte", Byte.TYPE);
        mappings.put("short", Short.TYPE);
        mappings.put("int", Integer.TYPE);
        mappings.put("long", Long.TYPE);
        mappings.put("float", Float.TYPE);
        mappings.put("double", Double.TYPE);
        mappings.put("boolean", Boolean.TYPE);
        mappings.put("char", Character.TYPE);
        mappings.put("[byte", byte[].class);
        mappings.put("[short", short[].class);
        mappings.put("[int", int[].class);
        mappings.put("[long", long[].class);
        mappings.put("[float", float[].class);
        mappings.put("[double", double[].class);
        mappings.put("[boolean", boolean[].class);
        mappings.put("[char", char[].class);
        mappings.put("[B", byte[].class);
        mappings.put("[S", short[].class);
        mappings.put("[I", int[].class);
        mappings.put("[J", long[].class);
        mappings.put("[F", float[].class);
        mappings.put("[D", double[].class);
        mappings.put("[C", char[].class);
        mappings.put("[Z", boolean[].class);
        Class<?>[] clsArr = {Object.class, Cloneable.class, loadClass("java.lang.AutoCloseable"), Exception.class, RuntimeException.class, IllegalAccessError.class, IllegalAccessException.class, IllegalArgumentException.class, IllegalMonitorStateException.class, IllegalStateException.class, IllegalThreadStateException.class, IndexOutOfBoundsException.class, InstantiationError.class, InstantiationException.class, InternalError.class, InterruptedException.class, LinkageError.class, NegativeArraySizeException.class, NoClassDefFoundError.class, NoSuchFieldError.class, NoSuchFieldException.class, NoSuchMethodError.class, NoSuchMethodException.class, NullPointerException.class, NumberFormatException.class, OutOfMemoryError.class, SecurityException.class, StackOverflowError.class, StringIndexOutOfBoundsException.class, TypeNotPresentException.class, VerifyError.class, StackTraceElement.class, HashMap.class, LinkedHashMap.class, Hashtable.class, TreeMap.class, java.util.IdentityHashMap.class, WeakHashMap.class, LinkedHashMap.class, HashSet.class, LinkedHashSet.class, TreeSet.class, ArrayList.class, TimeUnit.class, ConcurrentHashMap.class, AtomicInteger.class, AtomicLong.class, Collections.EMPTY_MAP.getClass(), Boolean.class, Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class, Number.class, String.class, BigDecimal.class, BigInteger.class, BitSet.class, Calendar.class, java.util.Date.class, Locale.class, UUID.class, SimpleDateFormat.class, JSONObject.class, JSONPObject.class, JSONArray.class};
        for (int i9 = 0; i9 < 69; i9++) {
            Class<?> cls = clsArr[i9];
            if (cls != null) {
                mappings.put(cls.getName(), cls);
            }
        }
        ModuleUtil.callWhenHasJavaSql(addBaseClassMappingsFunction, mappings);
    }

    public static void addMapping(String str, Class<?> cls) {
        mappings.put(str, cls);
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy) {
        return buildBeanInfo(cls, map, propertyNamingStrategy, false);
    }

    public static byte byteValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (byte) 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.byteValueExact() : bigDecimal.byteValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Class<T> cls, ParserConfig parserConfig) {
        Object obj2;
        Class<T> cls2 = Boolean.TYPE;
        Class<T> cls3 = Double.TYPE;
        Class<T> cls4 = Float.TYPE;
        Class<T> cls5 = Byte.TYPE;
        Class<T> cls6 = Short.TYPE;
        Class<T> cls7 = Long.TYPE;
        Class<T> cls8 = Integer.TYPE;
        int i9 = 0;
        if (obj == 0) {
            if (cls == cls8) {
                return (T) 0;
            }
            if (cls == cls7) {
                return (T) 0L;
            }
            if (cls == cls6) {
                return (T) (short) 0;
            }
            if (cls == cls5) {
                return (T) (byte) 0;
            }
            if (cls == cls4) {
                return (T) Float.valueOf(0.0f);
            }
            if (cls == cls3) {
                return (T) Double.valueOf(0.0d);
            }
            if (cls == cls2) {
                return (T) Boolean.FALSE;
            }
            return null;
        }
        if (cls == null) {
            throw new IllegalArgumentException("clazz is null");
        }
        if (cls != obj.getClass()) {
            if (!(obj instanceof Map)) {
                if (cls.isArray()) {
                    if (obj instanceof Collection) {
                        Collection collection = (Collection) obj;
                        T t = (T) Array.newInstance(cls.getComponentType(), collection.size());
                        Iterator it = collection.iterator();
                        while (it.hasNext()) {
                            Array.set(t, i9, cast(it.next(), (Class) cls.getComponentType(), parserConfig));
                            i9++;
                        }
                        return t;
                    }
                    if (cls == byte[].class) {
                        return (T) castToBytes(obj);
                    }
                }
                if (!cls.isAssignableFrom(obj.getClass())) {
                    if (cls == cls2 || cls == Boolean.class) {
                        return (T) castToBoolean(obj);
                    }
                    if (cls == cls5 || cls == Byte.class) {
                        return (T) castToByte(obj);
                    }
                    if (cls == Character.TYPE || cls == Character.class) {
                        return (T) castToChar(obj);
                    }
                    if (cls == cls6 || cls == Short.class) {
                        return (T) castToShort(obj);
                    }
                    if (cls == cls8 || cls == Integer.class) {
                        return (T) castToInt(obj);
                    }
                    if (cls == cls7 || cls == Long.class) {
                        return (T) castToLong(obj);
                    }
                    if (cls == cls4 || cls == Float.class) {
                        return (T) castToFloat(obj);
                    }
                    if (cls == cls3 || cls == Double.class) {
                        return (T) castToDouble(obj);
                    }
                    if (cls == String.class) {
                        return (T) castToString(obj);
                    }
                    if (cls == BigDecimal.class) {
                        return (T) castToBigDecimal(obj);
                    }
                    if (cls == BigInteger.class) {
                        return (T) castToBigInteger(obj);
                    }
                    if (cls == java.util.Date.class) {
                        return (T) castToDate(obj);
                    }
                    T t6 = (T) ModuleUtil.callWhenHasJavaSql(castFunction, obj, cls);
                    if (t6 != null) {
                        return t6;
                    }
                    if (cls.isEnum()) {
                        return (T) castToEnum(obj, cls, parserConfig);
                    }
                    if (Calendar.class.isAssignableFrom(cls)) {
                        java.util.Date dateCastToDate = castToDate(obj);
                        if (cls == Calendar.class) {
                            obj2 = (T) Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                        } else {
                            try {
                                obj2 = (T) ((Calendar) cls.newInstance());
                            } catch (Exception e9) {
                                throw new JSONException("can not cast to : ".concat(cls.getName()), e9);
                            }
                        }
                        ((Calendar) obj2).setTime(dateCastToDate);
                        return (T) obj2;
                    }
                    String name = cls.getName();
                    if (name.equals("javax.xml.datatype.XMLGregorianCalendar")) {
                        java.util.Date dateCastToDate2 = castToDate(obj);
                        Calendar calendar = Calendar.getInstance(JSON.defaultTimeZone, JSON.defaultLocale);
                        calendar.setTime(dateCastToDate2);
                        return (T) CalendarCodec.instance.createXMLGregorianCalendar(calendar);
                    }
                    if (obj instanceof String) {
                        String str = (String) obj;
                        if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                            return null;
                        }
                        if (cls == Currency.class) {
                            return (T) Currency.getInstance(str);
                        }
                        if (cls == Locale.class) {
                            return (T) toLocale(str);
                        }
                        if (name.startsWith("java.time.")) {
                            return (T) JSON.parseObject(JSON.toJSONString(str), cls);
                        }
                    }
                    if (parserConfig.get(cls) != null) {
                        return (T) JSON.parseObject(JSON.toJSONString(obj), cls);
                    }
                    throw new JSONException("can not cast to : ".concat(cls.getName()));
                }
            } else if (cls != Map.class) {
                Map map = (Map) obj;
                if (cls != Object.class || map.containsKey(JSON.DEFAULT_TYPE_KEY)) {
                    return (T) castToJavaBean(map, cls, parserConfig);
                }
            }
        }
        return obj;
    }

    public static BigDecimal castToBigDecimal(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Float) {
            Float f6 = (Float) obj;
            if (Float.isNaN(f6.floatValue()) || Float.isInfinite(f6.floatValue())) {
                return null;
            }
        } else if (obj instanceof Double) {
            Double d9 = (Double) obj;
            if (Double.isNaN(d9.doubleValue()) || Double.isInfinite(d9.doubleValue())) {
                return null;
            }
        } else {
            if (obj instanceof BigDecimal) {
                return (BigDecimal) obj;
            }
            if (obj instanceof BigInteger) {
                return new BigDecimal((BigInteger) obj);
            }
            if ((obj instanceof Map) && ((Map) obj).size() == 0) {
                return null;
            }
        }
        String string = obj.toString();
        if (string.length() == 0 || string.equalsIgnoreCase("null")) {
            return null;
        }
        if (string.length() <= 65535) {
            return new BigDecimal(string);
        }
        throw new JSONException("decimal overflow");
    }

    public static BigInteger castToBigInteger(Object obj) {
        BigDecimal bigDecimal;
        int iScale;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Float) {
            Float f6 = (Float) obj;
            if (Float.isNaN(f6.floatValue()) || Float.isInfinite(f6.floatValue())) {
                return null;
            }
            return BigInteger.valueOf(f6.longValue());
        }
        if (obj instanceof Double) {
            Double d9 = (Double) obj;
            if (Double.isNaN(d9.doubleValue()) || Double.isInfinite(d9.doubleValue())) {
                return null;
            }
            return BigInteger.valueOf(d9.longValue());
        }
        if (obj instanceof BigInteger) {
            return (BigInteger) obj;
        }
        if ((obj instanceof BigDecimal) && (iScale = (bigDecimal = (BigDecimal) obj).scale()) > -1000 && iScale < 1000) {
            return bigDecimal.toBigInteger();
        }
        String string = obj.toString();
        if (string.length() == 0 || string.equalsIgnoreCase("null")) {
            return null;
        }
        if (string.length() <= 65535) {
            return new BigInteger(string);
        }
        throw new JSONException("decimal overflow");
    }

    public static Boolean castToBoolean(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof BigDecimal) {
            return Boolean.valueOf(intValue((BigDecimal) obj) == 1);
        }
        if (obj instanceof Number) {
            return Boolean.valueOf(((Number) obj).intValue() == 1);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
            if ("true".equalsIgnoreCase(str) || "1".equals(str)) {
                return Boolean.TRUE;
            }
            if ("false".equalsIgnoreCase(str) || "0".equals(str)) {
                return Boolean.FALSE;
            }
            if ("Y".equalsIgnoreCase(str) || "T".equals(str)) {
                return Boolean.TRUE;
            }
            if ("F".equalsIgnoreCase(str) || "N".equals(str)) {
                return Boolean.FALSE;
            }
        }
        throw new JSONException(e.k(obj, "can not cast to boolean, value : "));
    }

    public static Byte castToByte(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Byte.valueOf(byteValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Byte.valueOf(((Number) obj).byteValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Byte.valueOf(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
            }
            throw new JSONException(e.k(obj, "can not cast to byte, value : "));
        }
        String str = (String) obj;
        if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
            return null;
        }
        return Byte.valueOf(Byte.parseByte(str));
    }

    public static byte[] castToBytes(Object obj) {
        if (obj instanceof byte[]) {
            return (byte[]) obj;
        }
        if (obj instanceof String) {
            return IOUtils.decodeBase64((String) obj);
        }
        throw new JSONException(e.k(obj, "can not cast to byte[], value : "));
    }

    public static Character castToChar(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Character) {
            return (Character) obj;
        }
        if (!(obj instanceof String)) {
            throw new JSONException(e.k(obj, "can not cast to char, value : "));
        }
        String str = (String) obj;
        if (str.length() == 0) {
            return null;
        }
        if (str.length() == 1) {
            return Character.valueOf(str.charAt(0));
        }
        throw new JSONException(e.k(obj, "can not cast to char, value : "));
    }

    public static java.util.Date castToDate(Object obj) {
        return castToDate(obj, null);
    }

    public static Double castToDouble(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Double.valueOf(((Number) obj).doubleValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Double.valueOf(((Boolean) obj).booleanValue() ? 1.0d : 0.0d);
            }
            throw new JSONException(e.k(obj, "can not cast to double, value : "));
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != -1) {
            string = string.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
        }
        return Double.valueOf(Double.parseDouble(string));
    }

    public static <T> T castToEnum(Object obj, Class<T> cls, ParserConfig parserConfig) {
        try {
            if (obj instanceof String) {
                String str = (String) obj;
                if (str.length() == 0) {
                    return null;
                }
                if (parserConfig == null) {
                    parserConfig = ParserConfig.getGlobalInstance();
                }
                ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
                return deserializer instanceof EnumDeserializer ? (T) ((EnumDeserializer) deserializer).getEnumByHashCode(fnv1a_64(str)) : (T) Enum.valueOf(cls, str);
            }
            if (obj instanceof BigDecimal) {
                int iIntValue = intValue((BigDecimal) obj);
                T[] enumConstants = cls.getEnumConstants();
                if (iIntValue < enumConstants.length) {
                    return enumConstants[iIntValue];
                }
            }
            if (obj instanceof Number) {
                int iIntValue2 = ((Number) obj).intValue();
                T[] enumConstants2 = cls.getEnumConstants();
                if (iIntValue2 < enumConstants2.length) {
                    return enumConstants2[iIntValue2];
                }
            }
            throw new JSONException("can not cast to : ".concat(cls.getName()));
        } catch (Exception e9) {
            throw new JSONException("can not cast to : ".concat(cls.getName()), e9);
        }
    }

    public static Float castToFloat(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Number) {
            return Float.valueOf(((Number) obj).floatValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Float.valueOf(((Boolean) obj).booleanValue() ? 1.0f : 0.0f);
            }
            throw new JSONException(e.k(obj, "can not cast to float, value : "));
        }
        String string = obj.toString();
        if (string.length() == 0 || "null".equals(string) || "NULL".equals(string)) {
            return null;
        }
        if (string.indexOf(44) != -1) {
            string = string.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
        }
        return Float.valueOf(Float.parseFloat(string));
    }

    public static Integer castToInt(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        if (obj instanceof BigDecimal) {
            return Integer.valueOf(intValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Integer.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != -1) {
                strReplaceAll = strReplaceAll.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
            }
            Matcher matcher = NUMBER_WITH_TRAILING_ZEROS_PATTERN.matcher(strReplaceAll);
            if (matcher.find()) {
                strReplaceAll = matcher.replaceAll("");
            }
            return Integer.valueOf(Integer.parseInt(strReplaceAll));
        }
        if (obj instanceof Boolean) {
            return Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return castToInt(it.next());
            }
        }
        throw new JSONException(e.k(obj, "can not cast to int, value : "));
    }

    public static <T> T castToJavaBean(Object obj, Class<T> cls) {
        return (T) cast(obj, (Class) cls, ParserConfig.getGlobalInstance());
    }

    public static Long castToLong(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Long.valueOf(longValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Long.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            String strReplaceAll = (String) obj;
            if (strReplaceAll.length() == 0 || "null".equals(strReplaceAll) || "NULL".equals(strReplaceAll)) {
                return null;
            }
            if (strReplaceAll.indexOf(44) != -1) {
                strReplaceAll = strReplaceAll.replaceAll(Constants.ACCEPT_TIME_SEPARATOR_SP, "");
            }
            try {
                return Long.valueOf(Long.parseLong(strReplaceAll));
            } catch (NumberFormatException unused) {
                JSONScanner jSONScanner = new JSONScanner(strReplaceAll);
                Calendar calendar = jSONScanner.scanISO8601DateIfMatch(false) ? jSONScanner.getCalendar() : null;
                jSONScanner.close();
                if (calendar != null) {
                    return Long.valueOf(calendar.getTimeInMillis());
                }
            }
        }
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (map.size() == 2 && map.containsKey("andIncrement") && map.containsKey("andDecrement")) {
                Iterator it = map.values().iterator();
                it.next();
                return castToLong(it.next());
            }
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        throw new JSONException(e.k(obj, "can not cast to long, value : "));
    }

    public static Short castToShort(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof BigDecimal) {
            return Short.valueOf(shortValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            return Short.valueOf(((Number) obj).shortValue());
        }
        if (!(obj instanceof String)) {
            if (obj instanceof Boolean) {
                return Short.valueOf(((Boolean) obj).booleanValue() ? (short) 1 : (short) 0);
            }
            throw new JSONException(e.k(obj, "can not cast to short, value : "));
        }
        String str = (String) obj;
        if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
            return null;
        }
        return Short.valueOf(Short.parseShort(str));
    }

    public static Object castToSqlDate(Object obj) {
        return ModuleUtil.callWhenHasJavaSql(castToSqlDateFunction, obj);
    }

    public static Object castToSqlTime(Object obj) {
        return ModuleUtil.callWhenHasJavaSql(castToSqlTimeFunction, obj);
    }

    public static String castToString(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public static Object castToTimestamp(Object obj) {
        return ModuleUtil.callWhenHasJavaSql(castToTimestampFunction, obj);
    }

    public static Type checkPrimitiveArray(GenericArrayType genericArrayType) {
        Type genericComponentType = genericArrayType.getGenericComponentType();
        String strU = "[";
        while (genericComponentType instanceof GenericArrayType) {
            genericComponentType = ((GenericArrayType) genericComponentType).getGenericComponentType();
            strU = e.u(strU, strU);
        }
        if (!(genericComponentType instanceof Class)) {
            return genericArrayType;
        }
        Class cls = (Class) genericComponentType;
        if (!cls.isPrimitive()) {
            return genericArrayType;
        }
        try {
            String str = (String) primitiveTypeMap.get(cls);
            if (str == null) {
                return genericArrayType;
            }
            return Class.forName(strU + str);
        } catch (ClassNotFoundException unused) {
            return genericArrayType;
        }
    }

    public static void clearClassMapping() {
        mappings.clear();
        addBaseClassMappings();
    }

    private static void computeFields(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, Map<String, FieldInfo> map2, Field[] fieldArr) {
        int i9;
        int i10;
        int i11;
        String strLabel;
        for (Field field : fieldArr) {
            if (!Modifier.isStatic(field.getModifiers())) {
                JSONField jSONField = (JSONField) getAnnotation(field, JSONField.class);
                String name = field.getName();
                if (jSONField == null) {
                    i9 = 0;
                    i10 = 0;
                    i11 = 0;
                    strLabel = null;
                } else if (jSONField.serialize()) {
                    int iOrdinal = jSONField.ordinal();
                    int iOf = SerializerFeature.of(jSONField.serialzeFeatures());
                    int iOf2 = Feature.of(jSONField.parseFeatures());
                    if (jSONField.name().length() != 0) {
                        name = jSONField.name();
                    }
                    strLabel = jSONField.label().length() != 0 ? jSONField.label() : null;
                    i9 = iOrdinal;
                    i10 = iOf;
                    i11 = iOf2;
                }
                if (map == null || (name = map.get(name)) != null) {
                    if (propertyNamingStrategy != null) {
                        name = propertyNamingStrategy.translate(name);
                    }
                    String str = name;
                    if (!map2.containsKey(str)) {
                        map2.put(str, new FieldInfo(str, null, field, cls, null, i9, i10, i11, null, jSONField, strLabel));
                    }
                }
            }
        }
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map) {
        return computeGetters(cls, map, true);
    }

    public static List<FieldInfo> computeGettersWithFieldBase(Class<?> cls, Map<String, String> map, boolean z8, PropertyNamingStrategy propertyNamingStrategy) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            computeFields(superclass, map, propertyNamingStrategy, linkedHashMap, superclass.getDeclaredFields());
        }
        return getFieldInfos(cls, z8, linkedHashMap);
    }

    private static Map<TypeVariable, Type> createActualTypeMap(TypeVariable[] typeVariableArr, Type[] typeArr) {
        int length = typeVariableArr.length;
        HashMap map = new HashMap(length);
        for (int i9 = 0; i9 < length; i9++) {
            map.put(typeVariableArr[i9], typeArr[i9]);
        }
        return map;
    }

    public static Collection createCollection(Type type) {
        Class<?> cls;
        Class<?> rawClass = getRawClass(type);
        if (rawClass == AbstractCollection.class || rawClass == Collection.class) {
            return new ArrayList();
        }
        if (rawClass.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (rawClass.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (rawClass.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (rawClass.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if (rawClass.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        if (rawClass.isAssignableFrom(Queue.class) || ((cls = class_deque) != null && rawClass.isAssignableFrom(cls))) {
            return new LinkedList();
        }
        try {
            return (Collection) rawClass.newInstance();
        } catch (Exception unused) {
            throw new JSONException("create instance error, class ".concat(rawClass.getName()));
        }
    }

    public static Set createSet(Type type) {
        Class<?> rawClass = getRawClass(type);
        if (rawClass == AbstractCollection.class || rawClass == Collection.class) {
            return new HashSet();
        }
        if (rawClass.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (rawClass.isAssignableFrom(LinkedHashSet.class)) {
            return new LinkedHashSet();
        }
        if (rawClass.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        if (rawClass.isAssignableFrom(EnumSet.class)) {
            return EnumSet.noneOf((Class) (type instanceof ParameterizedType ? ((ParameterizedType) type).getActualTypeArguments()[0] : Object.class));
        }
        try {
            return (Set) rawClass.newInstance();
        } catch (Exception unused) {
            throw new JSONException("create instance error, class ".concat(rawClass.getName()));
        }
    }

    public static String decapitalize(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() > 1 && Character.isUpperCase(str.charAt(1)) && Character.isUpperCase(str.charAt(0))) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toLowerCase(charArray[0]);
        return new String(charArray);
    }

    public static long fnv1a_64(String str) {
        long jCharAt = fnv1a_64_magic_hashcode;
        for (int i9 = 0; i9 < str.length(); i9++) {
            jCharAt = (jCharAt ^ ((long) str.charAt(i9))) * fnv1a_64_magic_prime;
        }
        return jCharAt;
    }

    public static long fnv1a_64_extract(String str) {
        long j = fnv1a_64_magic_hashcode;
        for (int i9 = 0; i9 < str.length(); i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt != '_' && cCharAt != '-') {
                if (cCharAt >= 'A' && cCharAt <= 'Z') {
                    cCharAt = (char) (cCharAt + ' ');
                }
                j = (j ^ ((long) cCharAt)) * fnv1a_64_magic_prime;
            }
        }
        return j;
    }

    public static long fnv1a_64_lower(String str) {
        long j = fnv1a_64_magic_hashcode;
        for (int i9 = 0; i9 < str.length(); i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt >= 'A' && cCharAt <= 'Z') {
                cCharAt = (char) (cCharAt + ' ');
            }
            j = (j ^ ((long) cCharAt)) * fnv1a_64_magic_prime;
        }
        return j;
    }

    private static Type getActualType(Type type, Map<TypeVariable, Type> map) {
        if (type instanceof TypeVariable) {
            return map.get(type);
        }
        if (type instanceof ParameterizedType) {
            return makeParameterizedType(getRawClass(type), ((ParameterizedType) type).getActualTypeArguments(), map);
        }
        return type instanceof GenericArrayType ? new GenericArrayTypeImpl(getActualType(((GenericArrayType) type).getGenericComponentType(), map)) : type;
    }

    public static <A extends Annotation> A getAnnotation(Class<?> cls, Class<A> cls2) {
        A a3 = (A) cls.getAnnotation(cls2);
        Type mixInAnnotations = JSON.getMixInAnnotations(cls);
        Class cls3 = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls3 != null) {
            A a9 = (A) cls3.getAnnotation(cls2);
            Annotation[] annotations = cls3.getAnnotations();
            if (a9 == null && annotations.length > 0) {
                for (Annotation annotation : annotations) {
                    a9 = (A) annotation.annotationType().getAnnotation(cls2);
                    if (a9 != null) {
                        break;
                    }
                }
            }
            if (a9 != null) {
                return a9;
            }
        }
        Annotation[] annotations2 = cls.getAnnotations();
        if (a3 == null && annotations2.length > 0) {
            for (Annotation annotation2 : annotations2) {
                a3 = (A) annotation2.annotationType().getAnnotation(cls2);
                if (a3 != null) {
                    return a3;
                }
            }
        }
        return a3;
    }

    public static Class<?> getClass(Type type) {
        if (type.getClass() == Class.class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getClass(((ParameterizedType) type).getRawType());
        }
        if (type instanceof TypeVariable) {
            Type type2 = ((TypeVariable) type).getBounds()[0];
            return type2 instanceof Class ? (Class) type2 : getClass(type2);
        }
        if (!(type instanceof WildcardType)) {
            return Object.class;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length == 1 ? getClass(upperBounds[0]) : Object.class;
    }

    public static Class<?> getClassFromMapping(String str) {
        return mappings.get(str);
    }

    public static Class<?> getCollectionItemClass(Type type) {
        if (!(type instanceof ParameterizedType)) {
            return Object.class;
        }
        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
        if (type2 instanceof WildcardType) {
            Type[] upperBounds = ((WildcardType) type2).getUpperBounds();
            if (upperBounds.length == 1) {
                type2 = upperBounds[0];
            }
        }
        if (!(type2 instanceof Class)) {
            throw new JSONException("can not create ASMParser");
        }
        Class<?> cls = (Class) type2;
        if (Modifier.isPublic(cls.getModifiers())) {
            return cls;
        }
        throw new JSONException("can not create ASMParser");
    }

    public static Type getCollectionItemType(Type type) {
        if (type instanceof ParameterizedType) {
            return getCollectionItemType((ParameterizedType) type);
        }
        return type instanceof Class ? getCollectionItemType((Class<?>) type) : Object.class;
    }

    private static Type getCollectionSuperType(Class<?> cls) {
        Type type = null;
        for (Type type2 : cls.getGenericInterfaces()) {
            Class<?> rawClass = getRawClass(type2);
            if (rawClass == Collection.class) {
                return type2;
            }
            if (Collection.class.isAssignableFrom(rawClass)) {
                type = type2;
            }
        }
        return type == null ? cls.getGenericSuperclass() : type;
    }

    public static Field getField(Class<?> cls, String str, Field[] fieldArr) {
        char cCharAt;
        char cCharAt2;
        for (Field field : fieldArr) {
            String name = field.getName();
            if (str.equals(name) || (str.length() > 2 && (cCharAt = str.charAt(0)) >= 'a' && cCharAt <= 'z' && (cCharAt2 = str.charAt(1)) >= 'A' && cCharAt2 <= 'Z' && str.equalsIgnoreCase(name))) {
                return field;
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass == null || superclass == Object.class) {
            return null;
        }
        return getField(superclass, str, superclass.getDeclaredFields());
    }

    private static List<FieldInfo> getFieldInfos(Class<?> cls, boolean z8, Map<String, FieldInfo> map) {
        ArrayList arrayList = new ArrayList();
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        String[] strArrOrders = jSONType != null ? jSONType.orders() : null;
        if (strArrOrders == null || strArrOrders.length <= 0) {
            arrayList.addAll(map.values());
            if (z8) {
                Collections.sort(arrayList);
            }
            return arrayList;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
        for (FieldInfo fieldInfo : map.values()) {
            linkedHashMap.put(fieldInfo.name, fieldInfo);
        }
        for (String str : strArrOrders) {
            FieldInfo fieldInfo2 = (FieldInfo) linkedHashMap.get(str);
            if (fieldInfo2 != null) {
                arrayList.add(fieldInfo2);
                linkedHashMap.remove(str);
            }
        }
        arrayList.addAll(linkedHashMap.values());
        return arrayList;
    }

    public static Type getGenericParamType(Type type) {
        return (!(type instanceof ParameterizedType) && (type instanceof Class)) ? getGenericParamType(((Class) type).getGenericSuperclass()) : type;
    }

    public static String[] getKoltinConstructorParameters(Class cls) {
        if (kotlin_kclass_constructor == null && !kotlin_class_klass_error) {
            try {
                kotlin_kclass_constructor = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getConstructor(Class.class);
            } catch (Throwable unused) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kclass_constructor == null) {
            return null;
        }
        if (kotlin_kclass_getConstructors == null && !kotlin_class_klass_error) {
            try {
                kotlin_kclass_getConstructors = Class.forName("kotlin.reflect.jvm.internal.KClassImpl").getMethod("getConstructors", new Class[0]);
            } catch (Throwable unused2) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kfunction_getParameters == null && !kotlin_class_klass_error) {
            try {
                kotlin_kfunction_getParameters = P7.e.class.getMethod("getParameters", new Class[0]);
            } catch (Throwable unused3) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_kparameter_getName == null && !kotlin_class_klass_error) {
            try {
                kotlin_kparameter_getName = h.class.getMethod("getName", new Class[0]);
            } catch (Throwable unused4) {
                kotlin_class_klass_error = true;
            }
        }
        if (kotlin_error) {
            return null;
        }
        try {
            Iterator it = ((Iterable) kotlin_kclass_getConstructors.invoke(kotlin_kclass_constructor.newInstance(cls), new Object[0])).iterator();
            Object obj = null;
            while (it.hasNext()) {
                Object next = it.next();
                List list = (List) kotlin_kfunction_getParameters.invoke(next, new Object[0]);
                if (obj == null || list.size() != 0) {
                    obj = next;
                }
                it.hasNext();
            }
            if (obj == null) {
                return null;
            }
            List list2 = (List) kotlin_kfunction_getParameters.invoke(obj, new Object[0]);
            String[] strArr = new String[list2.size()];
            for (int i9 = 0; i9 < list2.size(); i9++) {
                strArr[i9] = (String) kotlin_kparameter_getName.invoke(list2.get(i9), new Object[0]);
            }
            return strArr;
        } catch (Throwable th) {
            th.printStackTrace();
            kotlin_error = true;
            return null;
        }
    }

    public static Constructor getKotlinConstructor(Constructor[] constructorArr) {
        return getKotlinConstructor(constructorArr, null);
    }

    public static Annotation[][] getParameterAnnotations(Method method) {
        Annotation[][] parameterAnnotations;
        Annotation[][] parameterAnnotations2 = method.getParameterAnnotations();
        Type mixInAnnotations = JSON.getMixInAnnotations(method.getDeclaringClass());
        Method declaredMethod = null;
        Class superclass = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (superclass != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredMethod = superclass.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredMethod != null && (parameterAnnotations = declaredMethod.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static int getParserFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return Feature.of(jSONType.parseFeatures());
    }

    private static String getPropertyNameByCompatibleFieldName(Map<String, Field> map, String str, String str2, int i9) {
        if (compatibleWithFieldName && !map.containsKey(str2)) {
            String strSubstring = str.substring(i9);
            if (map.containsKey(strSubstring)) {
                return strSubstring;
            }
        }
        return str2;
    }

    public static String getPropertyNameByMethodName(String str) {
        return Character.toLowerCase(str.charAt(3)) + str.substring(4);
    }

    public static Class<?> getRawClass(Type type) {
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return getRawClass(((ParameterizedType) type).getRawType());
        }
        if (!(type instanceof WildcardType)) {
            throw new JSONException("TODO");
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        if (upperBounds.length == 1) {
            return getRawClass(upperBounds[0]);
        }
        throw new JSONException("TODO");
    }

    public static int getSerializeFeatures(Class<?> cls) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType == null) {
            return 0;
        }
        return SerializerFeature.of(jSONType.serialzeFeatures());
    }

    public static JSONField getSuperMethodAnnotation(Class<?> cls, Method method) {
        Class<?>[] interfaces = cls.getInterfaces();
        if (interfaces.length > 0) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (Class<?> cls2 : interfaces) {
                for (Method method2 : cls2.getMethods()) {
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes2.length == parameterTypes.length && method2.getName().equals(method.getName())) {
                        int i9 = 0;
                        while (true) {
                            if (i9 >= parameterTypes.length) {
                                JSONField jSONField = (JSONField) getAnnotation(method2, JSONField.class);
                                if (jSONField == null) {
                                    break;
                                }
                                return jSONField;
                            }
                            if (!parameterTypes2[i9].equals(parameterTypes[i9])) {
                                break;
                            }
                            i9++;
                        }
                    }
                }
            }
        }
        Class<? super Object> superclass = cls.getSuperclass();
        if (superclass != null && Modifier.isAbstract(superclass.getModifiers())) {
            Class<?>[] parameterTypes3 = method.getParameterTypes();
            for (Method method3 : superclass.getMethods()) {
                Class<?>[] parameterTypes4 = method3.getParameterTypes();
                if (parameterTypes4.length == parameterTypes3.length && method3.getName().equals(method.getName())) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= parameterTypes3.length) {
                            JSONField jSONField2 = (JSONField) getAnnotation(method3, JSONField.class);
                            if (jSONField2 == null) {
                                break;
                            }
                            return jSONField2;
                        }
                        if (!parameterTypes4[i10].equals(parameterTypes3[i10])) {
                            break;
                        }
                        i10++;
                    }
                }
            }
        }
        return null;
    }

    private static Type getWildcardTypeUpperBounds(Type type) {
        if (!(type instanceof WildcardType)) {
            return type;
        }
        Type[] upperBounds = ((WildcardType) type).getUpperBounds();
        return upperBounds.length > 0 ? upperBounds[0] : Object.class;
    }

    public static Annotation getXmlAccessorType(Class cls) {
        if (class_XmlAccessorType == null && !classXmlAccessorType_error) {
            try {
                class_XmlAccessorType = Class.forName("javax.xml.bind.annotation.XmlAccessorType");
            } catch (Throwable unused) {
                classXmlAccessorType_error = true;
            }
        }
        if (class_XmlAccessorType == null) {
            return null;
        }
        return getAnnotation((Class<?>) cls, class_XmlAccessorType);
    }

    public static int intValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.intValueExact() : bigDecimal.intValue();
    }

    public static boolean isAnnotationPresentManyToMany(Method method) {
        if (method == null) {
            return false;
        }
        if (class_ManyToMany == null && !class_ManyToMany_error) {
            try {
                class_ManyToMany = Class.forName("javax.persistence.ManyToMany");
            } catch (Throwable unused) {
                class_ManyToMany_error = true;
            }
        }
        if (class_ManyToMany != null) {
            return method.isAnnotationPresent(class_OneToMany) || method.isAnnotationPresent(class_ManyToMany);
        }
        return false;
    }

    public static boolean isAnnotationPresentOneToMany(Method method) {
        if (method == null) {
            return false;
        }
        if (class_OneToMany == null && !class_OneToMany_error) {
            try {
                class_OneToMany = Class.forName("javax.persistence.OneToMany");
            } catch (Throwable unused) {
                class_OneToMany_error = true;
            }
        }
        Class<? extends Annotation> cls = class_OneToMany;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static boolean isClob(Class cls) {
        Boolean bool = (Boolean) ModuleUtil.callWhenHasJavaSql(isClobFunction, cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static boolean isGenericParamType(Type type) {
        Type genericSuperclass;
        if (type instanceof ParameterizedType) {
            return true;
        }
        return (type instanceof Class) && (genericSuperclass = ((Class) type).getGenericSuperclass()) != Object.class && isGenericParamType(genericSuperclass);
    }

    public static boolean isHibernateInitialized(Object obj) {
        if (obj == null) {
            return false;
        }
        if (method_HibernateIsInitialized == null && !method_HibernateIsInitialized_error) {
            try {
                method_HibernateIsInitialized = Class.forName("org.hibernate.Hibernate").getMethod("isInitialized", Object.class);
            } catch (Throwable unused) {
                method_HibernateIsInitialized_error = true;
            }
        }
        Method method = method_HibernateIsInitialized;
        if (method != null) {
            try {
                return ((Boolean) method.invoke(null, obj)).booleanValue();
            } catch (Throwable unused2) {
            }
        }
        return true;
    }

    private static boolean isJSONTypeIgnore(Class<?> cls, String str) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType != null) {
            String[] strArrIncludes = jSONType.includes();
            if (strArrIncludes.length > 0) {
                for (String str2 : strArrIncludes) {
                    if (str.equals(str2)) {
                        return false;
                    }
                }
                return true;
            }
            for (String str3 : jSONType.ignores()) {
                if (str.equals(str3)) {
                    return true;
                }
            }
        }
        if (cls.getSuperclass() == Object.class || cls.getSuperclass() == null) {
            return false;
        }
        return isJSONTypeIgnore(cls.getSuperclass(), str);
    }

    public static boolean isJacksonCreator(Method method) {
        if (method == null) {
            return false;
        }
        if (class_JacksonCreator == null && !class_JacksonCreator_error) {
            try {
                class_JacksonCreator = Class.forName("com.fasterxml.jackson.annotation.JsonCreator");
            } catch (Throwable unused) {
                class_JacksonCreator_error = true;
            }
        }
        Class<? extends Annotation> cls = class_JacksonCreator;
        return cls != null && method.isAnnotationPresent(cls);
    }

    public static boolean isKotlin(Class cls) {
        if (kotlin_metadata == null && !kotlin_metadata_error) {
            try {
                kotlin_metadata = c.class;
            } catch (Throwable unused) {
                kotlin_metadata_error = true;
            }
        }
        return kotlin_metadata != null && cls.isAnnotationPresent(kotlin_metadata);
    }

    private static boolean isKotlinIgnore(Class cls, String str) {
        if (kotlinIgnores == null && !kotlinIgnores_error) {
            try {
                HashMap map = new HashMap();
                int i9 = O7.c.f3584c;
                map.put(O7.c.class, new String[]{"getEndInclusive", "isEmpty"});
                O7.h hVar = O7.h.f3592d;
                map.put(O7.h.class, new String[]{"getEndInclusive", "isEmpty"});
                map.put(j.class, new String[]{"getEndInclusive", "isEmpty"});
                map.put(O7.e.class, new String[]{"getEndInclusive", "isEmpty"});
                map.put(d.class, new String[]{"getEndInclusive", "isEmpty"});
                kotlinIgnores = map;
            } catch (Throwable unused) {
                kotlinIgnores_error = true;
            }
        }
        if (kotlinIgnores == null) {
            return false;
        }
        String[] strArr = kotlinIgnores.get(cls);
        return strArr != null && Arrays.binarySearch(strArr, str) >= 0;
    }

    public static boolean isNumber(String str) {
        for (int i9 = 0; i9 < str.length(); i9++) {
            char cCharAt = str.charAt(i9);
            if (cCharAt == '+' || cCharAt == '-') {
                if (i9 != 0) {
                    return false;
                }
            } else if (cCharAt < '0' || cCharAt > '9') {
                return false;
            }
        }
        return true;
    }

    public static boolean isPath(Class<?> cls) {
        if (pathClass == null && !pathClass_error) {
            try {
                pathClass = Path.class;
            } catch (Throwable unused) {
                pathClass_error = true;
            }
        }
        Class<?> cls2 = pathClass;
        if (cls2 != null) {
            return cls2.isAssignableFrom(cls);
        }
        return false;
    }

    public static boolean isProxy(Class<?> cls) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (isProxyClassNames.contains(cls2.getName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTransient(Method method) {
        if (method == null) {
            return false;
        }
        if (!transientClassInited) {
            try {
                transientClass = Class.forName("java.beans.Transient");
            } catch (Exception unused) {
            } finally {
                transientClassInited = true;
            }
        }
        Class<? extends Annotation> cls = transientClass;
        return (cls == null || getAnnotation(method, cls) == null) ? false : true;
    }

    public static boolean isXmlField(Class cls) {
        Annotation annotation;
        Object objInvoke;
        if (class_XmlAccessorType == null && !classXmlAccessorType_error) {
            try {
                class_XmlAccessorType = Class.forName("javax.xml.bind.annotation.XmlAccessorType");
            } catch (Throwable unused) {
                classXmlAccessorType_error = true;
            }
        }
        if (class_XmlAccessorType == null || (annotation = getAnnotation((Class<?>) cls, (Class<Annotation>) class_XmlAccessorType)) == null) {
            return false;
        }
        if (method_XmlAccessorType_value == null && !classXmlAccessorType_error) {
            try {
                method_XmlAccessorType_value = class_XmlAccessorType.getMethod("value", new Class[0]);
            } catch (Throwable unused2) {
                classXmlAccessorType_error = true;
            }
        }
        if (method_XmlAccessorType_value == null) {
            return false;
        }
        if (classXmlAccessorType_error) {
            objInvoke = null;
        } else {
            try {
                objInvoke = method_XmlAccessorType_value.invoke(annotation, new Object[0]);
            } catch (Throwable unused3) {
                classXmlAccessorType_error = true;
                objInvoke = null;
            }
        }
        if (objInvoke == null) {
            return false;
        }
        if (class_XmlAccessType == null && !classXmlAccessorType_error) {
            try {
                class_XmlAccessType = Class.forName("javax.xml.bind.annotation.XmlAccessType");
                field_XmlAccessType_FIELD = class_XmlAccessType.getField("FIELD");
                field_XmlAccessType_FIELD_VALUE = field_XmlAccessType_FIELD.get(null);
            } catch (Throwable unused4) {
                classXmlAccessorType_error = true;
            }
        }
        return objInvoke == field_XmlAccessType_FIELD_VALUE;
    }

    public static Class<?> loadClass(String str) {
        return loadClass(str, null);
    }

    public static long longExtractValue(Number number) {
        return number instanceof BigDecimal ? ((BigDecimal) number).longValueExact() : number.longValue();
    }

    public static long longValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return 0L;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.longValueExact() : bigDecimal.longValue();
    }

    private static ParameterizedType makeParameterizedType(Class<?> cls, Type[] typeArr, Map<TypeVariable, Type> map) {
        int length = typeArr.length;
        Type[] typeArr2 = new Type[length];
        for (int i9 = 0; i9 < length; i9++) {
            typeArr2[i9] = getActualType(typeArr[i9], map);
        }
        return new ParameterizedTypeImpl(typeArr2, null, cls);
    }

    public static int num(char c5, char c9) {
        if (c5 < '0' || c5 > '9' || c9 < '0' || c9 > '9') {
            return -1;
        }
        return (c9 - '0') + ((c5 - '0') * 10);
    }

    public static Object optionalEmpty(Type type) {
        Class<?> cls;
        if (OPTIONAL_ERROR || (cls = getClass(type)) == null) {
            return null;
        }
        String name = cls.getName();
        if (!"java.util.Optional".equals(name)) {
            return null;
        }
        if (OPTIONAL_EMPTY == null) {
            try {
                OPTIONAL_EMPTY = Class.forName(name).getMethod("empty", new Class[0]).invoke(null, new Object[0]);
            } catch (Throwable unused) {
                OPTIONAL_ERROR = true;
            }
        }
        return OPTIONAL_EMPTY;
    }

    public static double parseDouble(String str) {
        double d9;
        double d10;
        int length = str.length();
        if (length > 10) {
            return Double.parseDouble(str);
        }
        long j = 0;
        boolean z8 = false;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '-' && i10 == 0) {
                z8 = true;
            } else if (cCharAt == '.') {
                if (i9 != 0) {
                    return Double.parseDouble(str);
                }
                i9 = (length - i10) - 1;
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    return Double.parseDouble(str);
                }
                j = (j * 10) + ((long) (cCharAt - '0'));
            }
        }
        if (z8) {
            j = -j;
        }
        switch (i9) {
            case 0:
                return j;
            case 1:
                d9 = j;
                d10 = 10.0d;
                break;
            case 2:
                d9 = j;
                d10 = 100.0d;
                break;
            case 3:
                d9 = j;
                d10 = 1000.0d;
                break;
            case 4:
                d9 = j;
                d10 = 10000.0d;
                break;
            case 5:
                d9 = j;
                d10 = 100000.0d;
                break;
            case 6:
                d9 = j;
                d10 = 1000000.0d;
                break;
            case 7:
                d9 = j;
                d10 = 1.0E7d;
                break;
            case 8:
                d9 = j;
                d10 = 1.0E8d;
                break;
            case 9:
                d9 = j;
                d10 = 1.0E9d;
                break;
            default:
                return Double.parseDouble(str);
        }
        return d9 / d10;
    }

    public static float parseFloat(String str) {
        float f6;
        float f9;
        int length = str.length();
        if (length >= 10) {
            return Float.parseFloat(str);
        }
        long j = 0;
        boolean z8 = false;
        int i9 = 0;
        for (int i10 = 0; i10 < length; i10++) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '-' && i10 == 0) {
                z8 = true;
            } else if (cCharAt == '.') {
                if (i9 != 0) {
                    return Float.parseFloat(str);
                }
                i9 = (length - i10) - 1;
            } else {
                if (cCharAt < '0' || cCharAt > '9') {
                    return Float.parseFloat(str);
                }
                j = (j * 10) + ((long) (cCharAt - '0'));
            }
        }
        if (z8) {
            j = -j;
        }
        switch (i9) {
            case 0:
                return j;
            case 1:
                f6 = j;
                f9 = 10.0f;
                break;
            case 2:
                f6 = j;
                f9 = 100.0f;
                break;
            case 3:
                f6 = j;
                f9 = 1000.0f;
                break;
            case 4:
                f6 = j;
                f9 = 10000.0f;
                break;
            case 5:
                f6 = j;
                f9 = 100000.0f;
                break;
            case 6:
                f6 = j;
                f9 = 1000000.0f;
                break;
            case 7:
                f6 = j;
                f9 = 1.0E7f;
                break;
            case 8:
                f6 = j;
                f9 = 1.0E8f;
                break;
            case 9:
                f6 = j;
                f9 = 1.0E9f;
                break;
            default:
                return Float.parseFloat(str);
        }
        return f6 / f9;
    }

    public static void setAccessible(AccessibleObject accessibleObject) {
        if (setAccessibleEnable && !accessibleObject.isAccessible()) {
            try {
                accessibleObject.setAccessible(true);
            } catch (Throwable unused) {
                setAccessibleEnable = false;
            }
        }
    }

    public static short shortValue(BigDecimal bigDecimal) {
        if (bigDecimal == null) {
            return (short) 0;
        }
        int iScale = bigDecimal.scale();
        return (iScale < -100 || iScale > 100) ? bigDecimal.shortValueExact() : bigDecimal.shortValue();
    }

    public static Locale toLocale(String str) {
        String[] strArrSplit = str.split(BundleUtil.UNDERLINE_TAG);
        if (strArrSplit.length == 1) {
            return new Locale(strArrSplit[0]);
        }
        return strArrSplit.length == 2 ? new Locale(strArrSplit[0], strArrSplit[1]) : new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }

    public static Type unwrapOptional(Type type) {
        if (!optionalClassInited) {
            try {
                optionalClass = Class.forName("java.util.Optional");
            } catch (Exception unused) {
            } finally {
                optionalClassInited = true;
            }
        }
        if (!(type instanceof ParameterizedType)) {
            return type;
        }
        ParameterizedType parameterizedType = (ParameterizedType) type;
        return parameterizedType.getRawType() == optionalClass ? parameterizedType.getActualTypeArguments()[0] : type;
    }

    public static SerializeBeanInfo buildBeanInfo(Class<?> cls, Map<String, String> map, PropertyNamingStrategy propertyNamingStrategy, boolean z8) {
        PropertyNamingStrategy propertyNamingStrategy2;
        int i9;
        String[] strArr;
        String str;
        String str2;
        Class<?> cls2;
        Map<String, String> map2;
        List<FieldInfo> listComputeGetters;
        List arrayList;
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        if (jSONType != null) {
            String[] strArrOrders = jSONType.orders();
            String strTypeName = jSONType.typeName();
            if (strTypeName.length() == 0) {
                strTypeName = null;
            }
            PropertyNamingStrategy propertyNamingStrategyNaming = jSONType.naming();
            if (propertyNamingStrategyNaming != PropertyNamingStrategy.NeverUseThisValueExceptDefaultValue) {
                propertyNamingStrategy = propertyNamingStrategyNaming;
            }
            int iOf = SerializerFeature.of(jSONType.serialzeFeatures());
            String strTypeKey = null;
            for (Class<? super Object> superclass = cls.getSuperclass(); superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                JSONType jSONType2 = (JSONType) getAnnotation(superclass, JSONType.class);
                if (jSONType2 == null) {
                    break;
                }
                strTypeKey = jSONType2.typeKey();
                if (strTypeKey.length() != 0) {
                    break;
                }
            }
            for (Class<?> cls3 : cls.getInterfaces()) {
                JSONType jSONType3 = (JSONType) getAnnotation(cls3, JSONType.class);
                if (jSONType3 != null) {
                    strTypeKey = jSONType3.typeKey();
                    if (strTypeKey.length() != 0) {
                        break;
                    }
                }
            }
            propertyNamingStrategy2 = propertyNamingStrategy;
            str2 = (strTypeKey == null || strTypeKey.length() != 0) ? strTypeKey : null;
            strArr = strArrOrders;
            str = strTypeName;
            i9 = iOf;
        } else {
            propertyNamingStrategy2 = propertyNamingStrategy;
            i9 = 0;
            strArr = null;
            str = null;
            str2 = null;
        }
        HashMap map3 = new HashMap();
        ParserConfig.parserAllFieldToCache(cls, map3);
        if (z8) {
            listComputeGetters = computeGettersWithFieldBase(cls, map, false, propertyNamingStrategy2);
            cls2 = cls;
            map2 = map;
        } else {
            cls2 = cls;
            map2 = map;
            listComputeGetters = computeGetters(cls2, jSONType, map2, map3, false, propertyNamingStrategy2);
        }
        FieldInfo[] fieldInfoArr = new FieldInfo[listComputeGetters.size()];
        listComputeGetters.toArray(fieldInfoArr);
        if (strArr == null || strArr.length == 0) {
            arrayList = new ArrayList(listComputeGetters);
            Collections.sort(arrayList);
        } else {
            arrayList = z8 ? computeGettersWithFieldBase(cls2, map2, true, propertyNamingStrategy2) : computeGetters(cls2, jSONType, map2, map3, true, propertyNamingStrategy2);
        }
        FieldInfo[] fieldInfoArr2 = new FieldInfo[arrayList.size()];
        arrayList.toArray(fieldInfoArr2);
        if (Arrays.equals(fieldInfoArr2, fieldInfoArr)) {
            fieldInfoArr2 = fieldInfoArr;
        }
        return new SerializeBeanInfo(cls2, jSONType, str, str2, i9, fieldInfoArr, fieldInfoArr2);
    }

    public static java.util.Date castToDate(Object obj, String str) {
        long j;
        if (obj == null) {
            return null;
        }
        if (obj instanceof java.util.Date) {
            return (java.util.Date) obj;
        }
        if (obj instanceof Calendar) {
            return ((Calendar) obj).getTime();
        }
        if (obj instanceof BigDecimal) {
            return new java.util.Date(longValue((BigDecimal) obj));
        }
        if (obj instanceof Number) {
            long jLongValue = ((Number) obj).longValue();
            if ("unixtime".equals(str)) {
                jLongValue *= 1000;
            }
            return new java.util.Date(jLongValue);
        }
        if (obj instanceof String) {
            String strH = (String) obj;
            JSONScanner jSONScanner = new JSONScanner(strH);
            try {
                if (jSONScanner.scanISO8601DateIfMatch(false)) {
                    java.util.Date time = jSONScanner.getCalendar().getTime();
                    jSONScanner.close();
                    return time;
                }
                jSONScanner.close();
                if (strH.startsWith("/Date(") && strH.endsWith(")/")) {
                    strH = a.h(2, 6, strH);
                }
                if (strH.indexOf(45) > 0 || strH.indexOf(43) > 0 || str != null) {
                    if (str == null) {
                        int length = strH.length();
                        if (length == JSON.DEFFAULT_DATE_FORMAT.length() || (length == 22 && JSON.DEFFAULT_DATE_FORMAT.equals("yyyyMMddHHmmssSSSZ"))) {
                            str = JSON.DEFFAULT_DATE_FORMAT;
                        } else if (length == 10) {
                            str = "yyyy-MM-dd";
                        } else if (length == 19) {
                            str = "yyyy-MM-dd HH:mm:ss";
                        } else if (length == 29 && strH.charAt(26) == ':' && strH.charAt(28) == '0') {
                            str = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
                        } else {
                            str = (length == 23 && strH.charAt(19) == ',') ? "yyyy-MM-dd HH:mm:ss,SSS" : "yyyy-MM-dd HH:mm:ss.SSS";
                        }
                    }
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, JSON.defaultLocale);
                    simpleDateFormat.setTimeZone(JSON.defaultTimeZone);
                    try {
                        return simpleDateFormat.parse(strH);
                    } catch (ParseException unused) {
                        throw new JSONException("can not cast to Date, value : ".concat(strH));
                    }
                }
                if (strH.length() == 0) {
                    return null;
                }
                j = Long.parseLong(strH);
            } catch (Throwable th) {
                jSONScanner.close();
                throw th;
            }
        } else {
            j = -1;
        }
        if (j != -1) {
            return new java.util.Date(j);
        }
        Class<?> cls = obj.getClass();
        if ("oracle.sql.TIMESTAMP".equals(cls.getName())) {
            if (oracleTimestampMethod == null && !oracleTimestampMethodInited) {
                try {
                    oracleTimestampMethod = cls.getMethod("toJdbc", new Class[0]);
                } catch (NoSuchMethodException unused2) {
                } finally {
                    oracleTimestampMethodInited = true;
                }
            }
            try {
                return (java.util.Date) oracleTimestampMethod.invoke(obj, new Object[0]);
            } catch (Exception e9) {
                throw new JSONException("can not cast oracle.sql.TIMESTAMP to Date", e9);
            }
        }
        if (!"oracle.sql.DATE".equals(cls.getName())) {
            throw new JSONException(e.k(obj, "can not cast to Date, value : "));
        }
        if (oracleDateMethod == null && !oracleDateMethodInited) {
            try {
                oracleDateMethod = cls.getMethod("toJdbc", new Class[0]);
            } catch (NoSuchMethodException unused3) {
            } finally {
                oracleDateMethodInited = true;
            }
        }
        try {
            return (java.util.Date) oracleDateMethod.invoke(obj, new Object[0]);
        } catch (Exception e10) {
            throw new JSONException("can not cast oracle.sql.DATE to Date", e10);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T castToJavaBean(Map<String, Object> map, Class<T> cls, ParserConfig parserConfig) {
        int iIntValueExact;
        try {
            if (cls == StackTraceElement.class) {
                String str = (String) map.get(PushClientConstants.TAG_CLASS_NAME);
                String str2 = (String) map.get("methodName");
                String str3 = (String) map.get("fileName");
                Number number = (Number) map.get("lineNumber");
                if (number == null) {
                    iIntValueExact = 0;
                } else {
                    iIntValueExact = number instanceof BigDecimal ? ((BigDecimal) number).intValueExact() : number.intValue();
                }
                return (T) new StackTraceElement(str, str2, str3, iIntValueExact);
            }
            Object obj = map.get(JSON.DEFAULT_TYPE_KEY);
            if (obj instanceof String) {
                String str4 = (String) obj;
                if (parserConfig == null) {
                    parserConfig = ParserConfig.global;
                }
                Class<?> clsCheckAutoType = parserConfig.checkAutoType(str4, null);
                if (clsCheckAutoType == null) {
                    throw new ClassNotFoundException(str4 + " not found");
                }
                if (!clsCheckAutoType.equals(cls)) {
                    return (T) castToJavaBean(map, clsCheckAutoType, parserConfig);
                }
            }
            if (cls.isInterface()) {
                JSONObject jSONObject = map instanceof JSONObject ? (JSONObject) map : new JSONObject(map);
                if (parserConfig == null) {
                    parserConfig = ParserConfig.getGlobalInstance();
                }
                return parserConfig.get(cls) != null ? (T) JSON.parseObject(JSON.toJSONString(jSONObject), cls) : (T) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls}, jSONObject);
            }
            if (cls == Locale.class) {
                Object obj2 = map.get("language");
                Object obj3 = map.get("country");
                if (obj2 instanceof String) {
                    String str5 = (String) obj2;
                    if (obj3 instanceof String) {
                        return (T) new Locale(str5, (String) obj3);
                    }
                    if (obj3 == null) {
                        return (T) new Locale(str5);
                    }
                }
            }
            if (cls == String.class && (map instanceof JSONObject)) {
                return (T) map.toString();
            }
            if (cls == JSON.class && (map instanceof JSONObject)) {
                return map;
            }
            if (cls == LinkedHashMap.class && (map instanceof JSONObject)) {
                T t = (T) ((JSONObject) map).getInnerMap();
                if (t instanceof LinkedHashMap) {
                    return t;
                }
            }
            if (cls.isInstance(map)) {
                return map;
            }
            if (cls == JSONObject.class) {
                return (T) new JSONObject(map);
            }
            if (parserConfig == null) {
                parserConfig = ParserConfig.getGlobalInstance();
            }
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            JavaBeanDeserializer javaBeanDeserializer = deserializer instanceof JavaBeanDeserializer ? (JavaBeanDeserializer) deserializer : null;
            if (javaBeanDeserializer != null) {
                return (T) javaBeanDeserializer.createInstance(map, parserConfig);
            }
            throw new JSONException("can not get javaBeanDeserializer. ".concat(cls.getName()));
        } catch (Exception e9) {
            throw new JSONException(e9.getMessage(), e9);
        }
    }

    public static List<FieldInfo> computeGetters(Class<?> cls, Map<String, String> map, boolean z8) {
        JSONType jSONType = (JSONType) getAnnotation(cls, JSONType.class);
        HashMap map2 = new HashMap();
        ParserConfig.parserAllFieldToCache(cls, map2);
        return computeGetters(cls, jSONType, map, map2, z8, PropertyNamingStrategy.CamelCase);
    }

    public static Constructor getKotlinConstructor(Constructor[] constructorArr, String[] strArr) {
        Constructor constructor = null;
        for (Constructor constructor2 : constructorArr) {
            Class<?>[] parameterTypes = constructor2.getParameterTypes();
            if ((strArr == null || parameterTypes.length == strArr.length) && ((parameterTypes.length <= 0 || !parameterTypes[parameterTypes.length - 1].getName().equals("kotlin.jvm.internal.f")) && (constructor == null || constructor.getParameterTypes().length < parameterTypes.length))) {
                constructor = constructor2;
            }
        }
        return constructor;
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader) {
        return loadClass(str, classLoader, false);
    }

    public static int num(char c5, char c9, char c10, char c11) {
        if (c5 < '0' || c5 > '9' || c9 < '0' || c9 > '9' || c10 < '0' || c10 > '9' || c11 < '0' || c11 > '9') {
            return -1;
        }
        return (c11 - '0') + ((c10 - '0') * 10) + ((c9 - '0') * 100) + ((c5 - '0') * 1000);
    }

    public static Class<?> loadClass(String str, ClassLoader classLoader, boolean z8) {
        if (str == null || str.length() == 0) {
            return null;
        }
        if (str.length() <= 198) {
            Class<?> clsLoadClass = mappings.get(str);
            if (clsLoadClass != null) {
                return clsLoadClass;
            }
            if (str.charAt(0) == '[') {
                return Array.newInstance(loadClass(str.substring(1), classLoader), 0).getClass();
            }
            if (str.startsWith("L") && str.endsWith(";")) {
                return loadClass(str.substring(1, str.length() - 1), classLoader);
            }
            if (classLoader != null) {
                try {
                    clsLoadClass = classLoader.loadClass(str);
                    if (!z8) {
                        return clsLoadClass;
                    }
                    mappings.put(str, clsLoadClass);
                    return clsLoadClass;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null && contextClassLoader != classLoader) {
                clsLoadClass = contextClassLoader.loadClass(str);
                if (z8) {
                    mappings.put(str, clsLoadClass);
                }
                return clsLoadClass;
            }
            try {
                clsLoadClass = Class.forName(str);
                if (z8) {
                    mappings.put(str, clsLoadClass);
                }
            } catch (Throwable unused) {
            }
            return clsLoadClass;
        }
        throw new JSONException("illegal className : ".concat(str));
    }

    public static int num(char c5, char c9, char c10, char c11, char c12, char c13, char c14, char c15, char c16) {
        if (c5 < '0' || c5 > '9' || c9 < '0' || c9 > '9' || c10 < '0' || c10 > '9' || c11 < '0' || c11 > '9' || c12 < '0' || c12 > '9' || c13 < '0' || c13 > '9' || c14 < '0' || c14 > '9' || c15 < '0' || c15 > '9' || c16 < '0' || c16 > '9') {
            return -1;
        }
        return (c16 - '0') + ((c15 - '0') * 10) + ((c14 - '0') * 100) + ((c13 - '0') * 1000) + ((c12 - '0') * 10000) + ((c11 - '0') * 100000) + ((c10 - '0') * 1000000) + ((c9 - '0') * ExceptionCode.CRASH_EXCEPTION) + ((c5 - '0') * 100000000);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:104:0x0202  */
    /* JADX WARN: Code duplicated, block: B:119:0x0235  */
    /* JADX WARN: Code duplicated, block: B:142:0x028d  */
    /* JADX WARN: Code duplicated, block: B:143:0x0296  */
    /* JADX WARN: Code duplicated, block: B:148:0x02a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:149:0x02a9  */
    /* JADX WARN: Code duplicated, block: B:151:0x02af  */
    /* JADX WARN: Code duplicated, block: B:158:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:160:0x02d4  */
    /* JADX WARN: Code duplicated, block: B:162:0x02dc  */
    /* JADX WARN: Code duplicated, block: B:165:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:167:0x0302  */
    /* JADX WARN: Code duplicated, block: B:169:0x030a  */
    /* JADX WARN: Code duplicated, block: B:172:0x0314  */
    /* JADX WARN: Code duplicated, block: B:175:0x0321  */
    /* JADX WARN: Code duplicated, block: B:177:0x032c  */
    /* JADX WARN: Code duplicated, block: B:179:0x0330  */
    /* JADX WARN: Code duplicated, block: B:181:0x0336  */
    /* JADX WARN: Code duplicated, block: B:185:0x0342  */
    /* JADX WARN: Code duplicated, block: B:189:0x0366  */
    /* JADX WARN: Code duplicated, block: B:194:0x037e  */
    /* JADX WARN: Code duplicated, block: B:222:0x03fd A[PHI: r15
  0x03fd: PHI (r15v15 java.util.Map<java.lang.String, java.lang.reflect.Field>) = 
  (r15v14 java.util.Map<java.lang.String, java.lang.reflect.Field>)
  (r15v16 java.util.Map<java.lang.String, java.lang.reflect.Field>)
  (r15v16 java.util.Map<java.lang.String, java.lang.reflect.Field>)
 binds: [B:221:0x03fb, B:224:0x0404, B:234:0x0423] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:226:0x0407 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:227:0x0409  */
    /* JADX WARN: Code duplicated, block: B:229:0x040f  */
    /* JADX WARN: Code duplicated, block: B:231:0x0415  */
    /* JADX WARN: Code duplicated, block: B:233:0x041f  */
    /* JADX WARN: Code duplicated, block: B:236:0x0426  */
    /* JADX WARN: Code duplicated, block: B:238:0x0444  */
    /* JADX WARN: Code duplicated, block: B:240:0x044a  */
    /* JADX WARN: Code duplicated, block: B:243:0x0456 A[PHI: r0
  0x0456: PHI (r0v26 java.lang.String) = (r0v16 java.lang.String), (r0v28 java.lang.String) binds: [B:237:0x0442, B:239:0x0448] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:246:0x0462  */
    /* JADX WARN: Code duplicated, block: B:248:0x0469  */
    /* JADX WARN: Code duplicated, block: B:249:0x046c  */
    /* JADX WARN: Code duplicated, block: B:256:0x0480  */
    /* JADX WARN: Code duplicated, block: B:260:0x048c  */
    /* JADX WARN: Code duplicated, block: B:52:0x00fb A[PHI: r6 r7 r9
  0x00fb: PHI (r6v31 java.lang.reflect.Constructor<?>[]) = 
  (r6v1 java.lang.reflect.Constructor<?>[])
  (r6v33 java.lang.reflect.Constructor<?>[])
  (r6v33 java.lang.reflect.Constructor<?>[])
 binds: [B:42:0x00c1, B:44:0x00cb, B:46:0x00d5] A[DONT_GENERATE, DONT_INLINE]
  0x00fb: PHI (r7v15 java.lang.String[]) = (r7v1 java.lang.String[]), (r7v1 java.lang.String[]), (r7v17 java.lang.String[]) binds: [B:42:0x00c1, B:44:0x00cb, B:46:0x00d5] A[DONT_GENERATE, DONT_INLINE]
  0x00fb: PHI (r9v6 java.lang.annotation.Annotation[][]) = 
  (r9v1 java.lang.annotation.Annotation[][])
  (r9v1 java.lang.annotation.Annotation[][])
  (r9v8 java.lang.annotation.Annotation[][])
 binds: [B:42:0x00c1, B:44:0x00cb, B:46:0x00d5] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x0178  */
    /* JADX WARN: Code duplicated, block: B:88:0x017e  */
    /* JADX WARN: Code duplicated, block: B:89:0x018a  */
    /* JADX WARN: Code duplicated, block: B:91:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:97:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:99:0x01e8  */
    public static List<FieldInfo> computeGetters(Class<?> cls, JSONType jSONType, Map<String, String> map, Map<String, Field> map2, boolean z8, PropertyNamingStrategy propertyNamingStrategy) {
        int i9;
        Boolean bool;
        JSONField jSONField;
        String strLabel;
        int iOrdinal;
        int iOf;
        int iOf2;
        Class<?> cls2;
        String str;
        LinkedHashMap linkedHashMap;
        Method method;
        int i10;
        Map<String, Field> map3;
        PropertyNamingStrategy propertyNamingStrategy2;
        String strSubstring;
        Field fieldFromCache;
        int i11;
        JSONField jSONField2;
        String str2;
        JSONField jSONField3;
        char cCharAt;
        String propertyNameByMethodName;
        String propertyNameByCompatibleFieldName;
        String strTranslate;
        Field fieldFromCache2;
        JSONField jSONField4;
        Boolean bool2;
        String strName;
        Boolean bool3;
        char cCharAt2;
        String strSubstring2;
        Field fieldFromCache3;
        int iOrdinal2;
        String strName2;
        int i12;
        Field fieldFromCache4;
        Constructor kotlinConstructor;
        Map<String, String> map4 = map;
        Map<String, Field> map5 = map2;
        PropertyNamingStrategy propertyNamingStrategy3 = propertyNamingStrategy;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        boolean zIsKotlin = isKotlin(cls);
        Method[] methods = cls.getMethods();
        try {
            Arrays.sort(methods, new MethodInheritanceComparator());
        } catch (Throwable unused) {
        }
        int length = methods.length;
        Constructor<?>[] declaredConstructors = null;
        String[] koltinConstructorParameters = null;
        short[] sArr = null;
        Annotation[][] parameterAnnotations = null;
        int i13 = 0;
        while (i13 < length) {
            int i14 = length;
            Method method2 = methods[i13];
            String name = method2.getName();
            if (Modifier.isStatic(method2.getModifiers())) {
                methods = methods;
                i9 = i13;
                i14 = i14;
                map3 = map5;
                propertyNamingStrategy2 = propertyNamingStrategy3;
                linkedHashMap = linkedHashMap2;
            } else {
                i9 = i13;
                Class<?> returnType = method2.getReturnType();
                if (returnType.equals(Void.TYPE) || method2.getParameterTypes().length != 0 || returnType == ClassLoader.class || returnType == InputStream.class || returnType == Reader.class || ((name.equals("getMetaClass") && returnType.getName().equals("groovy.lang.MetaClass")) || ((name.equals("getSuppressed") && method2.getDeclaringClass() == Throwable.class) || (zIsKotlin && isKotlinIgnore(cls, name))))) {
                    methods = methods;
                    map3 = map5;
                    propertyNamingStrategy2 = propertyNamingStrategy3;
                    i9 = i9;
                    linkedHashMap = linkedHashMap2;
                    i14 = i14;
                } else {
                    Boolean bool4 = Boolean.FALSE;
                    JSONField superMethodAnnotation = (JSONField) getAnnotation(method2, JSONField.class);
                    if (superMethodAnnotation == null) {
                        superMethodAnnotation = getSuperMethodAnnotation(cls, method2);
                    }
                    LinkedHashMap linkedHashMap3 = linkedHashMap2;
                    if (superMethodAnnotation == null && zIsKotlin) {
                        if (declaredConstructors == null && (kotlinConstructor = getKotlinConstructor((declaredConstructors = cls.getDeclaredConstructors()))) != null) {
                            parameterAnnotations = getParameterAnnotations(kotlinConstructor);
                            koltinConstructorParameters = getKoltinConstructorParameters(cls);
                            if (koltinConstructorParameters != null) {
                                String[] strArr = new String[koltinConstructorParameters.length];
                                System.arraycopy(koltinConstructorParameters, 0, strArr, 0, koltinConstructorParameters.length);
                                Arrays.sort(strArr);
                                short[] sArr2 = new short[koltinConstructorParameters.length];
                                for (short s8 = 0; s8 < koltinConstructorParameters.length; s8 = (short) (s8 + 1)) {
                                    sArr2[Arrays.binarySearch(strArr, koltinConstructorParameters[s8])] = s8;
                                }
                                koltinConstructorParameters = strArr;
                                sArr = sArr2;
                            }
                        }
                        if (koltinConstructorParameters != null && sArr != null && name.startsWith("get")) {
                            String strDecapitalize = decapitalize(name.substring(3));
                            int iBinarySearch = Arrays.binarySearch(koltinConstructorParameters, strDecapitalize);
                            if (iBinarySearch >= 0) {
                                i12 = iBinarySearch;
                                break;
                            }
                            int i15 = 0;
                            while (true) {
                                if (i15 >= koltinConstructorParameters.length) {
                                    i12 = iBinarySearch;
                                    break;
                                }
                                if (strDecapitalize.equalsIgnoreCase(koltinConstructorParameters[i15])) {
                                    i12 = i15;
                                    break;
                                }
                                i15++;
                            }
                            if (i12 >= 0) {
                                Annotation[] annotationArr = parameterAnnotations[sArr[i12]];
                                if (annotationArr == null) {
                                    bool = bool4;
                                    break;
                                }
                                int length2 = annotationArr.length;
                                int i16 = 0;
                                while (true) {
                                    if (i16 >= length2) {
                                        bool = bool4;
                                        break;
                                    }
                                    int i17 = i16;
                                    Annotation annotation = annotationArr[i17];
                                    bool = bool4;
                                    if (annotation instanceof JSONField) {
                                        superMethodAnnotation = (JSONField) annotation;
                                        break;
                                    }
                                    i16 = i17 + 1;
                                    bool4 = bool;
                                }
                                if (superMethodAnnotation == null && (fieldFromCache4 = ParserConfig.getFieldFromCache(strDecapitalize, map5)) != null) {
                                    superMethodAnnotation = (JSONField) getAnnotation(fieldFromCache4, JSONField.class);
                                }
                            }
                        }
                        String[] strArr2 = koltinConstructorParameters;
                        short[] sArr3 = sArr;
                        Annotation[][] annotationArr2 = parameterAnnotations;
                        jSONField = superMethodAnnotation;
                        Constructor<?>[] constructorArr = declaredConstructors;
                        strLabel = null;
                        if (jSONField != null) {
                            if (jSONField.serialize()) {
                                iOrdinal2 = jSONField.ordinal();
                                iOf = SerializerFeature.of(jSONField.serialzeFeatures());
                                iOf2 = Feature.of(jSONField.parseFeatures());
                                if (jSONField.name().length() != 0) {
                                    strName2 = jSONField.name();
                                    if (map4 == null && (strName2 = map4.get(strName2)) == null) {
                                        map3 = map5;
                                        propertyNamingStrategy2 = propertyNamingStrategy3;
                                        linkedHashMap = linkedHashMap3;
                                        i9 = i9;
                                        i14 = i14;
                                    } else {
                                        String str3 = strName2;
                                        i9 = i9;
                                        i14 = i14;
                                        linkedHashMap3.put(str3, new FieldInfo(str3, method2, null, cls, null, iOrdinal2, iOf, iOf2, jSONField, null, null));
                                        map3 = map5;
                                        propertyNamingStrategy2 = propertyNamingStrategy3;
                                        linkedHashMap = linkedHashMap3;
                                    }
                                } else {
                                    strLabel = jSONField.label().length() != 0 ? jSONField.label() : null;
                                    iOrdinal = iOrdinal2;
                                }
                            } else {
                                map3 = map5;
                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                linkedHashMap = linkedHashMap3;
                                i9 = i9;
                                i14 = i14;
                            }
                            declaredConstructors = constructorArr;
                            koltinConstructorParameters = strArr2;
                            sArr = sArr3;
                            parameterAnnotations = annotationArr2;
                        } else {
                            iOrdinal = 0;
                            iOf = 0;
                            iOf2 = 0;
                        }
                        if (name.startsWith("get")) {
                            if (name.length() >= 4 && !name.equals("getClass") && (!name.equals("getDeclaringClass") || !cls.isEnum())) {
                                cCharAt = name.charAt(3);
                                if (!Character.isUpperCase(cCharAt) || cCharAt > 512) {
                                    if (compatibleWithJavaBean) {
                                        propertyNameByMethodName = decapitalize(name.substring(3));
                                    } else {
                                        propertyNameByMethodName = getPropertyNameByMethodName(name);
                                    }
                                    propertyNameByCompatibleFieldName = getPropertyNameByCompatibleFieldName(map5, name, propertyNameByMethodName, 3);
                                } else {
                                    if (cCharAt == '_') {
                                        strTranslate = name.substring(3);
                                        fieldFromCache2 = map5.get(strTranslate);
                                        if (fieldFromCache2 == null) {
                                            strSubstring2 = name.substring(4);
                                            fieldFromCache3 = ParserConfig.getFieldFromCache(strSubstring2, map5);
                                            if (fieldFromCache3 != null) {
                                            }
                                            fieldFromCache2 = fieldFromCache3;
                                            if (!isJSONTypeIgnore(cls, strTranslate)) {
                                                if (fieldFromCache2 == null) {
                                                    fieldFromCache2 = ParserConfig.getFieldFromCache(strTranslate, map5);
                                                }
                                                if (fieldFromCache2 != null) {
                                                }
                                                if (fieldFromCache2 != null) {
                                                    jSONField4 = (JSONField) getAnnotation(fieldFromCache2, JSONField.class);
                                                    if (jSONField4 != null) {
                                                        if (jSONField4.serialize()) {
                                                            int iOrdinal3 = jSONField4.ordinal();
                                                            iOf = SerializerFeature.of(jSONField4.serialzeFeatures());
                                                            iOf2 = Feature.of(jSONField4.parseFeatures());
                                                            if (jSONField4.name().length() != 0) {
                                                                bool3 = Boolean.TRUE;
                                                                strName = jSONField4.name();
                                                                if (map4 != null) {
                                                                }
                                                            } else {
                                                                strName = strTranslate;
                                                                bool3 = bool;
                                                            }
                                                            if (jSONField4.label().length() != 0) {
                                                                strLabel = jSONField4.label();
                                                            }
                                                            String str4 = strName;
                                                            iOrdinal = iOrdinal3;
                                                            bool2 = bool3;
                                                            strTranslate = str4;
                                                            if (map4 != null) {
                                                            }
                                                            if (propertyNamingStrategy3 != null) {
                                                                strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                                            }
                                                            String str5 = strTranslate;
                                                            cls2 = returnType;
                                                            linkedHashMap = linkedHashMap3;
                                                            method = method2;
                                                            str = name;
                                                            i10 = 3;
                                                            linkedHashMap.put(str5, new FieldInfo(str5, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                                            iOrdinal = iOrdinal;
                                                        }
                                                    }
                                                } else {
                                                    jSONField4 = null;
                                                }
                                                bool2 = bool;
                                                if (map4 != null) {
                                                }
                                                if (propertyNamingStrategy3 != null) {
                                                    strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                                }
                                                String str6 = strTranslate;
                                                cls2 = returnType;
                                                linkedHashMap = linkedHashMap3;
                                                method = method2;
                                                str = name;
                                                i10 = 3;
                                                linkedHashMap.put(str6, new FieldInfo(str6, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                                iOrdinal = iOrdinal;
                                            }
                                        } else if (!isJSONTypeIgnore(cls, strTranslate)) {
                                            if (fieldFromCache2 == null) {
                                                fieldFromCache2 = ParserConfig.getFieldFromCache(strTranslate, map5);
                                            }
                                            if (fieldFromCache2 != null && strTranslate.length() > 1 && (cCharAt2 = strTranslate.charAt(1)) >= 'A' && cCharAt2 <= 'Z') {
                                                fieldFromCache2 = ParserConfig.getFieldFromCache(decapitalize(name.substring(3)), map5);
                                            }
                                            if (fieldFromCache2 != null) {
                                                jSONField4 = (JSONField) getAnnotation(fieldFromCache2, JSONField.class);
                                                if (jSONField4 != null) {
                                                    if (jSONField4.serialize()) {
                                                        int iOrdinal4 = jSONField4.ordinal();
                                                        iOf = SerializerFeature.of(jSONField4.serialzeFeatures());
                                                        iOf2 = Feature.of(jSONField4.parseFeatures());
                                                        if (jSONField4.name().length() != 0) {
                                                            bool3 = Boolean.TRUE;
                                                            strName = jSONField4.name();
                                                            if (map4 != null || (strName = map4.get(strName)) != null) {
                                                            }
                                                            declaredConstructors = constructorArr;
                                                            koltinConstructorParameters = strArr2;
                                                            sArr = sArr3;
                                                            parameterAnnotations = annotationArr2;
                                                        } else {
                                                            strName = strTranslate;
                                                            bool3 = bool;
                                                        }
                                                        if (jSONField4.label().length() != 0) {
                                                            strLabel = jSONField4.label();
                                                        }
                                                        String str7 = strName;
                                                        iOrdinal = iOrdinal4;
                                                        bool2 = bool3;
                                                        strTranslate = str7;
                                                        if (map4 != null || (strTranslate = map4.get(strTranslate)) != null) {
                                                            if (propertyNamingStrategy3 != null && !bool2.booleanValue()) {
                                                                strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                                            }
                                                            String str8 = strTranslate;
                                                            cls2 = returnType;
                                                            linkedHashMap = linkedHashMap3;
                                                            method = method2;
                                                            str = name;
                                                            i10 = 3;
                                                            linkedHashMap.put(str8, new FieldInfo(str8, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                                            iOrdinal = iOrdinal;
                                                        }
                                                        declaredConstructors = constructorArr;
                                                        koltinConstructorParameters = strArr2;
                                                        sArr = sArr3;
                                                        parameterAnnotations = annotationArr2;
                                                    }
                                                }
                                            } else {
                                                jSONField4 = null;
                                            }
                                            bool2 = bool;
                                            if (map4 != null) {
                                            }
                                            if (propertyNamingStrategy3 != null) {
                                                strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                            }
                                            String str9 = strTranslate;
                                            cls2 = returnType;
                                            linkedHashMap = linkedHashMap3;
                                            method = method2;
                                            str = name;
                                            i10 = 3;
                                            linkedHashMap.put(str9, new FieldInfo(str9, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                            iOrdinal = iOrdinal;
                                        }
                                    } else if (cCharAt == 'f') {
                                        strTranslate = name.substring(3);
                                        fieldFromCache2 = null;
                                        if (!isJSONTypeIgnore(cls, strTranslate)) {
                                            if (fieldFromCache2 == null) {
                                                fieldFromCache2 = ParserConfig.getFieldFromCache(strTranslate, map5);
                                            }
                                            if (fieldFromCache2 != null) {
                                            }
                                            if (fieldFromCache2 != null) {
                                                jSONField4 = (JSONField) getAnnotation(fieldFromCache2, JSONField.class);
                                                if (jSONField4 != null) {
                                                    if (jSONField4.serialize()) {
                                                        int iOrdinal5 = jSONField4.ordinal();
                                                        iOf = SerializerFeature.of(jSONField4.serialzeFeatures());
                                                        iOf2 = Feature.of(jSONField4.parseFeatures());
                                                        if (jSONField4.name().length() != 0) {
                                                            bool3 = Boolean.TRUE;
                                                            strName = jSONField4.name();
                                                            if (map4 != null) {
                                                            }
                                                        } else {
                                                            strName = strTranslate;
                                                            bool3 = bool;
                                                        }
                                                        if (jSONField4.label().length() != 0) {
                                                            strLabel = jSONField4.label();
                                                        }
                                                        String str10 = strName;
                                                        iOrdinal = iOrdinal5;
                                                        bool2 = bool3;
                                                        strTranslate = str10;
                                                        if (map4 != null) {
                                                        }
                                                        if (propertyNamingStrategy3 != null) {
                                                            strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                                        }
                                                        String str11 = strTranslate;
                                                        cls2 = returnType;
                                                        linkedHashMap = linkedHashMap3;
                                                        method = method2;
                                                        str = name;
                                                        i10 = 3;
                                                        linkedHashMap.put(str11, new FieldInfo(str11, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                                        iOrdinal = iOrdinal;
                                                    }
                                                }
                                            } else {
                                                jSONField4 = null;
                                            }
                                            bool2 = bool;
                                            if (map4 != null) {
                                            }
                                            if (propertyNamingStrategy3 != null) {
                                                strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                            }
                                            String str12 = strTranslate;
                                            cls2 = returnType;
                                            linkedHashMap = linkedHashMap3;
                                            method = method2;
                                            str = name;
                                            i10 = 3;
                                            linkedHashMap.put(str12, new FieldInfo(str12, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                            iOrdinal = iOrdinal;
                                        }
                                    } else if (name.length() >= 5 && Character.isUpperCase(name.charAt(4))) {
                                        propertyNameByCompatibleFieldName = decapitalize(name.substring(3));
                                    } else {
                                        strSubstring2 = name.substring(3);
                                        fieldFromCache3 = ParserConfig.getFieldFromCache(strSubstring2, map5);
                                        if (fieldFromCache3 == null) {
                                        }
                                        declaredConstructors = constructorArr;
                                        koltinConstructorParameters = strArr2;
                                        sArr = sArr3;
                                        parameterAnnotations = annotationArr2;
                                    }
                                    strTranslate = strSubstring2;
                                    fieldFromCache2 = fieldFromCache3;
                                    if (!isJSONTypeIgnore(cls, strTranslate)) {
                                        if (fieldFromCache2 == null) {
                                            fieldFromCache2 = ParserConfig.getFieldFromCache(strTranslate, map5);
                                        }
                                        if (fieldFromCache2 != null) {
                                        }
                                        if (fieldFromCache2 != null) {
                                            jSONField4 = (JSONField) getAnnotation(fieldFromCache2, JSONField.class);
                                            if (jSONField4 != null) {
                                                if (jSONField4.serialize()) {
                                                    int iOrdinal6 = jSONField4.ordinal();
                                                    iOf = SerializerFeature.of(jSONField4.serialzeFeatures());
                                                    iOf2 = Feature.of(jSONField4.parseFeatures());
                                                    if (jSONField4.name().length() != 0) {
                                                        bool3 = Boolean.TRUE;
                                                        strName = jSONField4.name();
                                                        if (map4 != null) {
                                                        }
                                                    } else {
                                                        strName = strTranslate;
                                                        bool3 = bool;
                                                    }
                                                    if (jSONField4.label().length() != 0) {
                                                        strLabel = jSONField4.label();
                                                    }
                                                    String str13 = strName;
                                                    iOrdinal = iOrdinal6;
                                                    bool2 = bool3;
                                                    strTranslate = str13;
                                                    if (map4 != null) {
                                                    }
                                                    if (propertyNamingStrategy3 != null) {
                                                        strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                                    }
                                                    String str14 = strTranslate;
                                                    cls2 = returnType;
                                                    linkedHashMap = linkedHashMap3;
                                                    method = method2;
                                                    str = name;
                                                    i10 = 3;
                                                    linkedHashMap.put(str14, new FieldInfo(str14, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                                    iOrdinal = iOrdinal;
                                                }
                                            }
                                        } else {
                                            jSONField4 = null;
                                        }
                                        bool2 = bool;
                                        if (map4 != null) {
                                        }
                                        if (propertyNamingStrategy3 != null) {
                                            strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                        }
                                        String str15 = strTranslate;
                                        cls2 = returnType;
                                        linkedHashMap = linkedHashMap3;
                                        method = method2;
                                        str = name;
                                        i10 = 3;
                                        linkedHashMap.put(str15, new FieldInfo(str15, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                        iOrdinal = iOrdinal;
                                    }
                                }
                                strTranslate = propertyNameByCompatibleFieldName;
                                fieldFromCache2 = null;
                                if (!isJSONTypeIgnore(cls, strTranslate)) {
                                    if (fieldFromCache2 == null) {
                                        fieldFromCache2 = ParserConfig.getFieldFromCache(strTranslate, map5);
                                    }
                                    if (fieldFromCache2 != null) {
                                    }
                                    if (fieldFromCache2 != null) {
                                        jSONField4 = (JSONField) getAnnotation(fieldFromCache2, JSONField.class);
                                        if (jSONField4 != null) {
                                            if (jSONField4.serialize()) {
                                                int iOrdinal7 = jSONField4.ordinal();
                                                iOf = SerializerFeature.of(jSONField4.serialzeFeatures());
                                                iOf2 = Feature.of(jSONField4.parseFeatures());
                                                if (jSONField4.name().length() != 0) {
                                                    bool3 = Boolean.TRUE;
                                                    strName = jSONField4.name();
                                                    if (map4 != null) {
                                                    }
                                                } else {
                                                    strName = strTranslate;
                                                    bool3 = bool;
                                                }
                                                if (jSONField4.label().length() != 0) {
                                                    strLabel = jSONField4.label();
                                                }
                                                String str16 = strName;
                                                iOrdinal = iOrdinal7;
                                                bool2 = bool3;
                                                strTranslate = str16;
                                                if (map4 != null) {
                                                }
                                                if (propertyNamingStrategy3 != null) {
                                                    strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                                }
                                                String str17 = strTranslate;
                                                cls2 = returnType;
                                                linkedHashMap = linkedHashMap3;
                                                method = method2;
                                                str = name;
                                                i10 = 3;
                                                linkedHashMap.put(str17, new FieldInfo(str17, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                                iOrdinal = iOrdinal;
                                            }
                                        }
                                    } else {
                                        jSONField4 = null;
                                    }
                                    bool2 = bool;
                                    if (map4 != null) {
                                    }
                                    if (propertyNamingStrategy3 != null) {
                                        strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                    }
                                    String str18 = strTranslate;
                                    cls2 = returnType;
                                    linkedHashMap = linkedHashMap3;
                                    method = method2;
                                    str = name;
                                    i10 = 3;
                                    linkedHashMap.put(str18, new FieldInfo(str18, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                    iOrdinal = iOrdinal;
                                }
                            }
                            map3 = map5;
                            propertyNamingStrategy2 = propertyNamingStrategy3;
                            linkedHashMap = linkedHashMap3;
                            declaredConstructors = constructorArr;
                            koltinConstructorParameters = strArr2;
                            sArr = sArr3;
                            parameterAnnotations = annotationArr2;
                        } else {
                            cls2 = returnType;
                            str = name;
                            linkedHashMap = linkedHashMap3;
                            method = method2;
                            i10 = 3;
                        }
                        if (str.startsWith("is") || str.length() < i10 || !(cls2 == Boolean.TYPE || cls2 == Boolean.class)) {
                            map4 = map;
                            map3 = map2;
                        } else {
                            char cCharAt3 = str.charAt(2);
                            if (Character.isUpperCase(cCharAt3)) {
                                map3 = map2;
                                strSubstring = getPropertyNameByCompatibleFieldName(map3, str, compatibleWithJavaBean ? decapitalize(str.substring(2)) : Character.toLowerCase(str.charAt(2)) + str.substring(i10), 2);
                            } else {
                                map3 = map2;
                                if (cCharAt3 == '_') {
                                    String strSubstring3 = str.substring(i10);
                                    fieldFromCache = map3.get(strSubstring3);
                                    if (fieldFromCache != null || (fieldFromCache = ParserConfig.getFieldFromCache((strSubstring = str.substring(2)), map3)) == null) {
                                        strSubstring = strSubstring3;
                                    }
                                } else {
                                    if (cCharAt3 == 'f') {
                                        strSubstring = str.substring(2);
                                    } else {
                                        strSubstring = str.substring(2);
                                        fieldFromCache = ParserConfig.getFieldFromCache(strSubstring, map3);
                                        if (fieldFromCache == null) {
                                        }
                                        declaredConstructors = constructorArr;
                                        koltinConstructorParameters = strArr2;
                                        sArr = sArr3;
                                        parameterAnnotations = annotationArr2;
                                    }
                                    map4 = map;
                                }
                                if (isJSONTypeIgnore(cls, strSubstring)) {
                                    map4 = map;
                                } else {
                                    if (fieldFromCache == null) {
                                        fieldFromCache = ParserConfig.getFieldFromCache(strSubstring, map3);
                                    }
                                    if (fieldFromCache == null) {
                                        fieldFromCache = ParserConfig.getFieldFromCache(str, map3);
                                    }
                                    if (fieldFromCache != null) {
                                        jSONField3 = (JSONField) getAnnotation(fieldFromCache, JSONField.class);
                                        if (jSONField3 != null) {
                                            map4 = map;
                                        } else if (jSONField3.serialize()) {
                                            iOrdinal = jSONField3.ordinal();
                                            iOf = SerializerFeature.of(jSONField3.serialzeFeatures());
                                            iOf2 = Feature.of(jSONField3.parseFeatures());
                                            if (jSONField3.name().length() != 0) {
                                                strSubstring = jSONField3.name();
                                                if (map != null) {
                                                    map4 = map;
                                                    strSubstring = map4.get(strSubstring);
                                                    if (strSubstring == null) {
                                                    }
                                                } else {
                                                    map4 = map;
                                                }
                                                if (jSONField3.label().length() != 0) {
                                                    strLabel = jSONField3.label();
                                                }
                                            } else {
                                                map4 = map;
                                                if (jSONField3.label().length() != 0) {
                                                    strLabel = jSONField3.label();
                                                }
                                            }
                                        } else {
                                            map4 = map;
                                        }
                                        jSONField2 = jSONField3;
                                        i11 = iOrdinal;
                                    } else {
                                        map4 = map;
                                        i11 = iOrdinal;
                                        jSONField2 = null;
                                    }
                                    if (map4 != null || (strSubstring = map4.get(strSubstring)) != null) {
                                        propertyNamingStrategy2 = propertyNamingStrategy;
                                        if (propertyNamingStrategy != null) {
                                            strSubstring = propertyNamingStrategy2.translate(strSubstring);
                                        }
                                        str2 = strSubstring;
                                        if (!linkedHashMap.containsKey(str2)) {
                                            linkedHashMap.put(str2, new FieldInfo(str2, method, fieldFromCache, cls, null, i11, iOf, iOf2, jSONField, jSONField2, strLabel));
                                        }
                                    }
                                }
                                declaredConstructors = constructorArr;
                                koltinConstructorParameters = strArr2;
                                sArr = sArr3;
                                parameterAnnotations = annotationArr2;
                            }
                            fieldFromCache = null;
                            if (isJSONTypeIgnore(cls, strSubstring)) {
                                if (fieldFromCache == null) {
                                    fieldFromCache = ParserConfig.getFieldFromCache(strSubstring, map3);
                                }
                                if (fieldFromCache == null) {
                                    fieldFromCache = ParserConfig.getFieldFromCache(str, map3);
                                }
                                if (fieldFromCache != null) {
                                    jSONField3 = (JSONField) getAnnotation(fieldFromCache, JSONField.class);
                                    if (jSONField3 != null) {
                                        map4 = map;
                                    } else if (jSONField3.serialize()) {
                                        map4 = map;
                                    } else {
                                        iOrdinal = jSONField3.ordinal();
                                        iOf = SerializerFeature.of(jSONField3.serialzeFeatures());
                                        iOf2 = Feature.of(jSONField3.parseFeatures());
                                        if (jSONField3.name().length() != 0) {
                                            strSubstring = jSONField3.name();
                                            if (map != null) {
                                                map4 = map;
                                                strSubstring = map4.get(strSubstring);
                                                if (strSubstring == null) {
                                                }
                                            } else {
                                                map4 = map;
                                            }
                                            if (jSONField3.label().length() != 0) {
                                                strLabel = jSONField3.label();
                                            }
                                        } else {
                                            map4 = map;
                                            if (jSONField3.label().length() != 0) {
                                                strLabel = jSONField3.label();
                                            }
                                        }
                                    }
                                    jSONField2 = jSONField3;
                                    i11 = iOrdinal;
                                } else {
                                    map4 = map;
                                    i11 = iOrdinal;
                                    jSONField2 = null;
                                }
                                if (map4 != null) {
                                }
                                propertyNamingStrategy2 = propertyNamingStrategy;
                                if (propertyNamingStrategy != null) {
                                    strSubstring = propertyNamingStrategy2.translate(strSubstring);
                                }
                                str2 = strSubstring;
                                if (!linkedHashMap.containsKey(str2)) {
                                    linkedHashMap.put(str2, new FieldInfo(str2, method, fieldFromCache, cls, null, i11, iOf, iOf2, jSONField, jSONField2, strLabel));
                                }
                            } else {
                                map4 = map;
                            }
                            declaredConstructors = constructorArr;
                            koltinConstructorParameters = strArr2;
                            sArr = sArr3;
                            parameterAnnotations = annotationArr2;
                        }
                        propertyNamingStrategy2 = propertyNamingStrategy;
                        declaredConstructors = constructorArr;
                        koltinConstructorParameters = strArr2;
                        sArr = sArr3;
                        parameterAnnotations = annotationArr2;
                    } else {
                        methods = methods;
                        method2 = method2;
                    }
                    bool = bool4;
                    String[] strArr3 = koltinConstructorParameters;
                    short[] sArr4 = sArr;
                    Annotation[][] annotationArr3 = parameterAnnotations;
                    jSONField = superMethodAnnotation;
                    Constructor<?>[] constructorArr2 = declaredConstructors;
                    strLabel = null;
                    if (jSONField != null) {
                        if (jSONField.serialize()) {
                            map3 = map5;
                            propertyNamingStrategy2 = propertyNamingStrategy3;
                            linkedHashMap = linkedHashMap3;
                            i9 = i9;
                            i14 = i14;
                        } else {
                            iOrdinal2 = jSONField.ordinal();
                            iOf = SerializerFeature.of(jSONField.serialzeFeatures());
                            iOf2 = Feature.of(jSONField.parseFeatures());
                            if (jSONField.name().length() != 0) {
                                strName2 = jSONField.name();
                                if (map4 == null) {
                                }
                                String str19 = strName2;
                                i9 = i9;
                                i14 = i14;
                                linkedHashMap3.put(str19, new FieldInfo(str19, method2, null, cls, null, iOrdinal2, iOf, iOf2, jSONField, null, null));
                                map3 = map5;
                                propertyNamingStrategy2 = propertyNamingStrategy3;
                                linkedHashMap = linkedHashMap3;
                            } else {
                                if (jSONField.label().length() != 0) {
                                }
                                iOrdinal = iOrdinal2;
                            }
                        }
                        declaredConstructors = constructorArr2;
                        koltinConstructorParameters = strArr3;
                        sArr = sArr4;
                        parameterAnnotations = annotationArr3;
                    } else {
                        iOrdinal = 0;
                        iOf = 0;
                        iOf2 = 0;
                    }
                    if (name.startsWith("get")) {
                        if (name.length() >= 4) {
                            cCharAt = name.charAt(3);
                            if (!Character.isUpperCase(cCharAt)) {
                                if (compatibleWithJavaBean) {
                                    propertyNameByMethodName = decapitalize(name.substring(3));
                                } else {
                                    propertyNameByMethodName = getPropertyNameByMethodName(name);
                                }
                                propertyNameByCompatibleFieldName = getPropertyNameByCompatibleFieldName(map5, name, propertyNameByMethodName, 3);
                                strTranslate = propertyNameByCompatibleFieldName;
                                fieldFromCache2 = null;
                                if (!isJSONTypeIgnore(cls, strTranslate)) {
                                    if (fieldFromCache2 == null) {
                                        fieldFromCache2 = ParserConfig.getFieldFromCache(strTranslate, map5);
                                    }
                                    if (fieldFromCache2 != null) {
                                    }
                                    if (fieldFromCache2 != null) {
                                        jSONField4 = (JSONField) getAnnotation(fieldFromCache2, JSONField.class);
                                        if (jSONField4 != null) {
                                            if (jSONField4.serialize()) {
                                                int iOrdinal8 = jSONField4.ordinal();
                                                iOf = SerializerFeature.of(jSONField4.serialzeFeatures());
                                                iOf2 = Feature.of(jSONField4.parseFeatures());
                                                if (jSONField4.name().length() != 0) {
                                                    bool3 = Boolean.TRUE;
                                                    strName = jSONField4.name();
                                                    if (map4 != null) {
                                                    }
                                                } else {
                                                    strName = strTranslate;
                                                    bool3 = bool;
                                                }
                                                if (jSONField4.label().length() != 0) {
                                                    strLabel = jSONField4.label();
                                                }
                                                String str110 = strName;
                                                iOrdinal = iOrdinal8;
                                                bool2 = bool3;
                                                strTranslate = str110;
                                                if (map4 != null) {
                                                }
                                                if (propertyNamingStrategy3 != null) {
                                                    strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                                }
                                                String str111 = strTranslate;
                                                cls2 = returnType;
                                                linkedHashMap = linkedHashMap3;
                                                method = method2;
                                                str = name;
                                                i10 = 3;
                                                linkedHashMap.put(str111, new FieldInfo(str111, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                                iOrdinal = iOrdinal;
                                            }
                                        }
                                    } else {
                                        jSONField4 = null;
                                    }
                                    bool2 = bool;
                                    if (map4 != null) {
                                    }
                                    if (propertyNamingStrategy3 != null) {
                                        strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                    }
                                    String str112 = strTranslate;
                                    cls2 = returnType;
                                    linkedHashMap = linkedHashMap3;
                                    method = method2;
                                    str = name;
                                    i10 = 3;
                                    linkedHashMap.put(str112, new FieldInfo(str112, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                    iOrdinal = iOrdinal;
                                }
                            } else {
                                if (compatibleWithJavaBean) {
                                    propertyNameByMethodName = decapitalize(name.substring(3));
                                } else {
                                    propertyNameByMethodName = getPropertyNameByMethodName(name);
                                }
                                propertyNameByCompatibleFieldName = getPropertyNameByCompatibleFieldName(map5, name, propertyNameByMethodName, 3);
                                strTranslate = propertyNameByCompatibleFieldName;
                                fieldFromCache2 = null;
                                if (!isJSONTypeIgnore(cls, strTranslate)) {
                                    if (fieldFromCache2 == null) {
                                        fieldFromCache2 = ParserConfig.getFieldFromCache(strTranslate, map5);
                                    }
                                    if (fieldFromCache2 != null) {
                                    }
                                    if (fieldFromCache2 != null) {
                                        jSONField4 = (JSONField) getAnnotation(fieldFromCache2, JSONField.class);
                                        if (jSONField4 != null) {
                                            if (jSONField4.serialize()) {
                                                int iOrdinal9 = jSONField4.ordinal();
                                                iOf = SerializerFeature.of(jSONField4.serialzeFeatures());
                                                iOf2 = Feature.of(jSONField4.parseFeatures());
                                                if (jSONField4.name().length() != 0) {
                                                    bool3 = Boolean.TRUE;
                                                    strName = jSONField4.name();
                                                    if (map4 != null) {
                                                    }
                                                } else {
                                                    strName = strTranslate;
                                                    bool3 = bool;
                                                }
                                                if (jSONField4.label().length() != 0) {
                                                    strLabel = jSONField4.label();
                                                }
                                                String str113 = strName;
                                                iOrdinal = iOrdinal9;
                                                bool2 = bool3;
                                                strTranslate = str113;
                                                if (map4 != null) {
                                                }
                                                if (propertyNamingStrategy3 != null) {
                                                    strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                                }
                                                String str114 = strTranslate;
                                                cls2 = returnType;
                                                linkedHashMap = linkedHashMap3;
                                                method = method2;
                                                str = name;
                                                i10 = 3;
                                                linkedHashMap.put(str114, new FieldInfo(str114, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                                iOrdinal = iOrdinal;
                                            }
                                        }
                                    } else {
                                        jSONField4 = null;
                                    }
                                    bool2 = bool;
                                    if (map4 != null) {
                                    }
                                    if (propertyNamingStrategy3 != null) {
                                        strTranslate = propertyNamingStrategy3.translate(strTranslate);
                                    }
                                    String str115 = strTranslate;
                                    cls2 = returnType;
                                    linkedHashMap = linkedHashMap3;
                                    method = method2;
                                    str = name;
                                    i10 = 3;
                                    linkedHashMap.put(str115, new FieldInfo(str115, method, fieldFromCache2, cls, null, iOrdinal, iOf, iOf2, jSONField, jSONField4, strLabel));
                                    iOrdinal = iOrdinal;
                                }
                            }
                        }
                        map3 = map5;
                        propertyNamingStrategy2 = propertyNamingStrategy3;
                        linkedHashMap = linkedHashMap3;
                        declaredConstructors = constructorArr2;
                        koltinConstructorParameters = strArr3;
                        sArr = sArr4;
                        parameterAnnotations = annotationArr3;
                    } else {
                        cls2 = returnType;
                        str = name;
                        linkedHashMap = linkedHashMap3;
                        method = method2;
                        i10 = 3;
                    }
                    if (str.startsWith("is")) {
                        map4 = map;
                        map3 = map2;
                        propertyNamingStrategy2 = propertyNamingStrategy;
                    } else {
                        map4 = map;
                        map3 = map2;
                        propertyNamingStrategy2 = propertyNamingStrategy;
                    }
                    declaredConstructors = constructorArr2;
                    koltinConstructorParameters = strArr3;
                    sArr = sArr4;
                    parameterAnnotations = annotationArr3;
                }
            }
            i13 = i9 + 1;
            linkedHashMap2 = linkedHashMap;
            length = i14;
            methods = methods;
            propertyNamingStrategy3 = propertyNamingStrategy2;
            map5 = map3;
        }
        PropertyNamingStrategy propertyNamingStrategy4 = propertyNamingStrategy3;
        LinkedHashMap linkedHashMap4 = linkedHashMap2;
        computeFields(cls, map4, propertyNamingStrategy4, linkedHashMap4, cls.getFields());
        return getFieldInfos(cls, z8, linkedHashMap4);
    }

    private static Type getCollectionItemType(Class<?> cls) {
        return cls.getName().startsWith("java.") ? Object.class : getCollectionItemType(getCollectionSuperType(cls));
    }

    private static Type getCollectionItemType(ParameterizedType parameterizedType) {
        Type rawType = parameterizedType.getRawType();
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (rawType == Collection.class) {
            return getWildcardTypeUpperBounds(actualTypeArguments[0]);
        }
        Class cls = (Class) rawType;
        Map<TypeVariable, Type> mapCreateActualTypeMap = createActualTypeMap(cls.getTypeParameters(), actualTypeArguments);
        Type collectionSuperType = getCollectionSuperType(cls);
        if (collectionSuperType instanceof ParameterizedType) {
            Class<?> rawClass = getRawClass(collectionSuperType);
            Type[] actualTypeArguments2 = ((ParameterizedType) collectionSuperType).getActualTypeArguments();
            if (actualTypeArguments2.length > 0) {
                return getCollectionItemType(makeParameterizedType(rawClass, actualTypeArguments2, mapCreateActualTypeMap));
            }
            return getCollectionItemType(rawClass);
        }
        return getCollectionItemType((Class<?>) collectionSuperType);
    }

    public static Annotation[][] getParameterAnnotations(Constructor constructor) {
        Annotation[][] parameterAnnotations;
        Constructor declaredConstructor;
        Annotation[][] parameterAnnotations2 = constructor.getParameterAnnotations();
        Type mixInAnnotations = JSON.getMixInAnnotations(constructor.getDeclaringClass());
        Constructor constructor2 = null;
        Class cls = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (cls != null) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            ArrayList arrayList = new ArrayList(2);
            for (Class<?> enclosingClass = cls.getEnclosingClass(); enclosingClass != null; enclosingClass = enclosingClass.getEnclosingClass()) {
                arrayList.add(enclosingClass);
            }
            int size = arrayList.size();
            for (Class superclass = cls; superclass != null && superclass != Object.class; superclass = superclass.getSuperclass()) {
                try {
                    if (size != 0) {
                        Class<?>[] clsArr = new Class[parameterTypes.length + size];
                        System.arraycopy(parameterTypes, 0, clsArr, size, parameterTypes.length);
                        for (int i9 = size; i9 > 0; i9--) {
                            int i10 = i9 - 1;
                            clsArr[i10] = (Class) arrayList.get(i10);
                        }
                        declaredConstructor = cls.getDeclaredConstructor(clsArr);
                    } else {
                        declaredConstructor = cls.getDeclaredConstructor(parameterTypes);
                    }
                    constructor2 = declaredConstructor;
                    break;
                } catch (NoSuchMethodException unused) {
                    size--;
                }
            }
            if (constructor2 != null && (parameterAnnotations = constructor2.getParameterAnnotations()) != null) {
                return parameterAnnotations;
            }
        }
        return parameterAnnotations2;
    }

    public static <A extends Annotation> A getAnnotation(Field field, Class<A> cls) {
        A a3;
        A a9 = (A) field.getAnnotation(cls);
        Type mixInAnnotations = JSON.getMixInAnnotations(field.getDeclaringClass());
        Field declaredField = null;
        Class superclass = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (superclass != null) {
            String name = field.getName();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredField = superclass.getDeclaredField(name);
                    break;
                } catch (NoSuchFieldException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredField != null && (a3 = (A) declaredField.getAnnotation(cls)) != null) {
                return a3;
            }
        }
        return a9;
    }

    public static <A extends Annotation> A getAnnotation(Method method, Class<A> cls) {
        A a3;
        A a9 = (A) method.getAnnotation(cls);
        Type mixInAnnotations = JSON.getMixInAnnotations(method.getDeclaringClass());
        Method declaredMethod = null;
        Class superclass = mixInAnnotations instanceof Class ? (Class) mixInAnnotations : null;
        if (superclass != null) {
            String name = method.getName();
            Class<?>[] parameterTypes = method.getParameterTypes();
            while (superclass != null && superclass != Object.class) {
                try {
                    declaredMethod = superclass.getDeclaredMethod(name, parameterTypes);
                    break;
                } catch (NoSuchMethodException unused) {
                    superclass = superclass.getSuperclass();
                }
            }
            if (declaredMethod != null && (a3 = (A) declaredMethod.getAnnotation(cls)) != null) {
                return a3;
            }
        }
        return a9;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T cast(Object obj, Type type, ParserConfig parserConfig) {
        if (obj == 0) {
            return null;
        }
        if (type instanceof Class) {
            return (T) cast(obj, (Class) type, parserConfig);
        }
        if (type instanceof ParameterizedType) {
            return (T) cast(obj, (ParameterizedType) type, parserConfig);
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (str.length() == 0 || "null".equals(str) || "NULL".equals(str)) {
                return null;
            }
        }
        if (type instanceof TypeVariable) {
            return obj;
        }
        throw new JSONException("can not cast to : " + type);
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [T, java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v6, types: [T, java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r9v14, types: [T, java.util.Map$Entry] */
    public static <T> T cast(Object obj, ParameterizedType parameterizedType, ParserConfig parserConfig) {
        Object objCast;
        T t;
        Object objCast2;
        Type rawType = parameterizedType.getRawType();
        if (rawType == List.class || rawType == ArrayList.class) {
            Type type = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof List) {
                List list = (List) obj;
                ?? r10 = (T) new ArrayList(list.size());
                for (Object obj2 : list) {
                    if (type instanceof Class) {
                        if (obj2 != null && obj2.getClass() == JSONObject.class) {
                            objCast = ((JSONObject) obj2).toJavaObject((Class) type, parserConfig, 0);
                        } else {
                            objCast = cast(obj2, (Class<Object>) type, parserConfig);
                        }
                    } else {
                        objCast = cast(obj2, type, parserConfig);
                    }
                    r10.add(objCast);
                }
                return r10;
            }
        }
        if (rawType == Set.class || rawType == HashSet.class || rawType == TreeSet.class || rawType == Collection.class || rawType == List.class || rawType == ArrayList.class) {
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            if (obj instanceof Iterable) {
                if (rawType != Set.class && rawType != HashSet.class) {
                    if (rawType == TreeSet.class) {
                        t = (T) new TreeSet();
                    } else {
                        t = (T) new ArrayList();
                    }
                } else {
                    t = (T) new HashSet();
                }
                for (T t6 : (Iterable) obj) {
                    if (type2 instanceof Class) {
                        if (t6 != null && t6.getClass() == JSONObject.class) {
                            objCast2 = ((JSONObject) t6).toJavaObject((Class) type2, parserConfig, 0);
                        } else {
                            objCast2 = cast((Object) t6, (Class<Object>) type2, parserConfig);
                        }
                    } else {
                        objCast2 = cast(t6, type2, parserConfig);
                    }
                    ((Collection) t).add(objCast2);
                }
                return t;
            }
        }
        if (rawType == Map.class || rawType == HashMap.class) {
            Type type3 = parameterizedType.getActualTypeArguments()[0];
            Type type4 = parameterizedType.getActualTypeArguments()[1];
            if (obj instanceof Map) {
                ?? r11 = (T) new HashMap();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    r11.put(cast(entry.getKey(), type3, parserConfig), cast(entry.getValue(), type4, parserConfig));
                }
                return r11;
            }
        }
        if ((obj instanceof String) && ((String) obj).length() == 0) {
            return null;
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments.length == 1 && (parameterizedType.getActualTypeArguments()[0] instanceof WildcardType)) {
            return (T) cast(obj, rawType, parserConfig);
        }
        if (rawType == Map.Entry.class && (obj instanceof Map)) {
            Map map = (Map) obj;
            if (map.size() == 1) {
                ?? r9 = (T) ((Map.Entry) map.entrySet().iterator().next());
                Object value = r9.getValue();
                if (actualTypeArguments.length == 2 && (value instanceof Map)) {
                    r9.setValue(cast(value, actualTypeArguments[1], parserConfig));
                }
                return r9;
            }
        }
        if (rawType instanceof Class) {
            if (parserConfig == null) {
                parserConfig = ParserConfig.global;
            }
            ObjectDeserializer deserializer = parserConfig.getDeserializer(rawType);
            if (deserializer != null) {
                return (T) deserializer.deserialze(new DefaultJSONParser(JSON.toJSONString(obj), parserConfig), parameterizedType, null);
            }
        }
        throw new JSONException("can not cast to : " + parameterizedType);
    }
}

package com.engagelab.privates.core.constants;

/* JADX INFO: loaded from: classes.dex */
public interface MTCoreConstants {

    public interface Config {
        public static final String APP_CHANNEL = "config_app_channel";
        public static final String APP_KEY = "config_app_key";
        public static final String APP_SITE_NAME = "config_app_site_name";
        public static final String DEBUG_MODE = "config_debug_mode";
        public static final String DEVICE_MIGRATION = "config_device_migration";
        public static final String ENABLE_UDP = "config_enable_udp";
        public static final String IS_SSL = "config_is_ssl";
        public static final String LOG_COLLECTION_CAPACITY = "config_log_collection_capacity";
        public static final String LOG_COLLECTION_ON = "config_log_collection_on";
        public static final String SERVICE_NODE = "config_service_node";
    }

    public interface Heartbeat {
        public static final long DEFAULT_VALUE_HEARTBEAT_INTERVAL = 290000;
    }

    public interface Login {
        public static final String KEY_CODE = "code";
        public static final String KEY_SEED_ID = "seed_id";
        public static final String KEY_SERVER_TIME = "server_time";
    }

    public interface MainWhat {
        public static final int ON_HEARTBEAT = 2003;
        public static final int ON_LOGIN_INTO = 2102;
        public static final int ON_REGISTER_INTO = 2101;
        public static final int ON_TCP_CONNECTED = 2001;
        public static final int ON_TCP_DISCONNECTED = 2002;
    }

    public interface Protocol {
        public static final String KEY_CMD = "cmd";
        public static final String KEY_DATA = "data";
        public static final String KEY_NO_CACHE = "no_cache";
        public static final String KEY_PROTOCOL = "protocol";
    }

    public interface Register {
        public static final String KEY_CODE = "code";
        public static final String KEY_PW = "pwd";
        public static final String KEY_REGISTRATION_ID = "registration_id";
        public static final String KEY_USER_ID = "user_id";
    }

    public interface RemoteWhat {
        public static final int CTRL_DATA = 2235;
        public static final int ON_HEARTBEAT = 2997;
        public static final int ON_TCP_CONNECTED = 2999;
        public static final int ON_TCP_DISCONNECTED = 2998;
        public static final int REPORT = 2233;
        public static final int RETRY_CONNECT = 2990;
        public static final int SET_CONFIG = 2234;
        public static final int START_CONNECT = 2994;
        public static final int START_HEARTBEAT = 2992;
        public static final int STOP_CONNECT = 2993;
        public static final int STOP_HEARTBEAT = 2991;
        public static final int TURN_OFF_CONNECT = 2995;
        public static final int TURN_ON_CONNECT = 2996;
        public static final int UPLOAD = 2222;
    }

    public enum ServiceNode {
        REGION_OVERSEAS,
        REGION_CHINA
    }
}

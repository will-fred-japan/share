package B0;

import android.content.Context;
import android.util.TypedValue;
import com.engagelab.privates.push.constants.MTPushConstants;
import com.jieli.jl_bt_ota.constant.AttrAndFunCode;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;

/* JADX INFO: renamed from: B0.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AssetHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0306u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f1682a;

    public C0306u(Context context) {
        this.f1682a = context;
    }

    public static String a(File file) throws IOException {
        String canonicalPath = file.getCanonicalPath();
        return !canonicalPath.endsWith("/") ? canonicalPath.concat("/") : canonicalPath;
    }

    public static String b(String str) {
        byte b9 = 1;
        String str2 = null;
        if (str != null) {
            String strGuessContentTypeFromName = URLConnection.guessContentTypeFromName(str);
            if (strGuessContentTypeFromName == null) {
                int iLastIndexOf = str.lastIndexOf(46);
                if (iLastIndexOf != -1) {
                    String lowerCase = str.substring(iLastIndexOf + 1).toLowerCase();
                    lowerCase.getClass();
                    switch (lowerCase.hashCode()) {
                        case 3315:
                            b9 = !lowerCase.equals("gz") ? (byte) -1 : (byte) 0;
                            break;
                        case MTPushConstants.MainWhat.OTH_SOUND_ENABLE_SET /* 3401 */:
                            if (!lowerCase.equals("js")) {
                                b9 = -1;
                            }
                            break;
                        case 97669:
                            b9 = !lowerCase.equals("bmp") ? (byte) -1 : (byte) 2;
                            break;
                        case 98819:
                            b9 = !lowerCase.equals("css") ? (byte) -1 : (byte) 3;
                            break;
                        case 102340:
                            b9 = !lowerCase.equals("gif") ? (byte) -1 : (byte) 4;
                            break;
                        case 103649:
                            b9 = !lowerCase.equals("htm") ? (byte) -1 : (byte) 5;
                            break;
                        case 104085:
                            b9 = !lowerCase.equals("ico") ? (byte) -1 : (byte) 6;
                            break;
                        case 105441:
                            b9 = !lowerCase.equals("jpg") ? (byte) -1 : (byte) 7;
                            break;
                        case 106458:
                            b9 = !lowerCase.equals("m4a") ? (byte) -1 : (byte) 8;
                            break;
                        case 106479:
                            b9 = !lowerCase.equals("m4v") ? (byte) -1 : (byte) 9;
                            break;
                        case 108089:
                            b9 = !lowerCase.equals("mht") ? (byte) -1 : (byte) 10;
                            break;
                        case 108150:
                            b9 = !lowerCase.equals("mjs") ? (byte) -1 : (byte) 11;
                            break;
                        case 108272:
                            b9 = !lowerCase.equals("mp3") ? (byte) -1 : (byte) 12;
                            break;
                        case 108273:
                            b9 = !lowerCase.equals("mp4") ? (byte) -1 : (byte) 13;
                            break;
                        case 108324:
                            b9 = !lowerCase.equals("mpg") ? (byte) -1 : (byte) 14;
                            break;
                        case 109961:
                            b9 = !lowerCase.equals("oga") ? (byte) -1 : (byte) 15;
                            break;
                        case 109967:
                            b9 = !lowerCase.equals("ogg") ? (byte) -1 : (byte) 16;
                            break;
                        case 109973:
                            b9 = !lowerCase.equals("ogm") ? (byte) -1 : (byte) 17;
                            break;
                        case 109982:
                            b9 = !lowerCase.equals("ogv") ? (byte) -1 : (byte) 18;
                            break;
                        case 110834:
                            b9 = !lowerCase.equals("pdf") ? (byte) -1 : (byte) 19;
                            break;
                        case 111030:
                            b9 = !lowerCase.equals("pjp") ? (byte) -1 : (byte) 20;
                            break;
                        case 111145:
                            b9 = !lowerCase.equals("png") ? (byte) -1 : (byte) 21;
                            break;
                        case 114276:
                            b9 = !lowerCase.equals("svg") ? (byte) -1 : AttrAndFunCode.SYS_INFO_FUNCTION_LOW_POWER;
                            break;
                        case 114791:
                            b9 = !lowerCase.equals("tgz") ? (byte) -1 : (byte) 23;
                            break;
                        case 114833:
                            b9 = !lowerCase.equals("tif") ? (byte) -1 : (byte) 24;
                            break;
                        case 117484:
                            b9 = !lowerCase.equals("wav") ? (byte) -1 : (byte) 25;
                            break;
                        case 118660:
                            b9 = !lowerCase.equals("xht") ? (byte) -1 : (byte) 26;
                            break;
                        case 118807:
                            b9 = !lowerCase.equals("xml") ? (byte) -1 : (byte) 27;
                            break;
                        case 120609:
                            b9 = !lowerCase.equals("zip") ? (byte) -1 : (byte) 28;
                            break;
                        case 3000872:
                            b9 = !lowerCase.equals("apng") ? (byte) -1 : (byte) 29;
                            break;
                        case 3145576:
                            b9 = !lowerCase.equals("flac") ? (byte) -1 : (byte) 30;
                            break;
                        case 3213227:
                            b9 = !lowerCase.equals("html") ? (byte) -1 : (byte) 31;
                            break;
                        case 3259225:
                            b9 = !lowerCase.equals("jfif") ? (byte) -1 : (byte) 32;
                            break;
                        case 3268712:
                            b9 = !lowerCase.equals("jpeg") ? (byte) -1 : (byte) 33;
                            break;
                        case 3271912:
                            b9 = !lowerCase.equals(MTPushConstants.Analysis.KEY_JSON) ? (byte) -1 : (byte) 34;
                            break;
                        case 3358085:
                            b9 = !lowerCase.equals("mpeg") ? (byte) -1 : (byte) 35;
                            break;
                        case 3418175:
                            b9 = !lowerCase.equals("opus") ? (byte) -1 : (byte) 36;
                            break;
                        case 3529614:
                            b9 = !lowerCase.equals("shtm") ? (byte) -1 : (byte) 37;
                            break;
                        case 3542678:
                            b9 = !lowerCase.equals("svgz") ? (byte) -1 : (byte) 38;
                            break;
                        case 3559925:
                            b9 = !lowerCase.equals("tiff") ? (byte) -1 : (byte) 39;
                            break;
                        case 3642020:
                            b9 = !lowerCase.equals("wasm") ? (byte) -1 : (byte) 40;
                            break;
                        case 3645337:
                            b9 = !lowerCase.equals("webm") ? (byte) -1 : (byte) 41;
                            break;
                        case 3645340:
                            b9 = !lowerCase.equals("webp") ? (byte) -1 : (byte) 42;
                            break;
                        case 3655064:
                            b9 = !lowerCase.equals("woff") ? (byte) -1 : (byte) 43;
                            break;
                        case 3678569:
                            b9 = !lowerCase.equals("xhtm") ? (byte) -1 : (byte) 44;
                            break;
                        case 96488848:
                            b9 = !lowerCase.equals("ehtml") ? (byte) -1 : (byte) 45;
                            break;
                        case 103877016:
                            b9 = !lowerCase.equals("mhtml") ? (byte) -1 : (byte) 46;
                            break;
                        case 106703064:
                            b9 = !lowerCase.equals("pjpeg") ? (byte) -1 : (byte) 47;
                            break;
                        case 109418142:
                            b9 = !lowerCase.equals("shtml") ? (byte) -1 : (byte) 48;
                            break;
                        case 114035747:
                            b9 = !lowerCase.equals("xhtml") ? (byte) -1 : (byte) 49;
                            break;
                        default:
                            b9 = -1;
                            break;
                    }
                    switch (b9) {
                        case 0:
                        case 23:
                            str2 = "application/gzip";
                            break;
                        case 1:
                        case 11:
                            str2 = "text/javascript";
                            break;
                        case 2:
                            str2 = "image/bmp";
                            break;
                        case 3:
                            str2 = "text/css";
                            break;
                        case 4:
                            str2 = "image/gif";
                            break;
                        case 5:
                        case 31:
                        case 37:
                        case 45:
                        case 48:
                            str2 = "text/html";
                            break;
                        case 6:
                            str2 = "image/x-icon";
                            break;
                        case 7:
                        case 20:
                        case 32:
                        case 33:
                        case 47:
                            str2 = "image/jpeg";
                            break;
                        case 8:
                            str2 = "audio/x-m4a";
                            break;
                        case 9:
                        case 13:
                            str2 = "video/mp4";
                            break;
                        case 10:
                        case 46:
                            str2 = "multipart/related";
                            break;
                        case 12:
                            str2 = "audio/mpeg";
                            break;
                        case 14:
                        case 35:
                            str2 = "video/mpeg";
                            break;
                        case 15:
                        case 16:
                        case 36:
                            str2 = "audio/ogg";
                            break;
                        case 17:
                        case 18:
                            str2 = "video/ogg";
                            break;
                        case 19:
                            str2 = "application/pdf";
                            break;
                        case 21:
                            str2 = "image/png";
                            break;
                        case 22:
                        case 38:
                            str2 = "image/svg+xml";
                            break;
                        case 24:
                        case 39:
                            str2 = "image/tiff";
                            break;
                        case 25:
                            str2 = "audio/wav";
                            break;
                        case 26:
                        case 44:
                        case 49:
                            str2 = "application/xhtml+xml";
                            break;
                        case 27:
                            str2 = "text/xml";
                            break;
                        case 28:
                            str2 = "application/zip";
                            break;
                        case 29:
                            str2 = "image/apng";
                            break;
                        case 30:
                            str2 = "audio/flac";
                            break;
                        case 34:
                            str2 = "application/json";
                            break;
                        case 40:
                            str2 = "application/wasm";
                            break;
                        case 41:
                            str2 = "video/webm";
                            break;
                        case 42:
                            str2 = "image/webp";
                            break;
                        case 43:
                            str2 = "application/font-woff";
                            break;
                    }
                }
            } else {
                str2 = strGuessContentTypeFromName;
            }
        }
        return str2 == null ? "text/plain" : str2;
    }

    public final InputStream c(String str) throws IOException {
        if (str.length() > 1 && str.charAt(0) == '/') {
            str = str.substring(1);
        }
        String[] strArrSplit = str.split("/", -1);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Incorrect resource path: ".concat(str));
        }
        String str2 = strArrSplit[0];
        String strSubstring = strArrSplit[1];
        int iLastIndexOf = strSubstring.lastIndexOf(46);
        if (iLastIndexOf != -1) {
            strSubstring = strSubstring.substring(0, iLastIndexOf);
        }
        Context context = this.f1682a;
        int identifier = context.getResources().getIdentifier(strSubstring, str2, context.getPackageName());
        TypedValue typedValue = new TypedValue();
        context.getResources().getValue(identifier, typedValue, true);
        int i9 = typedValue.type;
        if (i9 != 3) {
            throw new IOException(String.format("Expected %s resource to be of TYPE_STRING but was %d", str, Integer.valueOf(i9)));
        }
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(identifier);
        return str.endsWith(".svgz") ? new GZIPInputStream(inputStreamOpenRawResource) : inputStreamOpenRawResource;
    }
}

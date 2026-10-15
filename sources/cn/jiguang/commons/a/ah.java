package cn.jiguang.commons.a;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ah extends File implements Parcelable {
    public static final Parcelable.Creator<ah> CREATOR = new ai();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9659b;

    public ah(Parcel parcel) {
        super(parcel.readString());
        this.f9659b = parcel.readString();
    }

    public static String b(String str) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(str));
        while (true) {
            try {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    return sb.toString().trim();
                }
                sb.append(line);
                sb.append(System.lineSeparator());
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.io.File
    public long length() {
        return this.f9659b.length();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i9) {
        parcel.writeString(getAbsolutePath());
        parcel.writeString(this.f9659b);
    }

    public ah(String str) {
        super(str);
        this.f9659b = b(str);
    }
}

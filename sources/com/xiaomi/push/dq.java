package com.xiaomi.push;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
class dq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f17266a = "/MiPushLog";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private int f273a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f276a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private String f277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f17268c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @SuppressLint({"SimpleDateFormat"})
    private final SimpleDateFormat f274a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f17267b = 2097152;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private ArrayList<File> f275a = new ArrayList<>();

    public dq a(Date date, Date date2) {
        if (date.after(date2)) {
            this.f277b = this.f274a.format(date2);
            this.f17268c = this.f274a.format(date);
            return this;
        }
        this.f277b = this.f274a.format(date);
        this.f17268c = this.f274a.format(date2);
        return this;
    }

    public void a(int i9) {
        if (i9 != 0) {
            this.f17267b = i9;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public dq m246a(File file) {
        if (file.exists()) {
            this.f275a.add(file);
        }
        return this;
    }

    private void a(BufferedReader bufferedReader, BufferedWriter bufferedWriter, Pattern pattern) throws IOException {
        char[] cArr = new char[4096];
        int i9 = bufferedReader.read(cArr);
        boolean z8 = false;
        while (i9 != -1 && !z8) {
            String str = new String(cArr, 0, i9);
            Matcher matcher = pattern.matcher(str);
            int length = 0;
            int i10 = 0;
            while (length < i9 && matcher.find(length)) {
                int iStart = matcher.start();
                String strSubstring = str.substring(iStart, this.f277b.length() + iStart);
                if (!this.f276a) {
                    if (strSubstring.compareTo(this.f277b) >= 0) {
                        this.f276a = true;
                        i10 = iStart;
                    }
                } else if (strSubstring.compareTo(this.f17268c) > 0) {
                    z8 = true;
                    i9 = iStart;
                    break;
                }
                int iIndexOf = str.indexOf(10, iStart);
                length = iIndexOf != -1 ? iStart + iIndexOf : this.f277b.length() + iStart;
            }
            if (this.f276a) {
                int i11 = i9 - i10;
                this.f273a += i11;
                if (z8) {
                    bufferedWriter.write(cArr, i10, i11);
                    return;
                } else {
                    bufferedWriter.write(cArr, i10, i11);
                    if (this.f273a > this.f17267b) {
                        return;
                    }
                }
            }
            i9 = bufferedReader.read(cArr);
        }
    }

    private void a(File file) throws Throwable {
        BufferedReader bufferedReader;
        Pattern patternCompile = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        BufferedWriter bufferedWriter = null;
        bufferedReader = null;
        bufferedReader = null;
        bufferedReader = null;
        BufferedReader bufferedReader2 = null;
        bufferedWriter = null;
        bufferedWriter = null;
        bufferedWriter = null;
        try {
            try {
                BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
                try {
                    bufferedWriter2.write("model :" + l.a() + "; os :" + k.e() + "; uid :" + com.xiaomi.push.service.bi.m774a() + "; lng :" + Locale.getDefault().toString() + "; sdk :" + com.xiaomi.push.service.f.a() + "; andver :" + Build.VERSION.SDK_INT + "\n");
                    this.f273a = 0;
                    Iterator<File> it = this.f275a.iterator();
                    while (it.hasNext()) {
                        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(it.next())));
                        try {
                            a(bufferedReader, bufferedWriter2, patternCompile);
                            bufferedReader.close();
                            bufferedReader2 = bufferedReader;
                        } catch (FileNotFoundException e9) {
                            e = e9;
                            bufferedWriter = bufferedWriter2;
                            com.xiaomi.channel.commonutils.logger.c.c("LOG: filter error = " + e.getMessage());
                            y.a(bufferedWriter);
                            y.a(bufferedReader);
                            return;
                        } catch (IOException e10) {
                            e = e10;
                            bufferedWriter = bufferedWriter2;
                            com.xiaomi.channel.commonutils.logger.c.c("LOG: filter error = " + e.getMessage());
                            y.a(bufferedWriter);
                            y.a(bufferedReader);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedWriter = bufferedWriter2;
                            y.a(bufferedWriter);
                            y.a(bufferedReader);
                            throw th;
                        }
                    }
                    bufferedWriter2.write(ct.a().c());
                    y.a(bufferedWriter2);
                    y.a(bufferedReader2);
                } catch (FileNotFoundException e11) {
                    e = e11;
                    bufferedReader = bufferedReader2;
                } catch (IOException e12) {
                    e = e12;
                    bufferedReader = bufferedReader2;
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (FileNotFoundException e13) {
            e = e13;
            bufferedReader = null;
        } catch (IOException e14) {
            e = e14;
            bufferedReader = null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
        }
    }

    public File a(Context context, Date date, Date date2, File file) throws Throwable {
        File fileA;
        if ("com.xiaomi.xmsf".equalsIgnoreCase(context.getPackageName())) {
            fileA = dp.a(context);
            if (fileA == null) {
                return null;
            }
            m246a(new File(fileA, "xmsf.log.1"));
            m246a(new File(fileA, "xmsf.log"));
        } else {
            File file2 = new File(context.getFilesDir() + f17266a);
            if (!x.m843a(file2)) {
                return null;
            }
            m246a(new File(file2, "log0.txt"));
            m246a(new File(file2, "log1.txt"));
            fileA = file2;
        }
        if (!fileA.isDirectory()) {
            return null;
        }
        File file3 = new File(file, date.getTime() + Constants.ACCEPT_TIME_SEPARATOR_SERVER + date2.getTime() + ".zip");
        if (file3.exists()) {
            return null;
        }
        a(date, date2);
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file4 = new File(file, "log.txt");
        a(file4);
        com.xiaomi.channel.commonutils.logger.c.c("LOG: filter cost = " + (System.currentTimeMillis() - jCurrentTimeMillis));
        if (!file4.exists()) {
            return null;
        }
        long jCurrentTimeMillis2 = System.currentTimeMillis();
        y.a(file3, file4);
        com.xiaomi.channel.commonutils.logger.c.c("LOG: zip cost = " + (System.currentTimeMillis() - jCurrentTimeMillis2));
        file4.delete();
        if (file3.exists()) {
            return file3;
        }
        return null;
    }
}

package com.hack.utils;

import android.content.Context;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* JADX INFO: loaded from: classes.dex */
public class FileUtils {
    private static final boolean DEBUG = false;
    private static final int FILE_BYTE_BUFFER = 4096;
    private static final String TAG = "FileUtils";

    public static int copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        int i = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return i;
            }
            i += i2;
            outputStream.write(bArr, 0, i2);
        }
    }

    public static int copyAndClose(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            byte[] bArr = new byte[4096];
            int i = 0;
            while (true) {
                int i2 = inputStream.read(bArr);
                if (i2 != -1) {
                    i += i2;
                    outputStream.write(bArr, 0, i2);
                } else {
                    closeQuietly(inputStream);
                    closeQuietly(outputStream);
                    return i;
                }
            }
        } catch (Throwable th) {
            closeQuietly(inputStream);
            closeQuietly(outputStream);
            throw th;
        }
    }

    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void extractAsset(Context context, String str, File file) throws IOException {
        file.getParentFile().mkdirs();
        copyAndClose(context.getAssets().open(str), new FileOutputStream(file));
    }

    public static void extractFile(File file, String str, File file2) throws Throwable {
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(file);
            try {
                Enumeration<? extends ZipEntry> enumerationEntries = zipFile2.entries();
                String canonicalPath = file2.getCanonicalPath();
                while (enumerationEntries.hasMoreElements()) {
                    ZipEntry zipEntryNextElement = enumerationEntries.nextElement();
                    if (zipEntryNextElement.getName().startsWith(str) && !zipEntryNextElement.isDirectory()) {
                        File file3 = new File(file2, zipEntryNextElement.getName());
                        if (!file3.getCanonicalPath().startsWith(canonicalPath)) {
                            throw new IOException("security path " + zipEntryNextElement.getName());
                        }
                        file3.getParentFile().mkdirs();
                        copyAndClose(zipFile2.getInputStream(zipEntryNextElement), new FileOutputStream(file3));
                    }
                }
                try {
                    zipFile2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Throwable th) {
                th = th;
                zipFile = zipFile2;
                if (zipFile != null) {
                    try {
                        zipFile.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean deleteQuietly(File file) {
        File[] fileArrListFiles;
        try {
            if (!file.isFile() && (fileArrListFiles = file.listFiles()) != null) {
                for (File file2 : fileArrListFiles) {
                    deleteQuietly(file2);
                }
            }
            return file.delete();
        } catch (Exception unused) {
            return false;
        }
    }

    public static String readString(File file) {
        return readString(file, StandardCharsets.UTF_8);
    }

    public static String readString(File file, Charset charset) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            String string = readString(fileInputStream, charset);
            fileInputStream.close();
            return string;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String readString(InputStream inputStream, Charset charset) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            copy(inputStream, byteArrayOutputStream);
            if (charset != null) {
                return new String(byteArrayOutputStream.toByteArray(), charset);
            }
            return byteArrayOutputStream.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void writeString(File file, String str) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            file.getParentFile().mkdirs();
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                fileOutputStream2.write(str.getBytes());
                closeQuietly(fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                closeQuietly(fileOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean copyFile(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int i = inputStream.read(bArr);
                    if (i != -1) {
                        fileOutputStream2.write(bArr, 0, i);
                    } else {
                        fileOutputStream2.flush();
                        closeQuietly(inputStream);
                        closeQuietly(fileOutputStream2);
                        return true;
                    }
                }
            } catch (Throwable unused) {
                fileOutputStream = fileOutputStream2;
                closeQuietly(inputStream);
                closeQuietly(fileOutputStream);
                return false;
            }
        } catch (Throwable unused2) {
        }
    }
}

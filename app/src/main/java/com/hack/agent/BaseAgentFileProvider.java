package com.hack.agent;

import android.content.ContentProvider;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import com.hack.opensdk.Cmd;
import com.hack.opensdk.CmdConstants;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class BaseAgentFileProvider extends ContentProvider {
    private static final String TAG = "proxies.BaseAgentFileProvider";

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    public static ContentProviderClient getClient(Context context, Uri uri) {
        return context.getContentResolver().acquireContentProviderClient(uri.getAuthority());
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Uri uri2 = (Uri) Cmd.INSTANCE().exec(CmdConstants.CMD_FILE_PROVIDER_MAKE_URI, uri);
        ContentProviderClient client = getClient(getContext(), uri2);
        if (client == null) {
            return null;
        }
        try {
            return client.query(uri2, strArr, str, strArr2, str2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Log.e(TAG, "getType: " + uri);
        Uri uri2 = (Uri) Cmd.INSTANCE().exec(CmdConstants.CMD_FILE_PROVIDER_MAKE_URI, uri);
        ContentProviderClient client = getClient(getContext(), uri2);
        if (client == null) {
            return null;
        }
        try {
            return client.getType(uri2);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        Uri uri2 = (Uri) Cmd.INSTANCE().exec(CmdConstants.CMD_FILE_PROVIDER_MAKE_URI, uri);
        ContentProviderClient client = getClient(getContext(), uri2);
        if (client == null) {
            return null;
        }
        try {
            return client.insert(uri2, contentValues);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Uri uri2 = (Uri) Cmd.INSTANCE().exec(CmdConstants.CMD_FILE_PROVIDER_MAKE_URI, uri);
        ContentProviderClient client = getClient(getContext(), uri2);
        if (client != null) {
            try {
                return client.delete(uri2, str, strArr);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        Log.e(TAG, "update: " + uri);
        Uri uri2 = (Uri) Cmd.INSTANCE().exec(CmdConstants.CMD_FILE_PROVIDER_MAKE_URI, uri);
        ContentProviderClient client = getClient(getContext(), uri2);
        if (client != null) {
            try {
                return client.update(uri2, contentValues, str, strArr);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public int bulkInsert(Uri uri, ContentValues[] contentValuesArr) {
        Log.e(TAG, "bulkInsert: " + uri);
        Uri uri2 = (Uri) Cmd.INSTANCE().exec(CmdConstants.CMD_FILE_PROVIDER_MAKE_URI, uri);
        ContentProviderClient client = getClient(getContext(), uri2);
        if (client != null) {
            try {
                return client.bulkInsert(uri2, contentValuesArr);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        Uri uri2 = (Uri) Cmd.INSTANCE().exec(CmdConstants.CMD_FILE_PROVIDER_MAKE_URI, uri);
        String str2 = TAG;
        Log.e(str2, "openAssetFile " + uri + ", str " + str + "->" + uri2);
        ContentProviderClient client = getClient(getContext(), uri2);
        Log.e(str2, "openAssetFile: client result " + client);
        if (client != null) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFile = client.openAssetFile(uri2, str);
                Log.e(str2, "openAssetFile  result " + uri + ", str " + str + "->" + assetFileDescriptorOpenAssetFile);
                return assetFileDescriptorOpenAssetFile;
            } catch (RemoteException e) {
                e.printStackTrace();
                Log.e(TAG, "openAssetFile  result " + uri, e);
                throw new FileNotFoundException(uri.toString());
            }
        }
        return super.openAssetFile(uri, str);
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        Uri uri2 = (Uri) Cmd.INSTANCE().exec(CmdConstants.CMD_FILE_PROVIDER_MAKE_URI, uri);
        String str2 = TAG;
        Log.e(str2, "openAssetFile 2" + uri + ", str " + str + ", cancellationSignal " + cancellationSignal + "->" + uri2);
        ContentProviderClient client = getClient(getContext(), uri2);
        if (client != null) {
            try {
                AssetFileDescriptor assetFileDescriptorOpenAssetFile = client.openAssetFile(uri2, str, cancellationSignal);
                Log.e(str2, "openAssetFile 2  result " + uri2 + ", str " + str + "->" + client.getLocalContentProvider());
                return assetFileDescriptorOpenAssetFile;
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return super.openAssetFile(uri, str, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        Log.e(TAG, "openFile: " + uri);
        Uri uri2 = (Uri) Cmd.INSTANCE().exec(CmdConstants.CMD_FILE_PROVIDER_MAKE_URI, uri);
        ContentProviderClient client = getClient(getContext(), uri2);
        if (client != null) {
            try {
                return client.openFile(uri2, str);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return super.openFile(uri, str);
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str, CancellationSignal cancellationSignal) throws FileNotFoundException {
        Log.e(TAG, "openFile: " + uri);
        Uri uri2 = (Uri) Cmd.INSTANCE().exec(CmdConstants.CMD_FILE_PROVIDER_MAKE_URI, uri);
        ContentProviderClient client = getClient(getContext(), uri2);
        if (client != null) {
            try {
                return client.openFile(uri2, str, cancellationSignal);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return super.openFile(uri, str, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle) throws FileNotFoundException {
        Log.e(TAG, "openTypedAssetFile: " + uri);
        Uri uri2 = (Uri) Cmd.INSTANCE().exec(CmdConstants.CMD_FILE_PROVIDER_MAKE_URI, uri);
        ContentProviderClient client = getClient(getContext(), uri2);
        if (client != null) {
            try {
                return client.openTypedAssetFileDescriptor(uri2, str, bundle);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return super.openTypedAssetFile(uri, str, bundle);
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openTypedAssetFile(Uri uri, String str, Bundle bundle, CancellationSignal cancellationSignal) throws FileNotFoundException {
        Log.e(TAG, "openTypedAssetFile: " + uri);
        Uri uri2 = (Uri) Cmd.INSTANCE().exec(CmdConstants.CMD_FILE_PROVIDER_MAKE_URI, uri);
        ContentProviderClient client = getClient(getContext(), uri2);
        if (client != null) {
            try {
                return client.openTypedAssetFile(uri2, str, bundle, cancellationSignal);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        return super.openTypedAssetFile(uri, str, bundle, cancellationSignal);
    }

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        String str = TAG;
        Log.e(str, "applyBatch: ");
        if (arrayList != null) {
            Log.d(str, "applyBatch operations " + Arrays.toString(arrayList.toArray()));
        }
        return super.applyBatch(arrayList);
    }
}

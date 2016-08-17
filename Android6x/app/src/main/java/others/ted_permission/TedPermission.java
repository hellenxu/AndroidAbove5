package others.ted_permission;

import android.content.Context;
import android.os.Build;
import android.support.annotation.StringRes;


/**
 * Created by TedPark on 16. 2. 17..
 */
public class TedPermission {

    private static TedInstance instance;

    public TedPermission(Context context) {
         instance = new TedInstance(context);
    }

    public TedPermission setPermissionListener(PermissionListener listener) {
        instance.listener = listener;
        return this;
    }

    public TedPermission setPermissions(String... permissions) {
        instance.permissions = permissions;
        return this;
    }

    public TedPermission setRationaleMessage(String rationaleMessage) {
        instance.rationaleMessage = rationaleMessage;
        return this;
    }


    public TedPermission setRationaleMessage(@StringRes int stringRes) {
        if (stringRes <= 0)
            throw new IllegalArgumentException("Invalid value for RationaleMessage");

        instance.rationaleMessage = instance.context.getString(stringRes);
        return this;
    }



    public TedPermission setDeniedMessage(String denyMessage) {
        instance.denyMessage = denyMessage;
        return this;
    }



    public TedPermission setDeniedMessage(@StringRes int stringRes) {
        if (stringRes <= 0)
            throw new IllegalArgumentException("Invalid value for DeniedMessage");

        instance.rationaleMessage = instance.context.getString(stringRes);
        return this;
    }


    public TedPermission setGotoSettingButton(boolean hasSettingBtn) {
        instance.hasSettingBtn = hasSettingBtn;
        return this;
    }




    public TedPermission setRationaleConfirmText(String rationaleConfirmText) {
        instance.rationaleConfirmText = rationaleConfirmText;
        return this;
    }


    public TedPermission setRationaleConfirmText(@StringRes int stringRes) {
        if (stringRes <= 0)
            throw new IllegalArgumentException("Invalid value for RationaleConfirmText");

        instance.rationaleConfirmText = instance.context.getString(stringRes);

        return this;
    }



    public TedPermission setDeniedCloseButtonText(String deniedCloseButtonText) {
        instance.deniedCloseButtonText = deniedCloseButtonText;
        return this;
    }


    public TedPermission setDeniedCloseButtonText(@StringRes int stringRes) {
        if (stringRes <= 0)
            throw new IllegalArgumentException("Invalid value for DeniedCloseButtonText");

        instance.deniedCloseButtonText = instance.context.getString(stringRes);
        return this;
    }


    public void check() {
        if (instance.listener == null) {
            throw new NullPointerException("You must setPermissionListener() on TedPermission");
        } else if (instance.permissions == null || instance.permissions.length == 0) {
            throw new NullPointerException("You must setPermissions() on TedPermission");
        }

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            instance.listener.onPermissionGranted();
        } else {
            instance.checkPermissions();
        }
    }


}

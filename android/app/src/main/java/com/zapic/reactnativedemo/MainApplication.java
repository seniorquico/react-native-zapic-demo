package com.zapic.reactnativedemo;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.zapic.sdk.android.Zapic;
import com.zapic.sdk.android.ZapicPlayer;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new ZapicPackage()
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();

    Zapic.start(new Zapic.AuthenticationHandler() {
        @Override
        public void onLogin(@NonNull ZapicPlayer player) {
            Log.d("ZAPIC", "Player logged in: " + player.getPlayerId());
        }

        @Override
        public void onLogout(@NonNull ZapicPlayer player) {
            Log.d("ZAPIC", "Player logged out: " + player.getPlayerId());
        }
    });

    SoLoader.init(this, /* native exopackage */ false);
  }
}

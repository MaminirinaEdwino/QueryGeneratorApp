// package com.monentreprise.monquerygenerator;

// import androidx.appcompat.app.AppCompatActivity;
// import androidx.fragment.app.Fragment;
// import androidx.fragment.app.FragmentManager;

// import android.os.Bundle;

// public class MainActivity extends AppCompatActivity {
//     @Override
//     protected void onCreate(Bundle savedInstanceState) {
//         super.onCreate(savedInstanceState);
//         setContentView(R.layout.activity_main);
//     }
// }

package com.monentreprise.monquerygenerator;

// import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import com.monentreprise.monquerygenerator.R;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = (WebView) findViewById(R.id.my_webview);
        WebSettings settings = webView.getSettings();
        
        // Configuration indispensable
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);

        // Chargement du fichier local
        webView.loadUrl("file:///android_asset/index.html");
        // webView.loadUrl("file:///asset/index.html");
    }
}
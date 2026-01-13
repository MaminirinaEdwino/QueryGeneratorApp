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
import java.io.File;
import java.io.FileOutputStream;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 

        if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) 
            != android.content.pm.PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }


        WebView webView = (WebView) findViewById(R.id.my_webview);
        WebSettings settings = webView.getSettings();
        
        // Configuration indispensable
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAllowUniversalAccessFromFileURLs(true);
        webView.addJavascriptInterface(new WebAppInterface(), "AndroidBridge");
        // Chargement du fichier local
        webView.loadUrl("file:///android_asset/index.html");
        // webView.loadUrl("file:///asset/index.html");
        
    }

    // public class WebAppInterface {
    //     @JavascriptInterface
    //     public void saveSqlFile(String content) {
    //         try {
    //             // Sauvegarde dans le dossier "Documents" de l'application
    //             File path = getExternalFilesDir(null);
    //             File file = new File(path, "ma_requete.sql");
                
    //             FileOutputStream stream = new FileOutputStream(file);
    //             stream.write(content.getBytes());
    //             stream.close();
                
    //             // On affiche un message sur le téléphone
    //             runOnUiThread(() -> Toast.makeText(MainActivity.this, 
    //                 "Fichier exporté dans : " + file.getAbsolutePath(), 
    //                 Toast.LENGTH_LONG).show());
    //         } catch (Exception e) {
    //             e.printStackTrace();
    //         }
    //     }
    // }
    public class WebAppInterface {
        @JavascriptInterface
        public void saveSqlFile(String content) {
            try {
                // On cible le dossier Downloads public
                File path = android.os.Environment.getExternalStoragePublicDirectory(
                    android.os.Environment.DIRECTORY_DOWNLOADS);
                
                File file = new File(path, "ma_requete.sql");
                
                java.io.FileOutputStream stream = new java.io.FileOutputStream(file);
                stream.write(content.getBytes());
                stream.close();
                
                MainActivity.this.runOnUiThread(() -> 
                    Toast.makeText(MainActivity.this, "Fichier enregistré dans Téléchargements !"+path, Toast.LENGTH_LONG).show()
                );
            } catch (Exception e) {
                // Si ça échoue, c'est probablement un problème de permission
                MainActivity.this.runOnUiThread(() -> 
                    Toast.makeText(MainActivity.this, "Erreur : Permission refusée", Toast.LENGTH_SHORT).show()
                );
                e.printStackTrace();
            }
        }
    }
}


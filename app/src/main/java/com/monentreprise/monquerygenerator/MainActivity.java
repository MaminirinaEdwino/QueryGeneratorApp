package com.monentreprise.monquerygenerator;

import android.app.Activity;
import android.os.Bundle;

// MainActivity est la première Activity à s'exécuter
public class MainActivity extends Activity {

    // Méthode appelée lorsque l'Activity est créée (équivalent du 'main')
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Relie l'interface Java au fichier de mise en page XML
        // R.layout.activity_main fait référence au fichier res/layout/activity_main.xml
        setContentView(R.layout.activity_main);
        
        // Le code pour le TextView n'est pas nécessaire ici car le texte
        // est déjà défini dans le fichier XML via android:text="@string/hello_world"
    }

    
}
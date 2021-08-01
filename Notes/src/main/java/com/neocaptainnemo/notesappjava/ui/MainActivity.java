package com.neocaptainnemo.notesappjava.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.neocaptainnemo.notesappjava.R;
import com.neocaptainnemo.notesappjava.RouterHolder;
import com.neocaptainnemo.notesappjava.ui.auth.AuthFragment;

public class MainActivity extends AppCompatActivity implements RouterHolder {

    private MainRouter router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        router = new MainRouter(getSupportFragmentManager());

        if (savedInstanceState == null) {
            router.showAuth();
        }

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            if (item.getItemId() == R.id.action_notes) {
                router.showAuth();
            }

            if (item.getItemId() == R.id.action_info) {
                router.showInfo();
            }
            return true;
        });
        getSupportFragmentManager().setFragmentResultListener(AuthFragment.AUTH_RESULT, this, (requestKey, result) -> router.showNotes());

//        Context applicationContext = getApplicationContext();
//
//        Context application = getApplication();
//
//        Context thisContext = this;
//
//        new SomeStrangeClass(applicationContext);
//
//        LayoutInflater.from(thisContext);
    }

    @Override
    public MainRouter getMainRouter() {
        return router;
    }
}
package sg.edu.rp.webservices.dmsdchatapp;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {
    String TAG = ">>";

    EditText etDisplayName;
    Button btnDisplayName;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference userListRef;

    @Override
    protected void onResume() {
        super.onResume();

        userListRef = firebaseDatabase.getReference("/P13-DB/userList/");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();

        final String uid = firebaseUser.getUid();
        Log.i(TAG, "onCreate: " + uid);
        userListRef = firebaseDatabase.getReference("/P13-DB/userList/");

        etDisplayName = (EditText) findViewById(R.id.etName);
        btnDisplayName = (Button) findViewById(R.id.btnSubmitName);

        btnDisplayName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String display_name = etDisplayName.getText().toString();
                userListRef.child(uid).setValue(display_name);

                Intent i = new Intent(ProfileActivity.this, ChatActivity.class);
                startActivity(i);


            }
        });
    }
}
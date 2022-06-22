package iut.paci.classroomcommunity.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import iut.paci.classroomcommunity.MainActivity;
import iut.paci.classroomcommunity.R;

public class LoginActivity extends AppCompatActivity {
    TextView welcomeText;
    EditText username, password;
    String usn, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        welcomeText = findViewById(R.id.welcomeText);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.pax);
    }

    public void login(View v) {
        usn = username.getText().toString().trim();
        pass = password.getText().toString().trim();
        String usnDefini = "ferdo";
        String passDefini = "ferdo";
        if (usn.equals(usnDefini) && pass.equals(passDefini)) {
            Intent redirection = new Intent(getApplicationContext(), QuizzActivity.class);
            redirection.putExtra("name",usn);
            startActivity(redirection);
        } else if (usn.isEmpty() || pass.isEmpty()) {
            AlertDialog.Builder popup = new AlertDialog.Builder(this);
            popup.setTitle("Vide");
            popup.setMessage("Veuillez remplir tous les champs");
            popup.setPositiveButton("Reessayer", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {}
            });
            popup.show();
            return;
        } else {
            AlertDialog.Builder popup = new AlertDialog.Builder(this);
            popup.setTitle("Erreur");
            popup.setMessage("Identifiant ou mot de passe incorrect");
            popup.setPositiveButton("Reessayer", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {}
            });
            popup.show();
            return;
           // Toast.makeText(this, "Mot de passe incorect", Toast.LENGTH_SHORT).show();
//                //return;
        }


    }


}
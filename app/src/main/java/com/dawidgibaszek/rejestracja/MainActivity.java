package com.dawidgibaszek.rejestracja;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button confirmBtn;
    private TextView coms;
    private EditText passInput;
    private EditText repassInput;
    private EditText mailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.confirmBtn = findViewById(R.id.confirmBtn);
        this.coms = findViewById(R.id.coms);
        this.passInput = findViewById(R.id.passInput);
        this.repassInput = findViewById(R.id.repassInput);
        this.mailInput = findViewById(R.id.mailInput);

        this.confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!checkMail()) coms.setText("Niepoprawny adres email");
                else if (!checkPass()) coms.setText("Hasła się różnią");
                else coms.setText("Witaj " + mailInput.getText().toString());
            }
        });
    }

    public boolean checkMail() {
        return mailInput.getText().toString().contains("@");
    }

    public boolean checkPass() {
        return passInput.getText().toString().equals(repassInput.getText().toString());
    }
}
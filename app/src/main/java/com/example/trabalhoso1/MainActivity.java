package com.example.trabalhoso1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView, title;
    private Button button;

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

        editText = findViewById(R.id.editTextText);
        button = findViewById(R.id.btn01);
        textView = findViewById(R.id.textView);

        button.setOnClickListener(v -> {
            String input = editText.getText().toString();
            if (input.isEmpty()){
                editText.setError(getString(R.string.alert1));
                return;
            }
            int number = Integer.parseInt(input);
            if (number < 0 || number > 100) {
                editText.setError(getString(R.string.alert2));
                editText.setText("");
                return;
            }
            title = findViewById(R.id.titulo);
            title.setText(R.string.titleresultado);
            button.setText(R.string.script_buscanovamente);
            textView.setText("");
            editText.setText("");
            editText.setHint(getString(R.string.num));
            title.append(input);
            title.setVisibility(View.VISIBLE);
            String resultado = calcNaoPrimos(number);
            textView.setText(resultado);

    });
    }

        private String calcNaoPrimos(int numInserted){
            StringBuilder naoPrimos = new StringBuilder();

                    for (int i = 0; i <= numInserted; i++)
                    {
                        if (!primo(i)){
                            naoPrimos.append(i).append(" ; ");
                        }
                    }
            return naoPrimos.toString();
        }

        private boolean primo(int num){
            if (num <2 ) return false;
            for (int i = 2; i <= Math.sqrt(num); i++){
                if (num % i == 0) return false;
            }
            return true;
        }


    }

package calculadora.uninter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static calculadora.uninter.R.id.visor_principal;

public class MainActivity extends AppCompatActivity {

    private TextView visorPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Visor */
        visorPrincipal = (TextView) findViewById(visor_principal);

        /* botoes numericos */
        Button btn_0 = findViewById(R.id.btn_0);
        Button btn_1 = findViewById(R.id.btn_1);
        Button btn_2 = findViewById(R.id.btn_2);
        Button btn_3 = findViewById(R.id.btn_3);
        Button btn_4 = findViewById(R.id.btn_4);
        Button btn_5 = findViewById(R.id.btn_5);
        Button btn_6 = findViewById(R.id.btn_6);
        Button btn_7 = findViewById(R.id.btn_7);
        Button btn_8 = findViewById(R.id.btn_8);
        Button btn_9 = findViewById(R.id.btn_9);

        /* botoes operaçoes */
        Button btn_backspace = findViewById(R.id.btn_backspace);
        Button btn_divisao = findViewById(R.id.btn_divisao);
        Button btn_multiplicacao = findViewById(R.id.btn_multiplicacao);
        Button btn_mais = findViewById(R.id.btn_mais);
        Button btn_menos = findViewById(R.id.btn_menos);
        Button btn_igual = findViewById(R.id.btn_igual);
        Button btn_virgula = findViewById(R.id.btn_virgula);
    }

    public void btnAction(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                aplicaValores("1");
                break;
            case R.id.btn_2:
                aplicaValores("2");
                break;
            case R.id.btn_3:
                aplicaValores("3");
                break;
            case R.id.btn_4:
                aplicaValores("4");
                break;
            case R.id.btn_5:
                aplicaValores("5");
                break;
            case R.id.btn_6:
                aplicaValores("6");
                break;
            case R.id.btn_7:
                aplicaValores("7");
                break;
            case R.id.btn_8:
                aplicaValores("8");
                break;
            case R.id.btn_9:
                aplicaValores("9");
                break;
            case R.id.btn_0:
                aplicaValores("0");
                break;
            case R.id.btn_mais:
                Toast.makeText(this, "Clicou na soma", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_menos:
                Toast.makeText(this, "Clicou na subtração", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_multiplicacao:
                Toast.makeText(this, "Clicou na multiplicacao", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_divisao:
                Toast.makeText(this, "Clicou na divisão", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_igual:
                Toast.makeText(this, "Clicou no igual", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_virgula:
                Toast.makeText(this, "Clicou na virgula", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_backspace:
                zeraVisor();
                break;

        }
    }

    public void aplicaValores(String valor) {
        String resultado;
        String strValorVisor = this.visorPrincipal.getText().toString();
        if (strValorVisor.equals("0")) {
            resultado = valor;
        } else {
            resultado = strValorVisor + valor;
        }
        this.visorPrincipal.setText(resultado);

    }

    public void zeraVisor() {
        this.visorPrincipal.setText("0");
    }
}
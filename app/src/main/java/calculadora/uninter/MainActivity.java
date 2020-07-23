package calculadora.uninter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static calculadora.uninter.R.id.visor_principal;

public class MainActivity extends AppCompatActivity {

    final Integer MULTIPLICACAO = 1;
    final Integer DIVISAO = 2;
    final Integer SOMA = 3;
    final Integer SUBTRACAO = 4;
    final Integer TOTAL = 5;

    private Double valor1 = 0d;
    private Double valor2 = 0d;
    private Double resultado = 0d;
    private Integer operacao = 0;
    private Integer calcular = 0;
    private String operador = "";
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
                aplicaValores(1d);
                break;
            case R.id.btn_2:
                aplicaValores(2d);
                break;
            case R.id.btn_3:
                aplicaValores(3d);
                break;
            case R.id.btn_4:
                aplicaValores(4d);
                break;
            case R.id.btn_5:
                aplicaValores(5d);
                break;
            case R.id.btn_6:
                aplicaValores(6d);
                break;
            case R.id.btn_7:
                aplicaValores(7d);
                break;
            case R.id.btn_8:
                aplicaValores(8d);
                break;
            case R.id.btn_9:
                aplicaValores(9d);
                break;
            case R.id.btn_0:
                aplicaValores(0d);
                break;
            case R.id.btn_mais:
                if (this.operacao == 0) {
                    this.operacao = SOMA;
                } else {
                    this.calcular = SOMA;
                }
                this.operador = "+";
                this.visorPrincipal.setText(String.valueOf(this.valor1) + this.operador);
                realizaCalculo();
                break;
            case R.id.btn_menos:
                if (this.operacao == 0) {
                    this.operacao = SUBTRACAO;
                } else {
                    this.calcular = SUBTRACAO;
                }
                this.operador = "-";
                this.visorPrincipal.setText(String.valueOf(this.valor1) + this.operador);
                realizaCalculo();
                break;
            case R.id.btn_multiplicacao:
                if (this.operacao == 0) {
                    this.operacao = MULTIPLICACAO;
                } else {
                    this.calcular = MULTIPLICACAO;
                }
                this.operacao = MULTIPLICACAO;
                this.operador = "×";
                this.visorPrincipal.setText(String.valueOf(this.valor1) + this.operador);
                realizaCalculo();
                break;
            case R.id.btn_divisao:
                if (this.operacao == 0) {
                    this.operacao = DIVISAO;
                } else {
                    this.calcular = DIVISAO;
                }
                this.operacao = DIVISAO;
                this.operador = "÷";
                this.visorPrincipal.setText(String.valueOf(this.valor1) + this.operador);
                realizaCalculo();
                break;
            case R.id.btn_igual:
                this.operacao = TOTAL;
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

    public void realizaCalculo() {
        if (this.calcular == SOMA) {
            this.valor1 = this.valor1 + this.valor2;
            this.visorPrincipal.setText(String.valueOf(this.valor1));
        }else if (this.calcular == SUBTRACAO) {
            this.valor1 = this.valor1 - this.valor2;
            this.visorPrincipal.setText(String.valueOf(this.valor1));
        }else if (this.calcular == MULTIPLICACAO) {
            this.valor1 = this.valor1 * this.valor2;
            this.visorPrincipal.setText(String.valueOf(this.valor1));
        }else if (this.calcular == DIVISAO) {
            this.valor1 = this.valor1 / this.valor2;
            this.visorPrincipal.setText(String.valueOf(this.valor1));
        }
    }

    public void aplicaValores(Double valor) {
        if (this.operacao == 0) {
            this.valor1 = (this.valor1 * 10) + valor;
            this.visorPrincipal.setText(String.valueOf(this.valor1));
        } else {
            this.valor2 = (this.valor2 * 10) + valor;
            this.visorPrincipal.setText(String.valueOf(this.valor1) + this.operador + String.valueOf(this.valor2));
        }
    }

    public void zeraVisor() {
        this.valor1 = 0d;
        this.valor2 = 0d;
        this.resultado = 0d;
        this.operacao = 0;
        this.calcular = 0;
        this.visorPrincipal.setText("0");
    }
}
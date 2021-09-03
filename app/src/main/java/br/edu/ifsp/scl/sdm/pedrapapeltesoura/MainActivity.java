package br.edu.ifsp.scl.sdm.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import java.util.Random;

import br.edu.ifsp.scl.sdm.pedrapapeltesoura.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        activityMainBinding.doisRb.setOnClickListener(this);
        activityMainBinding.tresRb.setOnClickListener(this);
        activityMainBinding.pedraBt.setOnClickListener(this);
        activityMainBinding.papelBt.setOnClickListener(this);
        activityMainBinding.tesouraBt.setOnClickListener(this);

        if (activityMainBinding.opcaoRg.getCheckedRadioButtonId() == R.id.doisRb){
            activityMainBinding.jogadaComputadorDoisIv.setVisibility(View.GONE);
            activityMainBinding.jogadaComputadorDoisTv.setVisibility(View.GONE);
        }
        else {
            activityMainBinding.jogadaComputadorDoisIv.setVisibility(View.VISIBLE);
            activityMainBinding.jogadaComputadorDoisTv.setVisibility(View.VISIBLE);
        }

        /*
        if (activityMainBinding.tresRb.isChecked()) {
            activityMainBinding.jogadaComputadorDoisIv.setVisibility(View.VISIBLE);
            activityMainBinding.jogadaComputadorDoisTv.setVisibility(View.VISIBLE);
        }
        else {
            activityMainBinding.jogadaComputadorDoisIv.setVisibility(View.GONE);
            activityMainBinding.jogadaComputadorDoisTv.setVisibility(View.GONE);
        }
        */
    }

    @Override
    public void onClick(View view) {
        int jogada = -1;
        String jogadaS = " ";
        switch (view.getId()){
            case R.id.pedraBt:
                jogada = 1;
                jogadaS = "Pedra";
                break;
            case R.id.papelBt:
                jogada = 2;
                jogadaS = "Papel";
                break;
            case R.id.tesouraBt:
                jogada = 3;
                jogadaS = "Tesoura";
                break;
        }
        jogarJokenPo (jogada, jogadaS);
    }

    private void jogarJokenPo(int jogada, String jogadaS) {
        Random random = new Random(System.currentTimeMillis());
        int jogadaComputador = random.nextInt(3)+1;
        int jogadaComputadorDois = random.nextInt(3)+1;
        String jogadaComputadorS = " ";
        String jogadaComputadorSDois = " ";

        int imagemJogadaComputadorId = R.mipmap.zero;
        switch (jogadaComputador){
            case 1:
                imagemJogadaComputadorId = R.mipmap.zero;
                jogadaComputadorS = "Pedra";
                break;
            case 2:
                imagemJogadaComputadorId = R.mipmap.five;
                jogadaComputadorS = "Papel";
                break;
            case 3:
                imagemJogadaComputadorId = R.mipmap.two;
                jogadaComputadorS = "Tesoura";
                break;
        }

        int imagemJogadaComputadorIdDois = R.mipmap.zero;
        switch (jogadaComputadorDois){
            case 1:
                imagemJogadaComputadorIdDois = R.mipmap.zero;
                jogadaComputadorSDois = "Pedra";
                break;
            case 2:
                imagemJogadaComputadorIdDois = R.mipmap.five;
                jogadaComputadorSDois = "Papel";
                break;
            case 3:
                imagemJogadaComputadorIdDois = R.mipmap.two;
                jogadaComputadorSDois = "Tesoura";
                break;
        }

        activityMainBinding.jogadaComputadorUmIv.setImageResource(imagemJogadaComputadorId);
        activityMainBinding.jogadaComputadorDoisIv.setImageResource(imagemJogadaComputadorIdDois);

        StringBuilder resultadoSb = new StringBuilder();
        resultadoSb.append("Sua jogada: ");
        resultadoSb.append(jogadaS);
        resultadoSb.append("\n");

        resultadoSb.append("Computador: ");
        resultadoSb.append(jogadaComputadorS);
        resultadoSb.append("\n");

        if (activityMainBinding.opcaoRg.getCheckedRadioButtonId() == R.id.doisRb){
            activityMainBinding.jogadaComputadorDoisIv.setVisibility(View.GONE);
            activityMainBinding.jogadaComputadorDoisTv.setVisibility(View.GONE);
            if (jogada == 1) {
                if ((jogada + jogadaComputador) == 4)
                    resultadoSb.append("Você ganhou!");
                else if ((jogada + jogadaComputador) == 3)
                    resultadoSb.append("Você perdeu!");
                else resultadoSb.append("Empate!");
            }
            else if (jogada ==2){
                if ((jogada + jogadaComputador) == 3)
                    resultadoSb.append("Você ganhou!");
                else if ((jogada + jogadaComputador) == 5)
                    resultadoSb.append("Você perdeu!");
                else resultadoSb.append("Empate!");
            }
            else {
                if ((jogada + jogadaComputador) == 5)
                    resultadoSb.append("Você ganhou!");
                else if ((jogada + jogadaComputador) == 4)
                    resultadoSb.append("Você perdeu!");
                else resultadoSb.append("Empate!");
            }
        }
        else {
            activityMainBinding.jogadaComputadorDoisIv.setVisibility(View.VISIBLE);
            activityMainBinding.jogadaComputadorDoisTv.setVisibility(View.VISIBLE);
            resultadoSb.append("Computador Dois: ");
            resultadoSb.append(jogadaComputadorSDois);
            resultadoSb.append("\n");

            if (jogada == 1) {
                if ((jogada + jogadaComputador + jogadaComputadorDois) == 7)
                    resultadoSb.append("Você ganhou!");
                else if ((jogada + jogadaComputador + jogadaComputadorDois) == 4 || (jogada + jogadaComputador + jogadaComputadorDois) == 5)
                    resultadoSb.append("Você perdeu!");
                else resultadoSb.append("Empate!");
                }
            else if (jogada ==2){
                if ((jogada + jogadaComputador) == 4)
                    resultadoSb.append("Você ganhou!");
                else if ((jogada + jogadaComputador + jogadaComputadorDois) == 7 || (jogada + jogadaComputador + jogadaComputadorDois) == 8)
                    resultadoSb.append("Você perdeu!");
                else resultadoSb.append("Empate!");
            }
            else{
                if ((jogadaComputador == 3 && jogadaComputadorDois == 1) || (jogadaComputador == 1 && jogadaComputadorDois == 3))
                    jogada = 0;
                if ((jogada + jogadaComputador + jogadaComputadorDois) == 7)
                    resultadoSb.append("Você ganhou!");
                else if ((jogada + jogadaComputador + jogadaComputadorDois) == 4 || (jogada + jogadaComputador + jogadaComputadorDois) == 8)
                    resultadoSb.append("Você perdeu!");
                else resultadoSb.append("Empate!");
            }
        }
        activityMainBinding.resultadoTv.setText(resultadoSb.toString());
    }
}
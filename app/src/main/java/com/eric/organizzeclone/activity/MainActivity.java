package com.eric.organizzeclone.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.eric.organizzeclone.R;
import com.eric.organizzeclone.config.ConfigFirebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.slide.FragmentSlide;

public class MainActivity extends IntroActivity {

    private FirebaseAuth autenticacao;
    private final DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(new FragmentSlide.Builder()
                .background(R.color.light_blue)
                .fragment(R.layout.intro_1)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(R.color.light_blue)
                .fragment(R.layout.intro_2)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(R.color.light_blue)
                .fragment(R.layout.intro_3)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(R.color.light_blue)
                .fragment(R.layout.intro_4)
                .build());

        addSlide(new FragmentSlide.Builder()
                .background(R.color.light_blue)
                .fragment(R.layout.fragment_intro_5)
                .canGoForward(false)
                .build());

        setButtonBackVisible(false);
        setButtonNextVisible(false);

    }

    @Override
    protected void onStart() {
        super.onStart();
        VerificarUserLogado();
    }

    public void CadastrarClicked(View view){

        startActivity(new Intent(getApplicationContext(), CadastrarActivity.class));

    }

    public void LogarClicked(View view){

        startActivity(new Intent(getApplicationContext(), LoginActivity.class));

    }

    public void VerificarUserLogado(){

        autenticacao = ConfigFirebase.getAutenticacao();

        if (autenticacao.getCurrentUser() != null){
            AbrirHome();
        }

    }

    public void AbrirHome(){
        startActivity(new Intent(this,
                HomeActivity.class));
    }

}
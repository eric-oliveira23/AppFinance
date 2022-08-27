package com.eric.organizzeclone.config;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ConfigFirebase {

    //retorna instancia do firebaseauth
    private static FirebaseAuth autenticacao;

    public static FirebaseAuth getAutenticacao() {

        if (autenticacao == null) {

            autenticacao = FirebaseAuth.getInstance();

        }
        return autenticacao;

    }

    //retorna instancia do firebasedatabase
    public static DatabaseReference reference;

    public static DatabaseReference getDatabaseReference(){

        if (reference == null){

            reference = FirebaseDatabase.getInstance().getReference();

        }
        return reference;
    }

}

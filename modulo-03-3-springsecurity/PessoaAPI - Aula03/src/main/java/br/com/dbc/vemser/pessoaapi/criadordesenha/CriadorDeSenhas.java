package br.com.dbc.vemser.pessoaapi.criadordesenha;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CriadorDeSenhas {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String senha = bCryptPasswordEncoder.encode("123");
        System.out.println(senha);

        String minhaSenhaCript = "$2a$10$fP3fNbhDrkixHZHOqW4zKu9QdYiIWkhxH8NIXWcq7AQiUXAHivZEO";
        boolean matches = bCryptPasswordEncoder.matches("123", minhaSenhaCript);
        System.out.println(matches);

    }
}
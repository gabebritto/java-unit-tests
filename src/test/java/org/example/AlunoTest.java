package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlunoTest {


    private Aluno a1;

    @BeforeEach
    public void config() {
        a1 = new Aluno(1, "Gabriel", 10, "12345678912", "12345678912");
    }

    @Test
    public void naoDeveriaAceitarMatriculaComMenosDe11Digitos() {
        Assertions.assertThrows(RuntimeException.class, () -> a1.setMatricula("123"));
    }

    @Test public void naoDeveriaAceitarMatriculaComCaracteresEspeciais() {
        Assertions.assertThrows(RuntimeException.class, () -> a1.setMatricula("0123456789#"));
    }

    @Test public void naoDeveriaAceitarMatriculaComLetras() {
        Assertions.assertThrows(RuntimeException.class, () -> a1.setMatricula("0123456789a"));
    }
}

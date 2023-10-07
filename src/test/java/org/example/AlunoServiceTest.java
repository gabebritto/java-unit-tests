package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AlunoServiceTest {
    @InjectMocks
    private AlunoService alunoService;

    @Mock
    private AlunoDAO alunoDAO;

    private Aluno aluno;

    @BeforeEach
    public void config() {
       aluno = new Aluno(1, "Gabriel", 30, "12345678912", "12345678912");
    }

    @Test
    public void naoDeveriaInserirAlunoComMatriculaJahExistente() {
        Mockito.doReturn(true).when(alunoDAO).existeMatriculaAtiva("12345678912");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno));
    }

    @Test
    public void naoDeveriaInserirAlunoComCPFJahExistente(){
        Mockito.doReturn(true).when(alunoDAO).existeAlunoComCPF("12345678912");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(aluno));
    }

    @Test void naoDeveriaInserirAlunoComIdadeMenorQue18Anos(){
        Aluno menorDeIdade = new Aluno(1, "Pedro", 10, "12346578912", "12346578912");
        Assertions.assertThrows(IllegalArgumentException.class, () -> alunoService.inserirAluno(menorDeIdade));
    }
}

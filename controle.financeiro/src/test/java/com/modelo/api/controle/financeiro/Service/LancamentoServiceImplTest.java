package com.modelo.api.controle.financeiro.Service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import com.modelo.api.controle.financeiro.entity.Lancamento;
import com.modelo.api.controle.financeiro.service.LancamentoServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class LancamentoServiceImplTest {
    
    @Autowired
    private LancamentoServiceImpl lancamentoServiceImpl;

    @Test
    @Rollback(false)
    public void testCreateLancamentoSucess() {
        Lancamento Lancamento = lancamentoServiceImpl.create(new Lancamento("Gasolina", 100.00, new Date("15-10-2022"), 1, "Comentário"));

        assertThat(Lancamento.getIdLancamento()).isGreaterThan(0);
    }

    @Test
    public void testListLancamentosSucess() {
        List<Lancamento> Lancamentos = (List<Lancamento>) lancamentoServiceImpl.findAll();
        assertThat(Lancamentos).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    public void testUpdateLancamentoSucess() {
        Lancamento Lancamento = lancamentoServiceImpl.findOne(1);
        Lancamento.setNome("Alimentação");

        lancamentoServiceImpl.create(Lancamento);

        Lancamento updatedLancamento = lancamentoServiceImpl.findOne(1);

        assertThat(updatedLancamento.getNome()).isEqualTo("Alimentação");
    }

    @Test
    @Rollback(false)
    public void testDeleteLancamentoSucess() {
        Lancamento Lancamento = lancamentoServiceImpl.findOne(1);

        lancamentoServiceImpl.deleteById(Lancamento.getIdLancamento());

        Lancamento deletedLancamento = lancamentoServiceImpl.findOne(1);

        assertThat(deletedLancamento).isNull();

    }
}

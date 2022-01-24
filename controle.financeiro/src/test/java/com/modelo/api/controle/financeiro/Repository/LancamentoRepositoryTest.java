package com.modelo.api.controle.financeiro.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import com.modelo.api.controle.financeiro.entity.Lancamento;
import com.modelo.api.controle.financeiro.repository.LancamentoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringBootTest
public class LancamentoRepositoryTest {
    
    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Test
    @Rollback(false)
    public void testCreateLancamentoSucess() {
        Lancamento Lancamento = lancamentoRepository.save(new Lancamento("Gasolina", 100.00, new Date("15-10-2022"), 1, "Comentário"));

        assertThat(Lancamento.getIdLancamento()).isGreaterThan(0);
    }

    @Test
    public void testListLancamentosSucess() {
        List<Lancamento> Lancamentos = (List<Lancamento>) lancamentoRepository.findAll();
        assertThat(Lancamentos).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    public void testUpdateLancamentoSucess() {
        Lancamento Lancamento = lancamentoRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("Lancamento com este ID não existe :: " + 1));
        Lancamento.setNome("Despesa pessoal");

        lancamentoRepository.save(Lancamento);

        Lancamento updatedLancamento = lancamentoRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("Lancamento com este ID não existe :: " + 1));

        assertThat(updatedLancamento.getNome()).isEqualTo("Despesa pessoal");
    }

    @Test
    @Rollback(false)
    public void testDeleteLancamentoSucess() {
        Lancamento Lancamento = lancamentoRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("Lancamento com este ID não existe :: " + 1));

        lancamentoRepository.deleteById(Lancamento.getIdLancamento());

        Lancamento deletedLancamento = lancamentoRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("Lancamento com este ID não existe :: " + 1));

        assertThat(deletedLancamento).isNull();

    }
}

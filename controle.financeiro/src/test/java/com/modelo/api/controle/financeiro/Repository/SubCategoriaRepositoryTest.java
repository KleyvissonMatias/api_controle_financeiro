package com.modelo.api.controle.financeiro.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.modelo.api.controle.financeiro.entity.SubCategoria;
import com.modelo.api.controle.financeiro.repository.SubCategoriaRepository;

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
public class SubCategoriaRepositoryTest {

    @Autowired
    private SubCategoriaRepository subCategoriaRepository;

    @Test
    @Rollback(false)
    public void testCreateSubCategoriaSucess() {
        SubCategoria subcategoria = subCategoriaRepository.save(new SubCategoria("Despesas", 1));

        assertThat(subcategoria.getIdSubCategoria()).isGreaterThan(0);
    }

    @Test
    public void testListSubCategoriasSucess() {
        List<SubCategoria> subCategorias = (List<SubCategoria>) subCategoriaRepository.findAll();
        assertThat(subCategorias).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    public void testUpdateSubCategoriaSucess() {
        SubCategoria SubCategoria = subCategoriaRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("SubCategoria com este ID não existe :: " + 1));
        SubCategoria.setNome("Alimentação");

        subCategoriaRepository.save(SubCategoria);

        SubCategoria updatedSubCategoria = subCategoriaRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("SubCategoria com este ID não existe :: " + 1));

        assertThat(updatedSubCategoria.getNome()).isEqualTo("Alimentação");
    }

    @Test
    @Rollback(false)
    public void testDeleteSubCategoriaSucess() {
        SubCategoria subCategoria = subCategoriaRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("SubCategoria com este ID não existe :: " + 1));

        subCategoriaRepository.deleteById(subCategoria.getIdSubCategoria());

        SubCategoria deletedSubCategoria = subCategoriaRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("SubCategoria com este ID não existe :: " + 1));

        assertThat(deletedSubCategoria).isNull();

    }
}

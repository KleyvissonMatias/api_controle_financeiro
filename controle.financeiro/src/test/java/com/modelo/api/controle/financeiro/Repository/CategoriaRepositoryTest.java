package com.modelo.api.controle.financeiro.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Date;
import java.util.List;

import com.modelo.api.controle.financeiro.entity.Categoria;
import com.modelo.api.controle.financeiro.repository.CategoriaRepository;

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
public class CategoriaRepositoryTest {
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Test
    @Rollback(false)
    public void testCreateCategoriaSucess() {
        Categoria Categoria = categoriaRepository.save(new Categoria("Viagem"));

        assertThat(Categoria.getIdCategoria()).isGreaterThan(0);
    }

    @Test
    public void testListCategoriasSucess() {
        List<Categoria> Categorias = (List<Categoria>) categoriaRepository.findAll();
        assertThat(Categorias).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    public void testUpdateCategoriaSucess() {
        Categoria Categoria = categoriaRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria com este ID não existe :: " + 1));
        Categoria.setNome("Transporte");

        categoriaRepository.save(Categoria);

        Categoria updatedCategoria = categoriaRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria com este ID não existe :: " + 1));

        assertThat(updatedCategoria.getNome()).isEqualTo("Transporte");
    }

    @Test
    @Rollback(false)
    public void testDeleteCategoriaSucess() {
        Categoria Categoria = categoriaRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria com este ID não existe :: " + 1));

        categoriaRepository.deleteById(Categoria.getIdCategoria());

        Categoria deletedCategoria = categoriaRepository.findById(1)
                .orElseThrow(() -> new ResourceNotFoundException("Categoria com este ID não existe :: " + 1));

        assertThat(deletedCategoria).isNull();

    }
}

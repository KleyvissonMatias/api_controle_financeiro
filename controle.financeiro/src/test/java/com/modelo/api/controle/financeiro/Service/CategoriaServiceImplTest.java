package com.modelo.api.controle.financeiro.Service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.modelo.api.controle.financeiro.entity.Categoria;
import com.modelo.api.controle.financeiro.service.CategoriaServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class CategoriaServiceImplTest {
    
    @Autowired
    private CategoriaServiceImpl categoriaServiceImpl;

    @Test
    @Rollback(false)
    public void testCreateCategoriaSucess() {
        Categoria Categoria = categoriaServiceImpl.create(new Categoria("Transporte"));

        assertThat(Categoria.getIdCategoria()).isGreaterThan(0);
    }

    @Test
    public void testListCategoriasSucess() {
        List<Categoria> Categorias = (List<Categoria>) categoriaServiceImpl.findAll();
        assertThat(Categorias).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    public void testUpdateCategoriaSucess() {
        Categoria Categoria = categoriaServiceImpl.findOne(1);
        Categoria.setNome("Alimentação");

        categoriaServiceImpl.create(Categoria);

        Categoria updatedCategoria = categoriaServiceImpl.findOne(1);

        assertThat(updatedCategoria.getNome()).isEqualTo("Alimentação");
    }

    @Test
    @Rollback(false)
    public void testDeleteCategoriaSucess() {
        Categoria Categoria = categoriaServiceImpl.findOne(1);

        categoriaServiceImpl.deleteById(Categoria.getIdCategoria());

        Categoria deletedCategoria = categoriaServiceImpl.findOne(1);

        assertThat(deletedCategoria).isNull();

    }
}

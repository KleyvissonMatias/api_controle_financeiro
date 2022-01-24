package com.modelo.api.controle.financeiro.Service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.modelo.api.controle.financeiro.entity.SubCategoria;
import com.modelo.api.controle.financeiro.service.SubCategoriaServiceImpl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class SubCategoriaServiceImplTest {
    
    @Autowired
    private SubCategoriaServiceImpl subCategoriaServiceImpl;

    @Test
    @Rollback(false)
    public void testCreateSubCategoriaSucess() {
        SubCategoria subcategoria = subCategoriaServiceImpl.create(new SubCategoria("Despesas pessoais", 1));

        assertThat(subcategoria.getIdSubCategoria()).isGreaterThan(0);
    }

    @Test
    public void testListSubCategoriasSucess() {
        List<SubCategoria> subCategorias = (List<SubCategoria>) subCategoriaServiceImpl.findAll();
        assertThat(subCategorias).size().isGreaterThan(0);
    }

    @Test
    @Rollback(false)
    public void testUpdateSubCategoriaSucess() {
        SubCategoria SubCategoria = subCategoriaServiceImpl.findOne(1);
        SubCategoria.setNome("Alimentação");

        subCategoriaServiceImpl.create(SubCategoria);

        SubCategoria updatedSubCategoria = subCategoriaServiceImpl.findOne(1);

        assertThat(updatedSubCategoria.getNome()).isEqualTo("Alimentação");
    }

    @Test
    @Rollback(false)
    public void testDeleteSubCategoriaSucess() {
        SubCategoria subCategoria = subCategoriaServiceImpl.findOne(1);

        subCategoriaServiceImpl.deleteById(subCategoria.getIdSubCategoria());

        SubCategoria deletedSubCategoria = subCategoriaServiceImpl.findOne(1);

        assertThat(deletedSubCategoria).isNull();

    }
}

package com.generation.blogpessoal.repository;

import com.generation.blogpessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.*;
import java.util.List;

@Repository
public interface PostagemRepository extends JpaRepository<Postagem , Long> {

    public List <Postagem> findAllByTituloContainingIgnoreCase(@Param("titulo") String titulo);
}

package com.generation.blogpessoal.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.boot.jaxb.mapping.marshall.GenerationTypeMarshalling;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_postagem")
public class Postagem {

    // Todos os Privates são equivalentes aos campos no banco de dados
    // As Notações acima do Private fazem o tratamento das informações em cada campo

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank // Não aceita nem nulo e nem vazio (ao contrário do NOT NULL)
    @Size(min = 4 , max = 100, message = "O atributo título no mínimo 4 e no máximo 100")
    private String titulo;

    @NotBlank  // Não aceita nem nulo e nem vazio (ao contrário do NOT NULL)
    @Size(min = 10 , max = 1000)
    private String texto;

    @UpdateTimestamp // Coloca o horário e a data da postagem, sem ter a necessidade de digitar a hora e a data
    private LocalDateTime data;

    // RELAÇÃO ENTRE TABELAS
    @ManyToOne
    @JsonIgnoreProperties("postagem")
    private Tema tema;

    @ManyToOne
    @JsonIgnoreProperties("postagem")
    private Usuario usuario;

    // GETTER AND SETTER
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    //GETTER AND SETTER // RELAÇÃO ENTRE TABELAS

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

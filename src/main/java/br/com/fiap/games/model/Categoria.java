package br.com.fiap.games.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_categorias")
public class Categoria {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "TBL_CATEGORIAS_SEQ"
    )
    @SequenceGenerator(
            name = "TBL_CATEGORIAS_SEQ",
            sequenceName = "TBL_CATEGORIAS_SEQ",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "nome_categoria")
    private String nomeCategoria;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

}

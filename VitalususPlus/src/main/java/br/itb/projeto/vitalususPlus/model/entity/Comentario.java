package br.itb.projeto.vitalususPlus.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="Comentario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="texto")
    @NotBlank(message = "campo não preenchido")
    private String texto;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name="videoaula_id")
    private Videoaula videoaula;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Videoaula getVideoaula() {
		return videoaula;
	}

	public void setVideoaula(Videoaula videoaula) {
		this.videoaula = videoaula;
	}
    

}

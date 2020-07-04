package usj.edu.br.moto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@Entity
@NoArgsConstructor


public class Moto{
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String nome;
    Double modelo;
    String fabricante;
    Double cilindrada;
    Double preco;

}
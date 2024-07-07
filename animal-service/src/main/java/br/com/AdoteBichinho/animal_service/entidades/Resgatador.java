package br.com.AdoteBichinho.animal_service.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Resgatador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "resgatador")
    private List<Animal> animais = new ArrayList<>();

    public String getNome() {
        return nome;
    }

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    private void addAnimal(Animal animal){
        animais.add(animal);
        animal.setResgatador(this);
    }
}

package br.itb.projeto.vitalususPlus.service;

import br.itb.projeto.vitalususPlus.model.entity.Aluno;
import br.itb.projeto.vitalususPlus.model.entity.Evolucao;
import br.itb.projeto.vitalususPlus.model.repository.AlunoRepository;
import br.itb.projeto.vitalususPlus.model.repository.EvolucaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvolucaoService {
    private EvolucaoRepository evolucaoRepository;

    public EvolucaoService(EvolucaoRepository evolucaoRepository) {
        super();
        this.evolucaoRepository = evolucaoRepository;
    }
    public List<Evolucao> findAll(){
        List<Evolucao> listaEvolucao = evolucaoRepository.findAll();
        return listaEvolucao;
    }
    public Evolucao findById(long id) {
        Optional<Evolucao> evolucao = this.evolucaoRepository.findById(id);
        return evolucao.orElseThrow(() -> new RuntimeException(
                "Aluno não encontrado"
        ));
    }
    public Evolucao save(Evolucao evolucao){
        evolucao.setId(null);
        return evolucaoRepository.save(evolucao);
    }
    public void delete(Evolucao evolucao) {
        this.evolucaoRepository.delete(evolucao);
    }
    public Evolucao update(Evolucao evolucao){
        return evolucaoRepository.save(evolucao);
    }
}

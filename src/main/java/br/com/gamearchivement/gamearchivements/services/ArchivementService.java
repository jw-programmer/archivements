package br.com.gamearchivement.gamearchivements.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.gamearchivement.gamearchivements.models.Archivement;
import br.com.gamearchivement.gamearchivements.repositories.ArchivementRepository;

@Service
public class ArchivementService {

    @Autowired
    private ArchivementRepository repo;

    public List<Archivement> insertArchivments(List<Archivement> objs){
        for (Archivement archivement : objs) {
            archivement.setId(null);
        }
        
        return repo.saveAll(objs);
    }

    public void removeArchivements(List<Archivement> objs){
        repo.deleteAll(objs);
    }
}

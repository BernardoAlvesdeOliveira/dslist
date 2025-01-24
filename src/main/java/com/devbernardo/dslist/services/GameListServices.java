package com.devbernardo.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devbernardo.dslist.dto.GameListDTO;
import com.devbernardo.dslist.entities.GameList;
import com.devbernardo.dslist.projections.GameMinProjection;
import com.devbernardo.dslist.repositories.GameListRepository;
import com.devbernardo.dslist.repositories.GameRepository;

@Service
public class GameListServices {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(Long listedID, int sourceIndex, int destinationIndex) {
        // Busca a lista de jogos por listId
        List<GameMinProjection> list = gameRepository.searchByList(listedID);

        // Valida os índices para garantir que estão no intervalo correto
        if (sourceIndex < 0 || sourceIndex >= list.size() || destinationIndex < 0 || destinationIndex >= list.size()) {
            throw new IllegalArgumentException("Indices are out of bounds");
        }

        // Move o item na lista
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        // Define os limites para reordenar
        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        // Atualiza as posições no banco de dados
        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listedID, list.get(i).getId(), i);
        }
    }
}

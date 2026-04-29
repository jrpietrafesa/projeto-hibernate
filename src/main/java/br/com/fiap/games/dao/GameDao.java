package br.com.fiap.games.dao;

import br.com.fiap.games.model.Game;
import jakarta.persistence.EntityManager;

import java.util.List;

public class GameDao {

    private EntityManager em;

    public GameDao(EntityManager em) {
        this.em = em;
    }

    public void salvar(Game game) {
        em.persist(game);
    }

    public void atualizar(Game game) {
        em.merge(game);
    }

    public void remover(Game game) {
        Game gameExcluir = em.find(Game.class, game.getId());
        em.remove(gameExcluir);
    }

    public Game buscarGamePorId(Game game) {
        return em.find(Game.class, game.getId());
    }

    public List<Game> listarTodosOsGames() {
        //SELECT * FROM TBL_GAMES ORDER BY TITULO DESC
        String jpqlQuery = "SELECT g FROM Game g ORDER BY g.titulo ASC";
        return em.createQuery(jpqlQuery, Game.class).getResultList();
    }







}


package br.com.fiap.games;

import br.com.fiap.games.dao.GameDao;
import br.com.fiap.games.model.Game;
import br.com.fiap.games.utils.Conexao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {

        public static void main(String[] args) {

//            Game game1 = new Game();
//            game1.setId(6L);
//            game1.setTitulo("World of Warcraft");
//            game1.setCategoria("MMORPG");
//            game1.setDataLancamento(LocalDate.of(2005, 11, 11));
//            game1.setFinalizado(false);
//            game1.setProdutora("Blizzard");
//            game1.setValor(55.90);

            EntityManager em = Conexao.getEntityManager();

            pesquisar(em);


        }

        public static void pesquisar(EntityManager em) {

            GameDao dao = new GameDao(em);
            Game game1 = new Game();
            game1.setId(2L);

            Game gameEncontrado = dao.buscarGamePorId(game1);

            if (gameEncontrado != null) {
                System.out.println("Game Encontrado");
                System.out.println(gameEncontrado);
            } else {
                System.out.println("Game não encontrado");
            }

        }

        public static void cadastrar(EntityManager em) {
            Game game1 = new Game();
            game1.setTitulo("League of Legends");
            game1.setCategoria("MOBA");
            game1.setDataLancamento(LocalDate.of(2010, 05, 11));
            game1.setFinalizado(false);
            game1.setProdutora("RIOT");
            game1.setValor(19.90);

            GameDao gameDao = new GameDao(em);
            em.getTransaction().begin();
            gameDao.salvar(game1);
            em.getTransaction().commit();
            em.close();
        }
}

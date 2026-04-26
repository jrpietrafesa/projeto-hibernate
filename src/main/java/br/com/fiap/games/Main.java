package br.com.fiap.games;

import br.com.fiap.games.model.Game;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {

        public static void main(String[] args) {

            Game game1 = new Game();
            game1.setTitulo("Megaman 1");
            game1.setCategoria("Plataforma");
            game1.setDataLancamento(LocalDate.of(1987, 12, 1));
            game1.setFinaliado(true);
            game1.setProdutora("Capcom");
            game1.setValor(128.00);

            //entity manager
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("games");
            EntityManager em = emf.createEntityManager();

            //inicia e registra a transacao para o banco de dados
            em.getTransaction().begin();
            em.persist(game1);
            em.getTransaction().commit();
            em.close();

            //Persista esse Game1 no banco de dados
            em.persist(game1);

        }
}

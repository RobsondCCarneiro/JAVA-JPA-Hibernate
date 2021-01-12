package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		/*
		 * Para colocar esses dados no Banco de Dados utilizando o JPA
		 * � necess�rio utilizar o 
		 * - EntityManager: encapsula uma $conex�o
		 * com a base de dados e serve para efetuar $opera��es de acesso
		 * a dados$ (inser��o, remo��o, dele��o, atualiza��o) em entidades
		 * (clientes, produtos, pedidos etc.) por ele $monitoradas$ em um
		 * mesmo $contexto de persist�ncia$.
		 * 
		 * - EntityManagerFactory: � utilizado para instanciar objetos EntityManager.
		 */
		
		//Aqui os id's das pessoas s�o nulos porque o pr�prio banco de dados que cria e incrementa
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Quando o JPA faz al�m da leitura do BD, � necess�rio implementar a transa��o.
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		

	}

}

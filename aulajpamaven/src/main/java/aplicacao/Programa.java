package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		/*
		 * Para colocar esses dados no Banco de Dados utilizando o JPA
		 * é necessário utilizar o 
		 * - EntityManager: encapsula uma $conexão
		 * com a base de dados e serve para efetuar $operações de acesso
		 * a dados$ (inserção, remoção, deleção, atualização) em entidades
		 * (clientes, produtos, pedidos etc.) por ele $monitoradas$ em um
		 * mesmo $contexto de persistência$.
		 * 
		 * - EntityManagerFactory: é utilizado para instanciar objetos EntityManager.
		 */
		
		//Aqui os id's das pessoas são nulos porque o próprio banco de dados que cria e incrementa
		Pessoa p1 = new Pessoa(null, "Carlos da Silva", "carlos@gmail.com");
		Pessoa p2 = new Pessoa(null, "Joaquim Torres", "joaquim@gmail.com");
		Pessoa p3 = new Pessoa(null, "Ana Maria", "ana@gmail.com");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//Quando o JPA faz além da leitura do BD, é necessário implementar a transação.
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.getTransaction().commit();
		System.out.println("Pronto!");
		

	}

}

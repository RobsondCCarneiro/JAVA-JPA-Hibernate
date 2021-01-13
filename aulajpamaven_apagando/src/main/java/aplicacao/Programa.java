package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = emf.createEntityManager();
		
		//fun��o que busca o elemento pelo Id, o find pertence a JPA, de forma que uma linha basta.
		Pessoa p = em.find(Pessoa.class, 3);
		System.out.println(p);
		
		/*
		 * Para remover ou alterar um arquivo no Banco de Dados, � necess�rio que a inst�ncia esteja
		 * monitorada, ou seja, tive que acabar de inserir ou ter consultado antes de ter encerrado a
		 * execu��o do programa, caso contr�rio a inst�ncia � destacada e causa uma exce��o na hora de
		 * remover/alterar a entidade. 
		 */
		em.remove(p);
		
		System.out.println("Pronto!");
		em.close();
		emf.close();

	}

}

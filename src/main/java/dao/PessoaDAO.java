package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Pessoa;
import util.HibernateUtil;

/**
 * @author Pedro Alex
 */
public class PessoaDAO {

	public void salvar(Pessoa pessoa) {
    	EntityManager entityManager = HibernateUtil.getEntityManager();
    	try {
	    	entityManager.getTransaction().begin();
	    	entityManager.persist(pessoa);
	    	entityManager.getTransaction().commit();
	    	System.out.println("Pessoa salva com sucesso!");
    	} catch (Exception e) {
        	entityManager.getTransaction().rollback();
	    	System.out.println("Erro ao salvar a pessoa!");
            e.printStackTrace();
        } finally {
        	entityManager.close();			
		}
	}
	
	public List<Pessoa> listarTodos(){
		TypedQuery<Pessoa> query = HibernateUtil.getEntityManager().createQuery("SELECT p FROM Pessoa p", Pessoa.class);
		List<Pessoa> pessoas = query.getResultList();
		return pessoas;
	}
	
}

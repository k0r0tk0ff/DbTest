package k0r0tk0ff.exe;

import k0r0tk0ff.bl.HibernateUtil;
import k0r0tk0ff.entity.Articles;
import k0r0tk0ff.entity.Types;
import org.hibernate.Session;

/**
 * Created by k0r0tk0ff on 4/13/17.
 */
public class MainExecutor {

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Types types = new Types();
		types.setId(1);
		types.setName("Новости");

		Articles articles = new Articles();
		articles.setId(1);
		articles.setName("Новость1");

		/*articleLink.setProjects(projects);*/

		session.save(types);
		session.save(articles);

		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}

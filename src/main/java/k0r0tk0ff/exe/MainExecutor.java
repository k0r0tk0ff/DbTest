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
		types.setName("Новости");

		Articles articles = new Articles(types);
		articles.setName("Новость1");

		session.save(articles);
		session.save(types);


		/*ArrayList <Types> typesArrayList = new ArrayList<>();
		ArrayList <Articles> articlesArrayList = new ArrayList<>();

		for (int i=1; i<4; i++) {
			typesArrayList.add(i, new Types());
			typesArrayList.get(i).setId(i);
			typesArrayList.get(i).setName("Новости");

			articlesArrayList.add(i, new Articles(typesArrayList.get(i)));
			articlesArrayList.get(i).setId(i);
			articlesArrayList.get(i).setName("Новость" + i);

			session.save(typesArrayList.get(i));
			session.save(articlesArrayList.get(i));
		}*/

		session.getTransaction().commit();
		HibernateUtil.shutdown();
	}
}

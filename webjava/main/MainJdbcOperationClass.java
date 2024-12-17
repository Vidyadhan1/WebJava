package main.jdbc;

import java.util.Collection;
import java.util.Scanner;

import article.jdbc.dao.ArticlesDao;
import article.jdbc.dao.DaoInterface;
import jdbc.bean.Article;

public class MainJdbcOperationClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int key = 1;
		DaoInterface<Article, Integer> dao = new ArticlesDao();

		do {
			System.out.println("------------------------");
			System.out.println("1. Retrieve All Data");
			System.out.println("2. Get Article By Id");
			System.out.println("3. Insert Article details");
			System.out.println("4. Update Article details");
			System.out.println("5. Delete Article details");
			System.out.println("6. Exit");
			System.out.println("------------------------");
			System.out.println("Enter Your Choice : ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1:
				System.out.println("All Articles details : - ");
				Collection<Article> allArticle = dao.retrieveAll();
				for (Article article : allArticle) {
					System.out.println(article);
				}
				break;


			case 2:
				System.out.println("Get Article By Id : - ");
				int id =sc.nextInt();
				Article art = dao.retrieveOne(id);
				if(art!=null) {
					System.out.println(art);
				}
				else {
					System.out.println("Not present");

				}
				break;

			case 3:
				System.out.println("Insert Article details : - ");
				System.out.println("Enter Id: ");
				id=sc.nextInt();
				System.out.println("Enter Name: ");
				String name=sc.next();
				System.out.println("Enter Category: ");
				String cat=sc.next();
				System.out.println("Enter Date:");
				String date=sc.next();
				System.out.println("Enter Creator Name: ");
				String creatorname=sc.next();
				
				Article arts = new Article(id, name, cat, date, creatorname);
				dao.create(arts);
				break;

			case 4:
				System.out.println("Update Article details : - ");
				System.out.println("Get Article By Id : -");
				 id =sc.nextInt();
				Article arte = dao.retrieveOne(id);
				arte.setName("New Little Italy");
				dao.update(arte)
				break;

			case 5:
				System.out.println("Delete Article details : - ");
				System.out.println("Enter id: ");
			    id =sc.nextInt();
				dao.delete(id);
				break;

                
			case 6:
				System.exit(0);
				break;

			default:
				System.out.println("Wrong choice!");
			}

			System.out.println("Do you want to continue? press(0/1) : ");
			key = sc.nextInt();

		} while (key == 1);

	}
}

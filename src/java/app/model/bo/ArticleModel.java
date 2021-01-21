package app.model.bo;

import java.util.ArrayList;
import java.util.List;

public class ArticleModel {
	private List<Article> articles = new ArrayList<>();
        private Article article = null;
	
	public void setArticles(List<Article> cc) {
		this.articles = cc;
	}
        
	public List<Article> getArticles() {
		return  this.articles;
	}
        
        public void setArticle(Article cc) {
		this.article = cc;
	}
        
        public Article getArticle() {
		return this.article;
	}
        
}

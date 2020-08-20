package Entites;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class LignePanier
{

        private Book book;
        private int quantite;

        public LignePanier(Book book, int qte) 
        {    
                this.book = book;
                this.quantite = qte;
        }

        
        public LignePanier() {
			super();
		}


		public Book getBook() {
                return book;
        }

        public void setBook(Book book) {
                this.book = book;
        }

        public int getQuantite() {
                return quantite;
        }

        public void setQuantite(int quantite) {
                this.quantite = quantite;
        }
}

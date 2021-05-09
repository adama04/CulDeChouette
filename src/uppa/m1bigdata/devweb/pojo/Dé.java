package uppa.m1bigdata.devweb.pojo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the d�s database table.
 * 
 */
@Entity
@Table(name="d�s")
@NamedQuery(name="D�.findAll", query="SELECT d FROM D� d")
public class D� implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idD�s;

	private String nomD�s;

	private int valeurFace;

	//bi-directional many-to-one association to Combinaison
	@OneToMany(mappedBy="d�1")
	private List<Combinaison> combinaisons1;

	//bi-directional many-to-one association to Combinaison
	@OneToMany(mappedBy="d�2")
	private List<Combinaison> combinaisons2;

	//bi-directional many-to-one association to Combinaison
	@OneToMany(mappedBy="d�3")
	private List<Combinaison> combinaisons3;

	public D�() {
	}

	public int getIdD�s() {
		return this.idD�s;
	}

	public void setIdD�s(int idD�s) {
		this.idD�s = idD�s;
	}

	public String getNomD�s() {
		return this.nomD�s;
	}

	public void setNomD�s(String nomD�s) {
		this.nomD�s = nomD�s;
	}

	public int getValeurFace() {
		return this.valeurFace;
	}

	public void setValeurFace(int valeurFace) {
		this.valeurFace = valeurFace;
	}

	public List<Combinaison> getCombinaisons1() {
		return this.combinaisons1;
	}

	public void setCombinaisons1(List<Combinaison> combinaisons1) {
		this.combinaisons1 = combinaisons1;
	}

	public Combinaison addCombinaisons1(Combinaison combinaisons1) {
		getCombinaisons1().add(combinaisons1);
		combinaisons1.setD�1(this);

		return combinaisons1;
	}

	public Combinaison removeCombinaisons1(Combinaison combinaisons1) {
		getCombinaisons1().remove(combinaisons1);
		combinaisons1.setD�1(null);

		return combinaisons1;
	}

	public List<Combinaison> getCombinaisons2() {
		return this.combinaisons2;
	}

	public void setCombinaisons2(List<Combinaison> combinaisons2) {
		this.combinaisons2 = combinaisons2;
	}

	public Combinaison addCombinaisons2(Combinaison combinaisons2) {
		getCombinaisons2().add(combinaisons2);
		combinaisons2.setD�2(this);

		return combinaisons2;
	}

	public Combinaison removeCombinaisons2(Combinaison combinaisons2) {
		getCombinaisons2().remove(combinaisons2);
		combinaisons2.setD�2(null);

		return combinaisons2;
	}

	public List<Combinaison> getCombinaisons3() {
		return this.combinaisons3;
	}

	public void setCombinaisons3(List<Combinaison> combinaisons3) {
		this.combinaisons3 = combinaisons3;
	}

	public Combinaison addCombinaisons3(Combinaison combinaisons3) {
		getCombinaisons3().add(combinaisons3);
		combinaisons3.setD�3(this);

		return combinaisons3;
	}

	public Combinaison removeCombinaisons3(Combinaison combinaisons3) {
		getCombinaisons3().remove(combinaisons3);
		combinaisons3.setD�3(null);

		return combinaisons3;
	}

}
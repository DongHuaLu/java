package domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Node {

	private Set<Node> childs = new HashSet<Node>();
	private int id;
	private String name;

	private Node p;
	
	@OneToMany(mappedBy="p",fetch=FetchType.EAGER)
	public Set<Node> getChilds() {
		return childs;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@ManyToOne
	@JoinColumn(name="pid")
	public Node getP() {
		return p;
	}

	public void setChilds(Set<Node> childs) {
		this.childs = childs;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setP(Node p) {
		this.p = p;
	}

}

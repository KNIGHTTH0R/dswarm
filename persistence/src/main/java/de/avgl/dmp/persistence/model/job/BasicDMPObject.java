package de.avgl.dmp.persistence.model.job;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@MappedSuperclass
public abstract class BasicDMPObject extends DMPObject<String> {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1L;

	@Id
	@XmlID
	//@Access(AccessType.FIELD)
	//@Column(name = "ID")
	private String	id;

	//@Column(name = "NAME")
	private String	name;
	
	public BasicDMPObject(final String idArg) {
		
		id = idArg;
	}

	@Override
	public String getId() {

		return id;
	}

	public String getName() {

		return name;
	}

	public void setName(final String name) {

		this.name = name;
	}
}

package de.avgl.dmp.persistence.service;

import javax.persistence.EntityManager;

import com.google.inject.Provider;

import de.avgl.dmp.persistence.DMPPersistenceException;
import de.avgl.dmp.persistence.model.ExtendedBasicDMPJPAObject;
import de.avgl.dmp.persistence.model.proxy.ProxyExtendedBasicDMPJPAObject;

/**
 * A generic persistence service implementation for {@link ExtendedBasicDMPJPAObject}s, i.e., objects where the identifier will be
 * generated by the database and that can have a name and a description.
 * 
 * @author tgaengler
 * @param <POJOCLASS> the concrete POJO class
 */
public abstract class ExtendedBasicDMPJPAService<PROXYPOJOCLASS extends ProxyExtendedBasicDMPJPAObject<POJOCLASS>, POJOCLASS extends ExtendedBasicDMPJPAObject>
		extends BasicDMPJPAService<PROXYPOJOCLASS, POJOCLASS> {

	/**
	 * Creates a new persistence service for the given concrete POJO class and the entity manager provider.
	 * 
	 * @param clasz a concrete POJO class
	 * @param entityManagerProvider an entity manager provider
	 */
	protected ExtendedBasicDMPJPAService(final Class<POJOCLASS> clasz, final Class<PROXYPOJOCLASS> proxyClasz,
			final Provider<EntityManager> entityManagerProvider) {

		super(clasz, proxyClasz, entityManagerProvider);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void updateObjectInternal(final POJOCLASS object, final POJOCLASS updateObject, final EntityManager entityManager)
			throws DMPPersistenceException {

		final String description = object.getDescription();

		updateObject.setDescription(description);

		super.updateObjectInternal(object, updateObject, entityManager);
	}
}
